package com.ll.dao;

import com.ll.pojo.Employee;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl extends BaseDao implements EmployeeDao{


    @Override
    public List<Employee> findAll() throws Exception {

        List<Employee>list=new ArrayList<>();
        String sql= "select * from Employee";
        ResultSet rs = this.executeQuery(sql, null);
        while(rs.next()){
            Employee e=new Employee();
            e.setEno(rs.getInt("Eno"));
            e.setEname(rs.getString("Ename"));
            e.setDid(rs.getInt("Did"));
            e.setBrithday(rs.getDate("Brithday"));
            //装到集合
            list.add(e);
        }
        //释放资源
        this.closeConn(rs,pstm,conn);
        //返回集合
        return list;
    }

    @Override
    public int del(int del) throws Exception {
        //查询
        String sql="delete from Employee where  Eno=?";
        Object [] obj={del};
        //执行
        return this.executeUpdate(sql,obj);
    }

    @Override
    public int save(Employee e) throws Exception {
        StringBuilder sb=new StringBuilder();
        sb.append("insert into Employee(Ename,Did,Brithday)");
        sb.append(" values ");
        sb.append("(?,?,?)");
        Object [] obj={e.getEname(),e.getDid(),e.getBrithday()};

        return this.executeUpdate(sb.toString(),obj);
    }

    @Override
    public int update(Employee e) throws Exception {
        StringBuilder sb=new StringBuilder();
        sb.append(" update Employee set Ename=? , Did=? ,  Brithday=? ");
        sb.append(" where Eno=?");
        Object [] obj={e.getEname(),e.getDid(),e.getBrithday(),e.getEno()};
        //返回结果
        return this.executeUpdate(sb.toString(),obj);
    }

    @Override
    public Employee findByID(int id) throws Exception {

        //准备对象
        Employee e=new Employee();
        //查询
        String sql="select * from   Employee   where Eno=?";
        Object [] obj={id};

        ResultSet rs = this.executeQuery(sql, obj);
        while(rs.next()){
            e.setEno(rs.getInt("Eno"));
            e.setEname(rs.getString("Ename"));
            e.setDid(rs.getInt("Did"));
            e.setBrithday(rs.getDate("Brithday"));
        }

        //释放资源
        this.closeConn(rs,pstm,conn);
        //返回对象
        return e;
    }
}
