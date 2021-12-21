package com.tyx.view.login;

import javax.swing.*;
import java.awt.*;

public class UserLoginFrame extends JFrame {
    public UserLoginFrame() throws HeadlessException {
        setTitle("用户登录");
//        setSize(500,375); //设置窗口大小
        setBounds(500,500,500,375);
        setIconImage(new ImageIcon(getClass().getResource("/images/\u7ebf\u6027\u56fe\u4e66.png")).getImage());
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //点击右上角关闭按钮，结束系统
    }
    private void init(){
        add(new LoginView(this));
    }
}
