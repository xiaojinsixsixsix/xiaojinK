<template>
<view class="content">
	<view :style='{"minHeight":"100vh","width":"100%","padding":"24rpx","position":"relative","background":"url(http://codegen.caihongy.cn/20240112/23f959aa396c4607b2f20ed40caa81e9.jpg) no-repeat center top / 100% auto,#f5f5f5","height":"auto"}'>
		<form :style='{"width":"100%","padding":"24rpx","borderRadius":"16rpx","background":"#fff","display":"block","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"0px 24rpx 12rpx","margin":"0 0 24rpx 0","borderColor":"#eee","alignItems":"center","flexWrap":"wrap","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"left"}' class="title">景点名称</view>
				<input :style='{"border":"2rpx solid #fff","padding":"0","margin":"0px","color":"#666","borderRadius":"8rpx","flex":"1","background":"rgba(255,255,255,.6)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.jingdianmingcheng" v-model="ruleForm.jingdianmingcheng" placeholder="景点名称"  type="text"></input>
			</view>
			<view :style='{"padding":"0px 24rpx 12rpx","margin":"0 0 24rpx 0","borderColor":"#eee","alignItems":"center","flexWrap":"wrap","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"left"}' class="title">景点分类</view>
				<picker :disabled="ro.jingdianfenlei" :style='{"border":"2rpx solid #fff","width":"100%","padding":"0","flex":"1","background":"rgba(255,255,255,.6)","height":"auto"}' @change="jingdianfenleiChange" :value="jingdianfenleiIndex" :range="jingdianfenleiOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#666"}' class="uni-input">{{ruleForm.jingdianfenlei?ruleForm.jingdianfenlei:"请选择景点分类"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"0px 24rpx 12rpx","margin":"0 0 24rpx 0","borderColor":"#eee","alignItems":"center","flexWrap":"wrap","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="" @tap="jingdiantupianTap">
				<view :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"left"}' class="title">景点图片</view>
				<image :style='{"width":"80rpx","margin":"0","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.jingdiantupian" :src="baseUrl+ruleForm.jingdiantupian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","margin":"0","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"0px 24rpx 12rpx","margin":"0 0 24rpx 0","borderColor":"#eee","alignItems":"center","flexWrap":"wrap","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"left"}' class="title">官网</view>
				<input :style='{"border":"2rpx solid #fff","padding":"0","margin":"0px","color":"#666","borderRadius":"8rpx","flex":"1","background":"rgba(255,255,255,.6)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.guanwang" v-model="ruleForm.guanwang" placeholder="官网"  type="text"></input>
			</view>
			<view :style='{"padding":"0px 24rpx 12rpx","margin":"0 0 24rpx 0","borderColor":"#eee","alignItems":"center","flexWrap":"wrap","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"left"}' class="title">门票价格</view>
				<input :style='{"border":"2rpx solid #fff","padding":"0","margin":"0px","color":"#666","borderRadius":"8rpx","flex":"1","background":"rgba(255,255,255,.6)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.menpiaojiage" v-model="ruleForm.menpiaojiage" placeholder="门票价格"  type="text"></input>
			</view>
			<view :style='{"padding":"0px 24rpx 12rpx","margin":"0 0 24rpx 0","borderColor":"#eee","alignItems":"center","flexWrap":"wrap","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"left"}' class="title">景点地址</view>
				<input :style='{"border":"2rpx solid #fff","padding":"0","margin":"0px","color":"#666","borderRadius":"8rpx","flex":"1","background":"rgba(255,255,255,.6)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.jingdiandizhi" v-model="ruleForm.jingdiandizhi" placeholder="景点地址"  type="text"></input>
			</view>
			<view :style='{"padding":"0px 24rpx 12rpx","margin":"0 0 24rpx 0","borderColor":"#eee","alignItems":"center","flexWrap":"wrap","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"left"}' class="title">开放时间</view>
				<input :style='{"border":"2rpx solid #fff","padding":"0","margin":"0px","color":"#666","borderRadius":"8rpx","flex":"1","background":"rgba(255,255,255,.6)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.kaifangshijian" v-model="ruleForm.kaifangshijian" placeholder="开放时间"  type="text"></input>
			</view>
 

			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","borderWidth":"0 0 0px 0","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"margin":"0 0 0 24rpx","color":"#999","width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"160rpx","fontWeight":"500"}' class="title">景点介绍</view>
                <xia-editor ref="editor" :style='{"border":"2rpx solid #ddd","minHeight":"360rpx","padding":"20rpx","color":"#666","borderRadius":"8rpx","background":"rgba(255,255,255,.6)","width":"100%","height":"auto"}' v-model="ruleForm.jingdianjieshao" placeholder="景点介绍" @editorChange="jingdianjieshaoChange"></xia-editor>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","borderWidth":"0 0 0px 0","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"margin":"0 0 0 24rpx","color":"#999","width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"160rpx","fontWeight":"500"}' class="title">注意事项</view>
                <xia-editor ref="editor" :style='{"border":"2rpx solid #ddd","minHeight":"360rpx","padding":"20rpx","color":"#666","borderRadius":"8rpx","background":"rgba(255,255,255,.6)","width":"100%","height":"auto"}' v-model="ruleForm.zhuyishixiang" placeholder="注意事项" @editorChange="zhuyishixiangChange"></xia-editor>
			</view>
			
			<view :style='{"width":"100%","flexWrap":"wrap","justifyContent":"space-between","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0px","margin":"0 0 40rpx","color":"#fff","borderRadius":"32rpx","background":"#4AB030","width":"100%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

		<w-picker  mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="clicktimeConfirm" ref="clicktime" themeColor="#333333"></w-picker>
	</view>
</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
    import xiaEditor from '@/components/xia-editor/xia-editor';
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				cross:'',
				ruleForm: {
				jingdianmingcheng: '',
				jingdianfenlei: '',
				jingdiantupian: '',
				guanwang: '',
				menpiaojiage: '',
				jingdiandizhi: '',
				jingdianjieshao: '',
				kaifangshijian: '',
				zhuyishixiang: '',
				discussnum: '',
				storeupnum: '',
				},
				jingdianfenleiOptions: [],
				jingdianfenleiIndex: 0,
				// 登录用户信息
				user: {},
                ro:{
                   jingdianmingcheng : false,
                   jingdianfenlei : false,
                   jingdiantupian : false,
                   guanwang : false,
                   menpiaojiage : false,
                   jingdiandizhi : false,
                   jingdianjieshao : false,
                   kaifangshijian : false,
                   zhuyishixiang : false,
                   thumbsupnum : false,
                   crazilynum : false,
                   clicktime : false,
                   clicknum : false,
                   discussnum : false,
                   storeupnum : false,
                },
			}
		},
		components: {
			wPicker,
            xiaEditor,
            multipleSelect,
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},



		},
		async onLoad(options) {
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取


			// 下拉框
			res = await this.$api.option(`jingdianfenlei`,`jingdianfenlei`,{});
			this.jingdianfenleiOptions = res.data;
            this.jingdianfenleiOptions.unshift("请选择景点分类");

			// 如果有登录，获取登录后保存的userid
			this.ruleForm.userid = uni.getStorageSync("appUserid")
			if (options.refid) {
				// 如果上一级页面传递了refid，获取改refid数据信息
				this.ruleForm.refid = Number(options.refid);
				this.ruleForm.nickname = uni.getStorageSync("nickname");
			}
			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				res = await this.$api.info(`lvyoujingdian`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='jingdianmingcheng'){
					this.ruleForm.jingdianmingcheng = obj[o];
					this.ro.jingdianmingcheng = true;
					continue;
					}
					if(o=='jingdianfenlei'){
					this.ruleForm.jingdianfenlei = obj[o];
					this.ro.jingdianfenlei = true;
					continue;
					}
					if(o=='jingdiantupian'){
					this.ruleForm.jingdiantupian = obj[o].split(",")[0];
					this.ro.jingdiantupian = true;
					continue;
					}
					if(o=='guanwang'){
					this.ruleForm.guanwang = obj[o];
					this.ro.guanwang = true;
					continue;
					}
					if(o=='menpiaojiage'){
					this.ruleForm.menpiaojiage = obj[o];
					this.ro.menpiaojiage = true;
					continue;
					}
					if(o=='jingdiandizhi'){
					this.ruleForm.jingdiandizhi = obj[o];
					this.ro.jingdiandizhi = true;
					continue;
					}
					if(o=='jingdianjieshao'){
					this.ruleForm.jingdianjieshao = obj[o];
					this.ro.jingdianjieshao = true;
					continue;
					}
					if(o=='kaifangshijian'){
					this.ruleForm.kaifangshijian = obj[o];
					this.ro.kaifangshijian = true;
					continue;
					}
					if(o=='zhuyishixiang'){
					this.ruleForm.zhuyishixiang = obj[o];
					this.ro.zhuyishixiang = true;
					continue;
					}
					if(o=='thumbsupnum'){
					this.ruleForm.thumbsupnum = obj[o];
					this.ro.thumbsupnum = true;
					continue;
					}
					if(o=='crazilynum'){
					this.ruleForm.crazilynum = obj[o];
					this.ro.crazilynum = true;
					continue;
					}
					if(o=='clicktime'){
					this.ruleForm.clicktime = obj[o];
					this.ro.clicktime = true;
					continue;
					}
					if(o=='clicknum'){
					this.ruleForm.clicknum = obj[o];
					this.ro.clicknum = true;
					continue;
					}
					if(o=='discussnum'){
					this.ruleForm.discussnum = obj[o];
					this.ro.discussnum = true;
					continue;
					}
					if(o=='storeupnum'){
					this.ruleForm.storeupnum = obj[o];
					this.ro.storeupnum = true;
					continue;
					}
				}
			}
			this.styleChange()
            this.$forceUpdate()
			
			if (uni.getStorageSync('raffleType') && uni.getStorageSync('raffleType') != null) {
				uni.removeStorageSync('raffleType')
				setTimeout(() => {
					this.onSubmitTap()
				}, 300)
			}
		},
		methods: {
            jingdianjieshaoChange(e) {
                this.ruleForm.jingdianjieshao = e
            },
            zhuyishixiangChange(e) {
                this.ruleForm.zhuyishixiang = e
            },
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
					// })
				})
			},

			// 多级联动参数


			// 日长控件选择日期时间
			clicktimeConfirm(val) {
				console.log(val)
				this.ruleForm.clicktime = val.result;
				this.$forceUpdate();
			},

			// 下拉变化
			jingdianfenleiChange(e) {
				this.jingdianfenleiIndex = e.target.value
				this.ruleForm.jingdianfenlei = this.jingdianfenleiOptions[this.jingdianfenleiIndex]
			},

			jingdiantupianTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.jingdiantupian = 'upload/' + res.file;
					_this.$forceUpdate();
					_this.$nextTick(()=>{
						_this.styleChange()
					})
				});
			},

			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
//跨表计算判断
				var obj;
				if((!this.ruleForm.jingdianmingcheng)){
					this.$utils.msg(`景点名称不能为空`);
					return
				}
				if(this.ruleForm.guanwang&&(!this.$validate.isURL(this.ruleForm.guanwang))){
					this.$utils.msg(`官网应输入网址格式`);
					return
				}
				if(this.ruleForm.thumbsupnum&&(!this.$validate.isIntNumer(this.ruleForm.thumbsupnum))){
					this.$utils.msg(`赞应输入整数`);
					return
				}
				if(this.ruleForm.crazilynum&&(!this.$validate.isIntNumer(this.ruleForm.crazilynum))){
					this.$utils.msg(`踩应输入整数`);
					return
				}
				if(this.ruleForm.clicknum&&(!this.$validate.isIntNumer(this.ruleForm.clicknum))){
					this.$utils.msg(`点击次数应输入整数`);
					return
				}
				if(this.ruleForm.discussnum&&(!this.$validate.isIntNumer(this.ruleForm.discussnum))){
					this.$utils.msg(`评论数应输入整数`);
					return
				}
				if(this.ruleForm.storeupnum&&(!this.$validate.isIntNumer(this.ruleForm.storeupnum))){
					this.$utils.msg(`收藏数应输入整数`);
					return
				}
				//更新跨表属性
				var crossuserid;
				var crossrefid;
				var crossoptnum;
				if(this.cross){
                    uni.setStorageSync('crossCleanType',true);
					var statusColumnName = uni.getStorageSync('statusColumnName');
					var statusColumnValue = uni.getStorageSync('statusColumnValue');
					if(statusColumnName!='') {
                        if(!obj) {
						    obj = uni.getStorageSync('crossObj');
                        }
						if(!statusColumnName.startsWith("[")) {
							for (var o in obj){
								if(o==statusColumnName){
									obj[o] = statusColumnValue;
								}

							}
							var table = uni.getStorageSync('crossTable');
							await this.$api.update(`${table}`, obj);
						} else {
						       crossuserid=Number(uni.getStorageSync('appUserid'));
						       crossrefid=obj['id'];
						       crossoptnum=uni.getStorageSync('statusColumnName');
						       crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
						}
					}
				}
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid=crossuserid;
					this.ruleForm.crossrefid=crossrefid;
					let params = {
						page: 1,
						limit:10,
						crossuserid:crossuserid,
						crossrefid:crossrefid,
					}
					let res = await this.$api.list(`lvyoujingdian`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
                        uni.removeStorageSync('crossCleanType');
						return false;
					} else {
                //跨表计算
						if(this.ruleForm.id){
							await this.$api.update(`lvyoujingdian`, this.ruleForm);
						}else{
							await this.$api.add(`lvyoujingdian`, this.ruleForm);
						}
						this.$utils.msgBack('提交成功');
					}
				} else {
                //跨表计算
					if(this.ruleForm.id){
						await this.$api.update(`lvyoujingdian`, this.ruleForm);
					}else{
						await this.$api.add(`lvyoujingdian`, this.ruleForm);
					}
					this.$utils.msgBack('提交成功');
				}
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			bindDateChange(e) {
				this.date = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				if(this.ro[str]){
					return false
				}
				this.$refs[str].show();
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
