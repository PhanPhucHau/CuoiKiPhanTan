package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class GUI_GiaoDienChinh extends JFrame implements Runnable,ActionListener{

	private JPanel contentPane;
	int hour, second, minute;
	private JLabel lblClock;
	private JLabel lblDate;
	private JButton btnTrangChu;
	private JButton btnSanPham;
	private JButton btnNhanVien;
	private JButton btnHoaDon;
	private JButton btnKhachHang;
	private JButton btnDangXuat;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_GiaoDienChinh frame = new GUI_GiaoDienChinh();
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
	public GUI_GiaoDienChinh() {
		setTitle("Phần Mềm Quản Lý Học Sinh - Sinh Viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,800);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(0, 0, 1186, 773);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setForeground(Color.GREEN);
		toolBar.setBounds(0, 0, 1185, 50);
		panel.add(toolBar);
		
	    btnTrangChu = new JButton("Trang chủ");
		toolBar.add(btnTrangChu);
		btnTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTrangChu.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTrangChu.setIcon(new ImageIcon(GUI_GiaoDienChinh.class.getResource("/img/Hinh/Home.png")));
		
		btnSanPham = new JButton("Quản Lý Sinh Viên");
		btnSanPham.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSanPham.setIcon(new ImageIcon(GUI_GiaoDienChinh.class.getResource("/img/Hinh/Bar chart.png")));
		toolBar.add(btnSanPham);
		btnSanPham.addActionListener(this);
		
		btnNhanVien = new JButton("Thông Tin Cá Nhân");
		btnNhanVien.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNhanVien.setIcon(new ImageIcon(GUI_GiaoDienChinh.class.getResource("/img/Hinh/Users.png")));
		toolBar.add(btnNhanVien);
		
		// sự kiện
		btnNhanVien.addActionListener(this);
		
		btnHoaDon = new JButton("Quản Lý Môn Học");
		btnHoaDon.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHoaDon.setIcon(new ImageIcon(GUI_GiaoDienChinh.class.getResource("/img/Hinh/List.png")));
		toolBar.add(btnHoaDon);
		
		btnKhachHang = new JButton("Quản Lý Kết Quả Học Tập");
		btnKhachHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnKhachHang.setIcon(new ImageIcon(GUI_GiaoDienChinh.class.getResource("/img/Hinh/Users.png")));
		toolBar.add(btnKhachHang);
		
		btnDangXuat = new JButton("Đăng xuất\r\n");
		btnDangXuat.setIcon(new ImageIcon(GUI_GiaoDienChinh.class.getResource("/img/Hinh/Exit.png")));
		btnDangXuat.setFont(new Font("Tahoma", Font.BOLD, 18));
		toolBar.add(btnDangXuat);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.background"));
		panel_1.setBounds(0, 52, 1186, 711);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GUI_GiaoDienChinh.class.getResource("/img/Hinh/User.png")));
		lblNewLabel.setBounds(999, 33, 30, 34);
		panel_1.add(lblNewLabel);
		
		JLabel lblTenNhanVien = new JLabel("\r\n\r\n");
		lblTenNhanVien.setBounds(988, 54, 87, 13);
		panel_1.add(lblTenNhanVien);
		
		JLabel lblNewLabel_5 = new JLabel("PHẦN MỀM QUẢN LÝ HỌC SINH - SINH VIÊN");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_5.setBounds(190, 206, 1100, 125);
		panel_1.add(lblNewLabel_5);
		btnHoaDon.addActionListener(this);
		btnKhachHang.addActionListener(this);
		btnDangXuat.addActionListener(this);
		btnTrangChu.addActionListener(this);
		
		
		
		// Đồng hồ
		lblClock = new JLabel("");
		lblClock.setForeground(Color.RED);
		lblClock.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblClock.setBounds(866, 521, 113, 34);
		panel_1.add(lblClock);
		
		Thread t= new Thread(this);
		t.start();	
		// Ngày 
		lblDate = new JLabel("");
		lblDate.setForeground(Color.RED);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDate.setBounds(866, 464, 113, 28);
		panel_1.add(lblDate);
		
		lblNewLabel_1 = new JLabel("Nguyễn Tuấn Anh");
		lblNewLabel_1.setBounds(1047, 33, 113, 28);
		panel_1.add(lblNewLabel_1);
		showDate();
		
	}
	private void showDate() {
		// TODO Auto-generated method stub
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
		lblDate.setText(s.format(d));
		
	}

	@Override
	public void run() {
		while(true) {
			Calendar cal = Calendar.getInstance();
			hour = cal.get(Calendar.HOUR_OF_DAY);
			minute = cal.get(Calendar.MINUTE);
			second = cal.get(Calendar.SECOND);
			
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			Date dat = cal.getTime();
			String time = sdf.format(dat);
			
			lblClock.setText(time);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		/*if(o.equals(btnNhanVien)) {
			GiaoDien_NhanVien();
		}
		if(o.equals(btnHoaDon)) {
			GiaoDien_HoaDon();
		}
		if(o.equals(btnKhachHang)) {
			GiaoDien_KhachHang();
		}*/
		
		
		if(o.equals(btnDangXuat)) {
			int luachon = JOptionPane.showConfirmDialog(this, "Bạn muốn đăng xuất", "Chú ý", JOptionPane.YES_NO_OPTION);
			if(luachon == JOptionPane.YES_OPTION) {
				GiaoDien_DangXuat();
			}
		}	
		if(o.equals(btnSanPham)) {
			GiaoDien_SanPham();
		}	
		
		
	if(o.equals(btnKhachHang)) {
		GiaoDien_KhachHang();
	}
		if(o.equals(btnTrangChu)) {
			GiaoDien_TrangChu();
			
		}
	}

	private void GiaoDien_TrangChu() {
		GUI_GiaoDienChinh gui = new GUI_GiaoDienChinh();
		gui.setVisible(true);
		this.setVisible(false);
		
	}

	private void GiaoDien_DangXuat() {
		JOptionPane.showMessageDialog(this, "Đăng xuất thành công");
		FormDangNhap dn = new FormDangNhap();
		dn.setVisible(true);
		this.setVisible(false);
		
	}




	private void GiaoDien_KhachHang() {
		QuanLyKetQuaHocTap kh = new QuanLyKetQuaHocTap();
		kh.setVisible(true);
		this.setVisible(false);
		
	}


	
		
	

	private void GiaoDien_SanPham() {
		QuanLYSinhVien sp = new QuanLYSinhVien();
		sp.setVisible(true);
		this.setVisible(false);
		
		
	}

	
}
