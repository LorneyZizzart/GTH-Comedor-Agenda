<%@page import="Entidad.Cliente"%>
<%@page import="Entidad.View_Empleado_Encuesta"%>
<%@page import="Entidad.Cuestionario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<jsp:useBean id="_cuestionario_gestion" class="Controlador.Cuestionario_gestionController"/>

<%

    String gestion_id = request.getParameter("id_ciclo");
    String persona_id = request.getParameter("id_emple");

    List<View_Empleado_Encuesta> cuestionarios = new ArrayList<View_Empleado_Encuesta>();
    cuestionarios = _cuestionario_gestion.GetCuestionarioByGestionEmpleado(Integer.parseInt(gestion_id), Integer.parseInt(persona_id));

    if (cuestionarios.size() == 0) {
        out.print("No tiene evaluacion asignada");
    } else {
%>

<div class="table-responsive mailbox-messages table-responsive">
    <table class="table table-hover table-striped">
        <thead>
            <tr>
                <th class="text-center">#</th>
                <th>Nombre</th>
                <th style="width: 5%">Autoevaluación</th>
                <th style="width: 18%">Jefes</th>
                <th style="width: 18%">Pares</th>
                <th style="width: 18%">Bajos</th>
                <th style="width: 18%">Clientes</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <%
                int contador = 0;
                for (View_Empleado_Encuesta item : cuestionarios) {
                    contador++;
            %>
            <tr>
                <td><%=contador%> 
                    <input type="hidden" id="save_empleado_id_<%=contador%>" name="save_empleado_id_<%=contador%>" value="<%=item.getEmpleado_id()%>">
                    <input type="hidden" id="save_cuestionario_id_<%=contador%>" name="save_cuestionario_id_<%=contador%>" value="<%=item.getCuestionario_id()%>">
                </td>
                <td><%=item.getCuestionario_Nombre()%></td>
                <td class="text-center">
                    <%
                        String checked = "";
                        if (item.getAuto_evaluacion().equalsIgnoreCase("Ok")) {
                            checked = " checked";
                        }%>
                    <input class="autoEvaluacion-<%=contador%>" name="autoEvaluacion-<%=contador%>" id="autoEvaluacion-<%=contador%>" type="checkbox" <%=checked%> >
                </td>
                <td class="mailbox-subject">
                    <div class="form-group">
                        <select name="idJefe-<%=contador%>" id="idJefe-<%=contador%>"  class="form-control select2" multiple="multiple" style="width: 100%;">     
                            <%
                                for (View_Empleado_Encuesta j : item.getJefes()) {
                                    String selected_ = "";
                                    for (View_Empleado_Encuesta sj : item.getSelect_Jefes()) {
                                        if (j.getEmpleado_id() == sj.getEmpleado_id()) {
                                            selected_ = "selected";
                                        }
                                    }
                            %>
                            <option value="<%=j.getEmpleado_id()%>" <%=selected_%>><%=j.getNombre_empleado()%></option>                            
                            <%
                                }
                            %>                                                      
                        </select>
                    </div>
                </td>
                <td class="mailbox-subject">
                    <div class="form-group">
                        <select name="idPares-<%=contador%>" id="idPares-<%=contador%>"  class="form-control select2" multiple="multiple" style="width: 100%;">       
                            <%
                                for (View_Empleado_Encuesta j : item.getPares()) {
                                    String selected_ = "";
                                    for (View_Empleado_Encuesta p : item.getSelect_Pares()) {
                                        if (j.getEmpleado_id() == p.getEmpleado_id()) {
                                            selected_ = "selected";
                                        }
                                    }
                            %>
                            <option value="<%=j.getEmpleado_id()%>" <%=selected_%>><%=j.getNombre_empleado()%></option>                            
                            <%
                                }
                            %>     

                        </select>
                    </div>
                </td>
                <td class="mailbox-subject">
                    <div class="form-group">
                        <select name="idBajos-<%=contador%>" id="idBajos-<%=contador%>"  class="form-control select2" multiple="multiple" style="width: 100%;">                           
                            <%
                                for (View_Empleado_Encuesta j : item.getBajos()) {
                                    String selected_ = "";
                                    for (View_Empleado_Encuesta p : item.getSelect_Bajos()) {
                                        if (j.getEmpleado_id() == p.getEmpleado_id()) {
                                            selected_ = "selected";
                                        }
                                    }
                            %>
                            <option value="<%=j.getEmpleado_id()%>" <%=selected_%>><%=j.getNombre_empleado()%></option>                            
                            <%
                                }
                            %>                            
                        </select>
                    </div>
                </td>
                <td class="mailbox-subject">
                    <div class="form-group">
                        <select name="idClientes-<%=contador%>" id="idClientes-<%=contador%>"  class="form-control select2" multiple="multiple" style="width: 100%;">                           
                            <%
                                for (Cliente j : item.getClientes()) {
                                    String selected_ = "";
                                    for (Cliente p : item.getSelect_Clientes()) {
                                        if (j.getCliente_id() == p.getCliente_id()) {
                                            selected_ = "selected";
                                        }
                                    }
                            %>
                            <option value="<%=j.getCliente_id()%>" <%=selected_%>><%=j.getNombre()%></option>                            
                            <%
                                }
                            %>                 
                        </select>
                    </div>
                </td>
                <td> 

                    <% if (item.getVerifica_correo() == 0) {%>
                    <button type="button" class="btn btn-purple pull-right btn-save-evaluator" data-posicion="<%=contador%>"><i class="fa fa-save"></i> Guardar</button>
                    <%}%>
                </td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <div class="mensaje_save_evaluadores"></div>
</div>
<%
    }
%>

<script type="text/javascript">
    $(function () {
        $('.select2').select2()
    });

    $(".btn-save-evaluator").on("click", function () {
        var posicion = $(this).attr("data-posicion");
        //alert(posicion);

        var autoevaluacion = '';
        if ($('#autoEvaluacion-' + posicion).is(':checked')) {
            // Hacer algo si el checkbox ha sido seleccionado
            autoevaluacion = 'Ok';
        } else {
            // Hacer algo si el checkbox ha sido deseleccionado
            autoevaluacion = 'No';
        }
        //alert(" Auto eva : " + autoevaluacion);

        var id_ciclo_gestion = $('#id_ciclo_gestion').val();
        //alert("gestion Id : " + id_ciclo_gestion);

        var id_empleado = $('#save_empleado_id_' + posicion).val();
        //alert("Empleado Id : " + id_empleado);

        var id_cuestionario = $('#save_cuestionario_id_' + posicion).val();
        //alert("Cuestionario Id : " + id_cuestionario);

        var jefes_posicion = 'idJefe-' + posicion;
        var jefes = ($('select[id=' + jefes_posicion + ']').val());
        //alert("Jefes : " + jefes);

        var pares_posicion = 'idPares-' + posicion;
        var pares = ($('select[id=' + pares_posicion + ']').val());
        //alert("Pares : " + pares);

        var bajos_posicion = 'idBajos-' + posicion;
        var bajos = ($('select[id=' + bajos_posicion + ']').val());
        //alert("Bajos : " + bajos);

        var clientes_posicion = 'idClientes-' + posicion;
        var clientes = ($('select[id=' + clientes_posicion + ']').val());
        //alert("clientes : " + clientes);

        //$(".mensaje_save_evaluadores").html('');
        //$(".mensaje_save_evaluadores").addClass('loader');

        $.post('guardar_evaluadores.jsp',
                {id_ciclo_gestion: id_ciclo_gestion,
                    id_empleado: id_empleado,
                    id_cuestionario: id_cuestionario,
                    autoevaluacion: autoevaluacion,
                    jefes: jefes,
                    pares: pares,
                    bajos: bajos,
                    clientes: clientes
                },
                function (html) {
                    // $(".mensaje_save_evaluadores").removeClass('loader');
                    // $(".mensaje_save_evaluadores").html(html);
                    if (html.trim() == "Ok") {
                        toastr.success("Guardado Correctamente.");
                    } else {
                        toastr.error("Se produjo un error." + html);
                    }
                }
        ).fail(function (jqXHR, textStatus, errorThrown)
        {
            var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
            $(".mensaje_save_evaluadores").removeClass('loader');
            $(".mensaje_save_evaluadores").html(alerta);
        });

    });
</script>