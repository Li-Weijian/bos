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
    <title>messager</title>
</head>

<script type="text/javascript">
    $(function () {
        //消息框
        //$.messager.alert("标题","消息","info");

        //确认消息框
        /*
            $.messager.confirm("标题","消息",function (r) {
                 alert(r);
            });
        */

        //滑动消息框
       /* $.messager.show({
            title:'My Title',
            msg:'Message will be closed after 5 seconds.',
            timeout:5000,
            showType:'slide'
        });*/

       //进度条
        $.messager.progress();
    });
</script>

</html>
