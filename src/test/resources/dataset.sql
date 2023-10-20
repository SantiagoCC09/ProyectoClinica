
insert into cuenta values (1, "juan@gmali" , "juasd" );
insert into cuenta values (2, "jhon@gmali" , "jhonsd" );
insert into cuenta values (3, "Ca@mail.com", "casd" );

insert into cuenta values (4, "ale@gmali" , "aleasd" );
insert into cuenta values (5, "sa@gmalil" , "saasd" );
insert into cuenta values (6, "du@gmail.com" , "duasd" );


insert into usuario values (1,"12345", "3128823", "Armenia", "juan", "ESTADO_ACTIVO", "mifoto");
insert into usuario values (2,"123453534", "31235434", "Calarca", "jhon", "ESTADO_ACTIVO", "mifoto");
insert into usuario values (3,"123", "31288243", "Circasia", "carlos", "ESTADO_ACTIVO", "mifoto");

insert into usuario values (4,"123432", "334321288", "Genova", "alexander", "ESTADO_ACTIVO", "mifoto");
insert into usuario values (5,"123453", "312882343", "Montenegro", "santiago", "ESTADO_ACTIVO", "mifoto");
insert into usuario values (6,"1234530", "3128823532", "Armenia", "duvan", "ESTADO_ACTIVO", "mifoto");

insert into administrador values (1);

insert into medico values ( 1,"INFECTOLOGIA" );
insert into medico values (2,"GERIATRIA" );
insert into medico values (3,"GASTROENTEROLOGIA");

insert into paciente () values ( 4,0,1, "2003-02-28" );
insert into paciente () values ( 5,1,2,"2003-02-28" );
insert into paciente () values ( 6,2,1,"2003-02-28" );

insert into cita values (1, 3, 4, "2023-12-12", "2023-10-10", "Infeccion renal", "Programada");
insert into cita values (2, 2, 5, "2023-11-15", "2023-10-13", "Infeccion", "Programada");
insert into cita values (3, 1, 6, "2023-10-05", "2023-09-20", "Dolor de espalda", "Completada");


insert into dia_trabajo_medico values (1, 1,"2023-10-15 00:00:00","LIBRE");
insert into dia_trabajo_medico values (3, 2,"2023-10-15 00:00:00", "LIBRE");
insert into dia_trabajo_medico values (2, 3,"2023-10-15 00:00:00", "LIBRE");

insert into jornada_medico values (1,"07:00:00","18:00:00",1);
insert into jornada_medico values (2,"00:00:00","07:00:00",3);
insert into jornada_medico values (3,"18:00:00","00:00:00",2);

insert into alergia values (1,"rinitis");
insert into alergia values (2,"dermatitis");
insert into alergia values (3,"alergia a alimentos");
insert into alergia values (4,"alergia a farmacos");

insert into alergia_paciente values (4,1,1);
insert into alergia_paciente values (5,2,2);
insert into alergia_paciente values (6,3,3);

insert into pqr values (1, 1, 4, "2023-10-30", "2023-10-20","Cancelar cita","RADICADA","Calamidad domestica");




