package com.ll.dao;

import com.ll.pojo.Employee;

import java.util.List;

public interface EmployeeDao {


    //查询
    List<Employee> findAll() throws Exception;

    //删除
    int del(int del)throws  Exception;

    //新增
    int save(Employee e)throws Exception;

    //修改
    int update(Employee e)throws  Exception;

    //条件查询
    Employee findByID(int id) throws  Exception;

}
