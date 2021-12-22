/*
 * Created by JFormDesigner on Sat Dec 18 19:35:33 CST 2021
 */

package com.tyx.view.mainfm;

import com.tyx.dao.BookDao;
import com.tyx.dao.BookTypeDao;
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
public class BookTypeManage extends JInternalFrame {
    DbUtil dbUtil = new DbUtil();
    BookTypeDao bookTypeDao = new BookTypeDao();
    BookDao bookDao=new BookDao();
    public BookTypeManage() {

        setClosable(true);
        setIconifiable(true);
        initComponents();
        fillTable(new BookType());
    }

    /**
     * 初始化表格数据
     *
     * @param bookType
     */
    private void fillTable(BookType bookType) {
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        dtm.setRowCount(0); // 设置成0行
        Connection con = null;
        try {
            con = dbUtil.getCon();
            ResultSet rs = bookTypeDao.list(con, bookType);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("bookTypeName"));
                v.add(rs.getString("bookTypeDesc"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    //    table行点击事件
    private void table1MousePressed(MouseEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        textField2.setText((String) table1.getValueAt(row, 0));
        textField3.setText((String) table1.getValueAt(row, 1));
        textArea1.setText((String) table1.getValueAt(row, 2));
    }

    //    查询功能
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String s_bookTypeName = this.textField1.getText();
        BookType bookType = new BookType();
        bookType.setBookTypeName(s_bookTypeName);
        this.fillTable(bookType);
    }

    //删除功能
    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String id=textField2.getText();
        if(StringUtil.isEmpty(id)){
            JOptionPane.showMessageDialog(null, "请选择要删除的记录");
            return;
        }
        int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
        if(n==0){
            Connection con=null;
            try{
                con=dbUtil.getCon();
                boolean flag=bookDao.existBookByBookTypeId(con, id);
                if(flag){
                    JOptionPane.showMessageDialog(null, "当前图书类别下有图书，不能删除此类别");
                    return;
                }
                int deleteNum=bookTypeDao.delete(con, id);
                if(deleteNum==1){
                    JOptionPane.showMessageDialog(null, "删除成功");
                    this.resetValue();
                    this.fillTable(new BookType());
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

    //修改功能
    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String id = textField2.getText();
        String bookTypeName = textField3.getText();
        String bookTypeDesc = textArea1.getText();
        if (StringUtil.isEmpty(id)) {
            JOptionPane.showMessageDialog(null, "请选择要修改的记录");
            return;
        }
        if (StringUtil.isEmpty(bookTypeName)) {
            JOptionPane.showMessageDialog(null, "图书类别名称不能为空");
            return;
        }
        BookType bookType = new BookType(Integer.parseInt(id), bookTypeName, bookTypeDesc);
        Connection con = null;
        try {
            con = dbUtil.getCon();
            int modifyNum = bookTypeDao.update(con, bookType);
            if (modifyNum == 1) {
                JOptionPane.showMessageDialog(null, "修改成功");
                this.resetValue();
                this.fillTable(new BookType());
            } else {
                JOptionPane.showMessageDialog(null, "修改失败");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "修改失败");
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

//    重置表单
    private void resetValue(){
        this.textField2.setText("");
        this.textField3.setText("");
        this.textArea1.setText("");
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel1 = new JPanel();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        scrollPane2 = new JScrollPane();
        textArea1 = new JTextArea();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setTitle("\u56fe\u4e66\u7c7b\u522b\u7ba1\u7406");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u56fe\u4e66\u7c7b\u522b\u540d\uff1a");

        //---- button1 ----
        button1.setText("\u67e5\u8be2");
        button1.setIcon(new ImageIcon(getClass().getResource("/images/17\u3001\u52a8\u6001\u67e5\u8be2\u6761\u4ef6\u6a21\u677f.png")));
        button1.addActionListener(e -> button1ActionPerformed(e));

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null},
                    {null, null, null},
                },
                new String[] {
                    "\u7f16\u53f7", "\u56fe\u4e66\u7c7b\u522b", "\u63cf\u8ff0"
                }
            ){ //设置表格不可编辑
                boolean[] columnEditables = new boolean[] {
                        false, false, false
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

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("\u8868\u5355\u64cd\u4f5c"));

            //---- label2 ----
            label2.setText("\u7f16\u53f7\uff1a");

            //---- label3 ----
            label3.setText("\u56fe\u4e66\u7c7b\u522b\uff1a");

            //---- label4 ----
            label4.setText("\u63cf\u8ff0\uff1a");

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

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(label3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField3))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPane2))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(button2)
                                .addGap(100, 100, 100)
                                .addComponent(button3)))
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button2)
                            .addComponent(button3))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(button1))
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(49, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button1))
                    .addGap(36, 36, 36)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31)
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private JPanel panel1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JScrollPane scrollPane2;
    private JTextArea textArea1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
