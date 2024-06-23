package student.controllers;


import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import student.model.*;

import student.persistance.UserReposistory;



@Controller
public class LoginController {
  	@RequestMapping("/")
  	public ModelAndView index() {
		return new ModelAndView("index","loginbean",new Login());
	}
		

		
		@PostMapping("login")
		public String checkLogin(@ModelAttribute("loginbean")Login login,ModelMap map) {
			UserReposistory userRepo = new UserReposistory();
			
			User user=userRepo.getByLogin(login);
			map.addAttribute("user",user);
			
			LocalDate currentDate = LocalDate.now();
	        map.addAttribute("currentDate", currentDate);
	        
			if(user!=null && user.getUsername() != null) {
//			HttpSession session = HttpRequest.get;
//			session.setAttribute("userId", user.getId());
				return "welcome";
			}else{
				return "redirect:/";
			}
			}
		
		@GetMapping("logout")
	  	public String Logout(){
			return "welcome";
		}
		
			

	}


