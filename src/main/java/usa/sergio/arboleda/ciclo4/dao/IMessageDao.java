package usa.sergio.arboleda.ciclo4.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import usa.sergio.arboleda.ciclo4.entity.Message;

public interface IMessageDao extends JpaRepository<Message, Integer>{

}
