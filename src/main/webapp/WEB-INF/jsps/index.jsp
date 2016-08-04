<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="ThemeBucket">
  <link rel="shortcut icon" href="#" type="image/png">

  <title>超市信息管理系统</title>

  <link href="<%=path%>/resources/css/style.css" rel="stylesheet">
  <link href="<%=path%>/resources/css/style-responsive.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="<%=path%>/resources/js/html5shiv.js"></script>
  <script src="<%=path%>/resources/js/respond.min.js"></script>
  <![endif]-->
</head>

<body class="sticky-header">

<section>
    <!-- left side start-->
    <div class="left-side sticky-left-side">

        <!--logo and iconic logo start-->
        <div class="logo">
            <a href="index.jsp"><img src="<%=path%>/resources/images/logo.png" alt=""></a>
        </div>

        <div class="logo-icon text-center">
            <a href="index.jsp"><img src="<%=path%>/resources/images/logo_icon.png" alt=""></a>
        </div>
        <!--logo and iconic logo end-->

		<!--左侧栏-->
        <div class="left-side-inner">

            <!--sidebar nav start-->
            <ul class="nav nav-pills nav-stacked custom-nav">
                <li class="active"><a href="index.jsp"><i class="fa fa-home"></i> <span>主页</span></a></li>
                <li class="menu-list <!--nav-active是否展开-->"><a href=""><i class="fa fa-laptop"></i> <span>录入信息</span></a>
                    <ul class="sub-menu-list">
                        <li ><a href="<%=path%>/resources/area_insert.jsp"> 超市地图 </a></li>
                        <li><a href="<%=path%>/resources/product_insert.jsp"> 产品信息 </a></li>
                        <li><a href="<%=path%>/resources/onsale_insert.jsp">产品上架</a></li>
                        <li><a href="<%=path%>/resources/discount_insert.jsp"> 打折信息</a></li>
                    </ul>
                </li>
                <li class="menu-list"><a href=""><i class="fa fa-book"></i> <span>信息查询</span></a>
                    <ul class="sub-menu-list">
                        <li><a href="<%=path%>/resources/area_info.html"> 超市地图</a></li>
                        <li><a href="<%=path%>/resources/product_info.html"> 产品信息</a></li>
                        <li><a href="<%=path%>/resources/onsale_info.html"> 上架信息</a></li>
                        <li><a href="<%=path%>/resources/discount_info.html"> 打折信息</a></li>
                        <li><a href="<%=path%>/resources/user_info.html"> 用户信息</a></li>
                        <li><a href="<%=path%>/resources/sale_record_info.html"> 购物记录</a></li>
                    </ul>
                </li>
                
                <li><a href="<%=path%>/resources/login.html"><i class="fa fa-sign-in"></i> <span>注销</span></a></li>

            </ul>
            <!--sidebar nav end-->

        </div>
    </div>
    <!-- left side end-->
    
    <!-- main content start-->
    <div class="main-content" >

        <!-- header section start-->
        <div class="header-section">

			<!--toggle button start  侧边栏开关按钮-->
			<a class="toggle-btn"><i class="fa fa-bars"></i></a>
			<!--toggle button end-->

			<!--notification menu start 用户栏-->
			<div class="menu-right">
				<ul class="notification-menu">                        
						
					<li>
						<a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
							<img src="<%=path%>/resources/images/photos/user-avatar.png" alt="" />
							John Doe
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu dropdown-menu-usermenu pull-right">              
							<li><a href="#"><i class="fa fa-cog"></i>  设置</a></li>
							<li><a href="#"><i class="fa fa-sign-out"></i>注销</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<!--notification menu end -->
        </div>
        <!-- header section end-->

        <!-- page heading start-->
        <div class="page-heading">
            Page Tittle goes here
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">
            Body contents goes here
        </div>
        <!--body wrapper end-->

        <!--footer section start-->
        <footer class="sticky-footer">
            2016 &copy;  by SHU
        </footer>
        <!--footer section end-->
    </div>
    <!-- main content end-->
</section>

<!-- Placed js at the end of the document so the pages load faster -->
<script src="<%=path%>/resources/js/jquery-1.10.2.min.js"></script>
<script src="<%=path%>/resources/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="<%=path%>/resources/js/jquery-migrate-1.2.1.min.js"></script>
<script src="<%=path%>/resources/js/bootstrap.min.js"></script>
<script src="<%=path%>/resources/js/modernizr.min.js"></script>
<script src="<%=path%>/resources/js/jquery.nicescroll.js"></script>
<!--common scripts for all pages-->
<script src="<%=path%>/resources/js/scripts.js"></script>

</body>
</html>
