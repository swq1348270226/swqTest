$(document).ready(function(){

	$.ajaxSetup ({
		cache: false //关闭AJAX相应的缓存
	});
	
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
	loadcount("fails"); 
	
	//加载博客周排行榜
	loadWeeklyranking();
	
	//加载最新回复
	loadNewestComment();
}

function loadcount(isSearch){
	var key = $("#search").val();
	$.ajax({
		type:"post",
		async:"true",
		url:"/BlogSystem/getBlogCount",
		dataType:"text",
		/*ContentType:"application/json,charset=utf-8",*/
		data:{"contentTxt":key},
		success:function(data){
			if(parseInt(data)>0){
				loadList(1,isSearch)
			}
			 var dataL = parseInt(data);
			 var pagesize = 10;
			 var pageNum = Math.ceil(dataL / pagesize);
				$(".tcdPageCode").createPage({
				    pageCount:pageNum,
				    current:1,
				    backFn:function(p){
				    	loadList(p,isSearch);
				    }
				});
		}
	});
}

function loadList(index,isSearch){debugger
		var key = $("#search").val();
		//清空
		$("#main_blogList").html("");
		$.ajax({
			type:"post",
			async:"true",
			url:"/BlogSystem/getBlogList",
			dataType:"json",
			data:{
				"contentTxt":key,
				"pageIndex":index,
				"pageSize":"10"
			},
			success:function(datas){
				if(datas == null){
					
				}else{
					
					var liStr="";
					liStr+='<ul id ="blogList_ul">';
					$.each(datas,function(i,data){
						if(i%2==1){
							liStr+='<li class="blogList_li even">';
						}else{
							liStr+='<li class="blogList_li odd">';
						}
						liStr+='<div class="list_container">';
						liStr+='<div class="list_title"><h2 class="list_title_h2"><a href="/BlogSystem/blogDetail?bid='+data.bid+'" target="_blank">'+ data.title +'</a></h2></div>';
						if(isSearch == "true"){
							liStr+='<div class="list_centent">'+prominentString(data.contentTxt,key,50)+'</div>';
						}else{
							liStr+='<div class="list_centent">'+dealString(data.contentTxt,50)+'</div>';
						}
						
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
	

function prominentString(contentTxt,key,length){
	var str = "";
	if(contentTxt ==null || contentTxt==""){
		return str;
	}
	
	if(countByteLength(contentTxt,1)>length){
		var index = contentTxt.indexOf(key);
		
		if(index!=-1){
			//得出随机数
		var random = Math.floor(Math.random()*length + 1);
		if(index-random<0){
			str= contentTxt.substring(0,length)+"..";
		}else{
			str= contentTxt.substring(index-random,index+length-random)+"..";
		}
		
		}else{
			str= contentTxt.substring(0,length)+"..";
		}
	}
	return str;
}


function dealString(content,length){
	var str = "";
	if(content ==null || content==""){
		return str;
	}
	content = content.trim();
	if(countByteLength(content,1)>length){
		str= content.substring(0,length)+"..";
	}else{
		return str=content;
	}
	return str;
}

function countByteLength(str,cnCharByLen){
	var byteLen = 0;
	if(isEmpty(str)){
		return byteLen
	}
	for(var i =0;i<str.length;i++){
		if((/[\w\s\b\x00-\xff]/).test(str.charAt(i))){
			byteLen+=1;
		}
		else{
			byteLen +=cnCharByLen;
		}
	}
	return byteLen
}

function isEmpty(str){
	if(str == "" || str ==null ){
		return true;
	}
	return false;
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

function loadNewestComment(){
	$.ajax({
		type:"post",
		url:"/BlogSystem/getNewestComment",
		dataType:"json",
		data:{},
		success:function(datas){
			if(datas!=null){
				var commentStr = "";
				commentStr+='<ul class="hotReviews_list_ul">';
				$.each(datas,function(i,data){
					commentStr+='<li>';
					commentStr+='<span class="hotReviews_list_ul_li_span"><a><img src="./images/QQ.jpg"></a></span>';
					commentStr+='<span class ="hotReviews_list_ul_li_userinfo"><a href="" style="font-weight: 900" title="'+data.userId+'">'+data.userId+':</a></span>';
					commentStr+='<span class ="hotReviews_list_ul_li_content"><a href="" title="'+data.comment+'">'+data.comment+'</a></span>';
					commentStr+='</li>';
				})
				commentStr+='</ul>';
				$("#hotReviews_list").html(commentStr);
			}
		}
	})
}

