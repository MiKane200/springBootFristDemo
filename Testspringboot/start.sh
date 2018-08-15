docker-compose up -d;
# while ! telnet ${IP} ${JAVA_PORT} | grep "Connected";do sleep 3; done;
echo "please wait spring boot started·······";
sleep 30;
curl -H "Content-Type: application/json" -sd '{"languageId":"1"}' "$(docker-machine ip $(docker-machine active)):8888/test/test";
echo "wait data to be loaded completed·······";
sleep 15;
sh stop.sh;
echo "attention !!! This program was over,see the results on the top";