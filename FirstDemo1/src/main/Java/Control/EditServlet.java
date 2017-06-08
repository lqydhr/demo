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

/**
 * Created by liuqingyuan on 2017/6/5.
 */
@WebServlet(name = "EditServlet")
public class EditServlet extends HttpServlet {
    @Inject
    private DownloadSolutionService downloadSolutionServiceImpl;
    ;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String id=request.getParameter("id");
                int editId=Integer.valueOf(id);
       String sql=" from DownloadSolutionsEntity where Id="+editId;
            DownloadSolutionsEntity editSolution= downloadSolutionServiceImpl.readyEdit(sql);
            request.setAttribute("entity",editSolution);//将lists放到作用域 
            request.getRequestDispatcher("../Edit.jsp").forward(request,response);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
