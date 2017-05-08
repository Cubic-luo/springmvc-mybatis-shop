<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/17
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%--<%--%>
    <%--String path = request.getContextPath();--%>
    <%--String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()--%>
            <%--+ path + "/";--%>
<%--%>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>管理</title>--%>
    <%--<link rel="stylesheet" href="easyui/themes/default/easyui.css">--%>
    <%--<link rel="stylesheet" href="easyui/themes/icon.css">--%>
<%--</head>--%>
<%--<body>--%>
<%--编辑表开始--%>
<table id="dg"></table>
<%--编辑表结束--%>
<%--工具栏开始--%>
<div id="tb" style="width: 100%;">
    <div>
        <a href="#" id="agree" class="easyui-linkbutton" iconCls="icon-ok" plain="true">批准</a>
        <a href="#" id="cancel" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">驳回</a>
        <a href="#" id="delete" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
        <a href="#"  class="easyui-linkbutton tbSubmit" onclick="obj.search()" iconCls="icon-search">查询</a>
        <input type="text" class="tbSearch" name="username" placeholder="请输入用户名">
    </div>
</div>
<%--工具栏结束--%>
<%--<script type="text/javascript" src="easyui/jquery.min.js"></script>--%>
<%--<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>--%>
<%--<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>--%>
<script type="text/javascript" src="js/discuss.js"></script>
<%--</body>--%>
<%--</html>--%>
