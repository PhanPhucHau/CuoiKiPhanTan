package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;



public class QuanLyKetQuaHocTap extends JFrame implements ActionListener,MouseListener{
    private String StrName;
	private JPanel contentPane;
	private JButton btnTrangChu;
	private JButton btnSanPham;
	private JButton btnNhanVien;
	private JButton btnHoaDon;
	private JButton btnKhachHang;
	private JLabel lblTieuDe;
	private JButton btnDangXuat;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblMaKH;
	private JTextField txtMaKH;
	private JLabel lblTenKH;
	private JTextField txtTenKH;
	private JLabel lblNewLabel;
	private JTextField txtSDT;
	private JLabel lblDiaChi;
	private JTextField txtTimKiem;
	private JButton btnLamMoi;
	private JButton btnTimKiem;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField txtDiaChi;
	
	private DefaultTableModel tableModel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnIn;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyKetQuaHocTap frame = new QuanLyKetQuaHocTap();
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
	public QuanLyKetQuaHocTap() {

		
		
		setTitle("Phần Mềm Quản Lý Học Sinh - Sinh Viên\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 800);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1176, 50);
		contentPane.add(toolBar);
		
		btnTrangChu = new JButton("Trang chủ\r\n");
		btnTrangChu.setIcon(new ImageIcon(QuanLyKetQuaHocTap.class.getResource("/img/Hinh/Home.png")));
		btnTrangChu.setFont(new Font("Tahoma", Font.BOLD, 18));
		toolBar.add(btnTrangChu);
		
		btnNhanVien = new JButton("Quản Lý Sinh Viên");
		btnNhanVien.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNhanVien.setIcon(new ImageIcon(QuanLyKetQuaHocTap.class.getResource("/img/Hinh/Users.png")));
		toolBar.add(btnNhanVien);
		
		btnSanPham = new JButton("Thông Tin Cá Nhân");
		btnSanPham.setIcon(new ImageIcon(QuanLyKetQuaHocTap.class.getResource("/img/Hinh/Bar chart.png")));
		btnSanPham.setFont(new Font("Tahoma", Font.BOLD, 18));
		toolBar.add(btnSanPham);
		btnSanPham.addActionListener(this);
		
		btnHoaDon = new JButton("Quản Lý Môn Học");
		btnHoaDon.setIcon(new ImageIcon(QuanLyKetQuaHocTap.class.getResource("/img/Hinh/List.png")));
		btnHoaDon.setFont(new Font("Tahoma", Font.BOLD, 18));
		toolBar.add(btnHoaDon);
		
		btnKhachHang = new JButton("Quản Lý Kết Quả Học Tập");
		btnKhachHang.setIcon(new ImageIcon(QuanLyKetQuaHocTap.class.getResource("/img/Hinh/Unknown person.png")));
		btnKhachHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		toolBar.add(btnKhachHang);
		
		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setIcon(new ImageIcon(QuanLyKetQuaHocTap.class.getResource("/img/Hinh/Log out.png")));
		btnDangXuat.setFont(new Font("Tahoma", Font.BOLD, 18));
		toolBar.add(btnDangXuat);
		
		lblTieuDe = new JLabel("Quản Lý Kết Quả Học Tập");
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 45));
		lblTieuDe.setBounds(247, 60, 598, 61);
		contentPane.add(lblTieuDe);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Thông tin sinh viên", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(UIManager.getColor("Button.background"));
		panel_1.setBounds(10, 143, 367, 364);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblMaKH = new JLabel("Mã sinh viên");
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaKH.setBounds(25, 34, 117, 26);
		panel_1.add(lblMaKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(171, 34, 184, 26);
		panel_1.add(txtMaKH);
		txtMaKH.setColumns(10);
		txtMaKH.setEnabled(false);
		
		lblTenKH = new JLabel("Môn học");
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenKH.setBounds(25, 82, 117, 28);
		panel_1.add(lblTenKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(171, 82, 184, 26);
		panel_1.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		lblNewLabel = new JLabel("Học kì");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(25, 140, 117, 26);
		panel_1.add(lblNewLabel);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(171, 140, 181, 25);
		panel_1.add(txtSDT);
		txtSDT.setColumns(10);
		
		lblDiaChi = new JLabel("Điểm Thường kì");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDiaChi.setBounds(25, 188, 117, 34);
		panel_1.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(171, 188, 184, 29);
		panel_1.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblimGiaK = new JLabel("Điểm giữa kì");
		lblimGiaK.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblimGiaK.setBounds(25, 232, 117, 34);
		panel_1.add(lblimGiaK);
		
		JLabel lblimCuiK = new JLabel("Điểm cuối kì");
		lblimCuiK.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblimCuiK.setBounds(25, 276, 106, 34);
		panel_1.add(lblimCuiK);
		
		JLabel lblimTngKt = new JLabel("Điểm tổng kết");
		lblimTngKt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblimTngKt.setBounds(25, 320, 94, 34);
		panel_1.add(lblimTngKt);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(171, 227, 184, 29);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(171, 276, 184, 29);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(171, 320, 184, 29);
		panel_1.add(textField_2);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(UIManager.getColor("Button.background"));
		panel_2.setBounds(387, 143, 789, 66);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTimKiem = new JLabel("Tìm kiếm sinh viên");
		lblTimKiem.setIcon(null);
		lblTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTimKiem.setBounds(10, 10, 145, 46);
		panel_2.add(lblTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(169, 23, 326, 33);
		panel_2.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		btnLamMoi = new JButton("Làm mới\r\n");
		btnLamMoi.setIcon(new ImageIcon(QuanLyKetQuaHocTap.class.getResource("/img/Hinh/Refresh.png")));
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLamMoi.setBounds(657, 23, 121, 33);
		panel_2.add(btnLamMoi);
		
		btnTimKiem = new JButton("Tìm kiếm\r\n");
		btnTimKiem.setIcon(new ImageIcon(QuanLyKetQuaHocTap.class.getResource("/img/Hinh/Search.png")));
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimKiem.setBounds(505, 23, 131, 33);
		panel_2.add(btnTimKiem);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBackground(UIManager.getColor("Button.background"));
		panel_3.setBounds(10, 513, 367, 240);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		btnThem = new JButton("Thêm kết quả");
		btnThem.setIcon(new ImageIcon(QuanLyKetQuaHocTap.class.getResource("/img/Hinh/Add.png")));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThem.setBounds(67, 24, 228, 39);
		panel_3.add(btnThem);
		
		btnXoa = new JButton("Xóa kết quả");
		btnXoa.setIcon(new ImageIcon(QuanLyKetQuaHocTap.class.getResource("/img/Hinh/Delete.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoa.setBounds(67, 73, 228, 39);
		panel_3.add(btnXoa);
		
		btnSua = new JButton("Sửa kết quả");
		btnSua.setIcon(new ImageIcon(QuanLyKetQuaHocTap.class.getResource("/img/Hinh/Save as.png")));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSua.setBounds(67, 134, 228, 39);
		panel_3.add(btnSua);
		
		btnIn = new JButton("In");
		btnIn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnIn.setBounds(67, 191, 228, 39);
		panel_3.add(btnIn);
		
		String [] row = "Mã sinh viên; Môn Học; Học Kì; Điểm Thường kì; Điểm Giữa kì;Điểm Cuối kì;Điểm TB".split(";");
		tableModel = new DefaultTableModel(row, 0);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(387, 219, 789, 534);
		scrollPane.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		contentPane.add(scrollPane);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(QuanLyKetQuaHocTap.class.getResource("/img/Hinh/User.png")));
		lblNewLabel_1.setBounds(901, 66, 30, 24);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Phan Phúc Hậu\r\n");
		lblNewLabel_2.setBounds(958, 66, 97, 24);
		contentPane.add(lblNewLabel_2);
		// sự kiện
		btnNhanVien.addActionListener(this);
		btnHoaDon.addActionListener(this);
		btnKhachHang.addActionListener(this);
		btnDangXuat.addActionListener(this);
		btnTrangChu.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnLamMoi.addActionListener(this);
		table.addMouseListener(this);
		DocDuLieuDatabaseVaoTable();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnNhanVien)) {
			GiaoDien_NhanVien();
		}
		if(o.equals(btnHoaDon)) {
			GiaoDien_HoaDon();
		}
		if(o.equals(btnKhachHang)) {
			GiaoDien_KhachHang();
		
		}
		if(o.equals(btnDangXuat)) {
			int luachon = JOptionPane.showConfirmDialog(this, "Bạn muốn đăng xuất", "Chú ý", JOptionPane.YES_NO_OPTION);
			if(luachon == JOptionPane.YES_OPTION) {
				GiaoDien_DangXuat();
			}
		}	
		if(o.equals(btnSanPham)) {
			GiaoDien_SanPham();
		}	
		if(o.equals(btnTrangChu)) {
			GiaoDien_TrangChu();
		}
		if(o.equals(btnThem)) {
			int luachon = JOptionPane.showConfirmDialog(this, "Bạn muốn thêm một khách hàng mới ?", "Chú ý", JOptionPane.YES_NO_OPTION);
			if(luachon == JOptionPane.YES_OPTION) {
			if(validData()) {
			    themKhachHang();
			}
			}
		}
			
		if(o.equals(btnLamMoi)) {
			lamMoiDS();
		}	
		if(o.equals(btnSua)) {
			int luachon = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa thông tin khách hàng này? ", "Chú ý", JOptionPane.YES_NO_OPTION);
			if(luachon == JOptionPane.YES_OPTION) {
			if(validData())
			   suaKhachHang();
			}
		}
		if(o.equals(btnXoa)) {
			int luachon = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa khách hàng này? ", "Chú ý", JOptionPane.YES_NO_OPTION);
			if(luachon == JOptionPane.YES_OPTION) {
				xoaKhachHang();
			}
		}
			
		if(o.equals(btnTimKiem))
			timKiemTheoTen();
		
			xuatDanhSachKhachHang();
		
		
	}
	private void xuatDanhSachKhachHang() {
		/*try {
			XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Danh sách");

            XSSFRow row = null;
            Cell cell = null;

            row = sheet.createRow(3);
     
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Mã khách hàng");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Tên khách hàng");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Số điện thoại");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Địa chỉ");
          

           ArrayList<KhachHang> arr = new ArrayList<KhachHang>();


            for (int i = 0; i < arr.size(); i++) {
                row = sheet.createRow(4+i);
                
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i+1);
                
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(arr.get(i).getMaKH());
                
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(arr.get(i).getTenKH());
                
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(arr.get(i).getsDT());
                
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(arr.get(i).getDiaChi());
                         
            }
            File f = new File("D:/java/DoAn/danhsachkhachhang.xlsx");
            try {
				FileOutputStream file = new FileOutputStream(f);
				workbook.write(file);
				file.close();
				JOptionPane.showMessageDialog(this,"Xuất danh sách thành công");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
            
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
	}

	private void timKiemTheoTen() {
		
		
	}

	private void xoaKhachHang() {
		
		}
		
	
	public void xoaTrang()
	{
		txtMaKH.setText("");
		txtTenKH.setText("");
		txtSDT.setText("");
		txtDiaChi.setText("");
		txtMaKH.requestFocus();
	}

	private void suaKhachHang() {
			
	}

	private void lamMoiDS() {
		QuanLyKetQuaHocTap k = new QuanLyKetQuaHocTap();
		k.setVisible(true);
		
		
	}

	private void themKhachHang() {
		
		
		
		

		
	}

	private void GiaoDien_TrangChu() {
		GUI_GiaoDienChinh gui = new GUI_GiaoDienChinh();
		gui.setVisible(true);
		this.setVisible(false);
		
	}

	private void GiaoDien_DangXuat() {
		int luachon = JOptionPane.showConfirmDialog(this, "Bạn muốn đăng xuất", "Chú ý", JOptionPane.YES_NO_OPTION);
		if(luachon == JOptionPane.YES_OPTION) {
		JOptionPane.showMessageDialog(this, "Đăng xuất thành công");
		FormDangNhap dn = new FormDangNhap();
		dn.setVisible(true);
		this.setVisible(false);
		}
		
	}

	private void GiaoDien_HuongDan() {
/*		HuongDanForm hd = new HuongDanForm();
		hd.setVisible(true);
		this.setVisible(false);
*/		
	}

	private void GiaoDien_ThongKe() {
/*		ThongKeForm tk = new ThongKeForm();
		tk.setVisible(true);
		this.setVisible(false);
*/		
	}

	private void GiaoDien_KhachHang() {
		QuanLyKetQuaHocTap kh = new QuanLyKetQuaHocTap();
		kh.setVisible(true);
		this.setVisible(false);
		
	}

	private void GiaoDien_HoaDon() {
/*		HoaDonForm hdon = new HoaDonForm();
		hdon.setVisible(true);
		this.setVisible(false);
*/		
		
	}

	private void GiaoDien_NhanVien() {
		
	}

	private void GiaoDien_SanPham() {
		QuanLYSinhVien sp = new QuanLYSinhVien();
		sp.setVisible(true);
		this.setVisible(false);
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaKH.setText(tableModel.getValueAt(row, 0).toString());
		txtMaKH.setEnabled(false);
		txtTenKH.setText(tableModel.getValueAt(row, 1).toString());
		txtSDT.setText(tableModel.getValueAt(row, 2).toString());
		txtDiaChi.setText(tableModel.getValueAt(row, 3).toString());
		
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
	public void DocDuLieuDatabaseVaoTable() {
		
	}
	
	private boolean validData() {
		String ma = txtMaKH.getText().trim();
		String ten = txtTenKH.getText().trim();
		String sdt = txtSDT.getText().trim();
		String diachi = txtDiaChi.getText().trim();
/*		if(ma.length() == 0) {
			JOptionPane.showMessageDialog(this, "Bắt buộc nhập mã khách hàng");
			txtMaKH.requestFocus();
			return false;
		}else {
		if(!(ma.length() > 0 && ma.matches("^KH[0-9]{5}$"))) {
			JOptionPane.showMessageDialog(this, "Nhập mã theo mẫu KHxxxxx");
			txtMaKH.requestFocus();
			return false;
		}

		}
			*/
		if(ten.length() == 0) {
			JOptionPane.showMessageDialog(this, "Bắt buôc nhập họ tên");
			txtTenKH.requestFocus();
			return false;
		}
		if(sdt.length() == 0) {
			JOptionPane.showMessageDialog(this, "Bắt buôc nhập số điện thoại");
			txtSDT.requestFocus();
			return false;
		}else {	
		if(!(sdt.length() > 0 && sdt.matches("[0-9]{10}"))) {
			JOptionPane.showMessageDialog(this, "Bắt buộc nhập số và nhập đủ 10 số");
			txtMaKH.requestFocus();
			return false;
		}
		}
		if(diachi.length() == 0 ) {
			JOptionPane.showMessageDialog(this, "Bắt buộc nhập địa chỉ khách hàng");
			txtDiaChi.requestFocus();
			return false;
		}
		
		return true;
		
	}

}
