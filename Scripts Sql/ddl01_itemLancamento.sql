-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema estudos_schema
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema estudos_schema
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `estudos_schema` DEFAULT CHARACTER SET latin1 ;
USE `estudos_schema` ;

-- -----------------------------------------------------
-- Table `estudos_schema`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `estudos_schema`.`item` ;

CREATE TABLE IF NOT EXISTS `estudos_schema`.`item` (
  `oid` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NULL DEFAULT NULL,
  `valor` DECIMAL(19,2) NULL DEFAULT NULL,
  PRIMARY KEY (`oid`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `estudos_schema`.`lancamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `estudos_schema`.`lancamento` ;

CREATE TABLE IF NOT EXISTS `estudos_schema`.`lancamento` (
  `oid` INT(11) NOT NULL AUTO_INCREMENT,
  `dt_final` DATE NULL DEFAULT NULL,
  `dt_inicial` DATE NULL DEFAULT NULL,
  `observacao` VARCHAR(255) NULL DEFAULT NULL,
  `vl_total` DECIMAL(19,2) NULL DEFAULT NULL,
  PRIMARY KEY (`oid`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `estudos_schema`.`itemlancamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `estudos_schema`.`itemlancamento` ;

CREATE TABLE IF NOT EXISTS `estudos_schema`.`itemlancamento` (
  `item_oid` INT(11) NOT NULL,
  `lancamento_oid` INT(11) NOT NULL,
  PRIMARY KEY (`item_oid`, `lancamento_oid`),
  INDEX `FK614F4D0DC964C517` (`item_oid` ASC),
  INDEX `FK614F4D0D9C04E9E5` (`lancamento_oid` ASC),
  CONSTRAINT `FK614F4D0D9C04E9E5`
    FOREIGN KEY (`lancamento_oid`)
    REFERENCES `estudos_schema`.`lancamento` (`oid`),
  CONSTRAINT `FK614F4D0DC964C517`
    FOREIGN KEY (`item_oid`)
    REFERENCES `estudos_schema`.`item` (`oid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
