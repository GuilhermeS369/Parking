# Parking

## O Projeto
Esse é um projeto Back-end (Webservices, JPA+Hibernate) onde você tem um sistema que registra carros em um estacionamento


## 📋 Pré-requsitos

### Instalar o PostgresSQL

- https://www.enterprisedb.com/postgresql-tutorial-resources-training?uuid=db55e32d-e9f0-4d7c-9aef-b17d01210704&campaignId=7012J000001NhszQAC

### Java Zulu: 

- https://cdn.azul.com/zulu/bin/zulu18.32.11-ca-jdk18.0.2-win_x64.msi

## 🔧 Instruções 

### Instalar o PostgresSQL

Baixar e realizar a instalação colocando a senha Master como "36423537"

### Instalar o Zulu

Baixar e realiza a instalação marcando a opção JAVA_HOME para instalação.

Verificar se foi registrando a variavel de ambiente, caso contrario registrar.

### Package

Baixar o App: [https://drive.google.com/file/d/15ArxFHobg9o-XjGbST7AnHAifc6co6zS/view?usp=sharing](https://drive.google.com/file/d/1Qg0REoFFbwfd5MYj-aka7nkXh9T8L_r0/view?usp=share_link)

Alocar os arquivos em questão e abrir o Executavel.bat.

## ⚙️ Usabilidade (Requisições) 

`GET` Parking

```yaml

Buscar todos:
localhost:8080/parking
```
```yaml
Buscar pelo ID:
localhost:8080/parking/{ID}
Exemplo:
localhost:8080/parking/e12a6d64896f424bad5ba44dcb9e6e4e
```
___________________________________________________________________________________________________________________

`POST` Parking Entry

```yaml
Registro de entrada de um veiculo
localhost:8080/parking

Enviar no Body em formato JSON:
{

  "color": "string",
  "license": "string",
  "model": "string",
  "state": "string"

}
```
___________________________________________________________________________________________________________________

`POST` Parking Exit

```yaml
Registro de saida de um veiculo
localhost:8080/parking/{ID}

Exemplo:
localhost:8080/parking/e12a6d64896f424bad5ba44dcb9e6e4e


```
____________________________________________________________________________________________________________________

`PUT` Parking

```yaml
Alterar um ticket
localhost:8080/parking/{ID}
Exemplo:
localhost:8080/parking/e12a6d64896f424bad5ba44dcb9e6e4e

Enviar no Body em formato JSON:
{
  "color": "string",
  "license": "string",
  "model": "string",
  "state": "string"
}
```
____________________________________________________________________________________________________________________

`DELETE` Parking

```yaml
localhost:8080/parking/{ID}
Exemplo:
localhost:8080/parking/e12a6d64896f424bad5ba44dcb9e6e4e
```
____________________________________________________________________________________________________________________

## 🛠️ Construído com

* [Intellij](https://www.jetbrains.com/pt-br/idea/) - IDE
* [SpringBoot](https://spring.io/) - Framework principal
* [Maven](https://maven.apache.org/) - Gerente de Dependência
* [PostgreSQL](https://www.postgresql.org/about/) - Banco de dados


## 🎁 Expressões de gratidão

* Gostaria de agradecer a Dio e seus professores incriveis por oferecer um curso que trás além de conteúdo super atualizado uma formula de ensino que já nos apresenta às boas práticas do desenvolvimento de software, sem falar na excelente didática.
 

## 📄 Licença

The scripts and documentation in this project are released under the [MIT License](license)
