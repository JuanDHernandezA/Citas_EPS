--INSERTS
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

INSERT INTO medico VALUES
	(1,'11111','Pedro','Perez','pp@gmail.com','5551234','1980-04-23','RM1',1,2);
INSERT INTO medico VALUES
	(1,'22222','Paula','Arenas','pa@gmail.com','5554321','1990-05-12','RM2',2,3);
INSERT INTO medico VALUES
	(2,'33333','Carlos','Castro','cc@gmail.com','5557788','1985-10-01','RM3',1,4);
INSERT INTO medico VALUES
	(1,'44444','Maria','Moreno','mm@gmail.com','5559900','1995-06-12','RM4',2,5);

INSERT INTO public.agenda(fecha_inicio_agenda, fecha_fin_agenda, medico_id)
	VALUES ('2024-06-01', '2024-07-01', '11111'),
	('2024-06-01', '2024-07-01', '22222'),
	('2024-06-01', '2024-07-01', '33333'),
	('2024-06-01', '2024-07-01', '44444');

UPDATE jornada_consultorio SET medico_id = 11111 WHERE jornada_id = 1 AND consultorio_id = 2;
UPDATE jornada_consultorio SET medico_id = 22222 WHERE jornada_id = 2 AND consultorio_id = 3;
UPDATE jornada_consultorio SET medico_id = 33333 WHERE jornada_id = 1 AND consultorio_id = 4;
UPDATE jornada_consultorio SET medico_id = 44444 WHERE jornada_id = 2 AND consultorio_id = 5;

INSERT INTO public.cita(
	fecha_cita, hora_inicio, hora_fin, estado_id, agenda_id)
	VALUES ('2024-06-07', '10:00:00', '10:20:00', 1, 1),
			('2024-06-07', '11:00:00', '11:20:00', 1, 1),
			('2024-06-08', '15:00:00', '15:20:00', 1, 2),
			('2024-06-08', '15:20:00', '15:40:00', 1, 2),
			('2024-06-08', '08:20:00', '08:40:00', 1, 3),
			('2024-06-08', '08:40:00', '09:00:00', 1, 3),
			('2024-06-09', '16:40:00', '17:00:00', 1, 4),
			('2024-06-09', '17:00:00', '17:20:00', 1, 4);

--SELECTS

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
SELECT * FROM paciente;
SELECT * FROM jornada_consultorio;
SELECT * FROM agenda;
SELECT * FROM cita;


SELECT numero_con AS numero_consultorio, nombre_esp AS especialidad, nombre_sede FROM consultorio
INNER JOIN especialidad ON consultorio.especialidad_id = especialidad.id_esp
INNER JOIN sede ON consultorio.sede_id = sede.id_sede;

SELECT numero_con,nombre_jornada,medico_id FROM jornada_consultorio
INNER JOIN jornada ON jornada.id_jornada = jornada_consultorio.jornada_id
INNER JOIN consultorio ON consultorio.id_con = jornada_consultorio.consultorio_id;


--UPDATE jornada_consultorio SET medico_id = ? WHERE jornada_id = ? AND consultorio_id = ?
SELECT * FROM jornada_consultorio WHERE medico_id = '9999';


SELECT * FROM cita
INNER JOIN agenda ON cita.agenda_id = agenda.id_agenda
INNER JOIN medico ON agenda.medico_id = medico.id_med
WHERE medico.especialidad_id = 1 AND cita.estado_id = 1;

SELECT * FROM cita
INNER JOIN agenda ON cita.agenda_id = agenda.id_agenda
INNER JOIN medico ON agenda.medico_id = medico.id_med
WHERE cita.estado_id = 1;

--UPDATE cita SET paciente_id = ? WHERE id_cita = ? 





