CREATE TABLE category (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(60) DEFAULT NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE product (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(60) NOT NULL,
  Price double NOT NULL,
  Quantity int(11) NOT NULL,
  CategoryId int(11) NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (CategoryId) REFERENCES category (id)
);

INSERT INTO category (Name) VALUES 
  ('Computers'),
  ('Electronics'),
  ('Books');

INSERT INTO product (Name, Price, Quantity, CategoryId) VALUES 
  ('Notebook',2000,3,1),
  ('Resistor',0.5,10,2),
  ('LOTR',70,1,3),
  ('Harry Potter',35,2,3),
  ('Tablet',800,10,1),
  ('Diode',0.75,8,2);