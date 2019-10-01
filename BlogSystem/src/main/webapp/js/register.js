var codeStatus = "false";
$(document).ready(function(){
	
	//设置监听
	listener();
})

function listener(){
	
	//验证码校验
	$("#code").on("blur",function(){
		$.ajax({
			url:"/BlogSystem/validateCode",
			type:"get",
			async:"true",
			dataType:"text",
			data:{
				"modelName":"REGISTER_NAME",
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
	$("#usrename").on("focus",function(){
		$("#usernameTips").removeClass("input_illegal");
		$("#usernameExistTips").removeClass("input_illegal");
		$("#usernameExistTips").hide();
		$("#usernameTips").show();
		
	})
	
	
	$("#usrename").on("blur",function(){
		var reg= new RegExp('^[A-Za-z0-9]+$');
		var username = $("#usrename").val();
		if(!reg.test(username) || validateLength(username)){
			$("#usernameTips").addClass("input_illegal");
		}else{
			$("#usernameTips").hide();
			validateUser(username);
		}
	})
	
	//密码校验
	$("#password").on("focus",function(){
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
	
	
	//注册提交事件
	$("#register").click(function(){
		
		$.ajax({
			url:"/BlogSystem/registerUserInfo",
			type:"POST",
			dataType:"text",
			async:"true",
			data:{
				"username":$("#usrename").val(),
				"password":$("#password").val()
			},
			success:function(){
				if(data =="repeat"){
					alert("账号已经被注册！");
				}
				if(data =="true"){
					alert("注册成功！");
				}
				if(data =="false"){
					alert("注册失败！");
				}
			}
			
		})
	})
	
}

function validateLength(str){
	if(!(3<str.length && str.length < 17)){
		return true;
	}
	return false;
}

function change(username){
	var date = new Date();
	$("#codeImg").attr("src","/BlogSystem/getCode?modelName=REGISTER_NAME&&data="+date);
}

function validateUser(username){
	$.ajax({
		type:"post",
		url:"/BlogSystem/checkUser",
		dataType:"text",
		data:{
			"username":username
		},
		success:function(data){
			if(data == "repeat"){
				$("#usernameExistTips").show();
				$("#usernameExistTips").addClass("input_illegal");
				return;
			}
		}
	})
}