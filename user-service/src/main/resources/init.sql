create table users(
  id bigint auto_increment,
  name varchar(50),
  balance int,
  primary key (id)
);

create table user_transaction(
  id bigint auto_increment,
  user_id bigint,
  amount bigint,
  transaction_date timestamp,
  primary key (id),
  foreign key (user_id) references users(id) on delete cascade
);


INSERT INTO ecommerce.users (name, balance) VALUES ('nabil', 6450);

INSERT INTO ecommerce.user_transaction (user_id, amount, transaction_date) VALUES (1, 500, '2021-05-27 12:54:36');
INSERT INTO ecommerce.user_transaction (user_id, amount, transaction_date) VALUES (1, 1000, '2021-05-27 13:07:07');
INSERT INTO ecommerce.user_transaction (user_id, amount, transaction_date) VALUES (1, 750, '2021-05-29 17:46:42');
INSERT INTO ecommerce.user_transaction (user_id, amount, transaction_date) VALUES (1, 1300, '2021-05-29 17:47:18');

