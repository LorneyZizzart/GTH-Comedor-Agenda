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
<jsp:useBean id="_cuestionarioGestion" class="Controlador.Cuestionario_gestionController" />
<%
    int idUsuario = 0, idCiclo = 0;
    String idEncript = request.getParameter("idUser");
    String opcion = "registrar";
    List<View_Empleado_Gestion> listaEmpleado = new ArrayList<View_Empleado_Gestion>();
    listaEmpleado =  _cuestionarioGestion.GetAllEmpleadoGestion();
    
    try{
        idUsuario = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        
    }catch(Exception e){
        idUsuario = 0;
    }
%>
<section class="content-header">
    <h1>
        Crear
        <small> ciclo</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="../../masterPage/complemento/index.jsp"><i class="fa fa-home"></i> Home</a></li>
        <li><a href="./index.jsp"><i class="fa fa-th-list"></i> Lista de ciclos</a></li>
        <li class="active">Crear ciclo</li>
    </ol>
</section>
<section class="content">

    <div class="row">
        <form id="form_guardar" method="post" class="form_guardar">
        <div class="col-md-3">    
                <input type="hidden" value="<%=opcion%>" name="opcion" id="opcion">
                <input type="hidden" value="<%=_encript.ValorAEncriptar(Integer.toString(idCiclo))%>" name="id" id="id">
                <input type="hidden" value="<%=_encript.ValorAEncriptar(Integer.toString(DatoUsuario.getUser_id()))%>" name="idUsuario" id="idUsuario">
                <div class="box box-purple">
                    <div id="mensaje"></div> 
                    <div class="box-body box-profile">
                       <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" class="form-control" id="nombre"  name="nombre">                            
                        </div>
                        <div class="form-group">
                            <label>Descripción</label>
                            <textarea class="form-control" rows="3" id="descripcion"  name="descripcion"></textarea>
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="checkbox" name="estado" id="estado"  class="flat-red">
                        </div>
                        <button type="submit" class="btn-purple btn-block btn-guardar-ciclo"><i class="fa fa-save"></i><b> Guardar</b></button>

                    </div>
                    <!-- /.box-body -->
                </div>
        </div>
        <!-- /.col -->
        <div class="col-md-9">
            <div class="box box-purple">
                <div class="box-header with-border">
                    <h3 class="box-title">Lista de funcionarios</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive table-funcionario">
                    
                    <table id="exampleCargo" class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Nombre completo</th>
                                <th>Departamento</th>
                                <th>Cargo</th>
                                <th class="text-right" style="width: 10%"><button type="button" class="btn btn-default btn-sm checkbox-toggle" data-toggle="tooltip" title="Marcar todos"><i class="fa fa-square-o"></i>
                                </button></th>
                            </tr>                           
                        </thead>
                        <tbody>
                            <%
                                int contador = 0;
                                for(View_Empleado_Gestion item : listaEmpleado){
                                    contador++;
                            %>
                            <tr>
                                <td class="text-center"><%=contador%> <input type="hidden" name="posicion_celda" value="<%=contador%>" class="posicion_celda"> </td>
                                <input hidden>   
                                <td><input hidden value="<%=item.getEmpleado_id()%>" name="idEmpleado<%=contador%>" id="idEmpleado<%=contador%>"><%=item.getNombre_empleado()%></td>
                                <td><%=item.getNombre_departamento()%></td>
                                <td><%=item.getNombre_cargo()%></td>
                                <td class="text-center"><input class="selectEmpleado<%=contador%>" name="agregarEmpleado" id="agregarEmpleado" type="checkbox" data-toggle="tooltip" data-placement="left" title="Marcar"></td>
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
    </form>
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
    
    
    $(function () {
        $('.select2').select2();
        $("#exampleCargo").DataTable();
    });
 
    $(document).ready(function () {
        var jsonEmpleados = {};
        var array = [];
        var empleado = [];
        $(".btn-guardar-ciclo").click(function (){
        
         var valor = $(".posicion_celda").each(function () {
            var id = $(this).val();
            array.push(id);
        });
        array.forEach(function (element) {
            if( $('.selectEmpleado'+element).prop('checked') ) {
               empleado.push({
                    "idEmpleado" :  $('#idEmpleado' + element).val()
                });
            }
        });
        
        jsonEmpleados.idCiclo = $("#id").val();
        jsonEmpleados.idUsuairo = $("#idUsuario").val();
        jsonEmpleados.nombreCuestionario = $("#nombre").val();
        jsonEmpleados.descripcion = $("#descripcion").val();
        jsonEmpleados.estado = $("#estado").is(":checked");
        jsonEmpleados.empleados = empleado;
        var jsonString = JSON.stringify(jsonEmpleados);
        console.log(jsonString);
        
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
                            min: 6,
                            max: 100,
                            message: 'El Nombre tiene que ser mas de 6 y menos de 100 caracteres'
                        },
                        regexp: {
                            regexp: /^([-a-z()0-9_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛÝàáâãèéìíñòóùúûü-\s])+$/i,
                            message: 'El nombre de usuario solo puede constar de letras, números y guiones bajos.'
                        }
                    },
                descripcion:{
                    message: 'La descripción no es valido.',
                    validators: {
                        stringLength: {
                            min: 0,
                            max: 550,
                            message: 'La descripción tiene que ser mas de 0 y menos de 550 caracteres'
                        }
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
                url: "guardarCiclo.jsp",
                data: {"Object" :jsonString},
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
        
        
    });

</script>