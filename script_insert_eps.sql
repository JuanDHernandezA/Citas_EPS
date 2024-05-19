INSERT INTO tipo_documento(nombre_tipo,abreviacion_tipo) values
	('CEDULA DE CIUDADANIA','CC'),
	('CEDULA DE EXTRANJERIA','CE'),
	('TARJETA DE IDENTIDAD','TI');

INSERT INTO genero(nombre_genero) values
	('MASCULINO'),
	('FEMENINO'),
	('OTRO');

INSERT INTO estado(tipo_estado) values
	('DISPONIBLE'),
	('AGENDADA'),
	('FINALIZADA');
	
INSERT INTO categoria(nombre_categoria) values
	('A'),
	('B'),
	('C');
	
INSERT INTO especialidad(nombre_esp) values
	('GENERAL'),
	('ODONTOLOGIA'),
	('OPTOMETRIA'),
	('DERMATOLOGIA'),
	('HEMATOLOGIA');

INSERT INTO sede(nombre_sede,direccion) values
	('HOSPITAL CENTRAL','cll 100 # 12 - 34');
	
INSERT INTO consultorio(numero_con,especialidad_id,sede_id) values
	('101',1,1),
	('201',2,1),
	('301',3,1),
	('401',4,1),
	('501',5,1);
	
INSERT INTO jornada(nombre_jornada,hora_inicio,hora_fin) VALUES
	('DIURNA','06:00:00','12:00:00'),
	('TARDE','12:00:00','18:00:00');

INSERT INTO administrador VALUES
	(1,'1234','Admin','EPS','eps@gmail.com','5551234','1980-04-23',1);
	
INSERT INTO jornada_consultorio(jornada_id,consultorio_id) values
	(1,1),
	(2,1),
	(1,2),
	(2,2),
	(1,3),
	(2,3),
	(1,4),
	(2,4),
	(1,5),
	(2,5);

SELECT * FROM genero;
SELECT * FROM estado;
SELECT * FROM categoria;
SELECT * FROM especialidad;
SELECT * FROM sede;
SELECT * FROM consultorio;
SELECT * FROM jornada;
SELECT * FROM administrador;
SELECT * FROM tipo_documento;
SELECT * FROM medico;

SELECT numero_con AS numero_consultorio, nombre_esp AS especialidad, nombre_sede FROM consultorio
INNER JOIN especialidad ON consultorio.especialidad_id = especialidad.id_esp
INNER JOIN sede ON consultorio.sede_id = sede.id_sede;

SELECT numero_con,nombre_jornada,medico_id FROM jornada_consultorio
INNER JOIN jornada ON jornada.id_jornada = jornada_consultorio.jornada_id
INNER JOIN consultorio ON consultorio.id_con = jornada_consultorio.consultorio_id;
