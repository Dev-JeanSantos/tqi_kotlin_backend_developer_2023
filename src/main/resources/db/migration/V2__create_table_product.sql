CREATE TABLE tb_product (
  id BIGINT AUTO_INCREMENT NOT NULL,
   name VARCHAR(255) NOT NULL,
   unit_measure VARCHAR(255) NOT NULL,
   price DOUBLE NOT NULL,
   category_id BIGINT NULL,
   CONSTRAINT pk_tb_product PRIMARY KEY (id)
);

ALTER TABLE tb_product ADD CONSTRAINT uc_tb_product_id UNIQUE (id);

ALTER TABLE tb_product ADD CONSTRAINT FK_TB_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES tb_category (id);