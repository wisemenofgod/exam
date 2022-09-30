/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.49 : Database - exammanagementsystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`exammanagementsystem` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `exammanagementsystem`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

/*Table structure for table `clazz` */

DROP TABLE IF EXISTS `clazz`;

CREATE TABLE `clazz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(500) NOT NULL,
  `c_details` varchar(1000) DEFAULT NULL,
  `creatTIme` datetime NOT NULL,
  `creatperson` int(11) NOT NULL,
  `classSize` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `creatperson` (`creatperson`),
  CONSTRAINT `clazz_ibfk_1` FOREIGN KEY (`creatperson`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `clazz` */

insert  into `clazz`(`id`,`c_name`,`c_details`,`creatTIme`,`creatperson`,`classSize`) values (1,'九年一班','九年级一班','2022-01-18 20:53:22',4,4),(2,'九年二班','九年级二班班级','2022-01-01 21:43:33',5,5),(3,'英语辅导班','大学英语兴趣班','2022-01-01 19:08:42',6,1),(6,'英语辅导班','Jerry英语辅导班','2022-02-15 22:57:31',5,2),(7,'英语小课堂','小学英语课堂','2022-03-01 20:10:21',4,1),(8,'小学英语','小学生英语学习课堂','2022-04-20 10:19:20',4,1);

/*Table structure for table `clazz_exampaper_key` */

DROP TABLE IF EXISTS `clazz_exampaper_key`;

CREATE TABLE `clazz_exampaper_key` (
  `c_id` int(11) NOT NULL,
  `e_id` int(11) NOT NULL,
  PRIMARY KEY (`e_id`,`c_id`),
  KEY `c_id` (`c_id`),
  CONSTRAINT `clazz_exampaper_key_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `clazz` (`id`),
  CONSTRAINT `clazz_exampaper_key_ibfk_2` FOREIGN KEY (`e_id`) REFERENCES `exampaper` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `clazz_exampaper_key` */

insert  into `clazz_exampaper_key`(`c_id`,`e_id`) values (1,1),(2,2),(6,27),(8,24);

/*Table structure for table `clazz_user_key` */

DROP TABLE IF EXISTS `clazz_user_key`;

CREATE TABLE `clazz_user_key` (
  `c_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  PRIMARY KEY (`c_id`,`u_id`),
  KEY `u_id` (`u_id`),
  CONSTRAINT `clazz_user_key_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `clazz` (`id`),
  CONSTRAINT `clazz_user_key_ibfk_2` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `clazz_user_key` */

insert  into `clazz_user_key`(`c_id`,`u_id`) values (1,1),(2,1),(6,1),(1,2),(2,3),(1,4),(7,4),(8,4),(1,5),(2,5),(6,5),(2,6),(3,6),(2,7);

/*Table structure for table `exampaper` */

DROP TABLE IF EXISTS `exampaper`;

CREATE TABLE `exampaper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `creatTime` datetime DEFAULT NULL,
  `creatperson` int(11) NOT NULL,
  `questionNumber` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `creatperson` (`creatperson`),
  CONSTRAINT `exampaper_ibfk_1` FOREIGN KEY (`creatperson`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `exampaper` */

insert  into `exampaper`(`id`,`name`,`creatTime`,`creatperson`,`questionNumber`) values (1,'英语单元测试（一）','2022-03-10 15:53:06',4,15),(2,'英语单元测试（二）','2022-03-16 15:53:10',5,15),(3,'小明自建测试题','2022-03-20 15:53:12',1,15),(4,'小白的测试题','2022-03-01 21:42:58',3,14),(5,'小黑的测试题','2022-02-09 15:13:31',7,1),(6,'小明测试题','2022-04-19 16:42:54',1,7),(9,'测试试卷','2022-04-19 17:16:14',1,9),(13,'试卷','2022-04-19 17:38:40',1,7),(20,'这是个试卷','2022-04-24 22:31:13',1,1),(23,'英语单元测试（三）	','2022-05-02 20:54:08',4,15),(24,'英语单元测试（四）','2022-05-03 01:59:27',4,15),(27,'辅导班测试（一）','2022-05-05 00:13:59',5,15),(28,'试卷','2022-05-10 10:22:25',1,0);

/*Table structure for table `exampaper_question_key` */

DROP TABLE IF EXISTS `exampaper_question_key`;

CREATE TABLE `exampaper_question_key` (
  `e_id` int(11) NOT NULL,
  `q_id` int(11) NOT NULL,
  PRIMARY KEY (`q_id`,`e_id`),
  KEY `e_id` (`e_id`),
  CONSTRAINT `exampaper_question_key_ibfk_1` FOREIGN KEY (`q_id`) REFERENCES `question` (`id`),
  CONSTRAINT `exampaper_question_key_ibfk_2` FOREIGN KEY (`e_id`) REFERENCES `exampaper` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `exampaper_question_key` */

insert  into `exampaper_question_key`(`e_id`,`q_id`) values (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,91),(1,92),(1,93),(1,94),(1,95),(2,11),(2,12),(2,13),(2,14),(2,15),(2,16),(2,17),(2,18),(2,19),(2,20),(2,96),(2,97),(2,98),(2,99),(2,100),(3,22),(3,23),(3,24),(3,25),(3,26),(3,27),(3,28),(3,29),(3,30),(3,47),(3,101),(3,102),(3,103),(3,104),(3,105),(4,41),(4,42),(4,43),(4,44),(4,45),(4,46),(4,47),(4,48),(4,49),(4,50),(4,106),(4,107),(4,108),(4,109),(5,111),(6,142),(6,147),(6,151),(6,152),(6,153),(6,154),(6,155),(9,22),(9,23),(9,24),(9,25),(9,26),(9,27),(9,28),(9,29),(9,30),(13,142),(13,145),(13,151),(13,152),(13,153),(13,154),(13,155),(20,155),(23,40),(23,41),(23,42),(23,43),(23,44),(23,45),(23,46),(23,48),(23,49),(23,50),(23,107),(23,108),(23,109),(23,111),(23,112),(24,31),(24,32),(24,33),(24,34),(24,35),(24,36),(24,37),(24,38),(24,39),(24,40),(24,92),(24,93),(24,94),(24,95),(24,106),(27,18),(27,19),(27,20),(27,65),(27,66),(27,67),(27,68),(27,69),(27,70),(27,96),(27,97),(27,98),(27,99),(27,100),(27,139);

/*Table structure for table `examquestiondetail` */

DROP TABLE IF EXISTS `examquestiondetail`;

CREATE TABLE `examquestiondetail` (
  `e_id` int(11) NOT NULL,
  `q_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `choose` varchar(1000) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`e_id`,`q_id`,`u_id`),
  KEY `u_id` (`u_id`),
  KEY `q_id` (`q_id`),
  KEY `e_id` (`e_id`),
  CONSTRAINT `examquestiondetail_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`),
  CONSTRAINT `examquestiondetail_ibfk_2` FOREIGN KEY (`q_id`) REFERENCES `question` (`id`),
  CONSTRAINT `examquestiondetail_ibfk_3` FOREIGN KEY (`e_id`) REFERENCES `exampaper` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `examquestiondetail` */

insert  into `examquestiondetail`(`e_id`,`q_id`,`u_id`,`choose`,`time`) values (1,1,1,'B','2022-05-04 23:33:09'),(1,1,2,'B','2022-05-03 20:41:40'),(1,2,1,'C','2022-05-04 23:33:09'),(1,2,2,'C','2022-05-03 20:40:35'),(1,3,1,'D','2022-05-04 23:33:09'),(1,4,1,'B','2022-05-04 23:33:09'),(1,5,1,'C','2022-05-04 23:33:09'),(1,6,1,'B','2022-05-04 23:33:09'),(1,7,1,'B','2022-05-04 23:33:09'),(1,8,1,'C','2022-05-04 23:33:09'),(1,9,1,'B','2022-05-04 23:33:09'),(1,10,1,'C','2022-05-04 23:33:09'),(1,91,1,'在判断自己的外表时，我们甚至都没有接近客观','2022-05-04 23:33:09'),(1,92,1,'我们留给陌生人冷静的判断来满足我们对外表的好奇','2022-05-04 23:33:09'),(1,93,1,'其他人都太专注于自己的外表而无法批评你的外表','2022-05-04 23:33:09'),(1,94,1,'这些社会比较不仅发生在你故意仔细检查路人时，而且会不断地自动发生','2022-05-04 23:33:09'),(1,95,1,'因为她们的社会地位往往取决于她们的脸和身体，所以女性特别容易受到这种影响','2022-05-04 23:33:09'),(2,11,1,'B','2022-05-04 23:34:42'),(2,12,1,'B','2022-05-04 23:34:42'),(2,13,1,'D','2022-05-04 23:34:42'),(2,14,1,'B','2022-05-04 23:34:42'),(2,15,1,'B','2022-05-04 23:34:42'),(2,16,1,'C','2022-05-04 23:34:42'),(2,17,1,'C','2022-05-04 23:34:42'),(2,18,1,'B','2022-05-04 23:34:42'),(2,19,1,'A','2022-05-04 23:34:42'),(2,20,1,'D','2022-05-04 23:34:42'),(2,96,1,'虽然父母的爱可以增强某些人的自尊心，但童年经历和成人自我形象之间并没有直接的界限','2022-05-04 23:34:42'),(2,97,1,'研究表明，长得好看的人通常被评价为具有特殊人格特质的人','2022-05-04 23:34:42'),(2,98,1,'她的研究证明，人类和猿类之间的区别是一种程度，而不是种类','2022-05-04 23:34:42'),(2,99,1,'我们的大脑完全有能力控制这种本能行为','2022-05-04 23:34:42'),(2,100,1,'你赞成将动物圈养作为保护濒危物种的最后手段','2022-05-04 23:34:42'),(3,22,1,'D','2022-05-08 20:56:20'),(3,23,1,'D','2022-05-08 20:56:20'),(3,24,1,'C','2022-05-08 20:56:20'),(3,25,1,'A','2022-05-08 20:56:20'),(3,26,1,'B','2022-05-08 20:56:20'),(3,27,1,'C','2022-05-08 20:56:20'),(3,28,1,'B','2022-05-08 20:56:20'),(3,29,1,'C','2022-05-08 20:56:20'),(3,30,1,'B','2022-05-08 20:56:20'),(3,47,1,'C','2022-05-08 20:56:20'),(3,101,1,'1234123 ','2022-05-08 20:56:20'),(3,102,1,'asgdf ','2022-05-08 20:56:20'),(3,103,1,'asdf','2022-05-08 20:56:20'),(3,104,1,'asdf','2022-05-08 20:56:20'),(3,105,1,'asdfasdfa ','2022-05-08 20:56:20'),(6,142,1,'assdfas ','2022-05-04 21:40:04'),(6,147,1,'C','2022-05-04 21:40:04'),(6,151,1,'BC','2022-05-04 21:40:04'),(6,152,1,'BD','2022-05-04 21:40:04'),(6,153,1,'B','2022-05-04 21:40:04'),(6,154,1,'xzxczxcv','2022-05-04 21:44:30'),(6,155,1,'asdasdff','2022-05-04 21:40:04');

/*Table structure for table `identity` */

DROP TABLE IF EXISTS `identity`;

CREATE TABLE `identity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identity` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `identity` */

insert  into `identity`(`id`,`identity`) values (1,'学生'),(2,'老师');

/*Table structure for table `question` */

DROP TABLE IF EXISTS `question`;

CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `q_name` varchar(1000) NOT NULL,
  `q_ansA` varchar(1000) DEFAULT NULL,
  `q_ansB` varchar(1000) DEFAULT NULL,
  `q_ansC` varchar(1000) DEFAULT NULL,
  `q_ansD` varchar(1000) DEFAULT NULL,
  `q_ans` varchar(1000) NOT NULL,
  `q_type` int(11) NOT NULL,
  `creatperson` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `q_type` (`q_type`),
  KEY `creatperson` (`creatperson`),
  CONSTRAINT `question_ibfk_1` FOREIGN KEY (`q_type`) REFERENCES `questiontype` (`id`),
  CONSTRAINT `question_ibfk_2` FOREIGN KEY (`creatperson`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=utf8;

/*Data for the table `question` */

insert  into `question`(`id`,`q_name`,`q_ansA`,`q_ansB`,`q_ansC`,`q_ansD`,`q_ans`,`q_type`,`creatperson`) values (1,'From his earliest years he showed an _________ ability in mechanics and a natural talent for engineering','except','exception','exceptional','exceptionally','C',1,4),(2,'Your account has been created, but before you can use it, you will need to _______ your account','validate','validation','invalid','valid','A',1,4),(3,'___________ is the transitional period between childhood and manhood','Adolescent','Adolescence','Infant','Infancy','B',1,4),(4,'Job creation and training schemes have tended to focus almost _________ on younger people','exclude','exclusive','exclusively','inclusive','C',1,4),(5,'Students must be highly disciplined and _______ to succeed in such a competitive and active learning environment','self-centered','self-abandoned','self-evident','self-motivated','D',1,4),(6,'When you become ____________, it means you are carrying on your own business rather than working for an employer','self-critical','self-employed','self-conscious','self-assured','B',1,4),(7,'It’s difficult to ________ the possible results in advance','estimation','estimate','assessment','evaluation','B',1,4),(8,'In a televised interview, he __________ his resignation and, at the same time, his decision to join the Liberal People’s Party','announced','announce','broadcast','renounce','A',1,4),(9,'Once again, the High Authority had to admit defeat, and _________ its proposal','cancelled','withdrawing','withdrew','withdraw','C',1,4),(10,'Historically speaking, cutting taxes does not _________ economic growth','stimulate','motivates','activates','urge','A',1,4),(11,'China was the first country in the world to __________ crystalline insulin (结晶胰岛素), a bioactive protein','combine','synthesizes','blend','synthesize','D',1,5),(12,'The greatest good we can do to people is to treat them with _________, courtesy and respect','compassion','compassionate','compass','compassionately','A',1,5),(13,'Charles Darwin __________the basic principle of the Theory of Natural Selection in the late 1830s','formulation','formulate','formulated','formula','C',1,5),(14,'Sometimes his music _______ moments of sudden quiet with moments of dramatic intensity','alternate','alternative','alternates','alternation','C',1,5),(15,'The temple ruins are a distant reminder of a(n) _________ empire','dead','vanished','extinct','extinction','B',1,5),(16,'According to Tito Philips, how we respond to the _______ competitions is the key determinant whether we’ll remain in business or not','intense','intensive','concentrated','intensify','A',1,5),(17,'Now that we have discussed the prospects of finding primitive life on other planets, what about the prospect of finding _________ life there','brilliant','smart','wise','intelligent','D',1,5),(18,'It was found at the _______ spot where she had left it','precise','precision','accuracy','precisely','A',1,5),(19,'The African National Congress is opposed to the corporate giants’ ___________ economic power','intense','intensive','concentrated','concentration','C',1,5),(20,'The reconstruction of _______ species from fossil bones was often undertaken by museum workers','dead','vanished','extinct','extinction','C',1,5),(22,'Studies show that if a working environment is clean, organized and pleasant, employee ____________ increases','produce','product','productivity','productive','C',1,1),(23,'Jillian has created a step-by-step plan of weight loss, which includes _________nutrition guidelines','customization','customer','customize','customized','D',1,1),(24,'The best way to prepare for major life __________ is to take some time for self-reflection','transit','transitions','transitive','transitory','B',1,1),(25,'In shifting responsibility from government to the people, the government has ________ a novel approach','adopted','adapted','adapt','adopt','A',1,1),(26,'A contented mind is a _____ feast','permanence','infinity','perpetual','endlessness','C',1,1),(27,'Walking further, I noticed a red balloon _____ , rising to the higher altitude','loft','lofting','lofted','aloft','D',1,1),(28,'_____ the wake of developments in science and technology, man has become more capable of conquering nature','From','By','In','For','C',1,1),(29,'A painter may exaggerate or _____ shapes and forms','detain','distort','retort','retain','B',1,1),(30,'This problem is _____ in orbit, where the pull of gravity is reduced to effectively nothing','criminated','examined','elaborated','eliminated','D',1,1),(31,'But there’s fuzzy thinking _____ work even in terms of Garriott’s faith in the estimable Musk','at','as','for','from','A',1,4),(32,'In a train _____ , there are 3 men and a ravishing young girl','department','compartment','apartment','parliament','B',1,4),(33,'The material is _______ in microscopic amounts from a print head that slides along rails','discarding','deposited','uncovered','impeded','B',1,4),(34,'3D printing will _________ waste, because there isn’t any discarded raw material in the additive manufacturing process','correspond','typeset','cut down on','deposit','C',1,4),(35,'Scientific inventions have raised labor _____ by a big margin','productivity','fabrication','margin','dividend','A',1,4),(36,'I’m talking about truly major innovations that marked a _________ in history, where almost every aspect of daily life was affected','substrate','turning point','a sinking ship','productivity','B',1,4),(37,'Your success will ____ depend upon what you do and how you do it','anonymously','exclusive','impressive','largely','D',1,4),(38,'Was that something of a ______ for Spanish football','watershed','orthotic','margin','substrate','A',1,4),(39,'For a manufacturer, these will be materials used in the _____ of the products','exaggeration','compassion','customize','fabrication','D',1,4),(40,'It was Cindy who _______ the switch that opened the front gate','flip','flipped','flips','flipping','B',1,4),(41,'A book was thrown onto the table; it ________ the smooth surface to land in front of her','slide along','slides along','slid along','sliding along','C',1,4),(42,'Peter, who ___________ in the family wallpaper business, was a generous, demonstrative and easy-going stepfather','make his fortune','making his fortune','makes his fortune','made his fortune','D',1,4),(43,'He loves his family, but he also likes golf, and tries to make the __________','turning point','best of both worlds','cook’s tour','difference','B',1,4),(44,'He fixed the broken bike______','niftily','large','most','subsequent','A',1,4),(45,'The company has successfully ________ new products and service','innovation','innovate','innovated','innovative','C',1,4),(46,'The US achieved its predominance after World War II because it had made _______ efforts towards this goal','consequent','painstaking','subsequently','brand-new','B',1,4),(47,'He inherited a fortune ________ his grandmother','of','at','in','from','D',1,1),(48,'The innovation cycle in every industry will be drastically shortened, because additive manufacturing makes the design, construction, and testing of _______ a snap','prototype','prototypes','dividend','dividends','B',1,4),(49,'“3D printing” is almost a misleading term. Instead, it should be called ________printing','subtractive','B. compelling','C. additive','D. intensive','C',1,4),(50,'It is potentially a very lucrative market and those who ___________might well make a fortune','pay dividends','whittle down','fit together','get in on the ground floor','D',1,4),(51,'The printing business is not _________, because other innovations, such as email, the PDF format, and high-quality scanners are keeping it afloat','a sinking ship','a turning point','a good point','a viable enterprise','A',1,3),(52,'The only way to discover the limits of the possible is to ________ them into the impossible','predict','undergo','reap','go beyond','D',1,3),(53,'____ breeding is the process of breeding animals in human controlled environments with restricted settings','Capture','Captivity','Captive','Captured','C',1,3),(54,'He ____ equal pay for equal work','favor','favors','favorite','favorable','B',1,3),(55,'____ is that we have to make a decision today','The bottom line','The last line','The first line','The middle line','A',1,7),(56,'We’d be ____ without the noise from the neighboring bar','well off','worse off','better off','worst off','C',1,7),(57,'The popular band spends nine months a year ____','at the road','in the road','on the road','to the road','C',1,7),(58,'The government will impose a state of emergency only ____','on a last resort','in a last resort','at a last resort','as a last resort','D',1,7),(59,'You should ____ before you make any important decisions','think first','think twice','think three times','think second','B',1,7),(60,'It is important to check whether the ____ person left any instructions about the funeral','death','dead','extinct','vanished','B',1,6),(61,'The comely reap real social and _________ gains in life','economical','economy','economic','economics','C',1,6),(62,'We’re not even close to __________ when it comes to judging our own looks','object','objective','objection','objects','B',1,6),(63,'When we look in the mirror, we’re liable to zero in on the __________','perfection','perfect','imperfection','imperfect','C',1,6),(64,'If we can’t trust our own self-appraisal, we’re left to the cool judgment of strangers to satisfy our _______ about our appearance','curiosity','curious','curiousness','cure','A',1,6),(65,'Everyone else is too fixated on his or her own appearance to be ______ of yours','critics','criticism','criticizing','critical','D',1,5),(66,'Not all people who grow up disliking their _________ were ugly children','appear','appears','disappear','appearance','D',1,5),(67,'While _______ love can bolster self-esteem for some, there’s no direct line between childhood experiences and adul_t self-image','parents','parent','parental','present','C',1,5),(68,'When we want _______ for our decisions we often turn to friends for advice and approval','valid','validate','validating','validation','D',1,5),(69,'Stress of long hours can lead to heart problems, increased ________ to infection, fatigue disorders and even suicide','susceptibility','susceptible','suspect','inspect','A',1,5),(70,'There was a _______ of joy in her eyes','gleaming','steam','gleams','gleam','D',1,5),(71,'The new treatment works by blocking the growth of the cancer cells and eventually causing them to _______','self-destruct','self-destruction','self-construct','self-construction','A',1,2),(72,'The Occupy Wall Street protesters have demonstrated their ability to ________','self-organization','self-organize','self-organized','self-organizing','B',1,2),(73,'He __________ a chronic cough which disturbed his brother\'s rest','develop','developed','develops','is developing','B',1,2),(74,'____________ farming is the latest technique used to yield high productivity','Intense','Intensive','Intensify','Intensity','B',1,2),(75,'They surveyed the damage _________ by the storm','inflict','inflicts','inflicting','inflicted','D',1,2),(76,'This decision will isolate the country _________ the rest of Europe','to','of','from','for','C',1,2),(77,'The bridge is liable ______ collapse at any moment','to','of','for','from','A',1,3),(78,'He raised his voice to an even higher____________','degree','extent','sense','pitch','D',1,3),(79,'As the plot_______, you gradually realize that all your initial assumptions were wrong','folds','folding','unfolds','unfolding','C',1,3),(80,'More relevant, Garriott is thinking big thoughts and _______presenting them in a coherent and reasonably disciplined way','at least','at last','in all','at most','A',1,3),(81,'He distinguished himself _____a writer at a very early age','on','as','in','to','B',1,3),(82,'He felt that moving out from his parents’ home was a real _____ in his life','milemeter','milestone','diameter','touchstone','B',1,3),(83,'But grasshopper flew only about 240 ft. _____ (80 m) and didn’t go very fast','above','down','low','up','D',1,7),(84,'I’ve never been there, but it’s a lovely place, _____ all accounts','in','at','by','for','C',1,7),(85,'It will take some time to work out comprehensive and _____ common foreign and security policies','coherence','comprehension','component','coherent','D',1,7),(86,'Garriott also has some clear-eyed ideas _____ how to solve some stubborn objections that cranks like me always raise about plans like his','to','for','in','as','B',1,7),(87,'But it does mean that a 240-ft. test is an awfully thin reed on which to hang the hope that the goal is _____ reach','during','in','within','among','C',1,6),(88,'_____ people are easily misled by false advertisements','Credit','Curiosity','Credential','Credulous','D',1,6),(89,'The creation of an efficient and _____ transport system is critical','sustains','sustainable','sustained','sustaining','B',1,6),(90,'You don\'t know which encoding the document uses, so this is not a _____ solution','viable','edible','variable','liable','A',1,6),(91,'We’re not even close to objective when it comes to judging our own looks',NULL,NULL,NULL,NULL,'我们甚至都难以客观评价自己的相貌。',4,4),(92,'We’re left to the cool judgment of strangers to satisfy our curiosity about our appearance',NULL,NULL,NULL,NULL,'我们只落得靠陌生人的客观评价来满足对于自身容貌的好奇心。',4,4),(93,'Everyone else is too fixated on his or her own appearance to be critical of yours',NULL,NULL,NULL,NULL,'每个人都太专注于自己的外表，无暇对你评头论足。',4,4),(94,'These social comparisons happen not only when you deliberately scrutinize passersby, but constantly and automatically',NULL,NULL,NULL,NULL,'这种社会比较不仅仅只是出现在你特意仔细观察路人时，而是一直在自发地进行着。',4,4),(95,'Because their social status is often contingent upon their faces and bodies, women are particularly susceptible to this effect',NULL,NULL,NULL,NULL,'因为女性的社会地位经常是由脸蛋和身材决定的，所以她们特别容易受这种对比效应的影响。',4,4),(96,'While parental love can bolster self-esteem for some, there’s no direct line between childhood experiences and adul_t self-image',NULL,NULL,NULL,NULL,'尽管父母的爱能给一些人带来自信，但是儿童时期的经历与成年时的形象没有必然联系。',4,5),(97,'Research has shown that good-looking people are often evaluated to be ones with exceptional personality traits',NULL,NULL,NULL,NULL,'研究表明：长相好的人往往被评价为具有出色的性格特质的人。',4,5),(98,'Her research proved that the difference between humans and apes is one of degree, not of kind',NULL,NULL,NULL,NULL,'她的研究证实了人类与猩猩的差别没有类属之别，只有程度之异。',4,5),(99,'Our brains are fully capable of controlling this type of instinctive behavior',NULL,NULL,NULL,NULL,'人类的大脑完全有能力控制这种本能行为。',4,5),(100,'You are in favor of captive breeding of animals as a last resort to preserve endangered species',NULL,NULL,NULL,NULL,'您赞成把人工养殖作为保护濒危动物的最后防线。',4,5),(101,'If this species also becomes extinct, eventually a whole ecosystem may collapse',NULL,NULL,NULL,NULL,'因为如果这种生物也消亡的话，整个生态系统就会崩溃。',4,1),(102,'Our intellect has developed so explosively that we are able to formulate a moral code',NULL,NULL,NULL,NULL,'因为人类智力已经高度进化，所以我们能形成道德观念。',4,1),(103,'The human population has soared, as has the damage to the ecosystem',NULL,NULL,NULL,NULL,'人口激增，对生态系统的破坏也激增。',4,1),(104,'The Industrial Revolution boosted productivity, lowered costs, and raised the standard of living',NULL,NULL,NULL,NULL,'工业革命提高了生产力，降低了成本，提升了生活水平。',4,1),(105,'The computer and the Internet have made possible another gigantic increase in productivity, commerce, communication, and entertainment',NULL,NULL,NULL,NULL,'计算机和互联网使生产力、商贸、通讯、娱乐休闲都得到了极大提升和改善。',4,1),(106,'This breakthrough is changing the industries it touches in dramatic, fundamental ways',NULL,NULL,NULL,NULL,'这一重大突破正在使相关产业领域发生翻天覆地的变化。',4,4),(107,'The miracle of 3D printing is that it largely removes manual labor from the manufacturing process',NULL,NULL,NULL,NULL,'3D打印技术的非凡之处在于，它取代了制造过程中的体力劳动。',4,4),(108,'It is the subsequent entrepreneurial entrants who lower costs, enhance the technology, and really make the big money',NULL,NULL,NULL,NULL,'后来进入该行业的企业家靠降低成本、改进工艺，才赚到大钱。',4,4),(109,'Chinese typography created possibility for the wide dissemination and exchange of knowledge',NULL,NULL,NULL,NULL,'中国的印刷术为知识的广泛传播、交流创造了条件。',4,4),(111,'“The ship is turning,” he said. “The phoenix is rising on the back of something that’s sustainable.',NULL,NULL,NULL,NULL,'他说：“船正在转向，凤凰获得了新生的持续力量”。',4,4),(112,'But there’s fuzzy thinking at work even in terms of Garriott’s (加里奥特) faith in the estimable Musk (马斯克)',NULL,NULL,NULL,NULL,'即使加里奥特对颇值得称道的马斯克项目信心满满，其中也还有模糊不清的地方。',4,4),(116,'That’s more than NASA has done for a long time and more than entrepreneurs like Branson and Tito (布兰森和蒂托) are doing',NULL,NULL,NULL,NULL,'这已经超出了美国宇航局长期以来所做的，也超出了像布兰森和蒂托这样的企业家正在做的。',4,2),(117,'As the post-shuttle era unfolds, Garriott (加里奥特) surely has a place as an idea man',NULL,NULL,NULL,NULL,'随着后飞船时代的到来，加里奥特作为创意家定将占有一席之地。',4,2),(118,'3D printing is going to be one of the most important innovations we will see in our lifetime – and we’re going to see a lot of them',NULL,NULL,NULL,NULL,'3D 打印将会是我们有生之年见到的最重要的发明之一，我们还将目睹许许多多这样重要的创新。',4,2),(119,'3D printing, on the other hand, builds things up molecule by molecule – no retooling, no molds, no waste',NULL,NULL,NULL,NULL,'然而3D 打印是将原材料一点一点叠加，不用再加工，不用铸模，也不会产生浪费。',4,2),(120,'The most dramatic contribution of 3D printing will be to transform the manufacturing of all the things that make our everyday lives easier and better',NULL,NULL,NULL,NULL,'3D打印技术的最大贡献在于，它改变了所有产品的生产过程，让我们的日常生活更加便利美好。',4,3),(121,'3D printing will cut down on waste, because there isn’t any discarded raw material in the additive manufacturing process. Less waste means big savings',NULL,NULL,NULL,NULL,'3D打印能降低损耗，因为增材制造不会造成任何原材料的浪费，损耗减少意味着利润增加。',4,3),(122,'3D printing makes it as cheap to create single items as it is to produce thousands and thus undermines economies of scale',NULL,NULL,NULL,NULL,'3D打印技术使得生产单件商品的成本与批量生产一样便宜，这会削弱规模经济效益。',4,3),(123,'We just don’t know enough about how all the pieces (animals) fit together',NULL,NULL,NULL,NULL,'所有动物是怎样一种有机存在，我们还知之甚少。',4,3),(124,'We do not ask how decisions made today will affect generations to come but how they affect the bottom line',NULL,NULL,NULL,NULL,'我们从来不问今天的决定对后代会产生怎样的影响，而只问他们会怎样触及底线。',4,6),(125,'You have been a public figure for most of your career, alternating time in the jungle with time at the podium',NULL,NULL,NULL,NULL,'在你职业生涯的大部分时间，你一直是个公众人物，在丛林中的时间与在讲台上的时间互相交替',4,6),(126,'It has also taught me that our aggressive tendencies have probably been inherited from an ancient primate some six million years ago',NULL,NULL,NULL,NULL,'我还知道了人类的暴力倾向可能来源于大约六百万年前的一种远古灵长类动物。',4,6),(127,'She is on the road 300 days a year, lecturing to sold-out audiences and collecting material for her thought-provoking books',NULL,NULL,NULL,NULL,'一年中有300天她都在路上奔波，不是为满座观众发表演说，就是为她那发人深省的书籍收集素材。',4,6),(128,'As the first human ever to be accepted among groups of chimpanzees, Goodall (古多尔) introduced us over the years to an unforgettable cast of animal characters',NULL,NULL,NULL,NULL,'古多尔是第一个被不同黑猩猩家族接受的人类，多年来她向我们介绍了一个令人难忘的动物群体',4,6),(129,'As I entered her hotel suite, I notice a toy chimpanzee sitting on top of her open suitcase',NULL,NULL,NULL,NULL,'我走进她的酒店套房，注意到她敞开的箱子上有一只玩偶猩猩。',4,7),(130,'Heavy meat eating is damaging to the environment and human health',NULL,NULL,NULL,NULL,'大量食肉会对环境和个人健康产生危害。',4,7),(131,'Don’t hate yourself for wanting to be beautiful',NULL,NULL,NULL,NULL,'爱漂亮没有什么可自责的。',4,7),(132,'Good-looking people get special treatment from strangers, employers and even their own mothers',NULL,NULL,NULL,NULL,'外表俊美的人能从陌生人、雇主，甚至他们自己的母亲那里获得优待。',4,7),(133,'You’re almost certainly hotter than you think',NULL,NULL,NULL,NULL,'实际上你比你想象的更有魅力。',4,7),(134,'You feel prettier around ugly people and uglier around pretty people',NULL,NULL,NULL,NULL,'如果跟长得丑的人在一起，你会觉得自己变漂亮了；而如果跟漂亮的人在一起，你会觉得自己变丑了。',4,7),(135,'When I’m around tall, thin women all day, I start to feel fat',NULL,NULL,NULL,NULL,'当我身边整天都是又高又瘦的美女时，我开始觉得自己变胖了。',4,1),(136,'Ugly ducklings sometimes turn into swans',NULL,NULL,NULL,NULL,'丑小鸭有时会变成白天鹅。',4,2),(137,'For the first time, I felt that I was attractive',NULL,NULL,NULL,NULL,'我人生第一次觉得自己有魅力。',4,3),(139,'They tend to compare themselves exclusively with very good-looking people',NULL,NULL,NULL,NULL,'他们倾向于只跟那些相貌出众的人进行比较。',4,5),(140,'They were too busy wondering how they looked to crunch numbers correctly',NULL,NULL,NULL,NULL,'她们太急于想知道自己看起来是否得体，而无暇顾及答案的对错。',4,6),(142,'qwe?',NULL,NULL,NULL,NULL,'123',4,1),(144,'123123123','1231231','1231231','23123123','123123','A',1,1),(145,'55555555','333333333','6666666','777777','88888888','C',1,1),(146,'123123123','1231231','1231231','23123123','123123','C',1,1),(147,'123123123','1231231','1231231','23123123','123123','D',1,1),(151,'1234','1','2','3','4','AC',2,1),(152,'ssssssss','ddddddd','ffffffffff','gggggggg','ghhhhhhh','CD',2,1),(153,'rrrrrrrrrrrr','ffffffffff','ddddddddddd','hgghghgh','jkjkjkjkjk','CD',2,1),(154,'4444445','','','','','45666',4,1),(155,'这是个题目','','','','','这是答案',3,1);

/*Table structure for table `questiontype` */

DROP TABLE IF EXISTS `questiontype`;

CREATE TABLE `questiontype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `questiontype` */

insert  into `questiontype`(`id`,`typename`) values (1,'单选题'),(2,'多选题'),(3,'填空题'),(4,'简答题'),(5,'');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `registertime` datetime NOT NULL,
  `identity` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `identity` (`identity`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`identity`) REFERENCES `identity` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`email`,`registertime`,`identity`) values (1,'小明','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','xiaoming@qq.com','2022-03-14 16:23:03',1),(2,'小亮','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','xiaoliang@qq.com','2022-03-15 16:23:15',1),(3,'小白','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','xiaobai@qq.com','2022-03-17 16:23:22',1),(4,'Tom','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','tom@qq.com','2022-02-09 17:28:53',2),(5,'Jerry','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','jerry@qq.com','2022-01-17 17:29:00',2),(6,'rose','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','rose@qq.com','2022-02-01 22:05:25',2),(7,'小黑','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','xiaohei@qq.com','2022-04-17 22:12:14',1);

/* Trigger structure for table `clazz` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `del_CEK_beforeDelClazz` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `del_CEK_beforeDelClazz` BEFORE DELETE ON `clazz` FOR EACH ROW BEGIN
    
    delete from clazz_exampaper_key where c_id = old.id;
    END */$$


DELIMITER ;

/* Trigger structure for table `clazz_user_key` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `increaseClassSize` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `increaseClassSize` AFTER INSERT ON `clazz_user_key` FOR EACH ROW BEGIN
UPDATE clazz c SET c.classSize=c.`classSize`+1 WHERE new.c_id=c.id;
    END */$$


DELIMITER ;

/* Trigger structure for table `clazz_user_key` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `reduceClassSize` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `reduceClassSize` BEFORE DELETE ON `clazz_user_key` FOR EACH ROW BEGIN
UPDATE clazz c SET c.classSize=c.`classSize`-1 WHERE old.c_id=c.id;
    END */$$


DELIMITER ;

/* Trigger structure for table `exampaper` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `del_EQK_beforeDelExampaper` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `del_EQK_beforeDelExampaper` BEFORE DELETE ON `exampaper` FOR EACH ROW BEGIN
    
    #delete from exampaper_question_key  where  e_id = old.id;
    #Can't update table 'exampaper' in stored function/trigger because it is already used by statement which invoked this stored function/trigger.
    END */$$


DELIMITER ;

/* Trigger structure for table `exampaper_question_key` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `increaseQuestionNumber` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `increaseQuestionNumber` BEFORE INSERT ON `exampaper_question_key` FOR EACH ROW BEGIN
    
	UPDATE exampaper e SET e.`questionNumber`=e.`questionNumber`+1 WHERE new.e_id=e.id;
    END */$$


DELIMITER ;

/* Trigger structure for table `exampaper_question_key` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `reduceQuestionNumber` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `reduceQuestionNumber` BEFORE DELETE ON `exampaper_question_key` FOR EACH ROW BEGIN
    
    UPDATE exampaper e SET e.`questionNumber`=e.`questionNumber`-1 WHERE old.e_id=e.id;
    END */$$


DELIMITER ;

/* Trigger structure for table `question` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `del_EQK_beforedelquestion` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `del_EQK_beforedelquestion` BEFORE DELETE ON `question` FOR EACH ROW BEGIN
    
    delete from exampaper_question_key  where q_id = old.id;
    END */$$


DELIMITER ;

/*Table structure for table `classexampaperview` */

DROP TABLE IF EXISTS `classexampaperview`;

/*!50001 DROP VIEW IF EXISTS `classexampaperview` */;
/*!50001 DROP TABLE IF EXISTS `classexampaperview` */;

/*!50001 CREATE TABLE  `classexampaperview`(
 `cid` int(11) ,
 `classname` varchar(500) ,
 `eid` int(11) ,
 `examPaperName` varchar(50) ,
 `creatTime` datetime ,
 `creatperson` varchar(50) ,
 `questionNumber` int(11) 
)*/;

/*Table structure for table `classview` */

DROP TABLE IF EXISTS `classview`;

/*!50001 DROP VIEW IF EXISTS `classview` */;
/*!50001 DROP TABLE IF EXISTS `classview` */;

/*!50001 CREATE TABLE  `classview`(
 `cid` int(11) ,
 `classname` varchar(500) ,
 `classDetails` varchar(1000) ,
 `creatTime` datetime ,
 `classNumber` int(11) ,
 `uid` int(11) ,
 `creatperson` varchar(50) 
)*/;

/*Table structure for table `exampaperhistoryview` */

DROP TABLE IF EXISTS `exampaperhistoryview`;

/*!50001 DROP VIEW IF EXISTS `exampaperhistoryview` */;
/*!50001 DROP TABLE IF EXISTS `exampaperhistoryview` */;

/*!50001 CREATE TABLE  `exampaperhistoryview`(
 `eid` int(11) ,
 `qid` int(11) ,
 `uid` int(11) ,
 `examPaperName` varchar(50) ,
 `question` varchar(1000) ,
 `typename` varchar(50) ,
 `A` varchar(1000) ,
 `B` varchar(1000) ,
 `C` varchar(1000) ,
 `D` varchar(1000) ,
 `ans` varchar(1000) ,
 `creatperson` varchar(50) ,
 `choose` varchar(1000) ,
 `time` datetime 
)*/;

/*Table structure for table `exampaperquestionview` */

DROP TABLE IF EXISTS `exampaperquestionview`;

/*!50001 DROP VIEW IF EXISTS `exampaperquestionview` */;
/*!50001 DROP TABLE IF EXISTS `exampaperquestionview` */;

/*!50001 CREATE TABLE  `exampaperquestionview`(
 `eid` int(11) ,
 `examPaperName` varchar(50) ,
 `qid` int(11) ,
 `question` varchar(1000) ,
 `typename` varchar(50) ,
 `A` varchar(1000) ,
 `B` varchar(1000) ,
 `C` varchar(1000) ,
 `D` varchar(1000) ,
 `ans` varchar(1000) ,
 `creatperson` varchar(50) 
)*/;

/*Table structure for table `myclassview` */

DROP TABLE IF EXISTS `myclassview`;

/*!50001 DROP VIEW IF EXISTS `myclassview` */;
/*!50001 DROP TABLE IF EXISTS `myclassview` */;

/*!50001 CREATE TABLE  `myclassview`(
 `uid` int(11) ,
 `username` varchar(50) ,
 `email` varchar(50) ,
 `identity` varchar(20) ,
 `cid` int(11) ,
 `classname` varchar(500) ,
 `classDetails` varchar(1000) ,
 `creatTime` datetime ,
 `creatperson` varchar(50) ,
 `classNumber` int(11) 
)*/;

/*Table structure for table `myexamview` */

DROP TABLE IF EXISTS `myexamview`;

/*!50001 DROP VIEW IF EXISTS `myexamview` */;
/*!50001 DROP TABLE IF EXISTS `myexamview` */;

/*!50001 CREATE TABLE  `myexamview`(
 `uid` int(11) ,
 `username` varchar(50) ,
 `cid` int(11) ,
 `classname` varchar(500) ,
 `eid` int(11) ,
 `examPaperName` varchar(50) ,
 `creatTime` datetime ,
 `creatperson` varchar(50) ,
 `questionNumber` int(11) 
)*/;

/*Table structure for table `mypaperview` */

DROP TABLE IF EXISTS `mypaperview`;

/*!50001 DROP VIEW IF EXISTS `mypaperview` */;
/*!50001 DROP TABLE IF EXISTS `mypaperview` */;

/*!50001 CREATE TABLE  `mypaperview`(
 `uid` int(11) ,
 `creatperson` varchar(50) ,
 `eid` int(11) ,
 `examPaperName` varchar(50) ,
 `creatTime` datetime ,
 `questionNumber` int(11) 
)*/;

/*Table structure for table `myquestionview` */

DROP TABLE IF EXISTS `myquestionview`;

/*!50001 DROP VIEW IF EXISTS `myquestionview` */;
/*!50001 DROP TABLE IF EXISTS `myquestionview` */;

/*!50001 CREATE TABLE  `myquestionview`(
 `uid` int(11) ,
 `creatperson` varchar(50) ,
 `id` int(11) ,
 `question` varchar(1000) ,
 `A` varchar(1000) ,
 `B` varchar(1000) ,
 `C` varchar(1000) ,
 `D` varchar(1000) ,
 `ans` varchar(1000) ,
 `typename` varchar(50) 
)*/;

/*Table structure for table `myuser` */

DROP TABLE IF EXISTS `myuser`;

/*!50001 DROP VIEW IF EXISTS `myuser` */;
/*!50001 DROP TABLE IF EXISTS `myuser` */;

/*!50001 CREATE TABLE  `myuser`(
 `id` int(11) ,
 `username` varchar(50) ,
 `email` varchar(50) ,
 `password` varchar(100) ,
 `registertime` datetime ,
 `identity` varchar(20) 
)*/;

/*View structure for view classexampaperview */

/*!50001 DROP TABLE IF EXISTS `classexampaperview` */;
/*!50001 DROP VIEW IF EXISTS `classexampaperview` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `classexampaperview` AS (select `c`.`id` AS `cid`,`c`.`c_name` AS `classname`,`e`.`eid` AS `eid`,`e`.`examPaperName` AS `examPaperName`,`e`.`creatTime` AS `creatTime`,`e`.`creatperson` AS `creatperson`,`e`.`questionNumber` AS `questionNumber` from ((`clazz` `c` join `clazz_exampaper_key` `ce`) join `mypaperview` `e`) where ((`c`.`id` = `ce`.`c_id`) and (`ce`.`e_id` = `e`.`eid`))) */;

/*View structure for view classview */

/*!50001 DROP TABLE IF EXISTS `classview` */;
/*!50001 DROP VIEW IF EXISTS `classview` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `classview` AS (select `c`.`id` AS `cid`,`c`.`c_name` AS `classname`,`c`.`c_details` AS `classDetails`,`c`.`creatTIme` AS `creatTime`,`c`.`classSize` AS `classNumber`,`u`.`id` AS `uid`,`u`.`username` AS `creatperson` from (`clazz` `c` join `user` `u`) where (`u`.`id` = `c`.`creatperson`)) */;

/*View structure for view exampaperhistoryview */

/*!50001 DROP TABLE IF EXISTS `exampaperhistoryview` */;
/*!50001 DROP VIEW IF EXISTS `exampaperhistoryview` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `exampaperhistoryview` AS (select `e`.`eid` AS `eid`,`e`.`qid` AS `qid`,`ee`.`u_id` AS `uid`,`e`.`examPaperName` AS `examPaperName`,`e`.`question` AS `question`,`e`.`typename` AS `typename`,`e`.`A` AS `A`,`e`.`B` AS `B`,`e`.`C` AS `C`,`e`.`D` AS `D`,`e`.`ans` AS `ans`,`e`.`creatperson` AS `creatperson`,`ee`.`choose` AS `choose`,`ee`.`time` AS `time` from (`exampaperquestionview` `e` left join `examquestiondetail` `ee` on(((`e`.`eid` = `ee`.`e_id`) and (`e`.`qid` = `ee`.`q_id`))))) */;

/*View structure for view exampaperquestionview */

/*!50001 DROP TABLE IF EXISTS `exampaperquestionview` */;
/*!50001 DROP VIEW IF EXISTS `exampaperquestionview` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `exampaperquestionview` AS (select `e`.`id` AS `eid`,`e`.`name` AS `examPaperName`,`q`.`id` AS `qid`,`q`.`question` AS `question`,`q`.`typename` AS `typename`,`q`.`A` AS `A`,`q`.`B` AS `B`,`q`.`C` AS `C`,`q`.`D` AS `D`,`q`.`ans` AS `ans`,`q`.`creatperson` AS `creatperson` from ((`exampaper` `e` join `exampaper_question_key` `eq`) join `myquestionview` `q`) where ((`e`.`id` = `eq`.`e_id`) and (`eq`.`q_id` = `q`.`id`))) */;

/*View structure for view myclassview */

/*!50001 DROP TABLE IF EXISTS `myclassview` */;
/*!50001 DROP VIEW IF EXISTS `myclassview` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `myclassview` AS (select `u`.`id` AS `uid`,`u`.`username` AS `username`,`u`.`email` AS `email`,`u`.`identity` AS `identity`,`cc`.`cid` AS `cid`,`cc`.`classname` AS `classname`,`cc`.`classDetails` AS `classDetails`,`cc`.`creatTime` AS `creatTime`,`cc`.`creatperson` AS `creatperson`,`cc`.`classNumber` AS `classNumber` from ((`myuser` `u` join `classview` `cc`) join `clazz_user_key` `cu`) where ((`u`.`id` = `cu`.`u_id`) and (`cc`.`cid` = `cu`.`c_id`))) */;

/*View structure for view myexamview */

/*!50001 DROP TABLE IF EXISTS `myexamview` */;
/*!50001 DROP VIEW IF EXISTS `myexamview` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `myexamview` AS (select `u`.`id` AS `uid`,`u`.`username` AS `username`,`c`.`cid` AS `cid`,`c`.`classname` AS `classname`,`c`.`eid` AS `eid`,`c`.`examPaperName` AS `examPaperName`,`c`.`creatTime` AS `creatTime`,`c`.`creatperson` AS `creatperson`,`c`.`questionNumber` AS `questionNumber` from ((`user` `u` join `clazz_user_key` `cu`) join `classexampaperview` `c`) where ((`u`.`id` = `cu`.`u_id`) and (`c`.`cid` = `cu`.`c_id`))) */;

/*View structure for view mypaperview */

/*!50001 DROP TABLE IF EXISTS `mypaperview` */;
/*!50001 DROP VIEW IF EXISTS `mypaperview` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `mypaperview` AS (select `u`.`id` AS `uid`,`u`.`username` AS `creatperson`,`e`.`id` AS `eid`,`e`.`name` AS `examPaperName`,`e`.`creatTime` AS `creatTime`,`e`.`questionNumber` AS `questionNumber` from (`exampaper` `e` join `user` `u` on((`u`.`id` = `e`.`creatperson`)))) */;

/*View structure for view myquestionview */

/*!50001 DROP TABLE IF EXISTS `myquestionview` */;
/*!50001 DROP VIEW IF EXISTS `myquestionview` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `myquestionview` AS (select `u`.`id` AS `uid`,`u`.`username` AS `creatperson`,`q`.`id` AS `id`,`q`.`q_name` AS `question`,`q`.`q_ansA` AS `A`,`q`.`q_ansB` AS `B`,`q`.`q_ansC` AS `C`,`q`.`q_ansD` AS `D`,`q`.`q_ans` AS `ans`,`qt`.`typename` AS `typename` from ((`question` `q` join `questiontype` `qt`) join `user` `u`) where ((`q`.`q_type` = `qt`.`id`) and (`q`.`creatperson` = `u`.`id`))) */;

/*View structure for view myuser */

/*!50001 DROP TABLE IF EXISTS `myuser` */;
/*!50001 DROP VIEW IF EXISTS `myuser` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `myuser` AS (select `u`.`id` AS `id`,`u`.`username` AS `username`,`u`.`email` AS `email`,`u`.`password` AS `password`,`u`.`registertime` AS `registertime`,`i`.`identity` AS `identity` from (`user` `u` join `identity` `i`) where (`u`.`identity` = `i`.`id`)) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
