plugins {
  java
  application
}

application {
  mainClass.set("ai.getunleash.UnleashExample")
}


repositories {
  mavenCentral()
  mavenLocal()
}

dependencies {
  implementation("no.finn.unleash:unleash-client-java:4.2.1")
  implementation("org.apache.logging.log4j:log4j-api:2.13.1")
  implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.13.1")
  implementation("org.apache.logging.log4j:log4j-core:2.13.1")
  implementation("software.amazon.awssdk:s3:2.16.29")
}
