<%@page import="Entidad.Feedback"%>
<jsp:useBean id="_feedback_ver" class="Controlador.FeedbackController" />
<%
    String id_nota = request.getParameter("id");
    Feedback datos = new Feedback();
    datos = _feedback_ver.Get_feedback_by_id(Integer.parseInt(id_nota));
%>
<div class="box-body">
    <dl class="dl-horizontal">
        <dt>Tipo Advertencia: </dt>
        <dd><%=datos.getFeedback_tipo_nombre()%>.</dd>
        <dt>Motivo: </dt>        
        <dd><%=datos.getMotivo()%>.</dd>
        <dt>Fecha:</dt>
        <dd><%=datos.getFecha_advertencia()%>.</dd>
        <dt>Descripción</dt>
        <dd><%=datos.getDescripcion()%>
        </dd>
    </dl>

    <button type="button" class="btn btn-danger btn_eliminar_nota" data-id="<%=id_nota%>">
        Eliminar
    </button>
    <div id="elimina_mensaje"></div>
    <script>
        $(".btn_eliminar_nota").click(function () {
            var id_retro = $(this).attr('data-id');

            $("#elimina_mensaje").html('');
            $("#elimina_mensaje").addClass('loader');

            $.post('retro_alimentacion/eliminar_retroalimentacion_guardar.jsp',
                    {id: id_retro},
                    function (html) {
                        $("#elimina_mensaje").removeClass('loader');
                        $("#elimina_mensaje").html(html);
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $("#elimina_mensaje").removeClass('loader');
                $("#elimina_mensaje").html(alerta);
            });
        });
    </script>