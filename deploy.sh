#!/bin/bash

IS_GREEN=$(sudo docker ps | grep green)

if [ -z "$IS_GREEN" ]; then
  OLD_CONTAINER='be-blue'
  NEW_CONTAINER='be-green'
  NEW_CONF='nginx_green.conf'

else
  OLD_CONTAINER='be-green'
  NEW_CONTAINER='be-blue'
  NEW_CONF='nginx_blue.conf'
fi

echo "OLD : $OLD_CONTAINER , NEW : $NEW_CONTAINER, CONF : $NEW_CONF"
echo "1. get new image"
sudo docker compose pull $NEW_CONTAINER

echo "2. OLD container resize to 1"
sudo docker compose scale $OLD_CONTAINER=1
sleep 10

echo "3. NEW container up"
sudo docker compose up -d $NEW_CONTAINER --scale $NEW_CONTAINER=3

sleep 60

echo "4. reload nginx"
sudo cp /home/ubuntu/nginx/config/$NEW_CONF /home/ubuntu/nginx/config/nginx.conf
sudo docker compose exec nginx service nginx reload

echo "5. blue container down"
sudo docker compose down $OLD_CONTAINER