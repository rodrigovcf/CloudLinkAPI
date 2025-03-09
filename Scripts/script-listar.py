from azure.storage.blob import BlobServiceClient

# Conectar ao Azurite
connect_str = "DefaultEndpointsProtocol=http;AccountName=devstoreaccount1;AccountKey=Eby8vdM02xNOcqFlqUwJPLlmEtlCDXJ1OUzFT50uSRZ6IFsuFq2UVErCz4I6tq/K1SZFPTOtr/KBHBeksoGMGw==;BlobEndpoint=http://127.0.0.1:10000/devstoreaccount1;"

# Criar o cliente do serviço Blob
blob_service_client = BlobServiceClient.from_connection_string(connect_str)

# Nome do container
container_name = "meu-container"

# Criar o cliente do container
container_client = blob_service_client.get_container_client(container_name)

# Listar os blobs dentro do container
try:
    print(f"Blobs em '{container_name}':")
    blobs = container_client.list_blobs()
    for blob in blobs:
        print(blob.name)
except Exception as e:
    print(f"Erro ao listar os blobs: {e}")
