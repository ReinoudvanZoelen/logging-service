pipeline {
  environment {
    registry = "yoksar/logging-service"
    registryACC = "yoksar/logging-service-acceptance"
    registryCredential = 'dockerhub'
    dockerImage = ''
    gitUrl = 'https://github.com/ReinoudvanZoelen/logging-service.git'
  }
  agent any
    stages {
        stage('Master') {
            when {
                branch 'master'
            }
            stages{
                stage('Cloning Git') {
                    steps {
                        git([url: gitUrl, branch: 'master', credentialsId: 'Github'])
                    }
                }
                stage('Building image') {
                    steps{
                        script {
                        dockerImage = docker.build registry
                        }
                    }
                }
                stage('Deploy Image') {
                    steps{
                            script {
                                docker.withRegistry( '', registryCredential ) {
                                dockerImage.push()
                            }
                        }
                    }
                }
                stage('Remove Unused docker image') {
                    steps{
                        sh "docker rmi $registry"
                    }
                }


                stage("PROD") {
                    steps{
                        node("docker-prod"){
                            git([url: gitUrl, branch: 'master', credentialsId: 'Github'])
                            // sh "docker service rm logging-service_logging"
                            sh "docker stack deploy --with-registry-auth -c docker-compose-production.yml logging-service"
                        }
                    }
                }
            }
        }

        stage('Acceptance') {
            when {
                branch 'acceptance'
            }
            stages{
                stage('Cloning Git') {
                    steps {
                        git([url: gitUrl, branch: 'acceptance', credentialsId: 'Github'])
                    }
                }
                stage('Building image') {
                    steps{
                        script {
                        dockerImage = docker.build registryACC
                        }
                    }
                }
                stage('Deploy Image') {
                    steps{
                            script {
                                docker.withRegistry( '', registryCredential ) {
                                dockerImage.push()
                            }
                        }
                    }
                }
                stage('Remove Unused docker image') {
                    steps{
                        sh "docker rmi $registryACC"
                    }
                }


                stage("ACC") {
                    steps{
                        node("docker-prod"){
                            git([url: gitUrl, branch: 'acceptance', credentialsId: 'Github'])
                            // sh "docker service rm logging-service-acceptance_logging"
                            sh "docker stack deploy --with-registry-auth -c docker-compose-acceptance.yml logging-service-acceptance"
                        }
                    }
                }
            }
        }
    }
}