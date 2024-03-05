package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;

import ch.qos.logback.core.model.Model;

@Controller
public class PhonebookController {
	
	@Autowired
	private PhonebookService phonebookService;
	
	//등록폼
	@RequestMapping(value="/writeform", method= {RequestMethod.GET,RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhonebookController.writeForm()");
		
		return "writeForm";
	}
	
	//등록
	@RequestMapping(value="/write", method= {RequestMethod.GET,RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.write()");
		
		phonebookService.exeWrite(personVo);
		return "redirect:/list"; //리다이렉트
	}
	//리스트
	@RequestMapping(value="/list", method= {RequestMethod.GET,RequestMethod.POST})
	public String list(@ModelAttribute Model model) {
		System.out.println("PhonebookController.list()");
		
		phonebookService.exeList();
		
		return "";
	}
	
}
