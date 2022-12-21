package com.giao.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.giao.bean.DienThoai;
import com.giao.bean.Hang;
import com.giao.service.DienThoaiService;
import com.giao.service.GioHangService;
import com.giao.service.HangService;

/**
 * Servlet implementation class ChiTietSanPham
 */
@WebServlet("/chitiet")
public class ChiTietSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String ma = request.getParameter("ma");
		HangService hang = new HangService();
		DienThoai dt = null;
		ArrayList<Hang> ds = null;
		DienThoaiService ser = new DienThoaiService();
		try {
			ds = hang.getAllHang();
			dt = ser.getDienThoai(Integer.parseInt(ma));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();

		GioHangService gh = null;
		gh = (GioHangService) session.getAttribute("gio");
		if(gh == null) {
			request.setAttribute("gio", gh);
		} else {
			request.setAttribute("gio", gh.gio);
		}
		
		request.setAttribute("dt", dt);
		request.setAttribute("hang", ds);
		RequestDispatcher rd = request.getRequestDispatcher("chitiet.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
