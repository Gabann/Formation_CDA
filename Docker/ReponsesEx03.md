# Rechercher l' image nginx sur le hub Docker.Par exemple, recherchons une image "nginx" :
docker search nginx

# téléchargez l'image nginx sur votre machine.
docker pull nginx

# Exécutez un conteneur basé sur l'image que vous avez téléchargée. Démarrer un conteneur détaché, expose le port 80 du conteneur sur le port 8080 de votre machine, et donne un nom au conteneur.
docker run --name nginx -d -p 8080:80 nginx

# Avec une commande vérifiez que le conteneur est en cours d'exécution.
docker ps

# Ouvrez un navigateur web et accédez à http://localhost:8080 pour voir si la page d'accueil de Nginx s'affiche.
# Utilisez une commande pour accéder à une session interactive à l'intérieur du conteneur.
docker exec -it nginx /bin/bash

# Explorez le système de fichiers à l'intérieur du conteneur.
ls

# Modifier la page index.html su serveur nginx.
cd /usr/share/nginx/html
apt update 
apt install nano
nano index.html

# Arrêtez le conteneur.
docker stop nginx

# Supprimez le conteneur.
docker rm nginx
docker rmi nginx
