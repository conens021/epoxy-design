package com.abstractmedia.projects.epoxydesign.controller;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abstractmedia.projects.epoxydesign.features.CustomEmail;
import com.abstractmedia.projects.epoxydesign.features.MessageResponse;
import com.abstractmedia.projects.epoxydesign.model.Message;

@RestController
public class MessageController {

	
	@Autowired
	private CustomEmail customEmail;
	@Autowired
	private MessageResponse messageResponse;
	
	@PostMapping(path="send-msg",consumes = "application/json;charset=UTF-8")
	private ResponseEntity<MessageResponse> sendMessage(@RequestBody Message message){
		
		
		if(message.isValid()) {
			
			customEmail.setFrom(message.getEmail());
			customEmail.setFromName(message.getName());
			customEmail.setSubject(message.getSubject());
			customEmail.setMsg(String.format("%s %s",
					message.getMessage(),customEmail.getFrom()));
			
			try {
				customEmail.sendMessage();
			
				messageResponse.setSuccess(true);
				return new ResponseEntity<MessageResponse>(messageResponse,HttpStatus.OK);
			} catch (MessagingException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				messageResponse.setValidation(message.getValidation());
				messageResponse.setSuccess(false);
				
				return new ResponseEntity<MessageResponse>(messageResponse,HttpStatus.BAD_REQUEST);
			}
			
		}
		
		messageResponse.setValidation(message.getValidation());
		messageResponse.setSuccess(false);
	
		return new ResponseEntity<MessageResponse>(messageResponse,HttpStatus.BAD_REQUEST);
		
	}
}
