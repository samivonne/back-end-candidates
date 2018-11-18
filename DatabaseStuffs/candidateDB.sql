-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema heb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema heb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `heb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `heb` ;

-- -----------------------------------------------------
-- Table `heb`.`candidate`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `heb`.`candidate` ;

CREATE TABLE IF NOT EXISTS `heb`.`candidate` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(30) NULL DEFAULT NULL,
  `password` VARCHAR(20) NULL DEFAULT NULL,
  `firstName` VARCHAR(20) NULL DEFAULT NULL,
  `lastName` VARCHAR(20) NULL DEFAULT NULL,
  `streetAddress` VARCHAR(50) NULL DEFAULT NULL,
  `zipCode` VARCHAR(10) NULL DEFAULT NULL,
  `state` VARCHAR(20) NULL DEFAULT NULL,
  `city` VARCHAR(20) NULL DEFAULT NULL,
  `phoneNumber` VARCHAR(12) NULL DEFAULT NULL,
  `githubLink` VARCHAR(50) NULL DEFAULT NULL,
  `resume` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
