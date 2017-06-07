<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Mod.User" %>
<%@ page import="Mod.DownloadSolutions" %>

<%--<script type="text/javascript">

</script>--%>
<script>
function add() {
window.location.href=""
}
function deleteById(delId) {
   if (confirm("确认要删除吗"))
    {
        window.location.href = "DelServlet?id=" + delId;
        return true;
    }
    return false;
}
function Edit(EditId){
    window.location.href = "EditServlet?id=" + EditId;


}
</script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link href="bootStrap.css" rel="stylesheet" type="text/css"/>
<html>



<body>

<% List<DownloadSolutions> list =(List<DownloadSolutions>)request.getAttribute("list");
%>
<table class="table table-striped" width="95%" >
   <tr>
        <td colspan="9" width="100%" style="text-align: left">
<%--
            <button name="新增" style="text-align:right"   type="submit" onclick="add()">新增</button>
--%>
            <a href="../addAndDetail.jsp" style="text-align:left">上传可下载种子方案</a>
        </td>
    </tr>
    <tr>
      <%--  <td width="100" style="text-align: center">
            选择
        </td>--%>
        <td width="100" style="text-align: center">

            方案Id号</td>
        <td width="80" style="text-align: center">

            优先级
        </td>
        <td width="80" style="text-align: center">
            是否下发
        </td>
        <td width="80" style="text-align: center">
            是否内置方案
        </td>
        <td width="80" style="text-align: center">
            是否为64位
        </td>
        <td width="80" style="text-align: center">
            最小sdk版本
        </td>
        <td width="80" style="text-align: center">
            最大sdk版本
        </td>
        <td width="200" style="text-align: center">
            MD5
        </td>
        <td style="text-align: center">
            说明
        </td>
    </tr>
<%
    for (int j=0; j<list.size();j++){
        DownloadSolutions download =list.get(j);

%>
<tr>
   <%-- <td>

        <input type="checkbox"  name="check" value="<%=download.getId() %>" >

    </td>--%>
    <td style="text-align:center">
        <%=download.getSolutionId() %></td>
    <td contenteditable="true" style="text-align:center">
        <%=download.getPriority()%>
    </td>
    <td style="text-align:center">
        <%=download.isDownloadable()%>
    </td>
    <td style="text-align:center">
        <%=download.isEmbeddedSolution()%>
    </td>
    <td contenteditable="true" style="text-align:center">
    <%=download.isIsx64()%>
    </td>
    <td contenteditable="true" style="text-align:center">
        <%=download.getMinApiLevel()%>
    </td>
    <td contenteditable="true" style="text-align:center">
        <%=download.getMaxApiLevel()%>
    </td>

    <td contenteditable="true" style="text-align:center">
        <%=download.getFile_md5()%>
    </td>
    <td  style="text-align:center">
        <%=download.getRemark()%>

    <input type="button" name="del" value="删除"   onclick="javascript:deleteById('<%=download.getId() %>')" />
    <input type="button" name="Edit" value="编辑"   onclick="javascript:Edit('<%=download.getId() %>')" />

    </td>
</tr>
    <%
        }
    %>
</table>


</body>
</html>
