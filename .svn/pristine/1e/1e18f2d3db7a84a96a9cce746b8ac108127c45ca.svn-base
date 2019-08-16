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
<input type="hidden" value="<%=id_empleado%>" id="envia_empleado_id">
<input type="hidden" value="<%=id_ciclo%>" id="envia_ciclo_id">
<table class="table table-hover table-striped">
    <thead>
        <tr>
            <th class="text-center">#</th>
            <th>Nombre Cuestionario</th>
            <th style="width: 5%">Autoevaluación</th>
            <th style="width: 19%">Jefes</th>
            <th style="width: 19%">Pares</th>
            <th style="width: 19%">Bajos</th>
            <th style="width: 19%">Clientes</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <%
            int contador = 0;
            for (View_Enviar_correo item : correos) {
                contador++;
        %>
        <tr>
            <td><%=contador%></td>
            <td><%=item.getCuestionario_nombre()%></td>
            <td><% if (item.getAuto_evaluacion() != null) {
                %> <%=item.getAuto_evaluacion().getNombre_empleado()%> <br> 
                <%=item.getAuto_evaluacion().getCorreo_electonico()%><%
                    }
                %></td>
            <td>
                <%
                    for (View_Empleado_Encuesta jef : item.getLista_jefes()) {
                %>
                <%=jef.getNombre_empleado()%> <br> 
                <%=jef.getCorreo_electonico()%>
                <%
                    }
                %>
            </td>
            <td>
                <%
                    for (View_Empleado_Encuesta par : item.getLista_pares()) {
                %>
                <%=par.getNombre_empleado()%> <br> 
                <%=par.getCorreo_electonico()%>
                <%
                    }
                %>
            </td>
            <td>
                <%
                    for (View_Empleado_Encuesta bajo : item.getLista_bajos()) {
                %>
                <%=bajo.getNombre_empleado()%> <br> 
                <%=bajo.getCorreo_electonico()%><br> 
                <%
                    }
                %>
            </td>
            <td>
                <%
                    for (View_Empleado_Encuesta cli : item.getLista_clientes()) {
                %>
                <%=cli.getNombre_empleado()%> <br> 
                <%=cli.getCorreo_electonico()%><br> 
                <%
                    }
                %>
            </td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>

<div class="pull-right">
    <button type="button" class="btn btn-purple btn-sm btn-flat btn_enviar_correo" title="Guardar">Enviar Correo</button>
</div>.
<div class = "mensaje_guarda_correo"></div>
<script>
    $(".btn_enviar_correo").click(function (e) {

        var id_empleado = $('#envia_empleado_id').val();
        var id_gestion = $('#envia_ciclo_id').val();

        $(".mensaje_guarda_correo").html("");
        $(".mensaje_guarda_correo").addClass("loader");

        $.post('envia_correo.jsp',
                {
                    id_gestion: id_gestion,
                    id_empleado: id_empleado
                },
                function (html) {
                    $(".mensaje_guarda_correo").removeClass('loader');
                    $(".mensaje_guarda_correo").html(html);
                }
        ).fail(function (jqXHR, textStatus, errorThrown)
        {
            var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
            $(".mensaje_guarda_correo").removeClass('loader');
            $(".mensaje_guarda_correo").html(alerta);
        });
    });
</script>