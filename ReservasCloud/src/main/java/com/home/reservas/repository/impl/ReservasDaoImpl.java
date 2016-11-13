package com.home.reservas.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.home.reservas.model.Reserva;
import com.home.reservas.repository.ReservasDao;
import com.home.reservas.resources.SqlProperties;


public class ReservasDaoImpl implements ReservasDao {

	private SessionFactory sessionFactory;  

	public void setSessionFactory(SessionFactory sf)
	{
		sessionFactory = sf;
	}
	
	@Override
	public boolean insertReserva(Reserva reserva) {

		boolean isSuccess = true;

		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.save(reserva);	
		} catch (Exception e) {
			isSuccess = false;
			System.err.println("Exception in method insertReserva: " + e.getMessage());	
		}
		

		return isSuccess;
	}

	@Override
	public boolean updateReserva(Reserva reserva) {
		boolean isSuccess = true;

		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.saveOrUpdate(reserva);	
		} catch (Exception e) {
			isSuccess = false;
			System.err.println("Exception in method updateReserva: " + e.getMessage());	
		}		

		return isSuccess;
	}

	@Override
	public Reserva getReservaById(int reservaId) {
		  Session session = sessionFactory.getCurrentSession();
		  Reserva reserva = (Reserva) session.createQuery("from Reserva R where R.numero = :numero").setParameter("numero", reservaId).uniqueResult();
		  return reserva;  
	}

	@Override
	public boolean deleteReserva(Reserva reserva) {
		boolean isSuccess = true;

		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.delete(reserva);	
		} catch (Exception e) {
			isSuccess = false;
			System.err.println("Exception in method updateReserva: " + e.getMessage());	
		}		

		return isSuccess;
	}

	@Override
	public List<Reserva> getMisReservas(String usuario) {
		  Session session = sessionFactory.getCurrentSession();
		  @SuppressWarnings("unchecked")  
		  List<Reserva> misReservas = session.
				  					createQuery("from Reserva R where R.id_persona = :id_persona")
				  					.setParameter("id_persona", usuario)
				  					.list();  
		  return misReservas;  
	}
	
	@Override
	public int countReserva() {
		Session session = sessionFactory.getCurrentSession();
		Long count = (Long) session.createQuery(SqlProperties.getInstance().getProperties("count_numero_reserva")).uniqueResult();
		return count.intValue();
	}

}
