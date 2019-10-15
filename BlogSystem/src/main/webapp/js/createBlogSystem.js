var codeStatus = "false";
$(document).ready(function(){
	$.ajaxSetup ({
		cache: false //关闭AJAX相应的缓存
	});
	//加载页头
	$("#headPage").load("/BlogSystem/getHead");
	//设置监听
	listener33();
	//加载下拉框
	loadSelect();
})

function loadSelect(){
	var datas=[{"id":"type_01","value":"java开发"},{"id":"type_02","value":"主流框架"},{"id":"type_03","value":"前端技术"},{"id":"type_04","value":"其他技术"}];
	var str = "";
	$.each(datas,function(i,data){
		str+='<option value="'+data.id+'">'+data.value+'</option>';
	})
	$("#blogType_01").append(str);
}

function listener33(){ 
	//二级联动
	loadLevel2Drop();
	//三级联动
	loadLevel3Drop();
}

function loadLevel2Drop(){
	
	$("#blogType_01").on("change",function(){
		$("#pleaceSelectType").hide();
		var select = $(this).val();
		$("#blogType_02").empty();
		//获取二级联动框的值
		$.ajax({
			type:"post",
			url:"/BlogSystem/getDropDown2",
			dataType:"json",
			data:{
				type:select
			},
			success: function(datas){
				if(datas!=null){
					var str = '<option value="">-请选择-</option>';
					for(var key in datas){
						str+='<option value="'+key+'">'+datas[key]+'</option>';
					}
					$("#blogType_02").append(str);
					$("#blogType_02").show();
				}
			}
		})
		
	})
}

function loadLevel3Drop(){
	
	$("#blogType_02").on("change",function(){
		$("#pleaceSelectType").hide();
		$("#blogType_03").hide();
		$("#blogType_03").empty();
		var select = $(this).val();
		//获取二级联动框的值
		$.ajax({
			type:"post",
			url:"/BlogSystem/getDropDown3",
			dataType:"json",
			data:{
				type:select
			},
			success: function(datas){
				if(datas!=null){
					var str = '<option value="">-请选择-</option>';
					for(var key in datas){
						str+='<option value="'+key+'">'+datas[key]+'</option>';
					}
					$("#blogType_03").append(str);
					$("#blogType_03").show();
				}
			}
		})
		
	})
}


function createBlog(contentTxt,content){
	if(!checkLoginStatus()){
		alert("请先登录！");
		return;
	}
	var title = $("#title").val();
	var level1=$("#blogType_01").val();
	var level2=$("#blogType_02").val();
	var level3=$("#blogType_03").val();
	if(level1==null ||level1==""){
		$("#pleaceSelectType").show();
		return;
	}
	if($("#blogType_02").css('display')!="none" && (level2==null||level2=="")){
		$("#pleaceSelectType").show();
		return;
	}
	if($("#blogType_03").css('display')!="none" && (level3==null||level3=="")){
		$("#pleaceSelectType").show();
		return;
	}
	
	//拼接分类
	var type=splicingType(level1,level2,level3);
	
	var blog = {"content":content,"title":title,"contentTxt":contentTxt,"type":type};
	
$.ajax({
	url:"/BlogSystem/addBlogSystem",
	type:"post",
	contentType:"application/json",
	dataType:"text",
	async:"true",
	data:JSON.stringify(blog),
	success:function(data){
		if(data == "true"){
			window.location.href="/BlogSystem/index";
		}else{
			alert("发表失败！");
		}
	}
	
})
}

function splicingType(level1,level2,level3){
	var str=level1;
	if(level2!=null&&level2!=""){
		str+="-"+level2;
	}
	if(level3!=null&&level3!=""){
		str+="-"+level3;
	}
	return str;
}
