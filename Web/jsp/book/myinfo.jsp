<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    pageContext.setAttribute("basePath", basePath);
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <base href="${basePath}">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>我的个人信息</title>
    <link rel="stylesheet" href="bs/css/bootstrap.css">
    <script type="text/javascript" src="bs/js/jquery.min.js"></script>
    <script type="text/javascript" src="bs/js/bootstrap.js"></script>
    <script type="text/javascript" src="js/book/landing.js"></script>
    <link href="css/book/head_footer.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        body{
            margin:0;
            padding:0;
            background:#eee;
        }

        .container .row{
            line-height: 30px;
            htight:30px;
        }


    </style>

</head>
<body>
<div class="container-fullid">
    <%@include file="header.jsp" %>
    <div class="wrapper">
        <div class="main container">
            <h2 class="text-center">个人信息</h2>
            <div class="container">
                <div class="row">
                    <div class="col-md-2 text-right">用户编号</div>
                    <div class="col-md-10">${userInfo.userId}</div>
                </div>
                <div class="row">
                    <div class="col-md-2 text-right">用户名</div>
                    <div class="col-md-10">${userInfo.userName}</div>
                </div>
                <div class="row">
                    <div class="col-md-2 text-right">用户密码</div>
                    <div class="col-md-10">${userInfo.userPassWord}</div>
                </div>
                <div class="row">
                    <div class="col-md-2 text-right">姓名</div>
                    <div class="col-md-10">${userInfo.name}</div>
                </div>
                <div class="row">
                    <div class="col-md-2 text-right">性别</div>
                    <div class="col-md-10">${userInfo.sex}</div>
                </div>
                <div class="row">
                    <div class="col-md-2 text-right">年龄</div>
                    <div class="col-md-10">￥${userInfo.age}</div>
                </div>
                <div class="row">
                    <div class="col-md-2 text-right">电话</div>
                    <div class="col-md-10">${userInfo.tell}</div>
                </div>
                <div class="row">
                    <div class="col-md-2 text-right">地址</div>
                    <div class="col-md-10">${userInfo.address}</div>
                </div>
<%--                <div class="row">--%>
<%--                    <div class="col-md-2 text-right">启用状态</div>--%>
<%--                    <div class="col-md-10">--%>
<%--                        <c:choose>--%>
<%--                            <c:when test="${i.enabled eq 'y'}">--%>
<%--                                <span style="background:green;color:#fff">启用</span>--%>
<%--                            </c:when>--%>
<%--                            <c:otherwise>--%>
<%--                                <span style="background:red;color:#fff">禁用</span>--%>
<%--                            </c:otherwise>--%>
<%--                        </c:choose>--%>
<%--                    </div>--%>
<%--                </div>--%>
            </div>
        </div>
    </div>


    <%@include file="footer.jsp" %>
</div>
</body>
</html>