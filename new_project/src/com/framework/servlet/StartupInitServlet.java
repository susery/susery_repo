package com.framework.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

public class StartupInitServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public StartupInitServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		
		super.init();
	}
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		initBasePath(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		initBasePath(request, response);
	}
	/**
	 * 初始化项目url
	 * @param request
	 * @param response
	 */
	private void initBasePath(HttpServletRequest request, HttpServletResponse response){
		ServletContext application = this.getServletContext();
		
		String path = application.getContextPath();
		String basePath = "";
		if(StringUtils.isNotBlank(path)){
			basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			System.out.println(request.getScheme());
			System.out.println(request.getServerName());
			System.out.println(request.getServerPort());
			System.out.println(path);
			System.out.println("--系统url--"+basePath);
			if(StringUtils.isNotBlank(basePath)){
				application.setAttribute("basePath", basePath);
			}
		}
		System.out.println(application.getServerInfo());
		String x = application.getServletContextName();
		System.out.println("x====="+x);
		String temp = application.getContextPath();
		System.out.println("temp----"+temp);
	}

}
