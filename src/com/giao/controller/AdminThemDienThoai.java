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
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.giao.bean.Hang;
import com.giao.service.DienThoaiService;
import com.giao.service.HangService;

/**
 * Servlet implementation class AdminThemDienThoai
 */
@WebServlet("/admin/themdienthoai")
public class AdminThemDienThoai extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminThemDienThoai() {
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
		RequestDispatcher rd;

		HangService hang = new HangService();
		String them = request.getParameter("them");
		System.out.println(them);
		if (request.getParameter("them") == null) {
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "images";
			System.out.println("dir: " + dirUrl1);

			String tenDienThoai = null;
			String maHang = null;
			int soLuong = 0;
			long gia = 0;
			String ngayNhap = null;
			String anh = null;
			int ram = 0;
			int dungLuong = 0;
			float kichThuoc = 0;

			DienThoaiService dt = new DienThoaiService();
			try {
				List<FileItem> fileItems = upload.parseRequest(request);// L???y v??? c??c ?????i t?????ng g???i l??n

				// duy???t qua c??c ?????i t?????ng g???i l??n t??? client g???m file v?? c??c control
				for (FileItem fileItem : fileItems) {
					if (!fileItem.isFormField()) {// N???u ko ph???i c??c control=>upfile l??n
						// x??? l?? file
						String nameimg = fileItem.getName();
						anh = "images/" + nameimg;
						if (!nameimg.equals("")) {
							// L???y ???????ng d???n hi???n t???i, ch??? ?? x??? l?? tr??n dirUrl ????? c?? ???????ng d???n ????ng
							String dirUrl = request.getServletContext().getRealPath("") + File.separator + "images";
							File dir = new File(dirUrl);
							if (!dir.exists()) {// n???u ko c?? th?? m???c th?? t???o ra
								dir.mkdir();
							}
							String fileImg = dirUrl + File.separator + nameimg;
							File file = new File(fileImg);// t???o file
							try {
								// ki???m tra xem ???nh ???? c?? t???n t???i trong h??? th???ng ko
								if (!file.exists()) {
									fileItem.write(file);// l??u file
									System.out.println("UPLOAD TH??NH C??NG...!");
									System.out.println("???????ng d???n l??u file l??: " + dirUrl);
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
						
					}
				}
				// th??m s??ch v??o c?? s??? d??? li???u
				try {
					System.out.println("l???i:" + ngayNhap);
					SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd");
					
					dt.themDienThoai(tenDienThoai, maHang, soLuong, gia, ff.parse(ngayNhap), anh, ram, dungLuong, kichThuoc);
					response.sendRedirect("dienthoai");
				} catch (Exception e) {
					e.printStackTrace();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				request.setAttribute("hang", hang.getAllHang());
				rd = request.getRequestDispatcher("themdienthoai.jsp");
				rd.forward(request, response);
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
