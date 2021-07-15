package UI;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Editor: 张恒
 * Wechat：zh17530588817
 * */

public class RootAdministrator extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        RootAdministrator frame = new RootAdministrator();
        frame.setVisible(true);
    }

    /**
     * Create the frame.
     */
    public RootAdministrator() {
        this.setTitle("主管理员界面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 200, 500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);   //清空布局管理器

        //修改字体大小
        JLabel lblNewLabel = new JLabel("管理员,请选择要执行的功能模块");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 22));
        lblNewLabel.setSize(new Dimension(20,20));
        lblNewLabel.setBounds(78, 33, 318, 49);
        contentPane.add(lblNewLabel);

        JButton btnNewButton = new JButton("管理员工信息");

        btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 17));

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RootAdministrator.this.dispose();
                AdministratorManagement am = new AdministratorManagement(); //打开员工信息管理界面
                am.setVisible(true);
            }
        });
        btnNewButton.setBounds(170, 120, 159, 41);
        contentPane.add(btnNewButton);

        JButton button = new JButton("管理顾客信息");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RootAdministrator.this.dispose();
                CustomerManagement cm = new CustomerManagement();   // 打开会员信息管理界面
                cm.setVisible(true);
            }
        });
        button.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        button.setBounds(170, 200, 159, 41);
        contentPane.add(button);

        JButton btnNewButton1 = new JButton("管理商品信息");
        btnNewButton1.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        btnNewButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RootAdministrator.this.dispose();
                GoodsAdministrator qh = new GoodsAdministrator();   // 打开商品信息管理界面
                qh.setVisible(true);
            }
        });
        btnNewButton1.setBounds(170, 280, 159, 41);
        contentPane.add(btnNewButton1);

        JButton btnNewButton_1 = new JButton("返回登录界面");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RootAdministrator.this.dispose();
                Login lg = new Login();           // 返回登陆界面
                lg.setVisible(true);
            }
        });
        btnNewButton_1.setBounds(350, 360, 117, 35);
        contentPane.add(btnNewButton_1);
    }

}
