package Control;

import Mod.DownloadSolutionsEntity;
import Service.DownloadSolutionService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by liuqingyuan on 2017/6/5.
 */
@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Inject
    private DownloadSolutionService downloadSolutionServiceImpl;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //接收表单提交的值
        String solutionId = request.getParameter("solutionId");
        String className = request.getParameter("className");
        String methodName = request.getParameter("methodName");
        String priority = request.getParameter("priority");
        String downloadable = request.getParameter("downloadable");
        String isEmbeddedSolution = request.getParameter("isEmbeddedSolution");
        String isx64 = request.getParameter("Isx64");
        String remark = request.getParameter("remark");
        String minApiLevel = request.getParameter("minApiLevel");
        String maxApiLevel = request.getParameter("maxApiLevel");
        String crete = request.getParameter("create");
        Timestamp createTime = Timestamp.valueOf(crete);
        String Id = request.getParameter("id");
        int editId = Integer.valueOf(Id);
        DownloadSolutionsEntity newSolution = new DownloadSolutionsEntity();
        newSolution.setId(editId);
        if (solutionId != null && !"".equals(solutionId)) {
            newSolution.setSolutionId(Integer.valueOf(solutionId));
        }
        if (className != null && !"".equals(className)) {
            newSolution.setClassName(className);
        }
        if (methodName != null && !"".equals(methodName)) {
            newSolution.setMethodName(methodName);
        }
        if (priority != null && !"".equals(priority)) {
            newSolution.setPriority(Integer.valueOf(priority));
        }
        if (downloadable != null && !"".equals(downloadable)) {
            newSolution.setDownloadable(Boolean.valueOf(downloadable));
        }
        if (isEmbeddedSolution != null && !"".equals(isEmbeddedSolution)) {
            newSolution.setEmbeddedSolution(Boolean.valueOf(isEmbeddedSolution));
        }
        if (isx64 != null && !"".equals(isx64)) {
            newSolution.setIsx64(Boolean.valueOf(isx64));
        }
        if (remark != null && !"".equals(remark)) {
            newSolution.setRemark(remark);
        }
        if (minApiLevel != null && !"".equals(minApiLevel)) {
            newSolution.setMinApiLevel(Integer.valueOf(minApiLevel));
        }
        if (maxApiLevel != null && !"".equals(maxApiLevel)) {
            newSolution.setMaxApiLevel(Integer.valueOf(maxApiLevel));
        }
        newSolution.setCreatedAt(createTime);

        try {
            downloadSolutionServiceImpl.Edit(newSolution);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("RetrieveServlet").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
