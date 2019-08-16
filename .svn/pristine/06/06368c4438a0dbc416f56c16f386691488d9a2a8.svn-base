<%-- 
    Document   : index
    Created on : 22/05/2019, 09:24:16 AM
    Author     : pc
--%>
<%@page import="Entidad.Departamento"%>
<%@ include file= "../../masterPage/complemento/head.jsp" %> 

<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%    }
%>
<jsp:useBean id="_departamento" class="Controlador.DepartamentoController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<%
    List<Departamento> ListaDepartamento = new ArrayList<Departamento>();
    ListaDepartamento = _departamento.GetAllDepartamento();
%>
<section class="content-header">
    <h1>
        Registro
        <small> de Departamentos</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
        <li class="active">Panel</li>
    </ol>
</section>
<section class="content">
    <div class="row">
        <div class="col-xs-12">            

            <div class="box box-purple">
                <div class="box-header">
                    <h3 class="box-title">Lista de Departamentos</h3>
                    <button id="formNuevo" type="button" class="btn-purple btn-right_nivel" data-toggle="modal tooltip" data-target="#modal-default" data-placement="bottom" title="Añadir nivel">
                        <i class="fa fa-plus"></i>
                    </button>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <table id="example1" class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>#</th>                                
                                <th>Nombre</th>
                                <th>Area</th>
                                <th>Dependiente</th>
                                <th>Fecha de inicio</th>
                                <th>Estado</th>
                                <th style="width: 10%">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int contador = 0;
                                for (Departamento item : ListaDepartamento) {
                                    contador++;

                            %>
                            <tr>
                                <td><%=contador%></td>
                                
                                <td><%=_character.CharacterUCFirst(item.getNombre())%></td>
                                <td><%=item.getArea_Nombre()%></td>
                                
                                <td><% if(!item.getDepartamento_Nombre_dep().equals("0")){
                                    out.print(item.getDepartamento_Nombre_dep());
                                } %></td>
                                <td><%=item.getFecha_creacion()%></td>
                                <td><% if (item.getEstado() == 1) {%><span class="badge bg-green">Activo</span> </td><%} else {%><span class="badge bg-red">Inactivo</span> </td><%}%> 
                                <td class="text-center">
                                    <div class="btn-group ">
                                        <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(item.getDepartamento_id()))%>" class="formEdit btn btn-xs btn-primary edit_button" data-toggle="tooltip" data-placement="bottom" title="Editar"><i class="fa fa-edit"></i></a>                                
                                        <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(item.getDepartamento_id()))%>" class="formEliminar btn btn-danger btn-xs delete_button" data-toggle="tooltip" data-placement="bottom" title="Eliminar"> <i class="fa fa-trash-o"></i></a>                                
                                    </div>
                                </td>
                            </tr>
                            <%
                                }
                            %>

                        </tbody>
                        <tfoot>
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Area</th>
                                <th>Dependiente</th>
                                <th>Fecha de inicio</th>
                                <th>Estado</th>
                                <th>Opciones</th>
                            </tr>
                        </tfoot>
                    </table>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
    <!--Modal-->
    <div class="modal fade" id="formulario_registro">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 id="titleModal" class="modal-title">title</h4>
                </div>
                <div class="modal-body cuerpo_registro">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
</section>
<%@ include file= "../../masterPage/complemento/footer.jsp" %> 
<script>
    $('#formNuevo').tooltip({ boundary: 'window' })
    $('#example').tooltip({ boundary: 'window' })
    $(function () {
        $("#example1").DataTable();
    });   
    
    $(".formEdit").click(function (e){
        $("#titleModal").html("Editar Departamento");
        e.preventDefault();
        e.stopImmediatePropagation();
        
        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        
        $.post('editarDepartamento.jsp',
            {id: $(this).attr('data-id')},
                    function (html) {
                    $(".cuerpo_registro").removeClass('loader');
                    $(".cuerpo_registro").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $(".cuerpo_registro").removeClass('loader');
                $(".cuerpo_registro").html(alerta);
            });
        
    })
    $(".formEliminar").click(function (e){
        $("#titleModal").html("Eliminar Departamento");
        e.preventDefault();
        e.stopImmediatePropagation();
        
        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        
        $.post('eliminarDepartamento.jsp',
            {id: $(this).attr('data-id')},
                    function (html) {
                    $(".cuerpo_registro").removeClass('loader');
                    $(".cuerpo_registro").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $(".cuerpo_registro").removeClass('loader');
                $(".cuerpo_registro").html(alerta);
            });
        
    })
    
    $("#formNuevo").click(function (e) {
        $("#titleModal").html("Crear Departamento");
        e.preventDefault();
        e.stopImmediatePropagation();
            $('#formulario_registro').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('crearDepartamento.jsp',
            {id: $(this).attr('data-id')},
                    function (html) {
                    $(".cuerpo_registro").removeClass('loader');
                    $(".cuerpo_registro").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $(".cuerpo_registro").removeClass('loader');
                $(".cuerpo_registro").html(alerta);
            });
    });
</script>