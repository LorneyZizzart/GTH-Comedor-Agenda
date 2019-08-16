<%@page import="Entidad.Usuario"%>
<jsp:useBean id="_usuario" class="Controlador.UsuarioController" />
<%
    Usuario usuario = new Usuario();
    Usuario usuarioObtenido = new Usuario();
    String opcion = request.getParameter("editOpcion");
    String resultado = null;
    
    usuario.setUser_id(Integer.parseInt(request.getParameter("id")));
    usuarioObtenido = _usuario.GetDatosParaActualizarByUser_id(Integer.parseInt(request.getParameter("id")));
    
    if("editUser".equalsIgnoreCase(opcion)){
        usuario.setUsuario(request.getParameter("usuario"));
        usuario.setPerfil(request.getParameter("perfil").toLowerCase());
        usuario.setEmail(request.getParameter("email").trim());
        int estado = 0;        
        try {
            if (request.getParameter("estado").equalsIgnoreCase("on")) {
                estado = 1;
            }
        } catch (Exception e) {
            estado = 0;
        }
        usuario.setEstado(estado);
        if(usuarioObtenido.getEmail().equalsIgnoreCase(usuario.getEmail())){
             resultado = _usuario.UpdateUserDatosPersonales(usuario);
        }else{
            int validaCorreo = _usuario.validaCorreo(usuario.getEmail());
            if (validaCorreo > 0) 
               resultado = "emailExistente";            
            else 
               resultado = _usuario.UpdateUserDatosPersonales(usuario);
        }
        
    }else if("editPassword".equalsIgnoreCase(opcion)){
         usuario.setContrasena(request.getParameter("contrasena"));
         resultado = _usuario.UpdatePassword(usuario);
    }else if("registerUser".equalsIgnoreCase(opcion)){
        usuario.setEmpleado_id(Integer.parseInt(request.getParameter("idEmpleado")));
        usuario.setUsuario(request.getParameter("usuario"));
        usuario.setPerfil(request.getParameter("perfil").toLowerCase());
        usuario.setEmail(request.getParameter("email").trim());
        usuario.setContrasena(request.getParameter("contrasena"));
        int estado = 0;        
        try {
            if (request.getParameter("estado").equalsIgnoreCase("on")) {
                estado = 1;
            }
        } catch (Exception e) {
            estado = 0;
        }
        usuario.setEstado(estado);
        if(_usuario.validaCorreo(usuario.getEmail())==0)
            resultado = _usuario.CreateUsuario(usuario);
        else
            resultado = "emailExistente";
    }else{
        
    }   

    if(resultado.equalsIgnoreCase("Ok")){
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
 <script type="text/javascript">
    $(document).ready(function () {
        $("#mensaje").hide(3000, function () {
            location.reload();
        });
        $("form")[0].reset();
    });
</script>
<%
    } else if(resultado.equalsIgnoreCase("emailExistente")){
 %>
            <div class="alert alert-danger">
                <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
                El correo <strong><%=usuario.getEmail()%></strong> se encuentra en uso.
            </div>
 <%
    } else {
%>
<div class="text-center alert alert-danger alert-dismissible">
    <h4><i class="icon fa  fa-close"></i> Se ha produciso un error</h4>
    <%=resultado%>
</div>
<%    }   %>
