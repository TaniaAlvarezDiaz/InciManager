#language: es
Característica: Iniciar sesion 
	Como Agente 
	Quiero iniciar sesion
	Para enviar una incidencia
Escenario: Pantalla de Login de la aplicacion
	Dado el agente con username "09847581T"
	Y contraseña "123456789"
	Y tipo "Person"
	Cuando rellene el formulario de login y haga click en el boton "Enviar"
	Entonces se iniciara sesión y se mostrará una pantalla informativa