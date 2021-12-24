#!/bin/sh
mvn clean package && docker build -t ma.emsi.saad/TPBanque .
docker rm -f TPBanque || true && docker run -d -p 9080:9080 -p 9443:9443 --name TPBanque ma.emsi.saad/TPBanque