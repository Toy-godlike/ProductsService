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

  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>

<body class="sticky-header">

<section>
    <!-- left side start-->
    <div class="left-side sticky-left-side">

        <!--logo and iconic logo start-->
        <div class="logo">
            <a href="<%=path%>/resources/index.jsp"><img src="images/logo.png" alt=""></a>
        </div>

        <div class="logo-icon text-center">
            <a href="<%=path%>/resources/index.jsp"><img src="images/logo_icon.png" alt=""></a>
        </div>
        <!--logo and iconic logo end-->

		<!--左侧栏-->
        <div class="left-side-inner">

            <!--sidebar nav start-->
            <ul class="nav nav-pills nav-stacked custom-nav">
                <li ><a href="index.jsp"><i class="fa fa-home"></i> <span>主页</span></a></li>
                <li class="menu-list nav-active"><a href=""><i class="fa fa-laptop"></i> <span>录入信息</span></a>
                    <ul class="sub-menu-list">
                        <li ><a href="area_insert.jsp"> 超市地图 </a></li>
                        <li ><a href="product_insert.jsp"> 产品信息 </a></li>
                        <li ><a href="onsale_insert.jsp">产品上架</a></li>
                        <li class="active"><a href="discount_insert.jsp"> 打折信息</a></li>
                    </ul>
                </li>
                <li class="menu-list"><a href=""><i class="fa fa-book"></i> <span>信息查询</span></a>
                    <ul class="sub-menu-list">
                        <li><a href="area_info.jsp"> 超市地图</a></li>
                        <li><a href="product_info.jsp"> 产品信息</a></li>
                        <li><a href="onsale_info.jsp"> 上架信息</a></li>
                        <li><a href="discount_info.jsp"> 打折信息</a></li>
                        <li><a href="user_info.html"> 用户信息</a></li>
                        <li><a href="sale_record_info.jsp"> 购物记录</a></li>
                    </ul>
                </li>
                
                <li><a href="login.html"><i class="fa fa-sign-in"></i> <span>注销</span></a></li>

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
							<img src="images/photos/user-avatar.png" alt="" />
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
            <h3>
                产品打折信息录入
            </h3>
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            产品打折信息
                        </header>
                        <div class="panel-body">
                            <div role="form" class="form-horizontal adminex-form">
                                <div class="form-group has-success">
                                    <label class="col-lg-2 control-label">打折信息编号</label>
                                    <div class="col-lg-10">
                                        <input type="text" placeholder="" id="discountNum" class="form-control">
                                        
                                    </div>
                                </div>
                                <div class="form-group has-error">
                                    <label class="col-lg-2 control-label">产品条形码</label>
                                    <div class="col-lg-10">
                                        <input type="text" placeholder="" id="shapcode" class="form-control">
                                        
                                    </div>
                                </div>
                                <div class="form-group has-warning">
                                    <label class="col-lg-2 control-label">打折比率</label>
                                    <div class="col-lg-10">
                                        <input type="text" placeholder="" id="discountRate" class="form-control">
                                        
                                    </div>
                                </div>								
								<div class="form-group has-warning">
                                    <label class="col-lg-2 control-label">开始日期</label>
                                    <div class="col-lg-10">
                                        <input type="text" placeholder="" id="startDate" class="form-control">
                                        
                                    </div>
                                </div>
								<div class="form-group has-warning">
                                    <label class="col-lg-2 control-label">结束日期</label>
                                    <div class="col-lg-10">
                                        <input type="text" placeholder="" id="endDate" class="form-control">
                                        
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-lg-offset-2 col-lg-10">
                                        <button class="btn btn-primary" onclick="javascript:submitDiscountInfo()" type="button">提交</button>
                                    </div>
                                </div>
								<script>
									function submitDiscountInfo(){
										//alert("a");
										var discountNum = $("#discountNum").val();
										var shapcode = $("#shapcode").val();
										var discountRate = $("#discountRate").val();
										var startDate = $("#startDate").val();
										var endDate = $("#endDate").val();
										var postData = "d_num="+discountNum+"&shapcode="+shapcode+"&disc="+discountRate+
														"&beginDate="+startDate+"&endDate="+endDate;
										$.ajax({
											type:"POST",
											url:"<%= request.getContextPath()%>/supermarket/addDis",
											data:postData,
											dataType:"text",
											success:function(data){
												alert(data);				
											}
										});
									}
								
								</script>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
           
                
        </div>
	</div>
        <!--body wrapper end-->
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
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="js/jquery-migrate-1.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<!--common scripts for all pages-->
<script src="js/scripts.js"></script>

</body>
</html>
