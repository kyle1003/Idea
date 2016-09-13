package com.mvc.controller;

import com.mvc.entity.Users;
import com.mvc.service.UsersService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SignupController {
	protected final transient Log log = LogFactory
	.getLog(SignupController.class);
	@Autowired
	private UsersService usersService;
	public SignupController(){
		
	}
	
	@RequestMapping("/signup.do")
	public String load(HttpServletRequest request,ModelMap modelMap){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("user")!=null && session.getAttribute("user").equals(username)){//防止多次刷新重复提交
			return "signupsuc";
		}else{
			Users u = new Users();
			u.setEmail(email);
			u.setPassword(password);
			u.setUser(username);
			usersService.save(u);
			session.setAttribute("user", username);
		}
		return "signupsuc";
	}
}