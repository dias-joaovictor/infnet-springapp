#!/bin/bash


CONTAINER_ID=$(docker ps -q --filter "name=plantuml")

PORT=8787

if [ ! -n "$CONTAINER_ID" ]; then
    docker run -d -p ${PORT}:8080 --name  plantuml plantuml/plantuml-server:jetty
fi


cat payment.puml | curl -X POST --data-binary @- http://localhost:${PORT}/png > payment.png

