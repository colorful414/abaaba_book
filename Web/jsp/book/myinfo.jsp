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
    <title>订单提交成功</title>
    <link rel="stylesheet" href="bs/css/bootstrap.css">
    <script type="text/javascript" src="bs/js/jquery.min.js"></script>
    <script type="text/javascript" src="bs/js/bootstrap.js"></script>
    <script type="text/javascript" src="js/book/landing.js"></script>
    <link rel="stylesheet" type="text/css" href="bs/validform/style.css">
    <script type="text/javascript" src="bs/validform/Validform_v5.3.2_min.js"></script>
    <script type="text/javascript" src="js/admin/userManage/userEdit.js"></script>
    <link href="css/book/head_footer.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        .wrapper{
            min-height:500px;
        }
        /* 分页样式 */
        .wrapper .pager{
            border-top:1px #eee solid;
            padding-top:15px;
        }
        .wrapper .pager .page-div{
            display: inline-block;
            width:110px;
        }
        .wrapper .homePage,.wrapper .prePage,.wrapper .page-go,.wrapper .nextPage,.lastPage{
            border-radius:15px;
            color:#d7006d;
        }


        .wrapper #page-input{
            display:inline-block;
            width:60px;
            border-radius: 10px;
        }
        .wrapper .bookImg{
            width:50px;
        }
        .wrapper .funbtn{
            margin:10px 0;
        }
        .wrapper .funbtn a{
            margin-right:10px;
        }


    </style>

</head>
<body>
<div class="container-fullid">
    <%@include file="header.jsp" %>
    <div class="wrapper">
        <div class="main container">
            <c:if test="${!empty userMessage}">
                <h3 class="text-center">${userMessage}</h3>
            </c:if>
            <div class="container">
                <h2 class="text-center">用户修改</h2>
                <form id="myForm" action="jsp/admin/UserManageServlet?action=update" method="post" class="form-horizontal">
                    <input type="hidden" name="userId" value="${userInfo.userId}">
                    <div class="form-group">
                        <%--@declare id="username"--%><label for="userName" class="col-md-2 col-md-offset-2 control-label">用户名：</label>
                        <div class="col-md-4">
                            <p class="form-control-static">${userInfo.userName}</p>
                        </div>

                    </div>
                    <div class="form-group">
                        <label for="passWord" class="col-md-2 col-md-offset-2 control-label">密码：</label>
                        <div class="col-md-4">
                            <input type="password" name="passWord" id="passWord" class="form-control" value="${userInfo.userPassWord }">
                        </div>
                        <div class="col-md-4">
                            <span class="Validform_checktip"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="c_passWord" class="col-md-2 col-md-offset-2 control-label">确认密码：</label>
                        <div class="col-md-4">
                            <input type="password" name="c_passWord" id="c_passWord" class="form-control" value="${userInfo.userPassWord }">
                        </div>
                        <div class="col-md-4">
                            <span class="Validform_checktip"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-2 col-md-offset-2 control-label">姓名：</label>
                        <div class="col-md-4">
                            <input type="text" id="name" name="name" class="form-control" value="${userInfo.name }">
                        </div>
                        <div class="col-md-4">
                            <span class="Validform_checktip"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 col-md-offset-2 control-label">性别：</label>
                        <div class="col-md-4 ">
                            <c:choose>
                                <c:when test="${userInfo.sex eq '男'}">
                                    <label class="radio-inline">
                                        <input type="radio" name="sex" id="sex" checked="checked" class="pr1" value="男">男
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="sex"  class="pr1"  value="女">女
                                    </label>
                                </c:when>
                                <c:otherwise>
                                    <label class="radio-inline">
                                        <input type="radio" name="sex" id="sex1" class="pr1" value="男">男
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="sex" checked="checked"  class="pr1"  value="女">女
                                    </label>
                                </c:otherwise>
                            </c:choose>

                        </div>

                    </div>
                    <div class="form-group">
                        <label for="age" class="col-md-2 col-md-offset-2 control-label">年龄：</label>
                        <div class="col-md-4">
                            <input type="text" id="age" name="age" class="form-control" value="${userInfo.age }">
                        </div>
                        <div class="col-md-4">
                            <span class="Validform_checktip"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tell" class="col-md-2 col-md-offset-2 control-label">电话：</label>
                        <div class="col-md-4">
                            <input type="text" id="tell" name="tell" class="form-control" value="${userInfo.tell }">
                        </div>
                        <div class="col-md-4">
                            <span class="Validform_checktip"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="address" class="col-md-2 col-md-offset-2 control-label">地址：</label>
                        <div class="col-md-4">
                            <input type="text" id="address" name="address" class="form-control" value="${userInfo.address }">
                        </div>
                        <div class="col-md-4">
                            <span class="Validform_checktip"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="enabled" class="col-md-2 col-md-offset-2 control-label">启用状态</label>
                        <div class="col-md-4">
                            <select class="form-control" name="enabled" id="enabled">
                                <c:choose>
                                    <c:when test="${userInfo.enabled eq 'y'}">
                                        <option value="y" selected="selected">启用</option>
                                        <option value="n">禁用</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="y">启用</option>
                                        <option value="n" selected="selected">禁用</option>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2  control-label col-md-offset-2">
                            <input class="btn btn-success btn-block" type="submit" value="更改">
                        </label>
                        <label class="col-md-2 control-label">
                            <input class="btn btn-warning btn-block" type="reset" value="重置">
                        </label>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <%@include file="footer.jsp" %>
</div>
</body>
</html>