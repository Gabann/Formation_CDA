FROM node:latest AS builder
WORKDIR /usr/share/nginx/html
RUN apt update -y && apt upgrade -y
RUN apt-get install git -y
RUN git clone https://github.com/Gabann/APIDEX.git .
RUN npm i
RUN npm run build

FROM nginx:latest
WORKDIR /usr/share/nginx/html
COPY --from=builder /usr/share/nginx/html/APIDEX/dist .

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
