var codeStatus = "false";
$(document).ready(function(){
	
	$("#code").val()
	//设置监听
	listener();
})

function listener(){
	
	//登录验证
	$("#login").click(function(){
		if(codeStatus=="false"){
			$("#tips").show();
			$("#codeStatus").attr("src","./images/nopass.jpg");
			return;
		}
		$.ajax({
			url:"/BlogSystem/validateLogin",
			type:"post",
			dataType:"text",
			async:"true",
			data:{
				"username":$("#username").val(),
				"password":$("#password").val()
			},
			success:function(data){
				if(data == "true"){
					window.location.href="/BlogSystem/index";
				}else{
					$("#error_tips").show();
				}
			}
		})
	})
	
	//验证码校验
	$("#code").on("blur",function(){
		$.ajax({
			url:"/BlogSystem/validateCode",
			type:"get",
			async:false,
			dataType:"text",
			data:{
				"modelName":"LOGIN_NAME",
				"code":$("#code").val()
			},
			success:function(data){
				if(data == "true"){
					codeStatus = "true";
					$("#tips").show();
					$("#codeStatus").attr("src","./images/pass.jpg");
					
				}else{
					$("#tips").show();
					$("#codeStatus").attr("src","./images/nopass.jpg");
					codeStatus = "false";
				}
			}
		})
		
	})
	
	//用户名校验
	$("#username").on("focus",function(){
		$("#error_tips").hide();
		$("#usernameTips").removeClass("input_illegal");
		$("#usernameTips").show();
	})
	
	
	$("#username").on("blur",function(){
		var reg= new RegExp('^[A-Za-z0-9]+$');
		var username = $("#username").val();
		if(!reg.test(username) || validateLength(username)){
			$("#usernameTips").addClass("input_illegal");
		}else{
			$("#usernameTips").hide();
		}
	})
	
	//密码校验
	$("#password").on("focus",function(){
		$("#error_tips").hide();
		$("#passwordTips").removeClass("input_illegal");
		$("#passwordTips").show();
	})
	
	
	$("#password").on("blur",function(){
		var reg= new RegExp('^[A-Za-z0-9]+$');
		var password = $("#password").val();
		if(!reg.test(password) || validateLength(password)){
			$("#passwordTips").addClass("input_illegal");
		}else{
			$("#passwordTips").hide();
		}
	})
	
	
	$("#code").on("blur",function(){
		$.ajax({
			url:"/BlogSystem/checkCode",
			type:"get",
			dataType:"text",
			async:"true",
			data:{
				'code':code,
				"modelName":"LOGIN_NAME"
			},
			success:function(data){
				if(data == "success"){
					
				}
				else{
					$("#tips").show();
				}
			}
		})
	})
}
function change(){
	var date = new Date();
	$("#codeImg").attr("src","/BlogSystem/getCode?modelName=LOGIN_NAME&&data="+date);
}


function validateLength(str){
	if(!(3<str.length && str.length < 17)){
		return true;
	}
	return false;
}
