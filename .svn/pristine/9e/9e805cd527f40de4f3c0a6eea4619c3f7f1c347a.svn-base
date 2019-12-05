<jsp:useBean id="consultaEvento" class="Controlador.EventoController" />
<%
    String empleado = request.getParameter("empleado");
    String evento = request.getParameter("evento");

    String mensaje = consultaEvento.guarda_ganador_eventos(Integer.parseInt(empleado), Integer.parseInt(evento));

%>