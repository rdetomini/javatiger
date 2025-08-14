CREATE TABLE configuracoes (
  `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `chance_vitoria` DECIMAL(10,2) NOT NULL,
  `minimo_arrecadacao` DECIMAL(10,2) NOT NULL,
  `empresa_id` BIGINT NOT NULL,
  `porcentagem_repasse` DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (`empresa_id`)
    REFERENCES `empresas` (`id`))