package com.tts.WeatherApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.WeatherApp.Model.Request;
import com.tts.WeatherApp.Model.Response;
import com.tts.WeatherApp.Service.WeatherService;

@Controller
public class WeatherController {
    
	@Autowired
    private WeatherService weatherService;
	
	@GetMapping
	public String getIndex(Model model) {
	    model.addAttribute("request", new Request());  
	    return "index";
	}
	
	@PostMapping
	public String postIndex(Request request, Model model) {
	    Response data = weatherService.getForecast(request.getZipCode());
	    model.addAttribute("data", data);
	    return "index";
	}

}
