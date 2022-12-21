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
 * Servlet implementation class TrangChu
 */
@WebServlet("/trangchu")
public class TrangChu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrangChu() {
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
    	
    	String h = request.getParameter("hang");
        String key = request.getParameter("key");
    	
    	HangService hang = new HangService();
    	DienThoaiService dt = new DienThoaiService();
    	ArrayList<Hang> dsHang = null;
    	ArrayList<DienThoai> dsDienThoai = null;
    	try {
    		dsHang = hang.getAllHang();
    		dsDienThoai = dt.getDienThoai();
    		if(h != null) {
    			dsDienThoai = dt.getHang(h);
    		}
    		if(key != null) {
    			dsDienThoai = dt.tim(key);
    		}
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
    	
    	request.setAttribute("hang", dsHang);
    	request.setAttribute("dienthoai", dsDienThoai);
    	
        RequestDispatcher rd = request.getRequestDispatcher("trangchu.jsp");
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
