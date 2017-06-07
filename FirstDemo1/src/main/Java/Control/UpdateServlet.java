package Control;

import DBDao.DaoService;
import DBDao.SqlDao;
import Mod.DownloadSolutions;
import Service.TestService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liuqingyuan on 2017/6/5.
 */
@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Inject
    private TestService testServiceImpl;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //接收表单提交的值
        String solutionId=request.getParameter("solutionId");
        String className=request.getParameter("className");
        String methodName=request.getParameter("methodName");
        String priority=request.getParameter("priority");
        String downloadable=request.getParameter("downloadable");
        String isEmbeddedSolution=request.getParameter("isEmbeddedSolution");
        String Isx64=request.getParameter("Isx64");
        String remark=request.getParameter("remark");
        String minApiLevel=request.getParameter("minApiLevel");
        String maxApiLevel =request.getParameter("maxApiLevel");
        String crete=request.getParameter("create");
        Timestamp createTime=Timestamp.valueOf(crete);
       /* Date date =new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String now=df.format(date);
        Timestamp creteTime=Timestamp.valueOf(now);*/
        String Id=request.getParameter("id");
        int editId=Integer.valueOf(Id);
        DownloadSolutions newSolution= new DownloadSolutions();
        newSolution.setId(editId);
        if (solutionId!=null&&!"".equals(solutionId)) {
            newSolution.setSolutionId(Integer.valueOf(solutionId));
        }
        if (className!=null&&!"".equals(className)) {
            newSolution.setClassName(className);
        }
        if (methodName!=null&&!"".equals(methodName)) {
            newSolution.setMethodName(methodName);
        }
        if (priority!=null&&!"".equals(priority)) {
            newSolution.setPriority(Integer.valueOf(priority));
        }
        if (downloadable!=null&&!"".equals(downloadable)) {
            newSolution.setDownloadable(Boolean.valueOf(downloadable));
        }
        if (isEmbeddedSolution!=null&&!"".equals(isEmbeddedSolution)) {
            newSolution.setEmbeddedSolution(Boolean.valueOf(isEmbeddedSolution));
        }
        if (Isx64!=null&&!"".equals(Isx64)) {
            newSolution.setIsx64(Boolean.valueOf(Isx64));
        }
        if (remark!=null&&!"".equals(remark)) {
            newSolution.setRemark(remark);
        }
        if (minApiLevel!=null&&!"".equals(minApiLevel)) {
            newSolution.setMinApiLevel(Integer.valueOf(minApiLevel));
        }
        if (maxApiLevel!=null&&!"".equals(maxApiLevel)) {
            newSolution.setMaxApiLevel(Integer.valueOf(maxApiLevel));
        }
        newSolution.setCreatedAt(createTime);

        try {
            testServiceImpl.Edit(editId,newSolution);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("HelloServlet").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
