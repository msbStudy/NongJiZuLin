<template>
	<div>
		<div class="breadcrumb-preview">
			<el-breadcrumb :separator="'Ξ'">
				<el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
				<el-breadcrumb-item class="item2" v-for="(item, index) in breadcrumbItem" :key="index"><a>{{item.name}}</a></el-breadcrumb-item>
			</el-breadcrumb>
		</div>
		<div v-if="centerType" class="back_box">
			<el-button class="backBtn" size="mini" @click="backClick">
				<span class="icon iconfont icon-jiantou33"></span>
				<span class="text">返回</span>
			</el-button>
		</div>
		<div class="list-preview">
			<el-form :inline="true" :model="formSearch" class="list-form-pv">
				<el-form-item class="list-item">
					<div class="lable">报修编号：</div>
					<el-input v-model="formSearch.baoxiubianhao" placeholder="报修编号" @keydown.enter.native="getList(1, curFenlei)" clearable></el-input>
				</el-form-item>
				<el-form-item class="list-item">
					<div class="lable">农机名称：</div>
					<el-input v-model="formSearch.nongjimingcheng" placeholder="农机名称" @keydown.enter.native="getList(1, curFenlei)" clearable></el-input>
				</el-form-item>
				<el-button class="list-search-btn" v-if=" true " type="primary" @click="getList(1, curFenlei)">
					<i class="el-icon-search"></i>
					查询
				</el-button>
				<el-button class="list-add-btn" v-if="btnAuth('weixiuwancheng','新增')" type="primary" @click="add('/index/weixiuwanchengAdd')">
					<i class="el-icon-circle-plus-outline"></i>
					添加
				</el-button>
			</el-form>
			<div class="select2">
				<div class="select2-list" v-for="(item,index) in selectOptionsList" :key="index">
					<div class="label">{{item.name}}：</div>
					<div class="item-body">
						<div class="item" @click="selectClick2(item,-1)" :class="item.check ==-1 ? 'active' : ''">全部</div>
						<div class="item" @click="selectClick2(item,index1)" :class="item.check == index1 ? 'active' : ''" v-for="item1,index1 in item.list" :key="index1">{{item1}}</div>
					</div>
				</div>
			</div>
			<div class="list">
				<div class="list6">
					<div v-for="(item,index) in dataList" :key="index" :class="'list-item' + ((index%2) + 1)" @click.stop="toDetail(item)">
						<div class="imgbox">
							<img @click.stop="imgPreView(item.tupian)" v-if="item.tupian && item.tupian.substr(0,4)=='http'&&item.tupian.split(',w').length>1" :src="item.tupian" class="image" />
							<img @click.stop="imgPreView(item.tupian.split(',')[0])" v-else-if="item.tupian && item.tupian.substr(0,4)=='http'" :src="item.tupian.split(',')[0]" class="image" />
							<img @click.stop="imgPreView(baseUrl + (item.tupian?item.tupian.split(',')[0]:''))" v-else :src="baseUrl + (item.tupian?item.tupian.split(',')[0]:'')" class="image" />
						</div>
						<div class="infoBox">
							<div class="name">农机编号:{{item.nongjibianhao}}</div>
							<div class="name">{{item.nongjimingcheng}}</div>
							<div class="name">维修时间:{{item.weixiushijian}}</div>
							<div class="centerInfo">
								<div class="publisher_item">
									<span class="icon iconfont" :class="index%2==0?'icon-geren16':'icon-geren16'"></span>
									<span class="label">{{index%2==0?'发布人：':'发布人：'}}</span>
									<span class="text">{{item.yonghuzhanghao}}</span>
								</div>
							</div>
							<div class="bottomInfo">
								<div class="time_item">
									<span class="icon iconfont" :class="index%2==0?'icon-shijian21':'icon-shijian21'"></span>
									<span class="label">{{index%2==0?'发布时间：':'发布时间：'}}</span>
									<span class="text">{{index%2==0? item.addtime : item.addtime }}</span>
								</div>
								<div class="more_btn" @click.stop="toDetail(item)">
									<span class="text">{{index%2==0?'查看更多':'查看更多'}}</span>
									<span class="icon iconfont" :class="index%2==0?'icon-jiantou25':'icon-jiantou25'"></span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

	
			<el-pagination
				background
				id="pagination"
				class="pagination"
				:pager-count="7"
				:page-size="pageSize"
				prev-text="<"
				next-text=">"
				:hide-on-single-page="true"
				:layout='["total","prev","pager","next","sizes","jumper"].join()'
				:total="total"
				:page-sizes="pageSizes"
				@current-change="curChange"
				@size-change="sizeChange"
				@prev-click="prevClick"
				@next-click="nextClick"
				></el-pagination>
		</div>
		<el-dialog title="预览图" :visible.sync="previewVisible" width="50%">
			<img :src="previewImg" alt="" style="width: 100%;">
		</el-dialog>
	</div>
</template>
<script>
	export default {
		//数据集合
		data() {
			return {
				selectIndex2: 0,
				selectOptionsList: [],
				layouts: '',
				swiperIndex: -1,
				baseUrl: '',
				breadcrumbItem: [
					{
						name: '维修完成'
					}
				],
				formSearch: {
					baoxiubianhao: '',
					nongjibianhao: '',
					nongjimingcheng: '',
				},
				fenlei: [],
				dataList: [],
				total: 1,
				pageSize: 4,
				pageSizes: [],
				totalPage: 1,
				curFenlei: '全部',
				isPlain: false,
				indexQueryCondition: '',
				nongjibianhaoOptions: [],
				timeRange: [],
				centerType:false,
				previewImg: '',
				previewVisible: false,
				sortType: 'id',
				sortOrder: 'desc',
			}
		},
		async created() {
			if(this.$route.query.centerType&&this.$route.query.centerType!=0){
				this.centerType = true
			}
			this.baseUrl = this.$config.baseUrl;
			await this.$http.get('option/zulinfuwu/nongjibianhao').then(res => {
				if (res.data.code == 0) {
					this.nongjibianhaoOptions = res.data.data;
					this.selectOptionsList.push({name:'农机编号',list:this.nongjibianhaoOptions,tableName: 'nongjibianhao',check: -1})
				}
			});
			await this.getFenlei();
			let fenlei = '全部'
			if(this.$route.query.homeFenlei){
				fenlei = this.$route.query.homeFenlei
			}
			this.getList(1, fenlei);
		},
		watch:{
			$route(newValue){
				this.getList(1, newValue.query.homeFenlei);
			}
		},
		//方法集合
		methods: {
			selectClick2(row,index) {
				row.check = index
				if(index == -1){
					this.formSearch[row.tableName] = ''
				}else {
					this.formSearch[row.tableName] = row.list[index]
				}
				this.getList()
			},
			add(path) {
				let query = {}
				if(this.centerType){
					query.centerType = 1
				}
				this.$router.push({path: path,query:query});
			},
			async getFenlei() {
			},
			getList(page, fenlei, ref = '') {
				let params = {
					page,
					limit: this.pageSize,
				};
				let searchWhere = {};
				if (this.formSearch.baoxiubianhao != '') searchWhere.baoxiubianhao = '%' + this.formSearch.baoxiubianhao + '%';
				if (this.formSearch.nongjibianhao != '') searchWhere.nongjibianhao = this.formSearch.nongjibianhao;
				if (this.formSearch.nongjimingcheng != '') searchWhere.nongjimingcheng = '%' + this.formSearch.nongjimingcheng + '%';
				let user = JSON.parse(localStorage.getItem('sessionForm'))
				if(localStorage.getItem('frontToken')) {
					if(user.weixiuxingming){
						params['weixiuxingming'] = user.weixiuxingming
					}
				}
				if (this.sortType) searchWhere.sort = this.sortType
				if (this.sortOrder) searchWhere.order = this.sortOrder
				this.$http.get(`weixiuwancheng/${this.centerType?'page':'list'}`, {params: Object.assign(params, searchWhere)}).then(res => {
					if (res.data.code == 0) {
						this.dataList = res.data.data.list;
						this.total = Number(res.data.data.total);
						this.pageSize = Number(res.data.data.pageSize);
						this.totalPage = res.data.data.totalPage;
						if(this.pageSizes.length==0){
							this.pageSizes = [this.pageSize, this.pageSize*2, this.pageSize*3, this.pageSize*5];
						}
					}
				});
			},
			curChange(page) {
				this.getList(page);
			},
			prevClick(page) {
				this.getList(page);
			},
			sizeChange(size){
				this.pageSize = size
				this.getList(1);
			},
			nextClick(page) {
				this.getList(page);
			},
			imgPreView(url){
				this.previewImg = url
				this.previewVisible = true
			},
			toDetail(item) {
				let params = {
					id: item.id
				}
				if(this.centerType){
					params.centerType = 1
				}
				this.$router.push({path: '/index/weixiuwanchengDetail', query: params});
			},
			btnAuth(tableName,key){
				if(this.centerType){
					return this.isBackAuth(tableName,key)
				}else{
					return this.isAuth(tableName,key)
				}
			},
			backClick() {
				this.$router.push({path: '/index/center'});
			},
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.list-preview {
		padding: 0 calc(50% - 600px);
		margin: 10px auto;
		background: none;
		width: 100%;
		position: relative;
		.list-form-pv {
			padding: 10px 0;
			margin: 20px 0 0;
			background: none;
			display: flex;
			gap: 10px 0;
			width: 100%;
			align-items: center;
			flex-wrap: wrap;
			height: auto;
			.list-item {
				margin: 0 10px;
				/deep/.el-form-item__content {
					display: flex;
				}
				.lable {
					padding: 0 10px;
					flex: none;
					display: inline-block;
					width: auto;
					line-height: 42px;
				}
				.el-input {
					width: 100%;
				}
				.datetimerange {
					border: 1px solid rgb(14, 102, 125);
					border-radius: 8px;
					padding: 3px 10px;
					outline: none;
					background: #fff;
					width: auto;
					justify-content: center;
				}
				.el-input /deep/ .el-input__inner {
					border: 1px solid rgb(14, 102, 125);
					border-radius: 8px;
					padding: 0 10px;
					margin: 0;
					outline: none;
					color: #333;
					width: 140px;
					font-size: 14px;
					line-height: 42px;
					height: 42px;
				}
				.el-select {
					width: 100%;
				}
				.el-select /deep/ .el-input__inner {
				}
				.el-date-editor {
					width: 100%;
				}
				.el-date-editor /deep/ .el-input__inner {
					border: 1px solid rgb(14, 102, 125);
					border-radius: 8px;
					padding: 0 30px;
					margin: 0;
					outline: none;
					color: #333;
					width: 140px;
					font-size: 14px;
					line-height: 42px;
					height: 42px;
				}
			}
			.list-search-btn {
				cursor: pointer;
				border: 0;
				border-radius: 4px;
				padding: 0px 15px;
				margin: 0 10px 0 0;
				outline: none;
				color: #fff;
				background: #0E667D;
				width: auto;
				font-size: 14px;
				line-height: 42px;
				height: 42px;
				i {
					margin: 0 10px 0 0;
					color: #fff;
					font-size: 14px;
				}
			}
			.list-add-btn {
				cursor: pointer;
				border: 0;
				border-radius: 4px;
				padding: 0px 15px;
				margin: 0 10px 0 0;
				outline: none;
				color: #fff;
				background: #499CB2;
				width: auto;
				font-size: 14px;
				line-height: 42px;
				height: 42px;
				i {
					margin: 0 10px 0 0;
					color: #fff;
					font-size: 14px;
				}
			}
		}
		.select2 {
			padding: 10px;
			background: #E2EFF5;
			width: 100%;
			height: auto;
			.select2-list {
				border-radius: 20px;
				padding: 6px 0;
				margin: 10px 0;
				background: #D5D5D5;
				display: flex;
				width: 100%;
				position: relative;
				height: auto;
				.label {
					padding: 0 5px;
					color: #000000;
					flex: none;
					display: inline;
					font-size: 14px;
					line-height: 32px;
					position: relative;
				}
				.item-body {
					display: flex;
					gap: 10px;
					width: 100%;
					flex-wrap: wrap;
					height: auto;
					.item {
						cursor: pointer;
						border-radius: 4px;
						padding: 0 5px;
						color: #000000;
						background: none;
						font-size: 14px;
						line-height: 32px;
					}
					.item:hover {
						color: #fff;
						background: #0E667D;
					}
					.item.active {
						color: #fff;
						background: #0E667D;
					}
				}
			}
		}
		.list {
			margin: 0 0 10px;
			background: none;
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
				
			.index-pv1 .animation-box:hover {
				transform: rotate(0) scale(1.2) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
				
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0) scale(0.8) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list6 {
				margin: 30px auto;
				overflow: hidden;
				width: 100%;
				clear: both;
				.list-item1 {
					padding: 20px 85px 20px 20px;
					margin: 0 0 20px 0 ;
					background: url(http://codegen.caihongy.cn/20250203/47a281e55784408293da79dcdcb20e36.png) no-repeat center / 100% 100%;
					display: flex;
					width: 100%;
					align-items: center;
					height: auto;
					.imgbox {
						overflow: hidden;
						flex: none;
						width: 30%;
						float: left;
						height: 220px;
						.image {
							object-fit: cover;
							width: 100%;
							transition: all 0.6s;
							height: 100%;
						}
					}
					.infoBox {
						padding: 0 20px;
						flex: auto;
						width: 0;
						position: relative;
						float: right;
						height: 100%;
						.name {
							border: none;
							padding: 0;
							margin: 0 0 10px 0;
							overflow: hidden;
							color: #333;
							background: none;
							font-weight: normal;
							width: 100%;
							font-size: 16px;
							line-height: 24px;
						}
						.price {
							margin: 0 0 10px 0;
							color: #f00;
							font-size: 16px;
							line-height: 24px;
							.price_text {
								font-size: 22px;
							}
						}
						.centerInfo {
							padding: 0;
							margin: 0;
							display: flex;
							gap: 10px;
							width: 100%;
							flex-wrap: wrap;
							.publisher_item {
								padding: 0;
								.icon {
									margin: 0 2px 0 0;
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0;
								.icon {
									margin: 0 2px 0 0;
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0;
								.icon {
									margin: 0 2px 0 0;
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0;
								.icon {
									margin: 0 2px 0 0;
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
							}
						}
						.bottomInfo {
							margin: 0;
							display: flex;
							justify-content: space-between;
							align-items: center;
							flex-wrap: wrap;
							.time_item {
								padding: 0;
								.icon {
									margin: 0 2px 0 0;
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.more_btn {
								border: 1px solid #eee;
								border-radius: 20px;
								padding: 10px;
								display: block;
								width: 150px;
								text-align: center;
								.text {
									color: inherit;
								}
								.icon {
									color: inherit;
								}
							}
						}
					}
				}
				.list-item1:hover {
					cursor: pointer;
					background: #0E667D;
					.imgbox {
						.image {
							transform: scale(1.05);
						}
					}
					.infoBox {
						.name {
							border: none;
							color: #fff;
							background: none;
						}
						.price {
							color: #fff;
							.price_text {
								font-size: 24px;
							}
						}
						.centerInfo {
							.publisher_item {
								.icon {
									color: #fff;
								}
								.label {
									color: #fff;
								}
								.text {
									color: #fff;
								}
							}
							.like_item {
								.icon {
									color: #fff;
								}
								.label {
									color: #fff;
								}
								.text {
									color: #fff;
								}
							}
							.collect_item {
								.icon {
									color: #fff;
								}
								.label {
									color: #fff;
								}
								.text {
									color: #fff;
								}
							}
							.view_item {
								.icon {
									color: #fff;
								}
								.label {
									color: #fff;
								}
								.text {
									color: #fff;
								}
							}
						}
						.bottomInfo {
							.time_item {
								.icon {
									color: #fff;
								}
								.label {
									color: #fff;
								}
								.text {
									color: #fff;
								}
							}
							.more_btn {
								background: #ffffff30;
								.text {
									color: #fff;
								}
								.icon {
									color: #fff;
								}
							}
						}
					}
				}
				.list-item2 {
					padding: 20px  20px 20px 85px;
					margin: 0 0 20px 0 ;
					background: url(http://codegen.caihongy.cn/20250203/39ff9c492c0b4aa7a79e8ffeb4e8802f.png) no-repeat center / 100% 100%;
					display: flex;
					width: 100%;
					align-items: center;
					height: auto;
					.imgbox {
						overflow: hidden;
						width: 30%;
						height: 220px;
						order: 2;
						.image {
							object-fit: cover;
							width: 100%;
							transition: all 0.6s;
							height: 100%;
						}
					}
					.infoBox {
						padding: 0 20px;
						flex: auto;
						width: 0;
						position: relative;
						float: left;
						height: auto;
						.name {
							border: none;
							padding: 0;
							margin: 0 0 10px 0;
							color: #333;
							background: none;
							font-weight: normal;
							width: 100%;
							font-size: 16px;
							line-height: 24px;
						}
						.price {
							margin: 0 0 10px 0;
							color: #f00;
							font-size: 16px;
							.price_text {
								font-size: 22px;
							}
						}
						.centerInfo {
							padding: 0;
							margin: 0;
							display: flex;
							gap: 10px;
							width: 100%;
							flex-wrap: wrap;
							.publisher_item {
								padding: 0;
								.icon {
									margin: 0 2px 0 0;
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0;
								.icon {
									margin: 0 2px 0 0;
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0;
								.icon {
									margin: 0 2px 0 0;
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0;
								.icon {
									margin: 0 2px 0 0;
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
							}
						}
						.bottomInfo {
							margin: 0;
							display: flex;
							justify-content: space-between;
							align-items: center;
							flex-wrap: wrap;
							.time_item {
								padding: 0;
								.icon {
									margin: 0 2px 0 0;
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.more_btn {
								border: 1px solid #eee;
								border-radius: 20px;
								padding: 10px;
								display: block;
								width: 150px;
								text-align: center;
								.text {
									color: inherit;
								}
								.icon {
									color: inherit;
								}
							}
						}
					}
				}
				.list-item2:hover {
					cursor: pointer;
					background: #0E667D;
					.imgbox {
						.image {
							transform: scale(1.05);
						}
					}
					.infoBox {
						.name {
							border: none;
							color: #fff;
							background: none;
						}
						.price {
							color: #fff;
							.price_text {
								font-size: 24px;
							}
						}
						.centerInfo {
							.publisher_item {
								.icon {
									color: #fff;
								}
								.label {
									color: #fff;
								}
								.text {
									color: #fff;
								}
							}
							.like_item {
								.icon {
									color: #fff;
								}
								.label {
									color: #fff;
								}
								.text {
									color: #fff;
								}
							}
							.collect_item {
								.icon {
									color: #fff;
								}
								.label {
									color: #fff;
								}
								.text {
									color: #fff;
								}
							}
							.view_item {
								.icon {
									color: #fff;
								}
								.label {
									color: #fff;
								}
								.text {
									color: #fff;
								}
							}
						}
						.bottomInfo {
							.time_item {
								.icon {
									color: #fff;
								}
								.label {
									color: #fff;
								}
								.text {
									color: #fff;
								}
							}
							.more_btn {
								background: #ffffff30;
								.text {
									color: #fff;
								}
								.icon {
									color: #fff;
								}
							}
						}
					}
				}
			}
		}
	}
</style>
