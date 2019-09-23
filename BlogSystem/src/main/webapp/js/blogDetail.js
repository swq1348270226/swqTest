$(document).ready(function(){
	//加载页头
	$("#headPage").load("/BlogSystem/getHead");
	//设置监听
	//listener();
	
	//增加阅读数量
	addReadingCount();
	
})

function listener(){ 
	
}

function addReadingCount(){
	$.ajax({
		type:"post",
		url:"/BlogSystem/addReadingCount",
		dataType:"text",
		async:"true",
		data:{
			"bid":$("#bid").val()
		},
		success:function(data){
			if(data == "false"){
				alert("接口调用异常");
			}
		}
	})
}