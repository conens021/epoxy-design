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
		
		System.out.println(message);
		if(message.isValid()) {
			
			customEmail.setFrom(message.getEmail());
			customEmail.setFromName(message.getName());
			customEmail.setSubject(message.getSubject());
			customEmail.setMsg(message.getMessage());
			
			try {
				customEmail.sendMessage();
				System.out.println("Msg sent");
				messageResponse.setSuccess(true);
				return new ResponseEntity<MessageResponse>(messageResponse,HttpStatus.OK);
			} catch (MessagingException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				messageResponse.setValidation(message.getValidation());
				messageResponse.setSuccess(false);
				System.out.println("Msg not sent");
				return new ResponseEntity<MessageResponse>(messageResponse,HttpStatus.BAD_REQUEST);
			}
			
		}
		
		messageResponse.setValidation(message.getValidation());
		messageResponse.setSuccess(false);
		System.out.println("Msg not sent");
		return new ResponseEntity<MessageResponse>(messageResponse,HttpStatus.BAD_REQUEST);
		
	}
}
