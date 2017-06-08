package Control;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import DataBaseDao.SqlDao;
import Mod.DownloadSolutionsEntity;
import Mod.DownloadSolutionsEntity;
import Service.DownloadSolutionService;

/**
 * Created by liuqingyuan on 2017/5/17.
 */
@WebServlet(name = "RetrieveServlet")
public class RetrieveServlet extends HttpServlet {
    @Inject
    private DownloadSolutionService downloadSolutionServiceImpl;
    @Inject
    private SqlDao hello;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String sql = "from DownloadSolutionsEntity";
        List<DownloadSolutionsEntity> list = downloadSolutionServiceImpl.getName(sql);
        request.setAttribute("list", list);//将lists放到作用域  
        request.getRequestDispatcher("../index.jsp").forward(request, response);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


}