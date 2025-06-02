<template>
	<div class="home-preview">




		<!-- 新闻资讯 -->
		<div id="animate_newsnews" class="news animate__animated">
			<div class="news_title_box">
				<span class="news_title">公告信息</span>
				<span class="news_subhead">{{'news'.toUpperCase()}}</span>
			</div>
			<div class="list list26 index-pv1">
				<div class="list-body-top">
					<div v-if="newsList.length>0" class="list-item1" @click="toDetail('newsDetail', newsList[0])">
						<div class="img"><img :src="baseUrl + newsList[0].picture" /></div>
						<div class="name">{{newsList[0].title}}</div>
					</div>
					<div class="list-body-right">
						<div v-if="newsList.length>1" class="list-item2" @click="toDetail('newsDetail', newsList[1])">
							<div class="img"><img :src="baseUrl + newsList[1].picture" /></div>
							<div class="news_info">
								<div class="name">{{newsList[1].title}}</div>
								<div class="desc">{{newsList[1].introduction}}</div>
								<span class="time">{{newsList[1].addtime.split(' ')[0]}}</span>
							</div>
						</div>
						<div v-if="newsList.length>2" class="list-item2" @click="toDetail('newsDetail', newsList[2])">
							<div class="img"><img :src="baseUrl + newsList[2].picture" /></div>
							<div class="news_info">
								<div class="name">{{newsList[2].title}}</div>
								<div class="desc">{{newsList[2].introduction}}</div>
								<span class="time">{{newsList[2].addtime.split(' ')[0]}}</span>
							</div>
						</div>
					</div>
				</div>
				<div class="list-body-bottom">
					<div v-for="(item,index) in newsList" v-if="index>2" :key="index" class="list-item3" @click="toDetail('newsDetail', item)">
						<div class="name">{{item.title}}</div>
						<span class="time">{{item.addtime.split(' ')[0]}}</span>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('news')">
				<span class="text">更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
		</div>
		<!-- 新闻资讯 -->
		<!-- 商品推荐 -->
		<div id="animate_recommendzulinfuwu" class="recommend animate__animated">
			<div class="recommend_title_box">
				<span class="recommend_title">租赁服务推荐</span>
				<span class="recommend_subhead">{{'zulinfuwu'.toUpperCase()}} RECOMMEND</span>
			</div>
			<!-- 样式七 -->
			<div class="list list7 index-pv1">
				<div v-if="zulinfuwuRecommend.length>0" class="list-item animation-box" @click="toDetail('zulinfuwuDetail', zulinfuwuRecommend[0])">
					<img v-if="preHttp(zulinfuwuRecommend[0].tupian)" :src="zulinfuwuRecommend[0].tupian.split(',')[0]" alt="" />
					<img v-else :src="baseUrl + (zulinfuwuRecommend[0].tupian?zulinfuwuRecommend[0].tupian.split(',')[0]:'')" alt="" />
					<div class="infoBox">
						<div class="name">{{zulinfuwuRecommend[0].nongjimingcheng}}</div>
						<div class="name">日租价格:{{zulinfuwuRecommend[0].rizujiage}}</div>
						<div class="name">农机状态:{{zulinfuwuRecommend[0].nongjizhuangtai}}</div>
						<div class="time_item">
							<span class="icon iconfont icon-shijian21"></span>
							<span class="label">发布时间：</span>
							<span class="text">{{zulinfuwuRecommend[0].addtime.split(' ')[0]}}</span>
						</div>
						<div class="collect_item">
							<span class="icon iconfont icon-shoucang10"></span>
							<span class="label">收藏量：</span>
							<span class="text">{{zulinfuwuRecommend[0].storeupnum}}</span>
						</div>
					</div>
				</div>
				<div class="list-body1">
					<div v-if="zulinfuwuRecommend.length>1" @click="toDetail('zulinfuwuDetail', zulinfuwuRecommend[1])" class="list-item1 animation-box">
						<img v-if="preHttp(zulinfuwuRecommend[1].tupian)" :src="zulinfuwuRecommend[1].tupian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (zulinfuwuRecommend[1].tupian?zulinfuwuRecommend[1].tupian.split(',')[0]:'')" alt="" />
						<div class="infoBox">
							<div class="name">{{zulinfuwuRecommend[1].nongjimingcheng}}</div>
							<div class="name">日租价格:{{zulinfuwuRecommend[1].rizujiage}}</div>
							<div class="name">农机状态:{{zulinfuwuRecommend[1].nongjizhuangtai}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{zulinfuwuRecommend[1].addtime.split(' ')[0]}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏量：</span>
								<span class="text">{{zulinfuwuRecommend[1].storeupnum}}</span>
							</div>
						</div>
					</div>
					<div v-if="zulinfuwuRecommend.length>2" @click="toDetail('zulinfuwuDetail', zulinfuwuRecommend[2])" class="list-item2 animation-box">
						<img v-if="preHttp(zulinfuwuRecommend[2].tupian)" :src="zulinfuwuRecommend[2].tupian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl +  (zulinfuwuRecommend[2].tupian?zulinfuwuRecommend[2].tupian.split(',')[0]:'')" alt="" />
						<div class="infoBox">
							<div class="name">{{zulinfuwuRecommend[2].nongjimingcheng}}</div>
							<div class="name">日租价格:{{zulinfuwuRecommend[2].rizujiage}}</div>
							<div class="name">农机状态:{{zulinfuwuRecommend[2].nongjizhuangtai}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{zulinfuwuRecommend[2].addtime.split(' ')[0]}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏量：</span>
								<span class="text">{{zulinfuwuRecommend[2].storeupnum}}</span>
							</div>
						</div>
					</div>
				</div>
				<div v-if="zulinfuwuRecommend.length>3" class="list-item3 animation-box" @click="toDetail('zulinfuwuDetail', zulinfuwuRecommend[3])">
					<img v-if="preHttp(zulinfuwuRecommend[3].tupian)" :src="zulinfuwuRecommend[3].tupian.split(',')[0]" alt="" />
					<img v-else :src="baseUrl + (zulinfuwuRecommend[3].tupian?zulinfuwuRecommend[3].tupian.split(',')[0]:'')" alt="" />
					<div class="infoBox">
						<div class="name">{{zulinfuwuRecommend[3].nongjimingcheng}}</div>
						<div class="name">日租价格:{{zulinfuwuRecommend[3].rizujiage}}</div>
						<div class="name">农机状态:{{zulinfuwuRecommend[3].nongjizhuangtai}}</div>
						<div class="time_item">
							<span class="icon iconfont icon-shijian21"></span>
							<span class="label">发布时间：</span>
							<span class="text">{{zulinfuwuRecommend[3].addtime.split(' ')[0]}}</span>
						</div>
						<div class="collect_item">
							<span class="icon iconfont icon-shoucang10"></span>
							<span class="label">收藏量：</span>
							<span class="text">{{zulinfuwuRecommend[3].storeupnum}}</span>
						</div>
					</div>
				</div>
				<div class="list-body2">
					<div v-if="zulinfuwuRecommend.length>4" @click="toDetail('zulinfuwuDetail', zulinfuwuRecommend[4])" class="list-item1 animation-box">
						<img v-if="preHttp(zulinfuwuRecommend[4].tupian)" :src="zulinfuwuRecommend[4].tupian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (zulinfuwuRecommend[4].tupian?zulinfuwuRecommend[4].tupian.split(',')[0]:'')" alt="" />
						<div class="infoBox">
							<div class="name">{{zulinfuwuRecommend[4].nongjimingcheng}}</div>
							<div class="name">日租价格:{{zulinfuwuRecommend[4].rizujiage}}</div>
							<div class="name">农机状态:{{zulinfuwuRecommend[4].nongjizhuangtai}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{zulinfuwuRecommend[4].addtime.split(' ')[0]}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏量：</span>
								<span class="text">{{zulinfuwuRecommend[4].storeupnum}}</span>
							</div>
						</div>
					</div>
					<div v-if="zulinfuwuRecommend.length>5" @click="toDetail('zulinfuwuDetail', zulinfuwuRecommend[5])" class="list-item2 animation-box">
						<img v-if="preHttp(zulinfuwuRecommend[5].tupian)" :src="zulinfuwuRecommend[5].tupian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (zulinfuwuRecommend[5].tupian?zulinfuwuRecommend[5].tupian.split(',')[0]:'')" alt="" />
						<div class="infoBox">
							<div class="name">{{zulinfuwuRecommend[5].nongjimingcheng}}</div>
							<div class="name">日租价格:{{zulinfuwuRecommend[5].rizujiage}}</div>
							<div class="name">农机状态:{{zulinfuwuRecommend[5].nongjizhuangtai}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{zulinfuwuRecommend[5].addtime.split(' ')[0]}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏量：</span>
								<span class="text">{{zulinfuwuRecommend[5].storeupnum}}</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('zulinfuwu')">
				<span class="text">更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
		</div>
		<!-- 商品推荐 -->
		<!-- 特价商品 -->
		<div id="animate_listshiyongjiaoxue" class="lists animate__animated">
			<div class="list_title_box">
				<span class="list_title">使用教学展示</span>
				<span class="list_subhead">{{'shiyongjiaoxue'.toUpperCase()}} SHOW</span>
			</div>
			<!-- 样式七 -->
			<div class="list list7 index-pv1">
				<div v-if="shiyongjiaoxueList.length>0" class="list-item animation-box" @click="toDetail('shiyongjiaoxueDetail', shiyongjiaoxueList[0])">
					<img v-if="preHttp(shiyongjiaoxueList[0].tupian)" :src="shiyongjiaoxueList[0].tupian.split(',')[0]" alt="" />
					<img v-else :src="baseUrl + (shiyongjiaoxueList[0].tupian?shiyongjiaoxueList[0].tupian.split(',')[0]:'')" alt="" />
					<div class="infoBox">
						<div class="name">{{shiyongjiaoxueList[0].nongjimingcheng}}</div>
						<div class="name">型号:{{shiyongjiaoxueList[0].xinghao}}</div>
						<div class="time_item">
							<span class="icon iconfont icon-shijian21"></span>
							<span class="label">发布时间：</span>
							<span class="text">{{shiyongjiaoxueList[0].addtime}}</span>
						</div>
						<div class="collect_item">
							<span class="icon iconfont icon-shoucang10"></span>
							<span class="label">收藏量：</span>
							<span class="text">{{shiyongjiaoxueList[0].storeupnum}}</span>
						</div>
					</div>
				</div>
				<div class="list-body1">
					<div v-if="shiyongjiaoxueList.length>1" @click="toDetail('shiyongjiaoxueDetail', shiyongjiaoxueList[1])" class="list-item1 animation-box">
						<img v-if="preHttp(shiyongjiaoxueList[1].tupian)" :src="shiyongjiaoxueList[1].tupian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (shiyongjiaoxueList[1].tupian?shiyongjiaoxueList[1].tupian.split(',')[0]:'')" alt="" />
						<div class="infoBox">
							<div class="name">{{shiyongjiaoxueList[1].nongjimingcheng}}</div>
							<div class="name">型号:{{shiyongjiaoxueList[1].xinghao}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{shiyongjiaoxueList[1].addtime}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏量：</span>
								<span class="text">{{shiyongjiaoxueList[1].storeupnum}}</span>
							</div>
						</div>
					</div>
					<div v-if="shiyongjiaoxueList.length>2" @click="toDetail('shiyongjiaoxueDetail', shiyongjiaoxueList[2])" class="list-item2 animation-box">
						<img v-if="preHttp(shiyongjiaoxueList[2].tupian)" :src="shiyongjiaoxueList[2].tupian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl +  (shiyongjiaoxueList[2].tupian?shiyongjiaoxueList[2].tupian.split(',')[0]:'')" alt="" />
						<div class="infoBox">
							<div class="name">{{shiyongjiaoxueList[2].nongjimingcheng}}</div>
							<div class="name">型号:{{shiyongjiaoxueList[2].xinghao}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{shiyongjiaoxueList[2].addtime}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏量：</span>
								<span class="text">{{shiyongjiaoxueList[2].storeupnum}}</span>
							</div>
						</div>
					</div>
				</div>
				<div v-if="shiyongjiaoxueList.length>3" class="list-item3 animation-box" @click="toDetail('shiyongjiaoxueDetail', shiyongjiaoxueList[3])">
					<img v-if="preHttp(shiyongjiaoxueList[3].tupian)" :src="shiyongjiaoxueList[3].tupian.split(',')[0]" alt="" />
					<img v-else :src="baseUrl + (shiyongjiaoxueList[3].tupian?shiyongjiaoxueList[3].tupian.split(',')[0]:'')" alt="" />
					<div class="infoBox">
						<div class="name">{{shiyongjiaoxueList[3].nongjimingcheng}}</div>
						<div class="name">型号:{{shiyongjiaoxueList[3].xinghao}}</div>
						<div class="time_item">
							<span class="icon iconfont icon-shijian21"></span>
							<span class="label">发布时间：</span>
							<span class="text">{{shiyongjiaoxueList[3].addtime}}</span>
						</div>
						<div class="collect_item">
							<span class="icon iconfont icon-shoucang10"></span>
							<span class="label">收藏量：</span>
							<span class="text">{{shiyongjiaoxueList[3].storeupnum}}</span>
						</div>
					</div>
				</div>
				<div class="list-body2">
					<div v-if="shiyongjiaoxueList.length>4" @click="toDetail('shiyongjiaoxueDetail', shiyongjiaoxueList[4])" class="list-item1 animation-box">
						<img v-if="preHttp(shiyongjiaoxueList[4].tupian)" :src="shiyongjiaoxueList[4].tupian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (shiyongjiaoxueList[4].tupian?shiyongjiaoxueList[4].tupian.split(',')[0]:'')" alt="" />
						<div class="infoBox">
							<div class="name">{{shiyongjiaoxueList[4].nongjimingcheng}}</div>
							<div class="name">型号:{{shiyongjiaoxueList[4].xinghao}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{shiyongjiaoxueList[4].addtime}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏量：</span>
								<span class="text">{{shiyongjiaoxueList[4].storeupnum}}</span>
							</div>
						</div>
					</div>
					<div v-if="shiyongjiaoxueList.length>5" @click="toDetail('shiyongjiaoxueDetail', shiyongjiaoxueList[5])" class="list-item2 animation-box">
						<img v-if="preHttp(shiyongjiaoxueList[5].tupian)" :src="shiyongjiaoxueList[5].tupian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (shiyongjiaoxueList[5].tupian?shiyongjiaoxueList[5].tupian.split(',')[0]:'')" alt="" />
						<div class="infoBox">
							<div class="name">{{shiyongjiaoxueList[5].nongjimingcheng}}</div>
							<div class="name">型号:{{shiyongjiaoxueList[5].xinghao}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{shiyongjiaoxueList[5].addtime}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏量：</span>
								<span class="text">{{shiyongjiaoxueList[5].storeupnum}}</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('shiyongjiaoxue')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
	

		</div>
		<!-- 特价商品 -->
	</div>
</template>

<script>
import 'animate.css'
import Swiper from "swiper";

	export default {
		//数据集合
		data() {
			return {
				baseUrl: '',
				newsList: [],
				zulinfuwuRecommend: [],

				shiyongjiaoxueList: [],




			}
		},
		created() {
			this.baseUrl = this.$config.baseUrl;
			this.getNewsList();
			this.getList();
		},
		mounted() {
			window.addEventListener('scroll', this.handleScroll)
			setTimeout(()=>{
				this.handleScroll()
			},100)
			
			this.swiperChanges()
		},
		beforeDestroy() {
			window.removeEventListener('scroll', this.handleScroll)
		},
		//方法集合
		methods: {
			swiperChanges() {
				setTimeout(()=>{
				},750)
			},


			handleScroll() {
				let arr = [
					{id:'about',css:'animate__'},
					{id:'system',css:'animate__'},
					{id:'animate_recommendzulinfuwu',css:'animate__'},
					{id:'animate_listshiyongjiaoxue',css:'animate__'},
					{id:'animate_newsnews',css:'animate__'},
				]
			
				for (let i in arr) {
					let doc = document.getElementById(arr[i].id)
					if (doc) {
						let top = doc.offsetTop
						let win_top = window.innerHeight + window.pageYOffset
						// console.log(top,win_top)
						if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
							// console.log(doc)
							doc.classList.add(arr[i].css)
						}
					}
				}
			},
			preHttp(str) {
				return str && str.substr(0,4)=='http';
			},
			preHttp2(str) {
				return str && str.split(',w').length>1;
			},
			getNewsList() {
				let data = {
					page: 1,
					limit: 9,
					sort: 'addtime',
					order: 'desc'
				}
				this.$http.get('news/list', {params: data}).then(res => {
					if (res.data.code == 0) {
						this.newsList = res.data.data.list;
					
					}
				});
			},
			getList() {
				let autoSortUrl = "";
				let data = {}
				autoSortUrl = "zulinfuwu/autoSort";
				if(localStorage.getItem('frontToken')) {
					autoSortUrl = "zulinfuwu/autoSort2";
				}
				data = {
					page: 1,
					limit: 6,
				}
				this.$http.get(autoSortUrl, {params: data}).then(res => {
					if (res.data.code == 0) {
						this.zulinfuwuRecommend = res.data.data.list;
					}
				});
			
				data = {
					page: 1,
					limit: 6,
				}

				this.$http.get('shiyongjiaoxue/list', {params: data}).then(res => {
					if (res.data.code == 0) {
						this.shiyongjiaoxueList = res.data.data.list;
					}
				});
			},
			toDetail(path, item) {
				this.$router.push({path: '/index/' + path, query: {id: item.id}});
			},
			moreBtn(path) {
				this.$router.push({path: '/index/' + path});
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
		padding: 30px 0;
		margin: 0;
		flex-direction: column;
		display: flex;
		width: 100%;
		.news {
			padding: 0 calc(50% - 600px);
			margin: 30px 0 0;
			background: none;
			width: 100%;
			position: relative;
			order: 4;
			.news_title_box {
				padding: 0 0 0 50px;
				margin: 0 0 20px 0;
				background: url(http://codegen.caihongy.cn/20250120/bd3f11cd39054b2c9983b54078a7d4c6.png) no-repeat left center;
				width: auto;
				line-height: 44px;
				text-align: left;
				.news_title {
					color: #1B2233;
					font-weight: 600;
					font-size: 22px;
				}
				.news_subhead {
					margin: 0 0 10px;
					color: #999;
					display: none;
					width: 100%;
					font-size: 20px;
					line-height: 1.5;
					text-align: center;
				}
			}
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1.1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list26 {
				padding: 60px 0;
				margin: 0 auto;
				overflow: hidden;
				background: none;
				width: 100%;
				.list-body-top {
					margin: 30px 0 0;
					overflow: hidden;
					display: flex;
					gap: 0 20px;
					width: 100%;
					justify-content: space-between;
					align-items: flex-start;
					height: auto;
					.list-item1 {
						cursor: pointer;
						padding: 45px 20px;
						background: url(http://codegen.caihongy.cn/20250203/26eb899502cf420f8136d731514797fc.png) no-repeat center / 100% 100%;
						width: 50%;
						height: 340px;
						.img {
							overflow: hidden;
							width: 100%;
							height: 220px;
							img {
								transform: scale(1);
								object-fit: cover;
								width: 100%;
								transition: all 1s ease 0s;
								height: 100%;
							}
						}
						.name {
							margin: 10px 0 0;
							overflow: hidden;
							color: #666;
							white-space: nowrap;
							background: #f0f0f0;
							width: 100%;
							font-size: 16px;
							line-height: 40px;
							text-overflow: ellipsis;
							transition: all 0.3s ease 0s;
							text-align: center;
							height: 40px;
						}
					}
					.list-item1:hover {
						.img {
							img {
								transform: scale(1.05);
								transition: all 1s ease 0s;
							}
						}
						.name {
							color: #fff;
							background: #0E667D;
						}
					}
					.list-body-right {
						overflow: hidden;
						flex-direction: column;
						display: flex;
						gap: 20px 0;
						width: 50%;
						justify-content: space-between;
						height: 100%;
						.list-item2 {
							cursor: pointer;
							padding: 18px;
							background: url(http://codegen.caihongy.cn/20250203/c4f8cba4ee684a058b204e81496867fe.png) no-repeat center / 100% 100%;
							display: flex;
							width: 100%;
							align-items: center;
							transition: all 0.3s ease 0s;
							height: 160px;
							.img {
								flex: none;
								width: 168px;
								height: 124px;
								img {
									transform: scale(1);
									object-fit: cover;
									width: 100%;
									transition: all 1s ease 0s;
									height: 100%;
								}
							}
							.news_info {
								margin: 0 0 0 20px;
								.name {
									color: #4d4d4d;
									width: 100%;
									font-size: 16px;
									line-height: 30px;
									transition: all 0.3s ease 0s;
									height: 30px;
								}
								.desc {
									margin: 10px 0;
									overflow: hidden;
									color: #666;
									width: 100%;
									font-size: 14px;
									line-height: 24px;
									transition: all 0.3s ease 0s;
									height: 48px;
								}
								.time {
									color: #666;
									font-size: 14px;
									transition: all 0.3s ease 0s;
								}
							}
						}
						.list-item2:hover {
							background: #0E667D;
							.img {
								img {
									transform: scale(1.05);
								}
							}
							.news_info {
								.name {
									color: #fff;
								}
								.desc {
									color: #fff;
								}
								.time {
									color: #fff;
								}
							}
						}
					}
				}
				.list-body-bottom {
					margin: 30px 0 0;
					display: flex;
					gap: 20px 30px;
					width: 100%;
					flex-wrap: wrap;
					height: auto;
					.list-item3 {
						cursor: pointer;
						padding: 0px 10px;
						margin: 0;
						background: url(http://codegen.caihongy.cn/20250203/f50c7023aae74e9bb3f5886e1c4ffc0b.png) no-repeat center / 100%100%;
						display: flex;
						width: calc(33.33% - 20px);
						transition: all 0.3s ease 0s;
						height: 60px;
						.name {
							padding: 0 0 0 30px;
							overflow: hidden;
							color: #666;
							white-space: nowrap;
							width: 270px;
							font-size: 14px;
							line-height: 60px;
							text-overflow: ellipsis;
							transition: all 0.3s ease 0s;
							height: 60px;
						}
						.time {
							color: #666;
							font-size: 12px;
							line-height: 60px;
							transition: all 0.3s ease 0s;
						}
					}
					.list-item3:hover {
						background: #0E667D;
						.name {
							color: #fff;
						}
						.time {
							color: #fff;
						}
					}
				}
			}
			.moreBtn {
				border: 0;
				cursor: pointer;
				margin: 0;
				top: 0;
				background: #0E667D;
				display: block;
				width: 80px;
				line-height: 44px;
				position: absolute;
				right: calc(50% - 600px);
				text-align: center;
				.text {
					color: #f5f5f5;
					font-size: 12px;
				}
				.icon {
					color: #f5f5f5;
					font-size: 12px;
				}
			}
		}
		.recommend {
			padding: 30px calc(50% - 600px);
			margin: 30px 0 0;
			background: linear-gradient(to bottom, #fff 50%, #E2EFF5 50%);
			width: 100%;
			position: relative;
			order: 5;
			.recommend_title_box {
				padding: 0 0 0 50px;
				margin: 0 0 20px 0;
				background: url(http://codegen.caihongy.cn/20250120/bd3f11cd39054b2c9983b54078a7d4c6.png) no-repeat left center;
				width: auto;
				line-height: 44px;
				text-align: left;
				.recommend_title {
					color: #1B2233;
					font-weight: 600;
					font-size: 22px;
				}
				.recommend_subhead {
					margin: 0 0 10px;
					color: #999;
					display: none;
					width: 100%;
					font-size: 20px;
					line-height: 1.5;
					text-align: center;
				}
			}
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list7 {
				padding: 0;
				background: none;
				display: flex;
				width: 100%;
				height: auto;
				.list-item {
					padding: 40px 15px 20px 15px;
					margin: 0;
					background: url(http://codegen.caihongy.cn/20250203/dc4b91e3c07242f7af219ef033e26289.png) no-repeat center / 100% 100%;
					width: 275px;
					position: relative;
					height: 570px;
					img {
						object-fit: cover;
						width: 100%;
						float: left;
						height: 100%;
					}
					.infoBox {
						left: 0;
						bottom: 0;
						background: rgba(0,0,0,.3);
						width: 100%;
						position: absolute;
						.name {
							padding: 0 10px;
							color: #fff;
							font-size: 16px;
							line-height: 24px;
						}
						.price {
							padding: 10px;
							color: #f00;
							font-size: 13px;
							line-height: 1.5;
						}
						.time_item {
							padding: 0 10px;
							.icon {
								margin: 0 2px 0 0;
								color: #fff;
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
							padding: 0 10px;
							.icon {
								margin: 0 2px 0 0;
								color: #fff;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #fff;
								font-size: 12px;
								line-height: 1.5;
							}
						}
						.like_item {
							padding: 0 10px;
							.icon {
								margin: 0 2px 0 0;
								color: #fff;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #fff;
								font-size: 12px;
								line-height: 1.5;
							}
						}
						.collect_item {
							padding: 0 10px;
							.icon {
								margin: 0 2px 0 0;
								color: #fff;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #fff;
								font-size: 12px;
								line-height: 1.5;
							}
						}
						.view_item {
							padding: 0 10px;
							.icon {
								margin: 0 2px 0 0;
								color: #fff;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #fff;
								font-size: 12px;
								line-height: 1.5;
							}
						}
					}
				}
				.list-body1 {
					margin: 0 10px;
					width: 275px;
					height: auto;
					.list-item1 {
						padding: 45px 15px 20px 15px;
						margin: 0 0 20px;
						background: url(http://codegen.caihongy.cn/20250203/1fb617c0bdee4ecf826a2fe678c30109.png) no-repeat center / 100%100%;
						width: 275px;
						position: relative;
						height: 275px;
						img {
							object-fit: cover;
							width: 100%;
							float: left;
							height: 100%;
						}
						.infoBox {
							left: 0;
							bottom: 0;
							background: rgba(0,0,0,.3);
							width: 100%;
							position: absolute;
							.name {
								padding: 0 10px;
								color: #fff;
								font-size: 16px;
								line-height: 24px;
							}
							.price {
								padding: 10px;
								color: #f00;
								font-size: 13px;
								line-height: 1.5;
							}
							.time_item {
								padding: 0 10px;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
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
								padding: 0 10px;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0 10px;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0 10px;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0 10px;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
						}
					}
					.list-item2 {
						padding: 45px 15px 20px 15px;
						margin: 20px 0 0;
						background: url(http://codegen.caihongy.cn/20250203/1fb617c0bdee4ecf826a2fe678c30109.png) no-repeat center / 100%100%;
						width: 275px;
						position: relative;
						height: 275px;
						img {
							object-fit: cover;
							width: 100%;
							float: left;
							height: 100%;
						}
						.infoBox {
							left: 0;
							bottom: 0;
							background: rgba(0,0,0,.3);
							width: 100%;
							position: absolute;
							.name {
								padding: 0 10px;
								color: #fff;
								font-size: 16px;
								line-height: 24px;
							}
							.price {
								padding: 10px;
								color: #f00;
								font-size: 13px;
								line-height: 1.5;
							}
							.time_item {
								padding: 0 10px;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
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
								padding: 0 10px;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0 10px;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0 10px;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0 10px;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
						}
					}
				}
				.list-item3 {
					padding: 40px 15px 20px 15px;
					margin: 0;
					background: url(http://codegen.caihongy.cn/20250203/dc4b91e3c07242f7af219ef033e26289.png) no-repeat center / 100% 100%;
					width: 275px;
					position: relative;
					height: 570px;
					img {
						object-fit: cover;
						width: 100%;
						float: left;
						height: 100%;
					}
					.infoBox {
						left: 0;
						bottom: 0;
						background: rgba(0,0,0,.3);
						width: 100%;
						position: absolute;
						.name {
							padding: 0 10px;
							color: #fff;
							font-size: 16px;
							line-height: 24px;
						}
						.price {
							padding: 10px;
							color: #f00;
							font-size: 13px;
							line-height: 1.5;
						}
						.time_item {
							padding: 0 10px;
							.icon {
								margin: 0 2px 0 0;
								color: #fff;
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
							padding: 0 10px;
							.icon {
								margin: 0 2px 0 0;
								color: #fff;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #fff;
								font-size: 12px;
								line-height: 1.5;
							}
						}
						.like_item {
							padding: 0 10px;
							.icon {
								margin: 0 2px 0 0;
								color: #fff;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #fff;
								font-size: 12px;
								line-height: 1.5;
							}
						}
						.collect_item {
							padding: 0 10px;
							.icon {
								margin: 0 2px 0 0;
								color: #fff;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #fff;
								font-size: 12px;
								line-height: 1.5;
							}
						}
						.view_item {
							padding: 0 10px;
							.icon {
								margin: 0 2px 0 0;
								color: #fff;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #fff;
								font-size: 12px;
								line-height: 1.5;
							}
						}
					}
				}
				.list-body2 {
					margin: 0 10px;
					width: 275px;
					height: auto;
					.list-item1 {
						padding: 45px 15px 20px 15px;
						margin: 0 0 20px;
						background: url(http://codegen.caihongy.cn/20250203/1fb617c0bdee4ecf826a2fe678c30109.png) no-repeat center / 100%100%;
						width: 275px;
						position: relative;
						height: 275px;
						img {
							object-fit: cover;
							width: 100%;
							float: left;
							height: 100%;
						}
						.infoBox {
							left: 0;
							bottom: 0;
							background: rgba(0,0,0,.3);
							width: 100%;
							position: absolute;
							.name {
								padding: 0 10px;
								color: #fff;
								font-size: 16px;
								line-height: 24px;
							}
							.price {
								padding: 10px;
								color: #f00;
								font-size: 13px;
								line-height: 1.5;
							}
							.time_item {
								padding: 0 10px;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
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
								padding: 0 10px;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0 10px;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0 10px;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0 10px;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
						}
					}
					.list-item2 {
						padding: 45px 15px 20px 15px;
						margin: 20px 0 0;
						background: url(http://codegen.caihongy.cn/20250203/1fb617c0bdee4ecf826a2fe678c30109.png) no-repeat center / 100%100%;
						width: 275px;
						position: relative;
						height: 275px;
						img {
							object-fit: cover;
							width: 100%;
							float: left;
							height: 100%;
						}
						.infoBox {
							left: 0;
							bottom: 0;
							background: rgba(0,0,0,.3);
							width: 100%;
							position: absolute;
							.name {
								padding: 0 10px;
								color: #fff;
								font-size: 16px;
								line-height: 24px;
							}
							.price {
								padding: 10px;
								color: #f00;
								font-size: 13px;
								line-height: 1.5;
							}
							.time_item {
								padding: 0 10px;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
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
								padding: 0 10px;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0 10px;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0 10px;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0 10px;
								.icon {
									margin: 0 2px 0 0;
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #fff;
									font-size: 12px;
									line-height: 1.5;
								}
							}
						}
					}
				}
			}
			.moreBtn {
				border: 0;
				cursor: pointer;
				margin: 0;
				top: 30px;
				background: #0E667D;
				display: block;
				width: 80px;
				line-height: 44px;
				position: absolute;
				right: calc(50% - 600px);
				text-align: center;
				.text {
					color: #f5f5f5;
					font-size: 12px;
				}
				.icon {
					color: #f5f5f5;
					font-size: 12px;
				}
			}
		}
		.lists {
			padding: 0 calc(50% - 600px);
			margin: 30px 0 0;
			background: none;
			width: 100%;
			position: relative;
			order: 2;
			.list_title_box {
				padding: 0 0 0 50px;
				margin: 0 0 20px 0;
				background: url(http://codegen.caihongy.cn/20250120/bd3f11cd39054b2c9983b54078a7d4c6.png) no-repeat left center;
				width: auto;
				line-height: 44px;
				text-align: left;
				.list_title {
					color: #1B2233;
					font-weight: 600;
					font-size: 22px;
				}
				.list_subhead {
					margin: 0 0 10px;
					color: #999;
					display: none;
					width: 100%;
					font-size: 20px;
					line-height: 1.5;
					text-align: center;
				}
			}
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list7 {
				padding: 0;
				background: none;
				display: flex;
				width: 100%;
				flex-wrap: wrap;
				height: auto;
				.list-item {
					padding: 45px 15px 15px 15px;
					margin: 0 15px 0 0;
					background: url(http://codegen.caihongy.cn/20250120/cda3caa3753b4d459e8389845e833094.png) no-repeat center / 100% 100%;
					width: calc(50% - 15px);
					position: relative;
					height: auto;
					order: 1;
					img {
						object-fit: cover;
						width: 100%;
						height: 220px;
					}
					.infoBox {
						background: #fff;
						width: 100%;
						position: relative;
						.name {
							padding: 0;
							color: #000000;
							font-size: 16px;
							line-height: 24px;
						}
						.price {
							padding: 0;
							color: #f00;
							font-size: 14px;
							line-height: 24px;
						}
						.time_item {
							padding: 0;
							.icon {
								margin: 0 2px 0 0;
								color: #000;
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
							padding: 0 10px 0 0;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								color: #4B3E39;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #4B3E39;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #4B3E39;
								font-size: 12px;
								line-height: 1.5;
							}
						}
						.like_item {
							padding: 0 10px 0 0;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								color: #4B3E39;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #4B3E39;
								font-size: 12px;
								line-height: 1.5;
							}
						}
						.collect_item {
							padding: 0 10px 0 0;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								color: #4B3E39;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #4B3E39;
								font-size: 12px;
								line-height: 1.5;
							}
						}
						.view_item {
							padding: 0 10px 0 0;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								color: #4B3E39;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #4B3E39;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #4B3E39;
								font-size: 12px;
								line-height: 1.5;
							}
						}
					}
				}
				.list-body1 {
					margin: 0;
					display: flex;
					width: 50%;
					height: auto;
					order: 2;
					.list-item1 {
						padding: 45px 15px 15px 15px;
						margin: 0 10px 0 0;
						background: url(http://codegen.caihongy.cn/20250120/5150ec13af694a299dbf74a78d956a6c.png) center / 100% 100%;
						width: calc(50% - 10px);
						position: relative;
						height: auto;
						img {
							object-fit: cover;
							width: 100%;
							float: left;
							height: 220px;
						}
						.infoBox {
							background: #fff;
							width: 100%;
							.name {
								padding: 0;
								color: #000;
								font-size: 16px;
								line-height: 24px;
							}
							.price {
								padding: 0;
								color: #f00;
								font-size: 14px;
								line-height: 24px;
							}
							.time_item {
								padding: 0;
								.icon {
									margin: 0 2px 0 0;
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.publisher_item {
								padding: 0 10px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0 10px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0 10px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0 10px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
							}
						}
					}
					.list-item2 {
						padding: 45px 15px 15px 15px;
						margin: 0;
						background: url(http://codegen.caihongy.cn/20250120/5150ec13af694a299dbf74a78d956a6c.png) center / 100% 100%;
						width: 50%;
						position: relative;
						height: auto;
						img {
							object-fit: cover;
							width: 100%;
							float: left;
							height: 220px;
						}
						.infoBox {
							background: #fff;
							width: 100%;
							.name {
								padding: 0;
								color: #000;
								font-size: 16px;
								line-height: 24px;
							}
							.price {
								padding: 0;
								color: #f00;
								font-size: 14px;
								line-height: 24px;
							}
							.time_item {
								padding: 0;
								.icon {
									margin: 0 2px 0 0;
									color: #4B3E39;
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
								padding: 0 10px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0 10px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0 10px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0 10px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
							}
						}
					}
				}
				.list-item3 {
					padding: 45px 15px 15px 15px;
					margin: 20px 0 0;
					background: url(http://codegen.caihongy.cn/20250120/cda3caa3753b4d459e8389845e833094.png) no-repeat center / 100% 100%;
					width: 50%;
					position: relative;
					height: auto;
					order: 4;
					img {
						object-fit: cover;
						width: 100%;
						float: left;
						height: 220px;
					}
					.infoBox {
						background: none;
						width: 100%;
						.name {
							padding: 0;
							color: #000000;
							font-size: 16px;
							line-height: 24px;
						}
						.price {
							padding: 0;
							color: #f00;
							font-size: 14px;
							line-height: 24px;
						}
						.time_item {
							padding: 0;
							.icon {
								margin: 0 2px 0 0;
								color: #4B3E39;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #4B3E39;
								font-size: 12px;
								line-height: 1.5;
							}
						}
						.publisher_item {
							padding: 0 10px 0 0;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								color: #4B3E39;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #4B3E39;
								font-size: 12px;
								line-height: 1.5;
							}
						}
						.like_item {
							padding: 0 10px 0 0;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								color: #4B3E39;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #4B3E39;
								font-size: 12px;
								line-height: 1.5;
							}
						}
						.collect_item {
							padding: 0 10px 0 0;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								color: #4B3E39;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #4B3E39;
								font-size: 12px;
								line-height: 1.5;
							}
						}
						.view_item {
							padding: 0 10px 0 0;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								color: #4B3E39;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #4B3E39;
								font-size: 12px;
								line-height: 1.5;
							}
						}
					}
				}
				.list-body2 {
					margin: 20px 15px 0 0;
					display: flex;
					width: calc(50% - 15px);
					height: auto;
					order: 3;
					.list-item1 {
						padding: 45px 15px 15px 15px;
						margin: 0 10px 0 0;
						background: url(http://codegen.caihongy.cn/20250120/5150ec13af694a299dbf74a78d956a6c.png) center / 100% 100%;
						width: calc(50% - 10px);
						position: relative;
						height: auto;
						img {
							object-fit: cover;
							width: 100%;
							float: left;
							height: 220px;
						}
						.infoBox {
							width: 100%;
							.name {
								padding: 0;
								color: #000;
								font-size: 16px;
								line-height: 24px;
							}
							.price {
								padding: 0;
								color: #f00;
								font-size: 14px;
								line-height: 24px;
							}
							.time_item {
								padding: 0;
								.icon {
									margin: 0 2px 0 0;
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.publisher_item {
								padding: 0 10px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0 10px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0 10px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0 10px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
							}
						}
					}
					.list-item2 {
						padding: 45px 15px 15px 15px;
						margin: 0;
						background: url(http://codegen.caihongy.cn/20250120/5150ec13af694a299dbf74a78d956a6c.png) center / 100% 100%;
						width: 50%;
						position: relative;
						height: auto;
						img {
							object-fit: cover;
							width: 100%;
							float: left;
							height: 220px;
						}
						.infoBox {
							width: 100%;
							.name {
								padding: 0;
								color: #000;
								font-size: 16px;
								line-height: 24px;
							}
							.price {
								padding: 0;
								color: #f00;
								font-size: 14px;
								line-height: 24px;
							}
							.time_item {
								padding: 0;
								.icon {
									margin: 0 2px 0 0;
									color: #4B3E39;
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
								padding: 0 10px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0 10px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0 10px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0 10px 0 0;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #4B3E39;
									font-size: 12px;
									line-height: 1.5;
								}
							}
						}
					}
				}
			}
			.moreBtn {
				border: 0;
				cursor: pointer;
				margin: 0;
				top: 0;
				background: #0E667D;
				display: block;
				width: 80px;
				line-height: 44px;
				position: absolute;
				right: calc(50% - 600px);
				text-align: center;
				.text {
					color: #f5f5f5;
					font-size: 12px;
				}
				.icon {
					color: #f5f5f5;
					font-size: 12px;
				}
			}
		}
	}
</style>
