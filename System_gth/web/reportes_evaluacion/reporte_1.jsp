<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Reporte_gth"%>
<%@page import="java.util.List"%>
<jsp:useBean id="reporteGth" class="Controlador.Reporte_gthController" scope="application" />
<%
    List<Reporte_gth> reporte = new ArrayList<Reporte_gth>();
    reporte = reporteGth.getReporte("as");


%>

<table>
    <tbody>
        <tr>
            <th>#</th>
            <th>Nombre<th>
            <th>Falta que le evalúen<th>
            <th>Falque Que el evalúe</th>
        </tr>
    </tbody>
    <thead>
    <tbody>
        <%                int conta = 0;
            for (Reporte_gth e : reporte) {
                conta++;
        %>
        <tr>
            <td><%=conta%></td>
            <td><%=e.getEvaluado()%></td>
            <td><%=e.getLlenado()%></td>
            <td><%=e.getNo_evaluo()%></td>


        </tr>
        <%
            }
        %>
    </tbody>
</thead>
</table>