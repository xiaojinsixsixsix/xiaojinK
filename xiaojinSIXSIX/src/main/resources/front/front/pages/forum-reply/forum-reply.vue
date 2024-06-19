<template>
<view class="content">
	<view :style='{"width":"100%","padding":"24rpx","position":"relative","background":"url(http://codegen.caihongy.cn/20240112/23f959aa396c4607b2f20ed40caa81e9.jpg) no-repeat center top / 100% auto,#f5f5f5","height":"100%"}'>
		<form :style='{"width":"100%","padding":"24rpx","borderRadius":"16rpx","background":"#fff","display":"block","height":"auto"}'>
			<view :style='{"padding":"0","margin":"0 0 24rpx 0","borderColor":"#eee","alignItems":"center","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
				<xia-editor :style='{"minHeight":"360rpx","border":"2rpx solid #fff","padding":"20rpx","margin":"0px","borderRadius":"8rpx","color":"#666","background":"rgba(255,255,255,.6)","width":"100%","lineHeight":"1.5","height":"auto"}' v-model="content" @editorChange="contentChange" placeholder="回复"></xia-editor>
			</view>
			<view :style='{"width":"100%","justifyContent":"center","display":"flex","height":"auto"}'>
				<button :style='{"border":"0","padding":"0px","margin":"0 20rpx","color":"#fff","borderRadius":"32rpx","background":"#4AB030","width":"100%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="onReplyTap" class="bg-red margin-tb-sm">提交回复</button>
			</view>
		</form>
	</view>
</view>
</template>

<script>
    import xiaEditor from '@/components/xia-editor/xia-editor'
	export default {
		data() {
			return {
				pid: '',
				content: '',
				username: '',
                avatarurl: '',
				user: {},
			}
		},
        components: {
            xiaEditor
        },
		async onLoad(options) {
			this.pid = options.pid;
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
            if(table == `yonghu`){
                this.username = this.user.yonghuzhanghao
            }
		},
		methods: {
            contentChange(e) {
                this.content = e
            },
			async onReplyTap() {
				if(this.content==''){
					this.$utils.msg('内容不能为空');
					return false
				}
                this.avatarurl = uni.getStorageSync('headportrait')?uni.getStorageSync('headportrait'):'';
				
				await this.$api.save('forum',{
					parentid: this.pid,
					content: this.content,
                    avatarurl: this.avatarurl,
					username: this.username,
					toptime: this.$utils.getCurDateTime()
				});
				this.$utils.msgBack('回复成功');
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
