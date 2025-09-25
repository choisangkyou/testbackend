plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.5.4"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("plugin.jpa") version "1.9.25"
    kotlin("kapt") version "1.9.25"

}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Spring Boot
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springdoc:springdoc-openapi-ui:1.7.0")
    implementation("org.springdoc:springdoc-openapi-kotlin:1.7.0")



    //테스트
    testImplementation(kotlin("test"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.integration:spring-integration-test")
//    testImplementation("org.testcontainers:testcontainers:1.19.0")
//    testImplementation("org.testcontainers:junit-jupiter:1.19.0")
//    testImplementation("org.testcontainers:mysql:1.19.0") // MySQL 예시
//    testImplementation("io.mockk:mockk:1.13.7")
//    testImplementation("org.springframework.security:spring-security-test")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}