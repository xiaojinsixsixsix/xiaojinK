const base = {
    get() {
        return {
            url : "http://localhost:8080/xiaojinSIXSIX/",
            name: "xiaojinSIXSIX",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xiaojinSIXSIX/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "景点移动导游系统的设计与实现"
        } 
    }
}
export default base
