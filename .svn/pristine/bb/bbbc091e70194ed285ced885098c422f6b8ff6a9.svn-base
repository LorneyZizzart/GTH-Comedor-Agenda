<%-- 
    Document   : eliminarEmpleado
    Created on : 29/05/2019, 05:46:58 PM
    Author     : pc
--%>
<%@page import="Entidad.Empleado"%>
<jsp:useBean id="_empleado" class="Controlador.EmpleadoController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<% int idEmpleado = 0; 
    String idEncript = request.getParameter("id");  

    Empleado empleado = new Empleado();
    
    try {
        idEmpleado = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        empleado = _empleado.GetEmpleadoByID(idEmpleado);
    }catch (Exception e) {
        idEmpleado = 0;
    }    
%>
<form id="form_guardar" method="post" class="form_guardar">
             <input type="hidden" value="<%=empleado.getEmpleado_id()%>" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input disabled type="text" class="form-control" id="nombre"  name="nombre" placeholder="Nombres" value="<%=_character.CharacterUCFirst(empleado.getNombre())%>">                            
                        </div>  
                        <div class="form-group">
                            <label>Apellido paterno</label>
                            <input disabled type="text" class="form-control" id="apellidoPaterno"  name="apellidoPaterno" placeholder="Apellido paterno" value="<%=_character.CharacterUCFirst(empleado.getApellido_paterno())%>">                            
                        </div>  
                        <div class="form-group">
                            <label>Apellido materno</label>
                            <input disabled type="text" class="form-control" id="apellidoMaterno"  name="apellidoMaterno" placeholder="Apellido materno" value="<%=_character.CharacterUCFirst(empleado.getApellido_materno())%>">                            
                        </div>  
                        <div class="form-group">
                            <label>Correo electrónico</label>
                            <input disabled type="text" class="form-control" id="email"  name="email" placeholder="Email" value="<%=empleado.getEmail()%>">                            
                        </div>  
                        <div class="form-group">
                            <label>Teléfono</label>
                            <input disabled type="text" class="form-control" id="telefono"  name="telefono" placeholder="Teléfono" value="<%=empleado.getTelefono()%>">                            
                        </div> 
                        <div class="form-group">
                            <label>Estado</label>
                            <%
                                String select = "";
                                if(empleado.getEstado() > 0){
                                    select = "checked";
                                }
                            %>
                            <label> <input disabled type="checkbox" name="estado" id="estado"  class="flat-red" <%=select%>></label>
                        </div>
                        <div class="form-group">
                            <label>Estado civil</label>
                            <select disabled name="idEstadoCivil" class="form-control select2" style="width: 100%;">
                                <option value="" selected="selected"><%=empleado.getEstado_civil_Nombre()%></option>     
                            </select>
                        </div>
                        <div class="form-group">
                            <label>País</label>
                            <select disabled name="idPais" class="form-control select2" style="width: 100%;">
                                <option value="" selected="selected"><%=empleado.getPaisNombre()%></option>  
                                
                            </select>
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
            $.post('deleteEmpleado.jsp',
                    {id: id_menu},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
    });

</script>
