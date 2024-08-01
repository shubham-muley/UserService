CREATE TABLE token
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    created_at  datetime              NULL,
    updated_at  datetime              NULL,
    deleted     BIT(1)                NOT NULL,
    token_value VARCHAR(255)          NULL,
    expiry_date datetime              NULL,
    user_id     BIGINT                NULL,
    CONSTRAINT pk_token PRIMARY KEY (id)
);

ALTER TABLE token
    ADD CONSTRAINT FK_TOKEN_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);