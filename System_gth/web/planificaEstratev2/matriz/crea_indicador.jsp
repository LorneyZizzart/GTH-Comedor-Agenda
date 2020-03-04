<%@page import="Entidad.Plan_indica_resultado"%>
<%@page import="Entidad.Plan_estado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="pla_esta" class="Controlador.Plan_estadoController" />
<jsp:useBean id="ver_inidicador" class="Controlador.Plan_indica_resultadoController" />
<%
    String indicador = request.getParameter("indicador");
    String plan_Accion = request.getParameter("id_pla_ac");
    String subob = request.getParameter("sub_obje");
    String matriz = request.getParameter("matrizid");

    List<Plan_estado> estados = new ArrayList<Plan_estado>();
    estados = pla_esta.GetAllEstado();

    Plan_indica_resultado indicador_ver = new Plan_indica_resultado();

    indicador_ver = ver_inidicador.GetIndicadorById(indicador);

%>

<form class="form-horizontal form_indicador_nuevo">
    <input type="hidden" name="indicador_id" id="indicador_id" value="<%=indicador%>">
    <input type="hidden" name="matriz_id" id="matriz_id" value="<%=matriz%>">
    <input type="hidden" name="subob_id" id="subob_id" value="<%=subob%>">
    <input type="hidden" name="encri_plan_Accion" id="encri_plan_Accion" value="<%=plan_Accion%>">

    <div class="box-body">
        <div class="form-group">
            <label class="col-sm-2 control-label">Nombre: </label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="indi_nombre" name="indi_nombre" placeholder="Nombre" required value="<% if(indicador_ver.getNombre()!=null){out.print(indicador_ver.getNombre() );}%>">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Fecha</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" data-date-format='dd/mm/yyyy'  id="indi_fecha" name="indi_fecha" placeholder="dd/mm/yyyy" value="<% if(indicador_ver.getFecha()!=null){out.print(indicador_ver.getFecha() );}%>" required>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Indicador</label>

            <div class="col-sm-10" >
                <select class="form-control" id="indi_rango" name="indi_rango" required>
                    <%
                        for (Plan_estado e : estados) {
                            String Select = "";
                            if (indicador_ver.getPlan_estado_id() == e.getPlan_estado_id()) {
                                Select = "selected";
                            }
                    %>
                    <option value="<%=e.getPlan_estado_id()%>" <%=Select%>><%=e.getNombre()%></option>
                    <%
                        }
                    %>

                </select>
            </div>
        </div>

    </div>
    <!-- /.box-body -->
    <div class="box-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <button type="submit" class="btn btn-purple pull-right">Guardar</button>
        <div class="mensaje"></div>
    </div>
    <!-- /.box-footer -->
</form>
<script>
    $(document).ready(function () {

        $('#indi_fecha').datepicker({
            autoclose: true,
            dateFormat: 'dd/mm/yyyy'
        });
        $('.form_indicador_nuevo').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                indi_nombre: {
                    message: 'Nombre no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Nombre no puede ser vacio. '
                        },
                        stringLength: {
                            min: 4,
                            max: 200,
                            message: 'Nombre tiene que ser mas de 4 y menos de 200 caracteres'
                        }
                    }
                },
                indi_fecha: {
                    validators: {
                        notEmpty: {
                            message: 'Fecha no puede ser vacio. '
                        },
                        date: {
                            format: 'DD/MM/YYYY',
                            message: 'La fecha no es valida'
                        }
                    }
                },
                indi_rango: {
                    message: 'Indicador no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Indicador, no puede ser vacio. '
                        }
                    }
                }
            }
        }).on('success.form.bv', function (e) {
            // Prevent submit form
            e.preventDefault();
            $(".mensaje").show();
            $(".mensaje").addClass("loader");


            var $form = $(e.target);
            var validator = $form.data('bootstrapValidator');
            $.ajax({
                type: "POST",
                url: "../matriz/crear_indicador_guarda.jsp",
                data: $form.serialize(),
                success: function (data)
                {
                    $(".mensaje").removeClass("loader");
                    $(".mensaje").html(data);
                }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $(".mensaje").removeClass("loader");
                    var menn = "<p class='text-red'>Se produjo un error " + errorThrown + "  " + textStatus + "</p>";
                    $(".mensaje").html(menn);
                }
            });
        });

    });

</script>