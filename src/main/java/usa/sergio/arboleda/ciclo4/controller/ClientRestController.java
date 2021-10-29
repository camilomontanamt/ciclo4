package usa.sergio.arboleda.ciclo4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import usa.sergio.arboleda.ciclo4.entity.Client;
import usa.sergio.arboleda.ciclo4.services.ClientServices;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClientRestController {
	
	@Autowired
	private ClientServices clientServices;

	@GetMapping("/all")
	public List<Client> index() {
		return clientServices.findAll();
	}
	
	@GetMapping("/{id}")
	public Client show(@PathVariable Integer id) {
		return clientServices.findbyId(id);
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Client create(@RequestBody Client client) {	
		return clientServices.saveClient(client);
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public Client update(@RequestBody Client client) {
		Client updateClient = clientServices.findbyId(client.getIdClient());
		
		if (client.getIdClient() == null) {
			return client;	
		} else {
			updateClient.setIdClient(client.getIdClient());
			updateClient.setEmail(client.getEmail());
			updateClient.setPassword(client.getPassword());
			updateClient.setName(client.getName());
			updateClient.setAge(client.getAge());
			
			return clientServices.saveClient(updateClient);
		}		
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		clientServices.deleteClient(id);
	}
}
