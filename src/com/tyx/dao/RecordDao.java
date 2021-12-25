package com.tyx.dao;

import com.tyx.util.StringUtil;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * 借阅记录dao类
 */
public class RecordDao {
    /***
     * 添加借书记录
     * @param con
     * @param userId
     * @param bookId
     * @return
     * @throws SQLException
     */
    public int add(Connection con, int userId, int bookId) throws SQLException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = simpleDateFormat.format(new Date(System.currentTimeMillis()));
        String sql="insert into t_record values(null,?,?,?,null )";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1, userId);
        pstmt.setInt(2, bookId);
        pstmt.setString(3,date);
        return pstmt.executeUpdate();
    }

    /***
     * 获取借书记录
     * @param con
     * @return
     * @throws SQLException
     */
    public ResultSet list(Connection con,String id) throws SQLException {
        String sql = "SELECT\n" +
                "r.id,\n" +
                "s.userName,\n" +
                "b.bookName,\n" +
                "r.startTime,\n" +
                "r.endTime\n" +
                "FROM\n" +
                "t_record AS r ,\n" +
                "t_student AS s ,\n" +
                "t_book AS b\n" +
                "WHERE\n" +
                "r.userId = s.id AND\n" +
                "r.bookId = b.id";
        PreparedStatement ps;
        if (!StringUtil.isEmpty(id)){
            sql+=" AND r.userId = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,id);
        } else {
            ps = con.prepareStatement(sql);
        }

        return ps.executeQuery();
    }

    /***
     * 更新还书时间
     * @param con
     * @param userId
     * @return
     * @throws SQLException
     */
    public int update(Connection con, int userId) throws SQLException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = simpleDateFormat.format(new Date(System.currentTimeMillis()));
        int id = byId(con,userId);
        String sql="update t_record set endTime=? where id= ?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, date);
        pstmt.setInt(2, id);
        return pstmt.executeUpdate();
    }
    public int byId(Connection con,int id) throws SQLException {
        String sql = " select id from t_record  where startTime = (select max(startTime) from t_record  where userId=?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs = pstmt.executeQuery();
        int index = 0;
        while (rs.next()){
            index = rs.getInt("id");
        }
        return index;
    }
}
