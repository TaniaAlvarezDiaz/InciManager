#language: es
Característica: Enviar una incidencia
	Como Agente 
	Quiero enviar una incidencia
	Para que el personal de gestion de incidencias la trate
	Escenario: Agente con sesion iniciada y en pantalla de envio de incidencia
		Dado una incidencia con nombre "Incendio"
		Y descripcion "Incendio en la calle Uria de Oviedo"
		Y etiquetas "urgente;incendio"
		Y propiedades "temperatura:35ºC"
		Cuando rellene el formulario y haga click en el boton "Enviar"
		Entonces se enviara la incidencia y aparece la pantalla informativa indicando que se ha enviado correctamente