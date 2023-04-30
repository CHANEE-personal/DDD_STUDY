FROM openjdk:11 AS BUILD_IMAGE
WORKDIR /usr/app/
COPY settings.gradle gradlew /usr/app/
COPY gradle /usr/app/gradle
RUN ./gradlew build || return 0 
COPY . .
RUN ./gradlew build

FROM openjdk:11
WORKDIR /usr/app/
COPY --from=BUILD_IMAGE /usr/app/api/build/libs/api-1.0-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java","-jar", "api-1.0-SNAPSHOT.jar"]
