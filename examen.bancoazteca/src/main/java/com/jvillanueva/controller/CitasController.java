package com.jvillanueva.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jvillanueva.modelo.Cita;
import com.jvillanueva.utils.MongoDBFactory;

@Controller
public class CitasController
{
	@Autowired
	MongoDBFactory mdbf;

	@RequestMapping(value = "/control/citas.go", method = RequestMethod.GET)
	@ResponseBody
	public String getCitas()
	{
		return this.mdbf.verDetalleCita();
	}
	
	@RequestMapping(value = "/control/citas/cita.go", method = RequestMethod.POST)
	@ResponseBody
	public String postCita(@RequestBody Cita cita)
	{
		this.mdbf.agregarCita(cita);
		return "agregado";
	}
	
	@RequestMapping(value = "/control/citas/cita.go", method = RequestMethod.PUT)
	@ResponseBody
	public String putCita(@RequestBody Cita cita)
	{
		this.mdbf.actualizarCita(cita);
		return "actualizado";
	}
}
