CREATE TABLE users (
  user_id SERIAL PRIMARY KEY NOT NULL,
  username VARCHAR(255),
  password VARCHAR(255),
  email VARCHAR(255)
);

CREATE TABLE roles (
  role_id SERIAL PRIMARY KEY NOT NULL,
  role VARCHAR(255)
);

CREATE TABLE user_role (
  user_id INTEGER,
  role_id INTEGER
);

ALTER TABLE user_role ADD CONSTRAINT users_user_id_fkey FOREIGN KEY (user_id) REFERENCES users (user_id) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE user_role ADD CONSTRAINT roles_role_id_fkey FOREIGN KEY (role_id) REFERENCES roles (role_id) ON UPDATE CASCADE;
ALTER TABLE user_role ADD CONSTRAINT user_role_pkey PRIMARY KEY (user_id, role_id);