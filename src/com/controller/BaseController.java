package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.exception.UserLoginNoException;
@Controller
public class BaseController {
	/**
	 * ǰ̨�û���¼Ȩ�޿��ƣ�������ִ��ǰִ�и÷���
	 * @throws UserLoginNoException 
	 */
	@ModelAttribute  
    public void isLogin(HttpSession session, HttpServletRequest request) throws UserLoginNoException {      
       if(session.getAttribute("auser") == null){  
            throw new UserLoginNoException("û�е�¼");
       }  
    } 
}  
