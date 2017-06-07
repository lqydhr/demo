package Service;

import Mod.DownloadSolutions;


import java.util.List;

/**
 * Created by liuqingyuan on 2017/5/19.
 */
public interface TestService {
     List<DownloadSolutions> getName(String sql) ;

      void add(DownloadSolutions newSolution) throws Exception;

     DownloadSolutions readyEdit(String sql);
     void  del(int delId) throws Exception;
       void Edit(int editId,DownloadSolutions newSolution) throws Exception;

}
