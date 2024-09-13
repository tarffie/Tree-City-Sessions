CREATE TABLE IF NOT EXISTS User (
    id INT NOT NULL,
    username varchar(64) NOT NULL,
    password varchar(256) NOT NULL,
    registered_on timestamp NOT NULL,
);