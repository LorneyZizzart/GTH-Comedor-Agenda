<%-- 
    Document   : deleteArea
    Created on : 27/05/2019, 10:20:56 AM
    Author     : pc
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Departamento"%>
<jsp:useBean id="_area" class="Controlador.AreaController"/>
<%
    int idArea = 0;
    List<Departamento> departamentos = new ArrayList<Departamento>();
    
    try {
        idArea = Integer.parseInt(request.getParameter("id"));
        departamentos = _area.DeleteArea(idArea);
    }catch (Exception e) {
        idArea = 0;
    }
    
    if(departamentos.size() == 0){
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
            <h4><i class="icon fa fa-ban"></i>No se puede eliminar el área.</h4>

            <p>El área tiene <%=departamentos.size()%> departamentos activos que estan asignados.</p>
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
                        <th>ID</th>
                        <th>Departamento</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Departamento item : departamentos) {
                    %>
                    <tr>
                        <td><%=item.getDepartamento_id()%></td>
                        <td><%=item.getNombre()%></td>
                        <td><% if (item.getEstado() == 1) {%><span class="badge bg-green">Activo</span> </td><%} else {%><span class="badge bg-red">Inactivo</span> </td><%}%>
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