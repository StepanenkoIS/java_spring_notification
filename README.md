# java_spring_notification

# Тестовое задание:

Необходимо реализовать API для отправки уведомлений 3мя разными каналами.
1) СМС
2) push
3) e-mail  
   Решение необходимо построить на микросервисной архитектуре на стеке Spring Cloud, используя такие компоненты как Gateway, Spring Eureka,  не нужно реализовывать никаких дополнительных интеграций с сервисами отправки (смс, push, email). в качестве срабатывания отправки достаточно просто написать в лог
1) "sms was sent"
2) "push was sent"
3) "email was sent"

приложения должны запускаться в докере

# Инструкция по запуску
# Создать сеть:
docker network create mynetwork

# Собрать докер образы из каждого пакета
docker build -t eurekaserver .

docker build -t gateway .

docker build -t emailserver .

docker build -t smsserver .

docker build -t pushserver .


# Запустить с подключением к внутренней сети
docker run -d --net=mynetwork -p 8761:8761 --network-alias=eurekaserver eurekaserver

docker run -d --net=mynetwork -p 8282:8282 gateway

docker run -d --net=mynetwork -p 8081:8081 emailserver

docker run -d --net=mynetwork -p 8082:8082 smsserver

docker run -d --net=mynetwork -p 8083:8083 pushserver


# Вход в eurekaserver, где ${ip} - ip компьютера
http://{ip}:8761/


# Отправка сообщений, где ${ip} - ip компьютера
http://${ip}:8282/ServerSmsApplication/sendtest

http://${ip}:8282/ServerEmailApplication/sendtest

http://${ip}:8282/ServerPushApplication/sendtest


# Отправка сообщений с параметрами, где ${ip} - ip компьютера
http://${ip}:8282/ServerSmsApplication/send?to=8(900)000-00&from=SMS&body=textsms

http://${ip}:8282/ServerEmailApplication/send?to=email@mail.ru&from=app@mail.ru&title=Notification&body=emailText

http://${ip}:8282/ServerPushApplication/send?to=is&from=app1&title=Notification&body=pushText&click_action=app1&timeRelSec=30
