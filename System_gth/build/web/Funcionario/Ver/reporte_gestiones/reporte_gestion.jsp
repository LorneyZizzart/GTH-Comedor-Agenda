<%@page import="java.text.DecimalFormatSymbols"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="Entidad.Cuestionario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="_reporte_ciclo" class="Controlador.Reporte_evaluacionesController" />
<%
    String gestion_id = request.getParameter("gestion_id");
    String empleado_id = request.getParameter("empleado_id");

    List<Cuestionario> gestiones = new ArrayList<Cuestionario>();
    gestiones = _reporte_ciclo.GetAllCuestionario_Empleado(Integer.parseInt(gestion_id), Integer.parseInt(empleado_id));
    //(int Cuestionario_gestion_id, int empleado_id

    DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
    separadoresPersonalizados.setDecimalSeparator('.');

    DecimalFormat formato_personalizado = new DecimalFormat("#.00", separadoresPersonalizados);

    if (gestiones.size() > 0) {
        int contador = 0;
%>
<section class="invoice">
    <div class="row">
        <div class="col-xs-12 table-responsive">
            <input type="hidden" id="des_gestion" value="<%=gestion_id%>">
            <input type="hidden" id="des_emple_id" value="<%=empleado_id%>">

            <table class="table table-hover">
                <tr>
                    <th style="width: 10px">#</th>
                    <th>Nombre</th>
                    <th>Desempeño</th>
                    <th style="width: 40px">Promedio</th>
                    <th style="width: 40px"></th>
                </tr>
                <%            for (Cuestionario g : gestiones) {
                        contador++;
                        int nota = (int) (g.getPromedio());
                        float valor_progres = g.getPromedio() * 10;
                %>
                <tr>
                    <td><%=contador%></td>
                    <td><%=g.getNombre()%></td>
                    <td>
                        <div class="progress progress-xs">
                            <div class="progress-bar progress-bar-danger" style="width: <%=valor_progres%>%;background-color: #<%=g.getColor_pintar()%>!important"></div>
                        </div>
                    </td>
                    <td>
                        <span class="badge bg-red" style="width: 90px;background-color: #<%=g.getColor_pintar()%>!important"><%=(formato_personalizado.format(g.getPromedio()))%> <%=g.getDesempeno()%></span></td>
                    <td>

                        <button type="button" class="btn btn-purple btn-xs analiza_desepeño" data-cuestionaio="<%=g.getCuestionario_id()%>">Analizar desempeño</button>                
                    </td>
                </tr>
                <%
                    }
                %>                
            </table>

        </div>
    </div>
</section>

<div id="ver_analisis"></div>

<script>
    $(".analiza_desepeño").on("click", function () {
        var id_cuestionario = $(this).attr('data-cuestionaio');
        var des_gestion = $('#des_gestion').val();
        var des_emple_id = $('#des_emple_id').val();

        $("#ver_analisis").html("");
        $("#ver_analisis").addClass("loader");
        $.ajax({
            type: "POST",
            url: "reporte_gestiones/ver_desempeno_analisis.jsp",
            data: {id_cuestionario: id_cuestionario,
                des_gestion: des_gestion,
                des_emple_id: des_emple_id},
            success: function (data)
            {
                $("#ver_analisis").removeClass("loader");
                $("#ver_analisis").html(data);
            }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                $("#ver_analisis").removeClass("loader");
                var menn = "<p class='text-red'>Se produjo un error " + errorThrown + "  " + textStatus + "</p>";
                $("#ver_analisis").html(menn);
            }
        });
    });
</script>

<%} else {

%>
<div class="error-page">    
    <div class="error-content">
        <h3><i class="fa fa-warning text-yellow"></i> Oops! No se encontro resultado.</h3>        
    </div>
    <!-- /.error-content -->
</div>
<%    }
%>