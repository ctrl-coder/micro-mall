pipeline {
    environment {
        imageName = "micro-mall"
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
//         stage('Build Docker Image') {
//             steps {
//                 dockerImage = docker.build("${imageName}:${env.BUILD_NUMBER}")
//             }
//         }
//         stage('Push docker image') {
//             steps {
//                 echo 'Deploying....'
//             }
//         }
    }
}
