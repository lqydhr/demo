package ServiceImpl;


import Mod.DownloadSolutions;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liuqingyuan on 2017/6/6.
 */
public class ListennerImpl {
    //获取当前时间
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date =new Date();
    String now=df.format(date);
    Timestamp currentTime=Timestamp.valueOf(now);

    @PrePersist
    public void perAdd(DownloadSolutions downloadSolutions) {
        //插入之前设置创建时间和更新时间
        downloadSolutions.setCreatedAt(currentTime);
        downloadSolutions.setUpdateAt(currentTime);
            }
     @PostPersist
    public void postAdd(Object object) {
    System.out.println("postAdd");
     }

    @PreUpdate
    public void perUpdate(DownloadSolutions downloadSolutions){
//更新前设置更新时间
        downloadSolutions.setUpdateAt(currentTime);
    }
    @PostUpdate
     public void postUpdate(Object object){
    System.out.println("postUpdate");
     }
    @PreRemove
    public void perRemove(Object object){
        System.out.println("perRemove");
     }
    @PostRemove
    public void postRemove(Object object){
    System.out.println("postRemove");

     }

}
