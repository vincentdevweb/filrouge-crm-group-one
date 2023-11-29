DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS clients;

CREATE TABLE clients (
    id SERIAL PRIMARY KEY,
    company_name VARCHAR(100)NOT NULL,
    first_name VARCHAR(50)NOT NULL,
    last_name VARCHAR(50)NOT NULL,
    email VARCHAR(100)NOT NULL,
    phone VARCHAR(15)NOT NULL,
    address TEXT NOT NULL,
    zip_code VARCHAR(30)NOT NULL,
    city VARCHAR(255) NOT NULL,
    country VARCHAR(100) NOT NULL,
    state INTEGER CHECK(state>=0 AND state<=1) --(0, 1) (ACTIVE, INACTIVE) 
);

CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
	client_id INT REFERENCES clients(id) ON DELETE SET NULL ON UPDATE CASCADE ,
    type_presta VARCHAR(100) NOT NULL,
    designation VARCHAR(100) NOT NULL,
    nb_days INTEGER NOT NULL CHECK(nb_days>0),
    unit_price NUMERIC NOT NULL CHECK(unit_price>0),
    total_exclude_taxe NUMERIC(10, 2) GENERATED ALWAYS AS (unit_price * nb_days) STORED,
    total_with_taxe NUMERIC(10, 2) GENERATED ALWAYS AS ((unit_price * nb_days) * 1.20) STORED,
    state INTEGER CHECK(state>=0 AND state<=2)--  (0,1,2) (CANCELED, OPTION, CONFIRMED) 
);

INSERT INTO clients (company_name, first_name, last_name, email, phone, address, zip_code, city, country, state)
VALUES 
    ('Sopra STERIA', 'Nom du Contact 1', 'Nom de Famille 1', 'contact1@soprasteria.com', '0123456789', '123 Rue des Clients 1', '75000', 'Paris', 'France', 1),
    ('ATOS', 'Prénom du Contact 2', 'Nom de Famille 2', 'contact2@atos.com', '0123456789', '456 Rue des Clients 2', '69000', 'Lyon', 'France', 0),
    ('M2I Formation', 'Julien', 'Lamard', 'julien@m2iformation.com', '0611223344', '789 Rue des Clients 3', '13000', 'Marseille', 'France', 1),
    ('Techlead', 'Techlead', 'Techlead', 'techlead@techlead.com', '0123456789', '456 Rue des Clients 4', '69000', 'Lyon', 'France', 0),
    ('Sopra', 'Fabrice', 'Martin', 'fabrice@sopra.com', '0611223344', '789 Rue des Clients 5', '13000', 'Marseille', 'France', 1);


-- Insertion de données dans la table "orders"
INSERT INTO orders (type_presta, designation, client_id, nb_days, unit_price, state)
VALUES 
    ('Formation Angular init', 'Formation Angular init', 2, 3, 1200, 0),
    ('Formation React avancé', 'Formation React avancé', 2, 3, 1000, 2),
    ('Coaching React', 'Techlead', 1, 20, 900, 2),
    ('Coaching Nest.js', 'Techlead', 1, 50, 800, 1),
    ('Coaching React', 'Teachlead', 3, 10, 700, 0),
    ('Coaching Jakarta EE', 'Teachlead', 3, 5, 600, 2),
    ('Coaching Angular', 'Techlead', 4, 15, 900, 2),
    ('Formation Java avancé', 'Techlead', 2, 5, 1500, 2),
    ('Formation Python débutant', 'Sopra STERIA', 4, 4, 800, 2),
    ('Coaching Node.js', 'ATOS', 3, 8, 1000, 0),
    ('Coaching Angular', 'Sopra', 2, 6, 1200, 1),
    ('Formation SQL avancé', 'Techlead', 1, 4, 900, 2),
    ('Coaching Python', 'M2I Formation', 2, 10, 1100, 0),
    ('Formation DevOps', 'Techlead', 1, 5, 1300, 2),
    ('Coaching Docker', 'Techlead', 1, 8, 1400, 2),
    ('Formation AWS Cloud', 'M2I Formation', 4, 3, 1600,1),
    ('Coaching Kubernetes', 'ATOS', 3, 7, 1100, 2),
    ('Formation Cybersecurity', 'Sopra STERIA', 2, 4, 1200, 0),
    ('Coaching AI and ML', 'Techlead', 4, 6, 1500, 2),
    ('Formation Data Analytics', 'M2I Formation', 1, 5, 1300, 1);

SELECT * FROM orders;
SELECT * FROM clients;

-- Afficher toutes les formations sollicitées par le client "M2I Formation" 
SELECT o.type_presta, o.designation
FROM orders o
JOIN clients c ON o.client_id = c.id
WHERE c.company_name = 'M2I Formation';

-- Afficher les noms et contacts de tous les contacts des clients qui ont sollicité un coaching :
SELECT c.first_name, c.last_name, c.email, c.phone
FROM clients c
JOIN orders o ON c.id = o.client_id
WHERE o.type_presta LIKE 'Coaching%';

-- Afficher les noms et contacts de tous les contacts des clients qui ont sollicité un coaching pour les accompagnements "React.js" :
SELECT c.first_name, c.last_name, c.email, c.phone
FROM clients c
JOIN orders o ON c.id = o.client_id
WHERE o.type_presta ILIKE '%React%';

-- Pour chacune des demandes de formation, afficher le prix UHT et prix TTC :
SELECT
    o.type_presta,
    o.designation,
    o.unit_price AS "Prix UHT",
    o.total_exclude_taxe AS "Prix TTC"
FROM orders o;

-- -- Lister toutes les prestations confirmées qui rapporteront plus de 30 000€ :
-- SELECT o.type_presta, o.designation, (o.unit_price * o.nb_days * 1.20) AS "Prix TTC"
-- FROM orders o
-- WHERE o.state = 2 -- 2 corresponds to CONFIRMED
-- HAVING (o.unit_price * o.nb_days * 1.20) > 30000
-- GROUP BY "Prix TTC";


