<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	pageContext.setAttribute("basePath", basePath);
	request.setCharacterEncoding("UTF-8");
%>
<%--java.net.URLDecoder.decode(request.getParameter("tag"),"UTF-8");--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<base href="${basePath}">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>阿巴阿巴书城</title>
	<link rel="stylesheet" href="bs/css/bootstrap.css">
	<script type="text/javascript" src="bs/js/jquery.min.js"></script>
	<script type="text/javascript" src="bs/js/bootstrap.js"></script> 
	<link href="css/book/head_footer.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="js/book/getCatalog.js"></script>
	<script type="text/javascript" src="js/book/index.js"  charset="UTF-8"></script>
	<script type="text/javascript" src="js/book/landing.js"></script>
	<link rel="stylesheet" href="css/book/index.css" />
	<script type="text/javascript" src="js/book/addcart.js"></script>
	<!-- 轮播特效 -->
    <style type="text/css">
        .dropdown-menu{
            margin:0;
        }
        .c-860 {
            max-width: 900px;
            height: 400px;
            /*width: 100%;*/
            /* z-index: 99999999; */
        }
        .c-860 img{
            border-style:none;
            border-radius: 15px !important;
            vertical-align:top;
            max-width:100%;
            height:auto;
        }
        .c-860 a{
            text-decoration:none;
            color:#333;
        }
        .c-860  a:hover{
            color:#ff7700;
            text-decoration:none;
        }
		.head .top .top-right{
			display:inline;
			float: right;
			/*position: absolute;*/
			margin-top: -30px;
			padding-left: 100px;
		}
		.head .top .top-right2{
			margin-top: -40px;

		}
    </style>
	<link rel="stylesheet" href="banner/css/style.css" />
	<script type='text/javascript' src='banner/js/modernizr.min.js?ver=2.6.1'></script>
	<script type='text/javascript'>
		/* <![CDATA[ */
		var CSSettings = {"pluginPath":"banner"};
		/* ]]> */
	</script>
	<script type='text/javascript' src='banner/js/cute.slider.js?ver=2.0.0'></script>
	<script type='text/javascript' src='banner/js/cute.transitions.all.js?ver=2.0.0'></script>
</head>
<body>

	<div class="container-fullid">
		<%@include file="header.jsp" %>
		<div class="wrapper">
			<!-- banner start -->
			<div class="c-860 c-demoslider">
				<div id="cuteslider_3_wrapper" class="cs-circleslight">
					<div id="cuteslider_3" class="cute-slider" data-width="960" data-height="420" data-overpause="true">
						<ul data-type="slides">
							<li data-delay="5" data-src="5" data-trans3d="tr6,tr17,tr22,tr23,tr29,tr27,tr32,tr34,tr35,tr53,tr54,tr62,tr63,tr4,tr13,tr45" data-trans2d="tr3,tr8,tr12,tr19,tr22,tr25,tr27,tr29,tr31,tr34,tr35,tr38,tr39,tr41"><img  src="banner/001/白夜行.jpg" data-thumb="images/001/白夜行 - 副本.jpg"></li>
							<li data-delay="5" data-src="5" data-trans3d="tr6,tr17,tr22,tr23,tr26,tr27,tr29,tr32,tr34,tr35,tr53,tr54,tr62,tr63,tr4,tr13" data-trans2d="tr3,tr8,tr12,tr19,tr22,tr25,tr27,tr29,tr31,tr34,tr35,tr38,tr39,tr41"><img  src="banner/bg/blank.png" data-src="banner/001/我不喜欢这个世界.jpg" data-thumb="banner/001/我不喜欢这个世界 - 副本.jpg"></li>
							<li data-delay="5" data-src="5" data-trans3d="tr6,tr17,tr22,tr23,tr26,tr27,tr29,tr32,tr34,tr35,tr53,tr54,tr62,tr63,tr4,tr13" data-trans2d="tr3,tr8,tr12,tr19,tr22,tr25,tr27,tr29,tr31,tr34,tr35,tr38,tr39,tr41"><img  src="banner/bg/blank.png" data-src="banner/001/白夜行.jpg" data-thumb="banner/001/白夜行 - 副本.jpg"></li>
							<li data-delay="5" data-src="5" data-trans3d="tr6,tr17,tr22,tr23,tr26,tr27,tr29,tr32,tr34,tr35,tr53,tr54,tr62,tr63,tr4,tr13" data-trans2d="tr3,tr8,tr12,tr19,tr22,tr25,tr27,tr29,tr31,tr34,tr35,tr38,tr39,tr41"><img  src="banner/bg/blank.png" data-src="banner/001/解忧杂货铺.jpg" data-thumb="banner/001/解忧杂货铺 - 副本.jpg"></li>
							<li data-delay="5" data-src="5" data-trans3d="tr6,tr17,tr22,tr23,tr26,tr27,tr29,tr32,tr34,tr35,tr53,tr54,tr62,tr63,tr4,tr13" data-trans2d="tr3,tr8,tr12,tr19,tr22,tr25,tr27,tr29,tr31,tr34,tr35,tr38,tr39,tr41"><img  src="banner/bg/blank.png" data-src="banner/001/我只喜欢你.jpg" data-thumb="banner/001/我只喜欢你 - 副本.jpg"></li>
							<li data-delay="5" data-src="5" data-trans3d="tr6,tr17,tr22,tr23,tr26,tr27,tr29,tr32,tr34,tr35,tr53,tr54,tr62,tr63,tr4,tr13" data-trans2d="tr3,tr8,tr12,tr19,tr22,tr25,tr27,tr29,tr31,tr34,tr35,tr38,tr39,tr41"><img  src="banner/bg/blank.png" data-src="banner/001/海边的卡夫卡.jpg" data-thumb="banner/001/海边的卡夫卡 - 副本.jpg"></li>
						</ul>
						<ul data-type="controls"> <!-- 显示控制功能 -->
							<li data-type="captions"></li>  <!-- 显示文字信息 -->
							<li data-type="link"></li> <!-- 显示链接 -->
							<li data-type="video"></li>  <!-- 显示视频 -->
							<li data-type="slideinfo"></li>  <!-- 显示文字信息 -->
							<li data-type="circletimer"></li> <!-- 显示圆形时间进度条 -->
							<li data-type="previous"></li>  <!-- 显示上一张按钮 -->
							<li data-type="next"> </li>  <!-- 显示下一张按钮 -->
							<li data-type="bartimer"></li>  <!-- 显示底部时间进度条 bartimer | previous -->
							<li data-type="slidecontrol" data-thumb="true" data-thumbalign="up"></li>
						</ul>
					</div>
					<div class="cute-shadow"><img src="banner/bg/shadow.png" alt="shadow"></div>
				</div>
			</div>
			<!-- main start -->
			<div class="main container">
				<div class="row">
					<div class="col-md-2 main-left">
						<h3>图书分类</h3>
						
						<ul id="catalog-list">
							<li><a href="BookList">全部图书</a></li>
							
						</ul>
					</div>
					<div class="col-md-10 main-right">
						<div class="pro col-md-12">
							<h3>推荐图书</h3>
							<div id="recBooks" class="pro-list">
								<ul>
									
								</ul>
							</div>
								
						</div>
						<div class="pro col-md-12">
							<h3>新书上架</h3>
							<div id="newBooks" class="pro-list">
								<ul > 
									
								</ul>
							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		
		<%@include file="footer.jsp" %>
	</div>
	<!--弹窗盒子start -->
	<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	  	<div class="modal-dialog modal-sm">
	    	<div class="modal-content">
	    		<div class="modal-body" style="color:green;font-size:24px;">
				  <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp商品已成功加入购物车！
				</div>
	    			
	      		<div class="modal-footer">
	      			<a href="javascript:void(0)" type="button" class="btn btn-default" data-dismiss="modal">返回继续购物</a>
			        <a href="jsp/book/cart.jsp" type="button" class="btn btn-success">立即去结算</a>
			    </div>
	    	</div>
	  	</div>
	</div>
	<!--弹窗盒子end -->
	<!-- 轮播特效 -->
	<script type="text/javascript">
		var cuteslider3 = new Cute.Slider();
		cuteslider3.setup("cuteslider_3", "cuteslider_3_wrapper", "banner/css/slider-style.css");
		cuteslider3.api.addEventListener(Cute.SliderEvent.CHANGE_START,
				function(event) {});
		cuteslider3.api.addEventListener(Cute.SliderEvent.CHANGE_END,
				function(event) {});
		cuteslider3.api.addEventListener(Cute.SliderEvent.WATING,
				function(event) {});
		cuteslider3.api.addEventListener(Cute.SliderEvent.CHANGE_NEXT_SLIDE,
				function(event) {});
		cuteslider3.api.addEventListener(Cute.SliderEvent.WATING_FOR_NEXT,
				function(event) {});
	</script>
	<!-- 轮播特效结束 -->
</body>
</html>