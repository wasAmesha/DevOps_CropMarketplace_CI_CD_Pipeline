pipeline {
    agent any

    triggers {
        githubPush()
    }

    environment {
        REPO_URL = 'https://github.com/wasAmesha/DevOps_CropMarketplace_CI_CD_Pipeline'
        BRANCH = 'main'
        DOCKER_REGISTRY = 'ameshawas'
        APP_NAME = 'CROPXCHANGE'
        PORT = '3000'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: "${BRANCH}", url: "${REPO_URL}"
            }
        }

        stage('Build Docker Images') {
            steps {
                script {
                    bat 'docker-compose build'
                }
            }
        }

        stage('Push Docker Images') {
            steps {
                script {
                    bat 'docker-compose push'
                }
            }
        }

        stage('Deploy Application') {
            steps {
                script {
                    bat 'docker-compose down'
                    bat 'docker-compose up -d'
                }
            }
        }
    }
}