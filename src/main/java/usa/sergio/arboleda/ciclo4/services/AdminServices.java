package usa.sergio.arboleda.ciclo4.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usa.sergio.arboleda.ciclo4.dao.IAdminDao;
import usa.sergio.arboleda.ciclo4.entity.Admin;

@Service
public class AdminServices {

	@Autowired
	private IAdminDao adminDao;
	
	public AdminServices() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	public List<Admin> findAll() {
		return (List<Admin>) adminDao.findAll();
	}
	
	@Transactional
	public Optional<Admin> findbyId(Integer id) {
		return adminDao.findById(id);
	}
	
	@Transactional
	public Admin saveAdmin(Admin admin) {
		if (admin.getId() == null) {
			return adminDao.save(admin);			
		} else {
			Optional<Admin> paux = findbyId(admin.getId());
			if (paux.isEmpty()) {
				return adminDao.save(admin);
			} else {
				return admin;
			}
		}
	}

	@Transactional
	public void deleteAdmin(Integer id) {
		adminDao.deleteById(id);
	}

}
