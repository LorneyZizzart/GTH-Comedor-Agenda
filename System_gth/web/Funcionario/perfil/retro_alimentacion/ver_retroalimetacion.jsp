<%@page import="Entidad.Feedback"%>
<jsp:useBean id="_feedback_ver" class="Controlador.FeedbackController" />

<%
    String id_nota = request.getParameter("id");
    Feedback datos = new Feedback();
    datos = _feedback_ver.Get_feedback_by_id(Integer.parseInt(id_nota));
%>
<div class="box-body">
    <dl class="dl-horizontal">
        <dt>Tipo Advertencia: </dt>
        <dd><%=datos.getFeedback_tipo_nombre()%>.</dd>
        <dt>Motivo: </dt>        
        <dd><%=datos.getMotivo()%>.</dd>
        <dt>Fecha:</dt>
        <dd><%=datos.getFecha_advertencia()%>.</dd>
        <dt>Descripción</dt>
        <dd><%=datos.getDescripcion()%>
        </dd>
    </dl>
</div>