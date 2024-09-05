# CREATE TABLE User_playlist
# (
#     id INT AUTO_INCREMENT PRIMARY KEY,
#     username varchar(30) UNIQUE,
#     email varchar(50) UNIQUE,
#     signup_date date,
#     country varchar(30)
# );
#
# CREATE TABLE Music
# (
#     id INT AUTO_INCREMENT PRIMARY KEY,
#     title varchar(100),
#     artist varchar(30),
#     album varchar(30),
#     length_seconds int,
#     genre varchar(30),
#     release_year year
# );
#
# CREATE TABLE Playlist(
#     id INT AUTO_INCREMENT PRIMARY KEY,
#     name varchar(30),
#     user_id int,
#     creation_date date,
#     FOREIGN KEY (user_id) REFERENCES User_playlist(id)
# );
#
# CREATE TABLE Students (
#                           student_id INT PRIMARY KEY AUTO_INCREMENT,
#                           first_name VARCHAR(50) NOT NULL,
#                           last_name VARCHAR(50) NOT NULL,
#                           age INT,
#                           grade VARCHAR(10)
# );
#
# INSERT INTO Students(first_name, last_name, age, grade)
# VALUES ('Maria', 'Rodriguez', 21, 'B'),
#        ('Ahmed', 'Khan', 19, 'A'),
#        ('Emily', 'Baker', 22, 'C');
#
# UPDATE Students
# SET grade = 'A'
# WHERE first_name = 'Maria' AND last_name = 'Rodriguez';
#
# UPDATE Students
# SET age = age + 1;
#
# DELETE
# FROM students
# WHERE first_name = 'Emily';
#
# DELETE
# FROM students
# WHERE age < 20;
#
# TRUNCATE students;
#
# CREATE TABLE Customers(
#     id int PRIMARY KEY AUTO_INCREMENT,
#     first_name varchar(50),
#     last_name varchar(50),
#     city varchar(50)
# );
#
# CREATE TABLE Purchases(
#     id int PRIMARY KEY AUTO_INCREMENT,
#     customer_id int,
#     hibernateProduct varchar(50),
#     amount varchar(50),
#
#     FOREIGN KEY (customer_id) REFERENCES Customers(id)
# );
#
# INSERT INTO Customers(first_name, last_name, city)
# VALUES ('John', 'Doe', 'New York'),
#        ('Jane', 'Doe', 'Los Angeles'),
#        ('Alice', 'Johnson', 'Chicago'),
#        ('Bob', 'Smith', 'Houston'),
#        ('Charlie', 'Brown', 'Phoenix');
#
# INSERT INTO Purchases(customer_id, hibernateProduct, amount)
# VALUES (1, 'Product1', '100'),
#        (2, 'Product2', '200'),
#        (2, 'Product3', '300'),
#        (4, 'Product4', '400'),
#        (1, 'Product5', '500'),
#        (4, 'Product6', '600'),
#        (2, 'Product7', '700'),
#        (4, 'Product8', '800'),
#        (4, 'Product9', '900'),
#        (null, 'Product10', '1000');
#
# TRUNCATE Purchases;
#
# -- Sélectionnez les noms et prénoms des clients ainsi que les détails de leurs achats (si disponibles).
# SELECT Customers.first_name, Customers.last_name, Purchases.*
# FROM Customers
# JOIN Purchases on Customers.id = Purchases.customer_id;
#
# -- Sélectionnez tous les clients et les détails de leurs achats s'ils ont effectué des achats, sinon affichez les colonnes des achats avec des valeurs NULL.
# SELECT *
# FROM Customers
# LEFT JOIN Purchases
# ON Customers.id = Purchases.customer_id;
#
# -- Sélectionnez tous les achats et les détails des clients correspondants, même s'il n'y a pas de correspondance pour certains achats.
# SELECT *
# FROM Customers
# RIGHT JOIN  Purchases
# ON Customers.id = Purchases.customer_id;
#
# -- Sélectionnez tous les clients et tous les achats, en affichant les détails des clients même s'ils n'ont pas effectué d'achats, et vice versa.
# SELECT *
# FROM Customers
#          LEFT JOIN Purchases
#          ON Customers.id = Purchases.customer_id
#
# UNION
#
# SELECT *
# FROM Customers
#          RIGHT JOIN Purchases
#          ON Customers.id = Purchases.customer_id;

# ----------------------------------------------------------------------------------------------------------------------------------

# Modélisation
CREATE DATABASE IF NOT EXISTS tabletoptreasures_database;

USE tabletoptreasures_database;

CREATE TABLE IF NOT EXISTS Client
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    nom       VARCHAR(50) NOT NULL,
    prenom    VARCHAR(50) NOT NULL,
    mail      VARCHAR(50) NOT NULL UNIQUE,
    adresse   VARCHAR(150),
    telephone VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS Jeu
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    nom          VARCHAR(50) NOT NULL,
    description  TEXT,
    prix         FLOAT       NOT NULL,
    id_categorie INT         NOT NULL,
    FOREIGN KEY (id_categorie) REFERENCES Categorie (id)
);

CREATE TABLE IF NOT EXISTS Categorie
(
    id  INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Commande
(
    id                INT AUTO_INCREMENT PRIMARY KEY,
    id_client         INT          NOT NULL,
    date_commande     TIMESTAMP    NOT NULL DEFAULT NOW(),
    adresse_livraison VARCHAR(150) NOT NULL,
    statut            VARCHAR(50),
    FOREIGN KEY (id_client) REFERENCES Client (id)
);

# 1. Insérez les enregistrements du fichier annexe dans les tables "Jeux",
# "Categories" et "Clients"
INSERT INTO Categorie(nom)
VALUES ('Stratégie'),
       ('Familial'),
       ('Aventure');

INSERT INTO Jeu(nom, description, prix, id_categorie)
VALUES ('Catan', 'Jeu de stratégie et de développement de colonies', 30, 1),
       ('Dixit', 'Jeu d''association d''images', 25, 2),
       ('Les Aventuriers', 'Jeu de plateau d''aventure', 40, 3),
       ('Carcassonne', 'Jeu de placement de tuiles', 28, 1),
       ('Codenames', 'Jeu de mots et d''indices', 20, 2),
       ('Pandemic', 'Jeu de coopération pour sauver le monde', 35, 3),
       ('7 Wonders', 'Jeu de cartes et de civilisations', 29, 1),
       ('Splendor', 'Jeu de développement économique', 27, 2),
       ('Horreur à Arkham', 'Jeu d''enquête et d''horreur', 45, 3),
       ('Risk', 'Jeu de conquête mondiale', 22, 1),
       ('Citadelles', 'Jeu de rôles et de bluff', 23, 2),
       ('Terraforming Mars', 'Jeu de stratégie de colonisation de Mars', 55, 3),
       ('Small World', 'Jeu de civilisations fantastiques', 32, 1),
       ('7 Wonders Duel', 'Jeu de cartes pour 2 joueurs', 26, 2),
       ('Horreur à l''Outreterre', 'Jeu d''aventure horrifique', 38, 3);

INSERT INTO Client(nom, prenom, mail, adresse, telephone)
VALUES ('Dubois', 'Marie', 'marie.dubois@example.com', '123 Rue de la Libération, Ville', '+1234567890'),
       ('Lefebvre', 'Thomas', 'thomas.lefebvre@example.com', '456 Avenue des Roses, Ville', '+9876543210'),
       ('Martinez', 'Léa', 'lea.martinez@example.com', '789 Boulevard de la Paix, Ville', '+2345678901'),
       ('Dupuis', 'Antoine', 'antoine.dupuis@example.com', '567 Avenue de la Liberté, Ville', '+3456789012'),
       ('Morin', 'Camille', 'camille.morin@example.com', '890 Rue de l''Avenir, Ville', '+4567890123'),
       ('Girard', 'Lucas', 'lucas.girard@example.com', '234 Avenue des Champs, Ville', '+5678901234'),
       ('Petit', 'Emma', 'emma.petit@example.com', '123 Rue des Étoiles, Ville', '+6789012345'),
       ('Sanchez', 'Gabriel', 'gabriel.sanchez@example.com', '345 Boulevard du Bonheur, Ville', '+7890123456'),
       ('Rossi', 'Clara', 'clara.rossi@example.com', '678 Avenue de la Joie, Ville', '+8901234567'),
       ('Lemoine', 'Hugo', 'hugo.lemoine@example.com', '456 Rue de la Nature, Ville', '+9012345678'),
       ('Moreau', 'Eva', 'eva.moreau@example.com', '789 Avenue de la Créativité, Ville', '+1234567890'),
       ('Fournier', 'Noah', 'noah.fournier@example.com', '234 Rue de la Découverte, Ville', '+2345678901'),
       ('Leroy', 'Léa', 'lea.leroy@example.com', '567 Avenue de l''Imagination, Ville', '+3456789012'),
       ('Robin', 'Lucas', 'lucas.robin@example.com', '890 Rue de la Création, Ville', '+4567890123'),
       ('Marchand', 'Anna', 'anna.marchand@example.com', '123 Boulevard de l''Innovation, Ville', '+5678901234');

# 2. Effectuez trois commandes en insérant une nouvelle entrée dans la table
# "Commandes". Assurez-vous d'inclure l'ID du client (créé précédemment), la
# date de commande, l'adresse de livraison et le statut de la commande.
SET @Id = '5';
INSERT INTO Commande(id_client, adresse_livraison, statut)
VALUES (@Id, (SELECT adresse
              FROM Client
              WHERE id = @Id), 'En cour de préparation');

SET @Id = '1';
INSERT INTO Commande(id_client, adresse_livraison, statut)
VALUES (@Id, (SELECT adresse
              FROM Client
              WHERE id = @Id), 'En cour de préparation');

SET @Id = '10';
INSERT INTO Commande(id_client, adresse_livraison, statut)
VALUES (@Id, (SELECT adresse
              FROM Client
              WHERE id = @Id), 'En cour de préparation');

# 3. Mettez à jour le prix du jeu avec l'ID 3 (Les Aventuriers) pour le fixer à 35 €.
UPDATE jeu
SET prix = 35
WHERE id = 3;

# 4. Supprimez le jeu avec l'ID 2 (Dixit) de la table "Jeux
DELETE
FROM jeu
WHERE id = 2;


CREATE TABLE IF NOT EXISTS Jeu_commande
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    id_jeu      INT,
    id_commande INT,
    FOREIGN KEY (id_jeu) REFERENCES Jeu (id),
    FOREIGN KEY (id_commande) REFERENCES Commande (id)
);

INSERT INTO Jeu_commande(id_jeu, id_commande)
VALUES (1, 1),
       (10, 1),
       (5, 2),
       (7, 3),
       (6, 4),
       (7, 5);
# ----------------------------------------------------------------------------------------------------------------------------------

# 1. Sélectionnez tous les noms de catégories distinctes
SELECT DISTINCT nom
FROM categorie;

# 2. Montrez les catégories avec des noms commençant par "A" ou "S".
SELECT *
FROM categorie
WHERE nom LIKE 'A%'
   OR nom LIKE 'S%';

# 3. Quelles catégories ont un ID entre 2 et 5 inclus ?
SELECT *
FROM categorie
WHERE id BETWEEN 2 AND 5;

# 4. Combien de catégories différentes existent ?
SELECT COUNT(DISTINCT nom) 'distinct categories'
FROM categorie;

# 5. Quelle est la catégorie ayant le nom le plus long ?
SELECT MAX(CHAR_LENGTH(nom)), nom
FROM Categorie;

# 6. Montrez le nombre de jeux dans chaque catégorie
SELECT COUNT(*), Categorie.nom
FROM jeu
         JOIN Categorie ON Categorie.id = jeu.id_categorie
GROUP BY Jeu.id_categorie;

# 7. Affichez les catégories triées par ordre alphabétique inversé.
SELECT Categorie.nom
FROM Categorie
ORDER BY Categorie.nom DESC;

# ----------------------------------------------------------------------------------------------------------------------------------

# 1. Sélectionnez tous les noms de jeux distincts
SELECT DISTINCT nom
FROM jeu;

# 2. Montrez les jeux avec un prix entre 25 et 40.
SELECT *
FROM jeu
WHERE prix BETWEEN 25 AND 40;

# 3. Quels jeux appartiennent à la catégorie avec l'ID 3 ?
SELECT *
FROM jeu
WHERE id = 3;

# 4. Combien de jeux ont une description contenant le mot "aventure" ?
SELECT COUNT(*) 'Jeu avec le mot aventure en description'
FROM jeu
WHERE description LIKE '%aventure%';

# 5. Quel est le jeu le moins cher ?
SELECT *
FROM jeu
WHERE prix = (SELECT MIN(prix)
              FROM jeu);

# 6. Montrez la somme totale des prix de tous les jeux.
SELECT SUM(prix) 'Prix total des jeux'
FROM jeu;

# 7. Affichez les jeux triés par ordre alphabétique des noms en limitant les résultats à 5.
SELECT *
FROM jeu
ORDER BY nom
LIMIT 5;

# ----------------------------------------------------------------------------------------------------------------------------------

# 1. Sélectionnez tous les prénoms des clients distincts.
SELECT DISTINCT nom
FROM Client;

# 2. Montrez les clients dont l'adresse contient "Rue" et dont le numéro de téléphone
# commence par "+1"
SELECT *
FROM Client
WHERE adresse LIKE '%Rue%'
  AND telephone LIKE '+1%';

# 3. Quels clients ont un nom commençant par "M" ou "R" ?
SELECT *
FROM Client
WHERE nom LIKE 'M%'
   OR nom LIKE 'R%';

# 4. Combien de clients ont une adresse e-mail valide (contenant "@") ?
SELECT COUNT(*)
FROM Client
WHERE mail LIKE '%@%';

# 5. Quel est le prénom le plus court parmi les clients ?
SELECT *
FROM Client
WHERE CHAR_LENGTH(prenom) = (SELECT (MIN(CHAR_LENGTH(prenom)))
                             FROM Client);

# 6. Montrez le nombre total de clients enregistrés.
SELECT COUNT(*)
FROM Client;

# 7. Affichez les clients triés par ordre alphabétique des noms de famille, mais en
# excluant les premiers 3.
SELECT *
FROM Client
LIMIT 18446744073709551615 OFFSET 3;

# ----------------------------------------------------------------------------------------------------------------------------------

# 1. Sélectionnez les noms des clients, noms de jeux et date de commande pour
# chaque commande passée.
SELECT Client.nom, Jeu.nom, Commande.date_commande
FROM Commande
         JOIN Client ON Commande.id_client = Client.id
         JOIN Jeu_commande ON Commande.id = Jeu_commande.id_commande
         JOIN Jeu ON Jeu_commande.id_jeu = Jeu.id;

# 2. Sélectionnez les noms des clients et le montant total dépensé par chaque client.
# Triez les résultats par montant total décroissant.
SELECT Client.nom, SUM(Jeu.Prix)
FROM Client
         JOIN Commande ON Commande.id_client = Client.id
         JOIN Jeu_commande ON Commande.id = Jeu_commande.id_commande
         JOIN Jeu ON Jeu_commande.id_jeu = Jeu.id
GROUP BY Client.id
ORDER BY SUM(Jeu.prix) DESC;

# 3. Sélectionnez les noms des jeux, noms de catégories et prix de chaque jeu.
SELECT Jeu.prix, Jeu.nom, Categorie.nom
FROM Jeu
         JOIN Categorie ON Categorie.id = Jeu.id_categorie;

# 4. Sélectionnez les noms des clients, date de commande et noms de jeux pour
# toutes les commandes passées.
SELECT Client.nom, Commande.date_commande, Jeu.nom
FROM Client
         JOIN Commande ON Client.id = Commande.id_client
         JOIN Jeu_commande ON Commande.id = Jeu_commande.id_commande
         JOIN Jeu ON Jeu.id = Jeu_commande.id_jeu;

# 5. Sélectionnez les noms des clients, nombre total de commandes par client et
# montant total dépensé par client. Incluez uniquement les clients ayant effectué
# au moins une commande.
SELECT Client.nom, COUNT(DISTINCT Commande.id), SUM(Jeu.prix)
FROM Client
         JOIN Commande ON Client.ID = COMMANDE.ID_CLIENT
         JOIN Jeu_commande ON Commande.ID = Jeu_commande.ID_COMMANDE
         JOIN Jeu ON Jeu_commande.ID_JEU = Jeu.ID
GROUP BY Client.id
