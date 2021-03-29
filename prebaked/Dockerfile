FROM openjdk:slim

RUN apt-get update && apt-get -y install wget
WORKDIR /app

COPY build/distributions/unleash-prebaked.tar /tmp
RUN tar xf /tmp/unleash-prebaked.tar -C /app

# DOWNLOAD current state of demo app
RUN wget -O /app/backup.json https://unleash.herokuapp.com/api/client/features

ENV UNLEASH_BOOTSTRAP_FILE "/app/backup.json"

CMD ["/app/unleash-prebaked/bin/unleash-prebaked"]