package usa.sergio.arboleda.ciclo4.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import usa.sergio.arboleda.ciclo4.entity.Reservation;

public interface IReservationDao extends JpaRepository<Reservation, Integer>{

}
