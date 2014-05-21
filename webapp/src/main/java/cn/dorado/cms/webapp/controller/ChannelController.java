package cn.dorado.cms.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.dorado.cms.application.channel.ChannelApplication;
import cn.dorado.cms.domain.model.channel.Channel;

@Controller
@RequestMapping(value="/channel")
public class ChannelController {
	
	@Autowired
	ChannelApplication channelApplication;

	@RequestMapping(value="/list")
	public ModelAndView channels(){
		ModelAndView modelAndView = new ModelAndView();
		List<Channel> channels=channelApplication.allChannels();
		modelAndView.addObject("channels",channels);
		modelAndView.setViewName("channel/list");
		return modelAndView;
	}
	
}
