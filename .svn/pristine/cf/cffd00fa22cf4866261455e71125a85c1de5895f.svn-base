<%@page import="java.util.*"%>
<%@page import="Entidad.Pregunta"%>
<%@page import="Entidad.Tipo"%>
<jsp:useBean id="_pregunta" class="Controlador.PreguntaController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_tipoPregunta" class="Controlador.TipoController" />
<%
    String idPreguntaEncript = request.getParameter("id");
    String idUsuarioEncript = request.getParameter("idUser");
    String idCuestionariooEncript = request.getParameter("idCuestionario");
    
    List<Tipo> listaTipoPregunta = new ArrayList<Tipo>();
    listaTipoPregunta = _tipoPregunta.GetAllTipo();

    int idPregunta = 0;
    Pregunta pregunta = new Pregunta();    

    try {
        idPregunta = Integer.parseInt(_encript.ValorADesencriptar(idPreguntaEncript));
        pregunta = _pregunta.GetPreguntaByPregunta_Id(idPregunta);
    }catch (Exception e) {
        idPregunta = 0;
    }
%>
<form id="form_editar" method="post" class="form_editar">
    <input type="hidden" value="<%=idCuestionariooEncript%>" name="idCuestionario" id="idCuestionario">
    <input type="hidden" value="<%=idPreguntaEncript%>" name="idPregunta" id="idPregunta">
    <input type="hidden" value="<%=idUsuarioEncript%>" name="idUsuario" id="idUsuario">
            <div class="box-body">
               <div class="form-group">
                <label>Tipo</label>
                <select name="idTipo" class="form-control select2" style="width: 100%;">
                  <option>Selecione una opciÛn</option>
                    <%
                    for (Tipo item : listaTipoPregunta) {
                        String Select = "";
                        if(item.getTipo_id() == pregunta.getTipo_id())
                            Select = "Selected";
                    %>
                    <option value="<%=item.getTipo_id()%>" <%=Select%>><%=item.getNombre()%></option>
                    <% } %>
                </select>
              </div>
                <div class="form-group">
                   <label>Pregunta</label>
                   <input type="text" class="form-control" id="pregunta"  name="pregunta" value="<%=pregunta.getNombre()%>">                            
                </div>                  
                <div class="form-group">
                   <label>Orden</label>
                   <input type="text" class="form-control" id="orden"  name="orden" value="<%=pregunta.getOrden()%>">                            
                </div>
                <div class="form-group">
                    <label>Estado</label>
                    <%
                     String select = "";
                      if(pregunta.getEstado() > 0){
                          select = "checked";
                      }
                    %>
                     <label> <input type="checkbox" name="estado" id="estado"  class="flat-red" <%=select%>></label>
                </div>
                    </div>
                    <div class="box-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
                        <button type="submit" class="btn btn-primary pull-right"><i class="fa fa-refresh"></i> Actualizar</button>
                    </div>
 </form>
<div id="mensajeEditar"></div>

    <script type="text/javascript">
    $(document).ready(function () {
        $('.form_editar').bootstrapValidator({
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
                pregunta:{
                    message: 'La pregunta no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'La pregunta no puede ser vacio. '
                        },
                        stringLength: {
                            min: 6,
                            max: 100,
                            message: 'El Nombre tiene que ser mas de 6 y menos de 100 caracteres'
                        },
                        regexp: {
                            regexp: /^([-a-z()0-9_-¿¡¬√»… ÃÕ—“”‘Ÿ⁄€›‡·‚„ËÈÏÌÒÚÛ˘˙˚¸ø?-\s])+$/i,
                            message: 'La pregunta solo puede constar de letras, n˙meros y guiones bajos.'
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
                            message: 'El valor tiene que ser un n˙mero.'
                        }
                    }
                }
            }
        }).on('success.form.bv', function (e) {
            // Prevent submit form
            e.preventDefault();
            $("#mensajeEditar").show();
            $("#mensajeEditar").addClass("loader");


            var $form = $(e.target),
                    validator = $form.data('bootstrapValidator');
            $.ajax({
                type: "POST",
                url: "guardarPregunta.jsp",
                data: $(".form_editar").serialize(),
                success: function (data)
                {
                    $("#mensajeEditar").removeClass("loader");
                    $("#mensajeEditar").html(data);
                }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $("#mensajeEditar").removeClass("loader");
                    var menn = "<p class='text-red'>Se produjo un error " + errorThrown + "  " + textStatus + "</p>";
                    $("#mensajeEditar").html(menn);
                }
            });
        });

    });


</script>