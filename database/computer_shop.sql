SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema computer_shop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema computer_shop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `computer_shop`
  DEFAULT CHARACTER SET utf8;
USE `computer_shop`;

-- -----------------------------------------------------
-- Table `computer_shop`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`customer` (
  `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(255)        NOT NULL,
  `description` TEXT                NULL     DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `computer_shop`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`order` (
  `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `customer_id` BIGINT(20) UNSIGNED NOT NULL,
  `cost`        INT(10) UNSIGNED    NOT NULL,
  `ord_date`    DATETIME            NOT NULL,
  `status`      ENUM (
    'IN_PROGRESS',
    'READY',
    'FINISHED',
    'CANCELED')                     NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_order_customer` (`customer_id` ASC),
  CONSTRAINT `FK_order_customer`
  FOREIGN KEY (`customer_id`)
  REFERENCES `computer_shop`.`customer` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `computer_shop`.`assembly_parcel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`assembly_parcel` (
  `id`         BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `order_id`   BIGINT(20) UNSIGNED NOT NULL,
  `cost`       BIGINT(20) UNSIGNED NOT NULL,
  `count`      BIGINT(20) UNSIGNED NOT NULL,
  `done_count` BIGINT(20) UNSIGNED NOT NULL DEFAULT '0',
  `canceled`   BIT(1)              NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`, `order_id`),
  INDEX `FK_assembly_parcel_order` (`order_id` ASC),
  CONSTRAINT `FK_assembly_parcel_order`
  FOREIGN KEY (`order_id`)
  REFERENCES `computer_shop`.`order` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `computer_shop`.`employee_auth`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`employee_auth` (
  `id`        BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `role`      ENUM (
    'RECEIVER',
    'ASSEMBLER',
    'MANAGER',
    'DIRECTOR',
    'ADMIN'
  )                               NOT NULL,
  `email`     VARCHAR(255)        NOT NULL,
  `pass_hash` VARCHAR(60)         NOT NULL,
  `blocked`   BIT(1)              NOT NULL DEFAULT b'0',
  `deleted`   BIT(1)              NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UQ_email` (`email` ASC)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `computer_shop`.`assembler_task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`assembler_task` (
  `id`           BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `order_id`     BIGINT(20) UNSIGNED NOT NULL,
  `parcel_id`    BIGINT(20) UNSIGNED NOT NULL,
  `assembler_id` BIGINT(20) UNSIGNED NULL     DEFAULT NULL,
  `task_type`    ENUM (
    'ASSEMBLE',
    'DISASSEMBLE'
  )                                  NOT NULL,
  `count`        BIGINT(20) UNSIGNED NOT NULL,
  `done_count`   BIGINT(20) UNSIGNED NOT NULL DEFAULT '0',
  `done_date`    DATE                NULL     DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_assembler_task_employee_auth` (`assembler_id` ASC),
  INDEX `FK_assembler_task_assembly_parcel` (`order_id` ASC, `parcel_id` ASC),
  CONSTRAINT `FK_assembler_task_assembly_parcel`
  FOREIGN KEY (`order_id`, `parcel_id`)
  REFERENCES `computer_shop`.`assembly_parcel` (`order_id`, `id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_assembler_task_employee_auth`
  FOREIGN KEY (`assembler_id`)
  REFERENCES `computer_shop`.`employee_auth` (`id`)
    ON DELETE SET NULL
    ON UPDATE RESTRICT
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `computer_shop`.`component_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`component_type` (
  `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(255)        NOT NULL,
  `description` TEXT                NULL     DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `computer_shop`.`component_model`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`component_model` (
  `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `type_id`     BIGINT(20) UNSIGNED NOT NULL,
  `name`        VARCHAR(255)        NOT NULL,
  `description` TEXT                NULL     DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UQ_name` (`name` ASC),
  INDEX `FK_component_component_type` (`type_id` ASC),
  CONSTRAINT `FK_component_component_type`
  FOREIGN KEY (`type_id`)
  REFERENCES `computer_shop`.`component_type` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `computer_shop`.`component_store`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`component_store` (
  `id`       BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `model_id` BIGINT(20) UNSIGNED NOT NULL,
  `price`    INT(10) UNSIGNED    NULL     DEFAULT NULL,
  `count`    INT(10) UNSIGNED    NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_product_component` (`model_id` ASC),
  CONSTRAINT `FK_product_component`
  FOREIGN KEY (`model_id`)
  REFERENCES `computer_shop`.`component_model` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `computer_shop`.`assembly_component`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`assembly_component` (
  `order_id`     BIGINT(20) UNSIGNED NOT NULL,
  `assembly_id`  BIGINT(20) UNSIGNED NOT NULL,
  `component_id` BIGINT(20) UNSIGNED NOT NULL,
  `count`        BIGINT(20) UNSIGNED NOT NULL,
  PRIMARY KEY (`order_id`, `assembly_id`, `component_id`),
  INDEX `IXFK_assembly_component_assembly` (`component_id` ASC),
  INDEX `IXFK_assembly_id` (`assembly_id` ASC),
  INDEX `FK_assembly_component_assembly_parcel` (`assembly_id` ASC, `order_id` ASC),
  CONSTRAINT `FK_assembly_component_assembly_parcel`
  FOREIGN KEY (`assembly_id`, `order_id`)
  REFERENCES `computer_shop`.`assembly_parcel` (`id`, `order_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_assembly_component_component`
  FOREIGN KEY (`component_id`)
  REFERENCES `computer_shop`.`component_store` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `computer_shop`.`clientdetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`clientdetails` (
  `appId`                  VARCHAR(255)  NOT NULL,
  `resourceIds`            VARCHAR(255)  NULL DEFAULT NULL,
  `appSecret`              VARCHAR(255)  NULL DEFAULT NULL,
  `scope`                  VARCHAR(255)  NULL DEFAULT NULL,
  `grantTypes`             VARCHAR(255)  NULL DEFAULT NULL,
  `redirectUrl`            VARCHAR(255)  NULL DEFAULT NULL,
  `authorities`            VARCHAR(255)  NULL DEFAULT NULL,
  `access_token_validity`  INT(11)       NULL DEFAULT NULL,
  `refresh_token_validity` INT(11)       NULL DEFAULT NULL,
  `additionalInformation`  VARCHAR(4096) NULL DEFAULT NULL,
  `autoApproveScopes`      VARCHAR(255)  NULL DEFAULT NULL,
  PRIMARY KEY (`appId`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `computer_shop`.`employee_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`employee_info` (
  `id`         BIGINT(20) UNSIGNED NOT NULL,
  `auth_id`    BIGINT(20) UNSIGNED NOT NULL,
  `first_name` VARCHAR(255)        NOT NULL,
  `last_name`  VARCHAR(255)        NOT NULL,
  `patronymic` VARCHAR(255)        NULL DEFAULT NULL,
  `phone`      VARCHAR(50)         NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UQ_auth` (`auth_id` ASC),
  CONSTRAINT `FK_employee_info_employee_auth`
  FOREIGN KEY (`auth_id`)
  REFERENCES `computer_shop`.`employee_auth` (`id`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `computer_shop`.`export`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`export` (
  `id`       BIGINT(20)          NOT NULL,
  `order_id` BIGINT(20) UNSIGNED NOT NULL,
  `exp_date` DATETIME            NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_export_order` (`order_id` ASC),
  CONSTRAINT `FK_export_order`
  FOREIGN KEY (`order_id`)
  REFERENCES `computer_shop`.`order` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `computer_shop`.`provider`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`provider` (
  `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(255)        NOT NULL,
  `description` TEXT                NULL     DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `computer_shop`.`import`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`import` (
  `id`             BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `provider_id`    BIGINT(20) UNSIGNED NOT NULL,
  `date_time`      DATETIME            NOT NULL,
  `count`          INT(10) UNSIGNED    NOT NULL,
  `model_id`       BIGINT(20) UNSIGNED NOT NULL,
  `purchase_price` INT(10) UNSIGNED    NOT NULL,
  `price`          INT(10) UNSIGNED    NOT NULL DEFAULT '0',
  `status`         ENUM (
    'REGISTERED',
    'FINISHED'
  )                                    NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_import_provider` (`provider_id` ASC),
  INDEX `FK_import_component_model` (`model_id` ASC),
  CONSTRAINT `FK_import_component_model`
  FOREIGN KEY (`model_id`)
  REFERENCES `computer_shop`.`component_model` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_import_provider`
  FOREIGN KEY (`provider_id`)
  REFERENCES `computer_shop`.`provider` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `computer_shop`.`inventory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`inventory` (
  `id`      BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `st_date` DATETIME            NOT NULL,
  `saldo`   BIGINT(20)          NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `computer_shop`.`inventory_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`inventory_item` (
  `id`             BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `stocktaking_id` BIGINT(20) UNSIGNED NOT NULL,
  `component_id`   BIGINT(20) UNSIGNED NOT NULL,
  `real_count`     INT(10) UNSIGNED    NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  INDEX `FK_inventory_item_stocktaking` (`stocktaking_id` ASC),
  INDEX `FK_inventory_item_component` (`component_id` ASC),
  CONSTRAINT `FK_inventory_item_component`
  FOREIGN KEY (`component_id`)
  REFERENCES `computer_shop`.`component_store` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_inventory_item_stocktaking`
  FOREIGN KEY (`stocktaking_id`)
  REFERENCES `computer_shop`.`inventory` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `computer_shop`.`oauth_access_token`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`oauth_access_token` (
  `token_id`          VARCHAR(256) NULL DEFAULT NULL,
  `token`             BLOB         NULL DEFAULT NULL,
  `authentication_id` VARCHAR(256) NULL DEFAULT NULL,
  `user_name`         VARCHAR(256) NULL DEFAULT NULL,
  `client_id`         VARCHAR(256) NULL DEFAULT NULL,
  `authentication`    BLOB         NULL DEFAULT NULL,
  `refresh_token`     VARCHAR(256) NULL DEFAULT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `computer_shop`.`oauth_refresh_token`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`oauth_refresh_token` (
  `token_id`       VARCHAR(256) NULL DEFAULT NULL,
  `token`          BLOB         NULL DEFAULT NULL,
  `authentication` BLOB         NULL DEFAULT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `computer_shop`.`order_component`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computer_shop`.`order_component` (
  `order_id`     BIGINT(20) UNSIGNED NOT NULL,
  `component_id` BIGINT(20) UNSIGNED NOT NULL,
  `count`        INT(10) UNSIGNED    NOT NULL,
  INDEX `FK_order_product_order` (`order_id` ASC),
  INDEX `FK_order_product_product` (`component_id` ASC),
  CONSTRAINT `FK_order_product_order`
  FOREIGN KEY (`order_id`)
  REFERENCES `computer_shop`.`order` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_order_product_product`
  FOREIGN KEY (`component_id`)
  REFERENCES `computer_shop`.`component_store` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

USE `computer_shop`;

DELIMITER $$
USE `computer_shop`$$
CREATE DEFINER = CURRENT_USER TRIGGER `computer_shop`.`assembly_parcel_AFTER_UPDATE`
AFTER UPDATE ON `assembly_parcel`
FOR EACH ROW
  BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION BEGIN
      SET @old_asm_count = NULL;
      RESIGNAL;
    END;

    IF (OLD.`count` != NEW.`count`)
    THEN
      SET @old_asm_count = OLD.`count`;

      -- Activate triggers
      UPDATE `assembly_component`
      SET `count` = `count`
      WHERE `order_id` = OLD.`order_id`
            AND `assembly_id` = OLD.`id`;

      SET @old_asm_count = NULL;
    END IF;
  END$$

USE `computer_shop`$$
CREATE DEFINER = CURRENT_USER TRIGGER `computer_shop`.`assembly_component_BEFORE_INSERT`
BEFORE INSERT ON `assembly_component`
FOR EACH ROW
  BEGIN
    DECLARE asm_count INT UNSIGNED DEFAULT 0;
    DECLARE stored_count INT UNSIGNED DEFAULT 0;
    DECLARE needed_count INT UNSIGNED DEFAULT 0;

    SELECT `count`
    INTO stored_count
    FROM `component_store`
    WHERE `id` = NEW.`component_id`;

    SELECT `count`
    INTO asm_count
    FROM `assembly_parcel`
    WHERE `id` = NEW.`assembly_id`
          AND `order_id` = NEW.`order_id`;

    SET needed_count = asm_count * NEW.`count`;

    IF (stored_count >= needed_count)
    THEN
      UPDATE `component_store`
      SET `count` = stored_count - needed_count
      WHERE `id` = NEW.`component_id`;
    ELSE
      SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Not enough components available';
    END IF;
  END$$

USE `computer_shop`$$
CREATE DEFINER = CURRENT_USER TRIGGER `computer_shop`.`assembly_component_BEFORE_UPDATE`
BEFORE UPDATE ON `assembly_component`
FOR EACH ROW
  BEGIN
    DECLARE stored_count INT UNSIGNED DEFAULT 0;
    DECLARE temp_stored_count INT UNSIGNED DEFAULT 0;
    DECLARE asm_count INT UNSIGNED DEFAULT 0;
    DECLARE old_count INT UNSIGNED DEFAULT 0;
    DECLARE needed_count INT UNSIGNED DEFAULT 0;

    SELECT `count`
    INTO stored_count
    FROM `component_store`
    WHERE `id` = NEW.`component_id`;

    SELECT `count`
    INTO asm_count
    FROM `assembly_parcel`
    WHERE `id` = NEW.`assembly_id`
          AND `order_id` = NEW.`order_id`;

    IF (@old_asm_count IS NULL)
    THEN
      SET @old_asm_count = asm_count;
    END IF;

    SET old_count = @old_asm_count * OLD.`count`;
    SET temp_stored_count = stored_count + old_count;
    SET needed_count = asm_count * NEW.`count`;

    IF (temp_stored_count >= needed_count)
    THEN
      UPDATE `component_store`
      SET `count` = temp_stored_count - needed_count
      WHERE `id` = NEW.`component_id`;
    ELSE
      SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Not enough components available';
    END IF;
  END$$

USE `computer_shop`$$
CREATE DEFINER = CURRENT_USER TRIGGER `computer_shop`.`assembly_component_AFTER_DELETE`
AFTER DELETE ON `assembly_component`
FOR EACH ROW
  BEGIN
    DECLARE asm_count INT UNSIGNED DEFAULT 0;
    DECLARE back_count INT UNSIGNED DEFAULT 0;

    SELECT `count`
    INTO asm_count
    FROM `assembly_parcel`
    WHERE `id` = OLD.`assembly_id`
          AND `order_id` = OLD.`order_id`;

    SET back_count = asm_count * OLD.`count`;

    UPDATE `component_store`
    SET `count` = `count` + back_count
    WHERE `id` = OLD.`component_id`;
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

    IF (NEW.`count` != OLD.`count`)
    THEN
      SELECT
        `id`,
        `count`
      INTO store_id, store_count
      FROM `component_store`
      WHERE `model_id` = NEW.`model_id`
            AND `price` = NEW.`price`;

      IF (NOT store_id IS NULL)
      THEN
        IF (NEW.`count` > OLD.`count`)
           OR (store_count >= OLD.`count` - NEW.`count`)
        THEN
          UPDATE `component_store`
          SET `count` = `count` + NEW.`count` - OLD.`count`
          WHERE `id` = store_id;
        ELSE
          SIGNAL SQLSTATE '45000'
          SET MESSAGE_TEXT = 'Can\'t decrease import count - components are already in use';
        END IF;
      ELSE
        INSERT INTO `component_store`
        (`model_id`, `price`, `count`)
          VALUE
          (NEW.`model_id`, NEW.`price`, NEW.`count`);
      END IF;
    END IF;
  END$$

USE `computer_shop`$$
CREATE DEFINER = CURRENT_USER TRIGGER `computer_shop`.`order_component_BEFORE_INSERT`
BEFORE INSERT ON `order_component`
FOR EACH ROW
  BEGIN
    DECLARE stored_count INT UNSIGNED DEFAULT 0;

    SELECT `count`
    INTO stored_count
    FROM `component_store`
    WHERE `id` = NEW.`component_id`;

    IF (stored_count >= NEW.`count`)
    THEN
      UPDATE `component_store`
      SET `count` = stored_count - NEW.`count`
      WHERE `id` = NEW.`component_id`;
    ELSE
      SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Not enough components available';
    END IF;
  END$$

USE `computer_shop`$$
CREATE DEFINER = CURRENT_USER TRIGGER `computer_shop`.`order_component_BEFORE_UPDATE`
BEFORE UPDATE ON `order_component`
FOR EACH ROW
  BEGIN
    DECLARE stored_count INT UNSIGNED DEFAULT 0;
    DECLARE temp_stored_count INT UNSIGNED DEFAULT 0;
    DECLARE old_count INT UNSIGNED DEFAULT 0;
    DECLARE needed_count INT UNSIGNED DEFAULT 0;

    -- Forbid change of component in existing record
    IF (NEW.`component_id` != OLD.`component_id`)
    THEN
      SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Operation denied';
    END IF;

    SELECT `count`
    INTO stored_count
    FROM `component_store`
    WHERE `id` = NEW.`component_id`;

    SET old_count = OLD.`count`;
    SET temp_stored_count = stored_count + old_count;
    SET needed_count = NEW.`count`;

    IF (temp_stored_count >= needed_count)
    THEN
      UPDATE `component_store`
      SET `count` = temp_stored_count - needed_count
      WHERE `id` = NEW.`component_id`;
    ELSE
      SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Not enough components available';
    END IF;
  END$$

USE `computer_shop`$$
CREATE DEFINER = CURRENT_USER TRIGGER `computer_shop`.`order_component_AFTER_DELETE`
AFTER DELETE ON `order_component`
FOR EACH ROW
  BEGIN
    UPDATE `component_store`
    SET `count` = `count` + OLD.`count`
    WHERE `id` = OLD.`component_id`;
  END$$


DELIMITER ;

SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
-- begin attached script 'db user'
DROP USER IF EXISTS `cs_admin`@'localhost';
CREATE USER `cs_admin`@'localhost'
  IDENTIFIED BY 'passwd';

GRANT SELECT, INSERT, UPDATE, DELETE
ON `computer_shop`.*
TO `cs_admin`@'localhost';

FLUSH PRIVILEGES;

-- end attached script 'db user'
-- begin attached script 'sys admin'
INSERT INTO `computer_shop`.`employee_auth`
(`id`, `role`, `email`, `pass_hash`)
VALUES
  ('1', 'ADMIN', 'mail@mail.com', '$2a$12$uGYKKxqsTq1lCk0AhL97T.WGcMErxKoJ4GKtRhkxcnPiEy3KF81W6');
-- end attached script 'sys admin'
