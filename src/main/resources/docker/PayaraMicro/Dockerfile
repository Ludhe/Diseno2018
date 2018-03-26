# Agregando la imagen
FROM payara/micro:5-SNAPSHOT

# Descargando el JDBC
# RUN wget -O $PAYARA_PATH/postgresql-42.2.2.jar https://jdbc.postgresql.org/download/postgresql-42.2.2.jar
COPY postgresql-42.2.2.jar $PAYARA_PATH/

# Agregando el archivo de comandos asadmin
COPY asadmin.txt $PAYARA_PATH/

# Agregando nuestra aplicacion web al directorio autodeploy
COPY Mantenimiento-1.0-SNAPSHOT.war $PAYARA_PATH/

# Agregando la libreria, Ejecutamos los comandos asadmin(Pool y Resources) y hacemos Deploy
ENTRYPOINT ["java", "-jar", "payara-micro.jar", "--addLibs", "postgresql-42.2.2.jar", "--postbootcommandfile", "asadmin.txt","--deploy", "Mantenimiento-1.0-SNAPSHOT.war"]
