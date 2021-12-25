/*
 * Created by JFormDesigner on Fri Dec 24 14:20:24 CST 2021
 */

package com.tyx.view.borrow;

import com.tyx.dao.StudentDao;
import com.tyx.model.Student;
import com.tyx.util.DbUtil;
import com.tyx.util.StringUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;

/**
 * @author Brainrain
 */
public class StudentAdd extends JInternalFrame {
    private DbUtil dbUtil = new DbUtil();
    private StudentDao studentDao = new StudentDao();
    public StudentAdd() {
        setClosable(true);
        setIconifiable(true);
        initComponents();
        initComponents();
    }
//    注册
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String id = textField1.getText().trim();
        String userName = textField2.getText().trim();
        String phone = textField3.getText().trim();
        if (StringUtil.isEmpty(id)){
            JOptionPane.showMessageDialog(null, "学号不能为空！");
            return;
        }
        if (StringUtil.isEmpty(userName)){
            JOptionPane.showMessageDialog(null, "姓名不能为空！");
            return;
        }
        if (!StringUtil.isMobiPhoneNum(phone)){
            JOptionPane.showMessageDialog(null, "手机号不合法！");
            return;
        }
        try {
            Connection con = dbUtil.getCon();
            Student student = new Student();
            student.setId(Integer.parseInt(id));
            student.setUserName(userName);
            student.setPhone(phone);
            if (studentDao.getById(con,Integer.parseInt(id)).next()){
                JOptionPane.showMessageDialog(null, "该学号已注册过了！");
                return;
            }
            int index = studentDao.add(con,student);
            if (index!=0){
                JOptionPane.showMessageDialog(null, "注册成功！");
            } else {
                JOptionPane.showMessageDialog(null, "注册失败！");
            }
            con.close();
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
//     重置
    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("\u501f\u4e66\u8bc1\u6ce8\u518c");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u5b66\u53f7\uff1a");

        //---- label2 ----
        label2.setText("\u59d3\u540d\uff1a");

        //---- label3 ----
        label3.setText("\u7535\u8bdd\uff1a");

        //---- button1 ----
        button1.setText("\u6ce8\u518c");
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
                    .addGap(90, 90, 90)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button2))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField3))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField2))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(86, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(46, 46, 46)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addContainerGap(78, Short.MAX_VALUE))
        );
        pack();
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
