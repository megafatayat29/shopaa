ParkirAJA Boot
---------------------

* Introduction
* Requirements
* Installation
* Configuration
* Maintainers

INTRODUCTION
------------

Shopaa-boot is an e-commerce application which is a product of the start-up Shopaa Group.
In this application you can register your own store to start selling on Shopaa e-commerce.
To register a store on Shopaa-boot you need to prepare several registration files,
there are: SIUP No, Store Name, Store Address, Telephone Number, and NPWP.
You can register the products you sell in your store, the data needed are: Product Name, 
Description, Price, and Stock.


REQUIREMENTS
------------

This module requires the following dependencies library:

* Spring Boot Starter Data JPA
* Spring Boot Starter Web
* PostgreSQL
* Spring Boot Starter Test

INSTALLATION
------------

* You need to mvn clean install to load all the requirement dependencies library from maven central.
* You need to compile this application from .java to .jar.
* You can test the REST API from this application with POSTMAN.

CONFIGURATION
-------------

* In this REST API, we provide several path with 4 types of HTTP Request.



# Shoppaa

Shopaa is a study case of developing REST API using Springboot

## Prerequisites

* [Oracle JDK 1.8](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
* [Maven](https://maven.apache.org/)
* [PostgreSQL](https://www.postgresql.org/)

## Installation

Use the package manager [maven](https://maven.apache.org/) to install and build Shopaa app.

```bash
mvn clean install
```

running apps

```bash
java -jar target/shopee-boot
```

## API

####Store
1. GET
* Get Store By Id 

``GET: http://localhost:8081/store/{id}``

  => This API returns entity Store with the given String of id from PathVariable.

* Get All Stores 

``GET: http://localhost:8081/stores``

  => This API returns a number of Store with feature pagination, so it's need RequestParam page and size.

2. POST
* Create Store

``POST: http://localhost:8081/store``

  => This API returns the Store entity that was created. Need RequestBody of Store without id.

####
Request body:

```json
{
  "name": "Toko 256 Pagi",
  "address": "Cimahi",
  "phone": "0855454565567",
  "siup": "SIUP-682752678921897",
  "npwp": "1999087965467"
}
```

3. DELETE
* Delete Store 

``DELETE: http://localhost:8081/store?id=value``

  => This API returns void, and need RequestParam String id of Store you want to delete.

4. PUT
* Update Store 

``PUT: http://localhost:8081/store``

  => This API returns the Store entity that was updated. Need RequestBody of Store with id.

####
Request body:

```json
{
  "id": "8a8ab2a07c087bbc017c0884753a0004",
  "name": "Toko Kaya Raya",
  "address": "Bogor",
  "phone": "0855454565567",
  "siup": "SIUP-682752678921897",
  "npwp": "1999087965467"
}
```

####Product
1. GET
* Get Product By Id

``GET: http://localhost:8081/product/{id}``

  => This API returns entity Product with the given String of id from PathVariable.

* Get All Products 

``GET: http://localhost:8081/products``

  => This API returns a number of Product with feature pagination, so it's need RequestParam page and size.

* Get All Products By Name Is Containing And Price Between 

``GET: http://localhost:8081/product/search``

  => This API returns a number of Product which name product is containing some words and price is between
  certain range, with feature pagination, so it's need RequestParam page and size.

2. POST
* Create Product 

``POST: http://localhost:8081/product``

  => This API returns the Product entity that was created. Need RequestBody of Product without id.

####
Request body:

```json
{
  "name": "Lemari Baju",
  "description": "Untuk menyimpan naju",
  "price": 2500000,
  "stock": 19,
  "store_id": "8a8ab2a07c087bbc017c0883ec370002"
}
```

* Create Products 

``POST: http://localhost:8081/products``

  => This API returns List of Products entity that was created. Need RequestBody of List of Product without id.

####
Request body:

```json
[
  {
    "name": "Meja Belajar",
    "description": "Meja untuk belajar",
    "price": 250000,
    "stock": 20,
    "storeId": "8a8ab2a07c087bbc017c0883ec370002"
  },
  {
    "name": "Spring Bed",
    "description": "Untuk tidur",
    "price": 1500000,
    "stock": 17,
    "storeId": "8a8ab2a07c087bbc017c0883ec370002"
  }
]
```

3. DELETE
* Delete Product

``DELETE: http://localhost:8081/product?id=value``

  => This API returns void, and need RequestParam String id of Product you want to delete.

4. PUT
* Update Product (/product)

``PUT: http://localhost:8081/product``

  => This API returns the Product entity that was updated. Need RequestBody of Store with id.

####
Request body:

```json
{
  "id": "8a8ab2a07c087bbc017c088798fa000a",
  "name": "Lemari Baju",
  "description": "Untuk menyimpan baju",
  "price": 2500000,
  "stock": 19,
  "storeId": "8a8ab2a07c087bbc017c0883ec370002"
}
```


####Customer
1. GET
* Get Customer By Id

``GET: http://localhost:8081/customer/{id}``

=> This API returns entity Customer with the given String of id from PathVariable.

*Get Customer By Criteria

``GET: http://localhost:8081/customer``

=> This API returns a number of Customer entity with the given criteria search.

2. POST
* Create Customer

``POST: http://localhost:8081/customer``

=> This API returns the Customer entity that was created. Need RequestBody of Customer without id.

####
Request body:

```json
{
  "completeName": "Dewi Hajar",
  "username": "dewi",
  "birthDate": "2000-09-04",
  "phone": "08563554678",
  "email": "dewihajar@gmail.com",
  "gender": "F"
}
```


3. PUT
* Update Customer

``PUT: http://localhost:8081/customer``

=> This API returns the Customer entity that was updated. Need RequestBody of Customer with id.

####
Request body:

```json
{
  "id": "8a8ab2a07c0df420017c0df78e6f0000",
  "completeName": "Auliya Rini",
  "username": "auliyarini",
  "birthDate": "1993-09-04",
  "phone": "08563554678",
  "email": "auliyarini@gmail.com",
  "gender": "F"
}
```

## Support

Further information email me : [megafatayat9@gmail.com]()

## License

[Apache Software Foundation](https://www.apache.org/licenses/LICENSE-2.0)