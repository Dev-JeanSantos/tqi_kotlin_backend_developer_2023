CREATE TABLE tb_item (
  id BIGINT AUTO_INCREMENT NOT NULL,
   product_id BIGINT NULL,
   quantity_itens INT NOT NULL,
   price_by_sale DOUBLE NOT NULL,
   CONSTRAINT pk_tb_item PRIMARY KEY (id)
);

ALTER TABLE tb_item ADD CONSTRAINT uc_tb_item_id UNIQUE (id);

ALTER TABLE tb_item ADD CONSTRAINT FK_TB_ITEM_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES tb_product (id);