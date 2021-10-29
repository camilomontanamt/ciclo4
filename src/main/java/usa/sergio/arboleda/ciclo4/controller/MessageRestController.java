package usa.sergio.arboleda.ciclo4.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import usa.sergio.arboleda.ciclo4.entity.Message;
import usa.sergio.arboleda.ciclo4.services.MessageServices;

@RestController
@RequestMapping("/api/Message")
public class MessageRestController {

	@Autowired
	private MessageServices messageServices;
	private Message messageUpdate;
	
	@GetMapping("/all")
	public List<Message> index() {
		return messageServices.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Message> show(@PathVariable Integer id) {
		return messageServices.findbyId(id);
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Message create(@RequestBody Message message) {	
		return messageServices.saveMessage(message);
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public Message update(@RequestBody Message message) {
		messageUpdate = null;
		
		if (message.getIdMessage() == null) {
			
			return message;
			
		} else {
			messageUpdate.setIdMessage(message.getIdMessage());
			messageUpdate.setMessageText(message.getMessageText());
			
			return messageServices.saveMessage(messageUpdate);
		}		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		messageServices.deleteMessage(id);
	}

}
