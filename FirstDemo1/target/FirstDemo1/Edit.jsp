<%@ page import="Mod.DownloadSolutions" %><%--
  Created by IntelliJ IDEA.
  User: liuqingyuan
  Date: 2017/6/5
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<link href="bootStrap.css" rel="stylesheet" type="text/css"/>
<%
    DownloadSolutions editSolution=(DownloadSolutions)request.getAttribute("entity");
%>
<script>
    var op=document.createElement("option");
    if<%=editSolution.isDownloadable()%>){
        op.innerHTML='是';
        op.setAttribute("value","true");
    }
    else{
        op.innerHTML='否';
        op.setAttribute("value","false");
    }
    document.getElementById("five").appendChild(op);
    if<%=editSolution.isEmbeddedSolution()%>){
        op.innerHTML='是';
        op.setAttribute("value","true");
    }
    else{
        op.innerHTML='否';
        op.setAttribute("value","false");
    }
    document.getElementById("six").appendChild(op);
    if<%=editSolution.isIsx64()%>){
        op.innerHTML='是';
        op.setAttribute("value","true");
    }
    else{
        op.innerHTML='否';
        op.setAttribute("value","false");
    }
    document.getElementById("seven").appendChild(op);

</script>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form id="form" name="editForm" action="UpdateServlet" method="post">
    <table  class="table table-striped">
        <tr>
            <td><label  style="width: 320px "> 种子方案号</label> <input id="one" type="text" style="text-align: center" value="<%=editSolution.getSolutionId()%>" name="solutionId" /></td>
        </tr>
        <tr>
            <td><label  style="width: 320px "> 类名</label><input id="two"  style="text-align: center" type="text" value="<%=editSolution.getClassName()%>"  name="className"  /></td>
        </tr>
        <tr>
            <td><label  style="width: 320px "> 方法名</label> <input id="three"  style="text-align: center" type="text" value="<%=editSolution.getMethodName()%>" name="methodName"  /></td>
        </tr>
        <tr>
            <td><label  style="width: 320px "> 优先级</label><input id="four"  title="" style="text-align: center" type="text" value="<%=editSolution.getPriority()%>" name="priority"  /></td>
        </tr>
        <tr>
            <td><label  style="width: 320px "> 方案是否下发</label><select id="five"  style="text-align: center"    name="downloadable">

                <option id="down1" value="true" style="width: 100px">是</option>
                <option id="down2" value="false" style="width: 100px">否</option>

            </select>
            </td>
        </tr>
        <tr>
            <td><label  style="width: 320px "> 是否为内置方案</label><select id="six"  style="text-align: center"  name="isEmbeddedSolution" >

                <option id="dow1" value="true" style="width: 100px">是</option>
                <option id="dow2" value="false" style="width: 100px">否</option>


            </select>
            </td>
        </tr>
        <tr>
            <td width="100"><label  style="width: 320px "> 是否为x64</label><select id="seven"  style="text-align: center"  name="Isx64" >

                <option id="Satuts1" value="true" style="width: 100px">是</option>
                <option id="Satuts2" value="false" style="width: 100px">否</option>

            </select>

            </td>

        </tr>
        <tr>
            <td><label  style="width: 320px "> 最小SDK版本号</label>
                <input id="eight"  style="text-align: center" value="<%=editSolution.getMinApiLevel()%>" name="minApiLevel" type="text">
            </td>
        </tr>
        <tr>
            <td><label  style="width: 320px "> 最大SDK版本号</label>
                <input id="nine"  style="text-align: center" name="maxApiLevel" value="<%=editSolution.getMaxApiLevel()%>" type="text">
            </td>
        </tr>
        <tr>
            <td><label  style="width: 320px "> Jar包说明</label>
                <input id="ten"  style="text-align: center" name="remark" value="<%=editSolution.getRemark()%>" type="text">
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" value="提交" onclick="submit()">
                <input type="text" name="id" value="<%=editSolution.getId()%>" style="visibility:hidden" />
                <input type="text " name="create" value="<%=editSolution.getCreatedAt()%>" style="visibility: hidden">
            </td>
        </tr>

    </table>


</form>

</body>
</html>
