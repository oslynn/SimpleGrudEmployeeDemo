-- MySQL Workbench Forward `employee_db`

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema employee
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema employee
-- -----------------------------------------------------
-- CREATE SCHEMA IF NOT EXISTS `employee_db` DEFAULT CHARACTER SET utf8 ;
-- USE `employee_db` ;


-- -----------------------------------------------------
-- Table `employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(16) CHARACTER SET 'utf8' NOT NULL,
  `email` VARCHAR(255) NULL,
  `role` VARCHAR(100) NULL,
  `department` VARCHAR(255) NULL,
  `skill_sets` VARCHAR(255) NULL,
  `date_of_birth` TIMESTAMP NULL COMMENT 'Employee’s birth date',
  `date_of_joining` TIMESTAMP NULL COMMENT 'Employee’s joining date',
  `is_active` VARCHAR(16) NULL,
  `created_stamp` datetime NOT NULL,
  `last_updated_stamp` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
