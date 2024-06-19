# piores-filmes-app
Instruções para Rodar a Aplicação Web Spring Boot Java 17

Este repositório contém uma aplicação web Spring Boot Java 17 que carrega um arquivo CSV e fornece endpoints para obter informações sobre os produtores de prêmios.


Pré-requisitos
JDK 17 instalado e configurado em sua máquina.

Apache Maven para compilar e executar o projeto.

Git (opcional) para clonar este repositório.

Instalação e Execução
Clone este repositório para o seu ambiente local (se você não tiver feito isso ainda):
git clone https://exemplo.com/repo.git

Você pode também baixar ele em Code<> -> Download Zip

Navegue até o diretório do projeto usando comandos do seu sistema operacional:
Ex: Windows
cd nome-do-projeto

Compile o projeto usando o Maven:

mvn clean package


Após compilar, você deve ir ate a pasta raiz do seu computador e va até a pasta Documentos, ex de windows C:\Users\seuUsuario\Documentos e dentro desse diretório, copie o arquivo de carga inicial editando seu nome para data.csv caso ainda não esteja com esse nome.

Após copiar o arquivo data.csv para o diretorio de arquivos, volte ao terminal de seu sistema operacional onde você já está na pasta do projeto e entre na pasta target e execute o seguinte comando:
java -jar piores-filmes-app-0.0.1-SNAPSHOT.jar 


A aplicação estará disponível em http://localhost:8080


Como Usar os Endpoints

http://localhost:8080/premios/intervalos - Endpoint para obter o produtor com maior intervalo entre dois prêmios consecutivos, e o que
obteve dois prêmios mais rápido.

Você pode utilizar um navegador comum para essa chamada
