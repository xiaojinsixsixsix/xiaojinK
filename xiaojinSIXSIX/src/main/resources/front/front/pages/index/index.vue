<template>
<view class="content">
	<view :style='{"minHeight":"100vh","padding":"40rpx 0px 0","overflow":"hidden","alignItems":"flex-start","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20240112/23f959aa396c4607b2f20ed40caa81e9.jpg) no-repeat center top / 100% auto,#f5f5f5","flexDirection":"row","display":"flex","width":"100%","height":"auto"}'>
		<swiper :style='{"width":"100%","background":"#fff","height":"360rpx"}' class="swiper" :indicator-dots='true' :autoplay='true' :circular='true' indicator-active-color='#00cda6' indicator-color='rgba(0, 0, 0, .3)' :duration='600' :interval='6000' :vertical='false'>
			<swiper-item :style='{"width":"100%","background":"#fff","height":"360rpx"}' v-for="(swiper,index) in swiperList" :key="index" @tap="onSwiperTap(swiper)">
				<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' mode="aspectFill" :src="baseUrl+swiper.img"></image>
				<view v-if="false" :style='{"width":"100%","padding":"0 8rpx","lineHeight":"60rpx","fontSize":"28rpx","color":"#333","background":"#fff"}'>{{ swiper.title }}</view>
			</swiper-item>
		</swiper>
		<!-- menu -->
		<view v-if="true" class="menu" :style='{"padding":"0","margin":"40rpx auto 0","borderRadius":"20rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"calc(100% - 48rpx)","justifyContent":"space-between"}'>
            <block v-for="(item,index1) in menuList" v-bind:key="item.roleName">
                <block v-if="index1==0" v-bind:key="index" v-for=" (menu,index) in item.frontMenu">
                    <block v-bind:key="sort" v-for=" (child,sort) in menu.child">
                        <block v-bind:key="sort2" v-for=" (button,sort2) in child.buttons">
                            <view :style='{"width":"25%","padding":"0px 0","margin":"20rpx 0","height":"auto"}' class="menu-list" v-if="button=='查看' && child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan' " @tap="onPageTap2(child.tableName)">
                                <view class="iconarr" :class="child.appFrontIcon" :style='{"padding":"0px","margin":"0px auto","color":"#fff","borderRadius":"100%","textAlign":"center","background":"#00cda6","display":"block","width":"88rpx","lineHeight":"88rpx","fontSize":"64rpx","height":"88rpx"}'></view>
                                <view :style='{"padding":"0","margin":"12rpx auto 0","color":"#333","textAlign":"center","width":"100%","lineHeight":"28rpx","fontSize":"28rpx"}'>{{child.menu.split("列表")[0]}}</view>
                            </view>
                        </block>
                    </block>
                </block>
            </block>
		</view>
		<!-- menu -->
		<!-- 关于我们 -->
		<view :style='{"padding":"40rpx 24rpx","margin":"0 auto","borderRadius":"16rpx","alignItems":"flex-start","flexWrap":"wrap","background":"#fff","flexDirection":"column","display":"flex","width":"calc(100% - 48rpx)","position":"relative","height":"auto","order":"4"}'>
			<view :style='{"padding":"0 12rpx","margin":"0","borderColor":"#38bf3e","color":"#333","textAlign":"left","background":"none","borderWidth":"0 0 0 4rpx","width":"100%","fontSize":"32rpx","lineHeight":"36rpx","borderStyle":"solid","fontWeight":"600","height":"36rpx"}'>{{aboutUsDetail.title}}</view>
			<view :style='{"margin":"0px 0 0","color":"#333","textAlign":"center","display":"none","width":"100%","lineHeight":"1","fontSize":"28rpx"}'>{{aboutUsDetail.subtitle}}</view>
			<view :style='{"padding":"0 20rpx","margin":"40rpx 0 0","borderRadius":"0","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto","order":"2"}'>
				<img :style='{"width":"31%","margin":"0 0px","objectFit":"cover","borderRadius":"16rpx","display":"block","height":"160rpx"}' v-if="aboutUsDetail.picture1" :src="baseUrl+aboutUsDetail.picture1">
				<img :style='{"width":"31%","margin":"0 0px","objectFit":"cover","borderRadius":"16rpx","display":"block","height":"160rpx"}' v-if="aboutUsDetail.picture2" :src="baseUrl+aboutUsDetail.picture2">
				<img :style='{"width":"31%","margin":"0 0px","objectFit":"cover","borderRadius":"16rpx","display":"block","height":"160rpx"}' v-if="aboutUsDetail.picture3" :src="baseUrl+aboutUsDetail.picture3">
			</view>
			<view :style='{"padding":"0px","margin":"24rpx 0 0px 0","color":"rgb(102, 102, 102)","borderRadius":"0","background":"none","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","order":"2"}' v-html="aboutUsDetail.content"></view>
			<view :style='{"border":"0","padding":"0 30rpx","margin":"40rpx auto 20rpx","borderRadius":"8rpx","textAlign":"center","background":"#a5ccc4","display":"none","width":"auto","lineHeight":"56rpx","order":"3"}'>
			  <text :style='{"color":"#f5f5f5","fontSize":"24rpx"}'>更多</text>
			  <text class="icon iconfont icon-gengduo1" :style='{"color":"#f5f5f5","fontSize":"24rpx"}'></text>
			</view>
			<view :style='{"width":"100%","position":"absolute","top":"-200rpx","background":"url(http://codegen.caihongy.cn/20231220/f7e2906a88da4261917ac452b2a8858c.png) no-repeat center top /100% 100%","display":"none","height":"160rpx"}' />
			<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
		</view>
		<!-- 系统简介 -->
		<view :style='{"padding":"40rpx 24rpx","margin":"20rpx auto","borderRadius":"16rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"calc(100% - 48rpx)","height":"auto","order":"6"}'>
			<view :style='{"padding":"0 0 0 12rpx","margin":"0 auto","borderColor":"#38bf3e","color":"#333","textAlign":"left","background":"none","borderWidth":"0 0 0 4rpx","width":"100%","lineHeight":"36rpx","fontSize":"32rpx","borderStyle":"solid","fontWeight":"600"}'>{{systemIntroductionDetail.title}}</view>
			<view :style='{"padding":"0 0 24rpx","margin":"0 auto 0px","color":"#333","borderRadius":"0 0 40rpx 40rpx","textAlign":"center","background":"none","display":"none","width":"calc(100% - 48rpx)","lineHeight":"1","fontSize":"28rpx"}'>{{systemIntroductionDetail.subtitle}}</view>
			<view :style='{"padding":"0","margin":"20rpx 0 0","borderRadius":"0 0 16rpx 16rpx","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto","order":"2"}'>
				<img :style='{"width":"30%","margin":"0 0px","objectFit":"cover","borderRadius":"40rpx","display":"block","height":"160rpx"}' v-if="systemIntroductionDetail.picture1" :src="baseUrl+systemIntroductionDetail.picture1">
				<img :style='{"width":"30%","margin":"0 0px","objectFit":"cover","borderRadius":"40rpx","display":"block","height":"160rpx"}' v-if="systemIntroductionDetail.picture2" :src="baseUrl+systemIntroductionDetail.picture2">
				<img :style='{"width":"30%","margin":"0 0px","objectFit":"cover","borderRadius":"40rpx","display":"block","height":"160rpx"}' v-if="systemIntroductionDetail.picture3" :src="baseUrl+systemIntroductionDetail.picture3">
			</view>
			<view :style='{"padding":"0","margin":"20rpx 0 0","color":"#333","borderRadius":"0","background":"none","width":"100%","lineHeight":"48rpx","fontSize":"28rpx"}' v-html="systemIntroductionDetail.content"></view>
			<view :style='{"border":"0","padding":"0 30rpx","margin":"0 auto","textAlign":"center","background":"#409EFF","display":"none","width":"auto","lineHeight":"56rpx","order":"3"}'>
			  <text :style='{"color":"#f5f5f5","fontSize":"24rpx"}'>更多</text>
			  <text class="icon iconfont icon-gengduo1" :style='{"color":"#f5f5f5","fontSize":"24rpx"}'></text>
			</view>
			<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
			<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
		</view>
		<!-- 商品推荐 -->
		<view class="listBox recommend" :style='{"width":"calc(100% - 48rpx)","padding":"0","margin":"40rpx auto 40rpx","borderRadius":"16rpx","background":"none","order":"1"}'>
			<view class="title" :style='{"padding":"0 24rpx","margin":"0","textAlign":"center","background":"none","width":"100%","lineHeight":"80rpx","height":"auto"}'>
				<view :style='{"color":"#333","fontSize":"32rpx","fontWeight":"600"}'>旅游景点推荐</view>
			</view>
			<!-- 样式1 -->
			<view class="list-box style1" :style='{"padding":"0","margin":"20rpx 0 0","flexWrap":"wrap","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
				<view @tap="onDetailTap('lvyoujingdian',product.id)" v-for="(product,index) in lvyoujingdianlist" :key="index" class="list-item" :style='{"padding":"0 0 20rpx","margin":"0 0 40rpx","borderRadius":"16rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"48%","height":"auto"}'>
					<view :style='{"width":"100%","padding":"4rpx 20rpx","lineHeight":"1.4","fontSize":"28rpx","color":"#333"}' class="list-item-title ">{{product.jingdianmingcheng}}</view>
					<image :style='{"padding":"0","margin":"0","objectFit":"cover","borderRadius":"16rpx 16rpx 0 0","display":"block","width":"100%","height":"300rpx","order":"-1"}' class="list-item-image" mode="aspectFill" v-if="product.jingdiantupian.substring(0,4)=='http'" :src="product.jingdiantupian"></image>
					<image :style='{"padding":"0","margin":"0","objectFit":"cover","borderRadius":"16rpx 16rpx 0 0","display":"block","width":"100%","height":"300rpx","order":"-1"}' class="list-item-image" mode="aspectFill" v-else :src="product.jingdiantupian?baseUrl+product.jingdiantupian.split(',')[0]:''"></image>
					<view :style='{"width":"100%","padding":"0 20rpx"}'>
					  <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
					  <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.addtime}}</text>
					</view>
					<view :style='{"padding":"0 0px","margin":"0 20rpx","display":"inline-block"}'>
					  <text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
					  <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.thumbsupnum}}</text>
					</view>
					<view :style='{"padding":"0 0px","margin":"0 20rpx","display":"inline-block"}'>
					  <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
					  <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.storeupnum}}</text>
					</view>
					<view :style='{"padding":"0 0px","margin":"0 20rpx","display":"inline-block"}'>
					  <text class="icon iconfont icon-chakan9" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
					  <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.clicknum}}</text>
					</view>
				</view>
			</view>
		</view>
		<!-- 商品推荐 -->
		
		<!-- 商品列表 -->
		<view class="listBox list" :style='{"width":"calc(100% - 48rpx)","padding":"0 0 20rpx","margin":"0px auto","borderRadius":"40rpx 40rpx 16rpx 16rpx","background":"none","order":"3"}'>
			<view class="title" :style='{"padding":"0 32rpx","margin":"0","borderRadius":"16rpx","textAlign":"center","background":"none","display":"block","width":"100%","lineHeight":"80rpx","position":"relative","justifyContent":"space-between","height":"80rpx"}'>
				<view :style='{"color":"#333","fontSize":"32rpx","fontWeight":"600"}'>旅游景点</view>
				<view :style='{"padding":"0 40rpx","top":"0px","borderRadius":"60rpx","background":"none","display":"block","position":"absolute","right":"0px","height":"80rpx"}' @tap="onPageTap('lvyoujingdian')">
				  <text :style='{"color":"#888","fontSize":"26rpx"}'>更多</text>
				  <text class="icon iconfont " :style='{"color":"#fff","fontSize":"26rpx"}'></text>
				</view>
			</view>
		  <!-- 样式1 -->
		  <view class="list-box style1" :style='{"padding":"0","margin":"0","flexWrap":"wrap","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
			<view @tap="onDetailTap('lvyoujingdian',product.id)" v-for="(product,index) in homelvyoujingdianlist" :key="index" class="list-item" :style='{"padding":"0 0 20rpx","margin":"0 0 40rpx","borderRadius":"16rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"48%","height":"auto"}'>
			  <view :style='{"padding":"4rpx 20rpx","overflow":"hidden","whiteSpace":"nowrap","color":"#333","width":"100%","lineHeight":"1.4","fontSize":"28rpx","textOverflow":"ellipsis"}' class="list-item-title ">{{product.jingdianmingcheng}}</view>
			  <image :style='{"padding":"0","margin":"0","objectFit":"cover","borderRadius":"16rpx 16rpx 0 0","display":"block","width":"100%","height":"300rpx","order":"-1"}' class="list-item-image" mode="aspectFill" v-if="product.jingdiantupian.substring(0,4)=='http'" :src="product.jingdiantupian"></image>
			  <image :style='{"padding":"0","margin":"0","objectFit":"cover","borderRadius":"16rpx 16rpx 0 0","display":"block","width":"100%","height":"300rpx","order":"-1"}' class="list-item-image" mode="aspectFill" v-else :src="product.jingdiantupian?baseUrl+product.jingdiantupian.split(',')[0]:''"></image>
			  <view :style='{"padding":"0 20rpx"}'>
			    <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
			    <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.addtime}}</text>
			  </view>
			  <view :style='{"padding":"0 20rpx"}'>
			    <text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
			    <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.thumbsupnum}}</text>
			  </view>
			  <view :style='{"padding":"0 20rpx"}'>
			    <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
			    <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.storeupnum}}</text>
			  </view>
			  <view :style='{"padding":"0 20rpx"}'>
			    <text class="icon iconfont icon-chakan2" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
			    <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.clicknum}}</text>
			  </view>
			</view>
		  </view>
		</view>
		<!-- 商品列表 -->
		<!-- 新闻资讯 -->
		<view class="listBox news" :style='{"width":"calc(100% - 48rpx)","padding":"24rpx 0","margin":"60rpx auto 40rpx","borderRadius":"16rpx","background":"#fff","order":"5"}'>
			<view class="title" :style='{"padding":"0 0 0 12rpx","margin":"0 auto","borderColor":"#38bf3e","textAlign":"left","display":"block","justifyContent":"space-between","background":"none","borderWidth":"0 0 0 4rpx","width":"calc(100% - 48rpx)","lineHeight":"36rpx","position":"relative","borderStyle":"solid","height":"36rpx"}'>
				<view :style='{"color":"#333","fontSize":"32rpx","fontWeight":"600"}'>景点资讯</view>
				<view :style='{"position":"absolute","right":"0px","alignItems":"center","top":"0px","justifyContent":"center","display":"flex"}' @tap="onPageTap('news')">
				  <text :style='{"color":"#888","fontSize":"28rpx"}'>更多</text>
				  <text class="icon iconfont " :style='{"color":"#888","fontSize":"28rpx"}'></text>
				</view>
			</view>
			<!-- 样式3 -->
			<view class="list-box style3" :style='{"width":"100%","padding":"24rpx","margin":"0","color":"#888","height":"auto"}'>
				<view @tap="onNewsDetailTap(item.id)" v-for="(item,index) in news" :key="index" class="list-item" :style='{"border":"0px solid #60982f","padding":"0 0 20rpx","margin":"0 0 20rpx","borderColor":"#eee","flexWrap":"wrap","background":"#fff","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<image v-if="item.picture" :style='{"width":"200rpx","objectFit":"cover","display":"block","height":"220rpx","order":"2"}' class="list-item-image" mode="aspectFill" :src="baseUrl+item.picture"></image>
					<view class="list-item-body" :style='{"width":"calc(100% - 200rpx)","padding":"0","margin":"0","height":"auto"}'>
						<view :style='{"padding":"0 0px","margin":"0","overflow":"hidden","whiteSpace":"nowrap","color":"#000","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis"}' class="list-item-title">{{item.title}}</view>
						<view :style='{"padding":"6rpx 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#888","width":"100%","lineHeight":"1.5","fontSize":"24rpx","textOverflow":"ellipsis"}' class="text">{{item.introduction}}</view>
						<view :style='{"width":"100%","padding":"0 0px"}'>
						  <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"inherit"}'></text>
						  <text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.addtime}}</text>
						</view>
						<view :style='{"width":"100%","padding":"0 0px"}'>
						  <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"inherit"}'></text>
						  <text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.name}}</text>
						</view>
						<view :style='{"padding":"0 0px","margin":"0 10rpx 0 0","display":"inline-block"}'>
						  <text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"inherit"}'></text>
						  <text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.thumbsupnum}}</text>
						</view>
						<view :style='{"padding":"0 0px","margin":"0 10rpx 0 0","display":"inline-block"}'>
						  <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"inherit"}'></text>
						  <text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.storeupnum}}</text>
						</view>
						<view :style='{"padding":"0 0px","display":"inline-block"}'>
						  <text class="icon iconfont icon-chakan2" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"inherit"}'></text>
						  <text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.clicknum}}</text>
						</view>
					</view>
				</view>
			</view>
		</view>
		<!-- 新闻资讯 -->
	</view>
</view>
</template>

<script>
    import menu from '@/utils/menu'
	import '@/assets/css/global-restaurant.css'
	import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
	export default {
		components: {
			uniIcons
		},
		data() {
			return {
				options2: {
					effect: 'flip',
					loop : true
				},
				options3: {
					effect: 'cube',
					loop : true,
					cubeEffect: {
						shadow: true,
						slideShadows: true,
						shadowOffset: 20,
						shadowScale: 0.94,
					}
				},
				rows: 2,
				column: 4,
				iconArr: [
				  'cuIcon-same',
				  'cuIcon-deliver',
				  'cuIcon-evaluate',
				  'cuIcon-shop',
				  'cuIcon-ticket',
				  'cuIcon-cascades',
				  'cuIcon-discover',
				  'cuIcon-question',
				  'cuIcon-pic',
				  'cuIcon-filter',
				  'cuIcon-footprint',
				  'cuIcon-pulldown',
				  'cuIcon-pullup',
				  'cuIcon-moreandroid',
				  'cuIcon-refund',
				  'cuIcon-qrcode',
				  'cuIcon-remind',
				  'cuIcon-profile',
				  'cuIcon-home',
				  'cuIcon-message',
				  'cuIcon-link',
				  'cuIcon-lock',
				  'cuIcon-unlock',
				  'cuIcon-vip',
				  'cuIcon-weibo',
				  'cuIcon-activity',
				  'cuIcon-friendadd',
				  'cuIcon-friendfamous',
				  'cuIcon-friend',
				  'cuIcon-goods',
				  'cuIcon-selection'
				],
                role : '',
                aboutUsDetail: {},
                systemIntroductionDetail: {},
                menuList: [],
                swiperMenuList:[],
                user: {},
                tableName:'',

				//轮播
				swiperList: [],
				lvyoujingdianlist: [],
				homelvyoujingdianlist: [],
				news: [],
			}
		},
		watch: {
		},
		mounted() {
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
        async onLoad(){
            
        },
		async onShow() {
			this.swiperMenuList = []
			this.role = uni.getStorageSync("appRole");
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.user = res.data;
			this.tableName = table;
			let menus = menu.list();
			this.menuList = menus;
			this.menuList.forEach((item,key) => {
			    if(key==0) {
			        item.frontMenu.forEach((item2,key2) => {
			            if(item2.child[0].buttons.indexOf("查看")>-1) {
			                this.swiperMenuList.push(item2);
			            }
			        })
			    }
			})
            // let res;
			// 轮播图
			let swiperList = []
			res = await this.$api.list('config', {
				page: 1,
				limit: 5
			});
			for (let item of res.data.list) {
				if (item.name.indexOf('picture') >= 0 && item.value && item.value!="" && item.value!=null ) {
					swiperList.push({
						img: item.value,
                        title: item.name,
						url: item.url
					});
				}
			}
			if (swiperList) {
				this.swiperList = swiperList;
			}
			

            this.getAboutUs();
            this.getSystemIntroduction();
			// 推荐信息
			this.getRecommendList()
			this.getHomeList()
			this.getNewsList()
		},
		methods: {
			uGetRect(selector, all) {
				return new Promise(resolve => {
					uni.createSelectorQuery()
					.in(this)
					[all ? 'selectAll' : 'select'](selector)
					.boundingClientRect(rect => {
						if (all && Array.isArray(rect) && rect.length) {
							resolve(rect);
						}
						if (!all && rect) {
							resolve(rect);
						}
					})
					.exec();
				});
			},
			cloneData(data) {
				return JSON.parse(JSON.stringify(data));
			},
			newsTabClick2(index){
				this.newsIndex2 = index
				this.getNewsList()
			},
			async getNewsList(){
				let res;
				let params = {
					page: 1,
					limit: 6,
					sort: 'id',
					order: 'desc',
				}
				// 景点资讯
				res = await this.$api.list('news', params)
				this.news = res.data.list
			},
			homeTabClick2(index,name){
				this['home' + name + 'Index2'] = index
				this.getHomeList()
			},
			async getHomeList(){
				let res;
				let params;
				params = {
					page:1,
					limit: 8,
				}
				res = await this.$api.list('lvyoujingdian', params);
				this.homelvyoujingdianlist = res.data.list
			},
			recommendTabClick2(index,name){
				this[name + 'Index2'] = index
				this.getRecommendList()
			},
			async getRecommendList(){
				let res;
				let params;
				// 推荐信息
				params = {
					page: 1,
					limit: 6,
				}
				if(uni.getStorageSync("appUserid")) {
					res = await this.$api.recommend2('lvyoujingdian', params);
				} else {
					res = await this.$api.recommend('lvyoujingdian', params);
				}
				this.lvyoujingdianlist = res.data.list
				

			},
			//轮播图跳转
			onSwiperTap(e) {
				if(e.url) {
					if (e.url.indexOf('https') != -1) {
						// #ifdef MP-WEIXIN
						uni.navigateTo({
						    url: '../../common/linkOthers/linkOthers?url=' + encodeURIComponent(e.url),
						});
						return false
						// #endif
						window.open(e.url)
					} else {
						this.$utils.jump(e.url)
					}
				}
			},
            async getAboutUs() {
                let res = await this.$api.info('aboutus', 1)
                this.aboutUsDetail = res.data;
            },
            async getSystemIntroduction() {
                let res = await this.$api.info('systemintro', 1)
                this.systemIntroductionDetail = res.data;
            },
			// 新闻详情
			onNewsDetailTap(id) {
				this.$utils.jump(`../news-detail/news-detail?id=${id}`)
			},
			// 推荐列表点击详情
			onDetailTap(tableName, id) {
				this.$utils.jump(`../${tableName}/detail?id=${id}`)
			},
			onPageTap(tableName){

				uni.navigateTo({
					url: `../${tableName}/list`,
					fail: function(){
						uni.switchTab({
							url: `../${tableName}/list`
						});
					}
				});
				// this.$utils.jump(`../${tableName}/list`)
			},
            onPageTap2(index) {
				let url = '../' + index + '/list'
				if(index=='forum'){
					url = '../forum-index/forum-index'
				}
                uni.setStorageSync("useridTag",0);
                uni.navigateTo({
                    url: url,
                    fail: function() {
                        uni.switchTab({
                            url: url
                        });
                    }
                });
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
