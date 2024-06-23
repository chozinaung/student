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

import student.model.Student;
import student.persistance.StudentReposistory;


@Controller
public class StudentController {
	@Autowired
StudentReposistory studentRepo;

	@RequestMapping("add_student")
	public String diaplayAll(ModelMap map) {
		List<Student> students = studentRepo.getAll();
		//System.out.println("authors :" + authors.size());
		map.addAttribute("students", students);
		return "student_reg";
	}
//
//	@GetMapping("studentreg")
//	public ModelAndView addAuthor() {
//		return new ModelAndView("add_author", "author", new Author());
//
//	}

	@PostMapping("/addstudent")
	public String addStudent(@ModelAttribute("student") @Validated Student student, BindingResult bResult, ModelMap map) {
//		if (bResult.hasErrors()) {
//			return "student_reg";
//
//		}
		int rs = studentRepo.add(student);
		if (rs == 0) {
			map.addAttribute("error_msg", "Database something wrong");
			return "student_reg";

		} else {
			return "search_student";
		}
	}
	
	@GetMapping("/searchstudent")
	public ModelAndView searchStudent() {
		return new ModelAndView("search_student", "search", new Student());

	}
	
	@PostMapping("/searchstudent")
	public String searchStudent(@ModelAttribute("search") @Validated Student student, BindingResult bResult, ModelMap map) {
		int rs = studentRepo.add(student);
		if (rs == 0) {
			map.addAttribute("error_msg", "Database something wrong");
			return "search_student";

		} else {
			return "redirect:/add_student";
		}
	}
}
