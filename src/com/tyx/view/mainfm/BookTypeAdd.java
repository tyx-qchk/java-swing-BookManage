/*
 * Created by JFormDesigner on Sat Dec 18 18:03:17 CST 2021
 */

package com.tyx.view.mainfm;

import com.tyx.dao.BookTypeDao;
import com.tyx.model.BookType;
import com.tyx.util.DbUtil;
import com.tyx.util.StringUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;

/**
 * @author Brainrain
 */
public class BookTypeAdd extends JInternalFrame {
    private DbUtil dbUtil=new DbUtil();
    private BookTypeDao bookTypeDao = new BookTypeDao();
    public BookTypeAdd() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
        setBounds(100, 100, 450, 300);
        initComponents();
    }

//    添加
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String bookTypeName = textField1.getText().trim();
        String bokTypeDesc = textArea1.getText().trim();
        if (StringUtil.isEmpty(bookTypeName)){
            JOptionPane.showMessageDialog(null, "图书类别不能为空！");
            return;
        }
//        添加图书类别到数据库中
        try {
            Connection con = dbUtil.getCon();
            BookType bookType = new BookType();
            bookType.setBookTypeName(bookTypeName);
            bookType.setBookTypeDesc(bokTypeDesc);
            int index = bookTypeDao.add(con,bookType);
            if (index!=0){
                JOptionPane.showMessageDialog(null, "添加成功！");
//                添加成功后清空输入框
                textField1.setText("");
                textArea1.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "添加失败！");
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
//    重置
    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        textField1.setText("");
        textArea1.setText("");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("\u56fe\u4e66\u7c7b\u522b\u6dfb\u52a0");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u56fe\u4e66\u7c7b\u522b\u540d\u79f0\uff1a");

        //---- label2 ----
        label2.setText("\u56fe\u4e66\u7c7b\u522b\u63cf\u8ff0\uff1a");

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
                    .addGap(74, 74, 74)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(18, 18, 18)
                            .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2)
                                .addComponent(button1))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(scrollPane1)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(0, 103, Short.MAX_VALUE)
                                    .addComponent(button2)))))
                    .addGap(141, 141, 141))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button2)
                        .addComponent(button1))
                    .addGap(71, 71, 71))
        );
        pack();
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
