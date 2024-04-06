#!/bin/bash

IS_GREEN=$(docker ps | grep green) # 현재 실행중인 App이 blue인지 확인합니다.

if [ -z "$IS_GREEN" ]; then # blue라면

  echo "### BLUE => GREEN ###"

  echo "1. get green image"
  docker compose pull be-green

  echo "2. green container up"
  docker compose up -d be-green --scale be-green=3

  for cnt in {1..10}
  do
    echo "3. green health check..."
    echo "서버 응답 확인중(${cnt}/10)";

    REQUEST=$(curl http://localhost/health)
      if [ -n "$REQUEST" ]
        then # 서비스 가능하면 health check 중지
          echo "health check success"
          break ;
        else
          sleep 10

      fi
  done;

  if [ $cnt -eq 10 ]
  then
  	echo "서버가 정상적으로 구동되지 않았습니다."
  	exit 1
  fi

  echo "4. reload nginx"
  sudo cp /home/ubuntu/nginx/config/nginx_green.conf /home/ubuntu/nginx/config/nginx.conf
  sudo docker compose exec nginx service nginx reload

  echo "5. blue container down"
  docker compose stop be-blue
else
  echo "### GREEN => BLUE ###"

  echo "1. get blue image"
  docker compose pull be-blue

  echo "2. blue container up"
  docker compose up -d be-blue --scale be-blue=3

  for cnt in {1..10}
  do
    echo "3. blue health check..."
    echo "서버 응답 확인중(${cnt}/10)";

    REQUEST=$(curl http://localhost/health) # blue로 request

    if [ -n "$REQUEST" ]
      then # 서비스 가능하면 health check 중지
        echo "health check success"
        break ;
      else
        sleep 10

    fi
  done;

  if [ $cnt -eq 10 ]
  then
  	echo "서버가 정상적으로 구동되지 않았습니다."
  	exit 1
  fi

  echo "4. reload nginx"
  sudo cp /home/ubuntu/nginx/config/nginx_blue.conf /home/ubuntu/nginx/config/nginx.conf
  sudo docker compose exec nginx service nginx reload

  echo "5. green container down"
  docker compose stop be-green
fi