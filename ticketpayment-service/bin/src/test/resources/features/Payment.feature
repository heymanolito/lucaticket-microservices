#Del 0-7 "OK"
#Del 8-9 "No Ok"
Feature: Comprar entrada

  Background: 
    Given Un evento

  Scenario: Comprar entrada
    When Usuario compra el tiket
    Then El metodo comprar devuelve el mensaje OK

  Scenario: Comprar entrada
    When Usuario compra el tiket y no tiene dinero
    Then El metodo comprar devuelve el mensaje NO OK
		#Then Devuelve una InvalidCurrencyException
  
  Scenario: Comprar entrada
    When Usuario compra el tiket y tiene caducada la fecha de caducidad
    Then Devuelve una  ExpiryDateNotValidException

  Scenario: Comprar entrada
    When Usuario compra el tiket pero el numero de tarjeta es incorrecto
    Then Devuelve una AccountNumberNotValidException
    
     #"event" = me pilla el parametro como String y lo quiero Event
     #{Event}
     #<event>

