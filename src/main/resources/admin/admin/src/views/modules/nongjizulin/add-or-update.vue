<template>
	<div class="addEdit-block">
		<el-form
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template v-if="!showDriverFlag">
				<el-form-item class="input" v-if="type!='info'" label="租赁编号" prop="zulinbianhao" >
					<el-input v-model="ruleForm.zulinbianhao" placeholder="租赁编号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.zulinbianhao" label="租赁编号" prop="zulinbianhao" >
					<el-input v-model="ruleForm.zulinbianhao" placeholder="租赁编号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="农机编号" prop="nongjibianhao" >
					<el-input v-model="ruleForm.nongjibianhao" placeholder="农机编号" clearable  :readonly="ro.nongjibianhao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="农机编号" prop="nongjibianhao" >
					<el-input v-model="ruleForm.nongjibianhao" placeholder="农机编号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="农机名称" prop="nongjimingcheng" >
					<el-input v-model="ruleForm.nongjimingcheng" placeholder="农机名称" clearable  :readonly="ro.nongjimingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="农机名称" prop="nongjimingcheng" >
					<el-input v-model="ruleForm.nongjimingcheng" placeholder="农机名称" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.tupian" label="图片" prop="tupian" >
					<file-upload
						tip="点击上传图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.tupian?ruleForm.tupian:''"
						@change="tupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.tupian" label="图片" prop="tupian" >
					<img v-if="ruleForm.tupian.substring(0,4)=='http'&&ruleForm.tupian.split(',w').length>1" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.tupian" width="100" height="100">
					<img v-else-if="ruleForm.tupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.tupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.tupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="农机类型" prop="nongjileixing" >
					<el-input v-model="ruleForm.nongjileixing" placeholder="农机类型" clearable  :readonly="ro.nongjileixing"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="农机类型" prop="nongjileixing" >
					<el-input v-model="ruleForm.nongjileixing" placeholder="农机类型" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="型号" prop="xinghao" >
					<el-input v-model="ruleForm.xinghao" placeholder="型号" clearable  :readonly="ro.xinghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="型号" prop="xinghao" >
					<el-input v-model="ruleForm.xinghao" placeholder="型号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="押金" prop="yajin" >
					<el-input v-model.number="ruleForm.yajin" placeholder="押金" clearable  :readonly="ro.yajin"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="押金" prop="yajin" >
					<el-input v-model="ruleForm.yajin" placeholder="押金" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="日租价格" prop="rizujiage" >
					<el-input v-model.number="ruleForm.rizujiage" placeholder="日租价格" clearable  :readonly="ro.rizujiage"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="日租价格" prop="rizujiage" >
					<el-input v-model="ruleForm.rizujiage" placeholder="日租价格" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="租赁天数" prop="zulintianshu" >
					<el-input v-model.number="ruleForm.zulintianshu" placeholder="租赁天数" clearable  :readonly="ro.zulintianshu"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="租赁天数" prop="zulintianshu" >
					<el-input v-model="ruleForm.zulintianshu" placeholder="租赁天数" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="租赁金额" prop="zulinjine" >
					<el-input v-model="zulinjine" placeholder="租赁金额" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.zulinjine" label="租赁金额" prop="zulinjine" >
					<el-input v-model="ruleForm.zulinjine" placeholder="租赁金额" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="租赁时间" prop="zulinshijian" >
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.zulinshijian" 
						type="datetime"
						:readonly="ro.zulinshijian"
						placeholder="租赁时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.zulinshijian" label="租赁时间" prop="zulinshijian" >
					<el-input v-model="ruleForm.zulinshijian" placeholder="租赁时间" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="用户姓名" prop="yonghuxingming" >
					<el-input v-model="ruleForm.yonghuxingming" placeholder="用户姓名" clearable  :readonly="ro.yonghuxingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="用户姓名" prop="yonghuxingming" >
					<el-input v-model="ruleForm.yonghuxingming" placeholder="用户姓名" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="用户账号" prop="yonghuzhanghao" >
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder="用户账号" clearable  :readonly="ro.yonghuzhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="用户账号" prop="yonghuzhanghao" >
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder="用户账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="归还状态" prop="guihaizhuangtai" >
					<el-select :disabled="ro.guihaizhuangtai" v-model="ruleForm.guihaizhuangtai" placeholder="请选择归还状态" >
						<el-option
							v-for="(item,index) in guihaizhuangtaiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="归还状态" prop="guihaizhuangtai" >
					<el-input v-model="ruleForm.guihaizhuangtai"
						placeholder="归还状态" readonly></el-input>
				</el-form-item>




			</template>


<template v-if="showDriverFlag">
      <el-form-item class="select" v-if="type!='info'&&showDriverFlag"  label="司机" prop="driver"  >
        <el-select :disabled="ro.driver" v-model="ruleForm.driver" placeholder="请选择司机" >
          <el-option
              v-for="(item,index) in driverOptions"
              v-bind:key="index"
              :label="item.name"
              :value="item.name">
          </el-option>
        </el-select>
      </el-form-item>
</template>
			<el-form-item class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-xihuan"></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

	</div>
</template>
<script>
	import { 
		isIntNumer,
	} from "@/utils/validate";
	export default {
		data() {
			var validateIntNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isIntNumer(value)) {
					callback(new Error("请输入整数"));
				} else {
					callback();
				}
			};
			return {
				id: '',
				type: '',
        showDriverFlag: false,
			
				ro:{
					zulinbianhao : false,
					nongjibianhao : false,
					nongjimingcheng : false,
					tupian : false,
					nongjileixing : false,
					xinghao : false,
					yajin : false,
					rizujiage : false,
					zulintianshu : false,
					zulinjine : false,
					zulinshijian : false,
					yonghuxingming : false,
					yonghuzhanghao : false,
					guihaizhuangtai : false,
					ispay : false,
          driver:false,
				},
			
				ruleForm: {
					zulinbianhao: this.getUUID(),
					nongjibianhao: '',
					nongjimingcheng: '',
					tupian: '',
					nongjileixing: '',
					xinghao: '',
					yajin: '',
					rizujiage: '',
					zulintianshu: '',
					zulinjine: '',
					zulinshijian: '',
					yonghuxingming: '',
					yonghuzhanghao: '',
					guihaizhuangtai: '未归还',
          driver:'',
				},
				guihaizhuangtaiOptions: [],
				driverOptions: [],

				rules: {
					zulinbianhao: [
					],
					nongjibianhao: [
					],
					nongjimingcheng: [
					],
					tupian: [
					],
					nongjileixing: [
					],
					xinghao: [
					],
					yajin: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					rizujiage: [
						{ required: true, message: '日租价格不能为空', trigger: 'blur' },
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					zulintianshu: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					zulinjine: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					zulinshijian: [
					],
					yonghuxingming: [
					],
					yonghuzhanghao: [
					],
					guihaizhuangtai: [
					],
					ispay: [
					],
				},
			};
		},
		props: ["parent"],
		computed: {



			zulinjine:{
			
				get: function () {
					return 1*this.ruleForm.rizujiage*this.ruleForm.zulintianshu+parseFloat(this.ruleForm.yajin==""?0:this.ruleForm.yajin)
				}
			},
		},
		components: {
		},
		created() {
			this.ruleForm.zulinshijian = this.getCurDateTime()
		},
		methods: {
			// 下载
			download(file){
				window.open(`${file}`)
			},

      // 初始化
      setshowDriver(type) {
        this.showDriverFlag = type;
      },

			// 初始化
			init(id,type) {
				if (id) {
					this.id = id;
					this.type = type;
				}
				if(this.type=='info'||this.type=='else'||this.type=='msg'){
					this.info(id);
				}else if(this.type=='logistics'){
					for(let x in this.ro) {
						this.ro[x] = true
					}
					this.logistics=false;
					this.info(id);
				}else if(this.type=='cross'){
					var obj = this.$storage.getObj('crossObj');
					for (var o in obj){
            if(o=='driver'){
              this.ruleForm.driver = obj[o];
              this.ro.driver = true;
              continue;
            }
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
							this.ruleForm.tupian = obj[o];
							this.ro.tupian = true;
							continue;
						}
						if(o=='nongjileixing'){
							this.ruleForm.nongjileixing = obj[o];
							this.ro.nongjileixing = true;
							continue;
						}
						if(o=='xinghao'){
							this.ruleForm.xinghao = obj[o];
							this.ro.xinghao = true;
							continue;
						}
						if(o=='yajin'){
							this.ruleForm.yajin = obj[o];
							this.ro.yajin = true;
							continue;
						}
						if(o=='rizujiage'){
							this.ruleForm.rizujiage = obj[o];
							this.ro.rizujiage = true;
							continue;
						}
						if(o=='zulintianshu'){
							this.ruleForm.zulintianshu = obj[o];
							this.ro.zulintianshu = true;
							continue;
						}
						if(o=='zulinjine'){
							this.ruleForm.zulinjine = obj[o];
							this.ro.zulinjine = true;
							continue;
						}
						if(o=='zulinshijian'){
							this.ruleForm.zulinshijian = obj[o];
							this.ro.zulinshijian = true;
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
						if(o=='guihaizhuangtai'){
							this.ruleForm.guihaizhuangtai = obj[o];
							this.ro.guihaizhuangtai = true;
							continue;
						}
					}
					this.ruleForm.guihaizhuangtai = '未归还'; 				}
				// 获取用户信息
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
						if(((json.yonghuxingming!=''&&json.yonghuxingming) || json.yonghuxingming==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.yonghuxingming = json.yonghuxingming
							this.ro.yonghuxingming = true;
						}
						if(((json.yonghuzhanghao!=''&&json.yonghuzhanghao) || json.yonghuzhanghao==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.yonghuzhanghao = json.yonghuzhanghao
							this.ro.yonghuzhanghao = true;
						}
						if(this.$storage.get("role")!="管理员") {
							this.ro.guihaizhuangtai = true;
						}
					} else {
						this.$message.error(data.msg);
					}
				});
				this.guihaizhuangtaiOptions = "已归还,未归还".split(',')
        this.$http({
          url: `driver/lists`,
          method: "get"
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.driverOptions = data.data;

          } else {
            this.$message.error(data.msg);
          }
        });
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `nongjizulin/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					this.ruleForm.ispay = '未支付'
					if(this.ruleForm.zulinbianhao) {
						this.ruleForm.zulinbianhao = String(this.ruleForm.zulinbianhao)
					}
					this.ruleForm.zulinjine = this.zulinjine
					if(this.ruleForm.tupian!=null) {
						this.ruleForm.tupian = this.ruleForm.tupian.replace(new RegExp(this.$base.url,"g"),"");
					}
					var objcross = this.$storage.getObj('crossObj');
					await this.$refs["ruleForm"].validate(async valid => {
						if (valid) {
							if(this.type=='cross'){
								var statusColumnName = this.$storage.get('statusColumnName');
								var statusColumnValue = this.$storage.get('statusColumnValue');
								if(statusColumnName!='') {
									var obj = this.$storage.getObj('crossObj');
									if(statusColumnName && !statusColumnName.startsWith("[")) {
										for (var o in obj){
											if(o==statusColumnName){
												obj[o] = statusColumnValue;
											}
										}
										var table = this.$storage.get('crossTable');
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: obj
										}).then(({ data }) => {});
									}
								}
							}
							
							await this.$http({
								url: `nongjizulin/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											if(this.isAuth('nongjizulin','支付')&&this.type=='cross') {
												this.$confirm('是否跳转支付？').then(_ => {
													this.parent.showFlag = true;
													this.parent.addOrUpdateFlag = false;
													this.parent.nongjizulinCrossAddOrUpdateFlag = false;
													this.$router.push('/nongjizulin')
												}).catch(_ => {
													this.parent.showFlag = true;
													this.parent.addOrUpdateFlag = false;
													this.parent.nongjizulinCrossAddOrUpdateFlag = false;
													this.parent.search();
													this.parent.contentStyleChange();
												});
											}else {
												this.parent.showFlag = true;
												this.parent.addOrUpdateFlag = false;
												this.parent.nongjizulinCrossAddOrUpdateFlag = false;
												this.parent.search();
												this.parent.contentStyleChange();
											}
											
										}
									});
								} else {
									this.$message.error(data.msg);
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
				this.parent.showFlag = true;
				this.parent.addOrUpdateFlag = false;
				this.parent.nongjizulinCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
			tupianUploadChange(fileUrls) {
				this.ruleForm.tupian = fileUrls;
			},
		}
	};
</script>
<style lang="scss" scoped>
	.addEdit-block {
		padding: 0px 30px 30px;
		margin: 0 auto;
		background: none;
		width: calc(100% - 0px);
		font-size: 15px;
	}
	.add-update-preview {
		border-radius: 10px;
		padding: 40px 0;
		background: #fff;
		width: 100%;
		border-color: #eee;
		border-width: 0px 0 0;
		border-style: solid;
	}
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	.add-update-preview /deep/ .el-form-item {
		border: 0px solid #eee;
		padding: 0;
		margin: 0 0 26px 0;
		display: inline-block;
		width: 49%;
		text-align: left;
	}
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #333;
		font-weight: 500;
		width: 180px;
		font-size: 15px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		margin-left: 180px;
	}
	.add-update-preview .el-form-item span.text {
		padding: 10px 10px;
		color: #333;
		background: #fff;
		font-weight: 500;
		display: inline-block;
		font-size: 15px;
		line-height: 1.5;
		min-width: 100%;
	}
	
	.add-update-preview .el-input {
		width: 100%;
		text-align: left;
	}
	.add-update-preview .el-input /deep/ .el-input__inner {
		border: 1px solid #e8e8e8;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		width: 100%;
		font-size: 15px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input /deep/ .el-input__inner[readonly="readonly"] {
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-input-number {
		text-align: left;
		width: 100%;
		text-align: left;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
		border: 1px solid #e8e8e8;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		width: 100%;
		font-size: 15px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .is-disabled .el-input__inner {
		text-align: left;
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	.add-update-preview .el-select {
		width: 100%;
		text-align: left;
	}
	.add-update-preview .el-select /deep/ .el-input__inner {
		border: 1px solid #e8e8e8;
		border-radius: 0px;
		padding: 0 10px;
		color: #666;
		width: 100%;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-select /deep/ .is-disabled .el-input__inner {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 10px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 15px;
		height: 34px;
	}
	.add-update-preview .el-date-editor {
		width: 100%;
		text-align: left;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
		border: 1px solid #e8e8e8;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
		border: 0;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .viewBtn {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .viewBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .downBtn {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .downBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .unBtn {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 0px;
		margin: 0 20px 0 0;
		outline: none;
		color: #999;
		background: none;
		width: auto;
		font-size: 15px;
		line-height: 40px;
		height: 40px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 34px;
		}
	}
	.add-update-preview .unBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
		border: 1px solid #e8e8e8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
		border: 1px solid #e8e8e8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
		border: 1px solid #e8e8e8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	.add-update-preview /deep/ .el-upload__tip {
		color: #666;
		font-size: 15px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
		border: 1px solid #e8e8e8;
		border-radius: 0px;
		padding: 12px;
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 15px;
		min-width: 400px;
		height: 120px;
	}
	.add-update-preview .el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
				border: 0;
				cursor: not-allowed;
				border-radius: 0px;
				padding: 12px;
				color: #666;
				background: none;
				width: 100%;
				font-size: 14px;
				min-width: 400px;
				height: auto;
			}
	.add-update-preview .el-form-item.btn {
		padding: 0;
		margin: 20px 0 0;
		.btn1 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #05aeff;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn1:hover {
			opacity: 0.8;
		}
		.btn2 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #ffc144;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 34px;
			}
		}
		.btn2:hover {
			opacity: 0.8;
		}
		.btn3 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #ff837a;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn3:hover {
			opacity: 0.8;
		}
		.btn4 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #ffce52;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn4:hover {
			opacity: 0.8;
		}
		.btn5 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #90a0ff;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn5:hover {
			opacity: 0.8;
		}
	}
</style>
