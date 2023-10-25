CREATE TABLE "User"
(
    id    BIGINT AUTO_INCREMENT,
    name  VARCHAR(255),
    email VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE Request
(
    id          BIGINT AUTO_INCREMENT,
    description VARCHAR(255),
    requestor_id BIGINT,
    created     TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (requestor_id) REFERENCES "User" (id)
);

CREATE TABLE Item
(
    id          BIGINT AUTO_INCREMENT,
    name        VARCHAR(255),
    description VARCHAR(255),
    available   BOOLEAN,
    owner_id   BIGINT,
    request_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (owner_id) REFERENCES "User" (id),
    FOREIGN KEY (request_id) REFERENCES Request (id)
);

CREATE TABLE Booking
(
    id         BIGINT AUTO_INCREMENT,
    time_start TIMESTAMP,
    time_end   TIMESTAMP,
    item_id   BIGINT,
    booker_id BIGINT,
    status     VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (item_id) REFERENCES Item (id),
    FOREIGN KEY (booker_id) REFERENCES "User" (id)
);
