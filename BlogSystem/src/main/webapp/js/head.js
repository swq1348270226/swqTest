$(document).ready(function(){
	//加載登錄信息情況
	checkIsLogin();
	//设置监听
	listener();
})

function listener(){
	
	$("#searchsubmit").on("click",function(){
		//列表数量
		loadcount("true"); 
	})
	
	/*一*/
	$("#java_drop").mouseover(function(){
		$("#java_drop_ul").show();
		$("#java_drop").addClass("mouseover_style");
		$("#java_drop_img").remove();
	});
	
	$("#java_drop").mouseout(function(){
		$("#java_drop").removeClass("mouseover_style");
		$("#java_drop").append("<img id='java_drop_img' src='./images/drop.jpg'/>");
		$("#java_drop_ul").hide();
	});
	
	
	
	/*二*/
	$("#css_drop").mouseover(function(){
		$("#css_drop_ul").show();
		$("#css_drop").addClass("mouseover_style");
		$("#css_drop_img").remove();
	});
	
	$("#css_drop").mouseout(function(){
		$("#css_drop").removeClass("mouseover_style");
		$("#css_drop").append("<img id='css_drop_img' src='./images/drop.jpg'/>");
		$("#css_drop_ul").hide();
	});
	
	/*三*/
	$("#frame_drop").mouseover(function(){
		$("#frame_drop_ul").show();
		$("#frame_drop").addClass("mouseover_style");
		$("#frame_drop img").remove();
	});
	
	$("#frame_drop").mouseout(function(){
		$("#frame_drop").removeClass("mouseover_style");
		$("#frame_drop").append("<img src='./images/drop.jpg'/>");
		$("#frame_drop_ul").hide();
	});
	
	
	/*四*/
	$("#othter_drop").mouseover(function(){
		$("#othter_drop_ul").show();
		$("#othter_drop").addClass("mouseover_style");
		$("#othter_drop img").remove();
	});
	
	$("#othter_drop").mouseout(function(){
		$("#othter_drop").removeClass("mouseover_style");
		$("#othter_drop").append("<img src='./images/drop.jpg'/>");
		$("#othter_drop_ul").hide();
	});
	
	/*二级01*/
	$("#sort_navi_lv2_li_01_03").mouseover(function(){
		$("#sort_navi_lv2_li_01_03 img").remove();
		$("#lv3_ul_01_03").show();
	});
	
	$("#sort_navi_lv2_li_01_03").mouseout(function(){
		$("#lv3_ul_01_03").hide();
		$("#sort_navi_lv2_li_01_03").append("<img style='width:7px;height:10px;float:right;margin:18px 3px;' src='./images/drop_right.jpg'/>");
	});
	
	
	/*二级02*/
	$("#sort_navi_lv2_li_02_02").mouseover(function(){
		$("#sort_navi_lv2_li_02_02 img").remove();
		$("#lv3_ul_02_03").show();
	});
	
	$("#sort_navi_lv2_li_02_02").mouseout(function(){
		$("#lv3_ul_02_03").hide();
		$("#sort_navi_lv2_li_02_02").append("<img style='width:7px;height:10px;float:right;margin:18px 3px;' src='./images/drop_right.jpg'/>");
	});
	
}

function search(){
	var status = document.getElementById("search_div");
	var a = status.style.display;
	if(a == "none"){
		$("#search_div").show();
	}
	else{
		$("#search_div").hide();
	}
}

function checkIsLogin(){
	$.ajax({
		type:"post",
		url:"/BlogSystem/checkIsLogin",
		async:"true",
		dataType:"json",
		data:{
			
		},
		success:function(data){
			if(data.status == "login"){
				$("#welcomeName").html("");
				$("#welcomeName").html(data.name);
				$("#welcomeName").show();
				$("#loginButton").hide();
				$("#cancellation").show();
			}
			else{
				$("#welcomeName").hide();
				$("#loginButton").show();
				$("#cancellation").hide();
			}
		}
	})
}
