FROM store/oracle/serverjre:8
COPY backend-1.0-SNAPSHOT.jar /home/backend.jar
ENV logDir=/home/log
RUN mkdir -p $logDir
CMD java -jar /home/backend.jar -Dlogging.file=$logDir/backend.log
VOLUME "$logDir"
