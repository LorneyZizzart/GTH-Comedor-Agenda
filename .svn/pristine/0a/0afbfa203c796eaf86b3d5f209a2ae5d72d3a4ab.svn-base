<%-- 
    Document   : eliminarArea
    Created on : 27/05/2019, 10:20:44 AM
    Author     : pc
--%>
<%@page import="Entidad.Area"%>
<jsp:useBean id="_area" class="Controlador.AreaController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<%
    String idEncript = request.getParameter("id");
    int idArea = 0;
    Area area = new Area();
    
    try {
        idArea = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        area = _area.getAreaById(idArea);
    }catch (Exception e) {
        idArea = 0;
    }
%>
         <form id="form_guardar" method="post" class="form_area_guardar">
             <input type="hidden" value="<%=idArea%>" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input disabled type="text" class="form-control" id="area_nombre"  name="area_nombre" placeholder="Ingresar nombre" value="<%=_character.CharacterUCFirst(area.getNombre())%>">                            
                        </div>  
                        <div class="form-group">
                            <label>Posición</label>
                            <input disabled type="text" class="form-control" id="posicion"  name="posicion" value="<%=area.getPosicion()%>">                            
                        </div>
                        <div class="form-group">
                            <label>Estado</label
                            <%
                                String select = "";
                                if(area.getEstado() > 0){
                                    select = "checked";
                                }
                            %>
                            <label> <input disabled type="checkbox" name="area_estado" id="area_estado"  class="flat-red" <%=select%>></label>
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
            $.post('deleteArea.jsp',
                    {id: id_menu},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
    });

</script>
