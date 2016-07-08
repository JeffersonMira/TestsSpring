package jeff.study.tests.TestesSpring.MVC.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView helloWorld(){
		ModelAndView result = new ModelAndView("world");
		result.addObject("date", new Date());
		
		return result;
	}
}
