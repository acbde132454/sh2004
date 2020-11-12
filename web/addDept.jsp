<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/deptSys/DeptController?type=addDept" method="post">
        部门名称:<input type="text" name="dname" /><br />
        所在地:<input type="text" name="loc" /><br />
        <input type="submit" value="添加部门" /><br />
    </form>
</body>
</html>
