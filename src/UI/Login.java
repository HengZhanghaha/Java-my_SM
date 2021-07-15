package UI;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import service.UsersService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
/**
 * Editor: 张恒
 * Wechat：zh17530588817
 * */

public class Login extends JFrame {

    private JPanel contentPane;//面板
    private JTextField userName;
    final JPasswordField pwd =new JPasswordField();//密码不可更改
    private int roleId = 0;//角色

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        Login frame = new Login();
        frame.setVisible(true);

    }

    /**
     * Create the frame.
     */
    public Login() {

        this.setTitle("超市管理系统");//标题
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 200, 470, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//控制面板边界
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel beijing =new JLabel();
        /*beijing.setBounds(400, 200, 450, 300);*/
        ImageIcon beijing1 = new ImageIcon("D:\\MyData\\mine\\壁纸.jpg");
        beijing.setBounds(0,0,520,436);
        beijing.setIcon(new ImageIcon(beijing1.getImage()));

        JLabel Title = new JLabel("超 市 管 理 系 统");
        Title.setBounds(125,15,400,30);
        Title.setFont(new Font("黑体",Font.PLAIN,26));
        contentPane.add(Title);

        JLabel Jusername = new JLabel("员工名:");//标签
        Jusername.setBounds(82, 98, 54, 15);
        Jusername.setFont(new Font("宋体",Font.BOLD,14));
        contentPane.add(Jusername);

        userName = new JTextField();
        userName.setBounds(186,95,141,21);
        contentPane.add(userName);   //输入文本框

        JLabel Jpwd = new JLabel("密码:");
        Jpwd.setBounds(82, 144, 79, 15);
        Jpwd.setFont(new Font("宋体",Font.BOLD,14));
        contentPane.add(Jpwd);

        pwd.setBounds(186,137,141,21);
        pwd.setColumns(10);   //限制长度
        contentPane.add(pwd);

        JLabel label_1 = new JLabel("员工类别:");
        label_1.setBounds(80, 186, 100, 15);
        label_1.setFont(new Font("宋体",Font.BOLD,14));
        contentPane.add(label_1);



        final JComboBox comboBox = new JComboBox();  //将按钮或可编辑字段与下拉列表组合的组件
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"主管理员", "商品管理员", "收银员"}));
        //利用DefaultComboBoxModel类可以很方便地做到动态更改JComboBox的项目值
        comboBox.addItemListener(new ItemListener() {   //下拉列表框的选项监听，被选中的显示，未被选中的隐藏。
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(ItemEvent.SELECTED==e.getStateChange()){
                    roleId = comboBox.getSelectedIndex();
                }
            }
        });
        comboBox.setBounds(186, 186, 79, 21);
        contentPane.add(comboBox);

        JButton button = new JButton("登录");
        button.addActionListener(new ActionListener() {      //设置一个监听
            public void actionPerformed(ActionEvent e) {
                String UserName = userName.getText();    //获取输入的名字
                String Pwd = pwd.getText();          //获取输入的密码
                UsersService user = new UsersService();                   //用户相关服务
                if(user.checkUsersService(UserName, Pwd, roleId)){      //将输入的三个参数与数据库中的进行比对
                    Login.this.dispose();     //使用dispose()方法关闭的窗体可以使用pack 或 show 方法恢复，并且可以恢复到dispose前的状态
                    if(roleId == 0){//主管理员
                        RootAdministrator ra = new RootAdministrator();
                        ra.setVisible(true);
                    }else if(roleId == 1){//货物管理
                        GoodsAdministrator ga = new GoodsAdministrator();
                        ga.setVisible(true);
                    }else if(roleId == 2){//收银员
                        UsersService us = new UsersService();
                        int userId = us.getUserIdByUserNameService(UserName);
                        Cashier c = new Cashier(userId);
                        c.setVisible(true);
                    }
                }else{
                    JOptionPane.showMessageDialog(Login.this, "登陆失败!");
                }
            }
        });
        button.setBounds(100, 243, 93, 43);
        contentPane.add(button);

        JButton button_1 = new JButton("退出");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login.this.dispose();
            }
        });
        button_1.setBounds(264, 243, 93, 43);
        contentPane.add(button_1);
        this.add(beijing);
    }

}
