<template>
	<div>
		<div class="breadcrumb-preview">
			<el-breadcrumb :separator="'Ξ'">
				<el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
				<el-breadcrumb-item class="item2" v-for="(item, index) in breadcrumbItem" :key="index"><a>{{item.name}}</a></el-breadcrumb-item>
			</el-breadcrumb>
		</div>
	
		<div class="news-preview-pv">
			<el-form :inline="true" :model="formSearch" class="list-form-pv">
				<el-form-item class="search-item">
					<el-input v-model="title" placeholder="标题"></el-input>
				</el-form-item>
				<el-button class="search-btn" type="primary" @click="getNewsList(1)">
					<span class="icon iconfont icon-chakan14"></span>
					搜索
				</el-button>
			</el-form>
			
			<!-- category -->
			<div class="category-list">
				<div class="item" @click="categoryClick(0)" :class="categoryIndex == 0 ? 'active' : ''">全部</div>
				<div v-for="(item,index) in categoryList" @click="categoryClick(index+1)" :key="index" class="item" :class="categoryIndex == index+1 ? 'active' : ''">{{item.typename}}</div>
			</div>
			<!-- 样式五 -->
			<div class="list5 index-pv1">
				<div v-for="item in newsList" :key="item.id" @click="toNewsDetail(item)" class="list-item animation-box">
					<img :src="baseUrl + item.picture" >
					<div class="infoBox">
						<div class="name">{{item.title}}</div>
						<div class="desc">{{item.introduction}}</div>
						<div class="time_item">
							<span class="icon iconfont icon-shijian21"></span>
							<span class="label">发布时间：</span>
							<span class="text">{{item.addtime}}</span>
						</div>
						<div class="publisher_item">
							<span class="icon iconfont icon-geren16"></span>
							<span class="label">发布人：</span>
							<span class="text">{{item.name}}</span>
						</div>
						<div class="like_item">
							<span class="icon iconfont icon-zan10"></span>
							<span class="label">点赞数：</span>
							<span class="text">{{item.thumbsupnum}}</span>
						</div>
						<div class="collect_item">
							<span class="icon iconfont icon-shoucang10"></span>
							<span class="label">收藏量：</span>
							<span class="text">{{item.storeupnum}}</span>
						</div>
						<div class="view_item">
							<span class="icon iconfont icon-chakan9"></span>
							<span class="label">点击量：</span>
							<span class="text">{{item.clicknum}}</span>
						</div>
						<div class="tags">新闻动态</div>
					</div>
				</div>
			</div>
		
			<el-pagination
				background
				id="pagination" class="pagination"
				:pager-count="7"
				:page-size="pageSize"
				:page-sizes="pageSizes"
				prev-text="<"
				next-text=">"
				:hide-on-single-page="true"
				:layout='["total","prev","pager","next","sizes","jumper"].join()'
				:total="total"
				@current-change="curChange"
				@prev-click="prevClick"
				@next-click="nextClick"
				></el-pagination>

			<!-- 热门信息 -->
			<div class="hot">
				<div class="hot-title">热门信息</div>
				<div class="hot-list">
					<div class="hot-item" v-for="item in hotList" :key="item.id" @click="toNewsDetail(item)">
						<img :src="baseUrl + item.picture" alt="">
						<div class="hot-name">{{ item.title }}</div>
						<div class="hot-time">{{item.addtime}}</div>
					</div>
				</div>
			</div>
			<!-- 最新动态 -->
			<div class="news">
				<div class="news-title">最新动态</div>
				<div class="news-list">
					<div class="news-item" v-for="item in recommendList" :key="item.id" @click="toNewsDetail(item)">
						<img :src="baseUrl + item.picture" alt="">
						<div class="news-name">{{ item.title }}</div>
						<div class="news-time">{{item.addtime}}</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	export default {
		//数据集合
		data() {
			return {
				baseUrl: this.$config.baseUrl,
				breadcrumbItem: [
				  {
					name: '公告信息'
				  }
				],
				newsList: [],
				total: 1,
				pageSize: 10,
				pageSizes: [],
				totalPage: 1,
				layouts: '',
				title: '',
				categoryIndex: 0,
				categoryList: [],
				hotList: [],
				recommendList: [],
			}
		},
		created() {
			this.getCategoryList()
			
			this.getHotList()
			this.getRecommendList()
		},
		watch:{
			$route(newValue){
				this.getCategoryList()
			}
		},
		//方法集合
		methods: {
			getCategoryList(){
				this.$http.get('newstype/list', {}).then(res => {
					if (res.data.code == 0) {
						this.categoryList = res.data.data.list;
						if(this.$route.query.homeFenlei){
							for(let i=0;i<this.categoryList.length;i++) {
								if(this.$route.query.homeFenlei == this.categoryList[i].typename) {
									this.categoryIndex = i + 1;
									const currentRoute = this.$route;
									const routeWithoutQuery = { ...currentRoute };
									delete routeWithoutQuery.query;
									this.$router.replace(routeWithoutQuery)
									break;
								}
							}
						}
						this.getNewsList(1);
					}
				});
			},
			categoryClick(index) {
				this.categoryIndex = index
				this.getNewsList()
			},
			getNewsList(page) {
				let params = {page, limit: this.pageSize,sort:'addtime',order:'desc'};
				let searchWhere = {};
				if(this.title != '') searchWhere.title = '%' + this.title + '%';
				if(this.categoryIndex!=0){
					searchWhere.typename = this.categoryList[this.categoryIndex - 1].typename
				}
				this.$http.get('news/list', {params: Object.assign(params, searchWhere)}).then(res => {
					if (res.data.code == 0) {
						this.newsList = res.data.data.list;
						this.total = res.data.data.total;
						this.pageSize = Number(res.data.data.pageSize);
						this.totalPage = res.data.data.totalPage;
						if(this.pageSizes.length==0){
							this.pageSizes = [this.pageSize, this.pageSize*2, this.pageSize*3, this.pageSize*5];
						}
					}
				});
			},
			getHotList(){
				let params = {page:1, limit: 4,sort:'addtime',order:'desc'};
				this.$http.get('news/autoSort', {params: params}).then(res => {
					if (res.data.code == 0) {
						this.hotList = res.data.data.list;
					}
				});
			},
			getRecommendList(){
				let url = 'news/autoSort'
				if(localStorage.getItem('frontToken')){
					url = 'news/autoSort2'
				}
				let params = {page:1, limit: 4,sort:'addtime',order:'desc'};
				this.$http.get(url, {params: params}).then(res => {
					if (res.data.code == 0) {
						this.recommendList = res.data.data.list;
					}
				});
			},
			curChange(page) {
				this.getNewsList(page);
			},
			prevClick(page) {
				this.getNewsList(page);
			},
			nextClick(page) {
				this.getNewsList(page);
			},
			toNewsDetail(item) {
				this.$router.push({path: '/index/newsDetail', query: {id: item.id}});
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.news-preview-pv {
				margin: 10px auto;
				background: none;
				width: 1200px;
				position: relative;
				.list-form-pv {
						padding: 10px;
						background: none;
						display: flex;
						width: 100%;
						justify-content: center;
						align-items: center;
						flex-wrap: wrap;
						height: auto;
						.search-item {
								margin: 0 10px;
								.el-input {
										width: 100%;
									}
				.el-input /deep/ .el-input__inner {
										border: 0;
										border-radius: 8px;
										padding: 0 10px;
										margin: 0;
										outline: none;
										color: #333;
										width: 200px;
										font-size: 14px;
										line-height: 42px;
										height: 42px;
									}
			}
			.search-btn {
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
								.icon {
										margin: 0 10px 0 0;
										color: #fff;
										font-size: 14px;
									}
			}
		}
		.category-list {
						border-radius: 0px 0px 20px 20px;
						padding: 10px 20px;
						background: #0E667D;
						display: flex;
						width: 100%;
						height: auto;
						.item {
								cursor: pointer;
								border-radius: 4px;
								margin: 0 10px 0 0;
								color: #FFFFFF;
								background: none;
								width: 72px;
								font-size: 14px;
								line-height: 36px;
								text-align: center;
							}
			
			.item:hover {
								cursor: pointer;
								border-radius: 4px;
								margin: 0 10px 0 0;
								color: #0E667D;
								background: #fff;
								width: 72px;
								font-size: 14px;
								line-height: 36px;
								text-align: center;
							}
			
			.item.active {
								cursor: pointer;
								border-radius: 4px;
								margin: 0 10px 0 0;
								color: #0E667D;
								background: #fff;
								width: 72px;
								font-size: 14px;
								line-height: 36px;
								text-align: center;
							}
		}
		.list5 {
						padding: 0;
						margin: 20px 0 0;
						background: none;
						display: flex;
						width: 100%;
						flex-wrap: wrap;
						height: auto;
						.list-item {
								margin: 10px;
								background: #f5f5f5;
								display: flex;
								width: 570px;
								height: auto;
								img {
										color: 240px;
										object-fit: cover;
										display: inline-block;
										width: 170px;
									}
				.infoBox {
										padding: 10px;
										display: inline-block;
										width: 400px;
										height: auto;
										.name {
												color: #000;
												font-weight: 600;
												font-size: 14px;
												line-height: 32px;
											}
					.desc {
												max-height: 100px;
												overflow: hidden;
												color: #666;
												font-size: 14px;
												line-height: 20px;
											}
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
					.tags {
												cursor: pointer;
												padding: 0 10px;
												color: #fff;
												background: #0E667D;
												display: inline-block;
												font-size: 14px;
												line-height: 32px;
											}
				}
			}
		}
		.hot {
						margin: 30px 0 0;
						width: 100%;
						height: auto;
						.hot-title {
								padding: 0 0 0 50px;
								margin: 0;
								background: url(http://codegen.caihongy.cn/20250120/bd3f11cd39054b2c9983b54078a7d4c6.png) no-repeat left center;
								font-weight: 600;
								width: auto;
								font-size: 22px;
								line-height: 44px;
								text-align: left;
							}
			.hot-list {
								padding: 0;
								margin: 20px 0 0;
								background: none;
								display: flex;
								gap: 30px;
								width: 100%;
								height: auto;
								.hot-item {
										cursor: pointer;
										padding: 40px 25px 25px 25px;
										background: url(http://codegen.caihongy.cn/20250204/7d436c26ddd5478fa20ac208206b2268.png) no-repeat center / 100% 100%;
										width: 25%;
										height: auto;
										img {
												border-radius: 10px;
												object-fit: cover;
												display: block;
												width: 100%;
												height: 220px;
											}
					.hot-name {
												padding: 0;
												color: #000000;
												font-size: 16px;
												line-height: 24px;
												text-align: center;
											}
					.hot-time {
												padding: 0 5px;
												color: #A7A7A7;
												font-size: 14px;
												line-height: 24px;
												text-align: center;
											}
				}
			}
		}
		.news {
						margin: 30px 0 0;
						width: 100%;
						height: auto;
						.news-title {
								padding: 0 0 0 50px;
								margin: 0;
								background: url(http://codegen.caihongy.cn/20250120/bd3f11cd39054b2c9983b54078a7d4c6.png) no-repeat left center;
								font-weight: 600;
								width: auto;
								font-size: 22px;
								line-height: 44px;
								text-align: left;
							}
			.news-list {
								padding: 0;
								margin: 20px 0 0;
								background: none;
								display: flex;
								gap: 30px;
								width: 100%;
								height: auto;
								.news-item {
										cursor: pointer;
										padding: 40px 25px 25px 25px;
										background: url(http://codegen.caihongy.cn/20250204/7d436c26ddd5478fa20ac208206b2268.png) no-repeat center / 100% 100%;
										width: 25%;
										height: auto;
										img {
												border-radius: 10px;
												object-fit: cover;
												display: block;
												width: 100%;
												height: 220px;
											}
					.news-name {
												padding: 0;
												color: #000000;
												font-size: 16px;
												line-height: 24px;
												text-align: center;
											}
					.news-time {
												padding: 0 5px;
												color: #A7A7A7;
												font-size: 14px;
												line-height: 24px;
												text-align: center;
											}
				}
			}
		}
	}
	
	.index-pv1 .animation-box {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
		z-index: initial;
	}
	
	.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1.2) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
	}
	
	.index-pv1 .animation-box img {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
	}
	
	.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(0.8) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
</style>
