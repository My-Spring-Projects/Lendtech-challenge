CREATE TABLE users (
   user_id BIGINT AUTO_INCREMENT NOT NULL,
   username VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL,
   password VARCHAR(255) NOT NULL,
   CONSTRAINT pk_users PRIMARY KEY (user_id)
);

ALTER TABLE users ADD CONSTRAINT uc_74165e195b2f7b25de690d14a UNIQUE (email);

ALTER TABLE users ADD CONSTRAINT uc_77584fbe74cc86922be2a3560 UNIQUE (username);

CREATE TABLE roles (
   role_id BIGINT AUTO_INCREMENT NOT NULL,
   name VARCHAR(20) NOT NULL,
   CONSTRAINT pk_roles PRIMARY KEY (role_id)
);

CREATE TABLE transactions (
   transaction_id BIGINT AUTO_INCREMENT NOT NULL,
   sender VARCHAR(255) NULL,
   recipient VARCHAR(255) NULL,
   source VARCHAR(255) NULL,
   amount DOUBLE NULL,
   balance DOUBLE NULL,
   transaction_time date NULL,
   user_user_id BIGINT NULL,
   CONSTRAINT pk_transactions PRIMARY KEY (transaction_id)
);

ALTER TABLE transactions ADD CONSTRAINT FK_TRANSACTIONS_ON_USER_USER FOREIGN KEY (user_user_id) REFERENCES users (user_id);

CREATE TABLE user_roles (
   role_id BIGINT NOT NULL,
   user_id BIGINT NOT NULL,
   CONSTRAINT pk_user_roles PRIMARY KEY (role_id, user_id)
);

ALTER TABLE user_roles ADD CONSTRAINT fk_userol_on_role FOREIGN KEY (role_id) REFERENCES roles (role_id);

ALTER TABLE user_roles ADD CONSTRAINT fk_userol_on_user FOREIGN KEY (user_id) REFERENCES users (user_id);

CREATE TABLE user_transactions (
   transaction_id BIGINT NOT NULL,
   user_id BIGINT NOT NULL,
   CONSTRAINT pk_user_transactions PRIMARY KEY (transaction_id, user_id)
);

ALTER TABLE user_transactions ADD CONSTRAINT uc_user_transactions_transaction UNIQUE (transaction_id);

ALTER TABLE user_transactions ADD CONSTRAINT fk_usetra_on_transaction FOREIGN KEY (transaction_id) REFERENCES transactions (transaction_id);

ALTER TABLE user_transactions ADD CONSTRAINT fk_usetra_on_user FOREIGN KEY (user_id) REFERENCES users (user_id);