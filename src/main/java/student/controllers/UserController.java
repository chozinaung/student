package student.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import student.model.User;
import student.persistance.UserReposistory;

@Controller
public class UserController {
	
	@Autowired
	UserReposistory userRepo;
	@RequestMapping("/usermanagement")
	public String userReg(ModelMap map) {
		List<User> users = userRepo.getAll();
		//System.out.println("authors :" + authors.size());
		map.addAttribute("users", users);
		return "user_reg";
	}
	


	
	
//	@GetMapping("/add")
//	public ModelAndView addStudent( ModelMap map) {
//			return new ModelAndView("add_user","useradd",new User());
//
//	}

	@PostMapping("/add")
	public String displayUser(@ModelAttribute("user")@Validated User user, BindingResult bResult, ModelMap map) {
//		if (bResult.hasErrors()) {
//			return "welcome";
//
//		}
		
		int rs = userRepo.add(user);
		if (rs == 0) {
			System.out.println("username "+user.getEmail());
			map.addAttribute("error_msg", "Database something wrong");
			map.addAttribute("user", user);
			return "welcome";
			

		} else {
			return "add_user";
		}
	}
	@GetMapping("/adduser")
	public ModelAndView addStudent( ModelMap map) {
			return new ModelAndView("update_user","users",new User());

	}

	@PostMapping("/adduser")
	public String updateUser(@ModelAttribute("useradd")@Validated User user, BindingResult bResult, ModelMap map) {
//		if (bResult.hasErrors()) {
//			return "welcome";
//
//		}
		
		int rs = userRepo.add(user);
		if (rs == 0) {
			System.out.println("username "+user.getEmail());
			map.addAttribute("error_msg", "Database something wrong");
			map.addAttribute("user", user);
			return "update_user";
			

		} else {
			return "redirect:/usermanagement";
		}
	}
	
	
}
	

	
	