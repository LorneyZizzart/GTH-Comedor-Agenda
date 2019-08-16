<jsp:useBean id="_opcionesSaveDelete" class="Controlador.Usuario_opcionController" />
<%
    String opcion = request.getParameter("opcion");
    String user = request.getParameter("user");
    String accion = request.getParameter("accion");
    
    String resultado = "";
    
    if (accion.equalsIgnoreCase("1")) {
        //Añadir
        resultado = _opcionesSaveDelete.CreateUsuario_opcion(user, opcion);
    } else if (accion.equalsIgnoreCase("2")) {
        resultado = _opcionesSaveDelete.DeleteUsuario_opcion(user, opcion);
    } else {
        resultado = "No se realizo ninguna accion.";
    }
    out.print(resultado);
    
%>

