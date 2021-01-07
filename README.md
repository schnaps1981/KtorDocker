# KtorDocker

https://ktor.io/docs/docker.html#pushing-docker-image


для развертывания в Google Cloud Run необходимо руководстоваться документами
https://cloud.google.com/container-registry/docs/pushing-and-pulling

для авторизации в реестре
https://cloud.google.com/container-registry/docs/advanced-authentication#json-key


#Сборка и деплой
1. gradlew build

2. docker build -t my-application .

3. docker tag my-application gcr.io/test123-1fa0a/ktor-test:1.0.0

4. docker push gcr.io/test123-1fa0a/ktor-test:1.0.1
