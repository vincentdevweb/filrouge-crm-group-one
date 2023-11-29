CREATE TABLE IF NOT EXISTS clients(
    id SERIAL PRIMARY KEY,
    company_name VARCHAR(100) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone_number varchar(15) unique,
    address TEXT NOT NULL,
    zip_code VARCHAR(30) NOT NULL,
    city VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL,
    state INTEGER CHECK(state>=0 AND state<=1) --(0, 1) (ACTIVE, INACTIVE)
);

CREATE TABLE IF NOT EXISTS orders(
    id SERIAL PRIMARY KEY,
    type_presta VARCHAR(100) NOT NULL,
    designation VARCHAR(100) NOT NULL,
    client_id INTEGER REFERENCES clients(id) ON DELETE SET NULL,
    nb_days INTEGER NOT NULL CHECK(nb_days>0),
    unit_price NUMERIC NOT NULL CHECK(unit_price>0),
    total_exclude_taxe NUMERIC GENERATED ALWAYS AS (unit_price*nb_days) STORED,
    total_with_taxe NUMERIC GENERATED ALWAYS AS (1.2*unit_price*nb_days) STORED,
    state INTEGER CHECK(state>=0 AND state<=2)--  (0,1,2) (CANCELED, OPTION, CONFIRMED)
);

INSERT INTO clients (company_name, first_name, last_name, email, phone_number, address, zip_code, city, country, state)
VALUES
	('Sopra', 'Fabrice', 'Martin', 'martin@mail.com', '06 56 85 84 33', 'abc', 'xyz', 'Nantes', 'France', 0),
	('M2I Formation', 'Julien', 'Lamard', 'lamard@mail.com"', '06 11 22 33 44', 'abc', 'xyz', 'Paris', 'France', 1);

INSERT INTO orders (type_presta, designation, client_id, nb_days, unit_price, state)
VALUES
	('Formation', 'Angular init', 2, 3, 1200, 0), 
	('Formation', 'React avancé', 2, 3, 1000, 2),
	('Coaching', 'React Techlead', 1, 20, 900, 2);

SELECT * FROM clients;
SELECT * FROM orders;