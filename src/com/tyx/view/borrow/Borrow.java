/*
 * Created by JFormDesigner on Thu Dec 23 23:49:52 CST 2021
 */

package com.tyx.view.borrow;

import com.tyx.dao.BookDao;
import com.tyx.dao.BookTypeDao;
import com.tyx.dao.RecordDao;
import com.tyx.dao.StudentDao;
import com.tyx.model.Book;
import com.tyx.model.BookType;
import com.tyx.util.DbUtil;
import com.tyx.util.StringUtil;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * @author Brainrain
 */
public class Borrow extends JInternalFrame {
    private DbUtil dbUtil=new DbUtil();
    private BookDao bookDao=new BookDao();
    private BookTypeDao bookTypeDao = new BookTypeDao();
    private StudentDao studentDao = new StudentDao();
    private RecordDao recordDao = new RecordDao();
    private String borrow = "在馆";
    private String bookId = "0";
    private boolean b = false;
    public Borrow() {
        setClosable(true);
        setIconifiable(true);
        setTitle("借书/还书");
        initComponents();
        fillBookType("search");
        fillTable(new Book());
    }
//  查询
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String bookName=this.textField1.getText();
        String author=this.textField2.getText();
        BookType bookType=(BookType) this.comboBox1.getSelectedItem();
        int bookTypeId=bookType.getId();
        Book book=new Book(bookName,author,bookTypeId);
        this.fillTable(book);
    }
//  借书
    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (!b){
            JOptionPane.showMessageDialog(null, "未选中图书！");
            return;
        }

        if (StringUtil.isEmpty(textField3.getText().trim())){
            JOptionPane.showMessageDialog(null, "借书编号不能为空！");
            return;
        }

        int id = Integer.valueOf(textField3.getText().trim());

        try {
            Connection con = dbUtil.getCon();
            ResultSet rs = studentDao.getById(con,id);
            if (rs.next() && borrow.equals("在馆")){
                int studentBookId = rs.getInt("bookId");
                if (studentBookId!=0){
                    JOptionPane.showMessageDialog(null, "该用户还有图书未归还，不能再借书！");
                    return;
                } else {
                    int index = recordDao.add(con,id,Integer.valueOf(bookId));
                    if (index!=0){
                        bookDao.updateBorrow(con,Integer.valueOf(bookId),id);
                        studentDao.updateBookId(con,Integer.valueOf(bookId),id);
                        JOptionPane.showMessageDialog(null, "借阅成功！");
                        fillTable(new Book());
                    } else {
                        JOptionPane.showMessageDialog(null, "借阅失败！");
                        return;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "不存在该用户或图书已借出！");
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
//  还书
    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (!b){
            JOptionPane.showMessageDialog(null, "未选中图书！");
            return;
        }

        if (StringUtil.isEmpty(textField3.getText().trim())){
            JOptionPane.showMessageDialog(null, "借书编号不能为空！");
            return;
        }

        int id = Integer.valueOf(textField3.getText().trim()); //userid
        try {
            Connection con = dbUtil.getCon();
            ResultSet rs = studentDao.getById(con,id);
            if (rs.next() && borrow.equals("已借阅")){
                int studentBookId = rs.getInt("bookId");
                if (!bookId.equals(studentBookId+"")){
                    JOptionPane.showMessageDialog(null, "图书和用户不匹配！");
                    return;
                }
                if (studentBookId==0){
                    JOptionPane.showMessageDialog(null, "该用户还有图书已归还！");
                    return;
                } else {
                    int index = recordDao.update(con,id); //更新还书时间
                    if (index!=0){
                        bookDao.updateBorrow(con,Integer.valueOf(bookId),0); //还书了borrow设置为0
                        studentDao.updateBookId(con,0,id); //bookid设置为0
                        JOptionPane.showMessageDialog(null, "还书成功！");
                        fillTable(new Book());
                    } else {
                        JOptionPane.showMessageDialog(null, "还书失败！");
                        return;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "不存在该用户或图书已归还！");
                return;
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
// 表格选中
    private void table1MousePressed(MouseEvent e) {
        // TODO add your code here
        int row=this.table1.getSelectedRow();
        bookId = (String)table1.getValueAt(row, 0); //id
        String bookName = (String)table1.getValueAt(row, 1); //图书名
        borrow = (String) table1.getValueAt(row,6); //是否在馆
        b = true; //选中表格
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        comboBox1 = new JComboBox();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel2 = new JPanel();
        label4 = new JLabel();
        textField3 = new JTextField();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("\u641c\u7d22\u6761\u4ef6"));

            //---- label1 ----
            label1.setText("\u56fe\u4e66\u540d\u79f0\uff1a");

            //---- label2 ----
            label2.setText("\u56fe\u4e66\u4f5c\u8005\uff1a");

            //---- label3 ----
            label3.setText("\u56fe\u4e66\u7c7b\u522b\uff1a");

            //---- button1 ----
            button1.setText("\u67e5\u8be2");
            button1.setIcon(new ImageIcon(getClass().getResource("/images/17\u3001\u52a8\u6001\u67e5\u8be2\u6761\u4ef6\u6a21\u677f.png")));
            button1.addActionListener(e -> button1ActionPerformed(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button1)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label1)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3)
                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button1))
                        .addContainerGap(15, Short.MAX_VALUE))
            );
        }

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null, null},
                },
                new String[] {
                    "\u56fe\u4e66\u7f16\u53f7", "\u56fe\u4e66\u540d\u79f0", "\u56fe\u4e66\u4f5c\u8005", "\u4f5c\u8005\u6027\u522b", "\u56fe\u4e66\u4ef7\u683c", "\u56fe\u4e66\u7c7b\u522b", "\u72b6\u6001", "\u56fe\u4e66\u63cf\u8ff0"
                }
            ){ //设置表格不可编辑
                boolean[] columnEditables = new boolean[] {
                        false, false, false,false,false, false, false,false
                };
                public boolean isCellEditable(int row, int column) {
                    return columnEditables[column];
                }
            });
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    table1MousePressed(e);
                }
            });
            scrollPane1.setViewportView(table1);
        }

        //======== panel2 ========
        {
            panel2.setBorder(new TitledBorder("\u501f\u4e66\u64cd\u4f5c"));

            //---- label4 ----
            label4.setText("\u501f\u4e66\u4eba\u5b66\u53f7\uff1a");

            //---- button2 ----
            button2.setText("\u501f\u4e66");
            button2.setIcon(new ImageIcon(getClass().getResource("/images/13edit.png")));
            button2.addActionListener(e -> button2ActionPerformed(e));

            //---- button3 ----
            button3.setText("\u5f52\u8fd8");
            button3.setIcon(new ImageIcon(getClass().getResource("/images/\u56fe\u4e66\u5f52\u8fd8.png")));
            button3.addActionListener(e -> button3ActionPerformed(e));

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button3, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(label4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField3, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)))
                        .addContainerGap())
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button2)
                            .addComponent(button3))
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
                        .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JComboBox comboBox1;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel2;
    private JLabel label4;
    private JTextField textField3;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    /**
     * 初始化下拉框
     * @param type 下拉框类型
     */
    private void fillBookType(String type){
        b = false;
        Connection con=null;
        BookType bookType=null;
        try{
            con=dbUtil.getCon();
            ResultSet rs=bookTypeDao.list(con, new BookType());
            if("search".equals(type)){
                bookType=new BookType();
                bookType.setBookTypeName("请选择...");
                bookType.setId(-1);
                this.comboBox1.addItem(bookType); //搜索选择
            }
            while(rs.next()){
                bookType=new BookType();
                bookType.setBookTypeName(rs.getString("bookTypeName"));
                bookType.setId(rs.getInt("id"));
                if("search".equals(type)){
                    this.comboBox1.addItem(bookType); //搜索选择
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    /**
     * 初始化表格数据
     * @param book
     */
    private void fillTable(Book book){
        DefaultTableModel dtm=(DefaultTableModel) table1.getModel();
        dtm.setRowCount(0); // 设置成0行
        Connection con=null;
        try{
            con=dbUtil.getCon();
            ResultSet rs=bookDao.list(con, book);
            while(rs.next()){
                Vector v=new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("bookName"));
                v.add(rs.getString("author"));
                v.add(rs.getString("sex"));
                v.add(rs.getFloat("price"));
                v.add(rs.getString("bookTypeName"));
                int isBorrow = rs.getInt("borrow");
                if (isBorrow!=0){
                    v.add("已借阅");
                } else {
                    v.add("在馆");
                }
                v.add(rs.getString("bookDesc"));
                dtm.addRow(v);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
