package com.giao.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.giao.bean.KhachHang;
import com.giao.service.KhachHangService;
import com.giao.util.MaHoa;

import nl.captcha.Captcha;

/**
 * Servlet implementation class DangNhap
 */
@WebServlet("/dangnhap")
public class DangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangNhap() {
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

		String taiKhoan = request.getParameter("username");
		String matKhau = request.getParameter("password");

		KhachHangService service = new KhachHangService();
		KhachHang kh = null;
		HttpSession session = request.getSession();
		if(session.getAttribute("log") == null) {
			session.setAttribute("log", 0);
		}
		int check = (int)session.getAttribute("log");
		if(check >= 3) {
			Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
			String answer = request.getParameter("answer");
			if (answer == null) {
				request.setAttribute("login", check);
				RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
				rd.forward(request, response);
				return;
			}
			else if (!captcha.isCorrect(answer)) {
				request.setAttribute("login", check);
				request.setAttribute("capcha", "sai");
				RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
				rd.forward(request, response);;
				return;
			}
		}
		if(request.getParameter("dangnhap") != null) {
			try {
				kh = service.dangNhap(taiKhoan, MaHoa.ecrypt(matKhau));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("capcha", null);
		if(taiKhoan == null) {
			request.setAttribute("login", check);
			RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
			rd.forward(request, response);
			return;
		}

		if (kh == null) {
			request.setAttribute("sai", 1);
			session.setAttribute("log", (int)session.getAttribute("log") + 1);
			request.setAttribute("login", check);
			RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
			rd.forward(request, response);
			return;
		} else {
			session.setAttribute("user", kh);
			response.sendRedirect("trangchu");
			return;
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
