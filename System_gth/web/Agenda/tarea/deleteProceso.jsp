<%@page import="Entidad.A_ProcedimientoTarea"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_proceso" class="Controlador.A_ProcedimientoTareaController"/>
<%
    String idProceso = _encript.ValorADesencriptar(request.getParameter("id")); 
    A_ProcedimientoTarea procedimiento = new A_ProcedimientoTarea();
    procedimiento = _proceso.getProcedimientoById(Integer.parseInt(idProceso));
  
%>
<form id="formGuardarProceso" method="post" class="formGuardarProceso">
    <input type="hidden" value="<%=idProceso%>" name="idProceso" id="idProceso">
    <input type="hidden" value="0" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group" >
                            <label>Nombre</label>
                            <input disabled type="text" class="form-control" id="nombre"  name="nombre" value="<%=procedimiento.getNombreProcedimiento()%>">                            
                        </div>                         
                        <div class="form-group">
                            <label>Descripción</label>
                            <textarea disabled class="form-control" rows="3" id="descripcion"  name="descripcion"><%=procedimiento.getDescripcionProcedimiento()%></textarea>
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
        
        $(".modal-dialog-edit").width("40%");
        $(".modal-dialog-edit").css('margin-right', "30%");
        $(".modal-dialog-edit").css('margin-left', "30%");
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