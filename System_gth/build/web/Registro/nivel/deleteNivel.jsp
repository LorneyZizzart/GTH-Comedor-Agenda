<%-- 
    Document   : deleteNivel
    Created on : 27/05/2019, 10:02:55 AM
    Author     : pc
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Empleado_cargo"%>
<jsp:useBean id="_nivel" class="Controlador.NivelController" />
<jsp:useBean id="_cargo" class="Controlador.Empleado_cargoController" />

<%
    int idNivel = Integer.parseInt(request.getParameter("id"));
    
    List<Empleado_cargo> cargos = new ArrayList<Empleado_cargo>();
    
    cargos = _nivel.DeleteNivel(idNivel);
    
    if(cargos.size() == 0){
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
<div class="box ">
    <div class="box-header">
        <div class="alert alert-danger alert-dismissible">
            <h4><i class="icon fa fa-ban"></i>No se puede eliminar el nivel.</h4>

            <p>El nivel tiene <%=cargos.size()%> usuarios activos que estan asignados.</p>
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
                        <th>Empleado</th>
                        <th>Cargo</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Empleado_cargo item : cargos) {
                    %>
                    <tr>
                        <td><%=item.getEmpleado_nombre()%></td>
                        <td><%=item.getCargo()%></td>
                        <td><% if (item.getActivo() == 1) {%><span class="badge bg-green">Activo</span> </td><%} else {%><span class="badge bg-red">Inactivo</span> </td><%}%>
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