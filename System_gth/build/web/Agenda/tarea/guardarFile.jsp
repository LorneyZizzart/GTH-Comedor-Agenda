<%--<%@page import="com.itextpdf.text.pdf.codec.Base64"%>--%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStream"%>
<%@ page import="java.util.*" %>
<%@page import="com.itextpdf.text.pdf.codec.Base64"%>
<jsp:useBean id="_upFile" class="Modelo.AFileUploadHandler" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
//   _upFile.doPost(request, response);
    String idTarea = request.getParameter("id");
    byte[] image = Base64.decode(request.getParameter("path"));
//    String path =  Base64.parseBase64Binary(request.getParameter("path"));
    String base64Message = _encript.ValorAEncriptar(request.getParameter("path"));
    InputStream i =  new FileInputStream(request.getParameter("path"));
    
    String resultado = _upFile.savePathTarea(idTarea, "", i);
//    String resultado = "Ok";

    if(resultado.equalsIgnoreCase("Ok")){
 %>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Ok</h4>
</div>    
<%}else{%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=resultado%>
</div>
<%}%>