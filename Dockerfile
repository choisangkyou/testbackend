# ==========================
# 1단계: Build Stage
# ==========================
FROM gradle:7.6.3-jdk17 AS builder
WORKDIR /app

# Gradle 캐시 디렉토리 생성 및 권한 부여
RUN mkdir -p /home/gradle/.gradle && chown -R gradle:gradle /home/gradle

# 프로젝트 복사
COPY . .

# gradlew 실행 권한 부여
RUN chmod +x ./gradlew

# Gradle Wrapper 사용 (캐시 활용) # --refresh-dependencies 제거
RUN ./gradlew clean build --no-daemon

# ==========================
# 2단계: Runtime Stage
# ==========================
FROM openjdk:17-jdk-slim
WORKDIR /app

# builder에서 빌드 결과물만 복사 (jar)
COPY --from=builder /app/build/libs/*.jar app.jar


# 환경 변수 (OCI 배포 시 주입 가능)
ENV JAVA_OPTS="-Xms512m -Xmx1024m"
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
## 컨테이너 실행 시 기본 명령어
#ENTRYPOINT ["java", "-jar", "app.jar"]

