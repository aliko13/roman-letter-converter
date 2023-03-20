CREATE TABLE audit_log
(
    id     SERIAL PRIMARY KEY,
    created_date TIMESTAMP NOT NULL,
    conversion_type   TEXT NOT NULL,
    input_value TEXT NOT NULL,
    output_value TEXT NOT NULL
);