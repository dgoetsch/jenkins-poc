pipeline {
    agent {
        kubernetes {
            label 'declarative'
            containerTemplate {
                name 'search-app-build'
                image 'alpine:latest'
                ttyEnabled true
                command 'cat'
            }
        }
    }
    stages {
        stage("Build release") {
            steps {
                echo "hello world"
            }
        }
    }
}