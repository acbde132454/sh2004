<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="/deptSys/css/bootstrap.min.css" />
    <script src="/deptSys/js/jquery-1.8.3.min.js"></script>
  </head>
  <body>
    <h1>欢迎您,【${user.username}】</h1>
     <button class="btn btn-success" onclick="loginOut()">登出</button>

    <table border="1px" width="600px" height="300px" cellspacing="0" align="center">
      <caption><h1 style="text-align: center">部门列表</h1></caption>
      <tr>
        <td colspan="2">
          <a href="/deptSys/DeptController?type=toAddView" class="btn btn-success" target="right">添加员工</a>&nbsp;&nbsp;&nbsp;
          <button class="btn btn-danger" onclick="deleteBatch()">批量删除</button>
        </td>
        <td colspan="3">
          <form action="/deptSys/DeptController?type=deptList" method="post" style="margin-top: 15px">
            <input type="text" placeholder="请输入部门名称" name="dname" value="${dname}" />
            <input type="submit" class="btn btn-primary" value="查询" />
          </form>
        </td>
      </tr>
      <tr>
        <th>
          <input type="checkbox" />
        </th>
        <th>部门编号</th>
        <th>部门名称</th>
        <th>所在地</th>
        <th>操作</th>
      </tr>

      <c:forEach items="${deptList}" var="dept">
        <tr>
          <td>
            <input type="checkbox" class="son" value="${dept.deptno}" />
          </td>
          <td>${dept.deptno}</td>
          <td>${dept.dname}</td>
          <td>${dept.loc}</td>
          <td>
            <a href="/deptSys/DeptController?type=toEditView&deptno=${dept.deptno}" class="btn btn-info">修改</a>
            <button class="btn btn-warning" onclick="deleteBatch()">删除</button>
          </td>
        </tr>
      </c:forEach>

      <tr>
        <td colspan="5">
          <nav aria-label="Page navigation" style="margin-left:250px">
            <ul class="pagination">
              <li>
                <c:if test="${page-1 >= 1}">
                  <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                  </a>
                </c:if>

              </li>
              <c:forEach begin="1" end="${pages}" var="page">
                <li><a href="/deptSys/DeptController?page=${page}&type=deptList&dname=${dname}">${page}</a></li>
              </c:forEach>

              <li>
                <c:if test="${page+1 <= pages}">
                  <a href="/deptSys/DeptController?page=${page+1}&type=deptList&dname=${dname}" aria-label="Next">
                    <span aria-hidden="true" disabled="disabled">&raquo;</span>
                  </a>
                </c:if>
              </li>
            </ul>
          </nav>
        </td>
      </tr>
    </table>
    <script>

      function loginOut() {
        //发出登出请求，调用后台的loginOut方法
        location.href = "/deptSys/UserController?type=loginOut";
      }

      /*
      * 单删和批量删除
      * 思路:
      *   获取所有勾中的复选框，将选中的记录的主键使用,号进行拼接成字符，
      *   将字符串传到后台处理
      * */
      function deleteBatch() {
        var deptnos = [];
        //获取所有勾中的复选框
        $('.son:checked').each(function () {
          deptnos.push($(this).val());
        });
        //将数组调用join():默认使用,号进行分割
        //发送删除请求
        location.href = "/deptSys/DeptController?type=deleteBatch&deptnos="+deptnos.join();
      }
    </script>
  </body>
</html>
