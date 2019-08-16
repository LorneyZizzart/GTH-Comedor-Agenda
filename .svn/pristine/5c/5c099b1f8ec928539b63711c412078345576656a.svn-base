<%@page import="Entidad.Cuestionario_gestion"%>
<%
    String id_cuestionario = request.getParameter("id");
%>
<jsp:useBean id="_ciclo" class="Controlador.Cuestionario_gestionController" />

<%
    Cuestionario_gestion cues_gestio = new Cuestionario_gestion();
    cues_gestio = _ciclo.GetCuestionario_gestionById(Integer.parseInt(id_cuestionario));
%>
<input type="hidden" value="<%=id_cuestionario%>" name="id_save_mail_cuestioario" id="id_save_mail_cuestioario">

<b>Tomar nota:</b> <br>Para agregar el nombre del evaluador utilice la siguinte cadena = <b>--Evaluador--</b>
<br>
Para agregar el nombre de la persona a ser evaluaod utilice la siguinte cadena =<b> --Evaluado--</b>

<br><br>

<form>
    <div class="form-group">
        <label>Título Correo:</label>
        <input type="text" class="form-control titulo_correo" id="titulo_correo"  name="titulo_correo" value="<% if(cues_gestio.getTitulo_correo()!=null)out.print(cues_gestio.getTitulo_correo());%>">                            
    </div> 
    <div class="form-group">
        <label>Contenido Correo:</label>
        <textarea class="textarea_mail" id="textarea_mail" placeholder="Escriba el Correo" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;">
            <% if(cues_gestio.getMensaje_correo()!=null)out.print(cues_gestio.getMensaje_correo());%>
        </textarea>
    </div>
</form>

<div class="pull-right">
    <button type="button" class="btn btn-purple btn-sm btn-flat btn_guarda_correo" title="Guardar">Guardar</button>
</div>.
<div class = "mensaje_guarda_correo"></div>
<script>
    $(function () {
        $(".textarea_mail").wysihtml5();
    });

    $(".btn_guarda_correo").click(function (e) {
        var correo_mail = $('.textarea_mail').val();
        var titulo_mail = $('.titulo_correo').val();
        var id_gestion = $('#id_save_mail_cuestioario').val();
        $(".mensaje_guarda_correo").html("");
        $(".mensaje_guarda_correo").addClass("loader");

        $.post('correo_electronico_guarda.jsp',
                {
                    id_gestion: id_gestion,
                    correo_mail: correo_mail,
                    titulo_correo: titulo_mail
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
        return null;
    });
</script>