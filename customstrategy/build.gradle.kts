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
  implementation("io.getunleash:unleash-client-java:5.0.1")
  implementation("org.apache.logging.log4j:log4j-api:2.13.1")
  implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.13.1")
  implementation("org.apache.logging.log4j:log4j-core:2.13.1")
}
