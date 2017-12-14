package edu.karazin.shop.web;

import edu.karazin.shop.model.Role;
import edu.karazin.shop.model.User;
import edu.karazin.shop.service.UserService;
import edu.karazin.shop.web.form.UserForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {

	private final UserService userService;
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String userCreate(Model model) {
		log.info("User form");
		model.addAttribute("userForm", new UserForm());
		model.addAttribute("roles", Role.values());
		return "user";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addUser(Model model, @ModelAttribute("userForm") UserForm form) {
		User user = form.convertToUser();
		log.info("Add user " + user);
		userService.createUser(user);
		return "forward:/login";
	}
}