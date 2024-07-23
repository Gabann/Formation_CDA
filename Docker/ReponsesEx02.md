# Recherchez et téléchargez l'image Docker officielle pour le serveur web Nginx.
docker search nginx
docker pull nginx

# Affichez la liste des images Docker présentes sur votre machine.
docker images

# Supprimez l'image Nginx que vous venez de télécharger de votre machine.
docker rmi nginx

# Téléchargez les images Docker officielles pour MySQL et Redis sur votre machine.
docker search mysql
docker pull mysql
docker search redis
docker pull redis

# Affichez à nouveau la liste des images Docker sur votre machine pour vérifier que les images de MySQL et Redis ont été téléchargées avec succès.
docker images

# Affichez les détails (metadata) de l'image Mysql que vous avez téléchargée précédemment.
docker inspect mysql

# Affichez l'historique de l'image MySQL pour voir les différentes couches qui la composent.
docker history mysql

# Rechercher une image Docker liée à un service ou une technologie de votre choix. Choisissez une image intéressante et affichez quelques informations à son sujet.
docker search node
docker pull node
docker history node
docker inspect node
