# https://hub.docker.com/_/nginx
FROM nginx:1.17

COPY ./web.oidc.client.js/ /usr/share/nginx/html

RUN chmod -R 755 /usr/share/nginx/html

EXPOSE 80
