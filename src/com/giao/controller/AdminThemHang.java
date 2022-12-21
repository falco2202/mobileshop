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
 * Servlet implementation class AdminThemHang
 */
@WebServlet("/admin/themhang")
public class AdminThemHang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminThemHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		if (session.getAttribute("admin") == null) {
			response.sendRedirect("dangnhap");
			return;
		}

		String xacnhan = request.getParameter("xacnhan");

		if (xacnhan != null) {
			String ma = request.getParameter("ma");
			String ten = request.getParameter("ten");

			HangService service = new HangService();
			ArrayList<Hang> hang = null;
			try {
				service.addHang(ma, ten);
				hang = service.getAllHang();
			} catch (Exception e) {
				System.out.println("Sia r");
				request.setAttribute("noti", (int)1);
			}
			request.setAttribute("hang", hang);
			response.sendRedirect("hang");
			return;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("themhang.jsp");
		rd.forward(request, response);
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
