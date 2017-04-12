DROP SCHEMA IF EXISTS computer_shop;
CREATE SCHEMA computer_shop;

USE computer_shop;


/*********************************************
		TABLES
*********************************************/

CREATE TABLE `assembler_task`
(
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT ,
	`order_id` BIGINT UNSIGNED NOT NULL,
	`assembly_parcel_id` BIGINT UNSIGNED NOT NULL,
	`assembler_id` BIGINT UNSIGNED,
	`task_type` ENUM ('ASSEMBLE', 'DISASSEMBLE') NOT NULL,
	`count` BIGINT UNSIGNED NOT NULL,
	`done_count` BIGINT UNSIGNED NOT NULL DEFAULT 0,
	`done_date` DATE,
	CONSTRAINT `PK_assembler_task` PRIMARY KEY (`id`)
)
;

CREATE TABLE `assembly_component`
(
	`order_id` BIGINT UNSIGNED NOT NULL,
	`assembly_id` BIGINT UNSIGNED NOT NULL,
	`component_id` BIGINT UNSIGNED NOT NULL,
	`count` BIGINT UNSIGNED NOT NULL,
	CONSTRAINT `PK_assembly_component` PRIMARY KEY (`order_id`,`assembly_id`,`component_id`)
)
;

CREATE TABLE `assembly_parcel`
(
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT ,
	`order_id` BIGINT UNSIGNED NOT NULL,
	`cost` BIGINT UNSIGNED NOT NULL,
	`count` BIGINT UNSIGNED NOT NULL,
	`done_count` BIGINT UNSIGNED NOT NULL DEFAULT 0,
	`canceled` BIT NOT NULL DEFAULT FALSE,
	CONSTRAINT `PK_order_assembly` PRIMARY KEY (`id`,`order_id`)
)
;

CREATE TABLE `component_model`
(
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT ,
	`type_id` BIGINT UNSIGNED NOT NULL,
	`name` VARCHAR(255) NOT NULL,
	`description` TEXT NOT NULL,
	CONSTRAINT `PK_component` PRIMARY KEY (`id`)
)
;

CREATE TABLE `component_store`
(
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT ,
	`model_id` BIGINT UNSIGNED NOT NULL,
	`price` INT UNSIGNED,
	`count` INT UNSIGNED NOT NULL,
	CONSTRAINT `PK_product` PRIMARY KEY (`id`)
)
;

CREATE TABLE `component_type`
(
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT ,
	`name` VARCHAR(255) NOT NULL,
	`description` TEXT,
	CONSTRAINT `PK_component_type` PRIMARY KEY (`id`)
)
;

CREATE TABLE `customer`
(
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT ,
	`name` VARCHAR(255) NOT NULL,
	`description` TEXT,
	CONSTRAINT `PK_customer` PRIMARY KEY (`id`)
)
;

CREATE TABLE `employee_auth`
(
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT ,
	`role` ENUM ('RECEIVER', 'ASSEMBLER', 'MANAGER', 'DIRECTOR', 'ADMIN') NOT NULL,
	`email` VARCHAR(255) NOT NULL,
	`pass_hash` VARCHAR(60) NOT NULL,
	`blocked` BIT NOT NULL DEFAULT FALSE,
	`deleted` BIT NOT NULL DEFAULT FALSE,
	CONSTRAINT `PK_employee` PRIMARY KEY (`id`)
)
;

CREATE TABLE `employee_info`
(
	`id` BIGINT UNSIGNED NOT NULL,
	`auth_id` BIGINT UNSIGNED NOT NULL,
	`first_name` VARCHAR(255) NOT NULL,
	`last_name` VARCHAR(255),
	`patronymic` VARCHAR(255),
	`phone` VARCHAR(50),
	CONSTRAINT `PK_employee_info` PRIMARY KEY (`id`)
)
;

CREATE TABLE `export`
(
	`id` BIGINT NOT NULL,
	`order_id` BIGINT UNSIGNED NOT NULL,
	`exp_date` DATETIME(0) NOT NULL,
	CONSTRAINT `PK_export` PRIMARY KEY (`id`)
)
;

CREATE TABLE `import`
(
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT ,
	`provider_id` BIGINT UNSIGNED NOT NULL,
	`date_time` DATETIME(0) NOT NULL,
	`count` INT UNSIGNED NOT NULL,
	`model_id` BIGINT UNSIGNED NOT NULL,
	`purchase_price` INT UNSIGNED NOT NULL,
	`price` INT UNSIGNED NOT NULL,
	`status` ENUM ('REGISTERED', 'FINISHED') NOT NULL,
	CONSTRAINT `PK_import` PRIMARY KEY (`id`)
)
;

CREATE TABLE `inventory`
(
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT ,
	`st_date` DATETIME(0) NOT NULL,
	`saldo` BIGINT NOT NULL,
	CONSTRAINT `PK_stocktaking` PRIMARY KEY (`id`)
)
;

CREATE TABLE `inventory_item`
(
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT ,
	`stocktaking_id` BIGINT UNSIGNED NOT NULL,
	`component_id` BIGINT UNSIGNED NOT NULL,
	`real_count` INT UNSIGNED NOT NULL,
	CONSTRAINT `PK_inventory_item` PRIMARY KEY (`id`)
)
;

CREATE TABLE `order`
(
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT ,
	`customer_id` BIGINT UNSIGNED NOT NULL,
	`cost` INT UNSIGNED NOT NULL,
	`ord_date` DATETIME(0) NOT NULL,
	`status` ENUM ('IN_PROGRESS', 'READY', 'FINISHED', 'CANCELED') NOT NULL,
	CONSTRAINT `PK_order` PRIMARY KEY (`id`)
)
;

CREATE TABLE `order_component`
(
	`order_id` BIGINT UNSIGNED NOT NULL,
	`component_id` BIGINT UNSIGNED NOT NULL,
	`count` INT UNSIGNED NOT NULL
)
;

CREATE TABLE `provider`
(
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT ,
	`name` VARCHAR(255) NOT NULL,
	`description` TEXT,
	CONSTRAINT `PK_provider` PRIMARY KEY (`id`)
)
;


/*********************************************
		INDEXES
*********************************************/

ALTER TABLE `assembly_component` 
 ADD INDEX `IXFK_assembly_component_assembly` (`component_id` ASC)
;

ALTER TABLE `assembly_component` 
 ADD INDEX `IXFK_assembly_id` (`assembly_id` ASC)
;

ALTER TABLE `employee_auth` 
 ADD CONSTRAINT `UQ_email` UNIQUE (`email`)
;

ALTER TABLE `employee_info` 
 ADD CONSTRAINT `UQ_auth` UNIQUE (`auth_id`)
;


/*********************************************
		CONSTRAINTS
*********************************************/

SET FOREIGN_KEY_CHECKS=0
;

ALTER TABLE `export` 
 ADD CONSTRAINT `FK_export_order`
	FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `order` 
 ADD CONSTRAINT `FK_order_customer`
	FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `employee_info` 
 ADD CONSTRAINT `FK_employee_info_employee_auth`
	FOREIGN KEY (`auth_id`) REFERENCES `employee_auth` (`id`) ON DELETE Cascade ON UPDATE Restrict
;

ALTER TABLE `component_model` 
 ADD CONSTRAINT `FK_component_component_type`
	FOREIGN KEY (`type_id`) REFERENCES `component_type` (`id`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `import` 
 ADD CONSTRAINT `FK_import_provider`
	FOREIGN KEY (`provider_id`) REFERENCES `provider` (`id`) ON DELETE Restrict ON UPDATE Restrict,
 ADD CONSTRAINT `FK_import_component_model`
	FOREIGN KEY (`model_id`) REFERENCES `component_model` (`id`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `component_store` 
 ADD CONSTRAINT `FK_product_component`
	FOREIGN KEY (`model_id`) REFERENCES `component_model` (`id`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `inventory_item` 
 ADD CONSTRAINT `FK_inventory_item_stocktaking`
	FOREIGN KEY (`stocktaking_id`) REFERENCES `inventory` (`id`) ON DELETE Restrict ON UPDATE Restrict,
 ADD CONSTRAINT `FK_inventory_item_component`
	FOREIGN KEY (`component_id`) REFERENCES `component_store` (`id`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `order_component` 
 ADD CONSTRAINT `FK_order_product_order`
	FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE Restrict ON UPDATE Restrict,
 ADD CONSTRAINT `FK_order_product_product`
	FOREIGN KEY (`component_id`) REFERENCES `component_store` (`id`) ON DELETE Restrict ON UPDATE Restrict
;
ALTER TABLE `assembly_parcel` 
 ADD CONSTRAINT `FK_assembly_parcel_order`
	FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `assembly_component` 
 ADD CONSTRAINT `FK_assembly_component_component`
	FOREIGN KEY (`component_id`) REFERENCES `component_store` (`id`) ON DELETE Restrict ON UPDATE Restrict,
 ADD CONSTRAINT `FK_assembly_component_assembly_parcel`
	FOREIGN KEY (`assembly_id`,`order_id`) REFERENCES `assembly_parcel` (`id`,`order_id`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `assembler_task` 
 ADD CONSTRAINT `FK_assembler_task_employee_auth`
	FOREIGN KEY (`assembler_id`) REFERENCES `employee_auth` (`id`) ON DELETE Restrict ON UPDATE Restrict,
 ADD CONSTRAINT `FK_assembler_task_assembly_parcel`
	FOREIGN KEY (`order_id`, `assembly_parcel_id`) REFERENCES `assembly_parcel` (`order_id`, `id`) ON DELETE Restrict ON UPDATE Restrict
;

SET FOREIGN_KEY_CHECKS=1
;


/*********************************************
		USER
*********************************************/

DROP USER IF EXISTS `cs_admin`@'localhost';
CREATE USER `cs_admin`@'localhost' IDENTIFIED BY  'passwd';
GRANT SELECT, INSERT, UPDATE, DELETE ON `computer_shop`.* TO `cs_admin`@'localhost';
FLUSH PRIVILEGES;
