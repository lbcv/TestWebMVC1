<%--
  Created by IntelliJ IDEA.
  User: 94876
  Date: 2022/9/30
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="usersServlet" method="post">
    <pre>
        id:<input type="text" name="id"/>
        name:<input type="text" name="name"/>
        age:<input type="text" name="age"/>
        <input type="submit" name="sub" value="添加"/>
    </pre>

</form>
</body>
</html>
