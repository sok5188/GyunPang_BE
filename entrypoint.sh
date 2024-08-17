#!/bin/sh

java -jar -javaagent:/pinpoint-agent/pinpoint-bootstrap-3.0.0.jar \
  -Dpinpoint.agentId=${PINPOINT_AGENTID:-NoAgentId} \
  -Dpinpoint.applicationName=Main-Backend \
  app.jar