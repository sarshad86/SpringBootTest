pipeline {

    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Verify') {
            steps {
                sh 'mvn verify'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('build docker image') {
                    steps {
                        dir('spring-boot-pipeline'){
                            sh 'mvn docker:build'
                        }
                       }
          }

    }
}


