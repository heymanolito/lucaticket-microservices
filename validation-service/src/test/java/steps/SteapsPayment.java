package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.grupo1.lucaticket.validationservice.model.RequestPaymentDto;
import com.grupo1.lucaticket.validationservice.util.UtilRandom;

public class SteapsPayment {

	String result;

	@Given("La compra de un evento")
	public void un_evento() {

		RequestPaymentDto compraEvento = new RequestPaymentDto();
	}

	@When("La validadacion de la compra es correcta")
	public void usuario_compra_el_tiket() {

		result = UtilRandom.validarCompraAux(4);
	}

	@Then("El metodo comprar devuelve el mensaje La transaccion se ha realizado satisfactoriamente")
	public void el_metodo_comprar_devuelve_el_mensaje() {

		assertThat(result).isEqualTo("La transaccion se ha realizado satisfactoriamente");
	}

	@When("La validadacion de la compra es que no tiene saldo sufuciente en la cuenta")
	public void usuario_compra_el_tiket_y_no_tiene_dinero() {

		result = UtilRandom.validarCompraAux(8);
	}

	@Then("El metodo comprar devuelve el mensaje Error: Saldo insuficiente en su cuenta")
	public void devuelve_una_invalid_currency_exception() {
		assertThat(result).isEqualTo("Error: Saldo insuficiente en su cuenta");
	}

	@When("La validadacion de la compra es que tiene caducada la fecha de caducidad")
	public void usuario_compra_el_tiket_y_tiene_caducada_la_fecha_de_caducidad() {
		result = UtilRandom.validarCompraAux(9);
	}

	@Then("El metodo comprar devuelve el mensaje Error: La fecha de caducidad es incorrecta dd\\\\/mm\\\\/aa")
	public void devuelve_una_expiry_date_not_valid_exception() {
		assertThat(result).isEqualTo("Error: La fecha de caducidad es incorrecta (dd/mm/aa)");
	}

	@When("La validadacion de la compra es que tiene el numero de tarjeta es incorrecto")
	public void usuario_compra_el_tiket_pero_el_numero_de_tarjeta_es_incorrecto() {
		result = UtilRandom.validarCompraAux(10);
	}

	@Then("El metodo comprar devuelve el mensaje Error: El numero de cuenta introducido no es valido")
	public void devuelve_una_account_number_not_valid_exception() {
		assertThat(result).isEqualTo("Error: El numero de cuenta introducido no es valido");
	}

}
