package com.home.reservas;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.home.reservas.model.Reserva;
import com.home.reservas.service.ReservasService;

/**
 * Handles requests for the application home page.
 */
@Controller
@ComponentScan ("com.home.reservas.*")
public class ReservasController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReservasController.class);
	
	@Autowired
	private ReservasService reservasService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/**
	 * Servicio REST para insertar una reserva
	 */	
	@RequestMapping(value = "/insertReserva", method = RequestMethod.POST)
	public @ResponseBody boolean insertReserva(@RequestBody Reserva reserva){
		return reservasService.insertReserva(reserva);
	}	
	
	/**
	 * Servicio REST para modificar una reserva
	 */
	@RequestMapping(value = "/updateReserva", method = RequestMethod.POST)
	//@RequestMapping(value = "/updateReserva", method = RequestMethod.GET)
	//public @ResponseBody Reserva updateReserva(){
	public @ResponseBody Boolean updateReserva(@RequestBody Reserva reserva){
		return reservasService.updateReserva(reserva);
	}
	
	/**
	 * Servicio REST para obtener los detalles de una reserva
	 */
	@RequestMapping(value = "/detailsReserva", method = RequestMethod.POST)
	public @ResponseBody Reserva detailsReserva(@RequestBody Reserva reserva){
		Reserva r = reservasService.getReservaById(reserva.getNumero());		
		return r;
	}

	/**
	 * Servicio REST para eliminar una reserva
	 */
	@RequestMapping(value = "/deleteReserva", method = RequestMethod.POST)
	//@RequestMapping(value = "/deleteReserva", method = RequestMethod.GET)
	//public @ResponseBody Reserva deleteReserva(){
	public @ResponseBody Boolean deleteReserva(@RequestBody int numero){
		Reserva r = reservasService.getReservaById(numero);
		Boolean isDeleted = reservasService.deleteReserva(r);
		return isDeleted;
	}

	/**
	 * Servicio REST para obtener las reservas
	 */
	@RequestMapping(value = "/misreservas", method = RequestMethod.GET)
	public @ResponseBody List<Reserva> getReservas (@RequestParam(value="usuario")String  usuario) {
		logger.info("Ejecutando servicio rest");

		List<Reserva> misReservas = reservasService.getMisReservas(usuario);		
		return 	misReservas;
	}
}
