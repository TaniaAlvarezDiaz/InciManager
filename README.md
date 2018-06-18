[![Build Status](https://travis-ci.com/TaniaAlvarezDiaz/InciManager.svg?token=ENc151Ahc3Y3oqzaSf7S&branch=master)](https://travis-ci.com/TaniaAlvarezDiaz/InciManager)

# InciManager
Módulo encargado de tramitar las incidencias que serán eviadas por los agentes. Dichos agentes deberán estar dados de alta en el sistema y tener permisos para enviar las incidencias.

# Author

Tania Álvarez Díaz ([@TaniaAlvarezDiaz](https://github.com/TaniaAlvarezDiaz))

# Execute

Para ejecutar el proyecto seguir los siguientes pasos:

1. Ejecutar la base de datos, en este caso HSQLDB.

2. Descargar [Apache Kafka] (https://kafka.apache.org/quickstart) y seguir los siguientes pasos, todos ellos desde la consola CMD.
   * Ir a la capeta donde está el zip de Kafka descomprimido.
   * Ejecutar Apache Zookeeper. Para ello ejecutar:
     * En Windows: bin\windows\zookeeper-server-start.bat config\zookeeper.properties
     * En Mac: bin/zookeeper-server-start.sh config/zookeeper.properties
   * Se va a quedar bloqueada esa consola CMD, por tanto, sin cerrarla, abrir otra consola. Ejecutar Apache Kafka:
     * En Windows: bin\windows\kafka-server-start.bat config/server.properties
     * En Mac: bin/kafka-server-start.sh config/server.properties

3. Ejecutar [Agents] (https://github.com/TaniaAlvarezDiaz/Agents). Desde la carpeta Agents ejecutar: 
   * mvn spring-boot:run

4. Desde la carpeta InciManager ejecutar:
   * mvn spring-boot:run

5. Desde un navegador acceder a:
   * localhost:8090
