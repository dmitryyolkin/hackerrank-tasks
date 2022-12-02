plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"
java {
    targetCompatibility = JavaVersion.VERSION_17
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit", "junit", "4.12")
    testImplementation("com.google.guava", "guava", "30.0-jre")
    testImplementation("com.tngtech.java", "junit-dataprovider", "1.13.1")
}
