<%@page import="Entidad.A_TipoTarea"%>
<jsp:useBean id="_tipoTarea" class="Controlador.A_TipoTareaController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    String idTipoTarea = _encript.ValorADesencriptar(request.getParameter("id"));
    A_TipoTarea tipoTarea = new A_TipoTarea();
    tipoTarea = _tipoTarea.getTipoTareaById(Integer.parseInt(idTipoTarea));
    
%>
<form id="form_guardar" method="post" class="form_guardar">
    <input type="hidden" value="<%=idTipoTarea%>" name="id" id="id">
                    <div class="box-body">                         
                        <div class="form-group" >
                            <label>Tipo de tarea</label>
                            <input disabled type="text" class="form-control" id="tipoTarea"  name="tipoTarea" value="<%=tipoTarea.getNombreTarea()%>">                            
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <%
                                String select = "";
                                if(tipoTarea.getEstadoTipoTarea() > 0){
                                    select = "checked";
                                }
                            %>
                            <label><input disabled type="checkbox" name="estado" id="estado"  class="flat-red" <%=select%>></label>
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
            $.post('deleteTipoTarea.jsp',
                    {id: id_menu},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
    });

</script>