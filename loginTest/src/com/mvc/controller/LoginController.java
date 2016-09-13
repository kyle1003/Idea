package com.mvc.controller;

import com.mvc.service.UsersService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	protected final transient Log log = LogFactory
	.getLog(LoginController.class);
	@Autowired
	private UsersService usersService;
	public LoginController(){
		
	}
	
	@RequestMapping("/login.do")
	public String load(HttpServletRequest request,ModelMap modelMap){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean isExist = usersService.isExist(username, password);
		if(isExist){
			modelMap.addAttribute("username", username);
			return "loginsuc";
		}
		return "loginerror";
	}
	
	//jQuery ajax check up/
	@RequestMapping("/check.do")
	public @ResponseBody   String check(  
            @RequestParam(value = "username", required = true) String username, 
            		@RequestParam(value = "password", required = true) String password, 
            				Model model) {  
  
        // 
		boolean isExist = usersService.isExist(username, password);
		String info = new String();
		if(isExist){
			info = "yes";
		}else{
			info = "no";
		}
        return info;  
	}
}