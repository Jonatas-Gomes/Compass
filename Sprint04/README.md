
ENDPOINTS PARTIDO: 

POST PARTIDO JSON EXEMPLO

localhost:8080/politics/parties/

{
    "name": "PARTIDO VERDE",
    "sigla": "PV",
    "ideology": "CENTRO",
    "dateFoundation": "12/04/1989"

}

DELETE localhost:8080/politics/parties/{id}
PUT localhost:8080/politics/parties/{id}
	JSON EXEMPLO: 
{	

    "name": "PARTIDO VERDE",
    "sigla": "PV",
    "ideology": "CENTRO",
    "dateFoundation": "12/04/1989"

}

GET  localhost:8080/politics/parties/
GET  localhost:8080/politics/parties/{id}

GET localhost:8080/politics/parties/1/affiliates   - lista os afiliados do partido.


-----------------------------------------------------------------------------------------------------------------------------------------------
AFILIADO ENDPOINTS
GET localhost:8080/politics/affiliates/
GET localhost:8080/politics/affiliates/{id}

POST localhost:8080/politics/affiliates/
JSON EXAMPLE:
{
    "name":"FERNADO HENRIQUE" ,
    "politicalOffice": "PRESIDENTE",
    "birthDate": "12/02/1990",
    "gender": "MASCULINO"
}

PUT  localhost:8080/politics/affiliates/
JSON EXAMPLE: 
{
    "name":"BARACK OBAMA" ,
    "politicalOffice": "PRESIDENTE",
    "birthDate": "12/02/1990",
    "gender": "MASCULINO"
}

PUT localhost:8080/politics/affiliates/parties - CRIA ASSOCIAÇÃO
JSON EXAMPLE

{
    "idAffiliated": 2,
    "idParty": 1
}

DELETE localhost:8080/politics/affiliates/{id}/parties/{id}  DELETA ASSOCIAÇÃO

id do afiliado e do partido respectivamente.

