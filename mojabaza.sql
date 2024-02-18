/*
SQLyog Community v13.1.1 (64 bit)
MySQL - 10.1.28-MariaDB : Database - mojabaza
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mojabaza` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `mojabaza`;

/*Table structure for table `klijent` */

DROP TABLE IF EXISTS `klijent`;

CREATE TABLE `klijent` (
  `KlijentID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Ime` varchar(255) DEFAULT NULL,
  `Prezime` varchar(255) DEFAULT NULL,
  `JMBG` varchar(255) DEFAULT NULL,
  `Kontakt` varchar(255) DEFAULT NULL,
  `VrstaTreningaID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`KlijentID`),
  KEY `VrstaTreningaID` (`VrstaTreningaID`),
  CONSTRAINT `klijent_ibfk_1` FOREIGN KEY (`VrstaTreningaID`) REFERENCES `vrstatreninga` (`VrstaTreningaID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `klijent` */

insert  into `klijent`(`KlijentID`,`Ime`,`Prezime`,`JMBG`,`Kontakt`,`VrstaTreningaID`) values 
(2,'Milan','Cicvaric','1231','123342',1);

/*Table structure for table `rezimtreninga` */

DROP TABLE IF EXISTS `rezimtreninga`;

CREATE TABLE `rezimtreninga` (
  `RezimID` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `Opis` varchar(255) DEFAULT NULL,
  `Mesec` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`RezimID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `rezimtreninga` */

/*Table structure for table `stavkarezima` */

DROP TABLE IF EXISTS `stavkarezima`;

CREATE TABLE `stavkarezima` (
  `StavkaID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `RezimID` int(10) unsigned NOT NULL,
  `NazivStavke` varchar(255) DEFAULT NULL,
  `TrenerID` int(10) unsigned NOT NULL,
  `VrstaTreningaID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`StavkaID`,`RezimID`),
  KEY `TrenerID` (`TrenerID`),
  KEY `VrstaTreningaID` (`VrstaTreningaID`),
  KEY `RezimID` (`RezimID`),
  CONSTRAINT `stavkarezima_ibfk_1` FOREIGN KEY (`TrenerID`) REFERENCES `trener` (`TrenerID`),
  CONSTRAINT `stavkarezima_ibfk_2` FOREIGN KEY (`VrstaTreningaID`) REFERENCES `vrstatreninga` (`VrstaTreningaID`),
  CONSTRAINT `stavkarezima_ibfk_3` FOREIGN KEY (`RezimID`) REFERENCES `rezimtreninga` (`RezimID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `stavkarezima` */

/*Table structure for table `trener` */

DROP TABLE IF EXISTS `trener`;

CREATE TABLE `trener` (
  `TrenerID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Ime` varchar(255) DEFAULT NULL,
  `Prezime` varchar(255) DEFAULT NULL,
  `Username` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `JMBGT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`TrenerID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `trener` */

insert  into `trener`(`TrenerID`,`Ime`,`Prezime`,`Username`,`Password`,`JMBGT`) values 
(1,'Petar','Peric','pera','peric','1234'),
(2,'Steva','Stevic','steva','steva','5678');

/*Table structure for table `vrstatreninga` */

DROP TABLE IF EXISTS `vrstatreninga`;

CREATE TABLE `vrstatreninga` (
  `VrstaTreningaID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NazivVrsteTreninga` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`VrstaTreningaID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `vrstatreninga` */

insert  into `vrstatreninga`(`VrstaTreningaID`,`NazivVrsteTreninga`) values 
(1,'BodyBuilding'),
(2,'CrossFit'),
(3,'Joga');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
