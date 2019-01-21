$(document).ready(function()
{
	$('#fecha').datepicker
	({
		 uiLibrary: 'bootstrap',
         icons: {
             rightIcon: '<span class="glyphicon glyphicon-chevron-down"></span>'
         }	
	});
	
	$('#btnRegistrarCita').unbind('click').bind('click', registrarCita);
	$('#btnSumbitReg').unbind('click').bind('click', registrarPaciente);
	
	$.ajax
	({
		url : "/ExamenBancoAzteca/control/citas.go",
		type : "GET"
	})
	.done
	(
		function(resp)
		{
			var respuesta = eval(resp);
			for(var i = 0; i < respuesta.length; i++)
			{
				$('#bodyTablaCitas').append
				(
					"<tr><td>" + respuesta[i].pacPNombre + " " + respuesta[i].pacSNombre + " " + respuesta[i].pacPApellido + " " + respuesta[i].pacSApellido + "</td>" + 
					"<td>" + respuesta[i].docPNombre + " " + respuesta[i].docSNombre + " " + respuesta[i].docPApellido + " " + respuesta[i].docSApellido + "</td>" + 
					"<td><select id=\"selStatusIdCita" + respuesta[i].idCita + "\"><option value=\"Atendida\">Atendida</option><option value=\"Pendiente\">Pendiente</option><option value=\"Cancelada\">Cancelada</option></select></td>" +
					"<td><input id=\"fIdCita" +  respuesta[i].idCita  + "\" type=\"text\" value=\"" + respuesta[i].fecha + "\"/></td>" +
					"<td><input id=\"" + respuesta[i].idCita + "\" type=\"button\" class=\"btn btn-success\" value=\"Actualizar\"/></tr>"
				)
				
				$('#selStatusIdCita' + respuesta[i].idCita).val(respuesta[i].status);
				
				$('#fIdCita' + respuesta[i].idCita).datepicker
				({
					 uiLibrary: 'bootstrap',
			         icons: {
			             rightIcon: '<span class="glyphicon glyphicon-chevron-down"></span>'
			         }	
				});
				
				$('#' + respuesta[i].idCita).unbind('click').bind('click', actualizarCita);
			}
		}
	);
	
	$.ajax
	({
		url : "/ExamenBancoAzteca/control/pacientes.go",
		type : "GET"
	})
	.done
	(
		function(resp)
		{
			var respuesta = eval(resp);
			for(var i = 0; i < respuesta.length; i++)
			{
				$('#selectPaciente').append
				(
					"<option value=\"" + respuesta[i]._id + "\">" + respuesta[i].primerNombre + " " + respuesta[i].segundoNombre + " " + respuesta[i].primerApellido + " " + respuesta[i].segundoApellido + "</option>"
				)
			}
		}
	);
	
	$.ajax
	({
		url : "/ExamenBancoAzteca/control/doctores.go",
		type : "GET"
	})
	.done
	(
		function(resp)
		{
			var respuesta = eval(resp);
			for(var i = 0; i < respuesta.length; i++)
			{
				$('#selectDoctor').append
				(
					"<option value=\"" + respuesta[i]._id + "\">" + respuesta[i].primerNombre + " " + respuesta[i].segundoNombre + " " + respuesta[i].primerApellido + " " + respuesta[i].segundoApellido + "</option>"
				)
			}
		}
	);
});

function registrarPaciente()
{
	var datosPaciente = {};
	datosPaciente["primerNombre"] = $("#pNombre").val();
	datosPaciente["segundoNombre"] = $("#sNombre").val();
	datosPaciente["primerApellido"] = $("#pApellido").val();
	datosPaciente["segundoApellido"] = $("#sApellido").val();
	datosPaciente["edad"] = $("#edad").val();
	
	$.ajax
	({
		url : '/ExamenBancoAzteca/control/pacientes/paciente.go',
		type : 'POST',
	    contentType: 'application/json; charset=utf-8',
		data : JSON.stringify(datosPaciente),
	})
	.done
	(
		function(resp)
		{
			alert("Paciente registrado");
			window.location.href = "/ExamenBancoAzteca";
		}
	)
}

function registrarCita()
{
	var datosCita = {};
	datosCita["idPaciente"] = $('#selectPaciente option:selected').val();
	datosCita["idDoctor"] = $('#selectDoctor option:selected').val();
	datosCita["fecha"] = $("#fecha").val();
	datosCita["status"] = "Pendiente";
	
	$.ajax
	({
		url : '/ExamenBancoAzteca/control/citas/cita.go',
		type : 'POST',
	    contentType: 'application/json; charset=utf-8',
		data : JSON.stringify(datosCita),
	})
	.done
	(
		function(resp)
		{
			alert("Cita registrada");
			window.location.href = "/ExamenBancoAzteca";
		}
	)
}

function actualizarCita()
{
	console.log($(this).attr('id'));
	
	var datosCita = {};
	datosCita["_id"] = $(this).attr('id');
	datosCita["fecha"] = $("#fIdCita" + $(this).attr('id')).val();
	datosCita["status"] = $("#selStatusIdCita" + $(this).attr('id') + " option:selected").val();
	
	$.ajax
	({
		url : '/ExamenBancoAzteca/control/citas/cita.go',
		type : 'PUT',
	    contentType: 'application/json; charset=utf-8',
		data : JSON.stringify(datosCita),
	})
	.done
	(
		function(resp)
		{
			alert("Cita actualizada");
			window.location.href = "/ExamenBancoAzteca";
		}
	)
}