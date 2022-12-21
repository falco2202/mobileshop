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
import com.giao.service.HangService;

/**
 * Servlet implementation class AdminDienThoai
 */
@WebServlet("/admin/dienthoai")
public class AdminDienThoai extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminDienThoai() {
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
		String del = request.getParameter("xoa");

		DienThoaiService dt = new DienThoaiService();
		ArrayList<DienThoai> ds = null;
		try {

			if (del != null) {
				dt.xoaDienThoai(Integer.parseInt(del));
			}

			ds = dt.getDienThoai();
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("dienthoai", ds);
		RequestDispatcher rd = request.getRequestDispatcher("dienthoai.jsp");
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
