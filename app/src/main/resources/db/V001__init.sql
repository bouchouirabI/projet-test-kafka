CREATE TABLE IF NOT EXISTS CLIENT (
    id UUID NOT NULL PRIMARY KEY,
    first_name VARCHAR,
    last_name VARCHAR ,
    middle_name VARCHAR,
    date_of_birth DATE,
    place_of_birth VARCHAR,
    enrollment_date DATE,
    email VARCHAR
);