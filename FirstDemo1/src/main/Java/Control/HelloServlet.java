package Control;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import DBDao.SqlDao;
import Mod.DownloadSolutions;
import Service.TestService;

/**
 * Created by liuqingyuan on 2017/5/17.
 */
@WebServlet(name = "HelloServlet")
public class HelloServlet extends HttpServlet {
 @Inject
 private TestService testServiceImpl;
@Inject
 private SqlDao hello;
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String sql = "from DownloadSolutions";
        //"select id,solution_id,class_name,method_name,file_md5,create_at,update_at,priority,downloadable,remark" +
            //    "min_api_level,max_api_level,is_x64,is_embedded_solution from download_solutions order by id desc";
       /// String sql= "select * from download_solutions order by id desc";
        List<DownloadSolutions> list =testServiceImpl.getName(sql);
        request.setAttribute("list",list);//将lists放到作用域  
        request.getRequestDispatcher("../index.jsp").forward(request,response);


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                doPost(request,response);
    }


    public TestService getTestServiceImpl() {


        return testServiceImpl;
    }

    public SqlDao getHello() {
        return hello;
    }

    public void setTestServiceImpl(TestService testServiceImpl) {

        this.testServiceImpl = testServiceImpl;
    }

    public void setHello(SqlDao hello) {
        this.hello = hello;
    }
}
