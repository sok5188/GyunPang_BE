#!/bin/sh

java -jar -javaagent:/pinpoint-agent/pinpoint-bootstrap-3.0.0.jar \
  -Dpinpoint.agentId=${PINPOINT_AGENT_ID:-NoAgentId} \
  -Dpinpoint.applicationName=Main-Backend \
  app.jar