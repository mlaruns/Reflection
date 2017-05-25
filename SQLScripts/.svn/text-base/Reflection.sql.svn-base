-- MySQL dump 10.13  Distrib 5.1.50, for Win32 (ia32)
--
-- Host: localhost    Database: testquiz
-- ------------------------------------------------------
-- Server version	5.1.50-community


--
-- Table structure for table `answer_options`
--

DROP TABLE IF EXISTS `answer_options`;

CREATE TABLE `answer_options` (
  `question_id` int(11) NOT NULL,
  `ANSWER_ID` int(10) NOT NULL AUTO_INCREMENT,
  `OPTIONS` varchar(100) DEFAULT NULL,
  `questionType` varchar(45) NOT NULL DEFAULT 'option',
  PRIMARY KEY (`ANSWER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `application`;

CREATE TABLE `application` (
  `app_id` int(11) NOT NULL AUTO_INCREMENT,
  `app_name` varchar(50) NOT NULL,
  `start_date` datetime NOT NULL,
  `stop_date` datetime NOT NULL,
  `delete_flag` int(1) unsigned DEFAULT '0',
  `completed_flag` int(1) unsigned DEFAULT '0',
  `app_type` varchar(20) NOT NULL,
  `eligible_employee_count` varchar(10) DEFAULT NULL,
  `mask_id` varchar(3) DEFAULT NULL,
  `questUploaded` int(1) unsigned NOT NULL DEFAULT '0',
  `openToall` int(1) unsigned NOT NULL DEFAULT '0',
  `employee_num` varchar(45) NOT NULL,
  PRIMARY KEY (`app_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



--
-- Table structure for table `elig_employee_list`
--

DROP TABLE IF EXISTS `elig_employee_list`;
CREATE TABLE `elig_employee_list` (
  `appId` int(11) DEFAULT NULL,
  `empId` varchar(60) DEFAULT NULL,
  `completed` varchar(10) DEFAULT NULL,
  `submitted_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ans_count` int(11) DEFAULT NULL,
  `mask_id` varchar(3) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



--
-- Table structure for table `questionsquiz`
--

DROP TABLE IF EXISTS `questionsquiz`;
CREATE TABLE `questionsquiz` (
  `question_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Competency` varchar(100) NOT NULL,
  `Sub_Competency` varchar(100) NOT NULL,
  `question` varchar(255) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(30) DEFAULT NULL,
  `created_by` varchar(30) DEFAULT NULL,
  `updated_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `mandatory` varchar(45) DEFAULT 'n',
  `Attribute_Type` varchar(20) DEFAULT NULL,
  `questionOrder` int(10) unsigned NOT NULL,
  `Peer_1` varchar(45) DEFAULT NULL,
  `Peer_2` varchar(45) DEFAULT NULL,
  `HR` varchar(45) DEFAULT NULL,
  `IT` varchar(45) DEFAULT NULL,
  `Crossfunctional` varchar(45) DEFAULT NULL,
  `Admin` varchar(45) DEFAULT NULL,
  `Finance` varchar(45) DEFAULT NULL,
  `QMO` varchar(45) DEFAULT NULL,
  `RECRUITMENT` varchar(45) DEFAULT NULL,
  `RMG` varchar(45) DEFAULT NULL,
  `REPORTEE` varchar(45) DEFAULT NULL,
  `SUPERVISOR` varchar(45) DEFAULT NULL,
  `description` longtext,
  `questionPriority` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`question_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


--
-- Table structure for table `user_answers`
--

DROP TABLE IF EXISTS `user_answers`;
CREATE TABLE `user_answers` (
  `username` varchar(20) NOT NULL,
  `questionNo` int(11) NOT NULL,
  `correctAns` varchar(255) DEFAULT NULL,
  `surveyId` int(10) unsigned NOT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- SQL DATA
