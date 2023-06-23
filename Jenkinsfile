
pipeline{
    agent any
    tools{
        maven "maven"
    }
    stages{
        stage("Build JAR File"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/D4ig0/Tingeso-Pep-2']])
                dir("acopio-service"){
                        sh "mvn clean install -DskipTests=true"
                }
                dir("config-service"){
                        sh "mvn clean install -DskipTests=true"
                }
                dir("eureka-service"){
                        sh "mvn clean install -DskipTests=true"
                }
                dir("gateway-service"){
                        sh "mvn clean install -DskipTests=true"
                }
                dir("nutricional-service"){
                        sh "mvn clean install -DskipTests=true"
                }
                dir("pago-service"){
                        sh "mvn clean install -DskipTests=true"
                }
                dir("proveedor-service"){
                        sh "mvn clean install -DskipTests=true"
                }
                
            }
        }
        stage("Build Docker Image"){
            steps{
                dir("acopio-service"){
                        sh "docker build -t d4ig0/acopio-service:latest ."
                }
                dir("config-service"){
                        sh "docker build -t d4ig0/config-service:latest ."
                }
                dir("eureka-service"){
                        sh "docker build -t d4ig0/eureka-service:latest ."
                }
                dir("gateway-service"){
                        sh "docker build -t d4ig0/gateway-service:latest ."
                }
                dir("nutricional-service"){
                        sh "docker build -t d4ig0/nutricional-service:latest ."
                }
                dir("pago-service"){
                        sh "docker build -t d4ig0/pago-service:latest ."
                }
                dir("proveedor-service"){
                        sh "docker build -t d4ig0/proveedor-service:latest ."
                }
            }
        }
        stage("Push Docker Image"){
            steps{
                withCredentials([string(credentialsId: 'dckrhubpassword', variable: 'dckpass')]){
                        sh "docker login -u d4ig0 -p ${dckpass}"
                        }
                dir("acopio-service"){
                        sh "docker push d4ig0/acopio-service"
                }
                dir("config-service"){
                         sh "docker push d4ig0/config-service"
                }
                dir("eureka-service"){
                        sh "docker push d4ig0/eureka-service"
                }
                dir("gateway-service"){
                        sh "docker push d4ig0/gateway-service"
                }
                dir("nutricional-service"){
                        sh "docker push d4ig0/nutricional-service"
                }
                dir("pago-service"){
                        sh "docker push d4ig0/pago-service"
                }
                dir("proveedor-service"){
                        sh "docker push d4ig0/proveedor-service"
                }
            }
        }
    }
    post{
        always{
            dir("Tingeso"){
                sh "docker logout"
            }
        }
    }
}
