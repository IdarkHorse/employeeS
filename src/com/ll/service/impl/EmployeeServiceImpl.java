package com.ll.service.impl;

import com.ll.dao.EmployeeDao;
import com.ll.dao.EmployeeDaoImpl;
import com.ll.pojo.Employee;
import com.ll.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {


    EmployeeDao ed=new EmployeeDaoImpl();

    @Override
    public List<Employee> findAll() throws Exception {

        return ed.findAll();
    }

    @Override
    public int del(int del) throws Exception {
        return ed.del(del);
    }

    @Override
    public int save(Employee e) throws Exception {
        return ed.save(e);
    }

    @Override
    public int update(Employee e) throws Exception {
        return ed.update(e);
    }

    @Override
    public Employee findByID(int id) throws Exception {
        return ed.findByID(id);
    }
}
