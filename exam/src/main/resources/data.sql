-- Exams
INSERT INTO EXAM (name, description) VALUES ('Java Exam', 'Show your Java skills!');
INSERT INTO EXAM (name, description) VALUES ('Spring Boot', 'Lets see how good  you are?');

-- Java Questions with Answers
INSERT INTO QUESTION (exam_id, name, multi_answer) VALUES (1, 'Which collection cannot contain duplicate elements', 0);
INSERT INTO ANSWER (question_id, name, is_correct) VALUES (1, 'Set', 1);
INSERT INTO ANSWER (question_id, name, is_correct) VALUES (1, 'Map', 0);
INSERT INTO ANSWER (question_id, name, is_correct) VALUES (1, 'List', 0);

INSERT INTO QUESTION (exam_id, name, multi_answer) VALUES (1, 'What are the basic interfaces of Java Collections Framework ?', 1);
INSERT INTO ANSWER (question_id, name, is_correct) VALUES (2, 'Set', 1);
INSERT INTO ANSWER (question_id, name, is_correct) VALUES (2, 'Random', 0);
INSERT INTO ANSWER (question_id, name, is_correct) VALUES (2, 'List', 1);

INSERT INTO QUESTION (exam_id, name, multi_answer) VALUES (1, 'What’s a deadlock ?', 0);
INSERT INTO ANSWER (question_id, name, is_correct) VALUES (3, 'A condition that occurs when two processes are waiting for each other to complete', 1);
INSERT INTO ANSWER (question_id, name, is_correct) VALUES (3, 'Endless loop', 0);
INSERT INTO ANSWER (question_id, name, is_correct) VALUES (3, 'Broken lock', 0);

-- Scala Questions with Answers
INSERT INTO QUESTION (exam_id, name, multi_answer) VALUES (2, 'ARE DI and AOP pillars of spring boot ? ', 0);
INSERT INTO ANSWER (question_id, name, is_correct) VALUES (4, 'YES', 1);
INSERT INTO ANSWER (question_id, name, is_correct) VALUES (4, 'NO', 0);
INSERT INTO ANSWER (question_id, name, is_correct) VALUES (4, 'Spring boot is joke', 0);

INSERT INTO QUESTION (exam_id, name, multi_answer) VALUES (2, 'What is Spring Boot?', 1);
INSERT INTO ANSWER (question_id, name, is_correct) VALUES (5, 'Java Framework', 1);
INSERT INTO ANSWER (question_id, name, is_correct) VALUES (5, 'Opinated version of spring', 1);
INSERT INTO ANSWER (question_id, name, is_correct) VALUES (5, 'Every developer dream', 1);

INSERT INTO QUESTION (exam_id, name, multi_answer) VALUES (2, 'Do Spring Boot supports java?', 0);
INSERT INTO ANSWER (question_id, name, is_correct) VALUES (6, 'Yes', 1);
INSERT INTO ANSWER (question_id, name, is_correct) VALUES (6, 'No', 0);
INSERT INTO ANSWER (question_id, name, is_correct) VALUES (6, 'Only starting from Java 8', 0);
