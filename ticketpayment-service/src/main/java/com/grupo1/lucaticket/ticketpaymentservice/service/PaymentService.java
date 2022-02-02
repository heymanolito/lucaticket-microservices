package com.grupo1.lucaticket.ticketpaymentservice.service;

import com.grupo1.lucaticket.ticketpaymentservice.model.RequestPaymentDto;
import com.grupo1.lucaticket.ticketpaymentservice.model.ResponseTicketDto;
import com.grupo1.lucaticket.ticketpaymentservice.model.dto.RequestEventDto;
import com.grupo1.lucaticket.ticketpaymentservice.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;


    public RequestPaymentDto processPayment (String token, RequestPaymentDto request, int id) {
        return RequestPaymentDto.builder()
                .id_user(getTokenId(token))
                .nombreEvento(getEventDetails(id).getNombreEvento())
                .precioEvento(getEventDetails(id).getPrecioEvento())
                .fullName(request.getFullName())
                .fechaCaducidad(request.getFechaCaducidad())
                .numTarjeta(request.getNumTarjeta())
                .CVV(request.getCVV()).build();
    }

    public ResponseEntity<?> pasarelaDePago(RequestPaymentDto paymentDto, String validation) {
        if( validation.equals("OK")) {
            ResponseTicketDto responseTicketDto = ResponseTicketDto.builder()
                    .nombreEvento(paymentDto.getNombreEvento())
                    .precioEvento(paymentDto.getPrecioEvento())
                    .message(validation)
                    .build();
            return ResponseEntity.ok(saveTicket(responseTicketDto));
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

    public String requestValidation(RequestPaymentDto dto) {
        return restTemplate.postForObject("http://validation-service/validation", dto, String.class);
    }

    private ResponseTicketDto saveTicket(ResponseTicketDto responseTicketDto) {
        return restTemplate.postForObject("http://user/ticket/save", responseTicketDto, ResponseTicketDto.class);
    }


}
