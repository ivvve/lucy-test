package com.example.demo.sample;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Message Repository class
 */
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

}
