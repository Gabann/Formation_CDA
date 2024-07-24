FROM nginx:latest
WORKDIR /usr/share/nginx/html
COPY . .
RUN apt update -y && apt upgrade -y
EXPOSE 80
