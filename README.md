# CloudLinkAPI

## Descrição
Este projeto é uma API desenvolvida em **Spring Boot** para permitir o upload de arquivos JSON e armazená-los no **Azure Blob Storage** utilizando o **Azurite** como ambiente de testes local.

## Estrutura do Projeto
O projeto segue a seguinte estrutura:

```
CloudLinkAPI
│── src/main/java/com/CloudLinkAPI
│   │── CloudLinkApiApplication.java
│   │── controller/
│   │   ├── FileUploadController.java
│   │── services/
│   │   ├── AzureBlobStorageService.java
│   │── config/
│   │   ├── AzureStorageProperties.java
│── src/main/resources
│   │── application.properties
│── scripts/
│   │── create_container.py
│   │── list_containers.py
│── Dockerfile
│── docker-compose.yml
│── build.gradle
│── README.md
│── settings.gradle
```

## Tecnologias Utilizadas
- **Java 21**
- **Spring Boot**
- **Gradle**
- **Docker**
- **Azurite (Emulador do Azure Blob Storage)**
- **Python (para automação de containers no Azurite)**

## Configuração do Ambiente

### 1. Instalar Dependências
Certifique-se de ter os seguintes softwares instalados:
- **JDK 21**
- **Docker e Docker Compose**
- **Python 3** (caso utilize os scripts auxiliares)

### 2. Criar o Arquivo `.env` (Opcional)
Caso necessário, crie um arquivo `.env` na raiz do projeto para configurar variáveis de ambiente.

### 3. Subir os Containers
Para subir os serviços da API e do Azurite, execute:

```sh
docker-compose up -d
```

Isso iniciará:
- O container do **Azurite** (`azurite`)
- O container da **CloudLinkAPI** (`cloudlink-api`)

### 4. Criar o Container no Azurite
Para criar um container chamado **meu-container**, execute:

```sh
python scripts/create_container.py
```

### 5. Listar Containers Existentes no Azurite
Para verificar se o container foi criado corretamente, execute:

```sh
python scripts/list_containers.py
```

### 6. Testar a API
Após subir os serviços, a API estará rodando na porta `9090`. Para testar o endpoint de upload, use o **Postman** ou `curl`:

```sh
curl -X POST http://localhost:9090/files/upload -F "file=@seuarquivo.json"
```
Para testar o endpoint de listar blobs, use o **Postman** ou `curl`:

```sh
curl -X POST http://localhost:9090/files/list 
```

## Parando e Removendo os Containers
Se precisar parar os serviços:

```sh
docker-compose down
```

Para remover os containers e reconstruí-los:

```sh
docker-compose down && docker-compose up --build -d
```

## Contribuição
1. Faça um **fork** do projeto.
2. Crie uma **branch** para sua funcionalidade: `git checkout -b minha-feature`.
3. **Commit** suas mudanças: `git commit -m "Adiciona nova funcionalidade"`.
4. Faça um **push** da branch: `git push origin minha-feature`.
5. Abra um **Pull Request**.

---
**Desenvolvido por Rodrigão 🚀**
