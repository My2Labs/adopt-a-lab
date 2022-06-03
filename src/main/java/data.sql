DROP TABLE IF EXISTS puppies;

CREATE TABLE puppies(
  id SERIAL PRIMARY KEY,
  name TEXT UNIQUE,
  breed TEXT UNIQUE,
  sex TEXT UNIQUE,
  age TEXT UNIQUE,,
  imageUrl TEXT UNIQUE
);

INSERT INTO puppies(name, breed, sex, age, imageUrl) VALUES ('Freckles', 'Chocolate Labrador Retriever', 'Male', '6 months', 'https://static.independent.co.uk/s3fs-public/thumbnails/image/2018/10/22/09/chocolate-labrador.jpg?width=1200');
INSERT INTO puppies(name, breed, sex, age, imageUrl) VALUES ('Rosco', 'Chocolate Labrador Retriever', 'Male', '4', 'https://th.bing.com/th/id/OIP.AQrp4D0YhuWns8OjAn1_AwHaE8?w=258&h=180&c=7&r=0&o=5&pid=1.7');
INSERT INTO puppies(name, breed, sex, age, imageUrl) VALUES ('Mattie', 'Chocolate Labrador Retriever', 'Female', '1', 'https://keyassets.timeincuk.net/inspirewp/live/wp-content/uploads/sites/8/2021/10/CLI327.labradors.ChocolateLabsMP_078_FrontCover.jpg');
INSERT INTO puppies(name, breed, sex, age, imageUrl) VALUES ('Buster', 'Black Labrador Retriever', 'Male', '4', 'https://images.fineartamerica.com/images/artworkimages/mediumlarge/2/black-labrador-retriever-16-bob-langrish.jpg');
INSERT INTO puppies(name, breed, sex, age, imageUrl) VALUES ('Star', 'Black Labrador Retriever', 'Female', '1', 'https://i.pinimg.com/originals/6d/5b/90/6d5b90524eb0f0d889abd085e0c823bc.jpg');
INSERT INTO puppies(name, breed, sex, age, imageUrl) VALUES ('Bacon', 'Black Labrador Retriever', 'Male', '2', 'https://pheasantsforever.org/getattachment/94f12408-c8fe-483f-9358-61f9c2af3ae7/Bird-Dogs-American-Labs-vs-British-Labs.aspx');
INSERT INTO puppies(name, breed, sex, age, imageUrl) VALUES ('Otis', 'Yellow Labrador Retriever', 'Male', '5', 'https://www.k9web.com/wp-content/uploads/2020/12/yellow-labrador-retriever-on-green-grass-lawn-780x466.jpg');
INSERT INTO puppies(name, breed, sex, age, imageUrl) VALUES ('Candy', 'Yellow Labrador Retriever', 'Female', '7 months', 'https://www.thelabradorsite.com/wp-content/uploads/2015/07/yellow-labrador-puppy-garden.jpg');
INSERT INTO puppies(name, breed, sex, age, imageUrl) VALUES ('Luke', 'Yellow Labrador Retriever', 'Male', '5 months', 'https://www.mediastorehouse.com/p/172/jd-21712-dog-yellow-labrador-puppy-running-lawn-5267584.jpg');
INSERT INTO puppies(name, breed, sex, age, imageUrl) VALUES ('Jessie', 'Silver Labrador Retriever', 'Male', '4 months', 'https://dogable.net/wp-content/uploads/silver-labrador-puppies-for-sale.jpg');
INSERT INTO puppies(name, breed, sex, age, imageUrl) VALUES ('Rex', 'Fox Red Labrador Retriever', 'Male', '7 months', 'https://gfp-2a3tnpzj.stackpathdns.com/wp-content/uploads/2019/12/Coda-m1.jpg');
