package org.spring.mvc.rest.services;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/testapi")
public class TestController {
	
	@ResponseBody
	@RequestMapping(value="/ping", method=RequestMethod.GET)
	public String test(){
		return "pong";
	}
}
