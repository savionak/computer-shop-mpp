-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema computer_shop
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `computer_shop` ;

-- -----------------------------------------------------
-- Schema computer_shop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `computer_shop` DEFAULT CHARACTER SET utf8 ;
USE `computer_shop` ;

-- -----------------------------------------------------
-- Table `computer_shop`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`customer` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `computer_shop`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`order` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `customer_id` BIGINT UNSIGNED NOT NULL,
  `cost` INT UNSIGNED NOT NULL DEFAULT 0,
  `ord_date` DATETIME NOT NULL DEFAULT NOW(),
  `status` ENUM('IN_PROGRESS', 'FINISHED') NOT NULL DEFAULT 'IN_PROGRESS',
  `canceled` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_order_customer`
    FOREIGN KEY (`customer_id`)
    REFERENCES `computer_shop`.`customer` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `FK_order_customer` ON `computer_shop`.`order` (`customer_id` ASC);


-- -----------------------------------------------------
-- Table `computer_shop`.`assembly`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`assembly` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `order_id` BIGINT UNSIGNED NOT NULL,
  `cost` INT UNSIGNED NOT NULL DEFAULT 0,
  `count` INT UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_assembly_parcel_order`
    FOREIGN KEY (`order_id`)
    REFERENCES `computer_shop`.`order` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `FK_assembly_parcel_order` ON `computer_shop`.`assembly` (`order_id` ASC);


-- -----------------------------------------------------
-- Table `computer_shop`.`component_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`component_type` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `computer_shop`.`component_model`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`component_model` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `type_id` BIGINT UNSIGNED NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_component_component_type`
    FOREIGN KEY (`type_id`)
    REFERENCES `computer_shop`.`component_type` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `UQ_name` ON `computer_shop`.`component_model` (`name` ASC);

CREATE INDEX `FK_component_component_type` ON `computer_shop`.`component_model` (`type_id` ASC);


-- -----------------------------------------------------
-- Table `computer_shop`.`component_store`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`component_store` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `model_id` BIGINT UNSIGNED NOT NULL,
  `price` INT UNSIGNED NULL DEFAULT NULL,
  `count` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_product_component`
    FOREIGN KEY (`model_id`)
    REFERENCES `computer_shop`.`component_model` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `FK_product_component` ON `computer_shop`.`component_store` (`model_id` ASC);

CREATE UNIQUE INDEX `UQ_price_model` ON `computer_shop`.`component_store` (`price` ASC, `model_id` ASC);


-- -----------------------------------------------------
-- Table `computer_shop`.`assembly_component`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`assembly_component` (
  `assembly_id` BIGINT UNSIGNED NOT NULL,
  `component_id` BIGINT UNSIGNED NOT NULL,
  `count` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`assembly_id`, `component_id`),
  CONSTRAINT `FK_assembly_component_assembly_parcel`
    FOREIGN KEY (`assembly_id`)
    REFERENCES `computer_shop`.`assembly` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_assembly_component_component`
    FOREIGN KEY (`component_id`)
    REFERENCES `computer_shop`.`component_store` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `IXFK_component_id` ON `computer_shop`.`assembly_component` (`component_id` ASC);


-- -----------------------------------------------------
-- Table `computer_shop`.`clientdetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`clientdetails` (
  `appId` VARCHAR(255) NOT NULL,
  `resourceIds` VARCHAR(255) NULL DEFAULT NULL,
  `appSecret` VARCHAR(255) NULL DEFAULT NULL,
  `scope` VARCHAR(255) NULL DEFAULT NULL,
  `grantTypes` VARCHAR(255) NULL DEFAULT NULL,
  `redirectUrl` VARCHAR(255) NULL DEFAULT NULL,
  `authorities` VARCHAR(255) NULL DEFAULT NULL,
  `access_token_validity` INT(11) NULL DEFAULT NULL,
  `refresh_token_validity` INT(11) NULL DEFAULT NULL,
  `additionalInformation` VARCHAR(4096) NULL DEFAULT NULL,
  `autoApproveScopes` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`appId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `computer_shop`.`employee_auth`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`employee_auth` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `pass_hash` VARCHAR(60) NOT NULL,
  `role` ENUM('MANAGER', 'DIRECTOR', 'ADMIN') NOT NULL,
  `blocked` TINYINT(1) NOT NULL DEFAULT FALSE,
  `deleted` TINYINT(1) NOT NULL DEFAULT FALSE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `UQ_email` ON `computer_shop`.`employee_auth` (`email` ASC);


-- -----------------------------------------------------
-- Table `computer_shop`.`employee_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`employee_info` (
  `id` BIGINT UNSIGNED NOT NULL,
  `auth_id` BIGINT UNSIGNED NOT NULL,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `patronymic` VARCHAR(255) NULL DEFAULT NULL,
  `phone` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_employee_info_employee_auth`
    FOREIGN KEY (`auth_id`)
    REFERENCES `computer_shop`.`employee_auth` (`id`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `UQ_auth` ON `computer_shop`.`employee_info` (`auth_id` ASC);


-- -----------------------------------------------------
-- Table `computer_shop`.`export`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`export` (
  `id` BIGINT NOT NULL,
  `order_id` BIGINT UNSIGNED NOT NULL,
  `exp_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_export_order`
    FOREIGN KEY (`order_id`)
    REFERENCES `computer_shop`.`order` (`id`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `FK_export_order` ON `computer_shop`.`export` (`order_id` ASC);


-- -----------------------------------------------------
-- Table `computer_shop`.`provider`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`provider` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `computer_shop`.`import`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`import` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `provider_id` BIGINT UNSIGNED NOT NULL,
  `model_id` BIGINT UNSIGNED NOT NULL,
  `date_time` DATETIME NOT NULL,
  `count` INT UNSIGNED NOT NULL,
  `purchase_price` INT UNSIGNED NOT NULL,
  `price` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_import_component_model`
    FOREIGN KEY (`model_id`)
    REFERENCES `computer_shop`.`component_model` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_import_provider`
    FOREIGN KEY (`provider_id`)
    REFERENCES `computer_shop`.`provider` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `FK_import_provider` ON `computer_shop`.`import` (`provider_id` ASC);

CREATE INDEX `FK_import_component_model` ON `computer_shop`.`import` (`model_id` ASC);


-- -----------------------------------------------------
-- Table `computer_shop`.`oauth_access_token`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`oauth_access_token` (
  `token_id` VARCHAR(256) NULL DEFAULT NULL,
  `token` BLOB NULL DEFAULT NULL,
  `authentication_id` VARCHAR(256) NULL DEFAULT NULL,
  `user_name` VARCHAR(256) NULL DEFAULT NULL,
  `client_id` VARCHAR(256) NULL DEFAULT NULL,
  `authentication` BLOB NULL DEFAULT NULL,
  `refresh_token` VARCHAR(256) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `computer_shop`.`oauth_refresh_token`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`oauth_refresh_token` (
  `token_id` VARCHAR(256) NULL DEFAULT NULL,
  `token` BLOB NULL DEFAULT NULL,
  `authentication` BLOB NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `computer_shop` ;

-- -----------------------------------------------------
-- procedure recount_assembly_components
-- -----------------------------------------------------

DELIMITER $$
USE `computer_shop`$$
CREATE PROCEDURE recount_assembly_components(
	IN asm_id BIGINT UNSIGNED,
    IN old_count INT UNSIGNED,
    IN new_count INT UNSIGNED
)
BEGIN
	DECLARE EXIT HANDLER FOR SQLEXCEPTION BEGIN
		SET @updating_assembly_count = FALSE;
        RESIGNAL;
    END;
    
    SET @updating_assembly_count = TRUE;
    
    SET @old_asm_count = old_count;
	SET @new_asm_count = new_count;
	
	-- Activate triggers for components
	UPDATE `assembly_component`
	SET `count` = `count`
	WHERE `assembly_id` = asm_id;
	    
	SET @old_asm_count = NULL;
	SET @new_asm_count = NULL;
    
    SET @updating_assembly_count = FALSE;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure cancel_order
-- -----------------------------------------------------

DELIMITER $$
USE `computer_shop`$$
CREATE PROCEDURE cancel_order(
	IN ord_id BIGINT UNSIGNED
)
BEGIN
	DECLARE order_canceled BOOLEAN DEFAULT TRUE;
    
    SELECT `canceled`
    INTO order_canceled
    FROM `order`
    WHERE `id` = ord_id;
    
	IF (NOT order_canceled)
	THEN
		UPDATE `component_store` AS store
		JOIN `assembly_component` AS comp
			ON comp.`component_id` = store.`id`
		JOIN `assembly` AS asm
			ON comp.`assembly_id` = asm.`id`
		SET store.`count` = store.`count` + (comp.`count` * asm.`count`)
		WHERE asm.`order_id` = ord_id;
        
        UPDATE `order`
		SET `order`.`canceled` = TRUE
        WHERE `id` = ord_id;
	END IF;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure renew_order
-- -----------------------------------------------------

DELIMITER $$
USE `computer_shop`$$
CREATE PROCEDURE renew_order(
	IN ord_id BIGINT UNSIGNED
)
BEGIN
	DECLARE order_canceled BOOLEAN DEFAULT FALSE;

	DECLARE EXIT HANDLER FOR SQLSTATE '22003'	-- `component_store`.`count` out of range: < 0
		SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'Not enough components available to renew order.';
    
    SELECT `canceled`
    INTO order_canceled
    FROM `order`
    WHERE `id` = ord_id;
    
	IF (order_canceled)
	THEN
		UPDATE `component_store` AS store
		JOIN `assembly_component` AS comp
			ON comp.`component_id` = store.`id`
		JOIN `assembly` AS asm
			ON comp.`assembly_id` = asm.`id`
		SET store.`count` = store.`count` - (comp.`count` * asm.`count`)
		WHERE asm.`order_id` = ord_id;
        
        UPDATE `order`
		SET `order`.`canceled` = FALSE
        WHERE `id` = ord_id;
	END IF;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure update_store_price
-- -----------------------------------------------------

DELIMITER $$
USE `computer_shop`$$
CREATE PROCEDURE update_store_price(
	IN store_id BIGINT UNSIGNED,
    IN new_price INT UNSIGNED,
    IN new_count INT UNSIGNED
)
BEGIN
/*	DECLARE in_assembly BOOLEAN DEFAULT FALSE; */
	DECLARE s_model_id BIGINT UNSIGNED DEFAULT NULL;
	DECLARE s_count INT UNSIGNED DEFAULT 0;
	DECLARE left_count INT UNSIGNED DEFAULT 0;
	DECLARE target_id BIGINT UNSIGNED DEFAULT NULL;
    /*
	SELECT EXISTS (
		SELECT 1 FROM `assembly_component`
		WHERE `component_id` = store_id
	)
	INTO in_assembly;
    */
    SELECT `model_id`, `count`
    INTO s_model_id, s_count
    FROM `component_store`
    WHERE `id` = store_id;
    
    SELECT `id`
    INTO target_id
    FROM `component_store`
    WHERE `price` = new_price
		AND `model_id` = s_model_id;
    
    IF (new_count > s_count)
    THEN
		SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'Cannot update price: not enough components';
    END IF;
    
    SET left_count = s_count - new_count;
    
    IF (target_id IS NULL)
    THEN
		INSERT INTO `component_store`
		(`model_id`, `price`, `count`)
		VALUE
		(s_model_id, new_price, new_count);
    ELSE	-- has target
		UPDATE `component_store`
		SET `count` = `count` + new_count
		WHERE `id` = target_id;
	END IF;
    
    UPDATE `component_store`
	SET `count` = left_count
	WHERE `id` = store_id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure remove_assembly
-- -----------------------------------------------------

DELIMITER $$
USE `computer_shop`$$
CREATE PROCEDURE remove_assembly(
	IN asm_id BIGINT UNSIGNED
)
BEGIN
	DELETE FROM `assembly_component`
    WHERE `assembly_id` = asm_id;
    
    DELETE FROM `assembly`
    WHERE `id` = asm_id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure remove_order
-- -----------------------------------------------------

DELIMITER $$
USE `computer_shop`$$
CREATE PROCEDURE remove_order(
	IN ord_id BIGINT UNSIGNED
)
BEGIN
	DECLARE asm_id BIGINT UNSIGNED DEFAULT NULL;
	DECLARE done BOOLEAN DEFAULT FALSE;
	DECLARE asm_cur CURSOR FOR
		SELECT `id`
        FROM `assembly`
        WHERE `order_id` = ord_id;
    
    DECLARE CONTINUE HANDLER FOR NOT FOUND
		SET done = TRUE;
	
    OPEN asm_cur;
    FETCH asm_cur INTO asm_id;
    WHILE NOT done DO
		CALL remove_assembly(asm_id);
		FETCH asm_cur INTO asm_id;
    END WHILE;
    CLOSE asm_cur;
    
    DELETE FROM `order`
	WHERE `id` = ord_id;
END$$

DELIMITER ;
USE `computer_shop`;

DELIMITER $$
USE `computer_shop`$$
CREATE DEFINER = CURRENT_USER TRIGGER `computer_shop`.`order_BEFORE_INSERT`
BEFORE INSERT ON `order`
FOR EACH ROW
BEGIN
	IF (NEW.`status` = 'CANCELED')
    THEN
		SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'Cannot insert canceled order';
    END IF;
END$$

USE `computer_shop`$$
CREATE DEFINER = CURRENT_USER TRIGGER `computer_shop`.`assembly_BEFORE_INSERT`
BEFORE INSERT ON `assembly`
FOR EACH ROW
BEGIN
	DECLARE order_canceled BOOLEAN DEFAULT TRUE;
    
    SELECT `canceled`
    INTO order_canceled
    FROM `order`
    WHERE `id` = NEW.`order_id`;
    
	IF (order_canceled)
    THEN
		SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'Cannot add assembly to canceled order';
    END IF;
END$$

USE `computer_shop`$$
CREATE DEFINER = CURRENT_USER TRIGGER `computer_shop`.`assembly_BEFORE_UPDATE`
BEFORE UPDATE ON `assembly`
FOR EACH ROW
BEGIN
	DECLARE order_canceled BOOLEAN DEFAULT TRUE;
    
    SELECT `canceled`
    INTO order_canceled
    FROM `order`
    WHERE `id` = NEW.`order_id`;
    
	IF (order_canceled)
	THEN
		SIGNAL SQLSTATE '01000'
			SET MESSAGE_TEXT = 'Updating assembly of canceled order is not recommended.';
	END IF;
    
	IF (OLD.`count` != NEW.`count`)
	THEN   
        CALL recount_assembly_components(OLD.`id`, OLD.`count`, NEW.`count`);
	END IF;
    
    UPDATE `order`
	SET `cost` = `cost` - (OLD.`count` * OLD.`cost`)
	WHERE `id` = OLD.`order_id`;
    
    UPDATE `order`
	SET `cost` = `cost` + (NEW.`count` * NEW.`cost`)
	WHERE `id` = NEW.`order_id`;    
END$$

USE `computer_shop`$$
CREATE DEFINER = CURRENT_USER TRIGGER `computer_shop`.`assembly_component_BEFORE_INSERT`
BEFORE INSERT ON `assembly_component`
FOR EACH ROW
BEGIN
	DECLARE asm_count INT UNSIGNED DEFAULT 0;
    DECLARE order_canceled BOOLEAN DEFAULT TRUE;
	DECLARE s_price INT UNSIGNED DEFAULT NULL;
	DECLARE stored_count INT UNSIGNED DEFAULT 0;
	DECLARE new_count INT UNSIGNED DEFAULT 0;

	SELECT `count`, `canceled`
	INTO asm_count, order_canceled
	FROM `assembly`
    JOIN `order`
		ON `order`.`id` = `assembly`.`order_id`
	WHERE `assembly`.`id` = NEW.`assembly_id`;
	
    SELECT `count`, `price`
	INTO stored_count, s_price
	FROM `component_store`
	WHERE `id` = NEW.`component_id`;
	
    IF (s_price IS NULL)
    THEN
		SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'Cannot use components without price';
    END IF;
    
	IF (NOT order_canceled)
	THEN
		SET new_count = asm_count * NEW.`count`;

		IF (stored_count >= new_count)
		THEN
			UPDATE `component_store`
			SET `count` = stored_count - new_count
			WHERE `id` = NEW.`component_id`;
			
			UPDATE `assembly`
			SET `cost` = `cost` + (s_price * NEW.`count`)
			WHERE `id` = NEW.`assembly_id`;
		ELSE
			SIGNAL SQLSTATE '45000'
				SET MESSAGE_TEXT = 'Not enough components available';
		END IF;
	END IF;
END$$

USE `computer_shop`$$
CREATE DEFINER = CURRENT_USER TRIGGER `computer_shop`.`assembly_component_BEFORE_UPDATE`
BEFORE UPDATE ON `assembly_component`
FOR EACH ROW
BEGIN
	DECLARE stored_count INT UNSIGNED DEFAULT 0;
	DECLARE s_price INT UNSIGNED DEFAULT 0;
    DECLARE temp_stored_count INT UNSIGNED DEFAULT 0;
    DECLARE asm_count INT UNSIGNED DEFAULT 0;
    DECLARE old_count INT UNSIGNED DEFAULT 0;
    DECLARE new_count INT UNSIGNED DEFAULT 0;
	DECLARE order_canceled BOOLEAN DEFAULT TRUE;
    
	SELECT `count`, `canceled`
	INTO asm_count, order_canceled
	FROM `assembly`
    JOIN `order`
		ON `order`.`id` = `assembly`.`order_id`
	WHERE `assembly`.`id` = OLD.`assembly_id`;
	
	SELECT `count`, `price`
	INTO stored_count, s_price
	FROM `component_store`
	WHERE `id` = NEW.`component_id`;

	IF (NOT @updating_assembly_count
		OR @updating_assembly_count IS NULL)
	THEN
		SET @old_asm_count = asm_count;
		SET @new_asm_count = asm_count;
	END IF;
	
	SET old_count = @old_asm_count * OLD.`count`;
	SET temp_stored_count = stored_count + old_count;
	SET new_count = @new_asm_count * NEW.`count`;

	IF (NOT order_canceled)
	THEN
		IF (temp_stored_count >= new_count)
		THEN
			UPDATE `component_store`
			SET `count` = temp_stored_count - new_count
			WHERE `id` = NEW.`component_id`;
		ELSE
			SIGNAL SQLSTATE '45000'
				SET MESSAGE_TEXT = 'Not enough components available';
		END IF;
    END IF;
	
	IF (NOT @updating_assembly_count
		OR @updating_assembly_count IS NULL)
	THEN
		SET @new_asm_count = NULL;
		SET @old_asm_count = NULL;
		
		UPDATE `assembly`
		SET `cost` = `cost` + (s_price * NEW.`count`) - (s_price * OLD.`count`);
	END IF;
END$$

USE `computer_shop`$$
CREATE DEFINER = CURRENT_USER TRIGGER `computer_shop`.`assembly_component_AFTER_DELETE`
AFTER DELETE ON `assembly_component`
FOR EACH ROW
BEGIN
	DECLARE asm_count INT UNSIGNED DEFAULT 0;
    DECLARE s_price INT UNSIGNED DEFAULT 0;
    DECLARE back_count INT UNSIGNED DEFAULT 0;
	DECLARE order_canceled BOOLEAN DEFAULT TRUE;
    
	SELECT `count`, `canceled`
	INTO asm_count, order_canceled
	FROM `assembly`
    JOIN `order`
		ON `order`.`id` = `assembly`.`order_id`
	WHERE `assembly`.`id` = OLD.`assembly_id`;
	
	IF (NOT order_canceled)
	THEN
		SET back_count = asm_count * OLD.`count`;

		UPDATE `component_store`
		SET `count` = `count` + back_count
		WHERE `id` = OLD.`component_id`;
	END IF;

	SELECT `price`
	INTO s_price
	FROM `component_store`
	WHERE `id` = OLD.`component_id`;

	UPDATE `assembly`
	SET `cost` = `cost` - (s_price * OLD.`count`)
	WHERE `id` = OLD.`assembly_id`;
END$$

USE `computer_shop`$$
CREATE DEFINER = CURRENT_USER TRIGGER `computer_shop`.`employee_auth_AFTER_DELETE` AFTER DELETE ON `employee_auth` FOR EACH ROW
BEGIN
	IF (
    (
		SELECT COUNT(1)
		FROM `employee_auth`
		WHERE `role` = 'ADMIN'
	) = 0)
    THEN
		SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'Cannot remove last ADMIN';
    END IF;
END$$

USE `computer_shop`$$
CREATE DEFINER = CURRENT_USER TRIGGER `computer_shop`.`import_AFTER_INSERT`
AFTER INSERT ON `computer_shop`.`import`
FOR EACH ROW
BEGIN
	DECLARE store_id BIGINT UNSIGNED DEFAULT NULL;
	
	SELECT `id`
    INTO store_id
    FROM `component_store`
    WHERE `model_id` = NEW.`model_id`
		AND `price` = NEW.`price`;
	
    IF (NOT store_id IS NULL)
    THEN
		UPDATE `component_store`
        SET `count` = `count` + NEW.`count`
        WHERE `id` = store_id;
    ELSE
		INSERT INTO `component_store`
        (`model_id`, `price`, `count`)
        VALUE
        (NEW.`model_id`, NEW.`price`, NEW.`count`);
    END IF;
END$$

USE `computer_shop`$$
CREATE DEFINER = CURRENT_USER TRIGGER `computer_shop`.`import_BEFORE_UPDATE`
BEFORE UPDATE ON `computer_shop`.`import`
FOR EACH ROW
BEGIN
	DECLARE store_id BIGINT UNSIGNED DEFAULT NULL;
	DECLARE store_count INT UNSIGNED DEFAULT 0;
	DECLARE new_store_count INT UNSIGNED DEFAULT 0;
    
    IF (NEW.`model_id` != OLD.`model_id`)
    THEN
		SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'Cannot change import model. Delete current and insert new import instead.';
    END IF;
    
    SELECT `id`, `count`
	INTO store_id, store_count
	FROM `component_store`
	WHERE `model_id` = NEW.`model_id`
		AND `price` = OLD.`price`;
	
	IF (NOT store_id IS NULL)
	THEN
		IF (NEW.`count` != OLD.`count`)
		THEN
			IF (store_count + NEW.`count` >= OLD.`count`)
            THEN
				UPDATE `component_store`
				SET `count` = `count` + NEW.`count` - OLD.`count`
				WHERE `id` = store_id;
                
                SET new_store_count = store_count + NEW.`count` - OLD.`count`;
			ELSE
				SIGNAL SQLSTATE '45000'
					SET MESSAGE_TEXT = 'Cannot decrease import count - components are already in use';
			END IF;
		END IF;
        
        IF (NEW.`price` != OLD.`price`)
        THEN
			CALL update_store_price(store_id, NEW.`price`, NEW.`count`);
        END IF;
	ELSE
        SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'Cannot update import count - components are changed';
    END IF;
END$$

USE `computer_shop`$$
CREATE DEFINER = CURRENT_USER TRIGGER `computer_shop`.`import_BEFORE_DELETE`
BEFORE DELETE ON `import`
FOR EACH ROW
BEGIN
	DECLARE store_id BIGINT UNSIGNED DEFAULT NULL;
	DECLARE store_count INT UNSIGNED DEFAULT 0;
    
	SELECT `id`, `count`
	INTO store_id, store_count
	FROM `component_store`
	WHERE `model_id` = OLD.`model_id`
		AND `price` = OLD.`price`;
	
	IF (NOT store_id IS NULL)
	THEN
		IF (store_count >= OLD.`count`)
		THEN
			UPDATE `component_store`
			SET `count` = `count` - OLD.`count`
			WHERE `id` = store_id;
		ELSE
			SIGNAL SQLSTATE '45000'
				SET MESSAGE_TEXT = 'Cannot delete import - components are already in use';
		END IF;
	ELSE
		SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'Cannot delete import - components are changed';
	END IF;
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
-- begin attached script 'db_user'
DROP USER IF EXISTS `cs_admin`@'localhost';
CREATE USER `cs_admin`@'localhost'
	IDENTIFIED BY 'passwd';

GRANT SELECT, INSERT, UPDATE, DELETE
ON `computer_shop`.*
TO `cs_admin`@'localhost';

FLUSH PRIVILEGES;

-- end attached script 'db_user'
-- begin attached script 'system_users'
INSERT INTO `computer_shop`.`employee_auth`
(`id`, `role`, `email`, `pass_hash`)
VALUES
-- password = '123'
('1', 'ADMIN', 'mail@mail.com', '$2a$12$uGYKKxqsTq1lCk0AhL97T.WGcMErxKoJ4GKtRhkxcnPiEy3KF81W6'),

-- password = 'pass'
('2', 'MANAGER', 'man@mail.com', '$2a$12$oCKg9j.hGvce4yxMnJ4RpuEE6/NrGzYq8pgCQ7ZbFx2o3r0KgHKKO');

-- password = 'qwerty' => '$2a$12$aGHrSX8E1z/I1nnot6j8/Ogfp6hRlcWx58BdsN4n2FEzS2kcEwrau'

-- end attached script 'system_users'
-- begin attached script 'test_data'
INSERT INTO `computer_shop`.`component_type`
(`id`, `name`)
VALUES
  ('1', 'Процессор'),
  ('2', 'Материнская плата'),
  ('3', 'Оперативная память'),
  ('4', 'Видеокарта'),
  ('5', 'Сетевая плата');

INSERT INTO `computer_shop`.`component_model`
(`id`, `type_id`, `name`, `description`)
VALUES
  ('1', '1', 'Intel Core i7', 'Cool thing!'),
  ('2', '2', 'Gigabit M3', 'Cool mother!'),
  ('3', '1', 'AMD X5', 'Another proc');


INSERT INTO `computer_shop`.`provider`
(`id`, `name`, `description`)
VALUES
  ('1', 'MMGroup', NULL),
  ('2', 'TerraStore', NULL);

INSERT INTO `computer_shop`.`import`
(`id`, `provider_id`, `date_time`, `count`, `model_id`, `purchase_price`, `price`)
VALUES
  ('1', '1', '2017-04-14 11:43:33', '10', '1', '40', '5'),
  ('2', '1', '2017-04-15 13:26:49', '20', '1', '30', '0'),
  ('3', '2', '2017-04-19 15:23:01', '50', '2', '25', '30');


INSERT INTO `computer_shop`.`customer`
(`id`, `name`, `description`)
VALUES
  ('1', 'First', ''),
  ('2', 'Second', ''),
  ('3', 'Third', '');
  
INSERT INTO `computer_shop`.`order`
(`id`, `customer_id`)
VALUES
  ('1', '1');

INSERT INTO `computer_shop`.`assembly`
(`id`, `order_id`, `count`)
VALUES
  ('1', '1', '2');

INSERT INTO `computer_shop`.`assembly_component`
(`assembly_id`, `component_id`, `count`)
VALUES
  ('1', '1', '3'),
  ('1', '3', '1');

-- end attached script 'test_data'
