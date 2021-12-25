/*
 * Created by JFormDesigner on Fri Dec 24 15:04:18 CST 2021
 */

package com.tyx.view.borrow;

import com.tyx.dao.StudentDao;
import com.tyx.util.DbUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * @author Brainrain
 */
public class StudentManage extends JInternalFrame {
    private DbUtil dbUtil =new DbUtil();
    private StudentDao studentDao = new StudentDao();
    public StudentManage() {
        setClosable(true);
        setIconifiable(true);
        initComponents();
        fillTable("");
    }
//    查询学生
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String id = textField1.getText().trim();
        fillTable(id);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setTitle("\u5b66\u751f\u7ba1\u7406");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u5b66\u53f7\u67e5\u8be2:");

        //---- button1 ----
        button1.setText("\u67e5\u8be2");
        button1.setIcon(new ImageIcon(getClass().getResource("/images/17\u3001\u52a8\u6001\u67e5\u8be2\u6761\u4ef6\u6a21\u677f.png")));
        button1.addActionListener(e -> button1ActionPerformed(e));

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null},
                    {null, null, null, null},
                },
                new String[] {
                    "\u5b66\u53f7", "\u59d3\u540d", "\u7535\u8bdd", "\u501f\u9605\u7684\u4e66\u7c4d"
                }
            ){ //设置表格不可编辑
                boolean[] columnEditables = new boolean[] {
                        false, false, false,false
                };
                public boolean isCellEditable(int row, int column) {
                    return columnEditables[column];
                }
            });
            scrollPane1.setViewportView(table1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(button1)
                    .addContainerGap(90, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(9, Short.MAX_VALUE))
        );
        pack();
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    /**
     * 初始化表格数据
     * @param id
     */
    private void fillTable(String id){
        DefaultTableModel dtm=(DefaultTableModel) table1.getModel();
        dtm.setRowCount(0); // 设置成0行
        Connection con=null;
        try{
            con=dbUtil.getCon();
            ResultSet rs=studentDao.list2(con, id);
            while(rs.next()){
                Vector v=new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("userName"));
                v.add(rs.getString("phone"));
                v.add(rs.getString("bookName"));
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
