package com.swpu.warning.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库获取连接释放资源的方法
 * 
 * @author st
 * 
 */
public class JdbcTool
{
    /**
     * 数据库连接方法
     * 
     * @return con数据库的连接
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Connection getConnection()
        throws IOException, SQLException, ClassNotFoundException
    {
        // 获取配置文件 的流
       // InputStream inStream = JdbcTool.class.getResourceAsStream("/mysql.properties");
      //  Properties properties = new Properties();
        // 读取配置文件
      //  properties.load(inStream);
        String url = null;
        String driver = null;
        String user = null;
        String pass = null;
        // 为需要的变量赋值
        url = "jdbc:mysql://localhost:3306/arrangetime?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
        driver = "com.mysql.jdbc.Driver";
        user = "root";
        pass = "123456";
        Connection con = null;
        // 注册驱动
        Class.forName(driver);
        // 建立连接
        con = DriverManager.getConnection(url, user, pass);
        // 返回连接
        return con;
    }
    
    /**
     * 关闭数据库资源
     * 
     * @param rs
     * @param st
     * @param con
     * @throws SQLException
     */
    public static void closeResore(ResultSet rs, Statement st, Connection con)
        throws SQLException
    {
        // 关闭查询的时候用的资源
        if (rs != null)
        {
            rs.close();
        }
        // 关闭更新的时候用的资源
        if (st != null)
        {
            st.close();
        }
        // 关闭数据库资源
        if (con != null)
        {
            con.close();
        }
    }
    
}
