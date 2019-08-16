<%-- 
    Document   : editarDepartamento
    Created on : 22/05/2019, 09:24:45 AM
    Author     : Jhonny
--%>
<%@page import="Entidad.Usuario"%>
<jsp:useBean id="_usuario" class="Controlador.UsuarioController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    String idEncript = request.getParameter("id");
    int idUsuario = 0;
    Usuario usuario = new Usuario();   
    
    try {
        idUsuario = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        usuario = _usuario.GetDatosParaActualizarByUser_id(idUsuario);
    }catch (Exception e) {
        idUsuario = 0;
    }
%>
         <form id="form_guardar" method="post" class="form_guardar">
             <input type="hidden" value="<%=idUsuario%>" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Empleado</label>
                            <select disabled class="form-control select2" style="width: 100%;">
                                <option value=""><%=usuario.getNombre()%></option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Nombre Usuario</label>
                            <input type="text" class="form-control" value="<%=usuario.getUsuario()%>" disabled>                            
                        </div>                        
                        <div class="form-group">
                            <label>Estado</label>
                            <%
                                String select = "";
                                if(usuario.getEstado() > 0){
                                    select = "checked";
                                }
                            %>
                            <label> <input disabled type="checkbox" name="estado" id="estado"  class="flat-red" <%=select%>></label>
                        </div>
                        <div class="form-group">
                            <label>Perfil</label>
                            <input type="text" class="form-control" value="<%=usuario.getPerfil()%>" disabled>                            
                        </div> 
                        <div class="form-group">
                            <label>Email</label>
                            <input type="email" class="form-control" value="<%=usuario.getEmail()%>" disabled>
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
            $.post('deleteUsuario.jsp',
                    {id: id_menu},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
    });
</script>
