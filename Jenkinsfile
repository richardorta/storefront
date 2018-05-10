pipeline {

    agent {
        label 'linux'
    }
    
    environment {
        GRADLE_HOME = tool('gradle-4.6')
        
    }
    
    stages {
        stage('clean') {
            stes {
                sh '$GRADLE_HOME/bin/gradle --version'
            } 
        }
    }
}
