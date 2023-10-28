-- Заполнение таблицы Person
INSERT INTO person (name, email)
VALUES ('person1', 'person1@example.com'),
       ('person2', 'person2@example.com'),
       ('person3', 'person3@example.com'),
       ('person4', 'person4@example.com'),
       ('person5', 'person5@example.com'),
       ('person6', 'person6@example.com'),
       ('person7', 'person7@example.com'),
       ('person8', 'person8@example.com'),
       ('person9', 'person9@example.com'),
       ('person10', 'person10@example.com');

INSERT INTO request (description, person_id, created)
VALUES ('Request1', 1, '2023-10-25 21:53:28'),
       ('Request2', 2, '2023-10-26 21:53:28'),
       ('Request3', 3, '2023-10-27 21:53:28'),
       ('Request4', 4, '2023-10-28 21:53:28'),
       ('Request5', 5, '2023-10-29 21:53:28'),
       ('Request6', 6, '2023-10-30 21:53:28'),
       ('Request7', 7, '2023-10-31 21:53:28'),
       ('Request8', 8, '2023-11-01 21:53:28'),
       ('Request9', 9, '2023-11-02 21:53:28'),
       ('Request10', 10, '2023-11-03 21:53:28');

INSERT INTO item (name, description, available, person_id, request_id)
VALUES ('Item1', 'Description1', TRUE, 1, 1),
       ('Item2', 'Description2', TRUE, 1, 2),
       ('Item3', 'Description3', TRUE, 3, 3),
       ('Item4', 'Description4', TRUE, 4, 4),
       ('Item5', 'Description5', TRUE, 1, 5),
       ('Item6', 'Description6', TRUE, 6, 6),
       ('Item7', 'Description7', TRUE, 7, 7),
       ('Item8', 'Description8', TRUE, 8, 8),
       ('Item9', 'Description9', TRUE, 1, 9),
       ('Item10', 'Description10', TRUE, 10, 10);

INSERT INTO booking (time_start, time_end, item_id, person_id, status)
VALUES ('2023-10-25 21:53:28', '2023-10-26 21:53:28', 1, 2, 'APPROVED'),
       ('2023-10-26 21:53:28', '2023-10-27 21:53:28', 2, 2, 'WAITING'),
       ('2023-10-27 21:53:28', '2023-10-28 21:53:28', 3, 3, 'WAITING'),
       ('2023-10-28 21:53:28', '2023-10-29 21:53:28', 4, 4, 'WAITING'),
       ('2023-10-29 21:53:28', '2023-10-30 21:53:28', 5, 5, 'APPROVED'),
       ('2023-10-30 21:53:28', '2023-10-31 21:53:28', 6, 6, 'APPROVED'),
       ('2023-10-31 21:53:28', '2023-11-01 21:53:28', 7, 7, 'APPROVED'),
       ('2023-11-01 21:53:28', '2023-11-02 21:53:28', 8, 8, 'APPROVED'),
       ('2023-11-02 21:53:28', '2023-11-03 21:53:28', 9, 9, 'APPROVED'),
       ('2023-11-03 21:53:28', '2023-11-04 21:53:28', 10, 10, 'APPROVED');