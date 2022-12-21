package com.giao.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.giao.bean.DienThoai;
import com.giao.service.DienThoaiService;
import com.giao.service.HangService;

/**
 * Servlet implementation class AdminSuaDienThoai
 */
@WebServlet("/admin/suadienthoai")
public class AdminSuaDienThoai extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminSuaDienThoai() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		if (session.getAttribute("admin") == null) {
			response.sendRedirect("dangnhap");
			return;
		}

		String ma = request.getParameter("ma");
		if (ma != null) {
			try {
				DienThoaiService service = new DienThoaiService();
				DienThoai dt = service.getDienThoai(Integer.parseInt(ma));
				HangService hang = new HangService();

				request.setAttribute("dt", dt);
				request.setAttribute("hang", hang.getAllHang());
				RequestDispatcher rd = request.getRequestDispatcher("suadienthoai.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "images";
			System.out.println("dir: " + dirUrl1);

			String tenDienThoai = null;
			String maHang = null;
			int soLuong = 0;
			long gia = 0;
			String ngayNhap = null;
			String anhCu = null;
			String anhMoi = null;
			int ram = 0;
			int dungLuong = 0;
			float kichThuoc = 0;
			int maDienThoai = 0;

			DienThoaiService dt = new DienThoaiService();
			try {
				List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên

				// duyệt qua các đối tượng gửi lên từ client gồm file và các control
				for (FileItem fileItem : fileItems) {
					if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
						// xử lý file
						String nameimg = fileItem.getName();
						if (!nameimg.equals("")) {
							if(nameimg != null) {
								anhMoi = "images/" + nameimg;
								System.out.println("Anh moi:" + anhMoi);
							}
							// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
							String dirUrl = request.getServletContext().getRealPath("") + File.separator + "images";
							File dir = new File(dirUrl);
							if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
								dir.mkdir();
							}
							String fileImg = dirUrl + File.separator + nameimg;
							File file = new File(fileImg);// tạo file
							try {
								// kiểm tra xem ảnh đó có tồn tại trong hệ thống ko
								if (!file.exists()) {
									fileItem.write(file);// lưu file
									System.out.println("UPLOAD THÀNH CÔNG...!");
									System.out.println("Đường dẫn lưu file là: " + dirUrl);
								}

							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					} else {// Neu la control
						String tentk = fileItem.getFieldName();
						if (tentk.equals("tenDienThoai"))
							tenDienThoai = fileItem.getString();
						if (tentk.equals("maHang"))
							maHang = fileItem.getString();
						if (tentk.equals("soLuong"))
							soLuong = Integer.parseInt(fileItem.getString());
						if (tentk.equals("gia"))
							gia = Long.parseLong(fileItem.getString());
						if (tentk.equals("ngayNhap"))
							ngayNhap = fileItem.getString();
						if (tentk.equals("ngayNhap"))
							ngayNhap = fileItem.getString();
						if (tentk.equals("ram"))
							ram = Integer.parseInt(fileItem.getString());
						if (tentk.equals("dungLuong"))
							dungLuong = Integer.parseInt(fileItem.getString());
						if (tentk.equals("kichThuoc"))
							kichThuoc = Float.parseFloat(fileItem.getString());
						if (tentk.equals("maDienThoai"))
							maDienThoai = Integer.parseInt(fileItem.getString());
						if (tentk.equals("anh"))
							anhCu = fileItem.getString("UTF-8");
						System.out.println("Anh cu: " + anhCu);

					}
				}
				// thêm sách vào cơ sở dữ liệu
				try {
					System.out.println("lỗi:" + ngayNhap);
					SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd");

					dt.suaDienThoai(tenDienThoai, maHang, soLuong, gia, ff.parse(ngayNhap), anhMoi != null ? anhMoi : anhCu, ram, dungLuong,
							kichThuoc, maDienThoai);
					response.sendRedirect("dienthoai");
				} catch (Exception e) {
					e.printStackTrace();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
