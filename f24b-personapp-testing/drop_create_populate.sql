-- Names in SQL must begin with a letter (a-z) or underscore (_). 
-- Subsequent characters in a name can be letters, digits (0-9), or underscores.

-- Sletter hele sulamitten og oppretter på nytt.
DROP SCHEMA IF EXISTS person_db CASCADE;
CREATE SCHEMA person_db;
SET search_path TO person_db;

CREATE TABLE person (
   navn CHARACTER VARYING (10),
   fodselsaar INTEGER CHECK (fodselsaar BETWEEN 1900 AND 2100)
);

INSERT INTO person VALUES ('Per', 2000), ('Pål', 2000), ('Espen', 2005);