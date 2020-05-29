DELETE FROM users;
DELETE FROM messages;
DELETE FROM roles;
ALTER SEQUENCE global_seq RESTART WITH 1000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'testUser@ukr.net', 'password'),
  ('Admin', 'testAdmin@ukr.net', 'password');

INSERT INTO roles (role, user_id) VALUES
  ('ROLE_USER', 1000),
  ('ROLE_ADMIN', 1001),
  ('ROLE_USER', 1001);

INSERT INTO messages ( user_id, text, likecount)
VALUES (1000, 'Текст юзера №1', 100),
       (1000, 'Текст юзера №2', 300),
       (1000, 'Текст юзера №3', 500),
       (1001, 'Текст адміна №10', 100),
       (1001, 'Текст адміна №20', 100),
       (1001, 'Текст адміна №30', 600);

