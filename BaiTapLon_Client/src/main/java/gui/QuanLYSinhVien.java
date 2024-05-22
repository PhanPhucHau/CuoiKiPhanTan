package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;


import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JRadioButton;



public class QuanLYSinhVien extends JFrame implements ActionListener,MouseListener{

	String filename = null;
	byte[] person_image = null;
	
	
	private JPanel contentPane;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtGiaSP;
	private JTextField txtTimKiem;
	private JTextField txtKichThuoc;
	private JButton btnTrangChu;
	private JButton btnSanPham;
	private JButton btnNhanVien;
	private JButton btnHoaDon;
	private JButton btnThongKe;
	private JButton btnDangXuat;
	private JTable table;
	
	private JComboBox cboThuongHieu;
	private DefaultTableModel tableModel;
	private JComboBox<String> cboNhaCC;
	private JLabel lblAnh;
	String anh = "";
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	
	private JTable table_CN;
	DefaultTableModel DataModel;
	private String imagePath;
	private JButton btnLamMoi;
	private JButton btnTimKiem;
	private String StrName;
	private JToolBar toolBar_1;
	private JToolBar toolBar_2;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLYSinhVien frame = new QuanLYSinhVien();
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
	public QuanLYSinhVien() {
		// Kết nối database để lấy dử liệu lên cbo
		
		setTitle("Phần Mềm Quản Lý Học Sinh - Sinh Viên\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 800);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1186, 773);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1185, 50);
		panel.add(toolBar);
		
		btnTrangChu = new JButton("Trang chủ\r\n");
		btnTrangChu.setIcon(new ImageIcon(QuanLYSinhVien.class.getResource("/img/Hinh/Home.png")));
		btnTrangChu.setFont(new Font("Tahoma", Font.BOLD, 18));
		toolBar.add(btnTrangChu);
		
		btnSanPham = new JButton("Quản Lý Sinh Viên");
		btnSanPham.setIcon(new ImageIcon(QuanLYSinhVien.class.getResource("/img/Hinh/Bar chart.png")));
		btnSanPham.setFont(new Font("Tahoma", Font.BOLD, 18));
		toolBar.add(btnSanPham);
		
		btnNhanVien = new JButton("Thông Tin Cá Nhân");
		btnNhanVien.setIcon(new ImageIcon(QuanLYSinhVien.class.getResource("/img/Hinh/Users.png")));
		btnNhanVien.setFont(new Font("Tahoma", Font.BOLD, 18));
		toolBar.add(btnNhanVien);
		
		btnHoaDon = new JButton("Quản Lý Môn Học");
		btnHoaDon.setIcon(new ImageIcon(QuanLYSinhVien.class.getResource("/img/Hinh/List.png")));
		btnHoaDon.setFont(new Font("Tahoma", Font.BOLD, 18));
		toolBar.add(btnHoaDon);
		
		btnThongKe = new JButton("Quản Lý Kết Quả Học Tập");
		btnThongKe.setIcon(new ImageIcon(QuanLYSinhVien.class.getResource("/img/Hinh/Statistics.png")));
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 18));
		toolBar.add(btnThongKe);
		
		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setIcon(new ImageIcon(QuanLYSinhVien.class.getResource("/img/Hinh/Log out.png")));
		btnDangXuat.setFont(new Font("Tahoma", Font.BOLD, 18));
		toolBar.add(btnDangXuat);
		
		toolBar_1 = new JToolBar();
		toolBar_1.setForeground(Color.GREEN);
		toolBar.add(toolBar_1);

		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.background"));
		panel_1.setBounds(0, 55, 1186, 708);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản lý Học Sinh - Sinh Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(464, 0, 496, 54);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(QuanLYSinhVien.class.getResource("/img/Hinh/User.png")));
		lblNewLabel_1.setBounds(1021, 10, 24, 24);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nguyễn Tuấn Anh");
		lblNewLabel_2.setBounds(1070, 10, 106, 24);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Thông tin sinh viên", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(UIManager.getColor("Button.background"));
		panel_2.setBounds(10, 52, 292, 656);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMaSP = new JLabel("Mã sinh viên\r\n");
		lblMaSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaSP.setBounds(21, 24, 96, 23);
		panel_2.add(lblMaSP);
		
		txtMaSP = new JTextField();
		txtMaSP.setBounds(137, 28, 139, 19);
		
		panel_2.add(txtMaSP);
		txtMaSP.setColumns(10);
		
		JLabel lblTenSP = new JLabel("Họ tên");
		lblTenSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenSP.setBounds(21, 68, 116, 23);
		panel_2.add(lblTenSP);
		
		txtTenSP = new JTextField();
		txtTenSP.setBounds(137, 72, 139, 19);
		panel_2.add(txtTenSP);
		txtTenSP.setColumns(10);
		
		JLabel lblGiaSP = new JLabel("Địa chỉ");
		lblGiaSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiaSP.setBounds(21, 101, 96, 29);
		panel_2.add(lblGiaSP);
		
		txtGiaSP = new JTextField();
		txtGiaSP.setBounds(137, 108, 139, 19);
		panel_2.add(txtGiaSP);
		txtGiaSP.setColumns(10);
		
		JLabel lblSoLuong = new JLabel("Giới tính");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSoLuong.setBounds(21, 147, 96, 23);
		panel_2.add(lblSoLuong);
		
		JLabel lblThuongHieu = new JLabel("Số điện thoại");
		lblThuongHieu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThuongHieu.setBounds(21, 191, 96, 24);
		panel_2.add(lblThuongHieu);
		
		
		cboThuongHieu = new JComboBox<String>();
		cboThuongHieu.setEditable(true);
		cboThuongHieu.setBounds(137, 285, 139, 21);
		
		
		panel_2.add(cboThuongHieu);
		
		JLabel lblNhaCC = new JLabel("Tên lớp");
		lblNhaCC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNhaCC.setBounds(21, 237, 96, 23);
		panel_2.add(lblNhaCC);
		
		cboNhaCC = new JComboBox<String>();
		cboNhaCC.setBounds(137, 240, 139, 21);
		
		
		JLabel lblKichThuoc = new JLabel("Tên ngành");
		lblKichThuoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKichThuoc.setBounds(22, 282, 95, 23);
		panel_2.add(lblKichThuoc);
		
		txtKichThuoc = new JTextField();
		txtKichThuoc.setBounds(137, 196, 139, 19);
		panel_2.add(txtKichThuoc);
		txtKichThuoc.setColumns(10);
		
		
		panel_2.add(cboNhaCC);
		
	    lblAnh = new JLabel("\r\n");
		lblAnh.setBackground(Color.LIGHT_GRAY);
		lblAnh.setBounds(137, 519, 139, 127);
		panel_2.add(lblAnh);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
		rdbtnNewRadioButton.setBounds(129, 150, 63, 21);
		panel_2.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnN = new JRadioButton("Nữ");
		rdbtnN.setBounds(212, 150, 55, 21);
		panel_2.add(rdbtnN);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(UIManager.getColor("Button.background"));
		panel_3.setBounds(312, 52, 864, 52);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		btnTimKiem = new JButton("Tìm kiếm\r\n");
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimKiem.setIcon(new ImageIcon(QuanLYSinhVien.class.getResource("/img/Hinh/Search.png")));
		btnTimKiem.setBounds(563, 13, 134, 32);
		panel_3.add(btnTimKiem);
		
		btnLamMoi = new JButton("Làm mới\r\n");
		btnLamMoi.setIcon(new ImageIcon(QuanLYSinhVien.class.getResource("/img/Hinh/Refresh.png")));
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLamMoi.setBounds(720, 14, 134, 31);
		panel_3.add(btnLamMoi);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(160, 13, 393, 28);
		panel_3.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Tìm kiếm sinh viên");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_15.setBounds(10, 10, 146, 31);
		panel_3.add(lblNewLabel_15);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBackground(UIManager.getColor("Button.background"));
		panel_5.setBounds(312, 535, 864, 78);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		btnThem = new JButton("Thêm sinh viên");
		btnThem.setIcon(new ImageIcon(QuanLYSinhVien.class.getResource("/img/Hinh/Add.png")));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(10, 20, 188, 48);
		panel_5.add(btnThem);
		
		btnXoa = new JButton("Xóa sinh viên");
		btnXoa.setIcon(new ImageIcon(QuanLYSinhVien.class.getResource("/img/Hinh/Delete.png")));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(236, 20, 165, 48);
		panel_5.add(btnXoa);
		
		btnSua = new JButton("Sửa sinh viên");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSua.setIcon(new ImageIcon(QuanLYSinhVien.class.getResource("/img/Hinh/Documents.png")));
		btnSua.setBounds(445, 20, 171, 48);
		panel_5.add(btnSua);
		
		JButton btnIn = new JButton("IN");
		btnIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIn.setBounds(645, 20, 171, 48);
		panel_5.add(btnIn);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(312, 114, 864, 411);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 844, 377);
	
		String [] row = "Mã lớp;Mã ngành; Mã sinh viên;Địa chỉ;Giới tính;Tên sinh viên".split(";");
		tableModel = new DefaultTableModel(row, 0);
		tableModel.addRow(new Object[]{"1", "1", "20099441","Bình Thuận", "nam", "Nguyễn Tuấn Anh" });
		tableModel.addRow(new Object[]{"2", "1", "20109451","Bến Tre", "nam", "PHan PHúc Hậu" });
		tableModel.addRow(new Object[]{"1", "1", "20184654","Bình Thuận", "nam", "Nguyễn Tuấn Tú" });
		//DataModel.addRow(new Object[]{"KTPM16", "Kỹ thuật phần mềm", "Khoa Công nghệ thông tin","30/07/2024", "30/07/2028", "Hoạt động" });
	//	DataModel.addRow(new Object[]{"KHMT15", "Khoa học máy tính", "Khoa Công nghệ thông tin","30/07/2024", "30/07/2028", "Hoạt động" });

		
		scrollPane.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		panel_6.add(scrollPane);
		
		toolBar_2 = new JToolBar();
		toolBar_2.setForeground(Color.GREEN);
		toolBar_2.setBounds(0, 0, 1185, 50);
		panel.add(toolBar_2);
		
		
		// sự kiện
		btnNhanVien.addActionListener(this);
		btnHoaDon.addActionListener(this);
		btnThongKe.addActionListener(this);
		btnSanPham.addActionListener(this);
		btnDangXuat.addActionListener(this);
		btnTrangChu.addActionListener(this);
		table.addMouseListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnTimKiem.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnDangXuat)) {
			int luachon = JOptionPane.showConfirmDialog(this, "Bạn muốn đăng xuất", "Chú ý", JOptionPane.YES_NO_OPTION);
			if(luachon == JOptionPane.YES_OPTION) {
				GiaoDien_DangXuat();
			}
		}
		if(o.equals(btnSanPham)) {
			GiaoDien_QuanLySinhVien();
		}
		
	}
	
	private void GiaoDien_QuanLySinhVien() {
		QuanLyKetQuaHocTap gui  = new QuanLyKetQuaHocTap();
		gui.setVisible(true);
		this.setVisible(false);
		
	}

	private void TimSanPham() {
		
	}
	private void GiaoDien_ThuongHieu() {
		
		
	}

	private void GiaoDien_NhaCungCap() {
		
		
	}

	private void GiaoDien_XuatXu() {
		
		
	}

	private void GiaoDien_LoaiSanPham() {
		
		
	}

	private void LamMoi() {
		QuanLYSinhVien sp = new QuanLYSinhVien();
		sp.setVisible(true);
		
		
	}

	
				
				
		

	
	


	
	

	private void LayHinhAnh() {
		
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

/*	private void GiaoDien_HuongDan() {
		HuongDanForm hd = new HuongDanForm();
		hd.setVisible(true);
		this.setVisible(false);
		
	}

	private void GiaoDien_ThongKe() {
		ThongKeForm tk = new ThongKeForm();
		tk.setVisible(true);
		this.setVisible(false);
		
	}

	private void GiaoDien_KhachHang() {
		KhachHangForm kh = new KhachHangForm();
		kh.setVisible(true);
		this.setVisible(false);
		
	}

	private void GiaoDien_HoaDon() {
		HoaDonForm hdon = new HoaDonForm();
		hdon.setVisible(true);
		this.setVisible(false);
		
		
	}

	private void GiaoDien_NhanVien() {
		NhanVienForm nv = new NhanVienForm();
		nv.setVisible(true);
		this.setVisible(false);
		
	}

	private void GiaoDien_SanPham() {
		SanPhamForm sp = new SanPhamForm();
		sp.setVisible(true);
		this.setVisible(false);
		
		
	}
	private void DocDuLieuDatabaseVaoTable()
	{
		SanPham_Dao ds = new SanPham_Dao();
		List<SanPham> list = ds.getalltblSanPham();
		for(SanPham s :list)
		{
			String [] rowData = {
					
					
			};
			tableModel.addRow(rowData);
		}
		table.setModel(tableModel);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaSP.setEnabled(false);
		txtMaSP.setText(tableModel.getValueAt(row, 0).toString());
		txtTenSP.setText(tableModel.getValueAt(row, 1).toString());
		txtGiaSP.setText(tableModel.getValueAt(row, 2).toString());
		
		cboThuongHieu.setSelectedItem(table.getValueAt(row, 4).toString());
		cboNhaCC.setSelectedItem(table.getValueAt(row, 5).toString());
		txtKichThuoc.setText(tableModel.getValueAt(row, 6).toString());
		
		
//		lblAnh.setText(table.getValueAt(row, 11).toString());
		String path = tableModel.getValueAt(row, 11).toString();
		imagePath = path;
		lblAnh.setIcon(imageAdjust(path, null));
	
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	private boolean validData() {
	//	String ma = txtMaSP.getText().trim();
		String ten = txtTenSP.getText().trim();
	//	Date ngaysinh = txtNgaySinh.getText().trim();
		Double giasp = Double.valueOf(txtGiaSP.getText().toString());

		
		
		
	
		if(ten.length() == 0) {
			JOptionPane.showMessageDialog(this, "Bắt buôc nhập tên sản phẩm");
			txtTenSP.requestFocus();
			return false;
		}
/*		if( giasp.doubleValue() <= 0) {
			JOptionPane.showMessageDialog(this, "Bắt buôc nhập giá sản phẩm phải lớn hơn 0");
			txtGiaSP.requestFocus();
			return false;
		}
		*/
		
			
		
	
		
			
	
				/*
		if(txtNgaySinh.getDate().compareTo(new Date()) > 0) {
			JOptionPane.showMessageDialog(this, "Bắt buộc nhập ngày sinh");
			txtNgaySinh.requestFocus();
			return false;	
		}
		*/
		
		
		


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	}
