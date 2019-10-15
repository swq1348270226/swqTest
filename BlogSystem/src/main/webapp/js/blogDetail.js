$(document).ready(function(){

	$.ajaxSetup ({
		cache: false //关闭AJAX相应的缓存
	});
	//加载页头
	$("#headPage").load("/BlogSystem/getHead");
	
	$("#comment_area").load("/BlogSystem/getCommentHtml");


	
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