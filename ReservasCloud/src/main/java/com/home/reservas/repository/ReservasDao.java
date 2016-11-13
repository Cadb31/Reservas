package com.home.reservas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.home.reservas.model.Reserva;

@Repository
public interface ReservasDao {

	public boolean insertReserva(Reserva reserva);
	public List<Reserva> getMisReservas(String usuario);
	public boolean updateReserva(Reserva reserva);
	public Reserva getReservaById(int reservaId);	
	public boolean deleteReserva(Reserva reserva);
	public int countReserva();
		
}
