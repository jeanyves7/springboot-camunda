![Java CI with Maven](https://github.com/aravindhrs/camunda-springboot-postgres/workflows/Java%20CI%20with%20Maven/badge.svg) ![CodeQL](https://github.com/aravindhrs/camunda-springboot-postgres/workflows/CodeQL/badge.svg)

### Run this application
- Pleasenote that the login credentials are the following: Username:admin Password:admin
- You can access the deployed camunda-boot app via this URL
   ```sh
    https://camunda-boot-poc.herokuapp.com/index.html
    ```

- Clone this project into your local machine
    ```sh
    git clone https://github.com/jeanyves7/springboot-camunda.git
    ```

- Navigate to the folder containing the cloned folder
- You can simply double-click on the script file name "script.bat" to do the following steps 
automatically:
    -  Get the postgres image from dockerHub
          ````sh
          docker pull postgres:latest
         ````
    -  Get the springboot image from dockerHub
        ````sh
        docker pull jeanyves7/camundaboot:latest
       ````
     - Rename the pulled image 
        ````sh
         docker tag jeanyves7/camundaboot camundaworks
        ````
   
    - Running the springboot and postgres in a container   
        ````sh
        docker-compose up
       ````


- Or run local (not recommended)
     ```sh
       make sure you have postgresql database running  and configured from init.sql
      
 - Do a mvn clean install
 
- Run as Spring boot application from STS IDE.
