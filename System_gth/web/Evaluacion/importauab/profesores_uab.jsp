<%@page import="Entidad.Uni_acad_area_pre"%>
<%@page import="Entidad.Empleado_docente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="profesoresGet" class="Controlador.Empleado_docenteController"/>
<jsp:useBean id="areapreguntas" class="Controlador.Uni_acad_area_preController"/>
<%

    String gestion = request.getParameter("gestion");

    String area = "";
    try {
        area = request.getParameter("area");
    } catch (Exception e) {
        area = "0";
    }

    List<Empleado_docente> profesores = new ArrayList<Empleado_docente>();
    profesores = profesoresGet.getAllDocenteByGestionArea(gestion, area);

    Uni_acad_area_pre area_pregunta = new Uni_acad_area_pre();
    area_pregunta = areapreguntas.GetAreaPregunta(gestion, area);

    if (!area.equalsIgnoreCase("0")) {
%>
<div class="box-header">
    <h3 class="box-title"></h3>   
</div>
<%
    }
%>

<p class="lead text-center"><%=area_pregunta.getNombre()%> . Gestión: <%=area_pregunta.getGestion()%>. Puntuación sobre: <%=area_pregunta.getPuntuacion()%></p>
<p class="text-center">
    <button type="button" class="btn btn-purple btn_ver_preguntas">Ver Preguntas</button>
</p>


<table class="table table-hover">
    <thead>
        <tr>
            <th>#</th>
            <th>Nombre</th>
            <th>Area</th>
            <th>Gestión</th>
            <th>Codigo Universidad</th>
            <th>Estado</th>
            <th>Importar</th>
        </tr>
    </thead>
    <tbody>
        <% int cont = 0;
            for (Empleado_docente p : profesores) {
                cont++;
        %>
        <tr>
            <td><%=cont%></td>
            <td><%=p.getNombre_profesor()%></td>
            <td><%=p.getNombre_unidad()%></td>
            <td><%=p.getGestion()%></td>
            <td><%=p.getCodigo_uab()%></td>
            <td><%if (p.getNota() > 0) {
                %>
                <span class="badge bg-green">Importado </span></td>
                <%
                    } else {    %>
    <span class="badge bg-red">No Importado </span></td>
    <%
        }
    %>
<td>
    <div class="btn-group">
        <%if (p.getNota() > 0) {
                %>
        <a data-id="<%=p.getEmpleado_docente_id()%>" data-uab="<%=p.getCodigo_uab()%>" class="btn btn-success btn-xs" data-toggle="tooltip" data-placement="bottom" title="Importado"> 
            <i class="fa fa-clipboard"></i>
        </a>                                
            <%}else{%>
            <a data-id="<%=p.getEmpleado_docente_id()%>" data-uab="<%=p.getCodigo_uab()%>" class="btn btn-success btn-xs button_import_evaluacion" data-toggle="tooltip" data-placement="bottom" title="Importar"> 
            <i class="fa fa-clipboard"></i>
            <%}%>
        </a>      
    </div>
</td>
</tr>
<%
    }
%>
</tbody>
</table>
<div class="importa_evaluacion_div"></div>

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
    $(".btn_ver_preguntas").click(function (e) {
        e.preventDefault();
        e.stopImmediatePropagation();

        var area = '1';
        $("#titleModal").html("Preguntas ");

        $('#registro_nuevo_pro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');

        $.post('preguntas_ver.jsp',
                {area: area},
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

    $('.button_import_evaluacion').click(function (e) {
        e.stopImmediatePropagation();
        var docente_id = $(this).attr('data-id');
        var cod_uab = $(this).attr('data-uab');
        var area_id = '<%=area%>';
        var gestion = '<%=gestion%>';
        //alert("docente: " + docente_id + " area: " + area_id + " gestion:" + gestion);

        $(".importa_evaluacion_div").html('');
        $(".importa_evaluacion_div").addClass('loader');
        $.post('importa_evaluacion.jsp',
                {docente_id: docente_id,
                    area_id: area_id,
                    gestion: gestion,
                    cod_uab: cod_uab},
                function (html) {
                    $(".importa_evaluacion_div").html(html);
                    $(".importa_evaluacion_div").removeClass('loader');
                }
        ).fail(function (jqXHR, textStatus, errorThrown)
        {
            var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
            $(".importa_evaluacion_div").removeClass('loader');
            $(".importa_evaluacion_div").html(alerta);
        });

    });
</script>