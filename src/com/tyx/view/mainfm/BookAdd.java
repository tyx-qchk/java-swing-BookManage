/*
 * Created by JFormDesigner on Tue Dec 21 14:11:41 CST 2021
 */

package com.tyx.view.mainfm;

import com.tyx.dao.BookDao;
import com.tyx.dao.BookTypeDao;
import com.tyx.model.Book;
import com.tyx.model.BookType;
import com.tyx.util.DbUtil;
import com.tyx.util.StringUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @author Brainrain
 */
public class BookAdd extends JInternalFrame {
    private DbUtil dbUtil = new DbUtil();
    private BookTypeDao bookTypeDao = new BookTypeDao();
    private BookDao bookDao = new BookDao();
    public BookAdd() {
        setClosable(true);
        setIconifiable(true);
        initComponents();
        fillBookType();
    }
//    添加图书
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String bookName=this.textField1.getText();
        String author=this.textField2.getText();
        String price=this.textField3.getText();
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

        BookType bookType=(BookType) comboBox1.getSelectedItem();
        int bookTypeId=bookType.getId();

        Book book=new Book(bookName,author, sex, Float.parseFloat(price) , bookTypeId,  bookDesc);

        Connection con=null;
        try{
            con=dbUtil.getCon();
            int addNum=bookDao.add(con, book);
            if(addNum==1){
                JOptionPane.showMessageDialog(null, "图书添加成功！");
                resetValue();
            }else{
                JOptionPane.showMessageDialog(null, "图书添加失败！");
            }
        }catch(Exception e1){
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "图书添加失败！");
        }finally{
            try {
                dbUtil.closeCon(con);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
//    重置输入框
    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.resetValue();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        //将单选框加到组里
        radioButton1.setSelected(true);
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        label4 = new JLabel();
        textField3 = new JTextField();
        label5 = new JLabel();
        comboBox1 = new JComboBox();
        label6 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("\u56fe\u4e66\u6dfb\u52a0");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u56fe\u4e66\u540d\u79f0\uff1a");

        //---- label2 ----
        label2.setText("\u56fe\u4e66\u4f5c\u8005\uff1a");

        //---- label3 ----
        label3.setText("\u4f5c\u8005\u6027\u522b\uff1a");

        //---- radioButton1 ----
        radioButton1.setText("\u7537");

        //---- radioButton2 ----
        radioButton2.setText("\u5973");

        //---- label4 ----
        label4.setText("\u56fe\u4e66\u4ef7\u683c\uff1a");

        //---- label5 ----
        label5.setText("\u56fe\u4e66\u7c7b\u522b\uff1a");

        //---- label6 ----
        label6.setText("\u56fe\u4e66\u63cf\u8ff0\uff1a");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        button1.setIcon(new ImageIcon(getClass().getResource("/images/\u6dfb\u52a0.png")));
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button2 ----
        button2.setText("\u91cd\u7f6e");
        button2.setIcon(new ImageIcon(getClass().getResource("/images/\u91cd\u7f6e.png")));
        button2.addActionListener(e -> button2ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button1)
                            .addGap(102, 102, 102)
                            .addComponent(button2))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label6)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(scrollPane1))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label5)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(comboBox1))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label1)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label3)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(radioButton1)
                                            .addGap(18, 18, 18)
                                            .addComponent(radioButton2)))
                                    .addGap(30, 30, 30)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label2)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label4)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(textField3)))))))
                    .addContainerGap(37, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(34, 34, 34)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(radioButton1)
                        .addComponent(radioButton2)
                        .addComponent(label4)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(35, 35, 35)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label6)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JLabel label4;
    private JTextField textField3;
    private JLabel label5;
    private JComboBox comboBox1;
    private JLabel label6;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    /**
     * 初始化图书类别下拉框
     */
    private void fillBookType(){
        Connection con=null;
        BookType bookType=null;
        try{
            con=dbUtil.getCon();
            ResultSet rs=bookTypeDao.list(con, new BookType());
            while(rs.next()){
                bookType=new BookType();
                bookType.setId(rs.getInt("id"));
                bookType.setBookTypeName(rs.getString("bookTypeName"));
                this.comboBox1.addItem(bookType);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{

        }
    }
    /**
     * 重置表单
     */
    private void resetValue(){
        this.textField1.setText(""); //图书名称
        this.textField2.setText(""); //图书作者
        this.textField3.setText(""); //图书价格
        this.radioButton1.setSelected(true); //作者性别
        this.textArea1.setText(""); //图书简介
        if(this.comboBox1.getItemCount()>0){ //图书类别
            this.comboBox1.setSelectedIndex(0);
        }
    }
}
