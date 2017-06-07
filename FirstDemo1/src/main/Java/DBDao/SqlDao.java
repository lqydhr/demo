package DBDao;

import Mod.DownloadSolutions;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuqingyuan on 2017/6/2.
 */
public class SqlDao {
    private static final String URL="jdbc:mysql://localhost:3306/test";
    private static final String NAME="root";
    private static final String PASSWORD="i696608";

    //  public static void main(String[] args) throws Exception{
/*
           //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得数据库的连接
            Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
            //3.通过数据库的连接操作数据库
            Statement stmt = conn.createStatement();*/

    //}
    public List<DownloadSolutions> QuerySQL(String sql){
        try{

            Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
            Statement pstm=conn.createStatement();
            ResultSet rs=pstm.executeQuery(sql);
            List<DownloadSolutions> list=new ArrayList<DownloadSolutions>();
            while(rs.next())
            {
                DownloadSolutions rec=new DownloadSolutions();
                rec.setId(rs.getInt(1));
                rec.setSolutionId(rs.getInt(2));
                rec.setClassName(rs.getString(3));
                rec.setMethodName(rs.getString(4));
                rec.setFile_md5(rs.getString(5));
                rec.setCreatedAt(rs.getTimestamp(6));
                rec.setUpdateAt(rs.getTimestamp(7));
                rec.setPriority(rs.getInt(8));
                rec.setDownloadable(rs.getBoolean(9));
                rec.setRemark(rs.getString(10));
                rec.setMinApiLevel(rs.getInt(11));
                rec.setMaxApiLevel(rs.getInt(12));
                rec.setIsx64(rs.getBoolean(13));
                rec.setEmbeddedSolution(rs.getBoolean(14));
                list.add(rec);
            }
          /*  ResultSetMetaData md = rs.getMetaData();
           int columnCount = md.getColumnCount(); //Map rowData;
           while (rs.next()) {
                Map rowData = new HashMap();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnName(i), rs.getObject(i));
                }
                list.add(rowData);}
                List<DownloadSolutions> DownloadSolutionList =(List<DownloadSolutions>) list;*/
            return list;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public  void add(DownloadSolutions newSolution) throws Exception{
        Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        PreparedStatement pstmt;
        String sql ="insert into download_solutions(solution_Id,class_name,method_name,priority,downloadable,is_embedded_solution,is_x64,"
                + " min_api_level,max_api_level,remark,created_at,updated_at)"
                + " values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, newSolution.getSolutionId());
            pstmt.setString(2, newSolution.getClassName());
            pstmt.setString(3, newSolution.getMethodName());
            pstmt.setInt(4,newSolution.getPriority());
            pstmt.setBoolean(5,newSolution.isDownloadable());
            pstmt.setBoolean(6,newSolution.isEmbeddedSolution());
            pstmt.setBoolean(7,newSolution.isIsx64());
            pstmt.setInt(8,newSolution.getMinApiLevel());
            pstmt.setInt(9,newSolution.getMaxApiLevel());
            pstmt.setString(10,newSolution.getRemark());
            pstmt.setTimestamp(11,newSolution.getCreatedAt());
            pstmt.setTimestamp(12,newSolution.getUpdateAt());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void  del(int delId) throws Exception{
        Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        PreparedStatement pstmt;
        String del="delete from download_solutions where id=?";
            pstmt = (PreparedStatement) conn.prepareStatement(del);
            pstmt.setInt(1,delId);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

    }
    public DownloadSolutions readyEdit(String sql) {
        try{
        Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        Statement pstm=conn.createStatement();
        ResultSet rs=pstm.executeQuery(sql);
            DownloadSolutions editSolution = new DownloadSolutions();
            while(rs.next()) {
                editSolution.setId(rs.getInt(1));
                editSolution.setSolutionId(rs.getInt(2));
                editSolution.setClassName(rs.getString(3));
                editSolution.setMethodName(rs.getString(4));
                editSolution.setFile_md5(rs.getString(5));
                editSolution.setCreatedAt(rs.getTimestamp(6));
                editSolution.setUpdateAt(rs.getTimestamp(7));
                editSolution.setPriority(rs.getInt(8));
                editSolution.setDownloadable(rs.getBoolean(9));
                editSolution.setRemark(rs.getString(10));
                editSolution.setMinApiLevel(rs.getInt(11));
                editSolution.setMaxApiLevel(rs.getInt(12));
                editSolution.setIsx64(rs.getBoolean(13));
                editSolution.setEmbeddedSolution(rs.getBoolean(14));
            }
            if(editSolution.getClassName()==null){
                editSolution.setClassName("");
            }
            if(editSolution.getMethodName()==null){
                editSolution.setMethodName("");
            }
            if(editSolution.getFile_md5()==null){
                editSolution.setFile_md5("");
            }
            if(editSolution.getRemark()==null){
                editSolution.setRemark("");
            }

        return editSolution;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
   public  void Edit(int editId,DownloadSolutions newSolution) throws Exception{
        Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        PreparedStatement pstmt;
        String del = "update download_solutions set solution_Id=?,class_name=?,method_name=?,priority=?," +
                "downloadable=?,is_embedded_solution=?,is_x64=?,min_api_level=?,max_api_level=?,remark=?," +
                "updated_at=? where id="+editId;
        pstmt = (PreparedStatement) conn.prepareStatement(del);
        pstmt.setInt(1, newSolution.getSolutionId());
        pstmt.setString(2, newSolution.getClassName());
        pstmt.setString(3, newSolution.getMethodName());
        pstmt.setInt(4,newSolution.getPriority());
        pstmt.setBoolean(5,newSolution.isDownloadable());
        pstmt.setBoolean(6,newSolution.isEmbeddedSolution());
        pstmt.setBoolean(7,newSolution.isIsx64());
        pstmt.setInt(8,newSolution.getMinApiLevel());
        pstmt.setInt(9,newSolution.getMaxApiLevel());
        pstmt.setString(10,newSolution.getRemark());
        pstmt.setTimestamp(11,newSolution.getUpdateAt());
        pstmt.executeUpdate();
        pstmt.close();
        conn.close();
    }
}
