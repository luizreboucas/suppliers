CREATE TABLE IF NOT EXISTS suppliers (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cnpj CHAR(14) NOT NULL UNIQUE,
    estado CHAR(30),
    cidade CHAR(255),
    logradouro CHAR(255),
    numero CHAR(30)
);