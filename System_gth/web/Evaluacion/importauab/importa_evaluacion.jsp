<jsp:useBean id="preguntasImport" class="Controlador.Uni_acad_preController"/>
<%
    String docente_id = request.getParameter("docente_id");
    String cod_uab = request.getParameter("cod_uab");
    String area_id = request.getParameter("area_id");

    String gestion = request.getParameter("gestion");

    //out.print("codigo UAB:" + cod_uab + " docente: " + docente_id + " area: " + area_id + " gestion:" + gestion);
    String resultado = preguntasImport.ImportaNotaSisAcad(cod_uab, docente_id, area_id, gestion);
    if (resultado.equalsIgnoreCase("Ok")) {
%>
<script>
    location.reload();
</script>
<%
    }
%>