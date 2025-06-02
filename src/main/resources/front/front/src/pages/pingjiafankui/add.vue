<template>
	<div class="add-update-preview">
		<el-form
			class="add-update-form"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="120px"
			>
			<el-form-item class="add-item" label="租赁编号" prop="zulinbianhao">
				<el-input v-model="ruleForm.zulinbianhao" 
					placeholder="租赁编号" clearable :disabled=" false  ||ro.zulinbianhao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="农机编号" prop="nongjibianhao">
				<el-input v-model="ruleForm.nongjibianhao" 
					placeholder="农机编号" clearable :disabled=" false  ||ro.nongjibianhao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="农机名称" prop="nongjimingcheng">
				<el-input v-model="ruleForm.nongjimingcheng" 
					placeholder="农机名称" clearable :disabled=" false  ||ro.nongjimingcheng"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="图片" v-if="type!='cross' || (type=='cross' && !ro.tupian)" prop="tupian">
				<file-upload
					tip="点击上传图片"
					action="file/upload"
					:limit="3"
					:multiple="true"
					:fileUrls="ruleForm.tupian?ruleForm.tupian:''"
					@change="tupianUploadChange"
					></file-upload>
			</el-form-item>
			<el-form-item class="add-item" v-else label="图片" prop="tupian">
				<img v-if="ruleForm.tupian.substring(0,4)=='http'" class="upload-img" v-bind:key="index" :src="ruleForm.tupian.split(',')[0]">
				<img v-else class="upload-img" v-bind:key="index" v-for="(item,index) in ruleForm.tupian.split(',')" :src="baseUrl+item">
			</el-form-item>
			<el-form-item class="add-item" label="型号" prop="xinghao">
				<el-input v-model="ruleForm.xinghao" 
					placeholder="型号" clearable :disabled=" false  ||ro.xinghao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="租赁时间" prop="zulinshijian">
				<el-input v-model="ruleForm.zulinshijian" 
					placeholder="租赁时间" clearable :disabled=" false  ||ro.zulinshijian"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="归还时间" prop="guihaishijian">
				<el-input v-model="ruleForm.guihaishijian" 
					placeholder="归还时间" clearable :disabled=" false  ||ro.guihaishijian"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="用户姓名" prop="yonghuxingming">
				<el-input v-model="ruleForm.yonghuxingming" 
					placeholder="用户姓名" clearable :disabled=" false  ||ro.yonghuxingming"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="用户账号" prop="yonghuzhanghao">
				<el-input v-model="ruleForm.yonghuzhanghao" 
					placeholder="用户账号" clearable :disabled=" false  ||ro.yonghuzhanghao"></el-input>
			</el-form-item>
			<el-form-item class="add-item"  label="服务评分" prop="fuwupingfen">
				<el-select v-model="ruleForm.fuwupingfen" placeholder="请选择服务评分" :disabled=" false  ||ro.fuwupingfen" >
					<el-option
						v-for="(item,index) in fuwupingfenOptions"
						:key="index"
						:label="item"
						:value="item">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item class="add-item" label="评价时间" prop="pingjiashijian">
				<el-date-picker
					:disabled=" false  ||ro.pingjiashijian"
					value-format="yyyy-MM-dd HH:mm:ss"
					v-model="ruleForm.pingjiashijian" 
					type="datetime"
					placeholder="评价时间">
				</el-date-picker>
			</el-form-item>
			<el-form-item class="add-item" label="评价反馈" prop="pingjiafankui">
				<el-input
					type="textarea"
					:rows="8"
					placeholder="评价反馈"
					v-model="ruleForm.pingjiafankui">
					</el-input>
			</el-form-item>

			<el-form-item class="add-btn-item">
				<el-button class="submitBtn"  type="primary" @click="onSubmit">
					<span class="icon iconfont icon-kaitongfuwu"></span>
					<span class="text">提交</span>
				</el-button>
				<el-button class="closeBtn" @click="back()">
					<span class="icon iconfont icon-shanchu1"></span>
					<span class="text">取消</span>
				</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				id: '',
				baseUrl: '',
				ro:{
					zulinbianhao : false,
					nongjibianhao : false,
					nongjimingcheng : false,
					tupian : false,
					xinghao : false,
					zulinshijian : false,
					guihaishijian : false,
					yonghuxingming : false,
					yonghuzhanghao : false,
					fuwupingfen : false,
					pingjiafankui : false,
					pingjiashijian : false,
					crossuserid : false,
					crossrefid : false,
				},
				type: '',
				userTableName: localStorage.getItem('UserTableName'),
				ruleForm: {
					zulinbianhao: '',
					nongjibianhao: '',
					nongjimingcheng: '',
					tupian: '',
					xinghao: '',
					zulinshijian: '',
					guihaishijian: '',
					yonghuxingming: '',
					yonghuzhanghao: '',
					fuwupingfen: '',
					pingjiafankui: '',
					pingjiashijian: '',
					crossuserid: '',
					crossrefid: '',
				},
				fuwupingfenOptions: [],


				rules: {
					zulinbianhao: [
					],
					nongjibianhao: [
					],
					nongjimingcheng: [
					],
					tupian: [
					],
					xinghao: [
					],
					zulinshijian: [
					],
					guihaishijian: [
					],
					yonghuxingming: [
					],
					yonghuzhanghao: [
					],
					fuwupingfen: [
						{ required: true, message: '服务评分不能为空', trigger: 'blur' },
						{ validator: this.$validate.isIntNumer, trigger: 'blur' },
					],
					pingjiafankui: [
						{ required: true, message: '评价反馈不能为空', trigger: 'blur' },
					],
					pingjiashijian: [
					],
					crossuserid: [
					],
					crossrefid: [
					],
				},
				centerType: false,
			};
		},
		computed: {



		},
		components: {
		},
		created() {
			if(this.$route.query.centerType){
				this.centerType = true
			}
			//this.bg();
			let type = this.$route.query.type ? this.$route.query.type : '';
			this.init(type);
			this.baseUrl = this.$config.baseUrl;
			this.ruleForm.pingjiashijian = this.getCurDateTime()
		},
		methods: {
			getMakeZero(s) {
				return s < 10 ? '0' + s : s;
			},
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(type) {
				this.type = type;
				if(type=='cross'){
					var obj = JSON.parse(localStorage.getItem('crossObj'));
					for (var o in obj){
						if(o=='zulinbianhao'){
							this.ruleForm.zulinbianhao = obj[o];
							this.ro.zulinbianhao = true;
							continue;
						}
						if(o=='nongjibianhao'){
							this.ruleForm.nongjibianhao = obj[o];
							this.ro.nongjibianhao = true;
							continue;
						}
						if(o=='nongjimingcheng'){
							this.ruleForm.nongjimingcheng = obj[o];
							this.ro.nongjimingcheng = true;
							continue;
						}
						if(o=='tupian'){
							this.ruleForm.tupian = obj[o].split(",")[0];
							this.ro.tupian = true;
							continue;
						}
						if(o=='xinghao'){
							this.ruleForm.xinghao = obj[o];
							this.ro.xinghao = true;
							continue;
						}
						if(o=='zulinshijian'){
							this.ruleForm.zulinshijian = obj[o];
							this.ro.zulinshijian = true;
							continue;
						}
						if(o=='guihaishijian'){
							this.ruleForm.guihaishijian = obj[o];
							this.ro.guihaishijian = true;
							continue;
						}
						if(o=='yonghuxingming'){
							this.ruleForm.yonghuxingming = obj[o];
							this.ro.yonghuxingming = true;
							continue;
						}
						if(o=='yonghuzhanghao'){
							this.ruleForm.yonghuzhanghao = obj[o];
							this.ro.yonghuzhanghao = true;
							continue;
						}
						if(o=='fuwupingfen'){
							this.ruleForm.fuwupingfen = obj[o];
							this.ro.fuwupingfen = true;
							continue;
						}
						if(o=='pingjiafankui'){
							this.ruleForm.pingjiafankui = obj[o];
							this.ro.pingjiafankui = true;
							continue;
						}
						if(o=='pingjiashijian'){
							this.ruleForm.pingjiashijian = obj[o];
							this.ro.pingjiashijian = true;
							continue;
						}
						if(o=='crossuserid'){
							this.ruleForm.crossuserid = obj[o];
							this.ro.crossuserid = true;
							continue;
						}
						if(o=='crossrefid'){
							this.ruleForm.crossrefid = obj[o];
							this.ro.crossrefid = true;
							continue;
						}
					}
				}else if(type=='edit'){
					this.info()
				}
				// 获取用户信息
				this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						var json = res.data.data;
						if((json.yonghuxingming!=''&&json.yonghuxingming) || json.yonghuxingming==0){
							this.ruleForm.yonghuxingming = json.yonghuxingming;
							this.ro.yonghuxingming = true;
						}
						if((json.yonghuzhanghao!=''&&json.yonghuzhanghao) || json.yonghuzhanghao==0){
							this.ruleForm.yonghuzhanghao = json.yonghuzhanghao;
							this.ro.yonghuzhanghao = true;
						}
					}
				});
				this.fuwupingfenOptions = "1,2,3,4,5".split(',')

				if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
					localStorage.removeItem('raffleType')
					setTimeout(() => {
						this.onSubmit()
					}, 300)
				}
			},

			// 多级联动参数
			// 多级联动参数
			info() {
				this.$http.get(`pingjiafankui/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.ruleForm = res.data.data;
					}
				});
			},
			// 提交
			async onSubmit() {
				//更新跨表属性
				var crossuserid;
				var crossrefid;
				var crossoptnum;
				var finishNum = 0;
				await this.$refs["ruleForm"].validate(async valid => {
					if(valid) {
						if(this.type=='cross'){
							var statusColumnName = localStorage.getItem('statusColumnName');
							var statusColumnValue = localStorage.getItem('statusColumnValue');
							if(statusColumnName && statusColumnName!='') {
								var obj = JSON.parse(localStorage.getItem('crossObj'));
								if(!statusColumnName.startsWith("[")) {
									for (var o in obj){
										if(o==statusColumnName){
											obj[o] = statusColumnValue;
										}
									}
									var table = localStorage.getItem('crossTable');
									await this.$http.post(table+'/update', obj).then(res => {});
								}
								else {
									crossuserid=Number(localStorage.getItem('frontUserid'));
									crossrefid=obj['id'];
									crossoptnum=localStorage.getItem('statusColumnName');
									crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
								}
							}
							if(crossrefid && crossuserid) {
								this.ruleForm.crossuserid=crossuserid;
								this.ruleForm.crossrefid=crossrefid;
								var params = {
									page: 1,
									limit: 10,
									crossuserid:crossuserid,
									crossrefid:crossrefid,
								}
								await this.$http.get('pingjiafankui/list', {
									params: params
								}).then(res => {
									finishNum = res.data.data.total
								});
							}
							if(finishNum>=crossoptnum) {
								this.$message({
									message: localStorage.getItem('tips'),
									type: 'error',
									duration: 1500,
								});
								return false;
							}
						}


						await this.$http.post(`pingjiafankui/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(async res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
										
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
							}
						});
					}
				});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.$router.go(-1);
			},
			tupianUploadChange(fileUrls) {
				this.ruleForm.tupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
			},
		}
	};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.add-update-preview {
		padding: 20px;
		margin: 10px auto;
		background: none;
		width: 1200px;
		position: relative;
		.add-update-form {
			width: 100%;
			position: relative;
			.add-item.el-form-item {
				padding: 10px;
				margin: 0 0 10px;
				background: #efefef;
				/deep/ .el-form-item__label {
					padding: 0 10px 0 0;
					color: #666;
					font-weight: 500;
					width: 120px;
					font-size: 14px;
					line-height: 40px;
					text-align: right;
				}
				/deep/ .el-form-item__content {
					margin-left: 120px;
				}
				.el-input {
					width: 100%;
				}
				.el-input /deep/ .el-input__inner {
					border: 0;
					border-radius: 4px;
					padding: 0 12px;
					box-shadow: 0 0 6px rgba(64, 158, 255, .5);
					outline: none;
					color: #000;
					width: 400px;
					font-size: 14px;
					height: 40px;
				}
				.el-input /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 4px;
					padding: 0 12px;
					box-shadow: 0 0 6px rgba(85, 85, 127, 0.5);
					outline: none;
					color: rgba(85, 85, 127, 1.0);
					width: 400px;
					font-size: 14px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input__inner {
					text-align: left;
					border: 0;
					border-radius: 4px;
					padding: 0 12px;
					box-shadow: 0 0 6px rgba(64, 158, 255, .5);
					outline: none;
					color: #000;
					width: 400px;
					font-size: 14px;
					height: 40px;
				}
				.el-input-number /deep/ .is-disabled .el-input__inner {
					text-align: left;
					border: 0;
					cursor: not-allowed;
					border-radius: 4px;
					padding: 0 12px;
					box-shadow: 0 0 6px rgba(85, 85, 127, 0.5);
					outline: none;
					color: rgba(85, 85, 127, 1.0);
					width: 400px;
					font-size: 14px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input-number__decrease {
					display: none;
				}
				.el-input-number /deep/ .el-input-number__increase {
					display: none;
				}
				.el-select {
					width: 100%;
				}
				.el-select /deep/ .el-input__inner {
					border: 0;
					border-radius: 4px;
					padding: 0 10px;
					box-shadow: 0 0 6px rgba(64, 158, 255, .5);
					outline: none;
					color: #000;
					width: 200px;
					font-size: 14px;
					height: 40px;
				}
				.el-select /deep/ .is-disabled .el-input__inner {
					border: 0;
					cursor: not-allowed;
					border-radius: 4px;
					padding: 0 10px;
					box-shadow: 0 0 6px rgba(85, 85, 127, 0.5);
					outline: none;
					color: rgba(85, 85, 127, 1.0);
					background: #eee;
					width: 200px;
					font-size: 14px;
					height: 40px;
				}
				.el-date-editor {
					width: 100%;
				}
				.el-date-editor /deep/ .el-input__inner {
					border: 0;
					border-radius: 4px;
					padding: 0 10px 0 30px;
					box-shadow: 0 0 6px rgba(64, 158, 255, .5);
					outline: none;
					color: #000;
					width: 200px;
					font-size: 14px;
					height: 40px;
				}
				.el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 4px;
					padding: 0 10px 0 30px;
					box-shadow: 0 0 6px rgba(85, 85, 127, 0.5);
					outline: none;
					color: rgba(85, 85, 127, 1.0);
					background: #eee;
					width: 200px;
					font-size: 14px;
					height: 40px;
				}
				/deep/ .el-upload--picture-card {
					background: transparent;
					border: 0;
					border-radius: 0;
					width: auto;
					height: auto;
					line-height: initial;
					vertical-align: middle;
				}
				/deep/ .upload .upload-img {
					border: 1px dashed rgba(64, 158, 255, 1);
					cursor: pointer;
					border-radius: 6px;
					color: rgba(64, 158, 255, 1);
					width: 200px;
					font-size: 32px;
					line-height: 200px;
					text-align: center;
					height: 200px;
				}
				/deep/ .el-upload-list .el-upload-list__item {
					border: 1px dashed rgba(64, 158, 255, 1);
					cursor: pointer;
					border-radius: 6px;
					color: rgba(64, 158, 255, 1);
					width: 200px;
					font-size: 32px;
					line-height: 200px;
					text-align: center;
					height: 200px;
					font-size: 14px;
					line-height: 1.8;
				}
				/deep/ .el-upload .el-icon-plus {
					border: 1px dashed rgba(64, 158, 255, 1);
					cursor: pointer;
					border-radius: 6px;
					color: rgba(64, 158, 255, 1);
					width: 200px;
					font-size: 32px;
					line-height: 200px;
					text-align: center;
					height: 200px;
				}
				/deep/ .el-upload__tip {
					color: #838fa1;
				}
				.el-textarea /deep/ .el-textarea__inner {
					border: 0;
					border-radius: 4px;
					padding: 12px;
					box-shadow: 0 0 6px rgba(64, 158, 255, .5);
					outline: none;
					color: #000;
					width: 400px;
					font-size: 14px;
					height: 120px;
				}
				.el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 4px;
					padding: 12px;
					box-shadow: 0 0 6px rgba(85, 85, 127, 0.5);
					outline: none;
					color: #000;
					width: 400px;
					font-size: 14px;
					height: 120px;
				}
				/deep/ .el-input__inner::placeholder {
					color: #123;
					font-size: 16px;
				}
				/deep/ textarea::placeholder {
					color: #123;
					font-size: 16px;
				}
				.editor {
					background-color: #fff;
					border-radius: 0;
					padding: 0;
					box-shadow: 0 0 6px rgba(75,223,201,.5);
					margin: 0;
					width: 100%;
					border-color: #ccc;
					border-width: 0;
					border-style: solid;
					height: auto;
				}
				.upload-img {
					width: 150px;
					height: 150px;
				}
				.viewBtn {
					border: 0;
					cursor: pointer;
					padding: 0 10px;
					margin: 0;
					color: #fff;
					display: inline-block;
					font-size: 14px;
					line-height: 30px;
					border-radius: 4px;
					outline: none;
					background: #0E667D;
					width: auto;
					height: 30px;
				}
				.viewBtn:hover {
					color: #666;
					background: rgba(64, 158, 255, .5);
				}
				.unviewBtn {
					border: 0;
					cursor: pointer;
					padding: 0 10px;
					margin: 0;
					color: #fff;
					display: inline-block;
					font-size: 14px;
					line-height: 30px;
					border-radius: 4px;
					outline: none;
					background: rgba(85, 85, 127, 1.0);
					width: auto;
					height: 30px;
				}
				.unviewBtn:hover {
					color: #666;
					background: rgba(85, 85, 127, .5);
				}
			}
			.add-btn-item {
				padding: 0;
				margin: 0;
				.submitBtn {
					border: 0;
					cursor: pointer;
					border-radius: 4px;
					padding: 0 15px;
					margin: 0 20px 0 0;
					outline: none;
					background: #0E667D;
					display: inline-block;
					width: auto;
					font-size: 14px;
					line-height: 40px;
					height: 40px;
					.icon {
						color: rgba(255, 255, 255, 1);
					}
					.text {
						color: rgba(255, 255, 255, 1);
					}
				}
				.submitBtn:hover {
					background: rgba(64, 158, 255, .5);
					.icon {
						color: #000;
					}
					.text {
						color: #000;
					}
				}
				.closeBtn {
					border: none;
					cursor: pointer;
					border-radius: 4px;
					padding: 0 15px;
					margin: 0 20px 0 0;
					outline: none;
					background: #E8E8E8;
					display: inline-block;
					width: auto;
					font-size: 14px;
					line-height: 40px;
					height: 40px;
					.icon {
						color: #000;
					}
					.text {
						color: #000;
					}
				}
				.closeBtn:hover {
					color: rgba(64, 158, 255, .5);
					border-color: rgba(64, 158, 255, .5);
					.icon {
						color: rgba(64, 158, 255, 0.5);
					}
					.text {
						color: rgba(64, 158, 255, 0.5);
					}
				}
			}
		}
	}
	.el-date-editor.el-input {
		width: auto;
	}
</style>
