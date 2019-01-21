<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Control citas</title>
		<link rel="stylesheet" type="text/css" href="css/gijgo.min.css">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/control_citas.css">
	</head>
	<body>
		<div class="container-fluid">
			<div class="row">
				<div id="divHeader" class="col-sm-12">
					<h3>Citas</h3>
				</div>
				<div id="divTable" class="col-sm-12">
					<table id="tablaCitas">
						<thead>
							<th>Paciente</th>
							<th>Doctor</th>
							<th>Estatus</th>
							<th>Fecha</th>
							<th></th>
						</thead>
						<tbody id="bodyTablaCitas"></tbody>
					</table>
				</div>
			</div>
			<div class="row">
				<div id="formCitas" class="col-sm-12">
					<div class="row">
						<div class="col-sm-12">
							<h3>Registro de citas</h3>
						</div>
						<div class="div-form-control col-12">
							<select id="selectPaciente" class="form-control"></select>
						</div>
						<div class="div-form-control col-12">
							<select id="selectDoctor" class="form-control"></select>
						</div>
						<div class="div-form-control col-12">
							<input id="fecha" type='text' class="form-control" />
						</div>
						<div class="div-form-control col-sm-12">
							<input id="btnRegistrarCita" type="button" class="btn btn-success" value="Registrar cita"/>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div id="formPacientes" class="col-sm-12">
					<div class="row">
						<div class="col-sm-12">
							<h3>Registro de pacientes</h3>
						</div>
						<div class="div-form-control col-sm-12">
							<input type="text" id="pNombre" class="form-control mx-auto" placeholder="Primer nombre" />
						</div>
						<div class="div-form-control col-sm-12">
							<input type="text" id="sNombre" class="form-control mx-auto" placeholder="Segundo nombre" />
						</div>
						<div class="div-form-control col-sm-12">
							<input type="text" id="pApellido" class="form-control mx-auto" placeholder="Primer apellido" />
						</div>
						<div class="div-form-control col-sm-12">
							<input type="text" id="sApellido" class="form-control mx-auto" placeholder="Segundo apellido" />
						</div>
						<div class="div-form-control col-12 offset-md-3 col-sm-3">
							<input type="number" id="edad" min="5"  max="99" class="form-control float-right" placeholder="Edad"/>
						</div>
						<div class="div-form-control col-12 col-sm-6">
							<select id="genero" class="form-control">
								<option value="M">M</option>
								<option value="F">F</option>
							</select>
						</div>
						<div class="div-form-control col-sm-12">
							<input id="btnSumbitReg" type="button" class="btn btn-success" value="Registrar paciente"/>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script src="js/jquery-3.3.1.js"></script>
		<script src="js/gijgo.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/controlCitasFunctions.js"></script>
	</body>
</html>