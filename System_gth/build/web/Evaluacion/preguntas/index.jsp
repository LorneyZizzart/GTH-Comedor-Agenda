<%@page import="Entidad.Cuestionario"%>
<%@page import="Entidad.Tipo"%>
<%@page import="Entidad.Pregunta"%>
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
<jsp:useBean id="_pregunta" class="Controlador.PreguntaController" />
<jsp:useBean id="_tipóPregunta" class="Controlador.TipoController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_cuestionario" class="Controlador.CuestionarioController" />
<%
    String idEncript = request.getParameter("c").replace(" ", "+");
    int idCuestionario = 0, idPregunta = 0;
    List<Pregunta> listaPreguntas = new ArrayList<Pregunta>();
    List<Tipo> listaTipoPregunta = new ArrayList<Tipo>();
    listaTipoPregunta = _tipóPregunta.GetAllTipo();
    Cuestionario cuestionario = new Cuestionario();
    try {
        idCuestionario = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        listaPreguntas = _pregunta.GetAllPreguntaByCuestionarioId(idCuestionario);
        cuestionario = _cuestionario.GetCuestionariobyCuestionario_id(idCuestionario);
    } catch (Exception e) {
        idCuestionario = 0;
    }
%>
<section class="content-header">
    <h1>
        <%=cuestionario.getNombre()%>
        <small> Cuestionario</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="../../masterPage/complemento/index.jsp"><i class="fa fa-home"></i> Home</a></li>
        <li><a href="../Cuestionario/index.jsp"><i class="fa fa-th-list"></i> Lista de cuentas</a></li>
        <li class="active">Preguntas</li>
    </ol>
</section>
<section class="content">

    <div class="row">
        <div class="col-md-3">        
            <form id="form_guardar" method="post" class="form_guardar">
                <input type="hidden" value="<%=_encript.ValorAEncriptar(Integer.toString(idCuestionario))%>" name="idCuestionario" id="idCuestionario">
                <input type="hidden" value="<%=_encript.ValorAEncriptar(Integer.toString(idPregunta))%>" name="idPregunta" id="idPregunta">
                <input type="hidden" value="<%=_encript.ValorAEncriptar(Integer.toString(DatoUsuario.getUser_id()))%>" name="idUsuario" id="idUsuario">
                <div class="box box-purple">
                    <div id="mensaje"></div> 
                    <div class="box-body box-profile">
                        <div class="form-group">
                            <label>Tipo</label>
                            <select name="idTipo" class="form-control select2" style="width: 100%;">
                                <option>Selecione una opción</option>
                                <%
                                    for (Tipo item : listaTipoPregunta) {
                                %>
                                <option value="<%=item.getTipo_id()%>"><%=item.getNombre()%></option>
                                <% }%>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Pregunta</label>
                            <input type="text" class="form-control" id="pregunta"  name="pregunta" value="">                            
                        </div>                  
                        <div class="form-group">
                            <label>Orden</label>
                            <input type="text" class="form-control" id="orden"  name="orden" value="">                            
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <label><input type="checkbox" name="estado" id="estado"  class="flat-red"></label>
                        </div>
                        <button type="submit" class="btn-purple btn-block"><i class="fa fa-plus"></i><b> Agregar pregunta</b></button>

                    </div>
                    <!-- /.box-body -->
                </div>
            </form>

        </div>
        <!-- /.col -->
        <div class="col-md-9">
            <div class="box box-purple">
                <div class="box-header with-border">
                    <h3 class="box-title">Lista de preguntas</h3>

                    <div class="box-tools pull-right btn-enviar">
                        <a href="../EnviarCuestionario/index.jsp?e=<%=_encript.ValorAEncriptar(Integer.toString(cuestionario.getCuestionario_id()))%>" class="btn-purple"><i class="fa fa-paper-plane"></i> Enviar</a>
                    </div>
                    <!-- /.box-tools -->
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <table id="exampleCargo" class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Tipo</th>
                                <th>Pregunta</th>
                                <th>Orden</th>
                                <th>Estado</th>
                                <th style="width: 10%">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int contador = 0;
                                for (Pregunta item : listaPreguntas) {
                                    contador++;
                            %>
                            <tr>
                                <td><%=contador%></td>
                                <td><%=item.getNombre_tipo_id()%></td>
                                <td><%=item.getNombre()%></td>
                                <td><%=item.getOrden()%></td>
                                <td><% if (item.getEstado() == 1) {%><span class="badge bg-green">Activo</span> </td><%} else {%><span class="badge bg-red">Inactivo</span> </td><%}%> 
                        <td class="text-center">
                            <div class="btn-group ">
                                <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(item.getPregunta_id()))%>" class="formEdit btn btn-xs btn-primary edit_button" data-toggle="tooltip" data-placement="bottom" title="Editar"><i class="fa fa-edit"></i></a>                                
                                <a data-id="<%=item.getPregunta_id()%>" class="formDelet btn btn-danger btn-xs delete_button" data-toggle="tooltip" data-placement="bottom" title="Eliminar"> <i class="fa fa-trash-o"></i></a>                                
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
                                <th>Tipo</th>
                                <th>Pregunta</th>
                                <th>Orden</th>
                                <th>Estado</th>
                                <th>Opciones</th>
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
    $(function () {
        $('.select2').select2();
        $("#exampleCargo").DataTable();

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
                idTipo: {
                    message: 'El tipo de pregunta no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Debe seleccionar un tipo de pregunta. '
                        }
                    }
                },
                pregunta: {
                    message: 'La pregunta no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'La pregunta no puede ser vacio. '
                        },
                        stringLength: {
                            min: 6,
                            max: 100,
                            message: 'El Nombre tiene que ser mas de 6 y menos de 100 caracteres'
                        }
                    }
                },
                orden: {
                    message: 'El valor del orden no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El valor del orden no puede ser vacio.'
                        },
                        stringLength: {
                            min: 1,
                            max: 3,
                            message: 'El valor del orden tiene que ser de 1 a 3 caracteres.'
                        },
                        integer: {
                            message: 'El valor tiene que ser un número.'
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
                url: "guardarPregunta.jsp",
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

    $(".formEdit").click(function (e) {
        $("#titleModal").html("Editar pregunta");
        e.preventDefault();
        e.stopImmediatePropagation();

        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        var idUser = $("#idUsuario").val();
        $.post('editarPregunta.jsp',
                {id: $(this).attr('data-id'), idUser: idUser, idCuestionario: $("#idCuestionario").val()},
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
    $(".formDelet").click(function (e) {
        $("#titleModal").html("Eliminar pregunta");
        e.preventDefault();
        e.stopImmediatePropagation();

        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        var idUser = $("#idUsuario").val();
        $.post('eliminarPregunta.jsp',
                {id: $(this).attr('data-id'), idUser: idUser},
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