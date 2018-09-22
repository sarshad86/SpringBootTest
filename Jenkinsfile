pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /d/m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Verify') {
            steps {
                sh 'mvn Verify'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deliver') {
                steps {
                    /bin/sh './jenkins/scripts/deliver.sh'
                }
        }
    }
}