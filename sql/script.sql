/*
 * Execute this script before before run the app 
 * Database: MySQL
 * 
 * Author: Loiane Groner
 * http://loianegroner.com.br (English)
 * http://loiane.com.br (Portuguese)
 */

/*
 * CREATE TABLE  contact (
  CONTACT_ID int NOT NULL IDENTITY,
  CONTACT_EMAIL varchar(255) NOT NULL,
  CONTACT_NAME varchar(255) NOT NULL,
  CONTACT_PHONE varchar(255) NOT NULL,
  PRIMARY KEY (CONTACT_ID)
) 
 */


DROP TABLE IF EXISTS `braziljs`.`contact`;
CREATE TABLE  `braziljs`.`contact` (
  `CONTACT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CONTACT_EMAIL` varchar(255) NOT NULL,
  `CONTACT_NAME` varchar(255) NOT NULL,
  `CONTACT_PHONE` varchar(255) NOT NULL,
  PRIMARY KEY (`CONTACT_ID`)
) 
ENGINE=InnoDB;

insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact0','(000) 000-0000', 'contact0@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact1', '(000) 000-0000', 'contact1@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact2', '(000) 000-0000', 'contact2@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact3', '(000) 000-0000', 'contact3@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact4', '(000) 000-0000', 'contact4@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact5', '(000) 000-0000', 'contact5@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact6', '(000) 000-0000', 'contact6@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact7', '(000) 000-0000', 'contact7@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact8', '(000) 000-0000', 'contact8@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact9', '(000) 000-0000', 'contact9@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact10', '(000) 000-0000', 'contact10@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact11', '(000) 000-0000', 'contact11@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact12', '(000) 000-0000', 'contact12@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact13', '(000) 000-0000', 'contact13@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact14', '(000) 000-0000', 'contact14@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact15', '(000) 000-0000', 'contact15@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact16', '(000) 000-0000', 'contact16@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact17', '(000) 000-0000', 'contact17@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact18', '(000) 000-0000', 'contact18@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact19', '(000) 000-0000', 'contact19@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact20', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact21', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact22', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact23', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact24', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact25', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact26', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact27', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact28', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact29', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact30', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact31', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact32', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact33', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact34', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact35', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact36', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact37', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact38', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact39', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact40', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact41', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact42', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact43', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact44', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact45', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact46', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact47', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact48', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact49', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact50', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact51', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact52', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact53', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact54', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact55', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact56', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact57', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact58', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact59', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact60', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact61', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact62', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact63', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact64', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact65', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact66', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact67', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact68', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact69', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact70', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact71', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact72', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact73', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact74', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact75', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact76', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact77', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact78', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact79', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact80', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact81', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact82', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact83', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact84', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact85', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact86', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact87', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact88', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact89', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact90', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact91', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact92', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact93', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact94', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact95', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact96', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact97', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact98', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact99', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact101', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact102', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact103', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact104', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact105', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact106', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact107', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact108', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact109', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact110', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact111', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact112', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact113', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact114', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact115', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact116', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact117', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact118', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact119', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact120', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact121', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact122', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact123', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact124', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact125', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact126', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact127', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact128', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact129', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact130', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact131', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact132', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact133', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact134', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact135', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact136', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact137', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact138', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact139', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact140', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact141', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact142', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact143', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact144', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact145', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact146', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact147', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact148', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact149', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact150', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact151', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact152', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact153', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact154', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact155', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact156', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact157', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact158', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact159', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact160', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact161', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact162', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact163', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact164', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact165', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact166', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact167', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact168', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact169', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact170', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact171', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact172', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact173', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact174', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact175', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact176', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact177', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact178', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact179', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact180', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact181', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact182', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact183', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact184', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact185', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact186', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact187', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact188', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact189', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact190', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact191', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact192', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact193', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact194', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact195', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact196', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact197', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact198', '(000) 000-0000', 'Contact@braziljs.com.br');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact199', '(000) 000-0000', 'Contact@braziljs.com.br');

