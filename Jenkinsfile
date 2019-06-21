pipeline {

    agent

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
                    sh './jenkins/scripts/deliver.sh'
                }
        }
    }
}


