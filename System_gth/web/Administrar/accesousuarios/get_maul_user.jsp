<jsp:useBean id="empleado_mail" class="Controlador.EmpleadoController" />
<%
    String id_empleado = request.getParameter("id_empleado");
    String correo = empleado_mail.GetMailUsuario(Integer.parseInt(id_empleado));
    out.print(correo);
%>