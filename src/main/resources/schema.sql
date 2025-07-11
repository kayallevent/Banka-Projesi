CREATE TABLE IF NOT EXISTS customers (
    id SERIAL PRIMARY KEY,
    ad VARCHAR(255),
    soyad VARCHAR(255),
    email VARCHAR(255),
    bakiye DOUBLE PRECISION
);

