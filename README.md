# Catalog-service
Its a Rest based project by which if user send get request using product id then it get all the details about that product id

The project consist of 3 microservices named as products, prices and e_server.

The microservice e_server is used to register all 3 microservice on eureka server

The products microservice contains all details about a product. It used rest template to fetech data from prices microservice 

The prices microservice contain the detail about product like its price, manufacturing date and its availability status.

The technologies used were spring boot, JPA, H2 database, Maven, Microservices
