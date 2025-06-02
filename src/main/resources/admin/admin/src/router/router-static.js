import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import news from '@/views/modules/news/list'
	import weixiurenyuan from '@/views/modules/weixiurenyuan/list'
	import driver from '@/views/modules/driver/list'
	import weixiufenpei from '@/views/modules/weixiufenpei/list'
	import nongjiguihai from '@/views/modules/nongjiguihai/list'
	import syslog from '@/views/modules/syslog/list'
	import shiyongjiaoxue from '@/views/modules/shiyongjiaoxue/list'
	import nongjisuoche from '@/views/modules/nongjisuoche/list'
	import nongjizulin from '@/views/modules/nongjizulin/list'
	import nongjileixing from '@/views/modules/nongjileixing/list'
	import zulinfuwu from '@/views/modules/zulinfuwu/list'
	import weixiushenqing from '@/views/modules/weixiushenqing/list'
	import yonghu from '@/views/modules/yonghu/list'
	import pingjiafankui from '@/views/modules/pingjiafankui/list'
	import weixiuwancheng from '@/views/modules/weixiuwancheng/list'
	import config from '@/views/modules/config/list'
	import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/news',
		name: '公告信息',
		component: news
	}
		,{
			path: '/driver',
			name: '司机',
			component: driver
		}
	,{
		path: '/weixiurenyuan',
		name: '维修人员',
		component: weixiurenyuan
	}
	,{
		path: '/weixiufenpei',
		name: '维修分配',
		component: weixiufenpei
	}
	,{
		path: '/nongjiguihai',
		name: '农机归还',
		component: nongjiguihai
	}
	,{
		path: '/syslog',
		name: '系统日志',
		component: syslog
	}
	,{
		path: '/shiyongjiaoxue',
		name: '使用教学',
		component: shiyongjiaoxue
	}
	,{
		path: '/nongjisuoche',
		name: '农机锁车',
		component: nongjisuoche
	}
	,{
		path: '/nongjizulin',
		name: '订单详情',
		component: nongjizulin
	}
	,{
		path: '/nongjileixing',
		name: '农机类型',
		component: nongjileixing
	}
	,{
		path: '/zulinfuwu',
		name: '农机详情',
		component: zulinfuwu
	}
	,{
		path: '/weixiushenqing',
		name: '维修申请',
		component: weixiushenqing
	}
	,{
		path: '/yonghu',
		name: '用户',
		component: yonghu
	}
	,{
		path: '/pingjiafankui',
		name: '评价反馈',
		component: pingjiafankui
	}
	,{
		path: '/weixiuwancheng',
		name: '维修完成',
		component: weixiuwancheng
	}
	,{
		path: '/config',
		name: '轮播图管理',
		component: config
	}
	,{
		path: '/newstype',
		name: '公告信息分类',
		component: newstype
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
