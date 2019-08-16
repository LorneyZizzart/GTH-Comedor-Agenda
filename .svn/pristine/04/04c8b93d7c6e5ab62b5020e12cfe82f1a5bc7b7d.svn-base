<%@page import="java.text.DecimalFormatSymbols"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="Entidad.Pregunta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Cuestionario"%>
<jsp:useBean id="_reporte_ciclo_cuestionario" class="Controlador.Reporte_evaluacionesController" />

<%
    String id_cuestionario = request.getParameter("id_cuestionario");
    String des_gestion = request.getParameter("des_gestion");
    String des_emple_id = request.getParameter("des_emple_id");

    Cuestionario cuestionario = new Cuestionario();

    cuestionario = _reporte_ciclo_cuestionario.GetCuestionario_Empleado_by_cuestionario_id(Integer.parseInt(id_cuestionario), Integer.parseInt(des_gestion), Integer.parseInt(des_emple_id));

    DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
    separadoresPersonalizados.setDecimalSeparator('.');

    DecimalFormat formato_personalizado = new DecimalFormat("#.00", separadoresPersonalizados);
%>

<section class="invoice lista_preguntas">
    <!-- title row -->
    <div class="row">
        <div class="col-xs-12">
            <h2 class="page-header">
                <i class="fa fa-file-text-o"></i> <%=cuestionario.getNombre()%>                
            </h2>
        </div>
        <!-- /.col -->
    </div>

    <!-- Table row -->
    <div class="row">
        <div class="col-xs-12 table-responsive">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Pregunta </th>
                        <th style="width: 250px" >Análisis</th>
                        <th>Promedio</th>    
                    </tr>
                </thead>
                <tbody>
                    <%
                        int contapregunta = 0;
                        List<Pregunta> Preguntas = new ArrayList<Pregunta>();
                        Preguntas = cuestionario.getPreguntas();
                        for (Pregunta item : Preguntas) {
                            contapregunta++;
                            float promedio = item.getPromedio() * 10;
                    %>
                    <tr>
                        <td><%=contapregunta%></td>
                        <td><%=item.getNombre()%></td>
                        <td>
                            <div class="progress progress-xs">
                                <div class="progress-bar progress-bar-danger" style="width: <%=promedio%>%;background-color: #<%=item.getColor_pintar()%>!important"></div>
                            </div>
                        </td>
                        <td>
                            <%//=item.getPromedio()%>
                            <span class="badge bg-red" style="width: 90px; background-color: #<%=item.getColor_pintar()%>!important"><%=(formato_personalizado.format(item.getPromedio()))%> <%=item.getDesempeno()%></span>
                        </td>                        
                    </tr>
                    <%
                        }
                    %>


                </tbody>
            </table>
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->



    <!-- this row will not appear when printing -->
    <div class="row no-print">
        <div class="col-xs-12">
            <button class="btn btn-default close_preguntas"><i class="fa fa-close"></i> Cerrar</button>
        </div>
    </div>
</section>

<script>
    $(".close_preguntas").on("click", function () {
        $(".lista_preguntas").hide(2000, function () {

        });
    });
</script>