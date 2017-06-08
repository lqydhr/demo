package ServiceImpl;

import DataBaseDao.DownloadSolutionDao;
import DataBaseDao.SqlDao;
import Mod.DownloadSolutionsEntity;
import Mod.DownloadSolutionsEntity;
import Service.DownloadSolutionService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by liuqingyuan on 2017/5/19.
 */
public class DownloadSolutionServiceImpl implements DownloadSolutionService {
    @Inject
    private SqlDao helloWorld;
    @Inject
    private DownloadSolutionDao downloadSolutionDao;

    public List<DownloadSolutionsEntity> getName(String sql) {
        List<DownloadSolutionsEntity> list = downloadSolutionDao.QuerySQL(sql);
        return list;
    }

    public void add(DownloadSolutionsEntity newSolution) throws Exception {
        downloadSolutionDao.add(newSolution);
    }

    public DownloadSolutionsEntity readyEdit(String sql) {
        DownloadSolutionsEntity editSolution = downloadSolutionDao.readyEdit(sql);
        return editSolution;
    }

    public void del(int delId) throws Exception {
        downloadSolutionDao.del(delId);
    }

    public void Edit(DownloadSolutionsEntity newSolution) throws Exception {
        downloadSolutionDao.Edit(newSolution);
    }

}