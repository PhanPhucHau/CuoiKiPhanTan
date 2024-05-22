package app;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import entities.KetQua;
import entities.LopHoc;
import entities.MonHoc;
import entities.NganhHoc;
import entities.SinhVien;
import jakarta.persistence.EntityManager;
import service.EntityManagerFactoryUtil;
import service.KetQuaService;
import service.LopHocService;
import service.MonHocService;
import service.NganhHocService;
import service.SinhVienService;

public class Server {
	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(7777);){
			System.out.println("Server running port 7777");
			while(true) {
				Socket clientSocket = server.accept();			
				Thread t = new Thread(new ClientHandler(clientSocket));
				t.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	class ClientHandler implements Runnable{
		private Socket clientSocket;
		private EntityManagerFactoryUtil entityManagerFactoryUtil;
		private EntityManager entityManager;
		private SinhVienService sinhVienService;
		private LopHocService lopHocService;
		private MonHocService monHocService;
		private NganhHocService nganhHocService;
		private KetQuaService ketQuaService;
		
		public ClientHandler(Socket clinentSocket) {
		   this.clientSocket = clinentSocket;
		   this.entityManagerFactoryUtil = new EntityManagerFactoryUtil();
		   this.entityManager = entityManagerFactoryUtil.getEntityManager();
		   this.sinhVienService = new SinhVienService(this.entityManager);
		   this.lopHocService = new LopHocService(this.entityManager);
		   this.nganhHocService = new NganhHocService(this.entityManager);
		   this.monHocService = new MonHocService(this.entityManager);
		   this.ketQuaService = new KetQuaService(this.entityManager);
		}
		
		@Override
		public void run() {
			try {
				ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
				int choice = 0;
				
				while(true) {
					choice = in.readInt();
					switch (choice) {
					case 1:
						List<SinhVien> sinhViens = sinhVienService.findAll();
						out.writeObject(sinhViens);
						out.flush();
						break;
					case 2: 
						List<LopHoc> lopHocs = lopHocService.findAll();
						out.writeObject(lopHocs);
						out.flush();
						break;
					case 3: 
						List<NganhHoc> nganhHocs = nganhHocService.findAll();
						out.writeObject(nganhHocs);
						out.flush();
						break;
					case 4: 
						List<MonHoc> monHocs = monHocService.findAll();
						out.writeObject(monHocs);
						out.flush();
						break;
					case 5: 
						List<KetQua> ketQuas = ketQuaService.findAll();
						out.writeObject(ketQuas);
						out.flush();
						break;
					case 6: 
						SinhVien newSinhVien = (SinhVien) in.readObject();
						boolean addSuccess = sinhVienService.addSinhVien(newSinhVien);
						out.writeBoolean(addSuccess);
						out.flush();
						break;
					case 7: // Cập nhật thông tin sinh viên
				        SinhVien updatedSinhVien = (SinhVien) in.readObject();
				        boolean updateSuccess = sinhVienService.updateSinhVien(updatedSinhVien);
				        out.writeBoolean(updateSuccess);
				        out.flush();
				        break;

				    case 8: // Xóa sinh viên
				        int sinhVienIdToDelete = in.readInt();
				        boolean deleteSuccess = sinhVienService.deleteSinhVien(sinhVienIdToDelete);
				        out.writeBoolean(deleteSuccess);
				        out.flush();
				        break;
					}
					
				}
				
				
				
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				this.entityManagerFactoryUtil.closEntityManager();
				this.entityManagerFactoryUtil.closEntityManagerFatory();
			}		
		}
		
	}
