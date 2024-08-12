### Exercice : Filtres Servlet

#### Objectif
Développer un système de journalisation complet pour suivre les requêtes et les réponses HTTP dans une application Spring Boot, en utilisant uniquement des filtres Servlet.


1. **Créer un filtre Servlet pour journaliser les détails des requêtes**
   - Le filtre doit capturer et enregistrer les informations suivantes pour chaque requête :
     - URI demandée
     - Méthode HTTP (GET, POST, etc.)
     - Timestamp de la requête
     - Adresse IP du client
