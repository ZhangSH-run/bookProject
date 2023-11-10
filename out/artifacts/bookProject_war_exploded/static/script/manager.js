window.onload=function (){
    var vue = new Vue({
        el:"#main",
        data:{
            bookList:{},
            book:{}
        },
        methods:{
            getBookList:function(){
                axios({
                    method:"POST",
                    url:"bookController.do",
                    params:{
                        oper:"rootBookList"
                  }
                })
                    .then(function (value){
                        vue.bookList = value.data;
                    })
                    .catch(function (reason){
                        console.log(reason);
                    });
            },
            editBook:function (bookId){
                axios({
                    method: "POST",
                    url: "bookController.do",
                    params: {
                        oper: "updateBook",
                        bookId:bookId
                    }
                })
                    .then(function (value){
                        vue.getBookList()
                    })
                    .catch(function (reason){});
            }
        },
        beforeMount:function (){
            this.getBookList();
        }
    });
}