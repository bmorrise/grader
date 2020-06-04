FROM nginx
COPY maven/frontend-1.0-SNAPSHOT.zip /tmp
RUN apt-get update && apt-get install -y unzip && unzip -o /tmp/frontend-1.0-SNAPSHOT.zip -d /usr/share/nginx/html && mv /usr/share/nginx/html/frontend-1.0-SNAPSHOT/* /usr/share/nginx/html/
COPY maven/default.conf /etc/nginx/conf.d