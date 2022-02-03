package com.grupo1.lucaticket.ticketpaymentservice.service;

import com.grupo1.lucaticket.ticketpaymentservice.model.PaymentDto;
import com.grupo1.lucaticket.ticketpaymentservice.model.TicketDto;
import com.grupo1.lucaticket.ticketpaymentservice.model.TicketDtoNoId;
import com.grupo1.lucaticket.ticketpaymentservice.model.dto.RequestEventDto;
import com.grupo1.lucaticket.ticketpaymentservice.util.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

	private static final Logger log = LoggerFactory.getLogger(PaymentService.class);
	@Autowired
	private RestTemplate restTemplate;

	public PaymentDto processPayment(String token, PaymentDto request, int id) {
		return PaymentDto.builder().id_user(getTokenId(token)).nombreEvento(getEventDetails(id).getNombreEvento())
				.precioEvento(getEventDetails(id).getPrecioEvento()).fullName(request.getFullName())
				.fechaCaducidad(request.getFechaCaducidad()).numTarjeta(request.getNumTarjeta()).CVV(request.getCVV())
				.build();
	}

	public ResponseEntity<?> pasarelaDePago(PaymentDto paymentDto, String validation) {
		if (validation.equals("OK")) {
			TicketDto ticketDto = TicketDto.builder().id_user(paymentDto.getId_user())
					.nombreEvento(paymentDto.getNombreEvento()).precioEvento(paymentDto.getPrecioEvento())
					.message(validation).build();
			saveTicket(ticketDto);
			TicketDtoNoId respuesta = TicketDtoNoId.builder().nombreEvento(ticketDto.getNombreEvento())
					.precioEvento(ticketDto.getPrecioEvento()).message(ticketDto.getMessage()).build();
			return ResponseEntity.ok(respuesta);
		} else {
			return ResponseEntity.badRequest().body(validation);
		}
	}

	private Long getTokenId(String token) {
		return TokenUtil.getUserIdFromJWT(token);
	}

	private RequestEventDto getEventDetails(int id) {
		return restTemplate.getForObject("http://event/events/buy/" + id, RequestEventDto.class);
	}

	public String requestValidation(PaymentDto dto) {
		return restTemplate.postForObject("http://validation-service/validation", dto, String.class);
	}

	private TicketDto saveTicket(TicketDto ticketDto) {
		return restTemplate.postForObject("http://user/ticket/save", ticketDto, TicketDto.class);
	}

}
