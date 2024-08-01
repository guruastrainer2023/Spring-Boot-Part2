package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

	@Autowired
	KafkaTemplate<String, String> template;
	
	private static final String TOPIC = "Hello-Kafka";
	 
  
    @GetMapping("/publish/{message}")
    public String publishMessage(@PathVariable("message")
                                 final String message)
    {
 
        // Sending the message
    	template.send(TOPIC, message);
 
        return "Published Successfully";
    }
	
}
