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
    requestor   BIGINT,
    created     TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (requestor) REFERENCES "User" (id)
);

CREATE TABLE Item
(
    id          BIGINT AUTO_INCREMENT,
    name        VARCHAR(255),
    description VARCHAR(255),
    available   BOOLEAN,
    owner       BIGINT,
    request     BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (owner) REFERENCES "User" (id),
    FOREIGN KEY (request) REFERENCES Request (id)
);

CREATE TABLE Booking
(
    id         BIGINT AUTO_INCREMENT,
    time_start TIMESTAMP,
    time_end   TIMESTAMP,
    item       BIGINT,
    booker     BIGINT,
    status     VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (item) REFERENCES Item (id),
    FOREIGN KEY (booker) REFERENCES "User" (id)
);
