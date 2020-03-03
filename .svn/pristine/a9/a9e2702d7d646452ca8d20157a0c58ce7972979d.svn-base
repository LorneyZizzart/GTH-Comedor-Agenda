<%@page import="Entidad.Empleado_docente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="profesoresGet" class="Controlador.Empleado_docenteController"/>
<%

    String gestion = request.getParameter("gestion");

    String area = "";
    try {
        area = request.getParameter("area");
    } catch (Exception e) {
        area = "0";
    }

    List<Empleado_docente> profesores = new ArrayList<Empleado_docente>();
    // out.print("Gestion " + gestion + " area " + area);
    profesores = profesoresGet.getAllDocenteByGestionArea(gestion, area);

    if (!area.equalsIgnoreCase("0")) {
%>
<div class="box-header">
    <h3 class="box-title"></h3>
    <a href="#" class="btn-purple btn-right_nivel mod_agregar_prof" data-toggle="tooltip" title="Añadir Profesor"><i class="fa fa-plus"></i></a>   
</div>
<%
    }
%>

<table class="table table-hover">
    <thead>
        <tr>
            <th>#</th>
            <th>Código</th>
            <th>Nombre</th>
            <th>Area</th>
            <th>Gestión</th>
            <th>Codigo Universidad</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <% int cont = 0;
            for (Empleado_docente p : profesores) {
                cont++;
        %>
        <tr>
            <td><%=cont%></td>
            <td><%=p.getEmpleado_docente_id()%></td>
            <td><%=p.getNombre_profesor()%></td>
            <td><%=p.getNombre_unidad()%></td>
            <td><%=p.getGestion()%></td>
            <td><%=p.getCodigo_uab()%></td>
            <td>
                <div class="btn-group">
                    <a data-id="<%=p.getEmpleado_docente_id()%>" class="formDelete btn btn-danger btn-xs button_delete_prof" data-toggle="tooltip" data-placement="bottom" title="Eliminar"> <i class="fa fa-trash-o"></i></a>                                
                </div>
            </td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>
<div class="lista_porfesores_div"></div>

<div class="modal fade" id="registro_nuevo_pro">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 id="titleModal" class="modal-title">title</h4>
            </div>
            <div class="modal-body cuerpo_registro"></div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>    

<script>
    $(".mod_agregar_prof").click(function (e) {
        e.preventDefault();
        e.stopImmediatePropagation();
        var gestion = $(".gestion").val();
        var area = $(".area").val();
        $("#titleModal").html("Añadir Profesor ");
        if (gestion == '0') {
            toastr.error("Seleccione Gestion.");
            return null;
        }
        if (area == '0') {
            toastr.error("Seleccione Área.");
            return null;
        }
        $('#registro_nuevo_pro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');

        $.post('form_agrega_prof.jsp',
                {area: area, gestion: gestion},
                function (html) {
                    $(".cuerpo_registro").removeClass('loader');
                    $(".cuerpo_registro").html(html);
                }
        ).fail(function (jqXHR, textStatus, errorThrown)
        {
            var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
            $(".cuerpo_registro").removeClass('loader');
            $(".cuerpo_registro").html(alerta);
        });

    });

    $('.button_delete_prof').click(function (e) {
        e.stopImmediatePropagation();
        var id = $(this).attr('data-id');
        $.post('elimina_prof.jsp',
                {id: id},
                function (html) {
                    $(".lista_porfesores_div").html(html);
                    $(".lista_porfesores_div").removeClass('loader');
                }
        ).fail(function (jqXHR, textStatus, errorThrown)
        {
            var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
            $(".lista_porfesores_div").removeClass('loader');
            $(".lista_porfesores_div").html(alerta);
        });
       
    });
</script>