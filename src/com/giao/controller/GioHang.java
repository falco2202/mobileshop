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
import com.giao.service.GioHangService;
import com.giao.service.HangService;

/**
 * Servlet implementation class GioHang
 */
@WebServlet("/giohang")
public class GioHang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GioHang() {
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

		String ma = request.getParameter("ma");
		String ten = request.getParameter("ten");
		String gia = request.getParameter("gia");

		String maXoa = request.getParameter("delete");
		String delete = request.getParameter("deleteAll");

		String update = request.getParameter("update");
		String idAmount = request.getParameter("amount");

		String[] listDel = request.getParameterValues("selected");

		GioHangService gh = null;
		HttpSession session = request.getSession();

		if (session.getAttribute("gio") == null) {
			gh = new GioHangService();
			session.setAttribute("gio", gh);
		}

		gh = (GioHangService) session.getAttribute("gio");

		if (ten != null) {
			long price = Long.parseLong(gia);
			int maCapNhat = Integer.parseInt(ma);
			gh.themVaoGio(maCapNhat, ten, price, (int) 1);
		}

		if (maXoa != null) {
			int maCapNhat = Integer.parseInt(maXoa);
			gh.xoa(maCapNhat);
			if (gh.gio.size() == 0) {
				RequestDispatcher rd = request.getRequestDispatcher("trangchu");
				rd.forward(request, response);
				return;
			}
		}

		if (delete != null) {
			gh.xoaTatCa();
			RequestDispatcher rd = request.getRequestDispatcher("trangchu");
			rd.forward(request, response);
			return;
		}

		if (update != null) {
			int maCapNhat = Integer.parseInt(update);
			gh.suaSoLuong(maCapNhat, Integer.parseInt(idAmount));
			if (Long.parseLong(idAmount) == 0)
				gh.xoa(maCapNhat);
		}

		if (listDel != null) {
			for (String s : listDel) {
				int maCapNhat = Integer.parseInt(s);
				gh.xoa(maCapNhat);
			}
				
			if (gh.gio.size() == 0) {
				RequestDispatcher rd = request.getRequestDispatcher("trangchu");
				rd.forward(request, response);
				return;
			}
		}

		ArrayList<Hang> dsHang = null;
		HangService hang = new HangService();
		try {
			dsHang = hang.getAllHang();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("hang", dsHang);
		request.setAttribute("gio", gh.gio);
		
		RequestDispatcher rd = request.getRequestDispatcher("giohang.jsp");
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
