FROM node:18.10-alpine AS build
WORKDIR /usr/src/app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build

FROM nginx:1.24.0-alpine
COPY nginx.conf nginx.conf
COPY --from=build /usr/src/app/dist/naumen-frontend /usr/share/nginx/html

