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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/js/ztree/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.all-3.5.js"></script>
    <title>ztree</title>
</head>


<body class="easyui-layout">
    <div title="XXX管理系统" style="height: 100px;" data-options="region:'north'">北部区域</div>
    <div title="系统菜单" style="width: 200px;" data-options="region:'west'">
        <%--
            fit:true 折叠面板自适应（填充父面板）
            data-options="iconCls:'icon-cut'"  添加图标，具体图标在/js/easyui/themes/icon.css下找
        --%>
        <div class="easyui-accordion" data-options="fit:true">
            <div data-options="iconCls:'icon-cut'" title="面板一">
                <a id="but1" class="easyui-linkbutton">添加一个选项卡</a>

                <!-- 动态添加面板的脚本（位置不限） -->
                <script type="text/javascript">
                    $(function () {
                        $("#but1").click(function () {

                            //判断该面板是否存在
                            var e = $("#tab").tabs("exists","系统菜单");
                            if (e){
                                //存在，则选中
                                $("#tab").tabs("select","系统菜单");
                            }else {
                                //不存在，则添加
                                /*
                                    选中面板对象，调用tabs方法，传入add方法
                                    参数一：add  方法
                                    参数二：json对象。此处为添加面板的属性
                                */
                                $("#tab").tabs("add",{
                                    title:"系统菜单",
                                    closable:true
                                });
                            }
                        });
                    });
                </script>
            </div>
            <div title="面板二">
                <ul class="ztree" id="ztree"></ul>

                <!-- 使用简单的json数据构造树 -->
                <script type="text/javascript">
                    $(function () {
                        var setting = {
                            data: {
                                simpleData: {
                                    enable: true
                                }
                            }
                        };

                        var treeNodes = [
                            {"id":1, "pId":0, "name":"test1"},
                            {"id":11, "pId":1, "name":"test11"},
                            {"id":12, "pId":1, "name":"test12"},
                            {"id":111, "pId":11, "name":"test111"}
                        ];

                        $.fn.zTree.init($("#ztree"), setting, treeNodes);
                    });
                </script>
            </div>
            <div title="面板三">
                <!-- 使用ajax读取json文件构造ztree -->
                <ul class="ztree" id="ztree2"></ul>

                <script type="text/javascript">
                    $(function () {

                        var setting = {
                            data: {
                                simpleData: {
                                    enable: true
                                }
                            },
                            //回调函数
                            callback: {
                                //节点被点击触发
                                onClick: function (event, treeId, treeNode) {
                                    if(treeNode.page != undefined){
                                        var e = $("#tab").tabs("exists",treeNode.name);
                                        if (e){
                                            $("#tab").tabs("select",treeNode.name);
                                        }else {
                                            $("#tab").tabs("add",{
                                                title:treeNode.name,
                                                closable:true,
                                                content:'<iframe frameborder="0" height="100%" width="100%" src="'+treeNode.page+'"></iframe>'
                                            })
                                        }
                                    }
                                }
                            }
                        };

                        //发送ajax请求
                        var url = "${pageContext.request.contextPath}/json/menu.json";
                        $.post(url,{},function (data) {
                            $.fn.zTree.init($("#ztree2"), setting, data);
                        });

                    });
                </script>
            </div>
        </div>
    </div>

    <div data-options="region:'center'">

        <%--
            和折叠面板一样，只需要修改class名即可
            data-options="closable:true"  提供关闭按钮
        --%>
        <div id="tab" class="easyui-tabs" data-options="fit:true">
            <div data-options="iconCls:'icon-cut'" title="面板一">111</div>
            <div data-options="closable:true" title="面板二">222</div>
            <div title="面板三">333</div>
        </div>
    </div>
    <div style="width: 100px;" data-options="region:'east'">东部区域</div>
    <div style="height: 50px;" data-options="region:'south'">南部区域</div>
</body>
</html>
