DROP DATABASE banco;
DROP USER 'atm'@'%';
DROP USER 'admin'@'localhost';
DROP USER 'empleado'@'%';
#---------------------------------------------------
#----------Creación de la base de datos-------------
#---------------------------------------------------
CREATE DATABASE BANCO;

#---------------------------------------------------
#----------Eleccion de la base de datos-------------
#---------------------------------------------------
USE BANCO;

#---------------------------------------------------
#-----------------Creación de tablas----------------
#---------------------------------------------------
CREATE TABLE Ciudad(
cod_postal	INTEGER(4) UNSIGNED NOT NULL,
nombre		varchar(64) NOT NULL,

 constraint pk_ciudad primary key (cod_postal)
);

CREATE TABLE Sucursal(
nro_suc		INTEGER(3) UNSIGNED NOT NULL AUTO_INCREMENT,
nombre		varchar(64) NOT NULL,
direccion	varchar(64) NOT NULL,
telefono	varchar(32) NOT NULL,
horario 	varchar(32) NOT NULL,
cod_postal	INTEGER(4) UNSIGNED NOT NULL,

constraint pk_suc PRIMARY KEY (nro_suc),
constraint fk_suc_ciu FOREIGN KEY (cod_postal) REFERENCES Ciudad (cod_postal)
);

CREATE TABLE Empleado(
legajo		INTEGER(4) UNSIGNED NOT NULL AUTO_INCREMENT,
apellido	varchar(64) NOT NULL,
nombre		varchar(64) NOT NULL,
tipo_doc	varchar(20) NOT NULL,
nro_doc		INTEGER(8) UNSIGNED NOT NULL,
direccion	varchar(64) NOT NULL,
telefono	varchar(32)	NOT NULL,  
cargo		varchar(64) NOT NULL,  
password	varchar(32) NOT NULL,
nro_suc		INTEGER(3) UNSIGNED NOT NULL,

constraint pk_empleado PRIMARY KEY (legajo), 
constraint fk_empl_suc FOREIGN KEY (nro_suc) REFERENCES Sucursal (nro_suc)
);

CREATE TABLE Cliente(
nro_cliente		INTEGER(5) UNSIGNED NOT NULL AUTO_INCREMENT,
apellido		varchar(64) NOT NULL,
nombre			varchar(64) NOT NULL,
tipo_doc		varchar(20) NOT NULL,
nro_doc			INTEGER(8) UNSIGNED NOT NULL,
direccion		varchar(64) NOT NULL,
telefono		varchar(32) NOT NULL,
fecha_nac		DATE NOT NULL,

constraint pk_cliente PRIMARY KEY (nro_cliente)
);

CREATE TABLE Plazo_Fijo(
nro_plazo		INTEGER(8) UNSIGNED NOT NULL AUTO_INCREMENT,
capital			DECIMAL(16,2) UNSIGNED NOT NULL,
fecha_inicio	DATE NOT NULL, 
fecha_fin		DATE NOT NULL, 
tasa_interes	DECIMAL(4,2) UNSIGNED NOT NULL,
interes			DECIMAL(16,2) UNSIGNED NOT NULL,
nro_suc			INTEGER(3) UNSIGNED NOT NULL,

constraint pk_nro_plazo PRIMARY KEY (nro_plazo), 
constraint fk_pf_suc FOREIGN KEY (nro_suc) REFERENCES Sucursal (nro_suc)
);

CREATE TABLE Tasa_Plazo_Fijo(
periodo		INTEGER(3) UNSIGNED NOT NULL,
monto_inf	DECIMAL(16,2) UNSIGNED NOT NULL,
monto_sup	DECIMAL(16,2) UNSIGNED NOT NULL,
tasa		DECIMAL(4,2) UNSIGNED NOT NULL,

constraint pk_tasa_plazo_fijo PRIMARY KEY (periodo,monto_inf,monto_sup) 
);

CREATE TABLE Plazo_Cliente(
nro_plazo		INTEGER(8) UNSIGNED NOT NULL,
nro_cliente		INTEGER(5) UNSIGNED NOT NULL,

constraint pk_plazo_cliente PRIMARY KEY (nro_plazo, nro_cliente),

constraint fk_pc_pf FOREIGN KEY (nro_plazo) REFERENCES Plazo_Fijo (nro_plazo),
constraint fk_pc_cliente FOREIGN KEY (nro_cliente) REFERENCES Cliente (nro_cliente)
);

CREATE TABLE Prestamo(
nro_prestamo	INTEGER(8) UNSIGNED NOT NULL AUTO_INCREMENT,
fecha			DATE NOT NULL,
cant_meses		INTEGER(2) UNSIGNED NOT NULL,
monto			DECIMAL(10,2) UNSIGNED NOT NULL,
tasa_interes	DECIMAL(4,2) UNSIGNED NOT NULL,
interes			DECIMAL(9,2) UNSIGNED NOT NULL,
valor_cuota		DECIMAL(9,2) UNSIGNED NOT NULL,
legajo			INTEGER(4) UNSIGNED NOT NULL,
nro_cliente		INTEGER(5) UNSIGNED NOT NULL,

constraint pk_prestamo PRIMARY KEY (nro_prestamo),
constraint fk_prest_empleado FOREIGN KEY (legajo) REFERENCES Empleado (legajo),
constraint fk_prest_cliente FOREIGN KEY (nro_cliente) REFERENCES Cliente (nro_cliente)
);

CREATE TABLE Pago(
nro_prestamo	INTEGER(8) UNSIGNED NOT NULL,
nro_pago		INTEGER(2) UNSIGNED NOT NULL,
fecha_venc		DATE NOT NULL,
fecha_pago		DATE,

constraint pk_pago PRIMARY KEY (nro_prestamo,nro_pago),
constraint fk_pago_prest FOREIGN KEY (nro_prestamo) REFERENCES Prestamo (nro_prestamo)
);

CREATE TABLE Tasa_Prestamo(
periodo		INTEGER(3) UNSIGNED NOT NULL,
monto_inf	DECIMAL(10,2) UNSIGNED NOT NULL,
monto_sup	DECIMAL(10,2) UNSIGNED NOT NULL,
tasa		DECIMAL(4,2) UNSIGNED NOT NULL,

constraint pk_tp PRIMARY KEY (periodo,monto_inf,monto_sup)
);

CREATE TABLE Caja_Ahorro(
nro_ca		INTEGER(8) UNSIGNED NOT NULL AUTO_INCREMENT,
CBU			BIGINT(18) UNSIGNED NOT NULL,
saldo		DECIMAL(16,2) UNSIGNED NOT NULL,

constraint pk_ca PRIMARY KEY (nro_ca)
);

CREATE TABLE Cliente_CA(
nro_cliente		INTEGER(5) UNSIGNED NOT NULL,
nro_ca			INTEGER(8) UNSIGNED NOT NULL,

constraint pk_clienteCA PRIMARY KEY (nro_cliente,nro_ca),
constraint fk_clienteCA_cliente FOREIGN KEY (nro_cliente) REFERENCES Cliente (nro_cliente),
constraint fk_clienteCA_ca FOREIGN KEY (nro_ca) REFERENCES Caja_Ahorro (nro_ca)
);

CREATE TABLE Tarjeta(
nro_tarjeta		BIGINT(16) UNSIGNED NOT NULL AUTO_INCREMENT,
PIN				varchar(32) NOT NULL,
CVT				varchar(32) NOT NULL,
fecha_venc		DATE NOT NULL,
nro_cliente		INTEGER(5) UNSIGNED NOT NULL,
nro_ca			INTEGER(8) UNSIGNED NOT NULL,

constraint pk_tarjeta PRIMARY KEY (nro_tarjeta),
constraint fk_tarjeta_cliente FOREIGN KEY (nro_cliente,nro_ca) REFERENCES Cliente_CA (nro_cliente,nro_ca)
);

CREATE TABLE Caja(
cod_caja	INTEGER(5) UNSIGNED NOT NULL AUTO_INCREMENT,

constraint pk_caja PRIMARY KEY (cod_caja)
);

CREATE TABLE Ventanilla(
cod_caja	INTEGER(5) UNSIGNED NOT NULL,
nro_suc		INTEGER(3) UNSIGNED NOT NULL,

constraint pk_ventanilla PRIMARY KEY (cod_caja),
constraint fk_ventanilla_caja FOREIGN KEY (cod_caja) REFERENCES Caja(cod_caja),
constraint fk_ventanilla_suc FOREIGN KEY (nro_suc) REFERENCES Sucursal (nro_suc)
);

CREATE TABLE ATM(
cod_caja		INTEGER(5) UNSIGNED NOT NULL, 
cod_postal		INTEGER(4) UNSIGNED NOT NULL, 
direccion		varchar(64) NOT NULL,

constraint pk_ATM PRIMARY KEY (cod_caja),
constraint fk_ATM_caja FOREIGN KEY (cod_caja) REFERENCES Caja(cod_caja),
constraint fk_ATM_ciudad FOREIGN KEY (cod_postal) REFERENCES Ciudad(cod_postal)

);

CREATE TABLE Transaccion(
nro_trans	INTEGER(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
fecha		DATE NOT NULL, 
hora		TIME NOT NULL, 
monto		DECIMAL(16,2) UNSIGNED NOT NULL,

constraint pk_transaccion PRIMARY KEY (nro_trans)
);

CREATE TABLE Debito(
nro_trans 	INTEGER(10) UNSIGNED NOT NULL,
descripcion TEXT,
nro_cliente	INTEGER(5) UNSIGNED NOT NULL,
nro_ca		INTEGER(5) UNSIGNED NOT NULL,

constraint pk_debito PRIMARY KEY(nro_trans),
constraint fk_debito_transaccion FOREIGN KEY (nro_trans ) REFERENCES Transaccion(nro_trans),
constraint fk_debito_cliente FOREIGN KEY (nro_cliente,nro_ca) REFERENCES Cliente_CA(nro_cliente,nro_ca)
);

CREATE TABLE Transaccion_por_caja(
nro_trans 	INTEGER(10) UNSIGNED NOT NULL,
cod_caja	INTEGER(5) UNSIGNED NOT NULL,

constraint pk_tpc PRIMARY KEY(nro_trans),
constraint fk_tpc_transaccion FOREIGN KEY (nro_trans ) REFERENCES Transaccion(nro_trans),
constraint fk_tpc_caja FOREIGN KEY (cod_caja) REFERENCES Caja (cod_caja)
);

CREATE TABLE Deposito(
nro_trans 	INTEGER(10) UNSIGNED NOT NULL,
nro_ca		INTEGER(5) UNSIGNED NOT NULL,

constraint pk_deposito PRIMARY KEY(nro_trans),
constraint fk_deposito_transaccion FOREIGN KEY (nro_trans ) REFERENCES Transaccion_por_caja(nro_trans),
constraint fk_deposito_caja_ahorro FOREIGN KEY (nro_ca) REFERENCES Caja_Ahorro (nro_ca)
);

CREATE TABLE Extraccion(
nro_trans 	INTEGER(10) UNSIGNED NOT NULL,
nro_cliente INTEGER(5) UNSIGNED NOT NULL,
nro_ca		INTEGER(5) UNSIGNED NOT NULL,

constraint pk_extraccion PRIMARY KEY(nro_trans),
constraint fk_extraccion_transaccion FOREIGN KEY (nro_trans ) REFERENCES Transaccion_por_caja(nro_trans),
constraint fk_extraccion_cliente FOREIGN KEY (nro_cliente,nro_ca) REFERENCES Cliente_CA(nro_cliente,nro_ca)
);

CREATE TABLE Transferencia(
nro_trans 	INTEGER(10) UNSIGNED NOT NULL,
nro_cliente INTEGER(5) UNSIGNED NOT NULL,
origen		INTEGER(8) UNSIGNED NOT NULL,
destino		INTEGER(8) UNSIGNED NOT NULL,

constraint pk_transferencia PRIMARY KEY(nro_trans),
constraint fk_transferencia_transaccion FOREIGN KEY (nro_trans ) REFERENCES Transaccion_por_caja(nro_trans),
constraint fk_transferencia_cliente FOREIGN KEY (nro_cliente,origen) REFERENCES Cliente_CA(nro_cliente,nro_ca),
constraint fk_transferencia_destino_caja_ahorro FOREIGN KEY (destino) REFERENCES Caja_Ahorro (nro_ca)
);

#---------------------------------------------------
#-----------Creacion de Stored Procedures-----------
#---------------------------------------------------
delimiter !

	
#Si retorna 0 entonces la ejecucion fue correcta.
#Si retorna 1 entonces la cuenta no fue encontrada o no existe.
#Si retorna 2 entonces la cuenta origen no tenia saldo suficiente.
#Si retorna 3 entonces se produjo un error de SQL.
#Si retorna 4 entonces no se encontro la tarjeta.
#Si retorna 5 entonces no se encontro la caja.
	
	#PROCEDIMIENTO PARA EXTRAER DINERO DE UNA CAJA 
	#Entrada: Numero de tarjeta, monto a extraer.
	#Salida: Codigo de error;
	create procedure extraccion(IN nro INT, IN monto INT,IN cajaUsada INT, OUT err INT)
	begin	
		# Declaro variables locales para recuperar los errores 
		DECLARE codigo_SQL  CHAR(5) DEFAULT '00000';	 
		DECLARE codigo_MYSQL INT DEFAULT 0;
		DECLARE mensaje_error TEXT;
		
		#Declaro variables locales
		declare saldoActual INT;
		declare fin boolean default false;
		declare saldoNuevo INT DEFAULT 0;
		declare fecha DATE;
		declare hora TIME;
		declare nro_c INT;
		declare caja INT;
		
		#Declaro el manejador de excepcion para SQLEXCEPTION
		DECLARE EXIT HANDLER FOR SQLEXCEPTION 	 	 
		BEGIN #En caso de una excepción SQLEXCEPTION retrocede la transacción y
         	# devuelve el código de error especifico de MYSQL (MYSQL_ERRNO), 
			GET DIAGNOSTICS CONDITION 1  codigo_MYSQL= MYSQL_ERRNO,  
										 codigo_SQL= RETURNED_SQLSTATE, 
										 mensaje_error= MESSAGE_TEXT;
			SELECT 'SQLEXCEPTION!, transaccion abortada' AS resultado, 	#Mensaje de error
					codigo_MySQL, codigo_SQL,  mensaje_error;
			set err=3;
			ROLLBACK;
		END;	
		IF (EXISTS (SELECT * FROM Caja WHERE cod_caja=cajaUsada))
		THEN
			IF(EXISTS(SELECT * FROM Tarjeta WHERE nro_tarjeta=nro))
			THEN
				select nro_ca into caja from Tarjeta where nro_tarjeta=nro;
				select nro_cliente into nro_c from Tarjeta where nro_tarjeta=nro;
				select curdate() into fecha;
				select curtime() into hora;
				#Controlo si el numero de caja es valido
				IF (EXISTS(SELECT * FROM caja_ahorro WHERE caja=nro_ca))
					THEN  #Existe la caja
					START TRANSACTION; #Comienza la transaccion
					SELECT saldo INTO saldoActual from caja_ahorro where nro_ca=caja FOR UPDATE;
					#Controlo que el saldo de la caja sea mayor que el monto que quiero retirar.
						if saldoActual>monto then
							SET saldoNuevo=saldoActual-monto; #Modifico el valor
							update caja_ahorro #Actualizo en la tabla
							SET saldo=saldoNuevo where nro_ca=caja;
							INSERT INTO Transaccion VALUES (default,fecha,hora,monto);
							INSERT INTO Transaccion_por_caja VALUES (LAST_INSERT_ID(),cajaUsada);
							INSERT INTO Extraccion VALUES (LAST_INSERT_ID(),nro_c,caja);
							SELECT 'La operacion Extraccion finalizo correctamente.' as Resultado; #Mensaje de operacion correcta
							SET err=0;
						else
							select 'El saldo es menor al monto.' as Error; #Mensaje de error
							set err=2;
						end if;
					COMMIT; #Finalizo la transaccion
				else
					set err=1;
					select 'No se encontro la caja de ahorro.' as Error;	#Mensaje de error
					
				end if;
			ELSE
				set err=4;
				select 'No se encontro la tarjeta' as Error; #Mensaje de error
			END IF;
		ELSE
			SET err=5;
			SELECT 'No se encontro la caja' AS Error; #Mensaje de error
		END IF;
	end; !
	
	#ESTE PROCEDIMIENTO ES LA TRANSFERENCIA PERO EJECUTADA DE FORMA ATOMICA, SE HACE UNA SOLA TRANSACCION, SI FALLA EN ALGUN PUNTO VUELVE ATRAS.
	#SE VERIFICA QUE SE CUMPLAN TODAS LAS CONDICIONES DESDE UN PRINCIPIO
	CREATE PROCEDURE transferencia(IN nro INT, IN destino INT, IN monto INT,IN cajaUsada INT, OUT err INT)
	BEGIN
		# Declaro variables locales para recuperar los errores 
		DECLARE codigo_SQL  CHAR(5) DEFAULT '00000';	 
		DECLARE codigo_MYSQL INT DEFAULT 0;
		DECLARE mensaje_error TEXT;
		
		#Declaro variables locales
		declare saldoActual INT;
		declare fin boolean default false;
		declare saldoNuevo INT DEFAULT 0;
		declare fecha DATE;
		declare hora TIME;
		declare nro_c INT;
		declare origen INT;
		
		#Declaro el manejador de excepcion para SQLEXCEPTION
		DECLARE EXIT HANDLER FOR SQLEXCEPTION 	 	 
		BEGIN #En caso de una excepción SQLEXCEPTION retrocede la transacción y
         	# devuelve el código de error especifico de MYSQL (MYSQL_ERRNO), 
			GET DIAGNOSTICS CONDITION 1  codigo_MYSQL= MYSQL_ERRNO,  
										 codigo_SQL= RETURNED_SQLSTATE, 
										 mensaje_error= MESSAGE_TEXT;
			SELECT 'SQLEXCEPTION!, transaccion abortada' AS resultado, 	#Mensaje de error
					codigo_MySQL, codigo_SQL,  mensaje_error;
			set err=3;
			ROLLBACK;
		END;	
		IF (EXISTS (SELECT * FROM Caja WHERE cod_caja=cajaUsada))
		THEN
			IF(EXISTS(SELECT * FROM Tarjeta WHERE nro_tarjeta=nro))
			THEN
				select nro_ca into origen from Tarjeta where nro_tarjeta=nro;
				select nro_cliente into nro_c from Tarjeta where nro_tarjeta=nro;
				select curdate() into fecha;
				select curtime() into hora;
				
				START TRANSACTION; #Comienza la transaccion
				#Controlo si el numero de caja origen es valido
				IF (EXISTS(SELECT * FROM caja_ahorro WHERE origen=nro_ca))
					THEN  #Existe la caja origen
					IF (EXISTS(SELECT * FROM caja_ahorro WHERE destino=nro_ca))
					THEN  #Existe la caja destino
						SELECT saldo INTO saldoActual from caja_ahorro where nro_ca=origen FOR UPDATE;
						#Controlo que el saldo de la caja sea mayor que el monto que quiero retirar.
						if saldoActual>monto then
							SET saldoNuevo=saldoActual-monto; #Modifico el valor
							update caja_ahorro #Actualizo en la tabla
							SET saldo=saldoNuevo where nro_ca=origen;
							SELECT saldo INTO saldoActual from caja_ahorro where nro_ca=destino;
							SET saldoNuevo=saldoActual+monto; #Modifico el valor
							update caja_ahorro #Actualizo en la tabla
							SET saldo=saldoNuevo where nro_ca=destino;
							INSERT INTO Transaccion VALUES (default,fecha,hora,monto);
							INSERT INTO Transaccion_por_caja VALUES (LAST_INSERT_ID(),cajaUsada);
							INSERT INTO Transferencia VALUES (LAST_INSERT_ID(),nro_c,origen,destino);
							
							#INGRESO EL DEPOSITO
							INSERT INTO Transaccion VALUES (default,fecha,hora,monto);
							INSERT INTO Transaccion_por_caja VALUES (LAST_INSERT_ID(),cajaUsada);
							INSERT INTO Deposito VALUES (LAST_INSERT_ID(),destino);
							SELECT 'La operacion Transferencia finalizo correctamente.' as Resultado; #Mensaje de operacion correcta
							set err=0;
						else
							select 'El saldo de la caja origen es menor al monto.' as Error; #Mensaje de error
							set err=2;
						end if;
					else
						set err=1;
						select 'No se encontro la caja de ahorro destino.' as Error;	#Mensaje de error
					end if;
				else
					set err=1;
					select 'No se encontro la caja de ahorro origen.' as Error;	#Mensaje de error
				end if;
				COMMIT; #Finalizo la transaccion	
				
			ELSE
				set err=4;
				select 'No se encontro la tarjeta' as Error; #Mensaje de error
			END IF;
		ELSE
			SET err=5;
			select 'No se encontro la caja' as Error; #Mensaje de error
		END IF;
	END; !

#---------------------------------------------------
#----------------Creación de Trigger----------------
#---------------------------------------------------
	
	CREATE TRIGGER pagoUpdate AFTER INSERT ON prestamo
	FOR EACH ROW
	BEGIN
		set @contador=0; 																										#Creo un contador para mantener el numero de pago
		while(@contador<NEW.cant_meses) do 																						#Mientras no haya ingresado todos los pagos de cada mes...
		INSERT INTO Pago VALUES (NEW.nro_prestamo,@contador+1,(select DATE(date_add(now(),interval @contador+1 month))),null);  #Inserto el pago en la tabla
		set @contador=@contador+1; 																								#Aumento el valor del contador
		end while;
	END; !

delimiter ;
#---------------------------------------------------
#---------------Creación de Vistas------------------
#---------------------------------------------------
	
	#---------------------------Vista de debito---------------------	
	CREATE VIEW debito_v AS
	select distinct nro_trans,fecha,hora,monto,"Debito" as Tipo,nro_ca,"-" as cod_caja,"-" as destino,saldo,nro_cliente,tipo_doc,nro_doc,nombre,apellido from transaccion 
	natural join debito
	natural join cliente
	natural join caja_ahorro;
	
	#--------------------------Vista de deposito--------------------	
	CREATE VIEW deposito_v AS
	select distinct nro_trans,fecha,hora,monto,"Deposito" as Tipo,nro_ca,cod_caja,"-" as destino,saldo,"-" as nro_cliente,"-" as tipo_doc,"-" as nro_doc,"-" as nombre,"-" as apellido from transaccion 
	natural join transaccion_por_caja 
	natural join deposito
	natural join caja_ahorro;
	
	#------------------------Vista de extraccion--------------------		
	CREATE VIEW extraccion_v AS
	select distinct nro_trans,fecha,hora,monto,"Extraccion" as Tipo,nro_ca,cod_caja,"-" as destino,saldo,nro_cliente,tipo_doc,nro_doc,nombre,apellido from transaccion 
	natural join transaccion_por_caja 
	natural join extraccion
	natural join cliente 
	natural join Cliente_CA 
	natural join caja_ahorro;
	
	#-----------------------Vista de Transferencia------------------
	CREATE VIEW transferencia_v AS
	select distinct nro_trans,fecha,hora,monto,"Transferencia" as Tipo,origen as nro_ca,cod_caja,destino,saldo,nro_cliente,tipo_doc,nro_doc,nombre,apellido from transaccion 
	natural join transaccion_por_caja  
	natural join transferencia
	natural join Cliente_CA 
	natural join caja_ahorro
	natural join cliente 
	where origen=nro_ca;
	
	#---------------------------Vista General-----------------------
	CREATE VIEW trans_cajas_ahorro AS 
	SELECT * FROM debito_v UNION SELECT * FROM deposito_v UNION SELECT * FROM extraccion_v UNION SELECT * FROM transferencia_v ORDER BY nro_trans;
	


	
#---------------------------------------------------
#---------------Creación de usuarios----------------
#---------------------------------------------------


#------------------Administrador--------------------
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON banco.* TO 'admin'@'localhost' WITH GRANT OPTION;

#Para poder crear usuarios debo darle el permiso de crear usuarios en las tablas de mysql, por eso uso *.*

GRANT CREATE USER ON *.* TO 'admin'@'localhost' WITH GRANT OPTION;
#Le otorgo permisos para realizar flush
GRANT RELOAD ON *.* TO 'admin'@'localhost' WITH GRANT OPTION;
#-------------------Empleado------------------------

CREATE USER empleado@'%' IDENTIFIED BY 'empleado';
GRANT SELECT ON banco.Empleado TO empleado@'%';
GRANT SELECT ON banco.Sucursal TO empleado@'%';
GRANT SELECT ON banco.Tasa_Plazo_Fijo TO empleado@'%';
GRANT SELECT ON banco.Tasa_Prestamo TO empleado@'%';

GRANT SELECT,INSERT ON banco.Prestamo TO empleado@'%'; 
GRANT SELECT,INSERT ON banco.Plazo_Fijo TO empleado@'%';
GRANT SELECT,INSERT ON banco.Plazo_Cliente TO empleado@'%';
GRANT SELECT,INSERT ON banco.Caja_Ahorro TO empleado@'%';
GRANT SELECT,INSERT ON banco.Tarjeta TO empleado@'%';

GRANT SELECT,INSERT,UPDATE ON banco.Cliente_CA TO empleado@'%';
GRANT SELECT,INSERT,UPDATE  ON banco.Cliente TO empleado@'%';
GRANT SELECT,INSERT,UPDATE ON banco.Pago TO empleado@'%';


CREATE USER atm@'%' IDENTIFIED BY 'atm';
GRANT SELECT ON banco.trans_cajas_ahorro TO atm@'%';
GRANT SELECT,UPDATE ON banco.Tarjeta TO atm@'%';
GRANT EXECUTE ON PROCEDURE banco.extraccion TO atm@'%';
GRANT EXECUTE ON PROCEDURE banco.transferencia TO atm@'%';

FLUSH PRIVILEGES;
















