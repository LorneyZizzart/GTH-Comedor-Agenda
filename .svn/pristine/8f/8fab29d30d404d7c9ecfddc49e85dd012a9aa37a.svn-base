<%@page import="Entidad.C_TipoComida"%>
<jsp:useBean id="_tipoComida" class="Controlador.C_TipoComidaController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    String idEncript = request.getParameter("id");
    
    int idTipoComida = 0;
    C_TipoComida tipoComida = new C_TipoComida();
    
    try {
        idTipoComida = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        tipoComida = _tipoComida.getTipoComidaById(idTipoComida);        
    }catch (Exception e) {
        idTipoComida = 0;
    }
%>
         <form id="form_guardar" method="post" class="form_guardar">
             <input type="hidden" value="<%=idTipoComida%>" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input disabled type="text" class="form-control" id="nombre"  name="nombre" value="<%=tipoComida.getNombreComida()%>">                            
                        </div> 
                        <div class="form-group">
                            <label>Costo</label>
                            <input disabled type="text" class="form-control" id="costo"  name="costo" value="<%=tipoComida.getCosto()%>">                            
                        </div> 
                        <div class="form-group">
                            <label>Hora de ingreso</label>
                            <input disabled type="text" class="form-control" id="hora"  name="hora" value="<%=tipoComida.getHora()%>">                            
                        </div>
                        <div class="form-group">
                            <label>Color del item</label> 
                            <div class="input-group my-colorpicker2">
                                <input disabled type="text" id="color"  name="color" class="form-control "value="<%=tipoComida.getColor()%>">

                                <div class="input-group-addon">
                                  <i></i>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Horas de anticipación</label>
                            <input disabled="" type="text" class="form-control" id="horaAnticipacion"  name="horaAnticipacion" value="<%=tipoComida.getHorasAnticipacion()%>">                            
                        </div> 
                        <div class="form-group">
                            <label>Detalles</label>
                            <textarea disabled class="form-control" rows="3" id="detalle"  name="detalle"><%=tipoComida.getDetalle()%></textarea>
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <%
                                String select = "";
                                if(tipoComida.getEstado() > 0){
                                    select = "checked";
                                }
                            %>
                            <label> <input disabled type="checkbox" name="estado" id="estado"  class="flat-red" <%=select%>></label>
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
        $(".my-colorpicker2").colorpicker();
        $(".btn_eliminar").click(function () {
            var id_menu = $("#id").val();
            $("#mensaje").show();
            $("#mensaje").addClass("loader");
            $.post('deleteTipoComida.jsp',
                    {id: id_menu},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
    });
</script>