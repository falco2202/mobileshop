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

import com.giao.bean.Hang;
import com.giao.service.HangService;

/**
 * Servlet implementation class AdminSuaHang
 */
@WebServlet("/admin/suahang")
public class AdminSuaHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSuaHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		if (session.getAttribute("admin") == null) {
			response.sendRedirect("dangnhap");
			return;
		}

		String ma = request.getParameter("ma");
		HangService service = new HangService();
		
		if(ma == null) {
			ArrayList<Hang> ds = null;
			String maHang = request.getParameter("mahang");
			String tenHang = request.getParameter("tenhang");
			try {
				service.capNhap(maHang, tenHang);
				ds = service.getAllHang();
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("hang", ds);
			RequestDispatcher rd = request.getRequestDispatcher("hang.jsp");
			rd.forward(request, response);
			return;
		}
		Hang hang = null;
		try {
			hang = service.getHang(ma);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("s", hang);
		RequestDispatcher rd = request.getRequestDispatcher("suahang.jsp");
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
