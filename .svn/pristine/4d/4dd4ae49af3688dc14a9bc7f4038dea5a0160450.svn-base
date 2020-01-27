<%@page import="Entidad.A_Tarea"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.A_ProcedimientoTarea"%>
<jsp:useBean id="_proceso" class="Controlador.A_ProcedimientoTareaController"/>
<jsp:useBean id="_path" class="Controlador.A_PathProcedimientoTareaController" />
<%
    String[] id = request.getParameter("id").split("%"); 
    A_ProcedimientoTarea procedimiento = new A_ProcedimientoTarea();
    procedimiento = _proceso.getProcedimientoById(Integer.parseInt(id[0]));
    List<A_Tarea> listaPath = new ArrayList<A_Tarea>();
    listaPath = _path.getAllPathProcedimiento(Integer.parseInt(id[0])); 
  
%>
<form id="formGuardarProceso" method="post" class="formGuardarProceso">
    <input type="hidden" value="<%=id[0]%>" name="idProceso" id="idProceso">
    <input type="hidden" value="0" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group" >
                            <label>Nombre</label>
                            <input disabled type="text" class="form-control" id="nombre"  name="nombre" value="<%=procedimiento.getNombreProcedimiento()%>">                            
                        </div>   
                        <div class="form-group">
                            <label>Descripción</label>
                            <textarea disabled class="textarea"  id="descripcion"  name="descripcion" style="width: 100%; height: 300px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"><%=procedimiento.getDescripcionProcedimiento()%></textarea>
                        </div>
                        <div id="divImage" class="form-group row" style="margin: 2px;">
                            <%
                                for (A_Tarea path : listaPath) {

            %>
                            <div id="divimgSalida<%=path.getIdPathProcedimiento()%>" class="col-md-2 text-center cont-image" style="border: solid 1px #aba8a8; margin: 2px;padding: 0;border-radius: 5px;">
                                <label id="imgSalida"><%=path.getNombrePath()%></label>
                                <img id="imgSalida" width="100%" height="100%" src="../../folder_picture/Procesos/<%=path.getPathImage()%>" />
                            </div>
    <%  } %>
                        </div>
                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer">
                        <button type="button" class="btn btn-default pull-left btn-cProcess" data-dismiss="modal"><i class="fa fa-arrow-left"></i> Volver</button>
                        <button type="button" class="btn btn-danger pull-right btn_eliminar"><i class="fa fa-trash-o"></i> Eliminar</button>
                    </div>
                </form>
        <div id="mensaje"></div>
<script type="text/javascript">
    $(".textarea").wysihtml5();
    
        $(".btn_eliminar").click(function () {
            var id_menu = $("#idProceso").val();
            $("#mensaje").show();
            $("#mensaje").addClass("loader");
            $.post('eliminarProceso.jsp',
                    {id: id_menu},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
        
        $(".btn-cProcess").click(function (e) {
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