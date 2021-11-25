pipeline {
    agent any
    triggers {
        upstream(upstreamProjects: 'Tienda-frontend')
        GenericTrigger(
            genericVariables: [
                [
                    key: 'referencia', 
                    value: '$.ref', 
                    regexpFilter:'', 
                    defaultValue:'x'
                ]
            ],

            causeString: 'Triggered on $ref',
            token: '1234',
            tokenCredentialId: 'webhook-secret',

            printContributedVariables: true,
            printPostContent: true,

            silentResponse: false,

            regexpFilterText: '$referencia',
            regexpFilterExpression: 'refs/heads/develop'
        )
    }
  
    tools {
        maven "maven-first"
    }
    environment {
        BASE_PATH = "/var/jenkins_home/workspace"
        PRAGMA_USER = "Fher"
        PROJECT_ROOT = "Tienda-backend"
        EMAIL_ADDRESS = "arellano.gustavo@gmail.com"
    }
    stages {
        stage('Obten Código Fuente') {
            steps {
                git branch: 'develop',
                    credentialsId: 'fher-github2',
                    url: 'https://github.com/qbits-mx/tienda-backend.git'     
            }
        }
        stage('Compila & Construye') {
            steps {
                sh "mvn -U -Dmaven.test.skip=true package"
            }
        }
        stage('Ejecuta Pruebas Unitarias & jacoco') {
            steps {
                sh "mvn test"
            }
        }
        stage('despliega'){
            steps {
                // forma 2: https://github.com/jenkinsci/ssh-steps-plugin#remote
                sh "cd ${BASE_PATH}/${PROJECT_ROOT}/target && ls -la"
                sshagent(['135e6064-b985-420c-b71c-dc00c127181f']){
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@44.198.66.81 uptime'
                    sh "scp ${BASE_PATH}/${PROJECT_ROOT}/target/tienda-back-1.0-SNAPSHOT.jar ubuntu@44.198.66.81:/home/ubuntu/work/tienda/deploy"
                    sh "ssh -o StrictHostKeyChecking=no -l ubuntu 44.198.66.81 'cd /home/ubuntu/work && ./run_tienda.sh'"
                }
            }
        }

        stage("Corre Escaneo de Sonar") {
            environment {
                scannerHome = tool 'sonar-scanner'
            }
            
            steps {
                withSonarQubeEnv('sonar-scanner') {
                    sh "${scannerHome}/bin/sonar-scanner \
                    -Dsonar.projectKey=${PROJECT_ROOT} \
                    -Dsonar.projectName=${PROJECT_ROOT} \
                    -Dsonar.projectVersion=0.${BUILD_NUMBER} \
                    -Dsonar.sources=${BASE_PATH}/${PROJECT_ROOT}/src/main/java \
                    -Dsonar.test.sources=${BASE_PATH}/${PROJECT_ROOT}/src/test/java \
                    -Dsonar.language=java \
                    -Dsonar.java.binaries=${BASE_PATH}/${PROJECT_ROOT}/target/classes \
                    -Dsonar.java.test.binaries=${BASE_PATH}/${PROJECT_ROOT}/target/test-classes \
                    -Dsonar.junit.reportPaths=${BASE_PATH}/${PROJECT_ROOT}/target/jacoco.exec \
                    -Dsonar.coverage.jacoco.xmlReportPaths=${BASE_PATH}/${PROJECT_ROOT}/target/site/jacoco/jacoco.xml \
                    -Dsonar.java.coveragePlugin=jacoco"
                }
                timeout(time: 2, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: qualityGateValidation(waitForQualityGate())
                }                
            }
            
        }

    }
}

def qualityGateValidation(qg) {
    if(qg.status != 'OK') {
        emailext body: "El código no pasó el Quality Gate de Sonar", subject: "Error Sonar Scan, Quality Gate", to: "${EMAIL_ADDRESS}"
        return true
    }
    emailext body: "El código ha pasado el Quality Gate de sonar exitosamente", subject: "Info -Ejecucion pipeline", to: "${EMAIL_ADDRESS}"
    return false
}
