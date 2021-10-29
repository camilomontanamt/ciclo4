package usa.sergio.arboleda.ciclo4.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usa.sergio.arboleda.ciclo4.dao.ICategoryDao;
import usa.sergio.arboleda.ciclo4.entity.Category;

@Service
public class CategoryServices {

	@Autowired
	private ICategoryDao categoryDao;

	public CategoryServices() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	public List<Category> findAll() {
		return (List<Category>) categoryDao.findAll();
	}

	@Transactional
	public Category findbyId(Integer id) {
		return categoryDao.findById(id).orElse(null);
	}

	@Transactional
	public Category saveCategory(Category category) {
		return categoryDao.save(category);			
	}

	@Transactional
	public void deleteCategory(Integer id) {
		categoryDao.deleteById(id);
	}

}
