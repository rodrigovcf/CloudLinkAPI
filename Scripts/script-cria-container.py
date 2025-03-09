from azure.storage.blob import BlobServiceClient

# Conectar ao Azurite usando a cadeia de conexão 
connect_str = "DefaultEndpointsProtocol=http;AccountName=devstoreaccount1;AccountKey=Eby8vdM02xNOcqFlqUwJPLlmEtlCDXJ1OUzFT50uSRZ6IFsuFq2UVErCz4I6tq/K1SZFPTOtr/KBHBeksoGMGw==;BlobEndpoint=http://127.0.0.1:10000/devstoreaccount1;QueueEndpoint=http://127.0.0.1:10001/devstoreaccount1;TableEndpoint=http://127.0.0.1:10002/devstoreaccount1;"

# Criar o cliente do serviço Blob
blob_service_client = BlobServiceClient.from_connection_string(connect_str)

# Nome do container que você deseja criar
container_name = "meu-container"

# Criar o container
try:
    container_client = blob_service_client.create_container(container_name)
    print(f"Container '{container_name}' criado com sucesso.")
except Exception as e:
    print(f"Erro ao criar o container: {e}")
