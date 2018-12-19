package com.example.demo.sample;

/**
 * Entity의 역할을 줄이기 위한
 * 값만을 갖는 Message DTO class
 * @see MessageEntity
 */
public class MessageDto {
	private Long id;
	private String name;
	private String message;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public MessageEntity toEntity() {
		return new MessageEntity
				.Builder()
				.id(id)
				.name(name)
				.message(message)
				.build();
	}
	
	@Override
	public String toString() {
		return "MessageDto [id=" + id + ", name=" + name + ", message=" + message + "]";
	}
	
}
