<%@page import="Entidad.Uni_acad_pre"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="preguntasController" class="Controlador.Uni_acad_preController"/>
<%
    String area_preguntas = request.getParameter("area");
    //out.print(area_preguntas);
    List<Uni_acad_pre> preguntas = new ArrayList<Uni_acad_pre>();
    preguntas = preguntasController.getPreguntasByArea(area_preguntas);
%>


<div class="table-responsive">
    <table class="table">
        <tbody>
            <%
                for (Uni_acad_pre p : preguntas) {
            %>
            <tr>                
                <td><%=p.getPregunta()%></td>
            </tr>
            <%
                }
            %>


        </tbody>
    </table>
</div>