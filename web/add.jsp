
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加页面</title>


</head>
<body>

 <h1 align="center"  >增加员工表</h1>
<table align="center" >
    <form method="post" action="/Employee?opr=add">
    <tr>
        <td>员工名称</td>
        <td><input type="text" name="ename"  required ></td>
    </tr>
    <tr>
        <td>出生日期</td>
        <td><input type="Date" name="brithday"></td>
    </tr>
    <tr>
        <td>部门编号</td>
        <td>
        <select name="did">
            <option value="1">市场部</option>
            <option value="2">人事部</option>
            <option value="3">财务部</option>

        </select>
        </td>

    <tr>
        <td>
            <input type="submit" value="提交">
            <input type="reset" value="取消">
        </td>

    </tr>
    </form>
</table>


</body>
</html>
