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
	
	var time=setInterval(move,35000);
	
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
		time=setInterval(move,35000);
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
	loadcount(); 
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
			 var pagesize = 5;
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
				"pageSize":"5"
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
						liStr+='<div class="list_centent">'+deal(data.contentTxt)+'</div>';
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
	

function deal(content){
	var str = "";
	if(content ==null || content==""){
		return str;
	}
	if(content.length>40){
		str= content.substring(0,40)+"...";
	}else{
		return str=content;
	}
	return str;
}

function switchContent(str){
	return  str==null?"0":str;
}


