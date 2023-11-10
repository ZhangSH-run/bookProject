
function delCartItem(cartItemId){
    window.location.href='cartController.do?oper=delCartItem&cartItemId=' + cartItemId;
}

function delCart(){
    if (confirm("是否确认清空购物车？")){
        window.location.href='cartController.do?oper=delCart';
    }
}

window.onload=function (){
    var vue = new Vue({
        el:"#cart_div",
        data:{
            cart:{}
        },
        methods:{
          getCart:function (){
              axios({
                  method:"POST",
                  url:"cartController.do",
                  params:{
                      oper:"cartInfo"
                  }
              })
                  .then(function (value){
                      console.log(value);
                      console.log(value.data);
                      var cart = value.data;
                      vue.cart = cart;
                  })
                  .catch(function (reason){});
          },
            editCart:function (cartItemId,buyCount){
              axios({
                  method: "POST",
                  url: "cartController.do",
                  params: {
                      oper:"editCart",
                      cartItemId:cartItemId,
                      buyCount:buyCount
                  }
              })
                  .then(function (value){
                      vue.getCart();
                  })
                  .catch(function (reason){});
            },
            delCartItem:function (cartItemId){
              axios({
                  method:"POST",
                  url:"cartController.do",
                  params:{
                      oper:"delCartItem",
                      cartItemId:cartItemId
                  }
              })
                  .then(function (value){
                      vue.getCart();
                  })
                  .catch(function (reason){});
            }
        },
        beforeMount:function (){
            this.getCart();
        }
    });
}