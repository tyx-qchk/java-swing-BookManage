/*
 * Created by JFormDesigner on Sat Dec 18 15:40:30 CST 2021
 */

package com.tyx.view.mainfm;

import com.tyx.view.borrow.Borrow;
import com.tyx.view.borrow.BorrowManage;
import com.tyx.view.borrow.StudentAdd;
import com.tyx.view.borrow.StudentManage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Brainrain
 */
public class MainFm extends JFrame {
    JPanel contentPane;
    JDesktopPane table;
    public static void main(String[] args) {
        new MainFm();
    }
    public MainFm() {
        setVisible(true); //设置页面可见
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //点击右上角关闭按钮，退出系统
        initComponents();
        setBounds(100,100,1000,800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        table = new JDesktopPane();
        contentPane.add(table, BorderLayout.CENTER);

    }
//    图书类别添加
    private void menuItem6ActionPerformed(ActionEvent e) {
        // TODO add your code here
        BookTypeAdd bookTypeAdd = new BookTypeAdd();
        bookTypeAdd.setVisible(true);
        table.add(bookTypeAdd);

    }
//    图书管理
    private void menuItem9ActionPerformed(ActionEvent e) {
        // TODO add your code here
        BookManage bookManage = new BookManage();
        bookManage.setVisible(true);
        table.add(bookManage);
    }

//    图书添加
    private void menuItem8ActionPerformed(ActionEvent e) {
        // TODO add your code here
        BookAdd bookAdd = new BookAdd();
        bookAdd.setVisible(true);
        table.add(bookAdd);
    }
//    图书类别添加
    private void menuItem7ActionPerformed(ActionEvent e) {
        // TODO add your code here
        BookTypeManage bookTypeManage = new BookTypeManage();
        bookTypeManage.setVisible(true);
        table.add(bookTypeManage);
    }

//  借阅管理
    private void menuItem1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        Borrow borrow = new Borrow();
        borrow.setVisible(true);
        table.add(borrow);
        System.out.println("借阅管理");
    }
//  退出
    private void menuItem2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        System.exit(0);
    }

    private void menu3ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }
//    借书证注册
    private void menuItem3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        StudentAdd studentAdd =new  StudentAdd();
        studentAdd.setVisible(true);
        table.add(studentAdd);
    }
//  借阅记录管理
    private void menuItem4ActionPerformed(ActionEvent e) {
        // TODO add your code here
        BorrowManage borrowManage = new BorrowManage();
        borrowManage.setVisible(true);
        table.add(borrowManage);
    }
//    学生管理
    private void menuItem5ActionPerformed(ActionEvent e) {
        // TODO add your code here
        StudentManage studentManage = new StudentManage();
        studentManage.setVisible(true);
        table.add(studentManage);
    }


//    初始化页面
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar2 = new JMenuBar();
        menu1 = new JMenu();
        menu7 = new JMenu();
        menuItem6 = new JMenuItem();
        menuItem7 = new JMenuItem();
        menu6 = new JMenu();
        menuItem8 = new JMenuItem();
        menuItem9 = new JMenuItem();
        menu3 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menu4 = new JMenu();
        menuItem2 = new JMenuItem();

        //======== this ========
        setTitle("\u56fe\u4e66\u7ba1\u7406\u7cfb\u7edf");
        setIconImage(new ImageIcon(getClass().getResource("/images/\u7ebf\u6027\u56fe\u4e66.png")).getImage());
        setFont(new Font("Gadugi", Font.PLAIN, 12));
        Container contentPane = getContentPane();

        //======== menuBar2 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u56fe\u4e66\u7ba1\u7406");
                menu1.setIcon(new ImageIcon(getClass().getResource("/images/2_\u7ba1\u7406.png")));
                menu1.setFont(new Font("Dialog", Font.PLAIN, 12));

                //======== menu7 ========
                {
                    menu7.setText("\u56fe\u4e66\u7c7b\u522b\u7ba1\u7406");
                    menu7.setIcon(new ImageIcon(getClass().getResource("/images/\u5206\u7c7b.png")));
                    menu7.setFont(new Font("Dialog", Font.PLAIN, 12));

                    //---- menuItem6 ----
                    menuItem6.setText("\u56fe\u4e66\u7c7b\u522b\u6dfb\u52a0");
                    menuItem6.setIcon(new ImageIcon(getClass().getResource("/images/\u6dfb\u52a0.png")));
                    menuItem6.setFont(new Font("Dialog", Font.PLAIN, 12));
                    menuItem6.addActionListener(e -> menuItem6ActionPerformed(e));
                    menu7.add(menuItem6);

                    //---- menuItem7 ----
                    menuItem7.setText("\u56fe\u4e66\u7c7b\u522b\u7ef4\u62a4");
                    menuItem7.setIcon(new ImageIcon(getClass().getResource("/images/13edit.png")));
                    menuItem7.setFont(new Font("Dialog", Font.PLAIN, 12));
                    menuItem7.addActionListener(e -> menuItem7ActionPerformed(e));
                    menu7.add(menuItem7);
                }
                menu1.add(menu7);

                //======== menu6 ========
                {
                    menu6.setText("\u56fe\u4e66\u7ba1\u7406");
                    menu6.setIcon(new ImageIcon(getClass().getResource("/images/\u4e66\u67b6.png")));
                    menu6.setFont(new Font("Dialog", Font.PLAIN, 12));

                    //---- menuItem8 ----
                    menuItem8.setText("\u56fe\u4e66\u6dfb\u52a0");
                    menuItem8.setIcon(new ImageIcon(getClass().getResource("/images/\u6dfb\u52a0.png")));
                    menuItem8.setFont(new Font("Dialog", Font.PLAIN, 12));
                    menuItem8.addActionListener(e -> menuItem8ActionPerformed(e));
                    menu6.add(menuItem8);

                    //---- menuItem9 ----
                    menuItem9.setText("\u56fe\u4e66\u7ef4\u62a4");
                    menuItem9.setIcon(new ImageIcon(getClass().getResource("/images/13edit.png")));
                    menuItem9.setFont(new Font("Dialog", Font.PLAIN, 12));
                    menuItem9.addActionListener(e -> menuItem9ActionPerformed(e));
                    menu6.add(menuItem9);
                }
                menu1.add(menu6);
            }
            menuBar2.add(menu1);

            //======== menu3 ========
            {
                menu3.setText("\u501f\u9605");
                menu3.setFont(new Font("Dialog", Font.PLAIN, 12));
                menu3.setIcon(new ImageIcon(getClass().getResource("/images/\u4e66\u67b6.png")));
                menu3.addActionListener(e -> {
			menu3ActionPerformed(e);
			menu3ActionPerformed(e);
		});

                //---- menuItem1 ----
                menuItem1.setText("\u501f\u4e66/\u8fd8\u4e66");
                menuItem1.setIcon(new ImageIcon(getClass().getResource("/images/\u4e66\u67b6.png")));
                menuItem1.addActionListener(e -> {
			menuItem1ActionPerformed(e);
		});
                menu3.add(menuItem1);

                //---- menuItem3 ----
                menuItem3.setText("\u501f\u4e66\u8bc1\u6ce8\u518c");
                menuItem3.setIcon(new ImageIcon(getClass().getResource("/images/\u5de5\u4f1a\u6210\u5458\u6ce8\u518c.png")));
                menuItem3.addActionListener(e -> menuItem3ActionPerformed(e));
                menu3.add(menuItem3);

                //---- menuItem4 ----
                menuItem4.setText("\u501f\u9605\u7ba1\u7406");
                menuItem4.setIcon(new ImageIcon(getClass().getResource("/images/2_\u7ba1\u7406.png")));
                menuItem4.addActionListener(e -> menuItem4ActionPerformed(e));
                menu3.add(menuItem4);

                //---- menuItem5 ----
                menuItem5.setText("\u5b66\u751f\u7ba1\u7406");
                menuItem5.setIcon(new ImageIcon(getClass().getResource("/images/\u5de5\u4f1a\u6210\u5458\u6ce8\u518c.png")));
                menuItem5.addActionListener(e -> menuItem5ActionPerformed(e));
                menu3.add(menuItem5);
            }
            menuBar2.add(menu3);

            //======== menu4 ========
            {
                menu4.setText("\u9000\u51fa");
                menu4.setIcon(new ImageIcon(getClass().getResource("/images/\u9000\u51fa.png")));
                menu4.setFont(new Font("Dialog", Font.PLAIN, 12));

                //---- menuItem2 ----
                menuItem2.setText("\u9000\u51fa");
                menuItem2.setIcon(new ImageIcon(getClass().getResource("/images/\u9000\u51fa.png")));
                menuItem2.addActionListener(e -> menuItem2ActionPerformed(e));
                menu4.add(menuItem2);
            }
            menuBar2.add(menu4);
        }
        setJMenuBar(menuBar2);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 755, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 359, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar2;
    private JMenu menu1;
    private JMenu menu7;
    private JMenuItem menuItem6;
    private JMenuItem menuItem7;
    private JMenu menu6;
    private JMenuItem menuItem8;
    private JMenuItem menuItem9;
    private JMenu menu3;
    private JMenuItem menuItem1;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JMenuItem menuItem5;
    private JMenu menu4;
    private JMenuItem menuItem2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
