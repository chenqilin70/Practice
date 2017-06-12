<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>
<a href="helloworld">HelloWorld</a><br/><br/>
<a href="springmvc/testRequestMapping">testRequestMapping</a><br/><br/>
<a href="springmvc/testMethod">testMethod</a><br/><br/>
<form action="springmvc/testMethod" method="post">
    <input type="submit" name="submit" value="submit"/>
</form>
<a href="springmvc/testParamsAndHeads">testParamsAndHeads1</a><br/><br/>
<a href="springmvc/testParamsAndHeads?username=kylin&age=11">testParamsAndHeads2</a><br/><br/>
<a href="springmvc/testParamsAndHeads?username=kylin&age=10">testParamsAndHeads2</a><br/><br/>
<a href="springmvc/testParamsAndHeads?age=11">testParamsAndHeads2</a><br/><br/>
<a href="springmvc/testPathVariable/1">testPathVariable</a><br/><br/>







<hr/>
<a href="/springmvc/springmvc/testRest/1">Test Rest Get</a><br/><br/>
<form action="/springmvc/springmvc/testRest/1" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    <input type="submit" value="test PUT">
</form>
<br><br>
<form action="/springmvc/springmvc/testRest/1" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" value="test delete">
</form>
<br><br>
<form action="/springmvc/springmvc/testRest" method="post">
    <input type="submit" value="test post">
</form>
<hr/>


<a href="/springmvc/testParam?aaa=111&bbb=false">testParam</a>
<a href="/springmvc/testParam/111">testAnt</a>
<a href="/springmvc/testRequestHeader/111">testRequestHeader</a>
<a href="/springmvc/testCookie">testCookie</a>
<hr/>
<form action="/springmvc/testPOJO" method="post">
    <input type="text" name="username"/>
    <input type="text" name="age"/>
    <input type="text" name="address.province"/>
    <input type="text" name="address.city"/>
    <input type="submit" value="Submit"/>
</form>
<br/>
<br/>
<br/>
<a href="/springmvc/testServletAPI?aaa=123">testServletAPI</a><br>
<a href="/springmvc/testModelAndView">testModelAndView</a>
<a href="/springmvc/testMap">testMap</a>
<a href="/springmvc/testSession">testSession</a>
<hr/>
<form action="/springmvc/testModelAttribute" method="post">
    <input type="text" value="kylin" name="username"/>
    <input type="text" value="12" name="age"/>
    <input type="submit" value="Submit"/>
</form>
<a href="/springmvc/testView" >test View</a><a href="/springmvc/testRedirect">test Redirect</a>
</body>
</html>
