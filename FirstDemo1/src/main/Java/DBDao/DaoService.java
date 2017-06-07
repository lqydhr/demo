package DBDao;

import Mod.DownloadSolutions;

import javax.persistence.*;
import java.util.List;

/**
 * Created by liuqingyuan on 2017/6/6.
 */
public class DaoService {
    //开启EntityManager
    public static final String UNIT_NAME = "cspPU";
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_NAME);
    private static final ThreadLocal<EntityManager> threadLocal = new ThreadLocal<EntityManager>();
    protected EntityManager em=emf.createEntityManager();
    //查询
    public List<DownloadSolutions> QuerySQL(String sql){
        Query s= em.createQuery(sql);
        List<DownloadSolutions> list=s.getResultList();
        return list;
    }
//新增
    public   void add(DownloadSolutions newSolution) throws Exception{

        em.getTransaction().begin();
         em.persist(newSolution);
         em.getTransaction().commit();


    }
    //删除
    public void  del(int delId) throws Exception{
        em.getTransaction().begin();
        DownloadSolutions downloadSolutions=em.find(DownloadSolutions.class,delId);
        em.remove(downloadSolutions);
        em.getTransaction().commit();

    }
    //修改
    public  void Edit(int editId,DownloadSolutions newSolution) throws Exception{
        em.getTransaction().begin();
        em.merge(newSolution);
        em.getTransaction().commit();

    }
}
