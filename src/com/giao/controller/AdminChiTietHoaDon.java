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

import com.giao.bean.ChiTiet;
import com.giao.service.HoaDonService;

/**
 * Servlet implementation class AdminChiTietHoaDon
 */
@WebServlet("/admin/chitietdonhang")
public class AdminChiTietHoaDon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChiTietHoaDon() {
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
		String xacnhan = request.getParameter("xacnhan");
		
		HoaDonService hd = new HoaDonService();
		ArrayList<ChiTiet> ds = null;
		
		try {		
			if(xacnhan != null) {
				response.sendRedirect("donhang?xacnhan=" + xacnhan);
				return;
			} else {
				ds = hd.getChiTiet(Integer.parseInt(ma));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("chitiet", ds);
		request.setAttribute("hoadon", ma);
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
