<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/17
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>管理</title>
    <link rel="stylesheet" href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" href="easyui/themes/icon.css">
    <link rel="stylesheet" href="css/manage.css">
</head>
<body>
<%--整体布局开始--%>
<div id="cc" class="easyui-layout" style="width:100%;height:100%;">
    <%--左侧导航栏开始--%>
    <div data-options="region:'west',title:'导航',split:true" style="width:20%;padding: 10px;">
        <ul id="nav"></ul>
    </div>
    <%--左侧导航栏结束--%>
    <%--右侧内容区域开始--%>
    <div data-options="region:'center'" style="padding:5px;background:#eee;overflow: hidden;">
        <div id="tabs">
            <div title="起始页" closable="true" style="padding: 10px;">
                欢迎来到后台管理页面！
            </div>
        </div>
    </div>
    <%--右侧内容区域结束--%>
</div>
<%--整体布局结束--%>
<%--增加商品弹框开始--%>
<div id="p_addPro" style="display: none">
    <form id="p_addForm" action="<%=basePath%>manage/product/add" method="post" style="padding:10px;text-align: center;" enctype="multipart/form-data">
        <div style="margin-bottom:10px;">
            <input name="name" class="easyui-textbox" data-options="prompt:'输入菜名',required:true,"style="width:300px;">
        </div>
        <div style="margin-bottom:10px;">
            <input name="price" class="easyui-textbox" data-options="prompt:'输入价格',required:true,"style="width:300px;">
        </div>
        <div style="margin-bottom:10px;">
            <input name="imgFile" class="easyui-filebox" style="width:300px">
            <%--<input name="imgUrl" class="easyui-textbox" data-options="prompt:'输入图片名',required:true,"style="width:300px;">--%>
        </div>
        <div style="margin-bottom:10px;">
            <input name="info" class="easyui-textbox" data-options="prompt:'输入描述信息',required:true,"style="width:300px;">
        </div>
        <div style="margin-bottom:10px;">
            <input name="number" class="easyui-textbox" data-options="prompt:'输入数量',required:true,"style="width:300px;">
        </div>
        <select  class="easyui-combobox" name="typeId" style="width:200px;">
            <option value="1">今日推荐</option>
            <option value="2">江南小炒</option>
            <option value="3">东北特色</option>
            <option value="4">农家小菜</option>
            <option value="5">夏日特饮</option>
            <option value="6">凉菜</option>
        </select>
    </form>
</div>
<%--增加商品弹框结束--%>
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/manage.js"></script>
</body>
</html>
