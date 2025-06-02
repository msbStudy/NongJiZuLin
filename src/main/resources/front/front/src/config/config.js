export default {
	baseUrl: 'http://localhost:8080/springboot2063u69l/',
	name: '/springboot2063u69l',
	indexNav: [
		{
			name: '租赁服务',
			url: '/index/zulinfuwu',
		},
		{
			name: '使用教学',
			url: '/index/shiyongjiaoxue',
		},
		{
			name: '公告信息',
			url: '/index/news'
		},
	],
	cateList: [
		{
			name: '租赁服务',
			refTable: 'nongjileixing',
			refColumn: 'nongjileixing',
		},
		{
			name: '使用教学',
			refTable: 'nongjileixing',
			refColumn: 'nongjileixing',
		},
		{
			name: '公告信息',
			refTable: 'newstype',
			refColumn: 'typename',
		},
	]
}
