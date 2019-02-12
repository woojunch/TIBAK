package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConHallRegisterController {
	
	@RequestMapping(value="/conhall/register", method=RequestMethod.GET)
	public String ConHallRegister() {
		return "conhall/conhall_register";
	}
}
