package com.example.demo.sample;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 클라이언트로부터 Message를 받아 처리하는 Controller
 */
@RestController
public class MessageController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);
	
	private MessageRepository messageRepository;
	
	public MessageController(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	/**
	 * Message를 받아 DB에 등록
	 * @param message
	 * @return
	 */
	@PostMapping("/message")
	public MessageEntity postMessage(MessageDto message) {
		LOGGER.debug("message post request : {}", message);

		return messageRepository.save(message.toEntity());
	}
	
	/**
	 * Content-type: application/json의 Message를 받아 DB에 등록
	 * @param message
	 * @return
	 */
	@PostMapping("/jsonMessage")
	public MessageEntity postJsonMessage(@RequestBody MessageDto message) {
		LOGGER.debug("message post request : {}", message);

		return messageRepository.save(message.toEntity());
	}
	
	/**
	 * DB에 저장된 Message 리스트를 리턴
	 * @return
	 */
	@GetMapping("/message")
	public List<MessageEntity> getMessageList() {
		return messageRepository.findAll();
	}
}
