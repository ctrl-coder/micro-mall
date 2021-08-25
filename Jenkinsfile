pipeline {
    environment {
        registry = "wenyuntiandaydayup/micro-mall"
        registryCredential = 'docker-hub-credentials'
        dockerImage = ''
    }
    agent any
    tools {
        maven 'Maven 3.8.2'
        jdk 'jdk8'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        stage('Build Project') {
            steps {
                sh "mvn -B -DskipTests clean package"
            }
        }
        stage('Build And Publish Project Image') {
            steps {
                script {
                    dockerImage = docker.build registry+":$BUILD_NUMBER"
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Cleaning up') {
            steps {
                sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }
    }
}
