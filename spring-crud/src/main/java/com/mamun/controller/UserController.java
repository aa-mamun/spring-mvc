package com.mamun.controller;


import com.mamun.model.User;
import com.mamun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/")
	public ModelAndView index(Model model) {
		model.addAttribute("user" , new User());
		List<User> userList = userService.getAllUser();
		model.addAttribute("userList", userList);
		return new ModelAndView("user");
	}

	@RequestMapping(value = "/user")
	public ModelAndView indexPage(Model model) {
		model.addAttribute("user" , new User());
		List<User> userList = userService.getAllUser();
		model.addAttribute("userList", userList);
		return new ModelAndView("user");
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)	
	public String saveUser(  User user, BindingResult bindingResult,
			 ModelMap model, HttpServletRequest request) {

		String type = request.getParameter("update") != null ? request.getParameter("update") : "";
		String delete = request.getParameter("delete") != null ? request.getParameter("delete") : "";
		if (type.equalsIgnoreCase("update") || delete.equalsIgnoreCase("delete")) {
			User userDb = userService.getUserById(user.getUserId());
			user.setUserId(userDb.getUserId());
		}
		if (bindingResult.hasErrors()) {
			System.out.println("=====================error======================" + bindingResult.getFieldErrors());
			return "user";
		}
		if (delete.equalsIgnoreCase("delete")) {
			userService.deleteUser(user.getUserId());
		} else {
			userService.saveUser(user);
		}
		model.clear();
		return "redirect:/user";
	}

	  @RequestMapping(value = "/viewUser")
	    public ModelAndView userModify(@ModelAttribute("userId")User user, Model model){
	    	User userDb = userService.getUserById(user.getUserId());
	        model.addAttribute("user" , userDb);
	        List<User> userList = userService.getAllUser();
	        model.addAttribute("userList", userList);
	        return new ModelAndView("user");
	    }


}
