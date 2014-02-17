Projeto: crud-jsf
========================
Author: Adriano Santos Ramos <br>
Tecnologias: CDI, JSF, JPA, EJB, JPA <br>
Sumário: Exemplo de um crud em jsf <br>
Source: http://goo.gl/jwnyKu

Informação
-----------

É um projeto com um crud, projeto Maven 3 com Java EE 7 no JBoss Enterprise Application Platform 6 ou JBoss AS 7.  

Este projeto está configurado para um aplicativo Java EE 7 compatível com JSF 2.0, PrimeFaces, CDI 1.0, EJB 3.1, JPA 2.0 e Bean Validation 1.0. 

Requerimentos
-------------------

Tudo que você precisa para construir este projeto é Java 6.0 (Java SDK 1.7), ou superior, Maven 3.0 ou superior, Banco de dados MySql. 

Este projeto foi é projetado para ser executado com JBoss Enterprise Application Platform 6 ou JBoss AS 7. 

Antes executar o projeto:
- Entre na pasta SQL e execute o script SQL_Inicial.sql em seu mysql.
- Acesse o arquivo crud-jsf-ds.xml no projeto crud-jsf:
	- Altere o usuario e senha para acesso ao banco de dados.

- Verifique o driver do mysql em seu JBoss:
	- Acesse o diretorio: %JBOSS_HOME%\modules\com
	- Verifique se possui as pastas mysql\main (caso não exista crie as pastas)
	- Dentro da pasta %JBOSS_HOME%\modules\com\mysql\main deve existir dois arquivos mysql-connector-java-X.X.XX.jar e module.xml 
	- Caso não exista o arquivo mysql-connector-java-X.X.XX.jar efetue o download do mesmo conforme link a seguir (Versão 5.1.29): http://search.maven.org/remotecontent?filepath=mysql/mysql-connector-java/5.1.29/mysql-connector-java-5.1.29.bundle.jar
	- Caso não exista o arquivo module.xml efetue a criação de um arquivo xml chamado module.xml e adicione o conteudo conforme abaixo:
	```xml
	<?xml version="1.0" encoding="UTF-8"?>

	<module xmlns="urn:jboss:module:1.0" name="com.mysql">
  		<resources>
    		<resource-root path="mysql-connector-java-5.1.29.jar"/>
  		</resources>
  		<dependencies>
    		<module name="javax.api"/>
  		</dependencies>
	</module>
	
- Verifique se o standalone.xml esta com o driver do mysql configurado
	- Acesse o diretório: %JBOSS_HOME%\standalone\configuration
	- Abra o arquivo standalone.xml e localize a tag drivers
	- Dentro desta tag deve existir a declaração do driver do mysql conforme abaixo, caso não exista adicione esta informação.
	```xml
	<driver name="mysql" module="com.mysql">
		<xa-datasource-class>com.mysql.jdbc.jdbc2.optional.MysqlXADataSource</xa-datasource-class>
	</driver>
	

Acesso para a aplicação
---------------------

URL para acesso: <http://localhost:8080/crud-jsf/>
