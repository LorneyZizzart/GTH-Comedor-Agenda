<%-- 
    Document   : crearNivel
    Created on : 21/05/2019, 09:41:04 AM
    Author     : Jhonny
--%>
<%@page import="Entidad.Nivel"%>
<jsp:useBean id="_nivel" class="Controlador.NivelController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<%
    String idEncript = request.getParameter("id");
    int idNivel = 0;
    Nivel nivel = new Nivel();
    
    try {
        idNivel = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        nivel = _nivel.getNivelById(idNivel);
    }catch (Exception e) {
        idNivel = 0;
    }
%>
         <form id="form_guardar" method="post" class="form_nivel_guardar">
             <input type="hidden" value="<%=idNivel%>" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input disabled type="text" class="form-control" id="nivel_nombre"  name="nivel_nombre" value="<%=_character.CharacterUCFirst(nivel.getNombre())%>">                            
                        </div>  
                        <div class="form-group">
                            <label>Posición</label>
                            <input disabled type="text" class="form-control" id="posicion"  name="posicion" value="<%=nivel.getPosicion()%>">                            
                        </div> 
                        <div class="form-group">
                            <label>Estado</label
                            <%
                                String select = "";
                                if(nivel.getEstado() > 0){
                                    select = "checked";
                                }
                            %>
                            <label> <input disabled type="checkbox" name="nivel_estado" id="nivel_estado"  class="flat-red" <%=select%>></label>
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
            $.post('deleteNivel.jsp',
                    {id: id_menu},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
    });

</script>


