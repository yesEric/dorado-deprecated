package cn.dorado.cms.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.dorado.cms.application.channel.ChannelApplication;
import cn.dorado.cms.application.channel.ChannelDto;
import cn.dorado.cms.domain.model.channel.Channel;

@Controller
@RequestMapping(value = "/channel")
public class ChannelController {

	@Autowired
	ChannelApplication channelApplication;

	/**
	 * 列出所有Channel列表的方法
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView channels() {
		ModelAndView modelAndView = new ModelAndView();
		List<Channel> channels = channelApplication.allChannels();
		modelAndView.addObject("channels", channels);
		modelAndView.setViewName("channel/list");
		return modelAndView;
	}

	@RequestMapping("/form")
	public ModelAndView channelOfId(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		String channelId = request.getParameter("id");
		ChannelDto channelDto = new ChannelDto();
		if (StringUtils.isNotBlank(channelId)) {
			channelApplication.channelOfId(channelId);
		}
		modelAndView.addObject("channel", channelDto);
		modelAndView.setViewName("channel/form");
		return modelAndView;
	}

}
