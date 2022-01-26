create database user;
use userdb;

CREATE TABLE `users`
(
    `id`              BigInt(12)      NOT NULL AUTO_INCREMENT,                                                                                                                                                                            
    `nombre`          varchar(255)    NOT NULL,                                                                                                                                                                         
    `apellido`        varchar(255)    NOT NULL,                                                                                                                                                                        
    `mail`            varchar(255)    NOT NULL,                                                                                                                                                                        
    `password`     	  double          NOT NULL, 
	`fechaAlta`       date            NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 16
  DEFAULT CHARSET = utf8mb4;

SELECT date_format(fechaAlta, "%d/%m/%Y") as fecha_formateada from users;
#Para formatear la fecha de LocalDate


# Sentencia para borrar la tabla users
# drop table users;

# Sentencia para seleccionar todos los registros de la base de datos
# select *
# from users;
