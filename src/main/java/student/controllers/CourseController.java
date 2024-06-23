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

import student.model.Course;
import student.persistance.CourseRepository;




@Controller
public class CourseController {
	@Autowired
	CourseRepository courseRepo;
	
	@RequestMapping("addcourse")
	public String displayAll(ModelMap map) {
		
		List<Course> courses=courseRepo.getAll();
		
		map.addAttribute("courses", courses);
		return "course_re";
	}
//	
//	@GetMapping("/courses")
//	public ModelAndView addCourse() {
//		
//		return new ModelAndView("course_re","course",new Course());
//		
//	}

	@PostMapping("/courses")
	public String addCourse(@ModelAttribute("course")@Validated Course course,BindingResult bResult,ModelMap map) {
//	if(bResult.hasErrors()) {
//		return "course_re";
//		
//		}
//	else {
		int rs=courseRepo.add(course);
		if(rs==0) {
			map.addAttribute("error_msg", "SQL Insert Error : ");
			return "course_re";
		}else {
			return "redirect:/addcourse";
			
		}
	}
	}
//}
