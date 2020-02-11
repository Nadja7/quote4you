DROP TABLE IF EXISTS c_quote;
CREATE TABLE c_quote
(
  id        INTEGER PRIMARY KEY auto_increment,
  quote     VARCHAR(128),
  autor      VARCHAR(128),
  day_id     INTEGER
);