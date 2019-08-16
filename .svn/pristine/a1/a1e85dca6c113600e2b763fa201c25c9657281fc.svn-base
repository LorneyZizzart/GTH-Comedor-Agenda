<%@page import="Entidad.A_EstadoTarea"%>
<jsp:useBean id="_estadoTarea" class="Controlador.A_EstadoTareaController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    String idEstadoTarea = _encript.ValorADesencriptar(request.getParameter("id"));
    A_EstadoTarea estadoTarea = new A_EstadoTarea();
    estadoTarea = _estadoTarea.getEstadoTareaById(Integer.parseInt(idEstadoTarea));
    
%>
<form id="form_guardar" method="post" class="form_guardar">
    <input type="hidden" value="<%=idEstadoTarea%>" name="id" id="id">
                    <div class="box-body">                         
                        <div class="form-group" >
                            <label>Tipo de tarea</label>
                            <input disabled type="text" class="form-control" id="nombre"  name="nombre" value="<%=estadoTarea.getNombreEstadoTarea()%>">                            
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <%
                                String select = "";
                                if(estadoTarea.getEstadoEstadoTarea()> 0){
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
            $.post('deleteEstadoTarea.jsp',
                    {id: id_menu},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
    });

</script>