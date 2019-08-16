<%@page import="Entidad.Pregunta_opcion"%>
<%@page import="Entidad.Pregunta"%>
<%@page import="java.util.*"%>
<%@page import="Entidad.Cuestionario"%>
<%@ include file= "head.jsp" %> 

<jsp:useBean id="_cuestionario" class="Controlador.CuestionarioController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />

<%//Verificamos que aya usuario
    if (usuario_evalua.getUser_id() > 0) {
        Cuestionario cuestionario = new Cuestionario();
        List<Pregunta> listaPreguntas = new ArrayList<Pregunta>();
        List<Pregunta_opcion> opciones = new ArrayList<Pregunta_opcion>();
        cuestionario = _cuestionario.ComenzarEvaluacion(id);

        if (cuestionario == null) {
            //en caso que no se encuente el cuestionario    

%>
No se encontro cuestionario
<%} else {

    if (cuestionario.getLLeno_cuestionario() == 1) {
        //En caso que este lleno el cuestionario

%>
<section class="content-encuesta">
    <div class="row">
        <div class="col-xs-12">            

            <div class="box box-purple box-encuesta">
                <div class="box-header">
                    <h2>El cuestionario se encuentra llenado.</h2>                    
                </div>

                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
        <!-- /.col -->
    </div>
</section>
<%} else {
    //out.print("Estado cuestionario " + cuestionario.getLLeno_cuestionario());
    listaPreguntas = cuestionario.getPreguntas();
    int contador = 0;
%>

<section class="content-encuesta">
    <div class="row">
        <div class="col-xs-12">            

            <div class="box box-purple box-encuesta">
                <div class="box-header">
                    <h2><%=cuestionario.getNombre()%></h2>
                    <p class="pull-right">Descripción:
                        <span style="background-color: #ed1c24" class="badge">Malo</span> 
                        <span style="background-color: #fff200; color: #000" class="badge">Regular</span>
                        <span style="background-color: #00a2e8" class="badge">Bueno</span>
                        <span style="background-color: #22b14c" class="badge">Excelente</span>
                    </p>
                </div>

                <!-- /.box-header -->
                <div class="box-body table-responsive">

                    <div id="form_guardar" class="form_guardar">
                        <%

                            for (Pregunta item : listaPreguntas) {
                                contador++;
                                if (item.getEstado() == 1) {
                        %>
                        <div class="form-group group-pregunta">
                            <label class="nombre-pregunta"><%=contador%> - <%=item.getNombre()%></label>
                            <table class="text-center table">
                                <thead>
                                    <tr >
                                        <%

                                            for (Pregunta_opcion opcion : item.getPreguntaOpcion()) {
                                        %>
                                        <th style="background-color: #<%=opcion.getCss()%>"><%=opcion.getOpcion()%></th>                                
                                            <%}%>
                                    </tr>                                    
                                </thead>
                                <tbody>
                                    <tr>
                                <input type="hidden" id="pregunta_id_<%=contador%>" value="<%=item.getPregunta_id()%>">
                                <%
                                    for (Pregunta_opcion opcion : item.getPreguntaOpcion()) {
                                %>
                                <td style="background-color: #<%=opcion.getCss()%>">
                                    <input type="radio" name="respuesta_<%=contador%>" data-pregunta="<%=item.getPregunta_id()%>" value="<%=opcion.getOpcion()%>" >
                                </td>
                                <%}
                                %>
                                </tr>
                                </tbody>
                            </table>
                        </div>   
                        <%}
                            }%>

                        <div class="box-footer footer-encuesta">
                            <button type="button" class="btn btn-default pull-left cerrar_pestania" data-dismiss="modal" onClick="Finalizar();"><i class="fa fa-close"></i> Cancelar</button>
                            <button type="botton" class="btn-purple pull-right" id="enviar_respuestas"><i class="fa fa-send"></i> Enviar</button>
                            <input type="hidden" id="tamanio_preguntas" value="<%=contador%>">

                        </div>
                    </div>
                    <div id="mensaje_encuesta"></div>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
        <!-- /.col -->
    </div>

</section>


<%}
    }
} else {
    // En caso que no aya usuario
%>
No hay usuario

<section class="content-encuesta">
    <div class="row">
        <div class="col-xs-12">            

            <div class="box box-purple box-encuesta">
                <div class="box-header">
                    <h2>No se encontró usuario para realizar la encuesta.</h2>                    
                </div>

                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
        <!-- /.col -->
    </div>
</section>
<%
    }
%>


</body>

<%@ include file= "footer.jsp" %> 

<script>
    /* $(".cerrar_pestania").click(function (e) {
     e.preventDefault();
     e.stopImmediatePropagation();
     
     window.open("", "_self");
     window.close();
     });*/
    function Finalizar() {
        window.location.href = '../../index.jsp';
    }
    $("#enviar_respuestas").click(function (e) {
        e.preventDefault();
        e.stopImmediatePropagation();
        $('#mensaje_encuesta').html('');
        var cantidad_preguntas = $('#tamanio_preguntas').val();

        var array_nota = [];
        for (var i = 1; i <= cantidad_preguntas; i++) {
            var seleccion = 'respuesta_' + i;
            var opcion_seleccionado = $("input[name=" + seleccion + "]:checked").val()
            if (opcion_seleccionado == null) {
                var mensaje = '<div class="alert alert-warning" role="alert"> <strong>Ups!</strong> Se requiere de seleccione una respuesta en la pregunta .<strong>' + i + '</strong> </div>';
                $('#mensaje_encuesta').html(mensaje);
                return false;
            } else {
                var pregunta_id = $('#pregunta_id_' + i).val();
                var cuestionario_id_evalua = $('#cuestionario_id_evalua').val();
                var guardar = opcion_seleccionado + '-' + pregunta_id + '-' + cuestionario_id_evalua;
                array_nota.push(guardar);
            }
        }
        //alert(array_nota);
        $.ajax({
            type: "POST",
            url: "guarda_respuestas.jsp",
            data: {ids: array_nota},
            success: function (data)
            {
                $("#mensaje_encuesta").removeClass("loader");
                $("#mensaje_encuesta").html(data);
            }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                $("#mensaje_encuesta").removeClass("loader");
                var menn = "<p class='text-red'>Se produjo un error " + errorThrown + "  " + textStatus + "</p>";
                $("#mensaje_encuesta").html(menn);
            }
        });
    });
</script>
</html>