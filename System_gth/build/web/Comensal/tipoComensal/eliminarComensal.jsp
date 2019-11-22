<%-- 
    Document   : eliminarArea
    Created on : 27/05/2019, 10:20:44 AM
    Author     : pc
--%>
<%@page import="Entidad.C_TipoComensal"%>
<jsp:useBean id="_tipoComensalController" class="Controlador.C_TipoComensalesController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<%
    String idEncript = request.getParameter("id");
    int id = 0;
    C_TipoComensal entidad = new C_TipoComensal();
    
    try {
        id = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        entidad = _tipoComensalController.getTipoComensalById(id);
    }catch (Exception e) {
        id = 0;
    }
%>
         <form id="form_guardar" method="post" class="form_area_guardar">
             <input type="hidden" value="<%=id%>" name="id" id="id">
                    <div class="box-body">
                        <div class="box-body">
                            <div class="form-group">
                                <label>Nombre</label>
                                <input disabled type="text" class="form-control" id="tipo_comensal_nombre"  name="tipo_comensal_nombre" value="<%=_character.CharacterUCFirst(entidad.getNombreComensal())%>">                            
                            </div>   
                        <div class="form-group" >
                            <label>Descuento de desayuno</label>
                            <input disabled type="text" class="form-control" id="descuentoDesayuno"  name="descuentoDesayuno" value="<%=entidad.getDescuentoDesayuno()%>">                            
                        </div>
                        <div class="form-group" >
                            <label>Descuento de almuerzo</label>
                            <input disabled type="text" class="form-control" id="descuentoAlmuerzo"  name="descuentoAlmuerzo" value="<%=entidad.getDescuentoAlmuerzo()%>">                         
                        </div>
                        <div class="form-group" >
                            <label>Descuento de cena</label>
                            <input disabled type="text" class="form-control" id="descuentoCena"  name="descuentoCena" value="<%=entidad.getDescuentoCena()%>">                          
                        </div>
                        <div class="form-group" >
                            <label>Días anticipacion</label>
                            <input disabled type="text" class="form-control" value="<%=entidad.getDiasAnticipacion()%>">                            
                        </div>
                            <div class="form-group">
                                <label>Estado</label>
                                <%
                                    String select = "";
                                    if(entidad.getEstado() > 0){
                                        select = "checked";
                                    }
                                %>
                                <label> <input disabled  type="checkbox" name="tipo_comensal_estado" id="tipo_comensal_estado"  class="flat-red" <%=select%>></label>
                            </div>   
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
            var id_menu = $("#id").val();
            $("#mensaje").show();
            $("#mensaje").addClass("loader");
            $.post('deleteComensal.jsp',
                    {id: id_menu},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
    });

</script>
