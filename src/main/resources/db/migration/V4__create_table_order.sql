CREATE TABLE tb_order (
  id BIGINT AUTO_INCREMENT NOT NULL,
   total_sale_price DOUBLE NOT NULL,
   payment VARCHAR(255) NULL,
   CONSTRAINT pk_tb_order PRIMARY KEY (id)
);

ALTER TABLE tb_order ADD CONSTRAINT uc_tb_order_id UNIQUE (id);