package com.home.reservas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.home.json.serializer.JsonDateSerializer;

@JsonAutoDetect
@Entity
@Table(name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue
	private int numero;

	private String id_persona;
	private Date fecha_inicio;
	private Date fecha_fin;
	private int horas;
	private String lugar;
	private int estado;

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public String getId_persona() {
		return id_persona;
	}

	public void setId_persona(String id_persona) {
		this.id_persona = id_persona;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	
	@JsonSerialize(using = JsonDateSerializer.class)
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getFecha_fin() {
		return fecha_fin;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
}
