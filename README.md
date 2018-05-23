# sigevt
Criação de sistema de gerenciamento de eventos utilizando Spring Boot (Inicialmente com Web, Devtools e Thymeleaf)

## pré requisitos

As seguintes ferramentas devem estar instaladas e devidamente configuradas:

### Java 8
### MySQL Server (Versão utilizada 5.6.22)  
### Maven Versão utilizada 3.5.2
    
Clonar o repositório num diretório de sua preferência
```shell
git clone https://github.com/EdilsonDiasAlves/sigevt
```

Acessar a pasta do projeto
```shell
cd sigevt
```

Executar o maven através do comando
```shell
mvn clean install
```

Após a finalização do comando acima, navegar até a pasta onde o pacote foi gerado:
```shell
cd target
```

Executar o comando para subir o projeto
```shell
java -jar sigevt.jar
```

Acessar a página através do caminho http://localhost:3000/cadastrarEvento
