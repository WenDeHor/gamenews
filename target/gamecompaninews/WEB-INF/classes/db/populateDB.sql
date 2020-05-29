DELETE FROM users;
DELETE FROM messages;
DELETE FROM roles;
ALTER SEQUENCE global_seq RESTART WITH 1000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'password');

INSERT INTO roles (role, user_id) VALUES
  ('ROLE_USER', 1000),
  ('ROLE_ADMIN', 1001),
  ('ROLE_USER', 1001);

INSERT INTO messages ( user_id, text, likecount)
VALUES (1000, 'Текст адміна №1', 500),
       (1000, 'Текст адміна №2', 500),
       (1000, 'Текст адміна №3', 500),
       (1001, 'Текст адміна №4', 500),
       (1001, 'Текст адміна №5', 500),
       (1001, 'Текст адміна №6', 500);

