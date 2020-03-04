<%@page import="Entidad.C_Empleado_Reserva"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_empleadoReserva" class="Controlador.C_EmpleadoReservaController"/>
<%
    C_Empleado_Reserva empleadoReserva = new C_Empleado_Reserva();
    String[] idReserva = request.getParameter("id").split("%");
    if(Integer.parseInt(idReserva[1]) == 1){
        empleadoReserva = _empleadoReserva.getReservaEmpleadoById(Integer.parseInt(idReserva[0]));
    }else{
        empleadoReserva = _empleadoReserva.getReservaExternoById(Integer.parseInt(idReserva[0]));
    }
%>
<form id="form_guardar" method="post" class="form_guardar">
            <input type="hidden" value="<%=idReserva[0]%>%<%=idReserva[1]%>" name="idReserva" id="idReserva">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Nombre completo: </label>
                            <input disabled type="text" class="form-control" value="<%=empleadoReserva.getNombreEmpleado()%>">                            
                        </div>                          
                        <div class="form-group" >
                            <label>Teléfono</label>
                            <input disabled type="text" class="form-control" value="<%=empleadoReserva.getTelefono()%>">                            
                        </div>
                        <div class="form-group">
                            <label>Observación</label>
                            <textarea disabled class="form-control" rows="3" id="observacion"  name="observacion"><%=empleadoReserva.getObservacion()%></textarea>
                        </div>
                        <div class="form-group" >
                            <label>Cantidad</label>
                            <input disabled type="text" class="form-control" id="cantidad"  name="cantidad" value="<%=empleadoReserva.getCantidad()%>">                            
                        </div>
                        <div class="form-group">
                            <label>Descuento adicional</label>
                            <input disabled type="text" class="form-control" id="descuentoAdicional"  name="descuentoAdicional" value="<%=empleadoReserva.getDescuentoAdicional()%>">  
                        </div>   
                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
                        <button type="button" class="btn btn-danger pull-right btn_eliminar"><i class="fa fa-trash-o"></i> Eliminar</button>
                    </div>
                </form>
        <div id="mensaje"></div>
<script type="text/javascript">
      $(document).ready(function () {
        $(".btn_eliminar").click(function () {
            var id_menu = $("#idReserva").val();
            $("#mensaje").show();
            $("#mensaje").addClass("loader");
            $.post('deleteReserva.jsp',
                    {id: id_menu},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
    });

</script>