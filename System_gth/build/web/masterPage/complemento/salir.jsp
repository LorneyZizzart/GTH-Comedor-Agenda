<%
    HttpSession sesion = request.getSession();
    sesion.setAttribute("USUARIO", null);
%>
<script type="text/javascript">
    location.reload(true);
</script>