var codeStatus = "false";
$(document).ready(function(){
	//加载页头
	$("#headPage").load("head.html");
	//设置监听
	//listener();
})

function listener(){ 
	
}



function createBlog(contentTxt,content){
	var title = $("#title").val();
	var blog = {"content":content,"title":title,"contentTxt":contentTxt};
	
$.ajax({
	url:"/BlogSystem/addBlogSystem",
	type:"post",
	contentType:"application/json",
	dataType:"text",
	async:"true",
	data:JSON.stringify(blog),
	success:function(data){debugger;
		if(data == "true"){
			window.location.herf="http://localhost:8080/BlogSystem/index";
		}else{
			alert("发表失败！");
		}
	}
	
})
}
