<%--
  Created by IntelliJ IDEA.
  User: ajacker
  Date: 2019/10/16
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="/js/jquery-3.4.1.min.js"></script>
<script>
    // 页面加载，绑定单击事件
    $(function () {
        $("#btn").click(function () {
            // 发送ajax请求
            $.ajax({
                // 配置请求参数
                url: "/account/testAjax",
                contentType: "application/json;charset=UTF-8",
                dataType: "json",
                type: "post",
                // 请求的json数据
                data: '{"username":"myname","age":30}',
                // 回调函数,处理服务器返回的数据returnData
                success: function (returnData) {
                    // 我们假定服务器返回的是一个account对象,将其输出在控制台上
                    console.log(returnData);
                }
            });
        });
    });
</script>
<body>
    <h3>入门程序</h3>
    <a href="account/hello">入门程序</a>
    <form action="account/updateAccount" method="post">
        <label>名称</label><input type="text" name="username"><br/>
        <label>年龄</label><input type="text" name="age"><br/>
        <input type="submit" value="保存">
    </form>
    <button id="btn">发送请求</button>
    <h3>普通文件上传</h3>
    <form action="fileUpload/uploadHandler" method="post" enctype="multipart/form-data">
        选择文件<input type="file" name="fileParam"/><br/>
        <input type="submit" value="上传文件"/>
    </form>
    <h3>mvc文件上传</h3>
    <form action="fileUpload/mvcUploadHandler" method="post" enctype="multipart/form-data">
        选择文件<input type="file" name="fileParam"/><br/>
        <input type="submit" value="上传文件"/>
    </form>
    <h3>跨服务器文件上传</h3>
    <form action="fileUpload/betweenUploadHandler" method="post" enctype="multipart/form-data">
        选择文件<input type="file" name="fileParam"/><br/>
        <input type="submit" value="上传文件"/>
    </form>
    <!-- SessionAttribute 注解的使用 -->
    <a href="session/testPut">存入 SessionAttribute</a>
    <hr/>
    <a href="session/testGet">取出 SessionAttribute</a>
    <hr/>
    <a href="session/testClean">清除 SessionAttribute</a>
</body>
</html>
