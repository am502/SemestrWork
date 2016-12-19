CREATE TABLE users(
  user_id SERIAL PRIMARY KEY,
  login VARCHAR(255),
  password VARCHAR(255),
  first_name VARCHAR(255),
  last_name VARCHAR(255)
);

CREATE TABLE vendors(
  vendor_id SERIAL PRIMARY KEY,
  user_id INT REFERENCES users(user_id) ON DELETE SET NULL,
  phone_number VARCHAR(255),
  status VARCHAR(255) DEFAULT 'ACTIVE'
);

CREATE TABLE customers(
  customer_id SERIAL PRIMARY KEY,
  user_id INT REFERENCES users(user_id) ON DELETE SET NULL,
  phone_number VARCHAR(255),
  status VARCHAR(255) DEFAULT 'ACTIVE'
);

CREATE TABLE archive(
  vendor_id INT REFERENCES vendors(vendor_id) ON DELETE SET NULL,
  customer_id INT REFERENCES customers(customer_id) ON DELETE SET NULL,
  good_name VARCHAR(255),
  sell_date VARCHAR(255),
  price INT,
  customer_comment VARCHAR(255)
);

CREATE TABLE vendor_deals(
  vendor_deal_id SERIAL PRIMARY KEY,
  vendor_id INT REFERENCES vendors(vendor_id),
  good_name VARCHAR(255),
  lot_size_wholesale INT CHECK (lot_size_wholesale >= 0),
  price INT CHECK (price >= 0),
  payment_method VARCHAR(255),
  phone_number VARCHAR(255),
  conditions_sale VARCHAR(255),
  note VARCHAR(255)
);

CREATE TABLE customer_deals(
  customer_deal_id SERIAL PRIMARY KEY,
  customer_id INT REFERENCES customers(customer_id),
  good_name VARCHAR(255),
  lot_size INT CHECK (lot_size >= 0),
  price INT CHECK (price >= 0),
  payment_method VARCHAR(255),
  phone_number VARCHAR(255),
  note VARCHAR(255)
);

CREATE VIEW user_customer
 AS SELECT u.last_name, u.first_name, u.user_id, c.customer_id, c.phone_number, c.status
 FROM users u INNER JOIN customers c ON c.user_id = u.user_id;

CREATE VIEW user_vendor
 AS SELECT u.last_name, u.first_name, u.user_id, v.vendor_id, v.phone_number, v.status
 FROM users u INNER JOIN vendors v ON v.user_id = u.user_id;

CREATE FUNCTION update_delete() RETURNS trigger AS $users_delete$
BEGIN
  UPDATE customers SET (status, phone_number) = ('DELETED', '') WHERE user_id IS NULL;
  UPDATE vendors SET (status, phone_number) = ('DELETED', '') WHERE user_id IS NULL;
  DELETE FROM customer_deals cd USING customers c WHERE cd.customer_id = c.customer_id AND c.user_id IS NULL;
  DELETE FROM vendor_deals vd USING vendors v WHERE vd.vendor_id = v.vendor_id AND v.user_id IS NULL;
  RETURN NULL;
END;
$users_delete$ LANGUAGE plpgsql;

CREATE TRIGGER users_delete AFTER DELETE ON users
FOR EACH ROW EXECUTE PROCEDURE update_delete();

CREATE INDEX customer_index ON customers (customer_id);
CREATE INDEX vendor_index ON vendors (vendor_id);
CREATE INDEX user_index ON users (user_id);

CREATE OR REPLACE FUNCTION add_vendor
  (ulogin VARCHAR(255), upassword VARCHAR(255), ufirst_name VARCHAR(255), ulast_name VARCHAR(255), vphone_number VARCHAR(255))
  RETURNS void AS $add_vendor$
  DECLARE
  uid INT;
BEGIN
  INSERT INTO users (login, password, first_name, last_name)
                    VALUES (ulogin, upassword, ufirst_name, ulast_name)
                    RETURNING user_id INTO uid;
  INSERT INTO vendors (user_id, phone_number)
                    VALUES (uid, vphone_number);
END;
$add_vendor$  LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION add_customer
  (ulogin VARCHAR(255), upassword VARCHAR(255), ufirst_name VARCHAR(255), ulast_name VARCHAR(255), cphone_number VARCHAR(255))
  RETURNS void AS $add_customer$
  DECLARE
  uid INT;
BEGIN
  INSERT INTO users (login, password, first_name, last_name)
                    VALUES (ulogin, upassword, ufirst_name, ulast_name)
                    RETURNING user_id INTO uid;
  INSERT INTO customers (user_id, phone_number)
                    VALUES (uid, cphone_number);
END;
$add_customer$ LANGUAGE plpgsql;