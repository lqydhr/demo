package Service;

import Mod.DownloadSolutionsEntity;
import Mod.DownloadSolutionsEntity;


import java.util.List;

/**
 * Created by liuqingyuan on 2017/5/19.
 */
public interface DownloadSolutionService {
    List<DownloadSolutionsEntity> getName(String sql);

    void add(DownloadSolutionsEntity newSolution) throws Exception;

    DownloadSolutionsEntity readyEdit(String sql);

    void del(int delId) throws Exception;

    void Edit(DownloadSolutionsEntity newSolution) throws Exception;

}
