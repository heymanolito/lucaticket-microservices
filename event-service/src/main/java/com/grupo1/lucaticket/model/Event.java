package com.grupo1.lucaticket.model;

public class Event {

	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")

	@Override
	public String toString() {
		return String.format(
				"Event[id=%s, nombre='%s', descripcionCorta='%s', descripcionExtendida='%s', foto='%s', fechaEvento='%s', fechaEvento='%s',  "
				
				)
				
	}
}
