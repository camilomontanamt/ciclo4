package usa.sergio.arboleda.ciclo4.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import usa.sergio.arboleda.ciclo4.entity.Score;

public interface IScoreDao extends JpaRepository<Score, Integer>{

}
