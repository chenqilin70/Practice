<%--
  Created by IntelliJ IDEA.
  User: aierxuan
  Date: 2017/6/12
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.0.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#testJson").click(function(){
                $.post(this.href,{},function (data) {
                    console.log(data)
                })
                return false;
            });
        })
    </script>
</head>
<body>
    <a href="emps">list all employees</a>
    <br><<br>
    <a href="testJson" id="testJson">Test Json</a>
    <br><br>
    <form action="testHttpMessageConverter" method="post" enctype="multipart/form-data">
        file:<input type="file" name="testFile" /><br>
        desc:<input type="text" name="desc" />

        <input type="submit" value="Submit"/>
    </form>
<br><br>
<a href="testResponseEntity">testResponseEntity</a>
<a href="i18n">i18n page</a>
<hr/>
    <form action="testFileUpload" method="post" enctype="multipart/form-data">
        file:<input type="file" name="testFile" /><br>
        desc:<input type="text" name="desc" />

        <input type="submit" value="Submit"/>
    </form>
<a href="testExceptionHandlerExceptionResolver?i=10">testExceptionHandlerExceptionResolver</a>
<a href="testResponseStatusExceptionHandler?i=10">testResponseStatusExceptionHandler</a>
</body>
</html>
