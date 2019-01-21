package com.jvillanueva.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jvillanueva.modelo.Paciente;
import com.jvillanueva.utils.MongoDBFactory;

@Controller
public class PacientesController
{
	@Autowired
	MongoDBFactory mdbf;
	
	@RequestMapping(value="/control/pacientes/paciente.go", method=RequestMethod.POST)
	@ResponseBody
	public String postPaciente(@RequestBody Paciente paciente) 
	{
		mdbf.agregarPaciente(paciente);
		return "agregado";
	}
	
	@RequestMapping(value = "/control/pacientes.go", method = RequestMethod.GET)
	@ResponseBody
	public List<Paciente> getPacientes(HttpServletRequest request)
	{
		return this.mdbf.verPacientes();
	}

}
