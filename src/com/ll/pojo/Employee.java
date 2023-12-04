package com.ll.pojo;

import java.time.Instant;
import java.util.Date;

public class Employee {
    private Integer eno;
    private String ename;
    private  Integer did;
    private Date  brithday;


    public Employee() {
    }

    public Employee(Integer eno, String ename, Integer did, Date brithday) {
        this.eno = eno;
        this.ename = ename;
        this.did = did;
        this.brithday = brithday;
    }

    /**
     * 获取
     * @return eno
     */
    public Integer getEno() {
        return eno;
    }

    /**
     * 设置
     * @param eno
     */
    public void setEno(Integer eno) {
        this.eno = eno;
    }

    /**
     * 获取
     * @return ename
     */
    public String getEname() {
        return ename;
    }

    /**
     * 设置
     * @param ename
     */
    public void setEname(String ename) {
        this.ename = ename;
    }

    /**
     * 获取
     * @return did
     */
    public Integer getDid() {
        return did;
    }

    /**
     * 设置
     * @param did
     */
    public void setDid(Integer did) {
        this.did = did;
    }

    /**
     * 获取
     * @return brithday
     */
    public Date getBrithday() {
        return brithday;
    }

    /**
     * 设置
     * @param brithday
     */
    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public String toString() {
        return "Employee{eno = " + eno + ", ename = " + ename + ", did = " + did + ", brithday = " + brithday + "}";
    }
}
