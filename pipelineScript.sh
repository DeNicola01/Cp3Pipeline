node {
  def resourceGroupName = 'rg-devops'
  def resourceGroupLocation = 'brazilsouth'
  def appServicePlanName = 'devopsPlan'
  def appServicePlanTier = 'FREE'
  def webAppName = 'devops-Tein8'
  def webAppRuntime = '"java:17:Java SE:17"'
  def packagePath = 'target/tein8-0.0.1-SNAPSHOT.jar'
  
    stage('Extrair codigo') {
        checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/DeNicola01/Cp3Pipeline.git']]])
        echo "código extraido"
    }
    
    stage('Build') {
        bat 'D:/Fiap/apache-maven-3.8.6/bin/mvn clean package'
    }
  
    stage('Credenciais Azure') {
        echo 'Obtendo credenciais...'
        withCredentials([usernamePassword(credentialsId: 'AzureService', 
        passwordVariable: 'G#ab8@8803',
        usernameVariable: 'rm88803@fiap.com.br')]) {
        echo 'Logando na Azure...'
        bat 'az login -u rm88803@fiap.com.br -p G#ab8@8803'
}

  }

  stage('Criar Infra') {
    echo 'Criando o Grupo de Recursos...'
    bat "az group create --name $resourceGroupName --location $resourceGroupLocation"
    echo 'Criando Plano de ServiÃ§o...'
    bat "az appservice plan create --name $appServicePlanName --resource-group $resourceGroupName --sku $appServicePlanTier"
    echo 'Criando o Web App...'
    bat "az webapp create --name $webAppName --plan $appServicePlanName --resource-group $resourceGroupName --runtime $webAppRuntime"
  }

  stage('Deploy') {
     echo 'Realizando o Deploy na Azure...'
     bat "az webapp deploy --resource-group $resourceGroupName --name $webAppName --src-path $packagePath --type jar"
     echo 'Deploy realizado'
  }
} 