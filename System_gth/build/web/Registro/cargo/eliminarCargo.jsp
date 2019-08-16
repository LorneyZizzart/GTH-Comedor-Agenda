<%@page import="Entidad.Cargo"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_cargo" class="Controlador.CargoController" />
<% 
    int idCargo = 0;
    String idEncript = request.getParameter("id"); 
    Cargo cargo = new Cargo();
    try {
        idCargo = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        cargo = _cargo.getCargoByCargoId(idCargo);
    }catch (Exception e) {
        idCargo = 0;
    } 
%>
<form id="form_guardar" method="post" class="form_guardar">
    <input type="hidden" value="<%=idCargo%>" name="id" id="id">
    
                    <div class="box-body">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input disabled type="text" class="form-control" id="nombre" name="nombre" value="<%=cargo.getNombre()%>">                            
                        </div> 
                        <div class="form-group">
                            <label>Descripción</label>
                            <textarea disabled class="form-control" rows="3" id="descripcion"  name="descripcion"><%=cargo.getDescripcion()%></textarea>                     
                        </div> 
                        <div class="form-group">
                            <label>Estado</label>
                            <%
                                String select = "";
                                if(cargo.getEstado() > 0){
                                    select = "checked";
                                }
                            %>
                            <input disabled type="checkbox" name="estado" id="estado"  class="flat-red" <%=select%>>           
                        </div>
                    </div>

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
            $.post('deleteCargo.jsp',
                    {id: id_menu},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
    });

</script>