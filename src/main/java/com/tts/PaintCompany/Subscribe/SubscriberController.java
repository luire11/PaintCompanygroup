package com.tts.PaintCompany.Subscribe;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class SubscriberController { 
	
	@Autowired
	private SubscriberRepository subscriberRepository;
	
	@Autowired
	private AmazonSESSample sendEmail;
	
	
	@GetMapping (value= "/")
	public String index(Subscriber subscriber) {
		return "index";
	}
	
//	@RequestMapping(value = "/thankyou", method = RequestMethod.GET) 
//	public String sendEmail(Subscriber subscriber) throws Exception {
//		sendEmail.sendEmail();
//	    return "index.html"; 
//	}
// 
	
			
			@PostMapping (value = "/")

			public String addNewSubscriber(Subscriber subscriber, Model model) throws Exception {
					subscriberRepository.save(new Subscriber(subscriber.getEmail(), subscriber.getSignedUp()));
					model.addAttribute("email", subscriber.getEmail());
					sendEmail.sendEmail(subscriber);
					return "index";
			}
}
