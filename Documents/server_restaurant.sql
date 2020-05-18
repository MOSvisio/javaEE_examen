-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 18 mai 2020 à 06:44
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `server_restaurant`
--

-- --------------------------------------------------------

--
-- Structure de la table `carte`
--

DROP TABLE IF EXISTS `carte`;
CREATE TABLE IF NOT EXISTS `carte` (
  `idResto` int(11) NOT NULL,
  `idPlat` int(11) NOT NULL,
  PRIMARY KEY (`idResto`,`idPlat`),
  KEY `idPlat` (`idPlat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `carte`
--

INSERT INTO `carte` (`idResto`, `idPlat`) VALUES
(2, 2),
(3, 7),
(2, 13),
(9, 14),
(9, 15);

-- --------------------------------------------------------

--
-- Structure de la table `plat`
--

DROP TABLE IF EXISTS `plat`;
CREATE TABLE IF NOT EXISTS `plat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `typePlat` int(11) NOT NULL,
  `prix` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nom` (`nom`),
  KEY `typePlat` (`typePlat`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `plat`
--

INSERT INTO `plat` (`id`, `nom`, `typePlat`, `prix`) VALUES
(2, 'Entrecote sauce jack daniels', 2, 19),
(4, 'big king', 2, 4),
(7, 'Big Mac', 2, 4.5),
(13, ' Tagliatelle Sauce Carbonara ', 2, 14),
(14, 'Maki par 6', 1, 7.25),
(15, 'Sushi thon par 6', 1, 7.5);

-- --------------------------------------------------------

--
-- Structure de la table `restaurant`
--

DROP TABLE IF EXISTS `restaurant`;
CREATE TABLE IF NOT EXISTS `restaurant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `addresse` varchar(100) NOT NULL,
  `typeCuisine` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `addresse` (`addresse`),
  KEY `typeCuisine` (`typeCuisine`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `restaurant`
--

INSERT INTO `restaurant` (`id`, `nom`, `addresse`, `typeCuisine`) VALUES
(2, 'coetlos Quai', '32 rue du coetlosquet 57000 Metz', 1),
(3, 'Mac Donald', 'METZ Technopole', 2),
(5, 'Frerot', '10 rue des jardins 57220 coume', 1),
(7, 'BurgerKing', '11 Metz technopole', 2),
(8, 'Mac Donald', 'Rue des forrains 57200 Saint-avold', 2),
(9, 'Ayako sushi', '11 rue des messagers 57000 Metz', 4),
(10, 'Tacos King', '16 Rue du Palais, 57000 Metz', 2),
(11, 'co taco te', ' 4 Place Georges Clemenceau, 57220 Boulay-Moselle', 1),
(12, 'Mamma Mia', '7 rue de haute rive 57070 Metz', 3);

-- --------------------------------------------------------

--
-- Structure de la table `typecuisine`
--

DROP TABLE IF EXISTS `typecuisine`;
CREATE TABLE IF NOT EXISTS `typecuisine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Type` (`Type`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `typecuisine`
--

INSERT INTO `typecuisine` (`id`, `Type`) VALUES
(1, 'Cuisine Maison'),
(2, 'Fast Food'),
(3, 'Italienne'),
(4, 'Japonaise');

-- --------------------------------------------------------

--
-- Structure de la table `typeplat`
--

DROP TABLE IF EXISTS `typeplat`;
CREATE TABLE IF NOT EXISTS `typeplat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `typeplat`
--

INSERT INTO `typeplat` (`id`, `type`) VALUES
(1, 'entree'),
(2, 'plat'),
(3, 'dessert');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `carte`
--
ALTER TABLE `carte`
  ADD CONSTRAINT `carte_ibfk_1` FOREIGN KEY (`idPlat`) REFERENCES `plat` (`id`),
  ADD CONSTRAINT `carte_ibfk_2` FOREIGN KEY (`idResto`) REFERENCES `restaurant` (`id`);

--
-- Contraintes pour la table `plat`
--
ALTER TABLE `plat`
  ADD CONSTRAINT `plat_ibfk_1` FOREIGN KEY (`typePlat`) REFERENCES `typeplat` (`id`);

--
-- Contraintes pour la table `restaurant`
--
ALTER TABLE `restaurant`
  ADD CONSTRAINT `restaurant_ibfk_1` FOREIGN KEY (`typeCuisine`) REFERENCES `typecuisine` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
