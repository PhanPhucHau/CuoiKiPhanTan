package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.sql.*;
import javax.swing.JPasswordField;

public class FormDangNhap extends JFrame implements ActionListener{
	private JTextField txt_Username;
	private JPasswordField txt_Pw;
	

    private static final String DEFAULT_MA_GV = "sa";
    private static final String DEFAULT_MAT_KHAU = "123";
	
	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JButton btnDN;
	private JButton btnHuy;
	private JRadioButton rdbtnNMK;
	private Connection con;
	private JPasswordField txtMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDangNhap frame = new FormDangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public FormDangNhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 261);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 197, 212);
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(FormDangNhap.class.getResource("/img/Hinh/images.jpg")));
		lblNewLabel_3.setBounds(0, 10, 197, 192);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(217, 10, 209, 212);
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTieuDe = new JLabel("Đăng nhập\r\n");
		lblTieuDe.setForeground(Color.BLUE);
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTieuDe.setBounds(59, 0, 140, 38);
		panel_1.add(lblTieuDe);
		
		JLabel lblTaiKhoan = new JLabel("Tài khoản\r\n");
		lblTaiKhoan.setForeground(Color.BLUE);
		lblTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTaiKhoan.setBounds(10, 48, 69, 13);
		panel_1.add(lblTaiKhoan);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu\r\n");
		lblMatKhau.setForeground(Color.BLUE);
		lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatKhau.setBounds(10, 101, 69, 16);
		panel_1.add(lblMatKhau);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(89, 48, 110, 19);
		panel_1.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
	    rdbtnNMK = new JRadioButton("Nhớ mật khẩu\r\n");
		rdbtnNMK.setBackground(Color.LIGHT_GRAY);
		rdbtnNMK.setBounds(45, 127, 105, 21);
		panel_1.add(rdbtnNMK);
		
		btnDN = new JButton("Đăng nhập\r\n");
		btnDN.setBounds(10, 166, 96, 21);
		panel_1.add(btnDN);
		btnDN.addActionListener(this);
		btnHuy = new JButton("Hủy bỏ\r\n");
		btnHuy.setBounds(116, 166, 83, 21);
		panel_1.add(btnHuy);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(89, 102, 110, 19);
		panel_1.add(txtMatKhau);
		btnHuy.addActionListener(this);
		setTitle("Đăng nhập");
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnDN)){
			DangNhap();
		}
		if(o.equals(btnHuy)) {
			Huy();
		}
	}

	private void Huy() {
		txtMatKhau.setText("");
		txtTaiKhoan.setText("");
		rdbtnNMK.setSelected(false);		
	}

	private void DangNhap() {
         // Kiểm tra thông tin đăng nhập
         if (txtTaiKhoan.equals(DEFAULT_MA_GV) && txtMatKhau.equals(DEFAULT_MAT_KHAU)) {
             // Nếu thông tin đăng nhập đúng, mở GUI_TrangChu
             GUI_GiaoDienChinh trangChu = new GUI_GiaoDienChinh();
             trangChu.setVisible(true);
             dispose(); // Đóng giao diện đăng nhập
             JOptionPane.showMessageDialog(FormDangNhap.this, "Đăng nhập thành công");
         } else {
             GUI_GiaoDienChinh kh = new GUI_GiaoDienChinh();
     		 kh.setVisible(true);
     		 this.setVisible(false);
         }
		
		
	}
}
