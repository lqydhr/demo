<%--
  Created by IntelliJ IDEA.
  User: liuqingyuan
  Date: 2017/5/31
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="bootStrap.css" rel="stylesheet" type="text/css"/>

<html>

<head>
    <title>新增页面</title>
</head>
<body>
<form id="form" name="addForm" action="Control/AddServlet" method="post">
    <table  class="table table-striped">
        <tr>
            <td><label  style="width: 320px "> 种子方案号</label> <input id="one" type="text" style="text-align: center" value="" name="solutionId" /></td>
        </tr>
        <tr>
            <td><label  style="width: 320px "> 类名</label><input id="two"  style="text-align: center" type="text" name="className"  /></td>
        </tr>
        <tr>
            <td><label  style="width: 320px "> 方法名</label> <input id="three"  style="text-align: center" type="text" name="methodName"  /></td>
        </tr>
        <tr>
            <td><label  style="width: 320px "> 优先级</label><input id="four"  style="text-align: center" type="text" name="priority"  /></td>
        </tr>
        <tr>
            <td><label  style="width: 320px "> 方案是否下发</label><select id="five"  style="text-align: center"  name="downloadable" >

                <option id="isable" value="">     </option>
                <option id="down1" value="true" style="width: 100px">是</option>
                <option id="down2" value="false" style="width: 100px">否</option>

            </select>
            </td>
        </tr>
        <tr>
            <td><label  style="width: 320px "> 是否为内置方案</label><select id="six"  style="text-align: center"  name="isEmbeddedSolution" >

                <option id="kong" value="">     </option>
                <option id="sol" value="true" style="width: 100px">是</option>
                <option id="solution" value="false" style="width: 100px">否</option>

            </select>
            </td>
        </tr>
        <tr>
            <td width="100"><label  style="width: 320px "> 是否为x64</label><select id="seven"  style="text-align: center"  name="Isx64" >

                <option id="empty" value="">     </option>
                <option id="Satuts1" value="true" style="width: 100px">是</option>
                <option id="Satuts2" value="false" style="width: 100px">否</option>

            </select>

              </td>

        </tr>
        <tr>
            <td><label  style="width: 320px "> 最小SDK版本号</label>
            <input id="eight"  style="text-align: center" name="minApiLevel" type="text">
            </td>
        </tr>
        <tr>
            <td><label  style="width: 320px "> 最大SDK版本号</label>
             <input id="nine"  style="text-align: center" name="maxApiLevel" type="text">
            </td>
        </tr>
        <tr>
            <td><label  style="width: 320px "> Jar包说明</label>
                <input id="ten"  style="text-align: center" name="remark" type="text">
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" value="提交" onclick="submit()">
                <input type="reset" value="重设">
                <a href="Control/HelloServlet" >返回 </a>
            </td>
        </tr>
    </table>


</form>

</body>
<script type="text/javascript">
    function submit() {
        var dee=document.getElementById("userId").value;
    if(dee==""){
        alert("请输入用户名！");
        document.getElementById("userId").focus()
        }

    }
</script>
</html>
