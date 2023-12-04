<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>员工信息表</title>
  <script src="js/jquery.js"></script>
  <style>
    #a{
      text-align: center;

    }
  </style>
</head>
<body>
<c:if test="${empty list}">
  <c:redirect url="/Employee?opr=findAll"/>
</c:if>


<h1 align="center">电子图书列表</h1>
<table border="1px" width="50%" align="center">

  <tr>
    <th>员工编号</th>
    <th>员工姓名</th>
    <th>出生日期</th>
    <th>部门编号</th>
    <th>操作</th>
  </tr>
  <c:forEach items="${list}" var="s" varStatus="vs">
    <tr  style="background-color: ${vs.count%2==0?"pink":"skyblue"}">
      <td>${s.eno}</td>
      <td>${s.ename}</td>
      <td>${s.brithday}</td>
      <td>${s.did ==1?"人事部":"财务部"}</td>

      <td><a href="/Employee?opr=Bid&eno=${s.eno}">编辑</a>
        <a href="javascript:void(0)" onclick="del(${s.eno},this)">删除</a> </td>
    </tr>
  </c:forEach>
</table>
<p id="a"><a href="add.jsp" >新增员工</a></p>
<script>
  function del(id,obj){

    $.getJSON("/Employee?opr=del&id="+id ,callback);
    //回调函数
    function callback(date){
      if(date==true){
        //删除成功
        alert("删除成功");
        $(obj).parent().parent().remove();
      }else{
        alert("删除失败")
      }
    }
  }
</script>
</body>
</html>
