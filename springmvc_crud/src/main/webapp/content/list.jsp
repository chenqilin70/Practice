
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.0.min.js"></script>
    <script>
        $(function(){
            console.log("1212")
            $(".deleteLink").click(function(){
               var $this=$(this);
               var $form=$("<form>").attr("action","emp/"+$this.attr("id"))
                    .attr("method","post");
               var $input=$("<input>").attr("type","hidden")
                   .attr("name","_method").attr("value","DELETE");
               $form.append($input);
                $form.submit();
               return false;
            });
        })
    </script>
</head>
<body>
    <h1>list page</h1>

        <table>
            <thead>
                <tr>
                    <th>账号</th>
                    <th>姓氏</th>
                    <th>邮箱</th>
                    <th>性别</th>
                    <th>部门</th>
                    <th>编辑</th>
                    <th>删除</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.emps }" var="emp">
                    <tr>
                        <td>${emp.id}</td>
                        <td>${emp.lastName}</td>
                        <td>${emp.email}</td>
                        <td>${emp.gender==true?'男':'女'}</td>
                        <td>${emp.department.departmentName}</td>
                        <td><a href="emp/${emp.id}">Edit</a></td>
                        <td><a class="deleteLink" id="${emp.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
<br><br>
<a href="emp">Add New Employee</a>
</body>
</html>
