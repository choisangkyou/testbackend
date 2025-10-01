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

    // Spring Data JPA
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // Kotlin Reflection (필요: @Autowired, @Component 등)
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // QueryDSL (Jakarta for Spring Boot 3.x)
    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")

    implementation("com.vladmihalcea:hibernate-types-60:2.21.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // Database Driver (예: MySQL)
    runtimeOnly("mysql:mysql-connector-java:8.0.33")

    // Spring Security & JWT
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")

    // Password Encoding
    implementation("org.springframework.security:spring-security-crypto")

    //테스트
    testImplementation(kotlin("test"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.integration:spring-integration-test")


}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}