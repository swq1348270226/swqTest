$(document).ready(function(){
	$("#headPage").load("/BlogSystem/getHead",function(){
	});
		
	//设置监听
	listener();
		
	//加载列表
	loadData();
})


function listener(){
	
	
	var index=0;
	
	$(".num li").mousemove(function(){
		
		$(this).addClass("currentImg").siblings().removeClass("currentImg");
		index=$(this).index();
		$(".img li").eq(index).stop().fadeIn(1000).siblings().stop().fadeOut(1000);
		
	})
	
	var time=setInterval(move,3500);
	
	function move(){
		
		index++;
		if(index==4){
			index=0;
		}
		
		$(".num li").eq(index).addClass("currentImg").siblings().removeClass("currentImg");
		$(".img li").eq(index).stop().fadeIn(1000).siblings().stop().fadeOut(1000);
		
		
	}
	
	$(".img_list_div").hover(function(){
		$(".btn").show();
		clearInterval(time);
	},function(){
		$(".btn").hide();
		time=setInterval(move,3500);
	})
	
	$(".right_btn").click(function(){
		move();
	})
	
	
	function movel(){
		index--;
		if(index==-1){
			index=3;
		}
		
		$(".num li").eq(index).addClass("currentImg").siblings().removeClass("currentImg");
		$(".img li").eq(index).stop().fadeIn(1000).siblings().stop().fadeOut(1000);
		
	}
	
	$(".left_btn").click(function(){
		movel();
	})

	
}

function loadData(){
	//列表数量
	loadcount(); 
	
	//加载博客周排行榜
	loadWeeklyranking();
}

function loadcount(){
	$.ajax({
		type:"post",
		async:"true",
		url:"/BlogSystem/getBlogCount",
		dataType:"text",
		data:{
			
		},
		success:function(data){
			if(parseInt(data)>0){
				loadList(1)
			}
			 var dataL = parseInt(data);
			 var pagesize = 10;
			 var pageNum = Math.ceil(dataL / pagesize);
				$(".tcdPageCode").createPage({
				    pageCount:pageNum,
				    current:1,
				    backFn:function(p){
				    	loadList(p);
				    }
				});
		}
	});
}

function loadList(index){
		//清空
		$("#main_blogList").html("");
		$.ajax({
			type:"post",
			async:"true",
			url:"/BlogSystem/getBlogList",
			dataType:"json",
			data:{
				"pageIndex":index,
				"pageSize":"10"
			},
			success:function(datas){
				if(datas == null){
					
				}else{
					
					var liStr="";
					liStr+='<ul id ="blogList_ul">';
					$.each(datas,function(i,data){
						liStr+='<li class="blogList_li">';
						liStr+='<div class="list_container">';
						liStr+='<div class="list_title"><h2 class="list_title_h2"><a href="/BlogSystem/blogDetail?bid='+data.bid+'" target="_blank">'+ data.title +'</a></h2></div>';
						liStr+='<div class="list_centent">'+dealString(data.contentTxt,40)+'</div>';
						liStr+='<div class="list_countInfo">';
						liStr+='<ul>';
						liStr+='<li class="countInfo_1"><a href=""><img class="user_head" src="./images/QQ.jpg"/></a></li>';
						liStr+='<li class="countInfo_1 countInfo_1_1">'+data.commit+'</li>';
						liStr+='<li class="countInfo_2"><a herf=""><span class="countInfo_readingComment_text">阅读数</span><span class="countInfo_readingComment_num">'+switchContent(data.visitCount)+'</span></a></li>';
						liStr+='<li class="countInfo_2 countInfo_2_split">|</li>';
						liStr+='<li class="countInfo_2"><a herf=""><span class="countInfo_readingComment_text">评论数</span><span class="countInfo_readingComment_num">'+switchContent(data.commentCount)+'</span></a></li>';
						liStr+='</ul>';
						liStr+='</div>';
						liStr+='</div>';
						liStr+='</li>';
					})
					liStr+='</ul>';
					$("#main_blogList").html(liStr);
					

				}
				
			},
			error:function(data){
				alert("出错啦");
			}
			
		})	
}
	

function dealString(content,length){
	var str = "";
	if(content ==null || content==""){
		return str;
	}
	content = content.trim();
	if(content.length>length){
		str= content.substring(0,length)+"..";
	}else{
		return str=content;
	}
	return str;
}

function switchContent(str){
	return  str==null?"0":str;
}

function loadWeeklyranking(){
	$.ajax({
		type:"post",
		url:"/BlogSystem/getBlogWeeklyranking",
		dataType:"json",
		data:{
			
		},
		success:function(datas){
			if(datas == null){
				
			}
			else{
				var liStr="";
				liStr+='<ul>';
				$.each(datas,function(i,data){
					liStr+='<li class="favoriteBlog_content_li">';
					liStr+='<div class="favoriteBlog_li_left"><a href=""><img src="./images/QQ.jpg"></a></div>'
					liStr+='<div class="favoriteBlog_li_center">';
					liStr+='<p class="item_title"><a href="/BlogSystem/blogDetail?bid='+data.bid+'" target="_blank" title="'+dealString(data.contentTxt,60)+'">'+dealString(data.contentTxt,10)+'</a></p>';
					liStr+='<p class="comment_count">';
					liStr+='<span>点击量</span>';
					liStr+='<span>'+data.visitCount+'</span>';
					liStr+='</p>';
					liStr+='</div>';
					liStr+='<div class="favoriteBlog_li_right">';
					liStr+='<p class="clicks_count"><img src="./images/up.jpg"/>'+data.fever+'</p>';
					liStr+='<p class="clicks_text">综合指标</p>';
					liStr+='</div>';
					liStr+='</li>';					
				})
				liStr+='</ul>';
				$("#favoriteBlog_top10_list").html(liStr);
			}
		}
	})
}

