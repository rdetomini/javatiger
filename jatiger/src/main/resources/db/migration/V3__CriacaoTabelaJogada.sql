CREATE TABLE jogadas (
  `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `usuario_id` BIGINT NOT NULL,
  `credito_utilizado` DECIMAL(10,2) NOT NULL,
  `jogada_ganha` BIT NOT NULL,
    FOREIGN KEY (`usuario_id`)
    REFERENCES `usuarios` (`id`))