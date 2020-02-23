
package com.neo.controller;

import javax.servlet.http.HttpSession;

import com.neo.model.DropDown;
import com.neo.model.HourlyForecast;
import com.neo.repository.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MessageController {
	@Autowired
	private WeatherDataService weatherDataService;
	@Autowired
	private DropDown dataConfig;

	@GetMapping
	public ModelAndView init(HttpSession session) {
		session.setAttribute("cityList", dataConfig.getCitys());
		return new ModelAndView("messages/list");
	}

	@GetMapping(value = "/list")
	public String list(String  cityName, Model model) {
		if (StringUtils.isEmpty(cityName)) {
			model.addAttribute("data", new HourlyForecast());
			return "messages/list::displayPage";
		}
		HourlyForecast data = weatherDataService.getDataByCityName(cityName);
		model.addAttribute("data", data);
		return "messages/list::displayPage";
	}
}
