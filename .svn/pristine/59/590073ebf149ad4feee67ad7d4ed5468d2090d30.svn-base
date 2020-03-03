
<%@page import="java.text.DecimalFormatSymbols"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="Entidad.Uni_acad_pre"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="_docente_evalua" class="Controlador.Uni_acad_preController" />
<%
    String id_cuestionario = request.getParameter("id_cuestionario");
    String des_gestion = request.getParameter("des_gestion");
    String des_emple_id = request.getParameter("des_emple_id");

    //out.print(id_cuestionario + " - " + des_gestion + " - " + des_emple_id);

    List<Uni_acad_pre> preguntas = new ArrayList<Uni_acad_pre>();
    preguntas = _docente_evalua.getPreguntasAndNota(des_emple_id, id_cuestionario, des_gestion);

    DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
    separadoresPersonalizados.setDecimalSeparator('.');
    DecimalFormat formato_personalizado = new DecimalFormat("#.00", separadoresPersonalizados);
%>
<section class="invoice lista_preguntas">
    <!-- title row -->
    <div class="row">
        <div class="col-xs-12">
            <h2 class="page-header">
                <i class="fa fa-file-text-o"></i> Analizar            
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

                        for (Uni_acad_pre item : preguntas) {
                            contapregunta++;
                            float promedio = item.getNota() * 10;
                    %>
                    <tr>
                        <td><%=contapregunta%></td>
                        <td><%=item.getPregunta()%></td>
                        <td>
                            <div class="progress progress-xs">
                                <div class="progress-bar progress-bar-danger" style="width: <%=promedio%>%;background-color: #<%=item.getCss()%>!important"></div>
                            </div>
                        </td>
                        <td>
                            <%//=item.getPromedio()%>
                            <span class="badge bg-red" style="width: 90px; background-color: #<%=item.getCss()%>!important"><%=(formato_personalizado.format(item.getNota()))%> <%=item.getNota_estado()%></span>
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