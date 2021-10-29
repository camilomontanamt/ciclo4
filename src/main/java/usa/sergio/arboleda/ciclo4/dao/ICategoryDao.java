package usa.sergio.arboleda.ciclo4.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import usa.sergio.arboleda.ciclo4.entity.Category;

public interface ICategoryDao extends JpaRepository<Category, Integer>{

}
