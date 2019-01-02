pipeline {
    agent {
        kubernetes {
            label 'search-app-build'
            yamlFile 'ci/pipeline/pod.yml'
        }
    }
    stages {
        stage("build") {
            parallel {
                stage("Linux") {
                    steps {
                        container("rust") {
                            sh "cargo build --release"
                        }
                    }
                }
                stage("Docker image") {
                    steps {
                        container("dind") {
                            sh "docker build ."
                        }
                    }
                }
            }
        }
    }
}