package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import service.CustomerService;

import entity.Customers;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Editor: 张恒
 * Wechat：zh17530588817
 * */

public class NewCustomer extends JFrame {


    private JPanel contentPane;
    private JTextField cstName;
    private JTextField telephone;
    private JTextField cstNo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        NewCustomer frame = new NewCustomer();
        frame.setVisible(true);
    }

    /**
     * Create the frame.
     */
    public NewCustomer() {
        this.setTitle("新增会员");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 200, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("会员编号:");
        lblNewLabel.setBounds(80, 35, 76, 15);
        contentPane.add(lblNewLabel);

        cstNo = new JTextField();
        cstNo.setBounds(166, 32, 148, 21);
        contentPane.add(cstNo);
        cstNo.setColumns(10);

        JLabel label = new JLabel("会员名:");
        label.setBounds(89, 80, 54, 15);
        contentPane.add(label);

        cstName = new JTextField();
        cstName.setColumns(10);
        cstName.setBounds(166, 77, 148, 21);
        contentPane.add(cstName);

        JLabel label_1 = new JLabel("会员联系方式:");
        label_1.setBounds(58, 131, 85, 15);
        contentPane.add(label_1);

        telephone = new JTextField();
        telephone.setColumns(10);
        telephone.setBounds(166, 128, 148, 21);
        contentPane.add	(telephone);

        JButton btnNewButton = new JButton("提交");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Customers customer = new Customers();
                customer.setCustomerNo(cstNo.getText());
                customer.setCustomerName(cstName.getText());
                customer.setCustomerTel(telephone.getText());
                CustomerService cs = new CustomerService();
                //if(cs.checkCustomerNoDao(cstNo.getText())){
                int flag=cs.newCustomersService(customer);
                if(flag != 0){
                    JOptionPane.showMessageDialog(NewCustomer.this, "添加会员成功!会员号码是"+customer.getCustomerNo());
                }else{
                    JOptionPane.showMessageDialog(NewCustomer.this, "添加会员失败!");
                }
                //}
            }
        });
        btnNewButton.setBounds(99, 189, 93, 23);
        contentPane.add(btnNewButton);

        JButton button = new JButton("返回");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NewCustomer.this.dispose();
                CustomerManagement cm = new CustomerManagement();
                cm.setVisible(true);
            }
        });
        button.setBounds(243, 189, 93, 23);
        contentPane.add(button);

    }
}
