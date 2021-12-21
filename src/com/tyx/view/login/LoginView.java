/*
 * Created by JFormDesigner on Fri Dec 17 13:45:05 CST 2021
 */

package com.tyx.view.login;

import com.tyx.dao.UserDao;
import com.tyx.model.User;
import com.tyx.util.DbUtil;
import com.tyx.util.StringUtil;
import com.tyx.view.mainfm.MainFm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;

/**
 * @author Brainrain
 */
public class LoginView extends JPanel {
    UserLoginFrame userLoginFrame;
    DbUtil dbUtil;
    Connection con;
    UserDao userDao;
    public LoginView(UserLoginFrame userLoginFrame) {
        this.userLoginFrame = userLoginFrame;
        initComponents();
    }

    private void loginActionPerformed(ActionEvent e) {
        // TODO add your code here
        String userName = userEdit.getText();
        String passWord = passWordEdit.getText();
        if (StringUtil.isEmpty(userName)){
            JOptionPane.showMessageDialog(null, "用户名不能为空！");
            return;
        }
        if (StringUtil.isEmpty(passWord)){
            JOptionPane.showMessageDialog(null, "密码不能为空！");
            return;
        }
        User user = new User();
        user.setUserName(userName);
        user.setPassword(passWord);
        userDao = new UserDao();
        dbUtil = new DbUtil();
        try {
            con = dbUtil.getCon();
            if (userDao.login(con,user) != null){
                new MainFm(); //跳转到主页面
                con.close();  //关闭数据库连接
                userLoginFrame.dispose(); //关闭登录窗口
            } else {
                JOptionPane.showMessageDialog(null, "账号或密码错误！");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void registerActionPerformed(ActionEvent e) {
        // TODO add your code here
        userEdit.setText("");
        passWordEdit.setText("");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        userName = new JLabel();
        userEdit = new JTextField();
        passWord = new JLabel();
        passWordEdit = new JPasswordField();
        login = new JButton();
        register = new JButton();
        title = new JLabel();

        //======== this ========

        //---- userName ----
        userName.setText("\u7528\u6237\u540d\uff1a");
        userName.setIcon(new ImageIcon(getClass().getResource("/images/\u7528\u6237.png")));
        userName.setFont(userName.getFont().deriveFont(userName.getFont().getSize() + 5f));

        //---- userEdit ----
        userEdit.setFont(userEdit.getFont().deriveFont(userEdit.getFont().getSize() + 5f));

        //---- passWord ----
        passWord.setText("\u5bc6    \u7801\uff1a");
        passWord.setFont(passWord.getFont().deriveFont(passWord.getFont().getSize() + 5f));
        passWord.setIcon(new ImageIcon(getClass().getResource("/images/\u5bc6\u7801.png")));

        //---- passWordEdit ----
        passWordEdit.setFont(passWordEdit.getFont().deriveFont(passWordEdit.getFont().getSize() + 5f));

        //---- login ----
        login.setText("\u767b\u5f55");
        login.setIcon(new ImageIcon(getClass().getResource("/images/\u767b\u5f55.png")));
        login.addActionListener(e -> loginActionPerformed(e));

        //---- register ----
        register.setText("\u91cd\u7f6e");
        register.setIcon(new ImageIcon(getClass().getResource("/images/\u91cd\u7f6e.png")));
        register.addActionListener(e -> registerActionPerformed(e));

        //---- title ----
        title.setText("\u56fe\u4e66\u7ba1\u7406\u7cfb\u7edf");
        title.setFont(title.getFont().deriveFont(title.getFont().getSize() + 13f));
        title.setIcon(new ImageIcon(getClass().getResource("/images/\u7ebf\u6027\u56fe\u4e66.png")));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(71, 71, 71)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(userName)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(userEdit, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(login)
                                    .addGap(188, 188, 188)
                                    .addComponent(register, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(145, 145, 145)
                            .addComponent(title))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addComponent(passWord)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(passWordEdit, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(title)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(userName)
                        .addComponent(userEdit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(passWordEdit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(passWord))
                    .addGap(43, 43, 43)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(login)
                        .addComponent(register))
                    .addContainerGap(86, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel userName;
    private JTextField userEdit;
    private JLabel passWord;
    private JPasswordField passWordEdit;
    private JButton login;
    private JButton register;
    private JLabel title;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
