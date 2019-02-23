CREATE TABLE users (
  id BIGSERIAL PRIMARY KEY,
  login VARCHAR NOT NULL,
  password_hash VARCHAR NOT NULL,
  status  VARCHAR NOT NULL
);

CREATE TABLE trainings (
  id BIGSERIAL PRIMARY KEY,
  title VARCHAR NOT NULL,
  exercises JSON NOT NULL,
  user_id  BIGINT NOT NULL REFERENCES users
);

CREATE TABLE goods (
  id BIGSERIAL PRIMARY KEY,
  title VARCHAR NOT NULL,
  price  VARCHAR NOT NULL,
  user_id  BIGINT NOT NULL REFERENCES users
);