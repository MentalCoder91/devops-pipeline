pipeline{

    agent any
    tools{
        maven 'maven3'
    }
    stages{

        stage('Maven Build'){


            steps{

                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/MentalCoder91/devops-pipeline']])
                sh 'pwd'
                sh "mvn clean install"
            }



        }

        stage('Build Docker Image'){

            steps{

                script{

                    sh 'docker build -t mentalcoder1991/devops:${BUILD_NUMBER} .'
                }

            }


        }

        stage('Push Image to DockerHub'){


            steps{

                script{

                  withCredentials([string(credentialsId: 'dockerHubPwd', variable: 'dockerHubPwd')]) {
                        sh 'docker login -u mentalcoder1991 -p ${dockerHubPwd}'
                    }

                    sh 'docker push mentalcoder1991/devops:${BUILD_NUMBER}'

                }
            }


        }

        stage('Print Workspace Directory') {
            steps {
                sh 'echo $WORKSPACE'
                sh 'cat $HOME/.kube/config'
            }
        }

        stage('Access File in Workspace') {
            steps {
                sh 'ls $WORKSPACE'
                // Or you can directly reference the file
                sh 'cat $WORKSPACE/k8s*.yaml'

            }
        }

        stage('K8s Deploy') {
            steps {
                script {
                    sh "kubectl --kubeconfig=$HOME/.kube/config apply -f $WORKSPACE/k8s*yaml"
                }
            }
        }







    }




}