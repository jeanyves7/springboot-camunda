![Java CI with Maven](https://github.com/aravindhrs/camunda-springboot-postgres/workflows/Java%20CI%20with%20Maven/badge.svg) ![CodeQL](https://github.com/aravindhrs/camunda-springboot-postgres/workflows/CodeQL/badge.svg)

# camunda-springboot-postgres
This repository is for camunda springboot postgres integration.

  - Postgres 9 dockerized
  - HikariCP Connection pooling
  - Camunda Rest api enabled
  - Camunda Webapps included
  
### Implementation

- Main Class (Bootstrap):

	```sh
	@SpringBootApplication
	public class Application {
	
	  public static void main(String[] args) {
	    SpringApplication.run(Application.class);
	  }
	
	}
	
	```

### Pre-Requisites

Below softwares need to be installed in the system before running this application.

| Software | Version |
| ------ | ------ |
| Java | 8 |
| Postgres | 9 |
| Maven | 3.6.x |
| Spring Tool Suite | 4 |

### Run this application

- Clone this project into your local machine
    ```sh
    git clone https://github.com/jeanyves7/springboot-camunda.git
    ```
- Run this command from command prompt:
    ```sh
    mvn clean install
    ```
- Import the project as existing maven project

- Before run local 
     ```sh
       change the url database to localhost instead of postgres   
        
- Run as Spring boot application from STS IDE.

- From the browser access the cockpit as:
    ```sh
    http://localhost:9099
    ```
- It will prompt the popup for basic auth since we enabled camunda basic auth. Input the credentials as: 
    ```sh
    demo/demo
    ```
- Camunda rest api will be accessed like:
    ```sh
    http://localhost:9091/engine-rest/engine
    ```
- Camunda rest api authorization details are:
    ```sh
    demo/demo
    ```
    
- Webapps context-path:
	```sh
	/camundapostgres
	```    
