# restservices
sandbox for studying and getting familiar with spring mvc rest and jpa-hibernate


Requirements
-------------
Java 7
Tomcat 7 or any other webserver
Spring 3.2
Eclipse/IntelliJ IDE

Input for the create (PUT)
---------------------------
Sample Json -
 
{  
   "name":"cellphone",
   "barcode":12345,
   "description":"Motorola Moto X Pure Edition 32GB Grey"
}

url - http://localhost:8080/restservices/rest/shop/create

Content Type - application/json

Input for find/create/Query (GET)
-----------------------------------
Accept - application/json

url - http://localhost:8080/restservices/rest/shop/12345
