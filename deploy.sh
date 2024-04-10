#!/bin/bash

IS_GREEN=$(sudo docker ps | grep green) # 현재 실행중인 App이 blue인지 확인합니다.

if [ -z "$IS_GREEN" ]; then # blue라면
  echo "### BLUE => GREEN ###"

  OLD_CONTAINER='be-green'
  NEW_CONTAINER='be-blue'

else
  echo "### GREEN => BLUE ###"

  OLD_CONTAINER='be-green'
  NEW_CONTAINER='be-blue'
fi

echo "1. get new image"
sudo docker compose pull $NEW_CONTAINER

echo "2. OLD container resize to 1"
sudo docker compose up -d $OLD_CONTAINER --scale $OLD_CONTAINER=1
sleep 10

echo "3. NEW container up"
sudo docker compose up -d $NEW_CONTAINER --scale $NEW_CONTAINER=3

sleep 60

echo "4. reload nginx"
sudo cp /home/ubuntu/nginx/config/nginx_green.conf /home/ubuntu/nginx/config/nginx.conf
sudo docker compose exec nginx service nginx reload

echo "5. blue container down"
sudo docker compose down $OLD_CONTAINER