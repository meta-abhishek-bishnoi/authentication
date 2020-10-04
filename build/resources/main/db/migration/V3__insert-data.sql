Insert into users(username, password, enabled) VALUES ('user','pass-user#@12',true);
Insert into users(username, password, enabled) VALUES ('admin','pass-admin#@12',true);
Insert into authorities(username, authority) VALUES ('user','ROLE_USER');
Insert into authorities(username, authority) VALUES ('admin', 'ROLE_ADMIN');