insert into course (acronym, title, credits)
values ('1DEV1A', 'Développement 1', 6),
       ('1EXP1A', 'Exploitation des systèmes 1', 5),
       ('1ALG1A', 'Algorithmique 1', 4),
       ('1ANG1A', 'Anglais 1', 2);

insert into student (name, gender, section)
values ('Damon', 'M', 'APPLICATION'),
       ('Stefan', 'M', 'NETWORK'),
       ('Elena', 'F', 'INDUSTRIAL'),
       ('Nasreddine', 'M', 'APPLICATION');

insert into student_courses (students_number, courses_acronym)
values (1, '1DEV1A'),
       (2, '1DEV1A'),
       (3, '1DEV1A'),
       (4, '1DEV1A'),
       (1, '1EXP1A');