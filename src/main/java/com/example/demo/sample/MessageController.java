package com.example.demo.sample;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);
	
	private MessageRepository messageRepository;
	
	public MessageController(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@PostMapping("/message")
	public MessageEntity postMessage(MessageDto message) {
		LOGGER.debug("message post request : {}", message);

		return messageRepository.save(message.toEntity());
	}
	
	@PostMapping("/jsonMessage")
	public MessageEntity postJsonMessage(@RequestBody MessageDto message) {
		LOGGER.debug("message post request : {}", message);

		return messageRepository.save(message.toEntity());
	}
	
	@GetMapping("/message")
	public List<MessageEntity> getMessageList() {
		return messageRepository.findAll();
	}
}
