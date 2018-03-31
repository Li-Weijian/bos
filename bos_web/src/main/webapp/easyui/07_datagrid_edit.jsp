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
    <title>datagrid</title>

    <script type="text/javascript">
        $(function () {
            $('#dg').datagrid({
                url:'${pageContext.request.contextPath}/json/datagrid_data.json',
                columns:[[
                    {field:'id',title:'编号',width:100,editor:{   type:'validatebox',
                                                                    options:{}
                                                                }},

                    {field:'name',title:'姓名',width:100,editor:{   type:'validatebox',
                        options:{}
                    }},
                    {field:'age',title:'年龄',width:100,align:'right',editor:{   type:'numberbox',
                        options:{}
                    }},
                    {field:'address',title:'出生日期',width:100,align:'right',editor:{   type:'datebox',
                        options:{}
                    }}
                ]],

                toolbar:[
                    {
                        text:'添加',iconCls:'icon-add',
                        handler:function () {
                            $("#dg").datagrid("insertRow",{
                                index:0,
                                row:{}
                            });
                        }
                    },
                    {
                        text:'修改',iconCls:'icon-edit',
                        handler:function () {
                            $("#dg").datagrid("beginEdit",0);
                        }
                    },
                    {
                        text:'添加',iconCls:'icon-add',
                        handler:function () {
                            $("#dg").datagrid("beginAdd",0);
                        }
                    },
                    {
                        text:'完成',iconCls:'icon-save',
                        handler:function () {
                            $("#dg").datagrid("endEdit",0);
                        }
                    }
                ]
            });



        });

    </script>

</head>

<body>

<table id="dg"></table>
</body>

</html>
