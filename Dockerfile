# ==========================
# 1단계: Build Stage
# ==========================
FROM gradle:7.6.3-jdk17 AS builder
WORKDIR /app

# Gradle 캐시 디렉토리 생성 및 권한 부여
RUN mkdir -p /home/gradle/.gradle && chown -R gradle:gradle /home/gradle

# 프로젝트 복사
COPY . .

# Gradle Wrapper 사용 (없으면 gradle 명령어로 교체)
RUN ./gradlew clean build --no-daemon --refresh-dependencies

# ==========================
# 2단계: Runtime Stage
# ==========================
FROM openjdk:17-jdk-slim
WORKDIR /app

# builder에서 빌드 결과물만 복사 (jar)
COPY --from=builder /app/build/libs/*.jar app.jar

# 컨테이너 실행 시 기본 명령어
ENTRYPOINT ["java", "-jar", "app.jar"]

