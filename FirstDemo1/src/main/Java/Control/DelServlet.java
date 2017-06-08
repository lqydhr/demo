package Control;

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
@WebServlet(name = "DelServlet")
public class DelServlet extends HttpServlet {
    @Inject
    private DownloadSolutionService downloadSolutionServiceImpl;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null && !"".equals(id))
            try {
                downloadSolutionServiceImpl.del(Integer.valueOf(id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        request.getRequestDispatcher("RetrieveServlet").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
