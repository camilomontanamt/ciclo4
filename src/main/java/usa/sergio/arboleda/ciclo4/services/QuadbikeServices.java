package usa.sergio.arboleda.ciclo4.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usa.sergio.arboleda.ciclo4.dao.IQuadbikeDao;
import usa.sergio.arboleda.ciclo4.entity.Quadbike;

@Service
public class QuadbikeServices {
	
	@Autowired
	private IQuadbikeDao quadbikeDao;

	public QuadbikeServices() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	public List<Quadbike> findAll() {
		return (List<Quadbike>) quadbikeDao.findAll();
	}
	
	@Transactional
	public Quadbike findbyId(Integer id) {
		return quadbikeDao.findById(id).orElse(null);
	}
	
	@Transactional
	public Quadbike saveQuadbike(Quadbike quadbike) {
		return quadbikeDao.save(quadbike);			
	}
	
	@Transactional
	public void deleteQuadbike(Integer id) {
		quadbikeDao.deleteById(id);
	}
}
