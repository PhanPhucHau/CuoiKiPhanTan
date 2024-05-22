package app;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

import entities.KetQua;
import entities.LopHoc;
import entities.MonHoc;
import entities.NganhHoc;
import entities.SinhVien;

public class Client {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)){
			
			try (Socket socket = new Socket("192.168.137.72", 7777)) {
				
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				
				
				int choice = 0;
				System.out.println("Enter your choice: \n" + 
						"1. Lấy ra danh sách sinh viên\n" + 
						"2. Lấy ra danh sách lớp học\n" +
						"3. Lấy ra danh sách ngành học\n" +
						"4. Lấy ra danh sách môn học\n" +
						"5. Lấy ra danh sách kết quả học tập\n"+
						"6. Thêm sinh viên mới \n"+
						"7. Chỉnh sửa thông tin sinh viên\n"+
						"8. Xóa sinh viên theo id \n"
						
						);
				
				while(true) {
					choice = sc.nextInt();
					out.writeInt(choice);
					out.flush();
					
					switch (choice) {
					case 1:
						System.out.println("Danh sách sinh viên");
						List<SinhVien> sinhViens = (List<SinhVien>) in.readObject();
						sinhViens.forEach(System.out::println);
						break;
					case 2:
						System.out.println("Danh sách lớp học");
						List<LopHoc> lopHocs = (List<LopHoc>) in.readObject();
						lopHocs.forEach(System.out::println);
						break;
					case 3:
						System.out.println("Danh sách ngành học");
						List<NganhHoc> nganhHocs = (List<NganhHoc>) in.readObject();
						nganhHocs.forEach(System.out::println);
						break;
						
					case 4:
						System.out.println("Danh sách môn học");
						List<MonHoc> monHocs = (List<MonHoc>) in.readObject();
						monHocs.forEach(System.out::println);
						break;
					case 5:
						System.out.println("Danh sách kết quả học tập");
						List<KetQua> ketQuas = (List<KetQua>) in.readObject();
						ketQuas.forEach(System.out::println);
						break;
					case 6: 
						SinhVien newSinhVien = new SinhVien();
						
						System.out.println("Nhập thông tin sinh viên mới");
						System.out.print("Nhập mã sinh viên: ");
						int id = sc.nextInt();
						newSinhVien.setId(id);
						sc.nextLine();
						
						System.out.print("Nhập tên sinh viên:");
					    String tenSV = sc.nextLine();
					    newSinhVien.setTenSV(tenSV);

					    System.out.print("Nhập giới tính:");
					    String gioiTinh = sc.nextLine();
					    newSinhVien.setGioiTinh(gioiTinh);

					    System.out.print("Nhập địa chỉ:");
					    String diaChi = sc.nextLine();
					    newSinhVien.setDiaChi(diaChi);
					    
					    System.out.println("Nhập mã lớp học:");
					    int maLopHoc = sc.nextInt();
					    LopHoc lopHoc = new LopHoc();					
					    lopHoc.setId(maLopHoc);
					    newSinhVien.setLopHoc(lopHoc);

					    // Nhập mã ngành học
					    System.out.println("Nhập mã ngành học:");
					    int maNganhHoc = sc.nextInt();
					    NganhHoc nganhHoc = new NganhHoc();
					    nganhHoc.setId(maNganhHoc);
					    newSinhVien.setNganhHoc(nganhHoc);
						
						
						out.writeObject(newSinhVien);
						out.flush();
						boolean addSuccess = in.readBoolean();
				        if (addSuccess) {
				            System.out.println("Sinh viên được thêm thành công!");
				        } else {
				            System.out.println("Thêm sinh viên thất bại!");
				        }
				        break;
					 case 7: 
					        SinhVien updatedSinhVien = new SinhVien();
					        
					        System.out.println("Chỉnh sửa thông tin sinh viên theo mã sinh viên");
							System.out.print("Nhập mã sinh viên cần chỉnh sửa thông tin : ");
							int idSV = sc.nextInt();
							updatedSinhVien.setId(idSV);
							sc.nextLine();
							
							System.out.print("Nhập tên sinh viên:");
						    String tenSVUpdate = sc.nextLine();
						    updatedSinhVien.setTenSV(tenSVUpdate);

						    System.out.print("Nhập giới tính:");
						    String gioiTinhUpdate = sc.nextLine();
						    updatedSinhVien.setGioiTinh(gioiTinhUpdate);

						    System.out.print("Nhập địa chỉ:");
						    String diaChiUpdate = sc.nextLine();
						    updatedSinhVien.setDiaChi(diaChiUpdate);


					        out.writeObject(updatedSinhVien);
					        out.flush();
					        boolean updateSuccess = in.readBoolean();
					        if (updateSuccess) {
					            System.out.println("Thông tin sinh viên được cập nhật thành công!");
					        } else {
					            System.out.println("Cập nhật thông tin sinh viên thất bại!");
					        }
					        break;

					    case 8: // Xóa sinh viên
					        System.out.println("Nhập ID của sinh viên cần xóa: ");
					        int sinhVienIdToDelete = sc.nextInt();
					        out.writeInt(sinhVienIdToDelete);
					        out.flush();
					        boolean deleteSuccess = in.readBoolean();
					        if (deleteSuccess) {
					            System.out.println("Sinh viên được xóa thành công!");
					        } else {
					            System.out.println("Xóa sinh viên thất bại!");
					        }
					        break;
					}
					
					
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}		
		} 
	}

}
