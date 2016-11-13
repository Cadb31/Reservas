package com.home.reservas.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.home.reservas.model.Reserva;
import com.home.reservas.repository.ReservasDao;
import com.home.reservas.service.ReservasService;

@Service("reservasService")
public class ReservasServiceImpl implements ReservasService {

	ReservasDao reservasDao;
	public void setReservasDao(ReservasDao reservasDao)
	{
		this.reservasDao = reservasDao;
	}
	
	@Override
	@Transactional
	public List<Reserva> getMisReservas(String usuario) {
		return reservasDao.getMisReservas(usuario);
	}

	@Override
	@Transactional
	public boolean insertReserva(Reserva reserva) {	
		return reservasDao.insertReserva(reserva);
	}

	@Override
	@Transactional
	public boolean updateReserva(Reserva reserva) {		
		return reservasDao.updateReserva(reserva);
	}

	@Override
	@Transactional
	public Reserva getReservaById(int reservaId) {
		return reservasDao.getReservaById(reservaId);
	}

	@Override
	@Transactional
	public boolean deleteReserva(Reserva reserva) {		
		return reservasDao.deleteReserva(reserva);
	}

	@Override
	@Transactional
	public int countReserva() {
		return reservasDao.countReserva();
	}

}
