#Del 0-7 "OK"
#Del 8-9 "No Ok"
Feature: Comprar entrada

  Background:
    Given La compra de un evento

  Scenario: Comprar entrada
    When La validadacion de la compra es correcta
    Then El metodo comprar devuelve el mensaje La transaccion se ha realizado satisfactoriamente

  Scenario: Comprar entrada
    When La validadacion de la compra es que no tiene saldo sufuciente en la cuenta
    Then El metodo comprar devuelve el mensaje Error: Saldo insuficiente en su cuenta
	
  Scenario: Comprar entrada
    When La validadacion de la compra es que tiene caducada la fecha de caducidad
    Then El metodo comprar devuelve el mensaje Error: La fecha de caducidad es incorrecta dd/mm/aa

  Scenario: Comprar entrada
    When La validadacion de la compra es que tiene el numero de tarjeta es incorrecto
    Then El metodo comprar devuelve el mensaje Error: El numero de cuenta introducido no es valido
    
     #"event" = me pilla el parametro como String y lo quiero Event
     #{Event}
     #<event>

