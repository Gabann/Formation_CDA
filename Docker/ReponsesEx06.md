# Exercice 6

# On souhaite cree une imge docker pour distribue notre site web statique via un serveur web

# - Choisir une image de serveur web
# - Cree un dockerfile a partir de cette image qui a la place de sa page par défaut montrera votre projet
``` dockerfile
	FROM nginx:latest
	WORKDIR /usr/share/nginx/html
	COPY . .
	RUN apt update -y && apt upgrade -y
	EXPOSE 80
```


# - Vous notere la commande pour teste votre image
``` docker
docker build -t gabann/apidex .
docker run -d -p 9010:80 --name apidex-dockerFile apidex-nginx
```

# Bonus :
# - Vous publierez cette image sur docker hub 
```  docker
docker tag apidex-nginx gabann/apidex
docker push gabann/apidex:tagname
```

https://hub.docker.com/repository/docker/gabann/apidex/general
