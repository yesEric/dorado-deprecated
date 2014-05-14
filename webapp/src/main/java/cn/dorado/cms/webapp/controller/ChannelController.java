package cn.dorado.cms.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChannelController {

	@RequestMapping("/channels")
	public ModelAndView channels(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("channel/list");
		return modelAndView;
	}
}
