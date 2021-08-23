pipeline {
    environment {
        imageName = "micro-mall"
        dockerImage = ''
    }
    agent any
    tools {
        maven 'Maven-3.8.2'
    }
    stages {
        stage('Unit test') {
            script {
                echo 'Pulling...' + env.BRANCH_NAME
                def mvnHome = tool 'Maven-3.8.2'
                if (isUnix()) {
                    def targetVersion = getDevVersion()
                    print 'target build version...'
                    print targetVersion
                    sh "mvn -Dintegration-tests.skip=true -Dbuild.number=${targetVersion} clean package"
                    def pom = readMavenPom file: 'pom.xml'
                    // get the current development version
                    developmentArtifactVersion = "${pom.version}-${targetVersion}"
                    print pom.version
                    // execute the unit testing and collect the reports
                    junit '**//*target/surefire-reports/TEST-*.xml'
                    archive 'target*//*.jar'
                } else {
                    bat(/mvn -Dintegration-tests.skip=true clean package/)
                    def pom = readMavenPom file: 'pom.xml'
                    print pom.version
                    junit '**//*target/surefire-reports/TEST-*.xml'
                    archive 'target*//*.jar'
                }
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
