package DataBaseDao;

import Mod.DownloadSolutionsEntity;
import Mod.DownloadSolutionsEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by liuqingyuan on 2017/6/6.
 */
public class DownloadSolutionDao {
    //开启EntityManager
    public static final String UNIT_NAME = "cspPU";
    private static final EntityManagerFactory E_F_M = Persistence.createEntityManagerFactory(UNIT_NAME);
    private static final ThreadLocal<EntityManager> threadLocal = new ThreadLocal<EntityManager>();
    protected EntityManager entityManager = E_F_M.createEntityManager();

    //查询
    public List<DownloadSolutionsEntity> QuerySQL(String sql) {
        Query query = entityManager.createQuery(sql);
        List<DownloadSolutionsEntity> list = query.getResultList();
        return list;
    }

    //新增
    public void add(DownloadSolutionsEntity newSolution) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.persist(newSolution);
        entityManager.getTransaction().commit();

    }


    //删除
    public void del(int delId) throws Exception {
        entityManager.getTransaction().begin();
        DownloadSolutionsEntity downloadSolutions = entityManager.find(DownloadSolutionsEntity.class, delId);
        entityManager.remove(downloadSolutions);
        entityManager.getTransaction().commit();

    }

    public DownloadSolutionsEntity readyEdit(String sql){
        Query query = entityManager.createQuery(sql);
        DownloadSolutionsEntity downloadSolutionsEntity=(DownloadSolutionsEntity)query.getResultList().get(0);
        return downloadSolutionsEntity;

    }
    //修改
    public void Edit(DownloadSolutionsEntity newSolution) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.merge(newSolution);
        entityManager.getTransaction().commit();

    }
}
