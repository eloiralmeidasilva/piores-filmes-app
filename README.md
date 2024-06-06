# piores-filmes-app
Instruções para Rodar a Aplicação Web Spring Boot Java 17 e os Testes de Integração

Este repositório contém uma aplicação web Spring Boot Java 17 que carrega um arquivo CSV e fornece endpoints para obter informações sobre os produtores de prêmios. Além disso, inclui testes de integração para garantir o funcionamento correto dos endpoints.


Pré-requisitos
JDK 17 instalado e configurado em sua máquina.
Apache Maven para compilar e executar o projeto.
Git (opcional) para clonar este repositório.

Instalação e Execução
Clone este repositório para o seu ambiente local (se você não tiver feito isso ainda):
git clone https://exemplo.com/repo.git

Navegue até o diretório do projeto:
cd nome-do-projeto

Compile o projeto usando o Maven:
mvn clean package


Após compilar, você deve criar um diretório C:\arquivos\premios se estiver usando sistema operacional Windows ou /arquivos/premios caso esteja utilizando sistema operacional Linux
Então copie o arquivo de carga inicial editando seu nome para data.csv caso ainda não esteja com esse nome.


Após a compilação bem-sucedida e copiar o arquivo data.csv para o diretorio de arquivos, você pode executar a aplicação usando o Maven:
mvn spring-boot:run

A aplicação estará disponível em http://localhost:8080


Testes de Integração

Os testes de integração estão localizados no diretório src/test/java. Eles podem ser executados usando o Maven:
mvn test



Como Usar os Endpoints

/premios/intervalos Endpoint para obter o produtor com maior intervalo entre dois prêmios consecutivos, e o que
obteve dois prêmios mais rápido.

Você pode utilizar um navegador comum para essa chamada
