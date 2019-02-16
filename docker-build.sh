sudo docker rm -f javacontainer
sudo mvn clean install
sudo chmod -R 777 target
sudo docker build -t java-img  -f java-dockerfile .
sudo docker run --name javacontainer -d -p 80:8888 java-img
