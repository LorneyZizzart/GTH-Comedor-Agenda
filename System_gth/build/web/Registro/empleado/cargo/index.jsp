<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Empleado_cargo"%>
<jsp:useBean id="_cargo" class="Controlador.Empleado_cargoController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<%
    String idEncript = request.getParameter("id");  
    int idEmpleado = 0;
    List<Empleado_cargo> listaCargo = new ArrayList<Empleado_cargo>();
    
    try {
        idEmpleado = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        listaCargo = _cargo.GetAllEnpleado_cargoByEmpleadoId(idEmpleado);
    }catch (Exception e) {
        idEmpleado = 0;
    }   
    
%>
<a data-id="<%=idEmpleado%>" class="nuevoCargo btn-purple btn-right_nivel" data-toggle="modal tooltip" data-target="#modal-default" data-placement="bottom" title="Añadir cargo">
<i class="fa fa-plus"></i>
</a> 

 <br>
<br>
<table id="exampleCargo" class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Inicio</th>
                                <th>Final</th>
                                <th>Cargo</th>
                                <th>Grupo</th>
                                <th>Departamento</th>
                                <th>Estado</th>
                                <th style="width: 10%">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int contador = 0;
                                for (Empleado_cargo item : listaCargo) {
                                    contador++;

                            %>
                            <tr>
                                <td><%=contador%></td>
                                <td><%=item.getFecha_inicio()%></td>
                                <td><%=item.getFecha_fin()%></td>
                                <td><%=_character.CharacterUCFirst(item.getCargo_nombre())%></td>
                                <td><%=_character.CharacterUCFirst(item.getNivel_nombre())%></td>
                                <td><%=_character.CharacterUCFirst(item.getDepartamento_nombre())%></td>
                                <td><% if (item.getActivo()== 1) {%><span class="badge bg-green">Activo</span> </td><%} else {%><span class="badge bg-red">Inactivo</span> </td><%}%> 
                                
                                <td class="text-center">
                                    <div class="btn-group ">
                                        <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(item.getId()))%>" class="formEditCargo btn btn-xs btn-primary edit_button" title="Editar"><i class="fa fa-edit"></i></a>                                
                                        <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(item.getId()))%>" class="formEliminarCargo btn btn-danger btn-xs delete_button" title="Eliminar"> <i class="fa fa-trash-o"></i></a>                                
                                    </div>
                                </td>
                        </tr>
                        <%
                            }
                        %>

                        </tbody>
                    </table>
                        
<div class="modal fade" id="formulario_registro_cargo">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close cerrar" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 id="titleModalCargo" class="modal-title">title</h4>
                </div>
                <div class="modal-body cuerpo_registro"></div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
<script>   
    
    $('.nuevoCargo').tooltip({ boundary: 'window' })    
    $('.formEditCargo').tooltip({ boundary: 'window' })
    $('.formEliminarCargo').tooltip({ boundary: 'window' })
    
    $(".nuevoCargo").click(function (e) {
        $(".modal-dialog").width(600);
        $("#titleModal").html("Añadir de cargo");
        e.preventDefault();
        e.stopImmediatePropagation();

        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');

        $.post('cargo/crearCargo.jsp',
                {id: $(this).attr('data-id')},
        function (html) {
            $(".cuerpo_registro").removeClass('loader');
            $(".cuerpo_registro").html(html);
        }
        ).fail(function (jqXHR, textStatus, errorThrown)
        {
            var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
            $(".cuerpo_registro").removeClass('loader');
            $(".cuerpo_registro").html(alerta);
        });

    });
    $(".formEditCargo").click(function (e) {
        $(".modal-dialog").width(600);
        $("#titleModal").html("Editar de cargo");
        e.preventDefault();
        e.stopImmediatePropagation();

        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');

        $.post('cargo/editarCargo.jsp',
                {id: $(this).attr('data-id')},
        function (html) {
            $(".cuerpo_registro").removeClass('loader');
            $(".cuerpo_registro").html(html);
        }
        ).fail(function (jqXHR, textStatus, errorThrown)
        {
            var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
            $(".cuerpo_registro").removeClass('loader');
            $(".cuerpo_registro").html(alerta);
        });

    });
    $(".formEliminarCargo").click(function (e) {
        $(".modal-dialog").width(600);
        $("#titleModal").html("Eliminar de cargo");
        e.preventDefault();
        e.stopImmediatePropagation();

        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');

        $.post('cargo/eliminarCargo.jsp',
                {id: $(this).attr('data-id')},
        function (html) {
            $(".cuerpo_registro").removeClass('loader');
            $(".cuerpo_registro").html(html);
        }
        ).fail(function (jqXHR, textStatus, errorThrown)
        {
            var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
            $(".cuerpo_registro").removeClass('loader');
            $(".cuerpo_registro").html(alerta);
        });

    });
    
</script>