package com.baizhi.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/captcha")
public class CaptchaController {

	@Autowired
	private HttpSession session;
	
	/**
	 * ���������֤��
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/safeCode")
	public void safeCode(HttpServletResponse response) throws IOException{
		
		LineCaptcha captcha = CaptchaUtil.createLineCaptcha(80, 40, 4, 10);
		captcha.createCode();
		String code = captcha.getCode();
		session.setAttribute("realCode", code);
		System.out.println(code);
		ServletOutputStream stream = response.getOutputStream();
		captcha.write(stream);
	}
}
