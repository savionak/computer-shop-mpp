USE `computer_shop`;

INSERT INTO `component_type`
(`id`, `name`)
VALUES
  ('1', 'Процессор'),
  ('2', 'Материнская плата'),
  ('3', 'Оперативная память'),
  ('4', 'Видеокарта'),
  ('5', 'Сетевая плата');

INSERT INTO `computer_shop`.`component_model`
(`id`, `type_id`, `name`, `description`)
VALUES
  ('1', '1', 'Intel Core i7', 'Cool thing!'),
  ('2', '2', 'Gigabit M3', 'Cool mother!'),
  ('3', '1', 'AMD X5', 'Another proc'),
  ('4', '1', 'AMD X10', '');

INSERT INTO `computer_shop`.`provider`
(`id`, `name`, `description`)
VALUES
  ('1', 'MMGroup', NULL),
  ('2', 'TerraStore', NULL);

/* Imports - trigger component_store */

INSERT INTO `computer_shop`.`import`
(`id`,
 `provider_id`,
 `date_time`,
 `count`,
 `model_id`,
 `purchase_price`,
 `price`,
 `status`)
VALUES
  ('1', '1', '2017-04-14 11:43:33', '10', '1', '40', '5', 'FINISHED'),
  ('2', '1', '2017-04-14 13:26:49', '20', '1', '30', '0', 'REGISTERED'),
  ('3', '2', '2017-04-14 15:23:01', '50', '2', '25', '30', 'FINISHED');

