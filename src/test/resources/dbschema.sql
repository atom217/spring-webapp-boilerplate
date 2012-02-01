SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `web_app_boilerplate` ;
CREATE SCHEMA IF NOT EXISTS `web_app_boilerplate` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `web_app_boilerplate`;

-- -----------------------------------------------------
-- Table `web_app_boilerplate`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `web_app_boilerplate`.`user` ;

CREATE  TABLE IF NOT EXISTS `web_app_boilerplate`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(50) NOT NULL ,
  `account_enabled` CHAR(1) NOT NULL ,
  `account_expired` CHAR(1) NOT NULL ,
  `account_locked` CHAR(1) NOT NULL ,
  `credentials_expired` CHAR(1) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `web_app_boilerplate`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `web_app_boilerplate`.`role` ;

CREATE  TABLE IF NOT EXISTS `web_app_boilerplate`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `description` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `web_app_boilerplate`.`user_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `web_app_boilerplate`.`user_role` ;

CREATE  TABLE IF NOT EXISTS `web_app_boilerplate`.`user_role` (
  `user_id` INT NOT NULL ,
  `role_id` INT NOT NULL ,
  PRIMARY KEY (`user_id`, `role_id`) ,
  INDEX `fk_user_role` (`user_id` ASC) ,
  INDEX `fk_role_user` (`role_id` ASC) ,
  CONSTRAINT `fk_user_role`
    FOREIGN KEY (`user_id` )
    REFERENCES `web_app_boilerplate`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_user`
    FOREIGN KEY (`role_id` )
    REFERENCES `web_app_boilerplate`.`role` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;