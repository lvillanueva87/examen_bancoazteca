package com.jvillanueva.modelo;

import java.util.ArrayList;

public class Doctor extends Persona
{
	private String especialidad;
	
	public void setEspecialidad(String especialidad)
	{
		this.especialidad = especialidad;
	}
	
	public String getEspecialidad()
	{
		return especialidad;
	}
}
