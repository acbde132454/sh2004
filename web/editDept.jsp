<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/deptSys/DeptController?type=editDept" method="post">
        <input type="hidden" name="deptno" value="${dept.deptno}" />
        部门名称:<input type="text" name="dname" value="${dept.dname}" /><br />
        所在地:<input type="text" name="loc"  value="${dept.loc}" /><br />
        <input type="submit" value="修改部门" /><br />
    </form>
</body>
</html>
