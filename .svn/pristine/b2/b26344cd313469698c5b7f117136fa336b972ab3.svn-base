<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Usuario"%>
<jsp:useBean id="consultaUser" class="Controlador.UsuarioController" />
<%
    int idDepartamento = Integer.parseInt(request.getParameter("idD"));
    
    List<Usuario> Usuarios = new ArrayList<Usuario>();
    
    if(idDepartamento == 0){
        Usuarios = consultaUser.GetAllUser();
    }else{
        Usuarios = consultaUser.getAllByDepartamento(idDepartamento);
    }
    
%>

<div  class="form-group">
    <label class="col-md-3 control-label" style="padding: 2% 0 0 0;">Funcionario: </label>
    <div class="col-md-9 col-xs-12 input-group">
        <select id="idFuncionario" name="idFuncionario"  class="form-control select2" style="width: 100%;">
            <option value="0" selected>Todos</option>
                <%
                for (Usuario item : Usuarios) {
                %>
                <option value="<%=item.getUser_id()%>" ><%=item.getNombre()%></option>                            
                <% } %>
            </select>
    </div>
</div>
            <script>
    $(document).ready(function() {
        $('.select2').select2();
    });
            </script>
     