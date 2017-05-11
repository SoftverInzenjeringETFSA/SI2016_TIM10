-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Lokacije`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Lokacije` (
  `idLokacije` INT NOT NULL AUTO_INCREMENT,
  `adresa` VARCHAR(60) NOT NULL,
  `grad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idLokacije`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`korisnik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`korisnik` (
  `idkorisnika` INT NOT NULL AUTO_INCREMENT,
  `ime` VARCHAR(20) NOT NULL,
  `prezime` VARCHAR(25) NOT NULL,
  `email` VARCHAR(35) NOT NULL,
  `korisnickoIme` VARCHAR(20) NOT NULL,
  `sifra` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`idkorisnika`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Oglas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Oglas` (
  `idOglasa` INT NOT NULL AUTO_INCREMENT,
  `nazivOglasa` VARCHAR(45) NOT NULL,
  `vrstaOglasa` VARCHAR(30) NOT NULL,
  `vrstaNekretnine` VARCHAR(45) NOT NULL,
  `idLokacije` INT NOT NULL,
  `kvadratura` DECIMAL(3,2) NOT NULL,
  `cijena` DECIMAL(10,3) NULL,
  `brojProstorija` INT(3) NULL,
  `brojSpratova` INT(2) NULL,
  `datumObjave` DATETIME NOT NULL,
  `aktivna` TINYINT(1) NOT NULL,
  `brojPregleda` INT(6) NULL,
  `idkorisnika` INT NOT NULL,
  `placen` TINYINT(1) NOT NULL,
  `linkFolderaGalerije` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`idOglasa`, `idLokacije`, `idkorisnika`),
  INDEX `fk_Oglas_Lokacije1_idx` (`idLokacije` ASC),
  INDEX `fk_Oglas_korisnik1_idx` (`idkorisnika` ASC),
  CONSTRAINT `fk_Oglas_Lokacije1`
    FOREIGN KEY (`idLokacije`)
    REFERENCES `mydb`.`Lokacije` (`idLokacije`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Oglas_korisnik1`
    FOREIGN KEY (`idkorisnika`)
    REFERENCES `mydb`.`korisnik` (`idkorisnika`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ZainteresovaniKorisnici`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ZainteresovaniKorisnici` (
  `idkorisnika` INT NOT NULL,
  `idOglasa` INT NOT NULL,
  PRIMARY KEY (`idkorisnika`, `idOglasa`),
  INDEX `fk_korisnik_has_Oglas_Oglas1_idx` (`idOglasa` ASC),
  INDEX `fk_korisnik_has_Oglas_korisnik1_idx` (`idkorisnika` ASC),
  CONSTRAINT `fk_korisnik_has_Oglas_korisnik1`
    FOREIGN KEY (`idkorisnika`)
    REFERENCES `mydb`.`korisnik` (`idkorisnika`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_korisnik_has_Oglas_Oglas1`
    FOREIGN KEY (`idOglasa`)
    REFERENCES `mydb`.`Oglas` (`idOglasa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
