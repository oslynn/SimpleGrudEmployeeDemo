#!/bin/bash

RES="src/main/resources"

case $1 in
    "localhost")
        echo "deploy to localhost"
        cp localhost.build.gradle build.gradle
        cp $RES/localhost.properties $RES/application.properties
        ;;
    "cloud")
        echo "deploy to google cloud"
        cp gcp.build.gradle build.gradle
        cp $RES/gcp.properties $RES/application.properties
        ;;
    *)
        echo "Please type: deploy.sh [localhost|cloud] <Enter>"
        ;;
esac