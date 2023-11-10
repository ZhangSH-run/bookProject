function $(id){
    return document.getElementById(id);
}
function checkRegist(){
    //验证用户名是否为6~16位数组和字母组成
    var unameTxt = $("unameTxt");
    var unameReg = /^[a-zA-Z0-9]{6,16}$/;
    var uname = unameTxt.value;
    var unameSpan = $("unameSpan");
    if (!unameReg.test(uname)){
        unameSpan.style.visibility="visible";
        return false;
    }else {
        unameSpan.style.visibility="hidden";
    }
    //密码的长度至少为8位
    var pwdTxt = $("pwdTxt");
    var pwdSpan = $("pwdSpan");
    var pwd = pwdTxt.value;
    var pwdReg = /.{8,}/;
    if (!pwdReg.test(pwd)){
        pwdSpan.style.visibility="visible";
        return false;
    }else {
        pwdSpan.style.visibility="hidden";
    }
    //密码两次输入不一致
    var pwdTxt2 = $("pwdTxt2");
    var pwdSpan2 = $("pwdSpan2");
    var pwd2 = pwdTxt2.value;
    if (pwd != pwd2){
        pwdSpan2.style.visibility="visible";
        return false;
    }else {
        pwdSpan2.style.visibility="hidden";
    }
    //请输入正确的邮箱格式
    var emailTxt = $("emailTxt");
    var email = emailTxt.value;
    var emailReg =/^[a-zA-Z0-9_\.-]+@([a-zA-Z0-9-]+[\.]{1})+[a-zA-Z]+$/;
    var emailSpan = $("emailSpan");
    if (!emailReg.test(email)){
        emailSpan.style.visibility="visible";
        return false;
    }else {
        emailSpan.style.visibility="visible";
    }

    return true;
}

//如果想要发送异步请求，我们需要一个关键的对象 XMLHttpRequest
var xmlHttpRequest ;

function createXMLHttpRequest(){
    if(window.XMLHttpRequest){
        //符合DOM2标准的浏览器 ，xmlHttpRequest的创建方式
        xmlHttpRequest = new XMLHttpRequest() ;
    }else if(window.ActiveXObject){//IE浏览器
        try{
            xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
        }catch (e) {
            xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP")
        }
    }
}
function checkUname(uname){
    createXMLHttpRequest();
    var url = "checkUname?uname="+uname;
    xmlHttpRequest.open("GET",url,true);
    //设置回调函数
    xmlHttpRequest.onreadystatechange = checkUnameCB;
    //发送请求
    xmlHttpRequest.send();
}

function checkUnameCB(){
    if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200){
        //xmlHttpRequest.responseText 表示服务器端响应给我的文本内容
        //alert(xmlHttpRequest.responseText);
        var responseText = xmlHttpRequest.responseText;
        if (responseText == "1"){
            alert("用户名已经被注册！");
        }
    }
}
