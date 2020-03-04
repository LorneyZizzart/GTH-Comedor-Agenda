<%@page import="Entidad.Login_Entidad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Cuestionario_respuestas"%>
<jsp:useBean id="_save_respuesta" class="Controlador.Cuestionario_respuestasController" />
<%
    //Cuestionario_respuestasController
    List<Cuestionario_respuestas> respuestas = new ArrayList<Cuestionario_respuestas>();
    String[] ids = request.getParameterValues("ids[]");
    String evaluacion_id_log = "";

    for (String item : ids) {
        Cuestionario_respuestas res = new Cuestionario_respuestas();
        String[] parts = item.split("-");

        int nota = Integer.parseInt(parts[0]);
        int pregunta = Integer.parseInt(parts[1]);
        int Cuestionario_evalua = Integer.parseInt(parts[2]);

        res.setNota(nota);
        res.setPregunta_id(pregunta);
        res.setCuestionario_evalua_id(Cuestionario_evalua);
        evaluacion_id_log = Integer.toString(Cuestionario_evalua);
        respuestas.add(res);
    }

    String guardar = _save_respuesta.Save_respuestas(respuestas);
    if (guardar.equalsIgnoreCase("Ok")) {

        Login_Entidad login = new Login_Entidad();
        HttpSession sesion = request.getSession();
        login = (Login_Entidad) sesion.getAttribute("USUARIO");
        login.setAccion("Termino la evaluacion. Encuesta_id: " + evaluacion_id_log);
        sesion.setAttribute("USUARIO", login);
%>

<%@include file="../../masterPage/complemento/guarda_log.jsp" %>
<script type="text/javascript">
    $(document).ready(function () {
        setTimeout("window.location.href = '../../index.jsp'", 2000);
    });
</script>

<%    
    sesion.setAttribute("USUARIO", null);
%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado Correctamente </h4>
</div>
<%
} else {%>
<script type="text/javascript">
    $(document).ready(function () {
        setTimeout("window.location.href = '../../index.jsp'", 2000);
    });
</script>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> <%=guardar%></h4>

</div>
<%}%>
