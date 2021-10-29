package usa.sergio.arboleda.ciclo4.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usa.sergio.arboleda.ciclo4.dao.IReservationDao;
import usa.sergio.arboleda.ciclo4.entity.Reservation;

@Service
public class ReservationServices {
	
	@Autowired
	private IReservationDao reservationDao;

	public ReservationServices() {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public List<Reservation> findAll() {
		return (List<Reservation>) reservationDao.findAll();
	}

	@Transactional
	public Optional<Reservation> findbyId(Integer idReservation) {
		return reservationDao.findById(idReservation);
	}

	@Transactional
	public Reservation saveReservation(Reservation reservation) {
		if (reservation.getIdReservation() == null) {
			return reservationDao.save(reservation);		
		} else {
			Optional<Reservation> paux = findbyId(reservation.getIdReservation());
			if (paux.isEmpty()) {
				return reservationDao.save(reservation);
			} else {
				return reservation;
			}
		}
	}

	@Transactional
	public void deleteReservation(Integer idReservation) {
		reservationDao.deleteById(idReservation);
	}

}
