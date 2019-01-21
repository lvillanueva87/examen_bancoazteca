package com.jvillanueva.utils;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.jvillanueva.modelo.Cita;
import com.jvillanueva.modelo.Doctor;
import com.jvillanueva.modelo.Paciente;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDBFactory
{
	MongoClient cliente;
	MongoDatabase bd;
	MongoCollection<Document> pacientesColeccion, citasColeccion, doctoresColeccion;
	
	public MongoDBFactory()
	{
		this.cliente = MongoClients.create("mongodb://dbadmincc:IntercamBanxico1987@ds159574.mlab.com:59574/control_citas");
		this.bd = cliente.getDatabase("control_citas");
		this.pacientesColeccion = bd.getCollection("paciente");
		this.doctoresColeccion = bd.getCollection("doctor");
		this.citasColeccion = bd.getCollection("cita");
	}
	
	public String verDetalleCita()
	{
		String resp = "[";
		
		MongoCursor<Document> cursor = citasColeccion.find().iterator();
		
		while(cursor.hasNext())
		{
			resp += "{";
			
			Document cita = cursor.next();
			
			
			String idDoctor = cita.getString("idDoctor");
			String idPaciente = cita.getString("idPaciente");
			
			MongoCursor<Document> doctorCursor = doctoresColeccion.find(new BasicDBObject("_id", new ObjectId(idDoctor))).iterator();
			MongoCursor<Document> pacienteCursor = pacientesColeccion.find(new BasicDBObject("_id", new ObjectId(idPaciente))).iterator();
			
			resp += "\"idCita\" : \"" + cita.getObjectId("_id").toString() + "\", ";
			
			while(doctorCursor.hasNext())
			{
				Document doctor = doctorCursor.next();
				resp += "\"docPNombre\" : \"" + doctor.getString("primerNombre") + "\", " + 
						"\"docSNombre\" : \"" + doctor.getString("segundoNombre") + "\", " +
						"\"docPApellido\" : \"" + doctor.getString("primerApellido") + "\", " +
						"\"docSApellido\" : \"" + doctor.getString("segundoApellido") + "\", ";
			}
			
			while(pacienteCursor.hasNext())
			{
				Document paciente = pacienteCursor.next();
				resp += "\"pacPNombre\" : \"" + paciente.getString("primerNombre") + "\", " + 
						"\"pacSNombre\" : \"" + paciente.getString("segundoNombre") + "\", " +
						"\"pacPApellido\" : \"" + paciente.getString("primerApellido") + "\", " +
						"\"pacSApellido\" : \"" + paciente.getString("segundoApellido") + "\", ";
			}
			
			resp += "\"fecha\" : \"" + cita.getString("fecha") + "\", \"status\" : \"" + cita.getString("status") + "\"}"; 
			
			if(cursor.hasNext())
			{
				resp += ","; 
			}
		}
		
		resp += "]";
		
		return resp;
	}
	
	public List<Doctor> verDoctores()
	{
		List<Doctor> doctores = new ArrayList<>();
		MongoCursor<Document> cursor = this.doctoresColeccion.find().iterator();
		
		while(cursor.hasNext())
		{
			Document doctor = cursor.next();
			
			Doctor d = new Doctor();
			d.set_id(doctor.getObjectId("_id").toString());
			d.setPrimerNombre(doctor.getString("primerNombre"));
			d.setSegundoNombre(doctor.getString("segundoNombre"));
			d.setPrimerApellido(doctor.getString("primerApellido"));
			d.setSegundoApellido(doctor.getString("segundoApellido"));
			d.setEdad(doctor.getInteger("edad"));
			d.setEspecialidad(doctor.getString("especialidad"));
			
			doctores.add(d);
		}
		
		return doctores;
	}
	
	public List<Paciente> verPacientes()
	{
		List<Paciente> pacientes = new ArrayList<>();
		MongoCursor<Document> cursor = this.pacientesColeccion.find().iterator();
		
		while(cursor.hasNext())
		{
			Document paciente = cursor.next();
			
			Paciente p = new Paciente();
			p.set_id(paciente.getObjectId("_id").toString());
			p.setPrimerNombre(paciente.getString("primerNombre"));
			p.setSegundoNombre(paciente.getString("segundoNombre"));
			p.setPrimerApellido(paciente.getString("primerApellido"));
			p.setSegundoApellido(paciente.getString("segundoApellido"));
			p.setEdad(paciente.getInteger("edad"));
			
			pacientes.add(p);
		}
		
		return pacientes;
	}
	
	public void agregarPaciente(Paciente p)
	{
		long idPaciente = this.pacientesColeccion.countDocuments() + 1;
		
		Document paciente = new Document();
		
		paciente.append("idPaciente", idPaciente);
		paciente.append("primerNombre", p.getPrimerNombre());
		paciente.append("segundoNombre", p.getSegundoNombre());
		paciente.append("primerApellido", p.getPrimerApellido());
		paciente.append("segundoApellido", p.getSegundoApellido());
		paciente.append("edad", p.getEdad());
		this.pacientesColeccion.insertOne(paciente);
	}
	
	public void agregarCita(Cita c)
	{
		long idCita = this.citasColeccion.countDocuments() + 1;
		
		Document cita = new Document();
		
		cita.append("idCita", idCita);
		cita.append("idPaciente", c.getIdPaciente());
		cita.append("idDoctor", c.getIdDoctor());
		cita.append("fecha", c.getFecha());
		cita.append("status", c.getStatus());

		this.citasColeccion.insertOne(cita);
	}
	
	public void actualizarCita(Cita cita)
	{
		Document nvosVal = new Document();
		nvosVal.put("fecha", cita.getFecha());
		nvosVal.put("status", cita.getStatus());
		this.citasColeccion.updateOne(new BasicDBObject("_id", new ObjectId(cita.get_id())), new Document("$set", nvosVal));
	}
	
}
