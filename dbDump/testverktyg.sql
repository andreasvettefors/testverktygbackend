-- --------------------------------------------------------
-- Värd:                         127.0.0.1
-- Serverversion:                5.7.16-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5164
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for g3testverktyg
CREATE DATABASE IF NOT EXISTS `g3testverktyg` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `g3testverktyg`;

-- Dumping structure for tabell g3testverktyg.answer
CREATE TABLE IF NOT EXISTS `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `answer` varchar(500) DEFAULT NULL,
  `isCorrect` tinyint(4) DEFAULT NULL,
  `question_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_answer_question1_idx` (`question_id`),
  CONSTRAINT `fk_answer_question1` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8;

-- Dumpar data för tabell g3testverktyg.answer: ~43 rows (ungefär)
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` (`id`, `answer`, `isCorrect`, `question_id`) VALUES
	(59, 'Ett förhistoriskt djur', 0, 22),
	(60, 'Ett programmeringspråk', 1, 22),
	(61, 'En liten hund', 0, 22),
	(62, 'Donald Trump', 0, 23),
	(63, 'Stefan Löfvén', 0, 23),
	(64, 'Kalle Anka', 0, 23),
	(65, 'James Gosling', 1, 23),
	(66, 'String', 1, 24),
	(67, 'int', 0, 24),
	(68, 'varchar', 0, 24),
	(69, 'boolean', 0, 24),
	(70, 'Allay', 0, 25),
	(71, 'Kallay', 0, 25),
	(72, 'Array', 1, 25),
	(73, 'Kalas', 0, 25),
	(74, 'Får', 0, 26),
	(75, 'För', 0, 26),
	(76, 'For', 1, 26),
	(77, 'Fyr', 0, 26),
	(78, '32', 0, 27),
	(79, '67', 0, 27),
	(80, '49', 1, 27),
	(81, '52', 0, 27),
	(82, '12', 0, 28),
	(83, '18', 0, 28),
	(84, '16', 1, 28),
	(85, '20', 0, 28),
	(86, '56', 0, 29),
	(87, '76', 0, 29),
	(88, '62', 1, 29),
	(89, '46', 0, 29),
	(90, 'Danmark', 0, 30),
	(91, 'Tjeckien', 0, 30),
	(92, 'Albanien', 1, 30),
	(93, 'Burundi', 1, 31),
	(94, 'Algeriet', 0, 31),
	(95, 'Norge', 0, 31),
	(96, 'Nigeria', 0, 32),
	(97, 'Chile', 0, 32),
	(98, 'El Salvador', 1, 32),
	(99, 'Sydafrika', 0, 33),
	(100, 'Surinam', 1, 33),
	(101, 'Tyskland', 0, 33);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;

-- Dumping structure for tabell g3testverktyg.course
CREATE TABLE IF NOT EXISTS `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumpar data för tabell g3testverktyg.course: ~4 rows (ungefär)
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`id`, `name`) VALUES
	(1, 'Java Basics'),
	(2, 'Matte'),
	(3, 'Geografi'),
	(4, 'Historia');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

-- Dumping structure for tabell g3testverktyg.question
CREATE TABLE IF NOT EXISTS `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(10000) DEFAULT NULL,
  `imgUrl` varchar(500) DEFAULT NULL,
  `test_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_question_test1_idx` (`test_id`),
  CONSTRAINT `fk_question_test1` FOREIGN KEY (`test_id`) REFERENCES `test` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- Dumpar data för tabell g3testverktyg.question: ~12 rows (ungefär)
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` (`id`, `question`, `imgUrl`, `test_id`) VALUES
	(22, 'Vad är java?', '', 19),
	(23, 'Vem skapade java', '', 19),
	(24, 'Hur definieras en sträng i java?', '', 19),
	(25, 'Vad kallas en lista?', '', 19),
	(26, 'Vilket nyckelord används för att loopa?', '', 19),
	(27, 'Vad är 7x7?', '', 20),
	(28, 'Vad är 64/4', '', 20),
	(29, 'Vad är 86-32+8?', '', 20),
	(30, 'Vilket land?', 'http://www.varldensflaggor.se/bilder/flaggor/albaniens-flagga.png', 21),
	(31, 'Vilket land?', 'http://www.varldensflaggor.se/bilder/flaggor/burundis-flagga.png', 21),
	(32, 'Vilket land?', 'http://www.varldensflaggor.se/bilder/flaggor/el-salvadors-flagga.png', 21),
	(33, 'Vilket land?', 'http://www.varldensflaggor.se/bilder/flaggor/surinams-flagga.png', 21);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;

-- Dumping structure for tabell g3testverktyg.studentanswer
CREATE TABLE IF NOT EXISTS `studentanswer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `answer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_studentanswer_user1_idx` (`user_id`),
  KEY `fk_studentanswer_question1_idx` (`question_id`),
  KEY `fk_studentanswer_answer1_idx` (`answer_id`),
  CONSTRAINT `fk_studentanswer_answer1` FOREIGN KEY (`answer_id`) REFERENCES `answer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_studentanswer_question1` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_studentanswer_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;

-- Dumpar data för tabell g3testverktyg.studentanswer: ~0 rows (ungefär)
/*!40000 ALTER TABLE `studentanswer` DISABLE KEYS */;
/*!40000 ALTER TABLE `studentanswer` ENABLE KEYS */;

-- Dumping structure for tabell g3testverktyg.test
CREATE TABLE IF NOT EXISTS `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) DEFAULT NULL,
  `description` varchar(999) DEFAULT NULL,
  `timeLimit` int(11) DEFAULT NULL,
  `seeResult` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- Dumpar data för tabell g3testverktyg.test: ~3 rows (ungefär)
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` (`id`, `name`, `description`, `timeLimit`, `seeResult`) VALUES
	(19, 'Grunder i java', 'Detta prov testar dina grunder i java', 1200, 1),
	(20, 'Ett litet mattetest', 'Huvudräkning', 600, 1),
	(21, 'Flaggor', 'Här ska du svar på flaggor', 7200, 1);
/*!40000 ALTER TABLE `test` ENABLE KEYS */;

-- Dumping structure for view g3testverktyg.testresult
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `testresult` (
	`user_id` INT(11) NOT NULL,
	`test_id` INT(11) NOT NULL,
	`question` VARCHAR(10000) NULL COLLATE 'utf8_general_ci',
	`answer` VARCHAR(500) NULL COLLATE 'utf8_general_ci',
	`isCorrect` TINYINT(4) NULL
) ENGINE=MyISAM;

-- Dumping structure for tabell g3testverktyg.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eMail` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `authorization` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Dumpar data för tabell g3testverktyg.user: ~6 rows (ungefär)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `eMail`, `password`, `authorization`) VALUES
	(4, 'nisse@teacher.com', 't', 1),
	(5, 'donald@teacher.com', 't', 1),
	(6, 'andreas@student.com', 's', 0),
	(7, 'monica@student.com', 's', 0),
	(8, 'lars@student.com', 's', 0),
	(9, 'lena@student.com', 's', 0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for tabell g3testverktyg.user_has_course
CREATE TABLE IF NOT EXISTS `user_has_course` (
  `user_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`course_id`),
  KEY `fk_user_has_course_course1_idx` (`course_id`),
  KEY `fk_user_has_course_user_idx` (`user_id`),
  CONSTRAINT `fk_user_has_course_course1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_course_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumpar data för tabell g3testverktyg.user_has_course: ~12 rows (ungefär)
/*!40000 ALTER TABLE `user_has_course` DISABLE KEYS */;
INSERT INTO `user_has_course` (`user_id`, `course_id`) VALUES
	(4, 1),
	(6, 1),
	(7, 1),
	(4, 2),
	(8, 2),
	(9, 2),
	(5, 3),
	(6, 3),
	(7, 3),
	(5, 4),
	(8, 4),
	(9, 4);
/*!40000 ALTER TABLE `user_has_course` ENABLE KEYS */;

-- Dumping structure for tabell g3testverktyg.user_has_test
CREATE TABLE IF NOT EXISTS `user_has_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `test_id` int(11) NOT NULL,
  `grade` varchar(45) DEFAULT '0',
  `isDone` tinyint(4) DEFAULT '0',
  `course_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_has_test_test1_idx` (`test_id`),
  KEY `fk_user_has_test_user1_idx` (`user_id`),
  KEY `fk_user_has_test_course1_idx` (`course_id`),
  CONSTRAINT `fk_user_has_test_course1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_has_test_test1` FOREIGN KEY (`test_id`) REFERENCES `test` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_has_test_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- Dumpar data för tabell g3testverktyg.user_has_test: ~6 rows (ungefär)
/*!40000 ALTER TABLE `user_has_test` DISABLE KEYS */;
INSERT INTO `user_has_test` (`id`, `user_id`, `test_id`, `grade`, `isDone`, `course_id`) VALUES
	(49, 6, 19, '0', 0, 1),
	(50, 7, 19, '0', 0, 1),
	(51, 8, 20, '0', 0, 2),
	(52, 9, 20, '0', 0, 2),
	(53, 6, 21, '0', 0, 3),
	(54, 7, 21, '0', 0, 3);
/*!40000 ALTER TABLE `user_has_test` ENABLE KEYS */;

-- Dumping structure for view g3testverktyg.testresult
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `testresult`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `testresult` AS select `studentanswer`.`user_id` AS `user_id`,`question`.`test_id` AS `test_id`,`question`.`question` AS `question`,`answer`.`answer` AS `answer`,`answer`.`isCorrect` AS `isCorrect` from ((`studentanswer` join `question` on((`question`.`id` = `studentanswer`.`question_id`))) join `answer` on((`answer`.`id` = `studentanswer`.`answer_id`)));

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
