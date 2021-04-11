INSERT INTO GROUPS (NAME, DIRECTION, STARTDATE)
VALUES ('Java Basic', 'Back-end', '2021-01-01')
     , ('Java Elementary', 'Back-end', '2021-01-04')
     , ('PHP', 'Back-end', '2020-12-29');


INSERT INTO USERS (groupId, role, firstName, lastName, dateOfBirth)
VALUES (1, 'STUDENT', 'Bill',      'Doe',      '2001-2-1')
     , (1, 'STUDENT', 'Ross',      'Brawn',    '1999-11-23')
     , (1, 'STUDENT', 'Zak',       'Brown',    '1982-4-30')
     , (1, 'STUDENT', 'Andreas',   'Sidle',    '1998-12-3')
     , (1, 'STUDENT', 'Frank',     'Williams', '1999-1-22')
     , (1, 'STUDENT', 'Mark',      'Webber',   '1982-3-4')
     , (1, 'STUDENT', 'Sebastien', 'Vettel',   '1998-11-12')
     , (1, 'STUDENT', 'Lewis',     'Hamilton', '1999-9-1')
     , (1, 'STUDENT', 'Felipe',    'Massa',    '2001-5-28')
     , (1, 'STUDENT', 'Fernando',  'Alonso',   '1997-7-30')
     , (1, 'STUDENT', 'Carlos',    'Sainz',    '2003-10-6')
     , (1, 'STUDENT', 'Lando',     'Norris',   '2000-11-8')
     , (1, 'STUDENT', 'Susie',     'Wolf',     '2001-1-3');

INSERT INTO USERS (groupId, role, firstName, lastName, dateOfBirth)
VALUES (2, 'STUDENT', 'Danny',    'Andrade',   '2003-3-5')
     , (2, 'STUDENT', 'Ruben',      'Andrade',    '1999-10-18')
     , (2, 'STUDENT', 'Ethan',       'Asher',    '1982-5-20')
     , (2, 'STUDENT', 'Andrea',   'Bedford',    '1999-1-30')
     , (2, 'STUDENT', 'Mack',     'Blake', '1989-4-22')
     , (2, 'STUDENT', 'Cassandra', 'Benedict',   '1982-3-4')
     , (2, 'STUDENT', 'Pearl', 'Bradford',   '1996-10-11')
     , (2, 'STUDENT', 'DeMott ',   'Capwell', '1997-8-12')
     , (2, 'STUDENT', 'Rafael',    'Castillo',    '2001-5-28')
     , (2, 'STUDENT', 'Jeffrey',  'Conrad',   '1997-3-15')
     , (2, 'STUDENT', 'Micah',    'DeAngelis',    '2001-10-6')
     , (2, 'STUDENT', 'Heather',     'Donnelly',   '2000-11-8')
     , (2, 'STUDENT', 'Christie',     'Duvall',     '2001-1-3');

INSERT INTO USERS (groupId, role, firstName, lastName, dateOfBirth)
VALUES (3, 'STUDENT', 'Mary',    'Duvall',   '2001-4-15')
     , (3, 'STUDENT', 'Cain',      'Garver',    '1993-10-17')
     , (3, 'STUDENT', 'Veronica',   'Gayley',    '1987-9-23')
     , (3, 'STUDENT', 'Amado',   'Gonzalez',    '1999-11-23')
     , (3, 'STUDENT', 'Derek',     'Griffin', '1996-9-9')
     , (3, 'STUDENT', 'Nick', 'Hartley',   '1989-9-10')
     , (3, 'STUDENT', 'Greg', 'Hughes',   '1998-4-13')
     , (3, 'STUDENT', 'Craig ',   'Hunt', '1997-5-7')
     , (3, 'STUDENT', 'Alice',    'Jackson',    '2004-2-14')
     , (3, 'STUDENT', 'Andie',  'Klein',   '1991-8-29')
     , (3, 'STUDENT', 'Jack',    'Lee',    '2000-12-12')
     , (3, 'STUDENT', 'Jerry',     'Cooper',   '2003-10-19')
     , (3, 'STUDENT', 'Caroline',     'Wilson',     '2005-1-30');

INSERT INTO USERS (groupId, role, firstName, lastName, dateOfBirth)
VALUES (1, 'TEACHER', 'Kostia', 'Los',     '1991-1-1')
     , (1, 'TEACHER', 'Steven', 'Hawking', '1945-9-23')
     , (1, 'TEACHER', 'Alex',   'Big',   '1982-5-22');

INSERT INTO USERS (groupId, role, firstName, lastName, dateOfBirth)
VALUES (2, 'TEACHER', 'Sylvester', 'Stallone',     '1992-1-11')
     , (2, 'TEACHER', 'Jason', 'Statham', '1965-9-13')
     , (2, 'TEACHER', 'Harrison',   'Ford',   '1972-5-12');

INSERT INTO USERS (groupId, role, firstName, lastName, dateOfBirth)
VALUES (3, 'TEACHER', 'Mel', 'Gibson',     '1971-11-12')
     , (3, 'TEACHER', 'Dolph', 'Lundgren', '1995-4-20')
     , (3, 'TEACHER', 'Wesley',   'Snipes',   '1972-3-15');

INSERT INTO lessons (groupId, topic, materials, lessonDate)
VALUES (1, 'Topic 1', 'Course introduction',          '2021-01-01 14:00:00')
     , (1, 'Topic 2', 'Basics Recall',                '2021-04-04 14:00:00')
     , (1, 'Topic 3', 'Java core',                    '2021-07-07 14:00:00')
     , (1, 'Topic 4', 'Java memory, Arrays',          '2021-07-10 14:00:00')
     , (1, 'Topic 5', 'Single responsibility',        '2021-07-13 14:00:00')
     , (1, 'Topic 6', 'Encapsulation',                '2021-07-16 14:00:00')
     , (1, 'Topic 7', 'Abstraction',                  '2021-07-19 14:00:00')
     , (1, 'Topic 8', 'OOP, Collections introduction','2021-07-22 14:00:00')
     , (1, 'Topic 9', 'Exceptions and LinkedList',    '2021-07-25 14:00:00')
     , (1, 'Topic 10', 'Nested Classes POJO ',        '2021-07-28 14:00:00')
     , (1, 'Topic 11', 'Set and Iterators',           '2021-08-01 14:00:00')
     , (1, 'Topic 12', 'Generics',                    '2021-08-04 14:00:00')
     , (1, 'Topic 13', 'Map Interface',               '2021-08-07 14:00:00')
     , (1, 'Topic 14', 'RegEx',                       '2021-08-10 14:00:00')
     , (1, 'Topic 15', 'Diploma project start',       '2021-08-13 14:00:00')
     , (1, 'Topic 16', 'Layer Architecture',          '2021-08-16 14:00:00')
     , (1, 'Topic 17', 'Singleton, Utility',          '2021-08-19 14:00:00')
     , (1, 'Topic 18', 'Java IO',                     '2021-08-22 14:00:00')
     , (1, 'Topic 19', 'Character encoding',          '2021-08-25 14:00:00')
     , (1, 'Topic 20', 'Databases',                   '2021-08-28 14:00:00')
     , (1, 'Topic 21', 'SQL',                         '2021-09-01 14:00:00')
     , (1, 'Topic 22', 'DBMS types',                  '2021-09-04 14:00:00')
     , (1, 'Topic 23', 'Relational DBs',              '2021-09-07 14:00:00')
     , (1, 'Topic 24', 'SQL JOINS & JDBC',            '2021-09-10 14:00:00')
     , (1, 'Topic 25', 'GOF patterns overview',       '2021-09-13 14:00:00')
     , (1, 'Topic 26', 'Factory method',              '2021-09-16 14:00:00')
     , (1, 'Topic 27', 'Abstract Factory',            '2021-09-19 14:00:00')
     , (1, 'Topic 28', 'Chain of Responsibility',     '2021-09-22 14:00:00')
     , (1, 'Topic 29', 'Command',                     '2021-09-25 14:00:00')
     , (1, 'Topic 30', 'Annotation',                  '2021-09-28 14:00:00')
     , (1, 'Topic 31', 'Interfaces',                  '2021-10-01 14:00:00')
     , (1, 'Topic 32', 'Abstraction',                 '2021-10-04 14:00:00')
     , (1, 'Topic 33', 'Sorting',                     '2021-10-07 14:00:00')
     , (1, 'Topic 34', 'Lambda',                      '2021-10-10 14:00:00')
     , (1, 'Topic 35', 'Functional interfaces',       '2021-10-13 14:00:00');

    INSERT INTO lessons (groupId, topic, materials, lessonDate)
VALUES    (2, 'Topic 1', 'OOPS concepts',                   '2021-01-01 15:00:00')
        , (2, 'Topic 2', 'Data Abstraction',                '2021-04-04 15:00:00')
        , (2, 'Topic 3', 'Encapsulation',                   '2021-07-07 15:00:00')
        , (2, 'Topic 4', 'Arrays',                          '2021-07-10 15:00:00')
        , (2, 'Topic 5', 'Inheritance',                     '2021-07-13 15:00:00')
        , (2, 'Topic 6', 'Polymorphism',                    '2021-07-16 15:00:00')
        , (2, 'Topic 7', 'Basic Java constructs like loops and data types',                  '2021-07-19 15:00:00')
        , (2, 'Topic 8', 'String handling',                 '2021-07-22 15:00:00')
        , (2, 'Topic 9', 'Collection framework',            '2021-07-25 15:00:00')
        , (2, 'Topic 10', 'Multithreading ',                '2021-07-28 15:00:00')
        , (2, 'Topic 11', 'Exception handling',             '2021-08-01 15:00:00')
        , (2, 'Topic 12', 'Generics',                       '2021-08-04 15:00:00')
        , (2, 'Topic 13', 'Synchronisation',                '2021-08-07 15:00:00')
        , (2, 'Topic 14', 'RegEx',                          '2021-08-10 15:00:00')
        , (2, 'Topic 15', 'Serialisation & De-serialisation',       '2021-08-13 15:00:00')
        , (2, 'Topic 16', 'Concurrent collection',          '2021-08-16 15:00:00')
        , (2, 'Topic 17', 'Singleton, Utility',             '2021-08-19 15:00:00')
        , (2, 'Topic 18', 'JDBC (Java Database Connectivity)',                     '2021-08-22 15:00:00')
        , (2, 'Topic 19', 'Servlet',                        '2021-08-25 15:00:00')
        , (2, 'Topic 20', 'Databases',                      '2021-08-28 15:00:00')
        , (2, 'Topic 21', 'JSP',                            '2021-09-01 15:00:00')
        , (2, 'Topic 22', 'Spring ',                        '2021-09-04 15:00:00')
        , (2, 'Topic 23', 'MVC',                            '2021-09-07 15:00:00')
        , (2, 'Topic 24', 'Core',                           '2021-09-10 15:00:00')
        , (2, 'Topic 25', 'JDBC',                           '2021-09-13 15:00:00')
        , (2, 'Topic 26', 'ORM',                            '2021-09-16 15:00:00')
        , (2, 'Topic 27', 'AOP',                            '2021-09-19 15:00:00')
        , (2, 'Topic 28', 'Chain of Responsibility',        '2021-09-22 15:00:00')
        , (2, 'Topic 29', 'Hibernate ORM framework',        '2021-09-25 15:00:00')
        , (2, 'Topic 30', 'Struts',                         '2021-09-28 15:00:00')
        , (2, 'Topic 31', 'JSF',                            '2021-10-01 15:00:00')
        , (2, 'Topic 32', 'Web Services (SOAP & REST)',     '2021-10-04 15:00:00')
        , (2, 'Topic 33', 'Java Stream Benefits',           '2021-10-07 15:00:00')
        , (2, 'Topic 34', 'Externalizable In Java with Example',                      '2021-10-10 15:00:00')
        , (2, 'Topic 35', 'Reader Class In Java',           '2021-10-13 15:00:00');

INSERT INTO lessons (groupId, topic, materials, lessonDate)
VALUES    (3, 'Topic 1', 'Getting Started',                   '2021-01-01 16:00:00')
        , (3, 'Topic 2', 'Installation and Configuration',    '2021-04-04 16:00:00')
        , (3, 'Topic 3', 'Language Reference',                '2021-07-07 16:00:00')
        , (3, 'Topic 4', 'Security',                          '2021-07-10 16:00:00')
        , (3, 'Topic 5', 'Features',                          '2021-07-13 16:00:00')
        , (3, 'Topic 6', 'Function Reference',                '2021-07-16 16:00:00')
        , (3, 'Topic 7', 'PHP at the Core: A Hacker’s Guide', '2021-07-19 16:00:00')
        , (3, 'Topic 8', 'FAQ',                               '2021-07-22 16:00:00')
        , (3, 'Topic 9', 'PHP Files',                         '2021-07-25 16:00:00')
        , (3, 'Topic 10', 'PHP Strings',                      '2021-07-28 16:00:00')
        , (3, 'Topic 11', 'PHP Advanced',                     '2021-08-01 16:00:00')
        , (3, 'Topic 12', 'PHP Basics',                       '2021-08-04 16:00:00')
        , (3, 'Topic 13', 'PHP Forms',                        '2021-08-07 16:00:00')
        , (3, 'Topic 14', 'PHP Advanced',                     '2021-08-10 16:00:00')
        , (3, 'Topic 15', 'MySQL Database',                   '2021-08-13 16:00:00')
        , (3, 'Topic 16', 'PHP-XML',                          '2021-08-16 16:00:00')
        , (3, 'Topic 17', 'PHP-AJAX',                         '2021-08-19 16:00:00')
        , (3, 'Topic 18', 'PHP Examples',                     '2021-08-22 16:00:00')
        , (3, 'Topic 19', 'PHP Reference',                    '2021-08-25 16:00:00')
        , (3, 'Topic 20', 'Variables and operators',          '2021-08-28 16:00:00')
        , (3, 'Topic 21', 'Control structures, arrays and PHP array functions',    '2021-09-01 16:00:00')
        , (3, 'Topic 22', 'External files',                   '2021-09-04 16:00:00')
        , (3, 'Topic 23', 'OOP in PHP4 and PHP5',             '2021-09-07 16:00:00')
        , (3, 'Topic 24', 'MySQL database form PHP',          '2021-09-10 16:00:00')
        , (3, 'Topic 25', 'SQLite',                           '2021-09-13 16:00:00')
        , (3, 'Topic 26', 'Sessions and Cookies',             '2021-09-16 16:00:00')
        , (3, 'Topic 27', 'PHP’s easiest method with dealing with XML',            '2021-09-19 16:00:00')
        , (3, 'Topic 28', 'Basic error handling and security',     '2021-09-22 16:00:00')
        , (3, 'Topic 29', 'Web Application Implementation',        '2021-09-25 16:00:00')
        , (3, 'Topic 30', 'Simple RSS news aggregator creation',   '2021-09-28 16:00:00')
        , (3, 'Topic 31', 'OOP PHP',                          '2021-10-01 16:00:00')
        , (3, 'Topic 32', 'Advanced PHP',                     '2021-10-04 16:00:00')
        , (3, 'Topic 33', 'PHP Form Examples',                '2021-10-07 16:00:00')
        , (3, 'Topic 34', 'PHP Login Examples',               '2021-10-10 16:00:00')
        , (3, 'Topic 35', 'PHP Ajax Examples',                '2021-10-13 16:00:00');

INSERT INTO homeTask (lessonId,task,materials,hwTaskDate,deadLine)
VALUES (1,'Task 1 for lesson 1','materials for task 1',   '2021-01-01','2021-04-04')
      ,(2,'Task 2 for lesson 2','materials for task 2',   '2021-04-04','2021-07-07')
      ,(3,'Task 3 for lesson 3','materials for task 3',   '2021-07-07','2021-07-10')
      ,(4,'Task 4 for lesson 4','materials for task 4',   '2021-07-10','2021-07-13')
      ,(5,'Task 5 for lesson 5','materials for task 5',   '2021-07-13','2021-07-16')
      ,(6,'Task 6 for lesson 6','materials for task 6',   '2021-07-16','2021-07-19')
      ,(7,'Task 7 for lesson 7','materials for task 7',   '2021-07-19','2021-07-22')
      ,(8,'Task 8 for lesson 8','materials for task 8',   '2021-07-22','2021-07-25')
      ,(9,'Task 9 for lesson 9','materials for task 9',   '2021-07-25','2021-07-28')
      ,(10,'Task 10 for lesson 10','materials for task 10','2021-07-28','2021-08-01')
      ,(11,'Task 11 for lesson 11','materials for task 11','2021-08-01','2021-08-04')
      ,(12,'Task 12 for lesson 12','materials for task 12','2021-08-04','2021-08-07')
      ,(13,'Task 13 for lesson 13','materials for task 13','2021-08-07','2021-08-10')
      ,(14,'Task 14 for lesson 14','materials for task 14','2021-08-10','2021-08-13')
      ,(15,'Task 15 for lesson 15','materials for task 15','2021-08-13','2021-08-16')
      ,(16,'Task 16 for lesson 16','materials for task 16','2021-08-16','2021-08-19')
      ,(17,'Task 17 for lesson 17','materials for task 17','2021-08-19','2021-08-22')
      ,(18,'Task 18 for lesson 18','materials for task 19','2021-08-22','2021-08-25')
      ,(19,'Task 19 for lesson 19','materials for task 20','2021-08-25','2021-08-28')
      ,(20,'Task 20 for lesson 20','materials for task 21','2021-08-28','2021-09-01')
      ,(21,'Task 21 for lesson 21','materials for task 22','2021-09-01','2021-09-04')
      ,(22,'Task 22 for lesson 22','materials for task 23','2021-09-04','2021-09-07')
      ,(23,'Task 23 for lesson 23','materials for task 24','2021-09-07','2021-09-10')
      ,(24,'Task 24 for lesson 24','materials for task 25','2021-09-10','2021-09-13')
      ,(25,'Task 25 for lesson 25','materials for task 26','2021-09-13','2021-09-16')
      ,(26,'Task 26 for lesson 26','materials for task 27','2021-09-16','2021-09-19')
      ,(27,'Task 27 for lesson 27','materials for task 28','2021-09-19','2021-09-22')
      ,(28,'Task 28 for lesson 28','materials for task 29','2021-09-22','2021-09-25')
      ,(29,'Task 29 for lesson 29','materials for task 30','2021-09-25','2021-09-28')
      ,(30,'Task 30 for lesson 30','materials for task 31','2021-09-28','2021-10-01')
      ,(31,'Task 31 for lesson 31','materials for task 32','2021-10-01','2021-10-04')
      ,(32,'Task 32 for lesson 32','materials for task 33','2021-10-04','2021-10-07')
      ,(33,'Task 33 for lesson 33','materials for task 34','2021-10-07','2021-10-10')
      ,(34,'Task 34 for lesson 34','materials for task 35','2021-10-10','2021-10-13')
      ,(35,'Task 35 for lesson 35','materials for task 36','2021-10-13','2021-10-16');

INSERT INTO homeTask (lessonId,task,materials,hwTaskDate,deadLine)
VALUES(36,'Task 1 for lesson 1','materials for task 1',   '2021-01-01','2021-04-04')
     ,(37,'Task 2 for lesson 2','materials for task 2',   '2021-04-04','2021-07-07')
     ,(38,'Task 3 for lesson 3','materials for task 3',   '2021-07-07','2021-07-10')
     ,(39,'Task 4 for lesson 4','materials for task 4',   '2021-07-10','2021-07-13')
     ,(40,'Task 5 for lesson 5','materials for task 5',   '2021-07-13','2021-07-16')
     ,(41,'Task 6 for lesson 6','materials for task 6',   '2021-07-16','2021-07-19')
     ,(42,'Task 7 for lesson 7','materials for task 7',   '2021-07-19','2021-07-22')
     ,(43,'Task 8 for lesson 8','materials for task 8',   '2021-07-22','2021-07-25')
     ,(44,'Task 9 for lesson 9','materials for task 9',   '2021-07-25','2021-07-28')
     ,(45,'Task 10 for lesson 10','materials for task 10','2021-07-28','2021-08-01')
     ,(46,'Task 11 for lesson 11','materials for task 11','2021-08-01','2021-08-04')
     ,(47,'Task 12 for lesson 12','materials for task 12','2021-08-04','2021-08-07')
     ,(48,'Task 13 for lesson 13','materials for task 13','2021-08-07','2021-08-10')
     ,(49,'Task 14 for lesson 14','materials for task 14','2021-08-10','2021-08-13')
     ,(50,'Task 15 for lesson 15','materials for task 15','2021-08-13','2021-08-16')
     ,(51,'Task 16 for lesson 16','materials for task 16','2021-08-16','2021-08-19')
     ,(52,'Task 17 for lesson 17','materials for task 17','2021-08-19','2021-08-22')
     ,(53,'Task 18 for lesson 18','materials for task 19','2021-08-22','2021-08-25')
     ,(54,'Task 19 for lesson 19','materials for task 20','2021-08-25','2021-08-28')
     ,(55,'Task 20 for lesson 20','materials for task 21','2021-08-28','2021-09-01')
     ,(56,'Task 21 for lesson 21','materials for task 22','2021-09-01','2021-09-04')
     ,(57,'Task 22 for lesson 22','materials for task 23','2021-09-04','2021-09-07')
     ,(58,'Task 23 for lesson 23','materials for task 24','2021-09-07','2021-09-10')
     ,(59,'Task 24 for lesson 24','materials for task 25','2021-09-10','2021-09-13')
     ,(60,'Task 25 for lesson 25','materials for task 26','2021-09-13','2021-09-16')
     ,(61,'Task 26 for lesson 26','materials for task 27','2021-09-16','2021-09-19')
     ,(62,'Task 27 for lesson 27','materials for task 28','2021-09-19','2021-09-22')
     ,(63,'Task 28 for lesson 28','materials for task 29','2021-09-22','2021-09-25')
     ,(64,'Task 29 for lesson 29','materials for task 30','2021-09-25','2021-09-28')
     ,(65,'Task 30 for lesson 30','materials for task 31','2021-09-28','2021-10-01')
     ,(66,'Task 31 for lesson 31','materials for task 32','2021-10-01','2021-10-04')
     ,(67,'Task 32 for lesson 32','materials for task 33','2021-10-04','2021-10-07')
     ,(68,'Task 33 for lesson 33','materials for task 34','2021-10-07','2021-10-10')
     ,(69,'Task 34 for lesson 34','materials for task 35','2021-10-10','2021-10-13')
     ,(70,'Task 35 for lesson 35','materials for task 36','2021-10-13','2021-10-16');

INSERT INTO homeTask (lessonId,task,materials,hwTaskDate,deadLine)
VALUES(71,'Task 1 for lesson 1','materials for task 1',   '2021-01-01','2021-04-04')
     ,(72,'Task 2 for lesson 2','materials for task 2',   '2021-04-04','2021-07-07')
     ,(73,'Task 3 for lesson 3','materials for task 3',   '2021-07-07','2021-07-10')
     ,(74,'Task 4 for lesson 4','materials for task 4',   '2021-07-10','2021-07-13')
     ,(75,'Task 5 for lesson 5','materials for task 5',   '2021-07-13','2021-07-16')
     ,(76,'Task 6 for lesson 6','materials for task 6',   '2021-07-16','2021-07-19')
     ,(77,'Task 7 for lesson 7','materials for task 7',   '2021-07-19','2021-07-22')
     ,(78,'Task 8 for lesson 8','materials for task 8',   '2021-07-22','2021-07-25')
     ,(79,'Task 9 for lesson 9','materials for task 9',   '2021-07-25','2021-07-28')
     ,(80,'Task 10 for lesson 10','materials for task 10','2021-07-28','2021-08-01')
     ,(81,'Task 11 for lesson 11','materials for task 11','2021-08-01','2021-08-04')
     ,(82,'Task 12 for lesson 12','materials for task 12','2021-08-04','2021-08-07')
     ,(83,'Task 13 for lesson 13','materials for task 13','2021-08-07','2021-08-10')
     ,(84,'Task 14 for lesson 14','materials for task 14','2021-08-10','2021-08-13')
     ,(85,'Task 15 for lesson 15','materials for task 15','2021-08-13','2021-08-16')
     ,(86,'Task 16 for lesson 16','materials for task 16','2021-08-16','2021-08-19')
     ,(87,'Task 17 for lesson 17','materials for task 17','2021-08-19','2021-08-22')
     ,(88,'Task 18 for lesson 18','materials for task 19','2021-08-22','2021-08-25')
     ,(89,'Task 19 for lesson 19','materials for task 20','2021-08-25','2021-08-28')
     ,(90,'Task 20 for lesson 20','materials for task 21','2021-08-28','2021-09-01')
     ,(91,'Task 21 for lesson 21','materials for task 22','2021-09-01','2021-09-04')
     ,(92,'Task 22 for lesson 22','materials for task 23','2021-09-04','2021-09-07')
     ,(93,'Task 23 for lesson 23','materials for task 24','2021-09-07','2021-09-10')
     ,(94,'Task 24 for lesson 24','materials for task 25','2021-09-10','2021-09-13')
     ,(95,'Task 25 for lesson 25','materials for task 26','2021-09-13','2021-09-16')
     ,(96,'Task 26 for lesson 26','materials for task 27','2021-09-16','2021-09-19')
     ,(97,'Task 27 for lesson 27','materials for task 28','2021-09-19','2021-09-22')
     ,(98,'Task 28 for lesson 28','materials for task 29','2021-09-22','2021-09-25')
     ,(99,'Task 29 for lesson 29','materials for task 30','2021-09-25','2021-09-28')
     ,(100,'Task 30 for lesson 30','materials for task 31','2021-09-28','2021-10-01')
     ,(101,'Task 31 for lesson 31','materials for task 32','2021-10-01','2021-10-04')
     ,(102,'Task 32 for lesson 32','materials for task 33','2021-10-04','2021-10-07')
     ,(103,'Task 33 for lesson 33','materials for task 34','2021-10-07','2021-10-10')
     ,(104,'Task 34 for lesson 34','materials for task 35','2021-10-10','2021-10-13')
     ,(105,'Task 35 for lesson 35','materials for task 36','2021-10-13','2021-10-16');

INSERT INTO homeWork (userId,hwTaskId,materialsHomeWork,dateCreate)
VALUES(1 ,1,'Materials for hwTask 1','2021-01-01'),
      (2 ,1,'Materials for hwTask 1','2021-01-02'),
      (3 ,1,'Materials for hwTask 1','2021-01-01'),
      (4 ,1,'Materials for hwTask 1','2021-01-03'),
      (5 ,1,'Materials for hwTask 1','2021-01-03'),
      (6 ,1,'Materials for hwTask 1','2021-01-01'),
      (7 ,1,'Materials for hwTask 1','2021-01-01'),
      (8 ,1,'Materials for hwTask 1','2021-01-01'),
      (9 ,1,'Materials for hwTask 1','2021-01-04'),
      (10,1,'Materials for hwTask 1','2021-01-02'),
      (11,1,'Materials for hwTask 1','2021-01-01'),
      (12,1,'Materials for hwTask 1','2021-01-03'),
      (13,1,'Materials for hwTask 1','2021-01-01');

INSERT INTO homeWork (userId,hwTaskId,materialsHomeWork,dateCreate)
VALUES(14,1,'Materials for hwTask 1','2021-01-01'),
      (15,1,'Materials for hwTask 1','2021-01-03'),
      (16,1,'Materials for hwTask 1','2021-01-02'),
      (17,1,'Materials for hwTask 1','2021-01-03'),
      (18,1,'Materials for hwTask 1','2021-01-03'),
      (19,1,'Materials for hwTask 1','2021-01-01'),
      (20,1,'Materials for hwTask 1','2021-01-01'),
      (21,1,'Materials for hwTask 1','2021-01-01'),
      (22,1,'Materials for hwTask 1','2021-01-04'),
      (23,1,'Materials for hwTask 1','2021-01-04'),
      (24,1,'Materials for hwTask 1','2021-01-01'),
      (25,1,'Materials for hwTask 1','2021-01-03'),
      (26,1,'Materials for hwTask 1','2021-01-04');

INSERT INTO homeWork (userId,hwTaskId,materialsHomeWork,dateCreate)
VALUES(27,1,'Materials for hwTask 1','2021-01-01'),
      (28,1,'Materials for hwTask 1','2021-01-03'),
      (29,1,'Materials for hwTask 1','2021-01-02'),
      (30,1,'Materials for hwTask 1','2021-01-03'),
      (31,1,'Materials for hwTask 1','2021-01-03'),
      (32,1,'Materials for hwTask 1','2021-01-01'),
      (33,1,'Materials for hwTask 1','2021-01-01'),
      (34,1,'Materials for hwTask 1','2021-01-01'),
      (35,1,'Materials for hwTask 1','2021-01-04'),
      (36,1,'Materials for hwTask 1','2021-01-04'),
      (37,1,'Materials for hwTask 1','2021-01-01'),
      (38,1,'Materials for hwTask 1','2021-01-03'),
      (39,1,'Materials for hwTask 1','2021-01-04');

INSERT INTO homeWork (userId,hwTaskId,materialsHomeWork,dateCreate)
VALUES(1 ,2,'Materials for hwTask 2','2021-01-07'),
      (2 ,2,'Materials for hwTask 2','2021-01-10'),
      (3 ,2,'Materials for hwTask 2','2021-01-08'),
      (4 ,2,'Materials for hwTask 2','2021-01-09'),
      (5 ,2,'Materials for hwTask 2','2021-01-10'),
      (6 ,2,'Materials for hwTask 2','2021-01-07'),
      (7 ,2,'Materials for hwTask 2','2021-01-10'),
      (8 ,2,'Materials for hwTask 2','2021-01-08'),
      (9 ,2,'Materials for hwTask 2','2021-01-09'),
      (10,2,'Materials for hwTask 2','2021-01-10'),
      (11,2,'Materials for hwTask 2','2021-01-07'),
      (12,2,'Materials for hwTask 2','2021-01-09'),
      (13,2,'Materials for hwTask 2','2021-01-08');

INSERT INTO homeWork (userId,hwTaskId,materialsHomeWork,dateCreate)
VALUES(14,2,'Materials for hwTask 2','2021-01-10'),
      (15,2,'Materials for hwTask 2','2021-01-07'),
      (16,2,'Materials for hwTask 2','2021-01-10'),
      (17,2,'Materials for hwTask 2','2021-01-08'),
      (18,2,'Materials for hwTask 2','2021-01-09'),
      (19,2,'Materials for hwTask 2','2021-01-10'),
      (20,2,'Materials for hwTask 2','2021-01-07'),
      (21,2,'Materials for hwTask 2','2021-01-09'),
      (22,2,'Materials for hwTask 2','2021-01-08'),
      (23,2,'Materials for hwTask 2','2021-01-09'),
      (24,2,'Materials for hwTask 2','2021-01-10'),
      (25,2,'Materials for hwTask 2','2021-01-07'),
      (26,2,'Materials for hwTask 2','2021-01-09');

INSERT INTO homeWork (userId,hwTaskId,materialsHomeWork,dateCreate)
VALUES(27,2,'Materials for hwTask 2','2021-01-07'),
      (28,2,'Materials for hwTask 2','2021-01-10'),
      (29,2,'Materials for hwTask 2','2021-01-08'),
      (30,2,'Materials for hwTask 2','2021-01-09'),
      (31,2,'Materials for hwTask 2','2021-01-10'),
      (32,2,'Materials for hwTask 2','2021-01-07'),
      (33,2,'Materials for hwTask 2','2021-01-09'),
      (34,2,'Materials for hwTask 2','2021-01-08'),
      (35,2,'Materials for hwTask 2','2021-01-09'),
      (36,2,'Materials for hwTask 2','2021-01-10'),
      (37,2,'Materials for hwTask 2','2021-01-07'),
      (38,2,'Materials for hwTask 2','2021-01-09'),
      (39,2,'Materials for hwTask 2','2021-01-08');

INSERT INTO feeds (feedId,groupId)
VALUES (1,1)
      ,(2,2)
      ,(3,3);

INSERT INTO posts (feedId,text,author,datePosted)
VALUES (1,'My super post','Author 5', '2021-04-04')
     ,(1,'My super post','Author 2', '2021-03-17')
     ,(1,'My super post','Author 78', '2021-03-17')
     ,(1,'My super post','Author 12', '2021-03-17')
     ,(1,'My super post','Author 2', '2021-01-27')
     ,(1,'My super post','Author 34', '2021-02-18')
     ,(1,'My super post','Author 2', '2021-01-21')
     ,(1,'My super post','Author 9', '2021-02-15')
     ,(1,'My super post','Author 1', '2021-01-30');

INSERT INTO posts (feedId,text,author,datePosted)
VALUES(2,'My super post','Author 74', '2021-04-04')
     ,(2,'My super post','Author 13', '2021-03-17')
     ,(2,'My super post','Author 24', '2021-03-17')
     ,(2,'My super post','Author 3', '2021-03-17')
     ,(2,'My super post','Author 25', '2021-01-27')
     ,(2,'My super post','Author 92', '2021-02-18')
     ,(2,'My super post','Author 1', '2021-01-21')
     ,(2,'My super post','Author 92', '2021-02-15')
     ,(2,'My super post','Author 92', '2021-01-28');

INSERT INTO posts (feedId,text,author,datePosted)
VALUES(3,'My super post','Author 74', '2021-01-04')
     ,(3,'My super post','Author 1', '2021-04-17')
     ,(3,'My super post','Author 24', '2021-02-01')
     ,(3,'My super post','Author 31', '2021-01-07')
     ,(3,'My super post','Author 2', '2021-03-27')
     ,(3,'My super post','Author 90', '2021-01-18')
     ,(3,'My super post','Author 11', '2021-01-11')
     ,(3,'My super post','Author 98', '2021-02-25')
     ,(3,'My super post','Author 97', '2021-01-30');