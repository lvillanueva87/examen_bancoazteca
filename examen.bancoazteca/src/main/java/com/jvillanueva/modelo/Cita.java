package com.jvillanueva.modelo;

public class Cita
{
	private String _id;
	private String idPaciente;
	private String idDoctor;
	private String fecha;
	private String status;
	
	public String get_id()
	{
		return _id;
	}

	public void set_id(String _id)
	{
		this._id = _id;
	}
	
	public String getIdPaciente()
	{
		return idPaciente;
	}
	
	public void setIdPaciente(String idPaciente)
	{
		this.idPaciente = idPaciente;
	}
	
	public String getIdDoctor()
	{
		return idDoctor;
	}
	
	public void setIdDoctor(String idDoctor)
	{
		this.idDoctor = idDoctor;
	}

	public String getFecha()
	{
		return fecha;
	}

	public void setFecha(String fecha)
	{
		this.fecha = fecha;
	}

	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
}