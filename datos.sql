#---------------------------------------------------
#----------------Insercion de datos-----------------
#---------------------------------------------------

#---------------------Ciudades----------------------

INSERT INTO Ciudad VALUES (8000,"Bahia Blanca");
INSERT INTO Ciudad VALUES (8300,"Neuquen");
INSERT INTO Ciudad VALUES (9410,"Ushuaia");
INSERT INTO Ciudad VALUES (1900,"La Plata");
INSERT INTO Ciudad VALUES (8500,"Viedma");
INSERT INTO Ciudad VALUES (5000,"Cordoba");
INSERT INTO Ciudad VALUES (3300,"Posadas");
INSERT INTO Ciudad VALUES (3500,"Resistencia");
INSERT INTO Ciudad VALUES (5400,"Rawson");
INSERT INTO Ciudad VALUES (6300,"Santa Rosa");

#--------------------Sucursales---------------------

INSERT INTO Sucursal VALUES(default,"Banco Centraloide","San martin 184",4578961,"8 a 12",8000);
INSERT INTO Sucursal VALUES(default,"Banco Homero","Av. Siempre Viva 742",4212397,"9 a 13",8300);
INSERT INTO Sucursal VALUES(default,"Banco McFly","Av. Roslyndale 9303",4519738,"8 a 12",9410);
INSERT INTO Sucursal VALUES(default,"Banco Balboa","Tusculum 1818",4378961,"10 a 18",1900);
INSERT INTO Sucursal VALUES(default,"Banco Stark","Malibu Point 10880",4571661,"8 a 12",8500);
INSERT INTO Sucursal VALUES(default,"Banco Goku","Distrito Este 439",4291103,"8 a 12",5000);
INSERT INTO Sucursal VALUES(default,"Banco Drake & Josh","Av. Alonzo 3878",4898123,"8 a 16",3300);
INSERT INTO Sucursal VALUES(default,"Banco Orden del Fenix","Grimauld Place 12",4566922,"8 a 20",3500);
INSERT INTO Sucursal VALUES(default,"Banco McCallister","Av Lincoln 671",4545617,"6 a 23",5400);
INSERT INTO Sucursal VALUES(default,"Banco Parker","Asquith Crescent 6224",4548261,"8 a 12",6300);

#--------------------Empleado------------------------

INSERT INTO Empleado VALUES(default,"Martinez","Jose","DNI",34789156,"Tte Farias 123","2020-800450","Cajero",md5("45jeje12pepito"),1);
INSERT INTO Empleado VALUES(default,"Perez","Pedro","DNI",31842456,"Av. Alem 1248","2020-800451","Corredor de Bolsa",md5("pedritoel+kpo"),2);
INSERT INTO Empleado VALUES(default,"Fernandez","Ricardo","DNI",33004567,"12 de Octubre 345","2020-800452","Cajero",md5("46jeje12pepito"),3);
INSERT INTO Empleado VALUES(default,"Hernandez","Erica","DNI",32432675,"Mitre 1256","2020-800453","Cajero",md5("47jeje12pepito"),4);
INSERT INTO Empleado VALUES(default,"Gimenez","Gabriela","DNI",33890432,"Sarmiento 567","2020-800454","Administrativo",md5("48jeje12pepito"),5);
INSERT INTO Empleado VALUES(default,"Mancini","Karina","DNI",35798546,"Chiclana 516","2020-800455","Cajero",md5("49jeje12pepito"),6);
INSERT INTO Empleado VALUES(default,"Suarez","Julia","DNI",34908643,"Av. Colon 367","2020-800456","Administrativo",md5("50jeje12pepito"),7);
INSERT INTO Empleado VALUES(default,"Puhl","Juan Manuel","DNI",39103245,"Zapiola 745","2020-800457","Gerente",md5("51jeje12pepito"),8);
INSERT INTO Empleado VALUES(default,"Pintos","Pintos","DNI",38775642,"San Martin 1678","2020-800458","Administrativo",md5("52jeje12pepito"),9);
INSERT INTO Empleado VALUES(default,"Comellas","Juan Manuel","DNI",38069284,"Alsina 890","2020-800459","Gerente",md5("53jeje12pepito"),10);

#------------------Cliente--------------------------

INSERT INTO Cliente VALUES(default,"Rodriguez","Alberto","DNI",24729156,"Panama 56","2020-802413",'1972-08-22');
INSERT INTO Cliente VALUES(default,"Rodriguez","Juan","DNI",25649156,"Aguado 210","2020-802414",'1973-08-02');
INSERT INTO Cliente VALUES(default,"Hernandez","Carlos","DNI",28219156,"Primera Junta 213","2020-802415",'1982-11-12');
INSERT INTO Cliente VALUES(default,"Hernandez","Martin","DNI",24990156,"Corrientes 67","2020-802416",'1973-10-16');
INSERT INTO Cliente VALUES(default,"Peron","Juan Domingo","DNI",10255365,"Entre Rios 457","2020-802412",'1895-01-09');
INSERT INTO Cliente VALUES(default,"Macri","Jose","DNI",27629156,"San Juan 651","2020-802417",'1982-06-30');
INSERT INTO Cliente VALUES(default,"Escudero","Rodrigo","DNI",29089156,"11 de Abril 345 ","2020-802418",'1988-03-05');
INSERT INTO Cliente VALUES(default,"Pesce","Juliana","DNI",30329156,"Moreno 478","2020-802419",'1989-12-22');
INSERT INTO Cliente VALUES(default,"Garza","Abigail","DNI",33429156,"9 de Julio 458","2020-802420",'1990-04-13');
INSERT INTO Cliente VALUES(default,"Pino","Viviana","DNI",24729676,"25 de Mayo 908","2020-802421",'1972-07-02');

#------------------Plazo Fijo-------------------------

INSERT INTO Plazo_Fijo VALUES(default,12554.25,'2018-05-03','2018-10-03',22.20,2220,1);
INSERT INTO Plazo_Fijo VALUES(default,125540.67,'2018-03-10','2019-03-10',22.20,2220,2);
INSERT INTO Plazo_Fijo VALUES(default,1250.90,'2018-04-14','2018-07-14',22.20,2220,1);
INSERT INTO Plazo_Fijo VALUES(default,12346.25,'2018-06-22','2019-01-22',22.20,2220,4);
INSERT INTO Plazo_Fijo VALUES(default,567800.75,'2018-12-12','2019-02-12',22.20,2220,3);
INSERT INTO Plazo_Fijo VALUES(default,45689.50,'2018-05-03','2019-05-03',22.20,2220,1);

#-----------------Taza Plazo Fijo-------------------------

INSERT INTO Tasa_Plazo_Fijo VALUES(30,0, 60000,5.50);
INSERT INTO Tasa_Plazo_Fijo VALUES(360,60000, 150000,7.55);
INSERT INTO Tasa_Plazo_Fijo VALUES(90,0, 60000, 6.50);
INSERT INTO Tasa_Plazo_Fijo VALUES(180,0,60000, 7.00);
INSERT INTO Tasa_Plazo_Fijo VALUES(60,150000, 10000000,6.39); #Tiene que tener mucha plata
INSERT INTO Tasa_Plazo_Fijo VALUES(360,0, 60000, 7.50);

#----------------Plazo Cliente--------------------------

INSERT INTO Plazo_Cliente VALUES(1,1);
INSERT INTO Plazo_Cliente VALUES(2,3);
INSERT INTO Plazo_Cliente VALUES(3,4);
INSERT INTO Plazo_Cliente VALUES(4,5);
INSERT INTO Plazo_Cliente VALUES(5,7);
INSERT INTO Plazo_Cliente VALUES(6,8);

#---------------Prestamo--------------------------------

INSERT INTO Prestamo VALUES(default,'2018-09-12', 12, 10000, 21.50, 2150, 1012.50, 3, 1);
INSERT INTO Prestamo VALUES(default,'2018-07-23', 120, 2000, 30, 6000, 66.66, 3, 4);
INSERT INTO Prestamo VALUES(default,'2018-03-21', 24, 25000, 27, 13500, 1604.16, 1, 5);
INSERT INTO Prestamo VALUES(default,'2018-05-04', 6, 1000, 17, 85, 180.83, 2, 9);

#--------------Pago---------------------------------------

#INSERT INTO Pago VALUES(1,1, '2018-10-12', '2018-10-01');
#INSERT INTO Pago VALUES(1,2, '2018-11-12', '2018-11-02');
#INSERT INTO Pago VALUES(1,3, '2018-11-12', null);
#INSERT INTO Pago VALUES(1,4, '2018-12-16', null);
#INSERT INTO Pago VALUES(2,3, '2018-07-23', '2018-07-20');
#INSERT INTO Pago VALUES(2,4, '2018-08-21', null);
#INSERT INTO Pago VALUES(2,5, '2018-09-24', null);
#INSERT INTO Pago VALUES(2,6, '2018-09-25', null);
#INSERT INTO Pago VALUES(2,7, '2018-09-26', null);
#INSERT INTO Pago VALUES(2,8, '2018-09-27', null);
#INSERT INTO Pago VALUES(2,9, '2018-09-28', null);
#INSERT INTO Pago VALUES(2,10, '2018-09-29', null);
#INSERT INTO Pago VALUES(2,11, '2018-09-30', null);
#INSERT INTO Pago VALUES(1,5, '2019-01-12', '2019-01-11');
#INSERT INTO Pago VALUES(1,6, '2017-01-13', null);
#INSERT INTO Pago VALUES(1,7, '2017-01-14', null);
#INSERT INTO Pago VALUES(1,8, '2017-01-15', null);
#INSERT INTO Pago VALUES(1,9, '2017-01-16', null);
#INSERT INTO Pago VALUES(3,1, '2018-04-04', '2018-04-03');
#INSERT INTO Pago VALUES(4,5, '2018-06-04', '2018-06-05');
#INSERT INTO Pago VALUES(4,6, '2018-06-05', null);


#-------------Tasa Prestamo-------------------------------

INSERT INTO Tasa_Prestamo VALUES(12,3000, 100000, 21.50);
INSERT INTO Tasa_Prestamo VALUES(120, 0, 3000, 30);
INSERT INTO Tasa_Prestamo VALUES(024, 10000, 30000, 27);
INSERT INTO Tasa_Prestamo VALUES(006, 0, 3000, 17);
INSERT INTO Tasa_Prestamo VALUES(18, 10000, 30000, 24);
INSERT INTO Tasa_Prestamo VALUES(18, 100, 3000, 21);

#-----------Caja de Ahorro-------------------------------

INSERT INTO Caja_Ahorro VALUES (default, 000000000000000001, 2369);
INSERT INTO Caja_Ahorro VALUES (default, 000000000000000002, 15000);
INSERT INTO Caja_Ahorro VALUES (default, 000000000000000003, 300000);
INSERT INTO Caja_Ahorro VALUES (default, 000000000000000004, 123000);
INSERT INTO Caja_Ahorro VALUES (default, 000000000000000005, 100000);

#----------Cliente CA-----------------------------------

INSERT INTO Cliente_CA VALUES(1,1);
INSERT INTO Cliente_CA VALUES(9,2);
INSERT INTO Cliente_CA VALUES(2,3);
INSERT INTO Cliente_CA VALUES(10,4);
INSERT INTO Cliente_CA VALUES(10,5);

#----------Tarjet---------------------------------------

INSERT INTO Tarjeta VALUES(default, md5("abcdefghijklmnopqrstuvwxyz012345"), md5("abcdefghijklmnopqrstuvwxyz012346"), '2018-12-12', 1, 1);
INSERT INTO Tarjeta VALUES(default, md5("abcdefghijklmnopqrstuvwxyzz01234"), md5("abcdefghjjklmnopqrstuvwxyz012345"), '2018-12-13', 9, 2);
INSERT INTO Tarjeta VALUES(default, md5("abcdefghijklmnopqrstuvwxyz002345"), md5("abcdefghijklmnnpqrstuvwxyz012345"), '2018-12-14', 2, 3);
INSERT INTO Tarjeta VALUES(default, md5("abcdefghijklmnopqrstuvwxyz012355"), md5("abcdefghijklmnopqrstuwwxyz012345"), '2018-12-15', 10, 4);
INSERT INTO Tarjeta VALUES(default, md5("55555"), md5("55555"), '2018-12-16', 10, 5  );

#---------Caja----------------------------------------

INSERT INTO Caja VALUES (default);
INSERT INTO Caja VALUES (default);
INSERT INTO Caja VALUES (default);
INSERT INTO Caja VALUES (default);
INSERT INTO Caja VALUES (100);

#------------Ventanilla-------------------------------

INSERT INTO Ventanilla VALUES (1, 1);
INSERT INTO Ventanilla VALUES (3, 5);

#------------ATM--------------------------------------

INSERT INTO ATM VALUES (2, 5000, "Gorrito 670");
INSERT INTO ATM VALUES (4, 9410, "Entre Rios 569");

#-----------Transaccion-------------------------------

INSERT INTO Transaccion VALUES (default, '2018-10-12', '13:00:00', 2000);
INSERT INTO Transaccion VALUES (default, '2018-09-09', '12:56:00', 1550);
INSERT INTO Transaccion VALUES (default, '2018-06-12', '10:01:00', 1345);
INSERT INTO Transaccion VALUES (default, '2018-09-15', '11:09:00', 10000);
INSERT INTO Transaccion VALUES (default, '2018-08-12', '14:55:00', 10050);
INSERT INTO Transaccion VALUES (default, '2018-05-30', '10:51:00', 600);
INSERT INTO Transaccion VALUES (default, '2018-07-11', '11:29:00', 1100);
INSERT INTO Transaccion VALUES (default, '2018-11-22', '14:15:00', 5000);
INSERT INTO Transaccion VALUES (default, '2018-05-10', '11:51:00', 680.50);
INSERT INTO Transaccion VALUES (default, '2018-07-21', '11:59:00', 1499);
INSERT INTO Transaccion VALUES (default, '2018-11-15', '14:35:00', 10000);


#-------------Debito------------------------------

INSERT INTO Debito VALUES (1, 'Pago de Servicio', 1, 1);
INSERT INTO Debito VALUES (2, 'Compra', 9, 2);
INSERT INTO Debito VALUES (5, 'Pago de Servicio', 2, 3);

#--------------Transaccion por caja-------------------

INSERT INTO Transaccion_por_caja VALUES (3, 1);
INSERT INTO Transaccion_por_caja VALUES (4, 3);
INSERT INTO Transaccion_por_caja VALUES (6, 3);
INSERT INTO Transaccion_por_caja VALUES (7, 2);
INSERT INTO Transaccion_por_caja VALUES (8, 4);
INSERT INTO Transaccion_por_caja VALUES (9, 1);

#-------------Deposito------------------------------

INSERT INTO Deposito VALUES (3, 1);
INSERT INTO Deposito VALUES (4, 3);

#-------------Extraccion------------------------------

INSERT INTO Extraccion VALUES (6, 2, 3);
INSERT INTO Extraccion VALUES (7, 10, 4);

#------------Transferencia-----------------------

INSERT INTO Transferencia VALUES (9, 1, 1, 2);
INSERT INTO Transferencia VALUES (8, 10, 4, 3);