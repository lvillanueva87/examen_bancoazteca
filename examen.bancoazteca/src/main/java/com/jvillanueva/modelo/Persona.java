package com.jvillanueva.modelo;

public class Persona
{
	private String _id;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private int edad;
	
	public Persona(){}
	
	public Persona(String id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, int edad)
	{
		super();
		this._id = id;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.edad = edad;
	}

	public Persona(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, int edad)
	{
		super();
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.edad = edad;
	}

	public String get_id()
	{
		return _id;
	}
	
	public void set_id(String id)
	{
		this._id = id;
	}
	
	public String getPrimerNombre()
	{
		return primerNombre;
	}
	
	public void setPrimerNombre(String primerNombre)
	{
		this.primerNombre = primerNombre;
	}
	
	public String getSegundoNombre()
	{
		return segundoNombre;
	}
	
	public void setSegundoNombre(String segundoNombre)
	{
		this.segundoNombre = segundoNombre;
	}
	
	public String getPrimerApellido()
	{
		return primerApellido;
	}
	
	public void setPrimerApellido(String primerApellido)
	{
		this.primerApellido = primerApellido;
	}
	
	public String getSegundoApellido()
	{
		return segundoApellido;
	}
	
	public void setSegundoApellido(String segundoApellido)
	{
		this.segundoApellido = segundoApellido;
	}

	public int getEdad()
	{
		return edad;
	}

	public void setEdad(int edad)
	{
		this.edad = edad;
	}
}
