pipeline {
    agent {
        label 'linux'
    }

    environment {
        GRADLE_HOME = tool('gradle-4.6')

    }

    stages {
        stage('clean') {
            steps {
                sh '$GRADLE_HOME/bin/gradle --version'
            }
        }
        stage('build') {
            steps {
                sh '$GRADLE_HOME/bin/gradle build'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew check'
            }
        }
    }
    
    post {
        always {
            junit 'build/test-results/test/**/*.xml'
            deleteDir() /* clean up our workspace */
        }
        success {
            echo 'I succeeeded!'
        }
        unstable {
            echo 'I am unstable :/'
        }
        failure {
            echo 'I failed :('
        }
        changed {
            echo 'Things were different before...'
        }    }
}
