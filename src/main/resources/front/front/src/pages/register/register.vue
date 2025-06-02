<template>
	<div>

		<div class="container">
			<el-form class='rgs-form animate__animated animate__fadeInDown' v-if="pageFlag=='register'" ref="registerForm" :model="registerForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">基于SpringBoot+Vue技术的农机租赁系统的设计与实现注册</p></div>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="yonghuzhanghao">
						<div class="label" :class="changeRules('yonghuzhanghao')?'required':''">用户账号：</div>
						<el-input v-model="registerForm.yonghuzhanghao"  placeholder="请输入用户账号" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="mima">
						<div class="label" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="mima2">
						<div class="label" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="yonghuxingming">
						<div class="label" :class="changeRules('yonghuxingming')?'required':''">用户姓名：</div>
						<el-input v-model="registerForm.yonghuxingming"  placeholder="请输入用户姓名" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="touxiang">
						<div class="label" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
							@change="yonghutouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="xingbie">
						<div class="label" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in yonghuxingbieOptions"
								:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="shoujihaoma">
						<div class="label" :class="changeRules('shoujihaoma')?'required':''">手机号码：</div>
						<el-input v-model="registerForm.shoujihaoma"  placeholder="请输入手机号码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='weixiurenyuan'" prop="weixiuzhanghao">
						<div class="label" :class="changeRules('weixiuzhanghao')?'required':''">维修账号：</div>
						<el-input v-model="registerForm.weixiuzhanghao"  placeholder="请输入维修账号" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='weixiurenyuan'" prop="mima">
						<div class="label" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='weixiurenyuan'" prop="mima2">
						<div class="label" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='weixiurenyuan'" prop="weixiuxingming">
						<div class="label" :class="changeRules('weixiuxingming')?'required':''">维修姓名：</div>
						<el-input v-model="registerForm.weixiuxingming"  placeholder="请输入维修姓名" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='weixiurenyuan'" prop="touxiang">
						<div class="label" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
							@change="weixiurenyuantouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='weixiurenyuan'" prop="xingbie">
						<div class="label" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in weixiurenyuanxingbieOptions"
								:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='weixiurenyuan'" prop="lianxidianhua">
						<div class="label" :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
						<el-input v-model="registerForm.lianxidianhua"  placeholder="请输入联系电话" />
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<el-button class="register_btn" type="primary" @click="submitForm('registerForm')">注册</el-button>
						</div>
						<div class="register-btn2">
							<router-link class="has_btn" to="/login">已有账号，直接登录</router-link>
						</div>
					</div>
				</div>
				<div class="idea1"></div>
				<div class="idea2"></div>
			</el-form>
		</div>
	</div>
</div>
</template>

<script>
	import 'animate.css';

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {},
			forgetForm: {},
			rules: {},
			requiredRules: {},
            yonghuxingbieOptions: [],
            weixiurenyuanxingbieOptions: [],
		}
    },
	mounted() {
		if(this.$route.query.pageFlag=='register'){
			this.tableName = this.$route.query.role;
			if(this.tableName=='yonghu'){
				this.registerForm = {
					yonghuzhanghao: '',
					mima: '',
					mima2: '',
					yonghuxingming: '',
					touxiang: '',
					xingbie: '',
					shoujihaoma: '',
					sfsh: '',
					shhf: '',
					status: '',
				}
			}
			if(this.tableName=='weixiurenyuan'){
				this.registerForm = {
					weixiuzhanghao: '',
					mima: '',
					mima2: '',
					weixiuxingming: '',
					touxiang: '',
					xingbie: '',
					lianxidianhua: '',
				}
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }];
				this.requiredRules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }];
				this.requiredRules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }]
			}
			this.yonghuxingbieOptions = "男,女".split(',');
			if ('yonghu' == this.tableName) {
				this.rules.shoujihaoma = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
			}
			if ('yonghu' == this.tableName) {
				this.rules.status = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
			}
			if ('weixiurenyuan' == this.tableName) {
				this.rules.weixiuzhanghao = [{ required: true, message: '请输入维修账号', trigger: 'blur' }];
				this.requiredRules.weixiuzhanghao = [{ required: true, message: '请输入维修账号', trigger: 'blur' }]
			}
			if ('weixiurenyuan' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('weixiurenyuan' == this.tableName) {
				this.rules.weixiuxingming = [{ required: true, message: '请输入维修姓名', trigger: 'blur' }];
				this.requiredRules.weixiuxingming = [{ required: true, message: '请输入维修姓名', trigger: 'blur' }]
			}
			this.weixiurenyuanxingbieOptions = "男,女".split(',');
			if ('weixiurenyuan' == this.tableName) {
				this.rules.lianxidianhua = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
			}
		}
	},
    created() {
		this.pageFlag = this.$route.query.pageFlag;
    },
    //方法集合
    methods: {
		changeRules(name){
			if(this.requiredRules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
        // 下二随
		yonghutouxiangUploadChange(fileUrls) {
			this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},
		weixiurenyuantouxiangUploadChange(fileUrls) {
			this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},

		// 多级联动参数


		submitForm(formName) {
			this.$refs[formName].validate((valid) => {
				if (valid) {
					var url=this.tableName+"/register";
					if(this.tableName=='yonghu'){
						this.registerForm.sfsh = '待审核'
					}
					if(`yonghu` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if(`weixiurenyuan` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
						this.$message.error(`两次密码输入不一致`);
						return
					}
					this.$http.post(url, this.registerForm).then(res => {
						if (res.data.code === 0) {
							this.$message({
								message: '注册成功',
								type: 'success',
								duration: 1500,
								onClose: () => {
									this.$router.push('/login');
								}
							});
						} else {
							this.$message.error(res.data.msg);
						}
					});
				} else {
					return false;
				}
			});
		},
		resetForm(formName) {
			this.$refs[formName].resetFields();
		}
    }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		padding: 16% 0 0 0;
		background: url(http://codegen.caihongy.cn/20250117/0689096c781b44da9d9f2f0cca926295.png) top center / 100% 100%;
		display: flex;
		width: 100%;
		min-height: 100vh;
		justify-content: flex-start;
		align-items: center;
		position: relative;
		background: url(http://codegen.caihongy.cn/20250117/0689096c781b44da9d9f2f0cca926295.png) top center / 100% 100%;
		.rgs-form {
			border-radius: 10px;
			padding: 0;
			box-shadow: none;
			margin: 0 0 0 12%;
			z-index: 1;
			background: none;
			width: 440px;
			height: auto;
			.rgs-form2 {
				width: 100%;
				.title {
					margin: 0 0 10px 0;
					text-shadow: none;
					color: #FFFFFF;
					font-weight: 700;
					width: 100%;
					font-size: 20px;
					line-height: 44px;
					text-align: center;
				}
				.subtitle {
					margin: 0 0 10px 0;
					text-shadow: 4px 4px 2px rgba(64, 158, 255, .5);
					color: rgba(64, 158, 255, 1);
					width: 100%;
					font-size: 20px;
					line-height: 44px;
					text-align: center;
				}
				.list-item {
					border-radius: 5px;
					padding: 1px;
					margin: 0 0 30px 0;
					background: #FFFFFF;
					display: flex;
					width: 100%;
					/deep/.el-form-item__content {
						display: flex;
						width: 100%;
						.label {
							border-radius: 5px;
							color: #FFFFFF;
							flex: none;
							background: #0E667D;
							width: auto;
							font-size: 14px;
							line-height: 44px;
							text-align: center;
							min-width: 80px;
						}
						
						.required {
							position: relative;
						}
						.required::after{
							color: red;
							left: -10px;
							position: absolute;
							content: "*";
						}
						.el-input {
							width: 100%;
						}
						.el-input .el-input__inner {
							border: none;
							padding: 0 10px;
							outline: none;
							color: #000;
							flex: auto;
							width: 100%;
							font-size: 14px;
							height: 44px;
						}
						.el-input .el-input__inner:focus {
							border: none;
							padding: 0 10px;
							outline: none;
							color: #000;
							flex: auto;
							width: 100%;
							font-size: 14px;
							height: 44px;
						}
						.el-input-number {
							width: 100%;
						}
						.el-input-number .el-input__inner {
							text-align: left;
							border: none;
							padding: 0 10px;
							outline: none;
							color: #000;
							flex: auto;
							width: 100%;
							font-size: 14px;
							height: 44px;
						}
						.el-input-number .el-input-number__decrease {
							display: none;
						}
						.el-input-number .el-input-number__increase {
							display: none;
						}
						.el-select {
							width: 100%;
						}
						.el-select .el-input__inner {
							border: none;
							padding: 0 10px;
							outline: none;
							color: #000;
							flex: auto;
							width: 100%;
							font-size: 14px;
							height: 44px;
						}
						.el-select .el-input__inner:focus {
							border: none;
							padding: 0 10px;
							outline: none;
							color: #000;
							flex: auto;
							width: 100%;
							font-size: 14px;
							height: 44px;
						}
						.el-date-editor {
							width: 100%;
						}
						.el-date-editor .el-input__inner {
							border: none;
							padding: 0 0 0 40px;
							outline: none;
							color: #000;
							flex: auto;
							width: 100%;
							font-size: 14px;
							height: 44px;
						}
						.el-date-editor .el-input__inner:focus {
							border: none;
							padding: 0 0 0 40px;
							outline: none;
							color: #000;
							flex: auto;
							width: 100%;
							font-size: 14px;
							height: 44px;
						}
						.el-upload--picture-card {
							background: transparent;
							border: 0;
							border-radius: 0;
							width: auto;
							height: auto;
							line-height: initial;
							vertical-align: middle;
						}
						.upload .upload-img {
							border: 1px dashed rgba(64, 158, 255, 1);
							cursor: pointer;
							border-radius: 8px;
							color: rgba(64, 158, 255, 1);
							width: 160px;
							font-size: 32px;
							line-height: 160px;
							text-align: center;
							height: 160px;
						}
						.el-upload-list .el-upload-list__item {
							border: 1px dashed rgba(64, 158, 255, 1);
							cursor: pointer;
							border-radius: 8px;
							color: rgba(64, 158, 255, 1);
							width: 160px;
							font-size: 32px;
							line-height: 160px;
							text-align: center;
							height: 160px;
							font-size: 14px;
							line-height: 1.8;
						}
						.el-upload .el-icon-plus {
							border: 1px dashed rgba(64, 158, 255, 1);
							cursor: pointer;
							border-radius: 8px;
							color: rgba(64, 158, 255, 1);
							width: 160px;
							font-size: 32px;
							line-height: 160px;
							text-align: center;
							height: 160px;
						}
						.el-upload__tip {
							color: #838fa1;
						}
						.emailInput {
							border: none;
							padding: 0 10px;
							outline: none;
							color: #000;
							flex: auto;
							width: 100%;
							font-size: 14px;
							height: 44px;
						}
						.emailInput:focus {
							border: none;
							padding: 0 10px;
							outline: none;
							color: #000;
							flex: auto;
							width: 100%;
							font-size: 14px;
							height: 44px;
						}
						.el-btn {
							border: 0;
							cursor: pointer;
							padding: 0;
							margin: 0;
							color: #fff;
							font-size: 12px;
							border-radius: 0 4px 4px 0;
							box-shadow: none;
							outline: none;
							background: #0E667D;
							flex: none;
							width: 80px;
							height: 44px;
						}
						.el-btn:hover {
							opacity: 0.7;
						}
						
						.el-input__inner::placeholder {
							color: #C0AD98;
							font-size: 14px;
						}
						input::placeholder {
							color: #C0AD98;
							font-size: 14px;
						}
						.editor {
							width: 100%;
							height: auto;
						}
					}
				}
				.register-btn {
					padding: 0 0 20px 0;
					width: 100%;
				}
				.register-btn1 {
					width: 100%;
				}
				.register-btn2 {
					width: 100%;
				}
				.register_btn {
					border: 2px solid #fff;
					cursor: pointer;
					padding: 0 10px;
					margin: 20px auto 5px;
					color: #fff;
					display: block;
					font-size: 16px;
					border-radius: 8px;
					box-shadow: none;
					outline: none;
					background: #0E667D;
					width: 100%;
					height: 44px;
				}
				.register_btn:hover {
					opacity: 0.5;
				}
				.has_btn {
					cursor: pointer;
					padding: 0 10%;
					color: rgba(159, 159, 159, 1);
					display: inline-block;
					text-decoration: none;
					font-size: 12px;
					line-height: 1;
				}
				.has_btn:hover {
					opacity: 0.5;
				}
			}
			.idea1 {
				background: red;
				display: none;
				width: 100%;
				height: 40px;
			}
			.idea2 {
				background: blue;
				display: none;
				width: 100%;
				height: 40px;
			}
		}
	}
	
	::-webkit-scrollbar {
		display: none;
	}
</style>
