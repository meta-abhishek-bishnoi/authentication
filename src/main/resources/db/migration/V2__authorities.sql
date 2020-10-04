create table authorities (
  id BIGSERIAL PRIMARY KEY,
  username VARCHAR NOT NULL REFERENCES users(username),
  authority VARCHAR NOT NULL
);
CREATE INDEX username_index_authorities ON authorities(username);