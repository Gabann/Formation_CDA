USE exercice_sql_sh;

# Obtenir l’utilisateur ayant le prénom “Muriel” et le mot de passe “test11”, sachant que l’encodage du mot de passe est effectué avec l’algorithme Sha1.
SELECT *
FROM client
WHERE prenom = 'Muriel' AND password = SHA1('test11');

# Obtenir la liste de tous les produits qui sont présent sur plusieurs commandes.
SELECT *
FROM commande_ligne
GROUP BY nom
HAVING COUNT(nom) > 1;

# Obtenir la liste de tous les produits qui sont présent sur plusieurs commandes et y ajouter une colonne qui liste les identifiants des commandes associées.
SELECT *, GROUP_CONCAT(commande_id)
FROM commande_ligne
GROUP BY nom
HAVING COUNT(commande_id) > 1;
    
# Enregistrer le prix total à l’intérieur de chaque ligne des commandes, en fonction du prix unitaire et de la quantité
UPDATE commande_ligne
SET prix_total = prix_unitaire * quantite;

# Obtenir le montant total pour chaque commande et y voir facilement la date associée à cette commande ainsi que le prénom et nom du client associé
SELECT commande_ligne.commande_id, SUM(commande_ligne.prix_total), commande.date_achat, client.nom, client.prenom
FROM commande_ligne
JOIN commande ON commande_ligne.commande_id = commande.id
JOIN client ON commande.client_id = client.id
GROUP BY commande_id;
    
# (difficulté très haute) Enregistrer le montant total de chaque commande dans le champ intitulé “cache_prix_total”
UPDATE commande
    JOIN (SELECT SUM(commande_ligne.prix_total) total_price, commande_ligne.commande_id commande_id
          FROM commande_ligne
          GROUP BY commande_ligne.commande_id) as tpci
SET cache_prix_total = total_price
WHERE commande.id = commande_id;

# Obtenir le montant global de toutes les commandes, pour chaque mois
SELECT SUM(cache_prix_total), YEAR(date_achat) Year, MONTH(date_achat) Month
FROM commande
GROUP BY MONTH(date_achat);

# Obtenir la liste des 10 clients qui ont effectué le plus grand montant de commandes, et obtenir ce montant total pour chaque client.
SELECT SUM(cache_prix_total) total_price, client.prenom, client.nom
FROM commande
JOIN client ON commande.client_id = client.id
GROUP BY client_id
ORDER BY total_price DESC 
LIMIT 10;
    
# Obtenir le montant total des commandes pour chaque date
SELECT SUM(cache_prix_total), DAY(date_achat), MONTH(date_achat) Month, YEAR(date_achat) Year
FROM commande
GROUP BY YEAR(date_achat), MONTH(date_achat), DAY(date_achat);


# Ajouter une colonne intitulée “category” à la table contenant les commandes. Cette colonne contiendra une valeur numérique
ALTER TABLE commande
ADD COLUMN category INT;
    
# Enregistrer la valeur de la catégorie, en suivant les règles suivantes :
# 
#     “1” pour les commandes de moins de 200€
#     “2” pour les commandes entre 200€ et 500€
#     “3” pour les commandes entre 500€ et 1.000€
#     “4” pour les commandes supérieures à 1.000€
UPDATE commande
SET category = 
    CASE 
        WHEN cache_prix_total > 1000 THEN 4
        WHEN cache_prix_total > 500 THEN 3
        WHEN cache_prix_total > 200 THEN 2
        ELSE 1
END ;

# Créer une table intitulée “commande_category” qui contiendra le descriptif de ces catégories
CREATE TABLE IF NOT EXISTS commande_category(
    id INT PRIMARY KEY AUTO_INCREMENT,
    description TEXT
);
    
# Insérer les 4 descriptifs de chaque catégorie au sein de la table précédemment créée
INSERT INTO commande_category(description)
VALUES ('Superieur a 1000'),
       ('Entre 500 et 1000'),
       ('Entre 200 et 500'),
       ('Inferieur a 200');

# Supprimer toutes les commandes (et les lignes des commandes) inférieur au 1er février 2019. Cela doit être effectué en 2 requêtes maximum
DELETE
FROM commande
WHERE commande.date_achat < 