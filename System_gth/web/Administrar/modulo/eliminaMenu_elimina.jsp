<jsp:useBean id="eliminaMenu" class="Controlador.MenuController" />
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Usuario"%>
<%@page import="java.util.List"%>
<%
    List<Usuario> Usuarios = new ArrayList<Usuario>();
    int id = Integer.parseInt(request.getParameter("id"));
    Usuarios = eliminaMenu.Elimina(id);
    if (Usuarios.size() == 0) {
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Eliminado</h4>
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
} else {
%>
<!-- TABLE: LATEST ORDERS -->
<div class="box">
    <div class="box-header">
        <div class="alert alert-danger alert-dismissible">
            <h4><i class="icon fa fa-ban"></i> No se puede eliminar el menú</h4>

            <p>El menú tiene <%=Usuarios.size()%> usuarios activos que usan la opción.</p>
        </div>

        <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
            </button>
            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
        </div>
    </div>
    <!-- /.box-header -->
    <div class="box-body">
        <div class="table-responsive">
            <table class="table no-margin">
                <thead>
                    <tr>
                        <th>Usuario</th>
                        <th>Correo</th>
                        <th>Perfil</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Usuario item : Usuarios) {
                    %>
                    <tr>
                        <td><%=item.getUsuario()%></td>
                        <td><%=item.getEmail()%></td>
                        <td><%=item.getPerfil()%></td>
                        <td><%
                            if (item.getEstado() == 1) {
                            %><span class="label label-success">Activo</span><%
                            } else {
                            %><span class="label label-warning">Inactivo</span><%
                                }
                            %></td>
                    </tr>
                    <%
                        }
                    %>               
                </tbody>
            </table>
        </div>
        <!-- /.table-responsive -->
        <%
            }
        %>