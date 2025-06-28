CREATE TABLE users
(
    id      UUID NOT NULL,
    name    VARCHAR(255) not null,
    surname VARCHAR(255) not null,
    email   VARCHAR(255) unique NOT NULL,
    password   VARCHAR(255) NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);