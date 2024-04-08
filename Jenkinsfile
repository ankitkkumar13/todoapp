pipeline {
    agent any
      tools{
          maven 'Default'
          jdk   'Default'
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
