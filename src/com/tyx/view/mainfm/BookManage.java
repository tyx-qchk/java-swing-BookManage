/*
 * Created by JFormDesigner on Sat Dec 18 19:37:45 CST 2021
 */

package com.tyx.view.mainfm;

import com.tyx.dao.BookDao;
import com.tyx.dao.BookTypeDao;
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
public class BookManage extends JInternalFrame {
    private DbUtil dbUtil=new DbUtil();
    private BookDao bookDao=new BookDao();
    private BookTypeDao bookTypeDao = new BookTypeDao();
    private String borrow = "在馆";
    public BookManage() {
        setClosable(true);
        setIconifiable(true);
        setTitle("图书管理");
        initComponents();
        fillBookType("search");
        fillBookType("modify");
        fillTable(new Book());
    }
//    图书查询功能
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String bookName=this.textField1.getText();
        String author=this.textField2.getText();
        BookType bookType=(BookType) this.comboBox1.getSelectedItem();
        int bookTypeId=bookType.getId();

        Book book=new Book(bookName,author,bookTypeId);
        this.fillTable(book);
    }
//    表格行选中
    private void table1MousePressed(MouseEvent e) {
        // TODO add your code here
        int row=this.table1.getSelectedRow();
        this.textField3.setText((String)table1.getValueAt(row, 0)); //id
        this.textField4.setText((String)table1.getValueAt(row, 1)); //图书名
        this.textField6.setText((String)table1.getValueAt(row, 2)); //作者
        String sex=(String)table1.getValueAt(row, 3); // 性别
        if("男".equals(sex)){
            this.radioButton1.setSelected(true);
        }else if("女".equals(sex)){
            this.radioButton2.setSelected(true);
        }
        this.textField5.setText((Float)table1.getValueAt(row, 4)+""); //价格
        this.textArea1.setText((String)table1.getValueAt(row, 7)); //简介
        String bookTypeName=(String)this.table1.getValueAt(row, 5);
        int n=this.comboBox2.getItemCount();
        for(int i=0;i<n;i++){
            BookType item=(BookType)this.comboBox2.getItemAt(i);
            if(item.getBookTypeName().equals(bookTypeName)){
                this.comboBox2.setSelectedIndex(i);
            }
        }
        borrow = (String) table1.getValueAt(row,6);
    }
//  修改功能
    private void button2ActionPerformed(ActionEvent e) {
        if (borrow.equals("已借阅")){
            JOptionPane.showMessageDialog(null, "图书已借出，请等图书归还再修改！");
            return;
        }
        // TODO add your code here
        String id=this.textField3.getText();
        if(StringUtil.isEmpty(id)){
            JOptionPane.showMessageDialog(null, "请选择要修改的记录");
            return;
        }

        String bookName=this.textField4.getText();
        String author=this.textField6.getText();
        String price=this.textField5.getText();
        String bookDesc=this.textArea1.getText();

        if(StringUtil.isEmpty(bookName)){
            JOptionPane.showMessageDialog(null, "图书名称不能为空！");
            return;
        }

        if(StringUtil.isEmpty(author)){
            JOptionPane.showMessageDialog(null, "图书作者不能为空！");
            return;
        }

        if(StringUtil.isEmpty(price)){
            JOptionPane.showMessageDialog(null, "图书价格不能为空！");
            return;
        }

        String sex="";
        if(radioButton1.isSelected()){
            sex="男";
        }else if(radioButton2.isSelected()){
            sex="女";
        }

        BookType bookType=(BookType) comboBox2.getSelectedItem();
        int bookTypeId=bookType.getId();

        Book book=new Book(Integer.parseInt(id),  bookName, author, sex, Float.parseFloat(price),  bookTypeId,  bookDesc);

        Connection con=null;
        try{
            con=dbUtil.getCon();
            int addNum=bookDao.update(con, book);
            if(addNum==1){
                JOptionPane.showMessageDialog(null, "图书修改成功！");
                resetValue();
                this.fillTable(new Book());
            }else{
                JOptionPane.showMessageDialog(null, "图书修改失败！");
            }
        }catch(Exception e1){
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "图书修改失败！");
        }finally{
            try {
                dbUtil.closeCon(con);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
//  删除功能
    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (borrow.equals("已借阅")){
            JOptionPane.showMessageDialog(null, "图书已借出，请等图书归还再删除！");
            return;
        }
        String id=textField3.getText();
        if(StringUtil.isEmpty(id)){
            JOptionPane.showMessageDialog(null, "请选择要删除的记录");
            return;
        }
        int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
        if(n==0){
            Connection con=null;
            try{
                con=dbUtil.getCon();
                int deleteNum=bookDao.delete(con, id);
                if(deleteNum==1){
                    JOptionPane.showMessageDialog(null, "删除成功");
                    this.resetValue();
                    this.fillTable(new Book());
                }else{
                    JOptionPane.showMessageDialog(null, "删除失败");
                }
            }catch(Exception e1){
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "删除失败");
            }finally{
                try {
                    dbUtil.closeCon(con);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
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
        label5 = new JLabel();
        textField4 = new JTextField();
        label6 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        label7 = new JLabel();
        textField5 = new JTextField();
        label8 = new JLabel();
        textField6 = new JTextField();
        label9 = new JLabel();
        comboBox2 = new JComboBox();
        label10 = new JLabel();
        scrollPane2 = new JScrollPane();
        textArea1 = new JTextArea();
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
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBox1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label1)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3)
                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button1))
                        .addGap(34, 34, 34))
            );
        }

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
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
            panel2.setBorder(new TitledBorder("\u8868\u5355\u64cd\u4f5c"));

            //---- label4 ----
            label4.setText("\u7f16\u53f7\uff1a");

            //---- label5 ----
            label5.setText("\u56fe\u4e66\u540d\u79f0\uff1a");

            //---- label6 ----
            label6.setText("\u4f5c\u8005\u6027\u522b\uff1a");

            //---- radioButton1 ----
            radioButton1.setText("\u7537");

            //---- radioButton2 ----
            radioButton2.setText("\u5973");

            //---- label7 ----
            label7.setText("\u4ef7\u683c\uff1a");

            //---- label8 ----
            label8.setText("\u56fe\u4e66\u4f5c\u8005\uff1a");

            //---- label9 ----
            label9.setText("\u56fe\u4e66\u7c7b\u522b\uff1a");

            //---- label10 ----
            label10.setText("\u56fe\u4e66\u63cf\u8ff0\uff1a");

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(textArea1);
            }

            //---- button2 ----
            button2.setText("\u4fee\u6539");
            button2.setIcon(new ImageIcon(getClass().getResource("/images/13edit.png")));
            button2.addActionListener(e -> button2ActionPerformed(e));

            //---- button3 ----
            button3.setText("\u5220\u9664");
            button3.setIcon(new ImageIcon(getClass().getResource("/images/\u5220\u9664.png")));
            button3.addActionListener(e -> button3ActionPerformed(e));

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.Alignment.LEADING, panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(label4)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(label7)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textField5)))
                                .addGap(56, 56, 56)
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(label5)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(label8)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textField6, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(label9)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(label6)
                                        .addGap(18, 18, 18)
                                        .addComponent(radioButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(radioButton2))
                                    .addComponent(comboBox2)))
                            .addGroup(GroupLayout.Alignment.LEADING, panel2Layout.createSequentialGroup()
                                .addComponent(label10)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPane2)))
                        .addGap(45, 45, 45))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(radioButton2)
                            .addComponent(radioButton1)
                            .addComponent(label6)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label7)
                            .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label8)
                            .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label9)
                            .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label10)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button3)
                            .addComponent(button2))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrollPane1))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
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
    private JLabel label5;
    private JTextField textField4;
    private JLabel label6;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JLabel label7;
    private JTextField textField5;
    private JLabel label8;
    private JTextField textField6;
    private JLabel label9;
    private JComboBox comboBox2;
    private JLabel label10;
    private JScrollPane scrollPane2;
    private JTextArea textArea1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    /**
     * 初始化下拉框
     * @param type 下拉框类型
     */
    private void fillBookType(String type){
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
                }else if("modify".equals(type)){
                    this.comboBox2.addItem(bookType); //修改选择
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
    /**
     * 重置表单
     */
    private void resetValue(){
        this.textField3.setText(""); //图书id
        this.textField4.setText(""); //图书名称
        this.textField5.setText(""); //图书价格
        this.textField6.setText(""); //图书作者
        this.radioButton1.setSelected(true); //性别
        this.textArea1.setText(""); // 简介
        if(this.comboBox2.getItemCount()>0){ //选择框
            this.comboBox2.setSelectedIndex(0);
        }
    }
}
