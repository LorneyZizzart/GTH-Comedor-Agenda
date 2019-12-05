<%@page import="Entidad.Evento"%>
<jsp:useBean id="editarEvento" class="Controlador.EventoController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    Evento e_evento = new Evento();
    int evento_id = 0;

    try {
        String desencriptar = _encript.ValorADesencriptar(request.getParameter("evento_id"));
        evento_id = Integer.parseInt(desencriptar);
        e_evento = editarEvento.GetEventobyId(evento_id);
    } catch (Exception e) {
        System.err.println(" -- - " + e.getMessage());
        evento_id = 0;
        e_evento = null;
    }

   // out.print(evento_id);
%>

<div class="tab-pane" id="settings">
    <form class="form-horizontal">
        <div class="form-group">
            <label class="col-sm-4 control-label">Nombre evento</label>

            <div class="col-sm-8">

                <input disabled="" type="text" class="form-control" value="<% if (e_evento != null) {
                        out.print(e_evento.getNombre_evento());
                    }
                       %>">
            </div>
        </div>

        <div class="form-group">
            <label for="inputEmail" class="col-sm-4 control-label">Fecha Inicio</label>
            <div class="col-sm-8">
                <input disabled="" type="text" class="form-control" value="<%if (e_evento != null) {
                        out.print(e_evento.getFecha_inicio());
                    }%>">
            </div>
        </div>
        <div class="form-group">
            <label for="inputName" class="col-sm-4 control-label">Fecha Fin</label>

            <div class="col-sm-8">
                <input disabled="" type="text" class="form-control" value="<%if (e_evento != null) {
                        out.print(e_evento.getFecha_fin());
                    }%>">
            </div>
        </div>
        <div class="form-group">
            <label for="inputExperience" class="col-sm-4 control-label">Detalle</label>

            <div class="col-sm-8">
                <textarea disabled="" class="form-control"><%if (e_evento != null) {
                        out.print(e_evento.getDetalle());
                    }%></textarea>
            </div>
        </div>
        <div class="box-footer">
            <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
            <button type="button" class="btn btn-warning pull-right btn_desactivar" data-id="<%=evento_id%>"><i class="fa fa-save"></i> Desactivar</button>
        </div>      
        <div class="mensaje_desactiva">
        </div>
    </form>
</div>
<!-- /.tab-pane -->
<script type="text/javascript">
    $(document).ready(function () {
        $(".btn_desactivar").click(function (e) {
           
            e.preventDefault();
            e.stopImmediatePropagation();
           
            $.post('desactivar_evento_guardar.jsp',
                    {id: $(this).attr('data-id')},
                    function (html) {
                        $(".mensaje_desactiva").removeClass('loader');
                        $(".mensaje_desactiva").html(html);
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".mensaje_desactiva").removeClass('loader');
                $(".mensaje_desactiva").html(alerta);
            });
        });
    });
</script>