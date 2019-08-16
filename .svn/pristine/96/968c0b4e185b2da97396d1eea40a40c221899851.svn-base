<%-- 
    Document   : eliminarCliente
    Created on : 29/05/2019, 09:59:36 AM
    Author     : pc
--%>
<%@page import="Entidad.Cliente"%>
<jsp:useBean id="_cliente" class="Controlador.ClienteController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    String idEncript = request.getParameter("id");
    int idCliente = 0;
    Cliente cliente = new Cliente();    

    try {
        idCliente = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        cliente = _cliente.getClienteByClienteId(idCliente);
    }catch (Exception e) {
        idCliente = 0;
    }
%>
<form id="form_guardar" method="post" class="form_guardar">
    <input type="hidden" value="<%=cliente.getCliente_id()%>" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input disabled type="text" class="form-control" id="nombre"  name="nombre" placeholder="Ingresar nombre" value="<%=cliente.getNombre()%>">                            
                        </div>  
                        <div class="form-group">
                            <label>Email</label>
                            <input disabled type="email" class="form-control" id="email" name="email" placeholder="Correo electrónico" value="<%=cliente.getCorreo()%>">
                        </div>  
                        <div class="form-group">
                            <label>Teléfono</label>
                            <input disabled type="text" class="form-control" id="telefono"  name="telefono" placeholder="Teléfono" value="<%=cliente.getTelefono()%>">                            
                        </div>                      
                        <div class="form-group">
                            <label>Estado</label>
                            <%
                                String select = "";
                                if(cliente.getEstado() > 0){
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
        $(".btn_eliminar").click(function () {
            var id_menu = $("#id").val();
            $("#mensaje").show();
            $("#mensaje").addClass("loader");
            $.post('deleteCliente.jsp',
                    {id: id_menu},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
    });

</script>
