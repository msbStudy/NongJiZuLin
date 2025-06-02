const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot2063u69l/",
            name: "springboot2063u69l",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot2063u69l/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于SpringBoot+Vue技术的农机租赁系统的设计与实现"
        } 
    }
}
export default base
