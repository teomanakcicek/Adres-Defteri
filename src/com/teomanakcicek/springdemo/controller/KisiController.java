package com.teomanakcicek.springdemo.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.teomanakcicek.springdemo.entity.Kisi;
import com.teomanakcicek.springdemo.service.KisiService;

@Controller
@RequestMapping("/kisi")
public class KisiController {
	
	@Autowired
	private KisiService kisiService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor= new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
	}
	
	@RequestMapping("/kisilerList")
	public String kisilerList(Model theModel) {
		
		List<Kisi> kisiler=kisiService.getKisiler();
		
		theModel.addAttribute("kisiler",kisiler);
		return "kisiler-list";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Kisi kisi=new Kisi();
		
		theModel.addAttribute("kisi",kisi);
		
		return "kisiler-form";
	}
	
	@RequestMapping("/kisiSakla")
	public String kisiSakla(@Valid@ModelAttribute("kisi")Kisi kisi,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "kisiler-form";
		}else {
			kisiService.saveKisi(kisi);
			
			return "redirect:/kisi/kisilerList";
		}
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("kisiId")int theId,Model theModel) {
		
		Kisi kisi=kisiService.getKisi(theId);
		
		theModel.addAttribute("kisi",kisi);
		
		return "kisiler-form";
	}
	
	@RequestMapping("/delete")
	public String deleteKisi(@RequestParam("kisiId")int theId) {
		
		kisiService.deleteKisi(theId);
		
		return "redirect:/kisi/kisilerList";
	}
	
}

