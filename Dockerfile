FROM amazoncorretto:17-al2-jdk AS builder
LABEL authors="sok5188"

RUN mkdir /be
WORKDIR /be

COPY . .

FROM amazoncorretto:17.0.10-alpine

ENV TZ=Asia/Seoul

RUN mkdir /be
WORKDIR /be
ARG PINPOINT_AGENTID=be-1

COPY --from=builder /be/build/libs/*.jar app.jar

COPY entrypoint.sh /be/entrypoint.sh

RUN chmod +x /be/entrypoint.sh

ENTRYPOINT ["/be/entrypoint.sh"]

#CMD ["java", "-jar", "-javaagent:/pinpoint-agent/pinpoint-bootstrap-3.0.0.jar", "-Dpinpoint.agentId=${PINPOINT_AGENTID}","-Dpinpoint.applicationName=Main-Backend","app.jar"]
