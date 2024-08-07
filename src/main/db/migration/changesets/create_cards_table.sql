CREATE TABLE IF NOT EXISTS cards
(
    id      SERIAL PRIMARY KEY,
    fk_user_id INT,
    number  CHARACTER VARYING(16) NOT NULL,
    expiry  CHARACTER VARYING(5) NOT NULL,
    name     CHARACTER VARYING(50) NOT NULL,
    balance INT NOT NULL,
    FOREIGN KEY(fk_user_id)
     REFERENCES users(id)
     ON DELETE CASCADE
);