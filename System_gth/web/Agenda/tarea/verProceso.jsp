<%@page import="Entidad.A_Tarea"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.A_ProcedimientoTarea"%>
<jsp:useBean id="_proceso" class="Controlador.A_ProcedimientoTareaController" />
<jsp:useBean id="_path" class="Controlador.A_PathProcedimientoTareaController" />
<%    
    String id = request.getParameter("id"); 
    A_ProcedimientoTarea procedimiento = new A_ProcedimientoTarea();
    procedimiento = _proceso.getProcedimientoById(Integer.parseInt(id));
    List<A_Tarea> listaPath = new ArrayList<A_Tarea>();
    listaPath = _path.getAllPathProcedimiento(Integer.parseInt(id));
%>
<div style=" padding: 0 2% 2% 2%; border: solid 1px #d2d2d2; background-color: white;">
    <!--titulo-->

        <div class="box-header" style="padding: 0;margin: 27px 0 0 0"> 
            <div class="text-center">
                <h4 class="box-title" style="font-weight: bold"><%=procedimiento.getNombreProcedimiento()%></h4>
            </div>
        </div>     
                <div class="box-body">
                    <p><%=procedimiento.getDescripcionProcedimiento()%></p>
                </div>
                 <div class="box-footer">
                    <%
                                for (A_Tarea path : listaPath) {

            %>
                            <div id="divimgSalida" class="col-md-2 text-center cont-image" style="border: solid 1px #aba8a8; margin: 2px;padding: 0;border-radius: 5px;">
                                
                                <img id="imgSalida'+numImage+'" width="100%" height="100%" src="../../folder_picture/Procesos/<%=path.getPathImage()%>" />

                                <label id="imgSalida"><%=path.getNombrePath()%></label>
                            </div>
    <%  } %>
                </div>
                
</div>
                <div class="box-footer" style="padding: 8px 0 0 0;background-color: #eaeaea;">
                        <button type="button" class="btn-purple pull-left btn-cProcess" data-dismiss="modal"><i class="fa fa-arrow-left"></i> Volver</button>
                    </div>
                <script type="text/javascript">
                    $(".btn-cProcess").click(function (e) {
                        $("#formulario_registro #modelViewTarea").removeClass( "modelViewTarea");
        $("#titleModal").html("Procesos");
        e.preventDefault();
        e.stopImmediatePropagation();
            $('#formulario_registro').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            
            $.post('procesosTarea.jsp',
            {id: localStorage.getItem("idTarea")},
                    function (html) {
                    $(".cuerpo_registro").removeClass('loader');
                    $(".cuerpo_registro").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $(".cuerpo_registro").removeClass('loader');
                $(".cuerpo_registro").html(alerta);
            });
    });
                    </script>