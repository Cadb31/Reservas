package com.home.reservas.service;

import java.util.List;
import com.home.reservas.model.Reserva;

public interface ReservasService {

	public boolean insertReserva(Reserva reserva);
	public List<Reserva> getMisReservas(String usuario);
	public boolean updateReserva(Reserva reserva);
	public Reserva getReservaById(int reservaId);	
	public boolean deleteReserva(Reserva reserva);
	public int countReserva();
	
}
