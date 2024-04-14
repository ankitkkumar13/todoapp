pipeline {
    agent any
      tools{
          maven 'Maven 3.2'
          jdk   'Jdk 1.8'
      }
    stages {
        stage('Checkout') {
            steps {
                script {
                    checkout scm
                }
            }
        }

        stage('Build and Test') {
            steps {
                script {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh 'mvn clean install'
                    sh 'java -jar app.jar'
                }
            }
        }
    }
}
