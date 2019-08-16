<%@page import="Entidad.Feedback"%>
<%@page import="Entidad.Login_Entidad"%>
<%@page import="Entidad.Feedback_tipo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="_feedback" class="Controlador.FeedbackController" />

<%
    int retroalimetacion_id = 0;
    String retro_id = request.getParameter("id");
    retroalimetacion_id = Integer.parseInt(retro_id);

    //out.print(retro_id);
    HttpSession sesion = request.getSession();
    Login_Entidad DatoUsuario = new Login_Entidad();
    List<Feedback_tipo> feedbacks = new ArrayList<Feedback_tipo>();
    feedbacks = _feedback.get_All_TiposAdventendia();
    DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");

    Feedback datos = new Feedback();
    try {
        datos = _feedback.Get_feedback_by_id(retroalimetacion_id);
    } catch (Exception e) {
        out.print(e.getMessage());
    }


%>


<form class="form-horizontal form_create_retoralimentacion"> 
    <input type="hidden" id ="admin_id" name="admin_id" value="<%=DatoUsuario.getEmpleado_id()%>">
    <input type="hidden" id ="emple_id" name="emple_id">
    <input type="hidden" id ="feedback_id" name="feedback_id" value="<%=retroalimetacion_id%>">

    <div class="form-group">
        <label for="inputName" class="col-sm-2 control-label">Tipo Feedback</label>
        <div class="col-sm-10">
            <select class="form-control" id="retro_tipo_adver" name="retro_tipo_adver">
                <option value=""></option>
                <%
                    for (Feedback_tipo fe : feedbacks) {
                        String select = "";
                        if (datos.getFeedback_tipo_id() == fe.getFeedback_tipo_id()) {
                            select = "selected";
                        }

                %>
                <option value="<%=fe.getFeedback_tipo_id()%>" <%=select%>><%=fe.getNombre()%></option>
                <%
                    }
                %>

            </select>
        </div>
    </div>

    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Motivo</label>
        <div class="col-sm-10">
            <input type="text" class="form-control"  id="retro_motivo" name="retro_motivo" placeholder="Motivo" value="<% if (datos.getMotivo() != null) {
                    out.print(datos.getMotivo());
                }%>">
        </div>
    </div>

    <div class="form-group">
        <label for="inputName" class="col-sm-2 control-label">Fecha</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="retro_fecha" name="retro_fecha" placeholder="Fecha" value="<%if (datos.getFecha_advertencia() != null) {
                    out.print(datos.getFecha_advertencia());
                }%>">
        </div>
    </div>

    <div class="form-group">
        <label for="inputExperience" class="col-sm-2 control-label">Descripción</label>
        <div class="col-sm-10">
            <textarea class="form-control retro_descripcion" id="retro_descripcion" name="retro_descripcion" placeholder="Descripción"><%if (datos.getDescripcion() != null) {
                    out.print(datos.getDescripcion());
                }%></textarea>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-purple">Guardar</button>
        </div>
    </div>
    <div class="form-group">
        <div id="mensaje_guarda_nota"></div>
    </div>
</form>
<script src="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>

<script type="text/javascript">
    $(function () {
        $(".retro_descripcion").wysihtml5();
    });
    
    var valor = $('#idEmpleado_id').val();
    $('#emple_id').val(valor);

    $('#retro_fecha').datepicker({
        autoclose: true,
    });//.datepicker("setDate", new Date());

    //$('#retro_fecha').data("Datepicker").show();

    $(document).ready(function () {
        $('.form_create_retoralimentacion').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                retro_motivo: {
                    message: 'Motivo no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Motivo no puede ser vacio. '
                        },
                        stringLength: {
                            min: 3,
                            max: 100,
                            message: 'El motivo tiene que ser mas de 3 y menos de 100 caracteres'
                        }
                    }
                },
                retro_fecha: {
                    message: 'Fecha no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Motivo no puede ser vacio. '
                        },
                        date: {
                            format: 'DD/MM/YYYY',
                            message: 'Fecha no valida, formto(dd/mm/yyyy)'
                        }
                    }
                },
                retro_descripcion: {
                    message: 'Descripción no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Descripción no puede ser vacio. '
                        }
                    }
                },
                retro_tipo_adver: {
                    message: 'Tipo Advertencia no valido.',
                    validators: {
                        notEmpty: {
                            message: 'Descripción no puede ser vacio. '
                        },
                        notEmpty: {
                            message: 'Debe seleccionar Tipo Advertencia. '
                        }
                    }
                }
            }
        }).on('success.form.bv', function (e) {
            // Prevent submit form
            e.preventDefault();
            $("#mensaje_guarda_nota").show();
            $("#mensaje_guarda_nota").addClass("loader");


            var $form = $(e.target),
                    validator = $form.data('bootstrapValidator');
            $.ajax({
                type: "POST",
                url: "retro_alimentacion/guarda_retroalimentacion.jsp",
                data: $(".form_create_retoralimentacion").serialize(),
                success: function (data)
                {
                    $("#mensaje_guarda_nota").removeClass("loader");
                    $("#mensaje_guarda_nota").html(data);
                }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $("#mensaje_guarda_nota").removeClass("loader");
                    var menn = "<p class='text-red'>Se produjo un error " + errorThrown + "  " + textStatus + "</p>";
                    $("#mensaje_guarda_nota").html(menn);
                }
            });
        });
    });

</script>