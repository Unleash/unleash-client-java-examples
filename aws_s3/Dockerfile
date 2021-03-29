FROM openjdk:slim

RUN apt-get update && apt-get -y install wget
WORKDIR /app

COPY build/distributions/unleash-aws-s3.tar /tmp
RUN tar xf /tmp/unleash-aws-s3.tar -C /app

CMD ["/app/unleash-aws-s3/bin/unleash-aws-s3"]
