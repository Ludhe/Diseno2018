FROM postgres:9.6.3-alpine
ENV POSTGRES_USER=tpi2018
ENV POSTGRES_PASSWORD tpipass
ENV POSTGRES_DB mantenimiento
ADD script-user-tables.sql /docker-entrypoint-initdb.d/script-user-tables.sql
