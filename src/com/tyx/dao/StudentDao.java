package com.tyx.dao;

import com.tyx.model.Student;
import com.tyx.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/***
 * 学生dao类
 */
public class StudentDao {
    /***
     * 创建学生
     * @param con
     * @param student
     * @return
     * @throws SQLException
     */
    public int add(Connection con, Student student) throws SQLException {
        String sql="insert into t_student values(?,?,? ,? )";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1, student.getId());
        pstmt.setString(2, student.getUserName());
        pstmt.setInt(3,0);
        pstmt.setString(4,student.getPhone());
        return pstmt.executeUpdate();
    }

    /***
     * 获取学生列表
     * @param con
     * @param student
     * @return
     * @throws SQLException
     */
    public ResultSet list(Connection con,Student student) throws SQLException {
        StringBuffer sb=new StringBuffer("select * from t_student");
        if(StringUtil.isNotEmpty(student.getUserName())){
            sb.append(" and bookTypeName like '%"+student.getUserName()+"%'");
        }
        PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
        return pstmt.executeQuery();
    }

    public ResultSet list2(Connection con,String id) throws SQLException {
        String sql = "SELECT\n" +
                "s.id,\n" +
                "s.userName,\n" +
                "s.phone,\n" +
                "b.bookName\n" +
                "FROM\n" +
                "t_student s LEFT OUTER JOIN t_book b ON s.bookId=b.id";
        PreparedStatement pstmt;
        if (StringUtil.isEmpty(id)){
            pstmt = con.prepareStatement(sql);
        } else {
            sql+=" WHERE s.id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,id);
        }
        return pstmt.executeQuery();
    }

    /***
     * 查询单个学生
     * @param con
     * @param id
     * @return
     * @throws SQLException
     */
    public ResultSet getById(Connection con,int id) throws SQLException {
        String sql = "select * from t_student where id=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,id);
        return pstmt.executeQuery();
    }

    /***
     * 更新学生电话信息
     * @param con
     * @param student
     * @return
     * @throws SQLException
     */
    public int update(Connection con,Student student) throws SQLException {
        String sql="update t_student set phone=? where id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, student.getPhone());
        pstmt.setInt(2,student.getId());
        return pstmt.executeUpdate();
    }
    public int updateBookId(Connection con,int bookId,int id) throws SQLException {
        String sql="update t_student set bookId=? where id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1, bookId);
        pstmt.setInt(2, id);
        return pstmt.executeUpdate();
    }
    /***
     * 删除学生信息
     * @param con
     * @param id
     * @return
     * @throws SQLException
     */
    public int delete(Connection con,int id) throws SQLException {
        String sql="delete from t_student where id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1, id);
        return pstmt.executeUpdate();
    }
}
