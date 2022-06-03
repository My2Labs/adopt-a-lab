DROP TABLE IF EXISTS puppies;

CREATE TABLE puppies(
  id SERIAL PRIMARY KEY,
  name TEXT UNIQUE,
  breed TEXT UNIQUE,
  sex TEXT UNIQUE,
  age TEXT UNIQUE,,
  imageUrl TEXT UNIQUE
);

INSERT INTO puppies(name, breed, sex, age, imageUrl) VALUES ('Freckles', 'Chocolate Labrador Retriever', 'Male', '6 months');
INSERT INTO puppies(name, breed, sex, age, imageUrl) VALUES ('Rosco', 'Chocolate Labrador Retriever', 'Male', '4');
INSERT INTO puppies(name, breed, sex, age, imageUrl) VALUES ('Mattie', 'Chocolate Labrador Retriever', 'Female', '1');
INSERT INTO puppies(name, breed, sex, age, imageUrl) VALUES ('Buster', 'Black Labrador Retriever', 'Male', '4');
INSERT INTO puppies(name, breed, sex, age, imageUrl) VALUES ('Star', 'Black Labrador Retriever', 'Female', '1');
INSERT INTO puppies(name, breed, sex, age, imageUrl) VALUES ('Bacon', 'Black Labrador Retriever', 'Male', '2');
INSERT INTO puppies(name, breed, sex, age, imageUrl) VALUES ('Otis', 'Yellow Labrador Retriever', 'Male', '5');
INSERT INTO puppies(name, breed, sex, age, imageUrl) VALUES ('Candy', 'Yellow Labrador Retriever', 'Female', '7 months');
INSERT INTO puppies(name, breed, sex, age, imageUrl) VALUES ('Luke', 'Yellow Labrador Retriever', 'Male', '5 months');
INSERT INTO puppies(name, breed, sex, age, imageUrl) VALUES ('Jessie', 'Silver Labrador Retriever', 'Male', '4 months');
INSERT INTO puppies(name, breed, sex, age, imageUrl) VALUES ('Rex', 'Fox Red Labrador Retriever', 'Male', '7 months');
