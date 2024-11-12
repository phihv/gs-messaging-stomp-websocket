package com.example.messagingstompwebsocket;

import com.example.messagingstompwebsocket.service.GreetingService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
	private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @MessageMapping("/hello")
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay
		greetingService.sendGreeting("/topic/greetings", message.getName());
        return null;
    }

	@MessageMapping("/hi")
	@SendTo("/topic/listen")
	public Greeting listen(HelloMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay
		return new Greeting("Hí hí, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}

}
