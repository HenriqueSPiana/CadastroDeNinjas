

-- ATHENAS.tb_missoes definition

CREATE TABLE IF NOT EXISTS `tb_missoes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dificuldade` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ATHENAS.tb_cadastro definition

CREATE TABLE IF NOT EXISTS `tb_cadastro` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `idade` int DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `missoes_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK8bqyjoqm2m8q7peklgtrv9jpg` (`email`),
  KEY `FKefsdhx90edgna6klo6eftmq7h` (`missoes_id`),
  CONSTRAINT `FKefsdhx90edgna6klo6eftmq7h` FOREIGN KEY (`missoes_id`) REFERENCES `tb_missoes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


