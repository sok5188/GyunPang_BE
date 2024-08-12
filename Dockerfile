FROM amazoncorretto:17-al2-jdk AS builder
LABEL authors="sok5188"

RUN mkdir /be
WORKDIR /be

COPY . .

FROM amazoncorretto:17.0.10-alpine

ENV TZ=Asia/Seoul

RUN mkdir /be
WORKDIR /be

COPY --from=builder /be/build/libs/*.jar app.jar

CMD ["java", "-jar", "-javaagent:/pinpoint-agent/pinpoint-bootstrap-3.0.0.jar", "-Dpinpoint.agentId=be","-Dpinpoint.applicationName=be","app.jar"]
