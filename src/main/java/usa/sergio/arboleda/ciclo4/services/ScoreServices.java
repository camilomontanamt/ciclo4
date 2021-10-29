package usa.sergio.arboleda.ciclo4.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usa.sergio.arboleda.ciclo4.dao.IScoreDao;
import usa.sergio.arboleda.ciclo4.entity.Score;

@Service
public class ScoreServices {

	@Autowired
	private IScoreDao scoreDao;
	
	public ScoreServices() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	public List<Score> findAll() {
		return (List<Score>) scoreDao.findAll();
	}
	
	@Transactional
	public Optional<Score> findbyId(Integer id) {
		return scoreDao.findById(id);
	}
	
	@Transactional
	public Score saveScore(Score score) {
		if (score.getId() == null) {
			return scoreDao.save(score);			
		} else {
			Optional<Score> paux = findbyId(score.getId());
			if (paux.isEmpty()) {
				return scoreDao.save(score);
			} else {
				return score;
			}
		}
	}

	@Transactional
	public void deleteScore(Integer id) {
		scoreDao.deleteById(id);
	}

}
