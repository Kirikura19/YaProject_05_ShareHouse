-- Заполнение таблицы User
INSERT INTO person (name, email)
VALUES ('User1', 'user1@example.com'),
       ('User2', 'user2@example.com'),
       ('User3', 'user3@example.com'),
       ('User4', 'user4@example.com'),
       ('User5', 'user5@example.com'),
       ('User6', 'user6@example.com'),
       ('User7', 'user7@example.com'),
       ('User8', 'user8@example.com'),
       ('User9', 'user9@example.com'),
       ('User10', 'user10@example.com');

INSERT INTO request (description, requestor_id, created)
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

INSERT INTO item (name, description, available, owner_id, request_id)
VALUES ('Item1', 'Description1', TRUE, 1, 1),
       ('Item2', 'Description2', TRUE, 2, 2),
       ('Item3', 'Description3', TRUE, 3, 3),
       ('Item4', 'Description4', TRUE, 4, 4),
       ('Item5', 'Description5', TRUE, 5, 5),
       ('Item6', 'Description6', TRUE, 6, 6),
       ('Item7', 'Description7', TRUE, 7, 7),
       ('Item8', 'Description8', TRUE, 8, 8),
       ('Item9', 'Description9', TRUE, 9, 9),
       ('Item10', 'Description10', TRUE, 10, 10);

INSERT INTO booking (time_start, time_end, item_id, booker_id, status)
VALUES ('2023-10-25 21:53:28', '2023-10-26 21:53:28', 1, 1, 'APPROVED'),
       ('2023-10-26 21:53:28', '2023-10-27 21:53:28', 2, 2, 'APPROVED'),
       ('2023-10-27 21:53:28', '2023-10-28 21:53:28', 3, 3, 'APPROVED'),
       ('2023-10-28 21:53:28', '2023-10-29 21:53:28', 4, 4, 'APPROVED'),
       ('2023-10-29 21:53:28', '2023-10-30 21:53:28', 5, 5, 'APPROVED'),
       ('2023-10-30 21:53:28', '2023-10-31 21:53:28', 6, 6, 'APPROVED'),
       ('2023-10-31 21:53:28', '2023-11-01 21:53:28', 7, 7, 'APPROVED'),
       ('2023-11-01 21:53:28', '2023-11-02 21:53:28', 8, 8, 'APPROVED'),
       ('2023-11-02 21:53:28', '2023-11-03 21:53:28', 9, 9, 'APPROVED'),
       ('2023-11-03 21:53:28', '2023-11-04 21:53:28', 10, 10, 'APPROVED');