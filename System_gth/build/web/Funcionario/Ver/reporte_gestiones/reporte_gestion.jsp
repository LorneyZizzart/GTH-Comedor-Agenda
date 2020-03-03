<%@page import="Entidad.Uni_acad_area_pre"%>
<%@page import="java.text.DecimalFormatSymbols"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="Entidad.Cuestionario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="_reporte_ciclo" class="Controlador.Reporte_evaluacionesController" />
<jsp:useBean id="_evalua_docente" class="Controlador.Uni_acad_area_preController" />
<%
    String gestion_id = request.getParameter("gestion_id");
    String empleado_id = request.getParameter("empleado_id");

    List<Cuestionario> gestiones = new ArrayList<Cuestionario>();
    gestiones = _reporte_ciclo.GetAllCuestionario_Empleado(Integer.parseInt(gestion_id), Integer.parseInt(empleado_id));
    //(int Cuestionario_gestion_id, int empleado_id

    List<Uni_acad_area_pre> profes = new ArrayList<Uni_acad_area_pre>();

    profes = _evalua_docente.GetProfAreasNota(empleado_id, gestion_id);

    DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
    separadoresPersonalizados.setDecimalSeparator('.');

    DecimalFormat formato_personalizado = new DecimalFormat("#.00", separadoresPersonalizados);

    if (gestiones.size() > 0) {
        int contador = 0;
        int tamanioLista = gestiones.size();
        int cuenta_tamanio = 0;
        float promedio_total = 0;
%>
<section class="invoice">
    <div class="row">
        <div class="col-xs-12 table-responsive">
            <input type="hidden" id="des_gestion" value="<%=gestion_id%>">
            <input type="hidden" id="des_emple_id" value="<%=empleado_id%>">

            <table class="table table-hover">
                <thead>
                    <tr>
                        <th style="width: 10px">#</th>
                        <th  style="white-space:nowrap; padding:5px">Nombre</th>
                        <th>Desempeño</th>
                        <th style="width: 40px">Promedio</th>
                        <th style="width: 40px"></th>
                    </tr>
                </thead>
                <tbody>
                    <%            for (Cuestionario g : gestiones) {
                            cuenta_tamanio++;
                            contador++;
                            promedio_total = promedio_total + g.getPromedio();
                            int nota = (int) (g.getPromedio());
                            float valor_progres = g.getPromedio() * 10;
                    %>
                    <tr>
                        <td><%=contador%></td>
                        <td style="white-space:nowrap; padding:5px"><%=g.getNombre()%></td>
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
                        if (tamanioLista == cuenta_tamanio) {
                            //Aqui agragamos en caso que tengo evaluacion commo profesor
                            if (profes.size() > 0) {
                                for (Uni_acad_area_pre p : profes) {
                                    contador++;
                                    //int nota = (int) (p.getNota());
                                    promedio_total = promedio_total + p.getNota();
                                    float valor_progres_ = p.getNota() * 10;
                    %>
                    <tr>
                        <td><%=contador%></td>
                        <td style="white-space:nowrap; padding:5px"><%=p.getNombre()%></td>
                        <td>
                            <div class="progress progress-xs">
                                <div class="progress-bar progress-bar-danger" style="width: <%=valor_progres_%>%;background-color: #<%=p.getCss()%>!important"></div>
                            </div>
                        </td>
                        <td>
                            <span class="badge bg-red" style="width: 90px;background-color: #<%=p.getCss()%>!important"><%=(formato_personalizado.format(p.getNota()))%> <%=p.getNota_estado()%></span>
                        </td>
                        <td>
                            <button type="button" class="btn btn-purple btn-xs analiza_profe" data-cuestionaio="<%=p.getUni_acad_area_pre_id()%>" data-gestion="<%=p.getGestion()%>">Analizar desempeño</button>                
                        </td>
                    </tr>
                    <%
                                    }
                                }
                            }
                        }
                    %>    
                </tbody>
            </table>
            <h3 class="box-title">Promedio Total = <%=formato_personalizado.format(promedio_total / contador)%></h3>

        </div>
    </div>
</section>

<div id="ver_analisis"></div>

<script>
    $(".analiza_profe").click(function (e) {
        e.stopImmediatePropagation();
        var id_cuestionario = $(this).attr('data-cuestionaio');
        var gestion = $(this).attr('data-gestion');
        var empleado_id = '<%=empleado_id%>';

        $("#ver_analisis").html("");
        $("#ver_analisis").addClass("loader");
        $.ajax({
            type: "POST",
            url: "reporte_gestiones/ver_desempeno_analisis_prof.jsp",
            data: {id_cuestionario: id_cuestionario,
                des_gestion: gestion,
                des_emple_id: empleado_id},
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
    if (profes.size() > 0) {
        int contador = 0;
        int tamanioLista = gestiones.size();
        int cuenta_tamanio = 0;
        float promedio_total = 0;
%>
<section class="invoice">
    <div class="row">
        <div class="col-xs-12 table-responsive">
            <input type="hidden" id="des_gestion" value="<%=gestion_id%>">
            <input type="hidden" id="des_emple_id" value="<%=empleado_id%>">

            <table class="table table-hover">
                <thead>
                    <tr>
                        <th style="width: 10px">#</th>
                        <th  style="white-space:nowrap; padding:5px">Nombre</th>
                        <th>Desempeño</th>
                        <th style="width: 40px">Promedio</th>
                        <th style="width: 40px"></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Uni_acad_area_pre p : profes) {
                            contador++;
                            //int nota = (int) (p.getNota());
                            promedio_total = promedio_total + p.getNota();
                            float valor_progres_ = p.getNota() * 10;
                    %>
                    <tr>
                        <td><%=contador%></td>
                        <td style="white-space:nowrap; padding:5px"><%=p.getNombre()%></td>
                        <td>
                            <div class="progress progress-xs">
                                <div class="progress-bar progress-bar-danger" style="width: <%=valor_progres_%>%;background-color: #<%=p.getCss()%>!important"></div>
                            </div>
                        </td>
                        <td>
                            <span class="badge bg-red" style="width: 90px;background-color: #<%=p.getCss()%>!important"><%=(formato_personalizado.format(p.getNota()))%> <%=p.getNota_estado()%></span>
                        </td>
                        <td>
                            <button type="button" class="btn btn-purple btn-xs analiza_profe" data-cuestionaio="<%=p.getUni_acad_area_pre_id()%>" data-gestion="<%=p.getGestion()%>">Analizar desempeño</button>                
                        </td>
                    </tr>
                    <%
                        }


                    %>    
                </tbody>
            </table>
            <h3 class="box-title">Promedio Total = <%=formato_personalizado.format(promedio_total / contador)%></h3>

        </div>
    </div>
</section>

<div id="ver_analisis"></div>
<script>
    $(".analiza_profe").click(function (e) {
        e.stopImmediatePropagation();
        var id_cuestionario = $(this).attr('data-cuestionaio');
        var gestion = $(this).attr('data-gestion');
        var empleado_id = '<%=empleado_id%>';

        $("#ver_analisis").html("");
        $("#ver_analisis").addClass("loader");
        $.ajax({
            type: "POST",
            url: "reporte_gestiones/ver_desempeno_analisis_prof.jsp",
            data: {id_cuestionario: id_cuestionario,
                des_gestion: gestion,
                des_emple_id: empleado_id},
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
<%
} else {
%>
<div class="error-page">    
    <div class="error-content">
        <h3><i class="fa fa-warning text-yellow"></i> Oops! No se encontro resultado.</h3>        
    </div>
    <!-- /.error-content -->
</div>
<%    }
    }
%>