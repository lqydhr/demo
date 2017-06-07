package ServiceImpl;

import DBDao.DaoService;
import DBDao.SqlDao;
import Mod.DownloadSolutions;
import Service.TestService;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by liuqingyuan on 2017/5/19.
 */
public class TestServiceImpl implements TestService {
    @Inject
        private SqlDao helloWorld;
    @Inject
        private DaoService daoService;
    public List<DownloadSolutions> getName(String sql){
        List<DownloadSolutions> list = daoService.QuerySQL(sql);
        return list;
    }
    public   void add(DownloadSolutions newSolution) throws Exception{
        daoService.add(newSolution);
    }
    public DownloadSolutions readyEdit(String sql){
        DownloadSolutions editSolution=helloWorld.readyEdit(sql);
        return  editSolution;
    }
    public void  del(int delId) throws Exception{
        daoService.del(delId);
    }
    public  void Edit(int editId,DownloadSolutions newSolution) throws Exception{
        daoService.Edit(editId,newSolution);
    }

}