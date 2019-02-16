sudo docker rm -f javacontainer mysqlcontainer
sudo docker build -t mysql-img  -f mysql-dockerfile .
sudo docker run --name mysqlcontainer -d -p 3306:3306 mysql-img
sudo mvn clean install
sudo chmod -R 777 target
sudo docker build -t java-img  -f java-dockerfile .
sudo docker run --name javacontainer -d -p 80:8888 java-img
