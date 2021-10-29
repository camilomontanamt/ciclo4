package usa.sergio.arboleda.ciclo4.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usa.sergio.arboleda.ciclo4.dao.IClientDao;
import usa.sergio.arboleda.ciclo4.entity.Client;

@Service
public class ClientServices {

	@Autowired
	private IClientDao clientDao;
	
	public ClientServices() {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public List<Client> findAll() {
		return (List<Client>) clientDao.findAll();
	}

	@Transactional
	public Client findbyId(Integer idClient) {
		return clientDao.findById(idClient).orElse(null);
	}

	@Transactional
	public Client saveClient(Client client) {
		return clientDao.save(client);			
	}

	@Transactional
	public void deleteClient(Integer idClient) {
		clientDao.deleteById(idClient);
	}
	
}
