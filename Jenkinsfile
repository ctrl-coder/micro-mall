pipeline {
    environment {
        imagename = "micro-mall"
        dockerImage = ''
    }
    agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11'
            args '-v /root/.m2:/root/.m2'
        }
    }

    stages {
        stage('Build Project') {
            steps {
                sh "mvn test"
            }
        }
        stage('Build Project') {
            steps {
                sh "mvn -B -DskipTests clean package"
            }
        }
        stage('Build Docker Image') {
            steps {
                dockerImage = docker.build("${imageName}:${env.BUILD_NUMBER}")
            }
        }
        stage('Push docker image') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
