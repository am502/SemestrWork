INSERT INTO users (login, password, first_name, last_name)
  VALUES ('user1', 'parol1', 'Андрей', 'Жуков');
INSERT INTO users (login, password, first_name, last_name)
  VALUES ('user2', 'parol2', 'Игорь', 'Павлов');
INSERT INTO users (login, password, first_name, last_name)
  VALUES ('user3', 'parol3', 'Александр', 'Иванов');
INSERT INTO users (login, password, first_name, last_name)
  VALUES ('user4', 'parol4', 'Марат', 'Пашин');

INSERT INTO vendors (user_id, phone_number)
  VALUES (1, '89236543892');
INSERT INTO vendors (user_id, phone_number)
  VALUES (2, '89273274623');

INSERT INTO customers (user_id, phone_number)
  VALUES (3, '89389805412');
INSERT INTO customers (user_id, phone_number)
  VALUES (4, '89545062798');

INSERT INTO customer_deals (customer_id, good_name, lot_size, price, payment_method, phone_number, note)
 VALUES (1, 'Машина', 25, 11, 'Банковская карта', '89389805412', 'Посредников прошу не беспокоиться');
INSERT INTO vendor_deals (vendor_id, good_name, lot_size_wholesale, price, payment_method, phone_number, conditions_sale, note)
 VALUES (2, 'Пистолет', 30, 140, 'Наличные', '89273274623', 'С доставкой', 'Выгодное предложение');