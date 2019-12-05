<jsp:useBean id="registra_persona_Actividad" class="Controlador.Evento_ActividadController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%    
    String id_actividad = request.getParameter("id_actividad");
    String id_empleado = request.getParameter("id_empleado");
    id_empleado = id_empleado.replace(" ", "+");
    
    

    String respuesta = registra_persona_Actividad.RegistroAsistenciaActividad(Integer.parseInt(id_empleado), Integer.parseInt(id_actividad));
    if (respuesta.equalsIgnoreCase("Ok")) {
        out.print("Registrado Correctamente");
    } else {
        out.print("Error");
    }
%>