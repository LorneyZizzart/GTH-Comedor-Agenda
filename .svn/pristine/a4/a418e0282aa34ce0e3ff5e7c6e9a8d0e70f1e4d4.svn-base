<%@page import="Entidad.Empleado_docente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="profesoresGet" class="Controlador.Empleado_docenteController"/>
<%
    String gestion_ = request.getParameter("gestion");
    String area_ = request.getParameter("area");
    List<Empleado_docente> empleados = new ArrayList<Empleado_docente>();
    empleados = profesoresGet.getAllEmpleadoByGestionArea(gestion_, area_);

%>
<form class="form-horizontal">
    <div class="form-group">
        <label class="col-sm-3 control-label">Buscar</label>
        <div class="col-sm-9">
            <select class="form-control select2 idEmpleado" name='idEmpleado' id='idEmpleado' style="width: 100%;">
                <option value="0">- Seleccionar -</option>
                <% for (Empleado_docente e : empleados) {
                %>
                <option value="<%=e.getEmpleado_docente_id()%>"><%=e.getNombre_profesor()%></option>
                <%
                    }
                %>
            </select>
        </div>
    </div>
    <%
        if (area_.equalsIgnoreCase("1")) {
    %>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-3 control-label">Codigo Sistema Académico</label>
        <div class="col-sm-9">
            <input type="text" class="form-control codigo_univ" id="codigo_univ" placeholder="Codigo UAB" value="">
        </div>
    </div>  
    <script>
        $('.idEmpleado').change(function () {
            var id_empleado = $(this).val();

            $.post('trae_codigouab.jsp',
                    {id_empleado: id_empleado},
                    function (html) {
                        $(".mensaje_anade_prof").html(html);
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".mensaje_anade_prof").removeClass('loader');
                $(".mensaje_anade_prof").html(alerta);
            });
        });
    </script>
    <%
    } else {
    %>
    <input type="hidden" class="codigo_univ" id="codigo_univ" value="-">
    <%
        }
    %>

    <div class="form-group">
        <div class="col-sm-offset-3 col-sm-9">
            <button type="button" class="btn btn-purple btn_aniade_profesor">Guardar</button>
        </div>
    </div>
    <div class="mensaje_anade_prof"></div>
</form>

<script>
    $(function () {
        $('.select2').select2()
    });

    $('.btn_aniade_profesor').click(function (e) {
        e.stopImmediatePropagation();
        var empleado_id = $('.idEmpleado').val();
        var codigo_univ = $('.codigo_univ').val();
        var gestion = '<%=gestion_%>';
        var area = '<%=area_%>';
        if (empleado_id === '0') {
            toastr.error("Seleccione profesor.");
            return null;
        }
        $(".mensaje_anade_prof").addClass('loader');
        $(".mensaje_anade_prof").html("");

        $.post('form_agrega_prof_guarda.jsp',
                {empleado_id: empleado_id,
                    codigo_univ: codigo_univ,
                    gestion: gestion,
                    area: area},
                function (html) {
                    $(".mensaje_anade_prof").html(html);
                    $(".mensaje_anade_prof").removeClass('loader');
                }
        ).fail(function (jqXHR, textStatus, errorThrown)
        {
            var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
            $(".mensaje_anade_prof").removeClass('loader');
            $(".mensaje_anade_prof").html(alerta);
        });

    });

</script>