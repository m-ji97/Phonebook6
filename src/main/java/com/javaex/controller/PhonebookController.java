package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;


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
	public String list(Model model) {
		System.out.println("PhonebookController.list()");
		
		List<PersonVo> personList = phonebookService.exeList();
		
		model.addAttribute("pList", personList);
		
		return "list";
	}
	//삭제
	@RequestMapping(value="/delete", method= {RequestMethod.GET,RequestMethod.POST})
	public String delete(@RequestParam("no") int no) {
		System.out.println("PhonebookController.delete()");
		
		phonebookService.exeDelete(no);
		
		return "redirect:/list";
	}
	//수정폼
	@RequestMapping(value="/mForm", method= {RequestMethod.GET,RequestMethod.POST})
	public String mform(@RequestParam(value="no") int no, Model model) {
		System.out.println("PhonebookController.mform");
		
		PersonVo personVo = phonebookService.exeMform(no);
		
		model.addAttribute("perVo", personVo);
		
		return "/modifyForm";
	}
	//수정
	@RequestMapping(value="/modify", method= {RequestMethod.GET,RequestMethod.POST})
	public String modify(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.modify");
		
		phonebookService.exeModify(personVo);
		
		return "redirect:/list";
	}
	
	
}
