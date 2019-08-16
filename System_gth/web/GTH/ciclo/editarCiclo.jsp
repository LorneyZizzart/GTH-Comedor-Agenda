<%@page import="Entidad.Cuestionario_gestion"%>
<%@page import="Entidad.View_Empleado_Gestion"%>
<%@ include file= "../../masterPage/complemento/head.jsp" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<% DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");
    }
%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_ciclo" class="Controlador.Cuestionario_gestionController" />
<%
    int idCiclo = 0;
    String idEncriptCiclo = request.getParameter("c").replace(" ", "+");
    String opcion = "editar";
    List<View_Empleado_Gestion> listaEmpleado = new ArrayList<View_Empleado_Gestion>();
    System.out.print("id: "+idEncriptCiclo);
    Cuestionario_gestion ciclo = new Cuestionario_gestion();
    try{
        idCiclo = Integer.parseInt(_encript.ValorADesencriptar(idEncriptCiclo));
        ciclo = _ciclo.GetCuestionario_gestionById(idCiclo);

    }catch(Exception e){
        idCiclo = 0;
    }
%>
<section class="content-header">
    <h1>
        Editar
        <small> ciclo</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="../../masterPage/complemento/index.jsp"><i class="fa fa-home"></i> Home</a></li>
        <li><a href="./index.jsp"><i class="fa fa-th-list"></i> Lista de ciclos</a></li>
        <li class="active">Editar ciclo</li>
    </ol>
</section>
<section class="content">

    <div class="row">
        
        <div class="col-md-3"> 
            <form id="form_guardar" method="post" class="form_guardar">
                <input type="hidden" value="<%=opcion%>" name="opcion" id="opcion">
                <input type="hidden" value="<%=idCiclo%>" name="id" id="id">
                <input type="hidden" value="<%=_encript.ValorAEncriptar(Integer.toString(DatoUsuario.getUser_id()))%>" name="idUsuario" id="idUsuario">
                <div class="box box-purple">
                    <div id="mensaje"></div> 
                    <div class="box-body box-profile">
                       <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" class="form-control" id="nombre"  name="nombre" value="<%=ciclo.getNombre()%>">                            
                        </div>
                        <div class="form-group">
                            <label>Descripción</label>
                            <textarea class="form-control" rows="3" id="descripcion"  name="descripcion"><%=ciclo.getDescripciom()%></textarea>
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <%
                                String select = "";
                                if(ciclo.getEstado() > 0){
                                    select = "checked";
                                }
                            %>
                            <input type="checkbox" name="estado" id="estado"  class="flat-red" <%=select%>>
                        </div>
                        <button type="submit" class="btn-purple btn-block "><i class="fa fa-refresh"></i><b> Actualizar</b></button>

                    </div>
                    <!-- /.box-body -->
                </div>
            </form>
        </div>
        <!-- /.col -->
        <div class="col-md-9">
            <div class="box box-purple">
                <div class="box-header with-border">
                    <h3 class="box-title">Lista de funcionarios</h3>
                    <a data-id="<%=idEncriptCiclo%>" class="btn-purple pull-right formAgregar" data-toggle="modal tooltip" data-target="#modal-default" data-placement="bottom" title="Añadir empleado">
                        <i class="fa fa-plus"></i>
                    </a>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive table-funcionario">
                    
                    <table id="example1" class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Nombre completo</th>
                                <th>Departamento</th>
                                <th>Cargo</th>
                                <th class="text-right" style="width: 10%">Opción</th>
                            </tr>                           
                        </thead>
                        <tbody>
                            <%
                                int contador = 0;
                                for(View_Empleado_Gestion item : ciclo.getEmpleados()){
                                    contador++;
                            %>
                            <tr>
                                <td class="text-center"><%=contador%></td>

                                <td><%=item.getNombre_empleado()%></td>
                                <td><%=item.getNombre_departamento()%></td>
                                <td><%=item.getNombre_cargo()%></td>
                                <td class="text-center">
                                    <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(item.getCuestionario_gestion_empleado_id()))%>" class="formEliminarEmpleado btn btn-danger btn-xs delete_button" data-toggle="tooltip" data-placement="bottom" title="Eliminar"> <i class="fa fa-times"></i></a>  
                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                        <tfoot>
                            <tr>
                                <th>#</th>
                                <th>Nombre completo</th>
                                <th>Departamento</th>
                                <th>Cargo</th>
                                <th class="text-center">Marcar</th>
                            </tr>
                        </tfoot>
                    </table>
                </div>
                <div class="box-footer no-padding">
                    
                </div>
            </div>
        </div>
    
    </div>
<div class="modal fade" id="formulario_registro">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 id="titleModal" class="modal-title">title</h4>
                </div>
                <div class="modal-body cuerpo_registro"></div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
</section>
<%@ include file= "../../masterPage/complemento/footer.jsp" %> 
<script type="text/javascript"> 
    $('#formNuevo').tooltip({ boundary: 'window' })
    $(function () {
        $("#example1").DataTable();
    });
    $(document).ready(function () {
        $('.form_guardar').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                nombre:{
                    message: 'El nombre no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El nombre no puede ser vacio. '
                        },
                        stringLength: {
                            min: 3,
                            max: 50,
                            message: 'El Nombre tiene que ser mas de 3 y menos de 50 caracteres'
                        },
                        regexp: {
                            regexp: /^([-a-z()0-9_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛÝàáâãèéìíñòóùúûü-\s])+$/i,
                            message: 'El nombre de usuario solo puede constar de letras, números y guiones bajos.'
                        }
                    }
                }
            }
        }).on('success.form.bv', function (e) {
            // Prevent submit form
            e.preventDefault();
            $("#mensaje").show();
            $("#mensaje").addClass("loader");


            var $form = $(e.target),
                    validator = $form.data('bootstrapValidator');
            $.ajax({
                type: "POST",
                url: "guardarEditarCiclo.jsp",
                data: $(".form_guardar").serialize(),
                success: function (data)
                {
                    $("#mensaje").removeClass("loader");
                    $("#mensaje").html(data);
                }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $("#mensaje").removeClass("loader");
                    var menn = "<p class='text-red'>Se produjo un error " + errorThrown + "  " + textStatus + "</p>";
                    $("#mensaje").html(menn);
                }
            });
        });
    });
    $(".formAgregar").click(function (e) {
        $(".modal-dialog").width("55%");
        $("#titleModal").html("Lista de empleados");
        e.preventDefault();
        e.stopImmediatePropagation();

        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');

        $.post('listaEmpleado.jsp',
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
    $(".formEliminarEmpleado").click(function () {
            $("#mensaje").show();
            $("#mensaje").addClass("loader");
            $.post('eliminarEmpleado.jsp',
                    {id: $(this).attr('data-id')},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
</script>