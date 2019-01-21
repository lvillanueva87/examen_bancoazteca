package com.jvillanueva.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jvillanueva.modelo.Doctor;
import com.jvillanueva.utils.MongoDBFactory;

@Controller
public class DoctoresController
{
	@Autowired
	MongoDBFactory mdbf;

	@RequestMapping(value="/control/doctores.go", method=RequestMethod.GET)
	@ResponseBody
	public List<Doctor> getDoctores(HttpServletRequest request)
	{
		return this.mdbf.verDoctores();
	}

}
