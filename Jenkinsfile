pipeline {
    agent {
        kubernetes {
            label 'declarative'
            containerTemplate {
                name 'search-app-build'
                image 'rust:1.31.1-slim'
                ttyEnabled true
                command 'cat'
            }
        }
    }
    stages {
        stage("Build release") {
            steps {
                sh "cargo build --release"
            }
        }
    }
}