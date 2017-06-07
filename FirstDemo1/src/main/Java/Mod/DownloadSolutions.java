package Mod;
import ServiceImpl.ListennerImpl;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by liuqingyuan on 2017/6/1.
 */

@Entity
@Table(name="Download_Solutions")

@EntityListeners(ListennerImpl.class)
public class DownloadSolutions {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
  private   int  Id;
    @Column(name="solution_Id")
    private int solutionId;
    @Column(name = "class_Name")
    private String className;
    @Column(name = "method_name")
    private  String methodName;
    @Column(name = "file_md5")
    private String file_md5;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updateAt;
    @Column(name="priority")
    private  int priority;
    @Column(name="downloadable")
    private  boolean downloadable;
    @Column(name = "remark")
    private  String remark;
    @Column(name="min_api_level")
    private int minApiLevel;
    @Column(name="max_api_level")
    private int maxApiLevel;
    @Column(name="is_x64")
    private boolean Isx64;
    @Column(name = "is_embedded_solution")
    private  boolean IsEmbeddedSolution;
public  DownloadSolutions(){

}
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(int solutionId) {
        this.solutionId = solutionId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getFile_md5() {
        return file_md5;
    }

    public void setFile_md5(String file_md5) {
        this.file_md5 = file_md5;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isDownloadable() {
        return downloadable;
    }

    public void setDownloadable(boolean downloadable) {
        this.downloadable = downloadable;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getMinApiLevel() {
        return minApiLevel;
    }

    public void setMinApiLevel(int minApiLevel) {
        this.minApiLevel = minApiLevel;
    }

    public int getMaxApiLevel() {
        return maxApiLevel;
    }

    public void setMaxApiLevel(int maxApiLevel) {
        this.maxApiLevel = maxApiLevel;
    }

    public boolean isIsx64() {
        return Isx64;
    }

    public void setIsx64(boolean isx64) {
        Isx64 = isx64;
    }

    public boolean isEmbeddedSolution() {
        return IsEmbeddedSolution;
    }

    public void setEmbeddedSolution(boolean embeddedSolution) {
        IsEmbeddedSolution = embeddedSolution;
    }
}
