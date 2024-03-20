CREATE TABLE IF NOT EXISTS device
(
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    identifier          VARCHAR(128) NOT NULL UNIQUE,
    creation_date       TIMESTAMP WITH TIME ZONE NOT NULL,
    modification_date   TIMESTAMP WITH TIME ZONE,
    launch_date         TIMESTAMP WITH TIME ZONE,
    shutdown_date       TIMESTAMP WITH TIME ZONE,
    address_id          BIGINT,
    FOREIGN KEY (address_id) REFERENCES address (id)
);