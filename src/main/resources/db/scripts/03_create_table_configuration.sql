CREATE TABLE IF NOT EXISTS configuration
(
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    identifier          VARCHAR(128) UNIQUE NOT NULL,
    device_id           BIGINT NOT NULL,
    configuration       TEXT NOT NULL,
    creation_date       TIMESTAMP WITH TIME ZONE NOT NULL,
    modification_date   TIMESTAMP WITH TIME ZONE NOT NULL,
    FOREIGN KEY (device_id) REFERENCES device (id)
);