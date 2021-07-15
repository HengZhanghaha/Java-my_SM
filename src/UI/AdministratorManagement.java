package UI;
/**
 * Editor: 张恒
 * Wechat：zh17530588817
 * */
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

import entity.Users;

import service.UsersService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdministratorManagement extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        AdministratorManagement frame = new AdministratorManagement();
        frame.setVisible(true);
    }

    /**
     * Create the frame.
     */
    public AdministratorManagement() {
        this.setTitle("管理员信息管理");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 680, 390);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(40, 40, 40, 40));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 85, 520, 192);
        contentPane.add(scrollPane);

        String[] cols={"员工编号","用户名","密码","管理员级别"};//建立一个数组
        final DefaultTableModel model = new DefaultTableModel(cols,0);   //建立一个有cols数组长度的表
        table = new JTable(model);
        UsersService us = new UsersService();
        List<Users> rows = us.getAllUsersService();
        for (Users users : rows) {
            Object[] row = {users.getUserId(),users.getUserName(),users.getPassword(),users.getRoleId()};
            model.addRow(row);
        }
        scrollPane.setViewportView(table);

        JButton btnNewButton = new JButton("新增");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdministratorManagement.this.dispose();
                NewAdministrator na = new NewAdministrator();
                na.setVisible(true);
            }
        });
        btnNewButton.setBounds(307, 23, 103, 33);
        contentPane.add(btnNewButton);

        JButton button_1 = new JButton("删除");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int rowIndex = table.getSelectedRow();
                if(rowIndex<0){
                    JOptionPane.showMessageDialog(AdministratorManagement.this, "请选择要删除的行","错误提示",JOptionPane.ERROR_MESSAGE);
                }else{
                    int userId = (Integer) model.getValueAt(rowIndex, 0);
                    if(JOptionPane.showConfirmDialog(AdministratorManagement.this, "确定删除第"+(rowIndex+1)+"行?")==0){
                        UsersService us = new UsersService();
                        if(us.deleteUsersService(userId)){
                            JOptionPane.showMessageDialog(AdministratorManagement.this, "删除成功!");
                            AdministratorManagement.this.dispose();
                            AdministratorManagement frame = new AdministratorManagement();
                            frame.setVisible(true);
                        }
                    }
                }
            }
        });
        button_1.setBounds(451, 23, 103, 33);
        contentPane.add(button_1);

        JButton btnNewButton_1 = new JButton("返回主管理员界面");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdministratorManagement.this.dispose();
                RootAdministrator ra = new RootAdministrator();
                ra.setVisible(true);
            }
        });

        btnNewButton_1.setBounds(469, 297, 155, 43);
        contentPane.add(btnNewButton_1);
    }
}
