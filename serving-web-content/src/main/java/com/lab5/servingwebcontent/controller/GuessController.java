package com.lab5.servingwebcontent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.lab5.servingwebcontent.model.*;

@Controller
public class GuessController {
	
	@Autowired 
	GuessModel guess;
	
	@GetMapping("/guess")
	public String showGuess(@RequestParam(name="name", required=false, defaultValue="user")
		String name, Model model) {
		guess.reset();
		guess.setParticipant(name);
		model.addAttribute("name", guess.getParticipant());
		model.addAttribute("try" , guess.getNumTries());
		return "guess";
	}
	
	@PostMapping("/guess")
	public String processGuess(@RequestParam(name = "submitButton", required = false) String submitButton,
            @RequestParam(name = "reset", required = false) String reset,
            @RequestParam String userInput, Model model) {
		String result;
		System.out.println(submitButton+" "+reset);
		if ("submitButton".equals(submitButton)) {
			guess.makeAGuess(Integer.valueOf(userInput));
			model.addAttribute("name", guess.getParticipant());
			
			if (!guess.isWinner()) {
				model.addAttribute("try" , guess.getNumTries());
				result = "guess";
			}
			else {
				model.addAttribute("prize" , guess.getPrize());
				result = "win";
			}
		}
		else {
			guess.reset();
			model.addAttribute("name", guess.getParticipant());
			model.addAttribute("try" , guess.getNumTries());
			result = "guess";
		}
		return result;
	}
}
