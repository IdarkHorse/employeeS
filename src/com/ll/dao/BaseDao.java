package com.ll.dao;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * 连接数据库的工具类
 */
public class BaseDao {
    private static String driver="";
    private static String url="";
    private static String userName="";
    private static String password="";
    protected Connection conn = null; //连接对象
    protected PreparedStatement pstm = null; //执行对象

    //静态代码块(读取属性配置文件)
    static{
        try {
            InputStream in = BaseDao.class.getClassLoader()
                    .getResourceAsStream("database.properties");
            Properties p = new Properties(); //实例化属性文件类
            p.load(in);  //加载文件
            //赋值
            driver = p.getProperty("driver");
            url = p.getProperty("url");
            userName = p.getProperty("userName");
            password = p.getProperty("password");
            Class.forName(driver);  //加载驱动
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url,userName,password);
    }

    //关闭连接(关闭增删改)
    public void closeConn(PreparedStatement pstm,Connection conn) throws Exception {
        if (pstm != null) pstm.close();
        if (conn != null) conn.close();
    }

    //关闭连接(关闭查询)
    public void closeConn(ResultSet rs,PreparedStatement pstm, Connection conn) throws Exception{
        if (rs != null) rs.close();
        closeConn(pstm,conn); //重复利用
    }

    //执行共用的增删改
    public int executeUpdate(String sql,Object[]obj) throws Exception {
        conn = getConnection();  //获取连接
        pstm = conn.prepareStatement(sql);  //获取预处理对象
        //传参
        if(obj!=null){
            for (int i = 0; i < obj.length; i++) {
                if(obj[i]!=null){
                    pstm.setObject(i+1,obj[i]);
                }
            }
        }
        int count = pstm.executeUpdate();  //执行命令
        closeConn(pstm,conn);  //关闭资源
        return count;
    }

    //执行共用的查询
    public ResultSet executeQuery(String sql,Object[]obj) throws Exception {
        conn = getConnection();  //获取连接
        pstm = conn.prepareStatement(sql);  //获取预处理对象
        //传参
        if(obj!=null){
            for (int i = 0; i < obj.length; i++) {
                if(obj[i]!=null){
                    pstm.setObject(i+1,obj[i]);
                }
            }
        }
        return pstm.executeQuery();
    }

}
