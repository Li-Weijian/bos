<%--
  Created by IntelliJ IDEA.
  User: 35264
  Date: 2018/2/23 0023
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
    <title>menubutton</title>
</head>

<body>
    <!-- 使用menu与div进行关联 -->
    <a class="easyui-menubutton" data-options="iconCls:'icon-help',menu:'#myMenubutton'">控制面板</a>

    <div id="myMenubutton">
        <div data-options="iconCls:'icon-edit'">修改密码</div>
        <div>联系管理员</div>
        <%--分隔符--%>
        <div class="menu-sep"></div>
        <div>退出系统</div>
    </div>

</body>

</html>
