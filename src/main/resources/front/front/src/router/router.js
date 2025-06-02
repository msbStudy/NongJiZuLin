import VueRouter from 'vue-router'
//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import weixiurenyuanList from '../pages/weixiurenyuan/list'
import weixiurenyuanDetail from '../pages/weixiurenyuan/detail'
import weixiurenyuanAdd from '../pages/weixiurenyuan/add'
import nongjileixingList from '../pages/nongjileixing/list'
import nongjileixingDetail from '../pages/nongjileixing/detail'
import nongjileixingAdd from '../pages/nongjileixing/add'
import zulinfuwuList from '../pages/zulinfuwu/list'
import zulinfuwuDetail from '../pages/zulinfuwu/detail'
import zulinfuwuAdd from '../pages/zulinfuwu/add'
import nongjizulinList from '../pages/nongjizulin/list'
import nongjizulinDetail from '../pages/nongjizulin/detail'
import nongjizulinAdd from '../pages/nongjizulin/add'
import nongjiguihaiList from '../pages/nongjiguihai/list'
import nongjiguihaiDetail from '../pages/nongjiguihai/detail'
import nongjiguihaiAdd from '../pages/nongjiguihai/add'
import pingjiafankuiList from '../pages/pingjiafankui/list'
import pingjiafankuiDetail from '../pages/pingjiafankui/detail'
import pingjiafankuiAdd from '../pages/pingjiafankui/add'
import shiyongjiaoxueList from '../pages/shiyongjiaoxue/list'
import shiyongjiaoxueDetail from '../pages/shiyongjiaoxue/detail'
import shiyongjiaoxueAdd from '../pages/shiyongjiaoxue/add'
import weixiushenqingList from '../pages/weixiushenqing/list'
import weixiushenqingDetail from '../pages/weixiushenqing/detail'
import weixiushenqingAdd from '../pages/weixiushenqing/add'
import weixiufenpeiList from '../pages/weixiufenpei/list'
import weixiufenpeiDetail from '../pages/weixiufenpei/detail'
import weixiufenpeiAdd from '../pages/weixiufenpei/add'
import weixiuwanchengList from '../pages/weixiuwancheng/list'
import weixiuwanchengDetail from '../pages/weixiuwancheng/detail'
import weixiuwanchengAdd from '../pages/weixiuwancheng/add'
import nongjisuocheList from '../pages/nongjisuoche/list'
import nongjisuocheDetail from '../pages/nongjisuoche/detail'
import nongjisuocheAdd from '../pages/nongjisuoche/add'
import syslogList from '../pages/syslog/list'
import syslogDetail from '../pages/syslog/detail'
import syslogAdd from '../pages/syslog/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'weixiurenyuan',
					component: weixiurenyuanList
				},
				{
					path: 'weixiurenyuanDetail',
					component: weixiurenyuanDetail
				},
				{
					path: 'weixiurenyuanAdd',
					component: weixiurenyuanAdd
				},
				{
					path: 'nongjileixing',
					component: nongjileixingList
				},
				{
					path: 'nongjileixingDetail',
					component: nongjileixingDetail
				},
				{
					path: 'nongjileixingAdd',
					component: nongjileixingAdd
				},
				{
					path: 'zulinfuwu',
					component: zulinfuwuList
				},
				{
					path: 'zulinfuwuDetail',
					component: zulinfuwuDetail
				},
				{
					path: 'zulinfuwuAdd',
					component: zulinfuwuAdd
				},
				{
					path: 'nongjizulin',
					component: nongjizulinList
				},
				{
					path: 'nongjizulinDetail',
					component: nongjizulinDetail
				},
				{
					path: 'nongjizulinAdd',
					component: nongjizulinAdd
				},
				{
					path: 'nongjiguihai',
					component: nongjiguihaiList
				},
				{
					path: 'nongjiguihaiDetail',
					component: nongjiguihaiDetail
				},
				{
					path: 'nongjiguihaiAdd',
					component: nongjiguihaiAdd
				},
				{
					path: 'pingjiafankui',
					component: pingjiafankuiList
				},
				{
					path: 'pingjiafankuiDetail',
					component: pingjiafankuiDetail
				},
				{
					path: 'pingjiafankuiAdd',
					component: pingjiafankuiAdd
				},
				{
					path: 'shiyongjiaoxue',
					component: shiyongjiaoxueList
				},
				{
					path: 'shiyongjiaoxueDetail',
					component: shiyongjiaoxueDetail
				},
				{
					path: 'shiyongjiaoxueAdd',
					component: shiyongjiaoxueAdd
				},
				{
					path: 'weixiushenqing',
					component: weixiushenqingList
				},
				{
					path: 'weixiushenqingDetail',
					component: weixiushenqingDetail
				},
				{
					path: 'weixiushenqingAdd',
					component: weixiushenqingAdd
				},
				{
					path: 'weixiufenpei',
					component: weixiufenpeiList
				},
				{
					path: 'weixiufenpeiDetail',
					component: weixiufenpeiDetail
				},
				{
					path: 'weixiufenpeiAdd',
					component: weixiufenpeiAdd
				},
				{
					path: 'weixiuwancheng',
					component: weixiuwanchengList
				},
				{
					path: 'weixiuwanchengDetail',
					component: weixiuwanchengDetail
				},
				{
					path: 'weixiuwanchengAdd',
					component: weixiuwanchengAdd
				},
				{
					path: 'nongjisuoche',
					component: nongjisuocheList
				},
				{
					path: 'nongjisuocheDetail',
					component: nongjisuocheDetail
				},
				{
					path: 'nongjisuocheAdd',
					component: nongjisuocheAdd
				},
				{
					path: 'syslog',
					component: syslogList
				},
				{
					path: 'syslogDetail',
					component: syslogDetail
				},
				{
					path: 'syslogAdd',
					component: syslogAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
