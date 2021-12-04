echo Starting Camunda boot 
docker pull postgres:latest
docker pull jeanyves7/camundaboot:latest
docker tag jeanyves7/camundaboot camundaworks
docker-compose up
pause
