package cn.bdqn.Dao;

import java.sql.*;


public class BeasDao {
    //驱动
    private String driver = "com.mysql.jdbc.Driver";
    //地址
    private String url = "jdbc:mysql://localhost:3306/rain";
    private String user = "root";
    private String password = "123456";

   Connection conn = null;
   Statement st = null;
    PreparedStatement ps = null ;//执行对象
     ResultSet rs = null;//结果集

    /**
     * 建立连接
     * @return
     */
    public Connection getConnection(){
        try{
            //加载驱动
            Class.forName(driver);
            //连接
            conn = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 查询
     * @param sql 需要执行的sql语句
     * @param param  ？的参数 可有可无
     * @return  返回结果集
     */
    public ResultSet getExrcuteQuery(String sql,Object...param){
        try{
            conn = getConnection();
            //创建执行对象
            ps=conn.prepareStatement(sql);
            //如果有问好 你的paradem就不会为空
            if (param!=null&&param.length>0){
                for(int i = 0; i<param.length;i++)
                {
                    //给sql 语句中的？占位符设置值
                    ps.setObject((i+1),param[i]);
                }
            }
            //返回执行对象
            rs=ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**修改
     * 删除
     * 添加
     * @param sql
     * @param param
     * @return 返回受影响的行数
     */
    public int getExrcuteUpdate(String sql,Object...param){
        try{
            conn = getConnection();
            //创建执行对象
            ps = conn.prepareStatement(sql);
            //给？设置参数
            if(param!=null&&param.length>0){
                for (int i = 0;param.length>i;i++){
                    ps.setObject((i+1),param[i]);
                }
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭
            closeAll(rs,conn,st);
        }
        return -1;
    }

    /**
     * 关闭所有
     */
    /**
     * 释放资源的方法
     * @param rs 结果集对象
     * @param conn 数据库连接对象
     */
    public void closeAll(ResultSet rs, Connection conn,Statement st){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if ( st!= null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
