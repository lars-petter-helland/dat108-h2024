-- Names in SQL must begin with a letter (a-z) or underscore (_). 
-- Subsequent characters in a name can be letters, digits (0-9), or underscores.

-- Dette eksemplet innholder en 1:N-forbindelse mellom entitetstypene ansatt og avdeling. 

-- Sletter hele sulamitten og oppretter på nytt.
DROP SCHEMA IF EXISTS ansatt_avdeling CASCADE;
CREATE SCHEMA ansatt_avdeling;
SET search_path TO ansatt_avdeling;
    
-- 

CREATE TABLE avdeling
(
    id SERIAL PRIMARY KEY,
    navn VARCHAR(30) NOT NULL
);

CREATE TABLE ansatt
(
    id SERIAL PRIMARY KEY,
    navn VARCHAR(30) NOT NULL,
    kjonn CHAR CHECK (kjonn='M' OR kjonn='K'),
    manedslonn INTEGER NOT NULL,
    avdeling_id INTEGER NOT NULL,
    FOREIGN KEY (avdeling_id) REFERENCES avdeling(id)
);

-- 

INSERT INTO
  avdeling(navn)
VALUES
    ('Økonomi'),
    ('IT'),
    ('Salg');

INSERT INTO
  ansatt(navn, kjonn, manedslonn, avdeling_id)
VALUES
    ('Atle', 'M', 50000, 1),
    ('Anne', 'K', 60000, 1),
    ('Knut', 'M', 50000, 2),
    ('Kine', 'K', 45000, 2),
    ('Erik', 'M', 45000, 3),
    ('Elin', 'K', 45000, 3);
    