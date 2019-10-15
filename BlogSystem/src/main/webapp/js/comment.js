var score = 0;
var isSelect = "false";
$(document).ready(function(){
	//设置监听
	commentListener();	
	//加载列表
	loadData();
})

function commentListener(){
	$(".span_socre_star").on("mouseover",function(){
		starMouseOver(this);
	});
	$(".span_socre_star").on("mouseout",function(){
		starMouseOut(this);
	});
	
	$(".span_socre_star").on("click",function(){
		starClick(this);
	});
	
	$("#comment_submit").on("click",function(){
		submitComment();
	});
	
/*	$(".comment_owner_reply").on("click",function(){
		alert("1");
	});*/
}

function loadData(){
	//加载评论列表
	loadCommentList();
}

//鼠标移过
function starMouseOver(self){
	var currentStar = $(self);
	//prevAll，获取指定元素的前边所有的同级元素
	currentStar.prevAll().andSelf().each(function(){
		$(this).removeClass('span_socre_star_empty');
		$(this).addClass('span_socre_star_full');
	});
	//nextAll,获取指定元素后面的所有同级元素
	currentStar.nextAll().each(function(){
		$(this).removeClass('span_socre_star_full');
		$(this).addClass('span_socre_star_empty');
	})
}

//点击
function starClick(self){
	var currentStar = $(self);
	//siblings()获取符合条件元素的同胞元素
	var scoreValue = currentStar.siblings().andSelf().filter('.span_socre_star_full').length;
	score = scoreValue;
	isSelect = "true";
	//andSelf，获取指定元素后面的所有同级元素，还有我自己。
	currentStar.prevAll().andSelf().each(function(){
		$(this).removeClass('span_socre_star_empty');
		$(this).addClass('span_socre_star_full');
	});
	
	currentStar.nextAll().each(function(){
		$(this).removeClass('span_socre_star_full');
		$(this).addClass('span_socre_star_empty');
	});
	
}
//移出	
function starMouseOut(self){
	var currentStar = $(self);
	if(isSelect =="true"){
		var children = currentStar.parent().children();
		for(var i=0;i<children.length;i++){
			if (i >= score) {
			$(children[i]).removeClass('span_socre_star_full');
			$(children[i]).addClass('span_socre_star_empty');
		} else {
			$(children[i]).removeClass('span_socre_star_empty');
			$(children[i]).addClass('span_socre_star_full');
		}
			}
		return;
	}else{
		currentStar.siblings().andSelf().each(function(){
			$(this).removeClass('span_socre_star_full');
			$(this).addClass('span_socre_star_empty');
		})
	}
	
}
function submitComment(){
	if(!checkLoginStatus()){
		$("#comment_pleaceLogin_dialog").dialog({
			title:"回复",
			resizable:false,
			width:200,
			height:150,
			modal:true,
			buttons:[{
				//关闭
				text:"关闭",
				click:function(){
					$(this).dialog("close");
				}
			}]
		});
		return;
	}
	$.ajax({
		type:"post",
		url:"/BlogSystem/submitComment",
		dataType:"text",
		data:{
			"bid":$("#bid").val(),
			"score":score,
			"comment":$("#article_comment_textarea").val()
		},
		success:function(data){
			if(data == "false"){
				$("#comment_false_dialog").dialog({
					title:"回复",
					resizable:false,
					width:200,
					height:150,
					modal:true,
					buttons:[{
						//关闭
						text:"关闭",
						click:function(){
							$(this).dialog("close");
						}
					}]
				});
			}
			if(data == "success"){
				
				$("#comment_success_dialog").dialog({
					title:"评论成功",
					resizable:false,
					width:250,
					height:180,
					modal:true,
					buttons:[{
						//确定
						text:"确定",
						click:function(){
							window.location.reload();
						}
					},{
						//取消
						text:"取消",
						click:function(){
							$(this).dialog("close");
						}
					}]
				});
				
			}
		}
	})
}
function loadCommentList(){
	var bid=$("#bid").val();
	$.ajax({
		type:"post",
		url:"/BlogSystem/getCommentList",
		dataType:"json",
		async:"true",
		data:{
			"bid":bid
		},
		success:function(datas){
			if(datas != null){
				var divStr = "";
				$.each(datas,function(i,data){
					divStr+='<div class="div_reply_mainInfo">';
					divStr+='<div class="div_replyInfo_userAndTime">';
					divStr+='<span class="div_replyInfo_author">'+data.userId+'</span>';
					divStr+='<span class="div_replyInfo_time">'+data.commentTime+'</span>';
					divStr+='<span class="div_replyInfo_score">';
					divStr+='<span class="div_select_star_show"></span>';
					divStr+='<span class="div_select_star_show"></span>';
					divStr+='<span class="div_select_star_show"></span>';
					divStr+='<span class="div_select_star_show"></span>';
					divStr+='<span class="div_select_star_show"></span>';
					divStr+='</span>';
					divStr+='<span class="comment_owner_reply_span"><button class="comment_owner_reply" id="'+data.commentId+'" onclick="openReply(this)">回复</button></span>';
					divStr+='</div>';
					divStr+='<div class="div_replyInfo_content">';
					divStr+='<div>';
					divStr+='<span>'+data.comment+'</span>';
					divStr+='</div>';
					divStr+='</div>';
					if(data.replyList.length>0){
						divStr+='<div class="div_replyInfo_switch" onclick="swichReply(this)">展开</div>';
						$.each(data.replyList,function(i,rp){
						divStr+='<div class="div_replyInfo_authorReply" style="display:none">';
						divStr+='<div class="">';
						divStr+='<span style="color:#0080ff;">[博主回复]：</span>';
						divStr+='<span style="margin-left:10px;">'+rp.replyTime+'</span>';
						divStr+='</div>';
						divStr+='<div class="div_replyInfo_autor_content">';
						divStr+='<span>'+rp.content+'</span>';
						divStr+='</div>';
						divStr+='</div>';
						})
					}
						
					divStr+='</div>';
					divStr+='</div>';
				})
				$("#div_replay_listMainInfo").html(divStr);
			}
		}
	})
}

function swichReply(data){
	var div_replyInfo_switch = $(data);
	if(div_replyInfo_switch.nextAll().css('display')=="none"){
		div_replyInfo_switch.nextAll().css("display","block");
		$(data).text("收起");
	}else{
		div_replyInfo_switch.nextAll().css("display","none");
		$(data).text("展开");
	}
}

function openReply(data){
	var comment_owner_reply = $(data);
	//博主回复
	$("#reply_dialog_div").dialog({
		title:"回复",
		resizable:false,
		width:500,
		height:300,
		modal:true,
		buttons:[{
			//确定
			text:"回复",
			click:function(){
				replySubmit(comment_owner_reply);
			}
		}]
	});
}
function replySubmit(data){
	var commentId=$(data).attr("id");
	var replyContent = $("#reply_text").val();
	if(replyContent == null || replyContent == ""){
		alert("回复内容不能为空！");
	}
	$.ajax({
		type:"post",
		url:"/BlogSystem/replySubmit",
		data:{
			"commentId":commentId,
			"replyContent":replyContent
		},
		dataType:"text",
		success:function(data){
			if(data == "success"){
				window.location.reload();
			}else{
				alert("回复失败");
			}
		}
	})
}