package com.ll.web;

import com.ll.pojo.Employee;
import com.ll.service.EmployeeService;
import com.ll.service.impl.EmployeeServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/Employee")
public class EmployeeServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        EmployeeService es=new EmployeeServiceImpl();
        String opr=request.getParameter("opr");
        if ("findAll".equals(opr)){
            try {
                List<Employee>list=es.findAll();
                //存到域中
                request.setAttribute("list",list);
                //转发
                request.getRequestDispatcher("index.jsp").forward(request,response);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if("del".equals(opr)){
            //执行删除
            String id=request.getParameter("id");

            int count =0;
            try {
                count=es.del(Integer.parseInt(id));
                if(count>0){
                    out.print(true);
                }else{
                    out.print(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if("add".equals(opr)){
            String eName=request.getParameter("ename");
            String brithday=request.getParameter("brithday");
            String did=request.getParameter("did");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

            //封装
            Employee ep=new Employee();
            ep.setDid(Integer.parseInt(did));
            try {
                ep.setBrithday(sdf.parse(brithday));
                ep.setEname(eName);
                //执行新增
                int count=es.save(ep);
                if(count>0){
                    out.print("<script>alert('新增成功');location.href='/Employee?opr=findAll'</script>");
                }else{
                    out.print("<script>alert('失败');location.href='add.jsp'</script>");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if("Bid".equals(opr)){
            String id=request.getParameter("eno");

            try {
                Employee ec=es.findByID(Integer.parseInt(id));
                request.setAttribute("ep",ec);
                request.getRequestDispatcher("update.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }else  if("update".equals(opr)){

            String eName=request.getParameter("ename");
            String id=request.getParameter("id");
            String brithday=request.getParameter("brithday");
            String did=request.getParameter("did");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Employee ep=new Employee();
            ep.setDid(Integer.parseInt(did));
            ep.setEname(eName);
            try {
                ep.setBrithday(sdf.parse(brithday));
                ep.setEno(Integer.parseInt(id));

                int count=es.update(ep);
                if(count>0){
                    out.print("<script>alert('编辑成功');location.href='/Employee?opr=findAll'</script>");
                }else{
                    out.print("<script>alert('编辑成功');location.href='/update.jsp'</script>");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

}}
