# 01. Run on IntelliJ
## 01-01. Configure MySQL
1. Create a database in your MySQL instance.
- docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password -e TZ=Asia/Seoul --name mysql mysql:5.7 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
- docker exec -it mysql bash
- mysql -u root -p
- create database tododb;

## 01-02. Build and run On IntelliJ
01. JVM Options: -server -Xmx1g -Xms1g -Dspring.profiles.active=local
02. Environment Variables: MYSQL_URL=jdbc:mysql://localhost:3306/tododb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8;MYSQL_USERNAME=root;MYSQL_PASSWORD=password
03. Start TodoDemoApplication
04. Open a web browser to http://localhost:8080

As you add and update tasks in the app you can verify the changes in the database through the MySQL console using simple statements like 
`select * from todo_item`.

# 02. Run on Local Container
## 02-01. Ref. 01-01 Configure MySQL
## 02-02. Run Container
01. docker build -t todo:1 .
02. docker run -d -p 8888:8080 --link mysql -e JAVA_OPTS='-server -Xmx1g -Xms1g -Dspring.profiles.active=local' -e MYSQL_URL="jdbc:mysql://mysql:3306/tododb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8" -e MYSQL_USERNAME=root -e MYSQL_PASSWORD=password --name todo todo:1
03. Open a web browser to http://localhost:8888

# 03. Run on Local Kubernetes
01. PreCondition : Kubernetes on DockerDesktop
02. docker build -t {YOUR DOCKERHUB ACCOUNT}/todo:1 .
03. docker push {YOUR DOCKERHUB ACCOUNT}/todo:1
04. kubectl create secret docker-registry regcred --docker-server=https://index.docker.io/v1/ --docker-username={Your Dockerhub username} --docker-password={Your DockerHub PaToken} --docker-email={Your DockerHub Email}
05. kubectl apply -f manifests/k8s/01-todo-config.yml
06. kubectl apply -f manifests/k8s/01-todo-mysql-local.yml
07. kubectl exec -it mysql-0 bash
  - mysql -u root -p
  - create database tododb;
08. kubectl apply -f manifests/k8s/02-todo-deployment.yml
09. kubectl apply -f manifests/k8s/03-todo-service.yml
10. Open a web browser to http://localhost:8000
