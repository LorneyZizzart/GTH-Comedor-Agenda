<%@page import="Entidad.Empleado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="consultaEvento" class="Controlador.EventoController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<%
    String evento_id = request.getParameter("id");
    List<Empleado> Empleados = new ArrayList<Empleado>();
    Empleados = consultaEvento.GetAllEmpleadoNoEstanaEnEvento(Integer.parseInt(evento_id));
%>
<style>
    table.dataTable tr th.select-checkbox.selected::after {

        margin-top: -11px;
        margin-left: -4px;
        text-align: center;
        text-shadow: rgb(176, 190, 217) 1px 1px, rgb(176, 190, 217) -1px -1px, rgb(176, 190, 217) 1px -1px, rgb(176, 190, 217) -1px 1px;
    }
</style>

<div class="box-body table-responsive">
    <table id="persona_no_select" class="table table-bordered table-striped">
        <thead>
            <tr>
                <th><input type="checkbox" id="select_all" /> Todos</th>
                <th>#</th>
                <th>Nombre Personal</th>
                <th>Departamento</th>
                <th>Cargo</th>
                <th>Grupo</th>                
                <th></th>
            </tr>
        </thead>
        <tbody>
            <%
                int contador = 0;
                for (Empleado em : Empleados) {
                    contador++;
            %>
            <tr id="tr_<%=em.getEmpleado_id()%>">

                <td><input type="checkbox" class="checkbox" name="empleados[]" value="<%=em.getEmpleado_id()%>"/></td>
                <td><%=contador%></td>
                <td><%=em.getApellido_paterno()%> <%=em.getApellido_materno()%> <%=em.getNombre()%></td>

                <%
                    if (em.getCargo() != null) {
                %>
                <td><%=_character.CharacterUCFirst(em.getCargo().getDepartamento_nombre())%></td>
                <td><%=_character.CharacterUCFirst(em.getCargo().getCargo_nombre())%></td>
                <td><%=_character.CharacterUCFirst(em.getCargo().getNivel_nombre())%></td>
                <%
                } else {
                %><td></td>
                <td></td>
                <td></td><%
                    }
                %>
                <td><a data-id="<%=em.getEmpleado_id()%>"  data-evento="<%=evento_id%>" class="agrega_empleado_uno btn btn-xs btn-success" data-original-title="Agregar a evento"> <i class="fa  fa-user-plus"></i></a></td>
            </tr>
            <%
                }
            %>

        </tbody>
        <tfoot>
            <tr>
                <td></td>
                <th>#</th>
                <th>Nombre Personal</th>
                <th>Departamento</th>
                <th>Cargo</th>
                <th>Grupo</th>
                <th></th>                
            </tr>
        </tfoot>
    </table>
    <div class="box-footer">
        <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
        <button type="button" class="btn-purple pull-right guarda_participantes"><i class="fa fa-save"></i> Guardar</button>
    </div>
    <div class="mensaje"></div>
</div>

<script type="text/javascript">
    $(document).ready(function () {

        /*$("#persona_no_select").DataTable({
         "lengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50, 100, "Todo"]]
         });
         */

        $(function () {
            $("#persona_no_select").DataTable({
                "lengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50, 100, "Todo"]]
            });
        });

        $('#select_all').on('click', function () {
            if (this.checked) {
                $('.checkbox').each(function () {
                    this.checked = true;
                });
            } else {
                $('.checkbox').each(function () {
                    this.checked = false;
                });
            }
        });
        $('.guarda_participantes').on('click', function () {
            var selected = new Array();
            $('[name="empleados[]"]:checked').each(
                    function () {
                        selected.push($(this).val());
                    }
            );
            if (selected.length > 0) {

                $(".mensaje").addClass('loader');
                $.post('personas_no_seleccionadas_guardar.jsp',
                        {id_evento: <%=evento_id%>,
                            personales: selected},
                        function (html) {
                            $(".mensaje").removeClass('loader');
                            $(".mensaje").html(html);
                        }
                ).fail(function (jqXHR, textStatus, errorThrown)
                {
                    var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                    $(".mensaje").removeClass('loader');
                    $(".mensaje").html(alerta);
                });

            } else {
                alert("No selecciono nada");
            }

        });


        $('.agrega_empleado_uno').click(function () {
            var evento = $(this).attr('data-evento');
            var empleado = $(this).attr('data-id');

            $.post('personas_no_seleccionadas_guardar_uno.jsp',
                    {id_evento: evento,
                        personales: empleado},
                    function (html) {
                        $(".mensaje").html(html);
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".mensaje").removeClass('loader');
                $(".mensaje").html(alerta);
            });
        });

    });
</script>