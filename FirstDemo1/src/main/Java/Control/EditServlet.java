package Control;

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
import java.util.List;

/**
 * Created by liuqingyuan on 2017/6/5.
 */
@WebServlet(name = "EditServlet")
public class EditServlet extends HttpServlet {
    @Inject
    private  TestService testServiceImpl;
    ;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String id=request.getParameter("id");
                int Id=Integer.valueOf(id);
       String sql="select * from download_solutions where id="+Id;
            DownloadSolutions editSolution=testServiceImpl.readyEdit(sql);
            request.setAttribute("entity",editSolution);//将lists放到作用域 
            request.getRequestDispatcher("../Edit.jsp").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
