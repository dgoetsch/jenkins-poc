pipeline {
    agent any
    stages {
        stage("Build release") {
            steps {
                sh "cargo build --release"
            }
        }
    }
}