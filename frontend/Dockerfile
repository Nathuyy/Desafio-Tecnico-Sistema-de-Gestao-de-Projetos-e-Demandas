# 1️⃣ build da aplicação
FROM node:20-alpine as build

WORKDIR /app
COPY package*.json ./
RUN npm install

COPY . .
RUN npm run build

# 2️⃣ servidor nginx para servir o build
FROM nginx:alpine

COPY --from=build /app/dist /usr/share/nginx/html

# nginx escuta na porta 80
EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
