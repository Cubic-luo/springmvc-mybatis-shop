<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/17
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--编辑表开始--%>
<table id="p_dg"></table>
<%--编辑表结束--%>
<%--工具栏开始--%>
<div id="p_tb" style="width: 100%;">
    <div>
        <a href="#" id="p_add" class="easyui-linkbutton" iconCls="icon-add" plain="true">增加</a>
        <a href="#" id="p_modify" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="#" id="p_delete" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
        <a href="#"  class="easyui-linkbutton tbSubmit" onclick="obj.search()" iconCls="icon-search">查询</a>
        <input type="text" class="tbSearch" name="username" placeholder="请输入用户名">
    </div>
</div>
<script type="text/javascript" src="js/product.js"></script>

