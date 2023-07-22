CREATE TABLE tb_category (
  id BIGINT AUTO_INCREMENT NOT NULL,
   name VARCHAR(255) NOT NULL,
   CONSTRAINT pk_tb_category PRIMARY KEY (id)
);

ALTER TABLE tb_category ADD CONSTRAINT uc_tb_category_id UNIQUE (id);