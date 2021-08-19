pipeline {
    def mvnHome = tool 'maven-3.8.2'
    def dockerImage
    def imageName = "micro-mall"

    agent { dockerfile true }

    stages {
        stage('Build Project') {
            sh "'${mvnHome}/bin/mvn' test"
        }
        stage('Build Project') {
            sh "'${mvnHome}/bin/mvn' clean install"
        }
        stage('Build Docker Image') {
          dockerImage = docker.build("${imageName}:${env.BUILD_NUMBER}")
        }
        stage('Push docker image') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
