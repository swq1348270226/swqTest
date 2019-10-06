var score = 0;
var isSelect = false;
$(document).ready(function(){	
	//设置监听
	listener();	
	//加载列表
	loadData();
})

function listener(){
	$(".span_socre_star").on("mouseover",function(){
		starMouseOver(this);
	});
	$(".span_socre_star").on("mouseout",function(){
		starMouseOut(this);
	});
	
	$(".span_socre_star").on("click",function(){
		starClick(this);
	});
}

function loadData(){
	
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
	isSelect = true;
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
	var children = $(this).parent().children();
	if(isSelect){
		for(var i=0;i<children.length;i++){	debugger;		
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
