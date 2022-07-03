CREATE TABLE refreshtoken (
  id BIGINT AUTO_INCREMENT NOT NULL,
   user_id BIGINT NULL,
   token VARCHAR(255) NOT NULL,
   expiry_date datetime NOT NULL,
   CONSTRAINT pk_refreshtoken PRIMARY KEY (id)
);

ALTER TABLE refreshtoken ADD CONSTRAINT uc_refreshtoken_token UNIQUE (token);

ALTER TABLE refreshtoken ADD CONSTRAINT FK_REFRESHTOKEN_ON_USER FOREIGN KEY (user_id) REFERENCES users (user_id);