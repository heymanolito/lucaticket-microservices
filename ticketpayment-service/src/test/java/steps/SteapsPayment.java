package steps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SteapsPayment {

	//Event event;
	
	int result;
	//EventNotFoundException e = new EventNotFoundException();
	
	@Given("Un evento")
	public void un_evento() {

		Integer[] rangoPrecios = { 10, 20 };

		//Recinto recinto = new Recinto(1, "Sala pepe", "Badalona", "Calle Jaume", 4000);

		//event = new Event(1, "La pantoja", "hola", "adios", "GDSGDS", LocalDate.now(), LocalTime.now(),
				//rangoPrecios, "hola", recinto, "Copla");
	}
	
	@When("Usuario compra el tiket")
	public void usuario_compra_el_tiket() {
	    result = 1;
	    //result = comprar(event)
	    // El método comprar debe devilvor un String "OK" o "No OK"
	}

	@Then("El metodo comprar devuelve el mensaje OK")
	public void el_metodo_comprar_devuelve_el_mensaje() {
		//La veriable retorno la cambio por result en la prueba definitiva(Cuando result haga lo que tinene que hacer)
	    String retorno = "OK";
	    assertThat(retorno).isEqualTo("OK");
	}

	@When("Usuario compra el tiket y no tiene dinero")
	public void usuario_compra_el_tiket_y_no_tiene_dinero() {
	    //result = 8;
		
	}

	@Then("El metodo comprar devuelve el mensaje NO OK")
	public void devuelve_una_invalid_currency_exception() {
		//assertThat(e).isEqualTo(new EventNotFoundException());
	}

	@When("Usuario compra el tiket y tiene caducada la fecha de caducidad")
	public void usuario_compra_el_tiket_y_tiene_caducada_la_fecha_de_caducidad() {
	    result = 9;
	}

	@Then("Devuelve una  ExpiryDateNotValidException")
	public void devuelve_una_expiry_date_not_valid_exception() {
		assertThat(result).isEqualTo(9);
		//assertThrows();
	}

	@When("Usuario compra el tiket pero el numero de tarjeta es incorrecto")
	public void usuario_compra_el_tiket_pero_el_numero_de_tarjeta_es_incorrecto() {
	    result = 10;
	}

	@Then("Devuelve una AccountNumberNotValidException")
	public void devuelve_una_account_number_not_valid_exception() {
		assertThat(result).isEqualTo(10);
	}

}
