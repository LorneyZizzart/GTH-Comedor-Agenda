<%@page import="Entidad.View_Empleado_Encuesta"%>
<%@page import="Entidad.View_Enviar_correo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="_ciclo" class="Controlador.Cuestionario_gestionController" />
<%
    String id_empleado = request.getParameter("id_emple");
    String id_ciclo = request.getParameter("id_ciclo");

    List<View_Enviar_correo> correos = new ArrayList<View_Enviar_correo>();
    correos = _ciclo.GetAquienEnviaCorreo(Integer.parseInt(id_ciclo), Integer.parseInt(id_empleado));
    //correos = _ciclo.VerAquienEnviaCorreo(Integer.parseInt(id_ciclo), Integer.parseInt(id_empleado));
%>

<%
    for (View_Enviar_correo correo : correos) {
%>
<h3><%=correo.getCuestionario_nombre()%></h3>

<table class="table table-responsive">
    <thead>
        <tr>
            <th>#</th>
            <th>Nombre</th>
            <th>Evaluo</th>
            <th>Enviar correo</th>
        </tr>
    </thead>
    <tbody>
        <%
            int contador = 0;
            if (correo.getAuto_evaluacion() != null) {
                contador++;
                View_Empleado_Encuesta auto = correo.getAuto_evaluacion();
        %>
        <tr>
            <td><%=contador%></td>
            <td><%=auto.getNombre_empleado()%></td>
            <td><% if (auto.getLleno_cuestionario() == 0) {%><p class="text-danger">NO</p><%} else {%><p class="text-success">SI</p><%}%></td>
            <td><button type="button" class="btn btn-purple btn_un_correo" data-id="<%=auto.getEmpleado_id()%>" data-grupo="Autoevaluacion">Enviar correo</button></td>
        </tr>
        <%
            }
            for (View_Empleado_Encuesta jef : correo.getLista_jefes()) {
                contador++;
        %>
        <tr>
            <td><%=contador%> - <%=jef.getLleno_cuestionario()%></td>
            <td><%=jef.getNombre_empleado()%></td>
            <td><% if (jef.getLleno_cuestionario() == 0) {%><p class="text-danger">NO</p><%} else {%><p class="text-success">SI</p><%}%></td>
            <td><button type="button" class="btn btn-purple btn_un_correo" data-id="<%=jef.getEmpleado_id()%>" data-grupo="Jefe">Enviar correo</button></td>
        </tr>
        <%
            }
            for (View_Empleado_Encuesta par : correo.getLista_pares()) {
                contador++;
        %>
        <tr>
            <td><%=contador%> - <%=par.getLleno_cuestionario()%></td>
            <td><%=par.getNombre_empleado()%></td>
            <td><% if (par.getLleno_cuestionario() == 0) {%><p class="text-danger">NO</p><%} else {%><p class="text-success">SI</p><%}%></td>
            <td><button type="button" class="btn btn-purple btn_un_correo" data-id="<%=par.getEmpleado_id()%>" data-grupo="Par">Enviar correo</button></td>
        </tr>
        <%
            }
            for (View_Empleado_Encuesta bajo : correo.getLista_bajos()) {
                contador++;
        %>
        <tr>
            <td><%=contador%></td>
            <td><%=bajo.getNombre_empleado()%></td>
            <td><% if (bajo.getLleno_cuestionario() == 0) {%><p class="text-danger">NO</p><%} else {%><p class="text-success">SI</p><%}%></td>
            <td><button type="button" class="btn btn-purple btn_un_correo" data-id="<%=bajo.getEmpleado_id()%>" data-grupo="Bajo">Enviar correo</button></td>
        </tr>
        <%
            }
            for (View_Empleado_Encuesta cli : correo.getLista_clientes()) {
                contador++;
        %>
        <tr>
            <td><%=contador%></td>
            <td><%=cli.getNombre_empleado()%></td>
            <td><% if (cli.getLleno_cuestionario() == 0) {%><p class="text-danger">NO</p><%} else {%><p class="text-success">SI</p><%}%></td>
            <td><button type="button" class="btn btn-purple btn_un_correo" data-id="<%=cli.getEmpleado_id()%>" data-grupo="Cliente">Enviar correo</button></td>
        </tr>

        <%
            }
        %>

    </tbody>
</table>
<div class="envia_correo_uno"></div>
<%
    }
%>

<script>
    $(".btn_un_correo").click(function (e) {
        var ciclo_id = <%=id_ciclo%>;
        var emple_evaluar = <%=id_empleado%>;
        var evaluador = $(this).attr("data-id");
        var grupo = $(this).attr("data-grupo");
        //alert(" Ciclo id = " + ciclo_id + "  evaluar = " + emple_evaluar + "  evaluador = " + evaluador + "  Grupo :" + grupo);

        $(".envia_correo_uno").html("");
        $(".envia_correo_uno").addClass("loader");

        $.post('ver_seguimiento_envia_correo.jsp',
                {
                    ciclo_id: ciclo_id,
                    emple_evaluar: emple_evaluar,
                    evaluador: evaluador,
                    grupo: grupo
                },
                function (html) {
                    $(".envia_correo_uno").removeClass('loader');
                    $(".envia_correo_uno").html(html);
                }
        ).fail(function (jqXHR, textStatus, errorThrown)
        {
            var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
            $(".envia_correo_uno").removeClass('loader');
            $(".envia_correo_uno").html(alerta);
        });
    });
</script>