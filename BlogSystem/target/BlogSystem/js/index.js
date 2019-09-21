$(document).ready(function(){
	$("#headPage").load("head.html");
	//设置监听
	listener();
})

function listener(){
	var index=0;
	
	$(".num li").mousemove(function(){
		
		$(this).addClass("current").siblings().removeClass("current");
		index=$(this).index();
		$(".img li").eq(index).stop().fadeIn(1000).siblings().stop().fadeOut(1000);
		
	})
	
	var time=setInterval(move,35000);
	
	function move(){
		
		index++;
		if(index==4){
			index=0;
		}
		
		$(".num li").eq(index).addClass("current").siblings().removeClass("current");
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
		
		$(".num li").eq(index).addClass("current").siblings().removeClass("current");
		$(".img li").eq(index).stop().fadeIn(1000).siblings().stop().fadeOut(1000);
		
	}
	
	$(".left_btn").click(function(){
		movel();
	})

	
}
