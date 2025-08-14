CREATE TABLE usuarios (
  `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `credito` DECIMAL(10,2) NULL,
  `quantidade_arrecadada` DECIMAL(10,2) NULL,
  `empresa_id` BIGINT NOT NULL,
    FOREIGN KEY (`empresa_id`)
    REFERENCES `empresas` (`id`))