<%@page import="Entidad.Cuestionario_gestion"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_ciclo" class="Controlador.Cuestionario_gestionController" />
<%
    int idUsuario = 0, idCiclo = 0;

    String idCicloEncript =  request.getParameter("id");
    Cuestionario_gestion ciclo = new Cuestionario_gestion();
    try{
        idCiclo = Integer.parseInt(_encript.ValorADesencriptar(idCicloEncript));
        ciclo = _ciclo.GetCuestionario_gestionById(idCiclo);
        
    }catch(Exception e){
        idUsuario = 0;
    }
%>
<form id="form_guardar" method="post" class="form_guardar">
    <input type="hidden" value="<%=idCiclo%>" name="id" id="id">
    <input type="hidden" value="<%=idUsuario%>" name="idUsuario" id="idUsuario">
                    <div class="box-body">
                         <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" class="form-control" id="nombre"  name="nombre" value="<%=ciclo.getNombre()%>">                            
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <%
                                String select = "";
                                if(ciclo.getEstado() > 0){
                                    select = "checked";
                                }
                            %>
                            <label> <input type="checkbox" name="estado" id="estado"  class="flat-red" <%=select%>></label>
                        </div>
                        <div class="form-group">
                            <label>Descripción</label>
                            <textarea class="form-control" rows="3" id="descripcion"  name="descripcion" ><%=ciclo.getDescripciom()%></textarea>
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
            $.post('deleteCiclo.jsp',
                    {id: id_menu},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
    });
</script>