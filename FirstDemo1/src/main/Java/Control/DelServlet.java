package Control;

import Service.TestService;

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
@WebServlet(name = "DelServlet")
public class DelServlet extends HttpServlet {
    @Inject
    private TestService testServiceImpl;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Id=request.getParameter("id");
        if (Id!=null&&!"".equals(Id))
        try {
            testServiceImpl.del(Integer.valueOf(Id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("HelloServlet").forward(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
