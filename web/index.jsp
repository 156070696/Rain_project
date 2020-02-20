<%@ page import="cn.bdqn.entity.RainManage" %>
<%@ page import="java.util.List" %><%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title></title>
      <style>
          .color{
              background-color: #929292;
          }
          .insert{
              text-decoration: none;
              padding-left: 47%;
          }
      </style>
  </head>
  <body>
  <%
    List<RainManage> list = (List<RainManage>)request.getAttribute("list");
    if(list == null){
      response.sendRedirect("Rain?opr=showAll");
    }
  %>
  <h3 style="text-align: center">雨量监测信息</h3>
  <table align="center" width="1200px" border="1">
      <thead align="center" style="font-weight: bold">
        <tr>
            <td>序号</td>
            <td>区域名称</td>
            <td>检测时间</td>
            <td>雨量值(mm)</td>
            <td>监测站</td>
            <td>站点地址</td>
            <td>操作</td>
        </tr>
      </thead>
      <tbody align="center">
        <c:forEach var="item" items="${list}">
            <tr>
                <td>${item.id}</td>
                <td>${item.districtName}</td>
                <td>${item.monitorTime}</td>
                <td>${item.rain}</td>
                <td>${item.monitoringStation}</td>
                <td>${item.monitoringAddress}</td>
                <td><a href="Rain?opr=delete&id=${item.id}" style="text-decoration:none">删除</a></td>
            </tr>
        </c:forEach>
      </tbody>
  </table>
  <br>
  <a href="insert.jsp" class="insert">新增雨量信息</a>

  <script src="jquery-3.1.1.js"></script>
  <script>
      $(function () {
          $("tr:even").css("background-color", "#a29fa3");//为单数行表格设置背颜色素
      })
  </script>

  </body>
</html>