FROM node:latest AS builder
WORKDIR /usr/share/nginx/html
RUN apt update -y && apt upgrade -y
COPY . .
RUN npm i
RUN npm run build

FROM nginx:latest
WORKDIR /usr/share/nginx/html
COPY --from=builder /usr/share/nginx/html/build .

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
