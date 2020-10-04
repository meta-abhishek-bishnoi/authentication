create TABLE details(
  id BIGSERIAL PRIMARY KEY,
  user_id BIGINT NOT NULL REFERENCES users(id),
  first_name VARCHAR,
  last_name VARCHAR,
  email VARCHAR,
  mobile_no VARCHAR
);
insert INTO details(user_id, first_name, last_name, email, mobile_no) VALUES (1,'First', 'User', 'itsUser@gmail.com', '8909890899');
insert INTO details(user_id, first_name, last_name, email, mobile_no) VALUES (2,'First', 'Admin', 'admin@gmail.com', '9909890899');