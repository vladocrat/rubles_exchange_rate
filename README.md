# rubles_exchange_rate

*Work in progress*

The app returns different gifs by given tags(using GIPHY API) dependent on the exchange rate of a currency (Defaults to USD) compared to ruble(using openexchangerates API) 

For example: 1 ruble is 0.0136 part of a USD and if tomorrow it will change to lets say 0.154 you will get a random gif from this selection https://giphy.com/search/rich (tag is the word at the end of the link, rich in this case), otherwise a random gif from this selection https://giphy.com/search/broke will be recieved. 

![image](https://user-images.githubusercontent.com/47445848/132402682-8a494383-4fd5-407d-82c5-f1ad139789f1.png)

# installation

*On linux make sure you are logged as root or add sudo before every command!*

1) make sure you have docker and docker-compose installed by writing following commands into the terminal:
```shell
 docker version
```

```shell
docker-compose --version
```

2) pull the image using docker pull command:

```shell
docker pull sherlotta/springboot-docker-compose-app 
```
3) create a config file called docker-compose.yml and paste the following code in:

```yml
version: "3.3"

services:
  springboot-docker-compose-app-container:
    image: sherlotta/springboot-docker-compose-app:1
    build:
      context: ./
      dockerfile: Dockerfile
    volumes:
      - /data/springboot-docker-compose-app
    ports:
      - "8081:8081"
    environment:
      server.port: 8081
      server.adress: 0.0.0.0
```
4) open the dir where your .yml file config is stored and write the following:

```shell
docker-compose -f docker-compose.yml up -d
```
5) go to the http://localhost:8081/ and you everything should work just fine

to stop the program from running you can just close the terminal or write the following: 

```shell
docker-compose down
```
