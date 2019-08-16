<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Menu"%>
<%@page import="Entidad.Login_Entidad"%>
<jsp:useBean id="loginController" class="Controlador.LoginController" scope="application" />
<%
    String usuario = request.getParameter("correo");
    String contrasenia = request.getParameter("password");

    //out.print("Usuario :" + usuario + "<br> contra : " + contrasenia + " <br>");
    Login_Entidad login = new Login_Entidad();
    login = loginController.Iniciar_sesion(usuario, contrasenia);
    if (login.getEstado() == 1) {
        // le manda al index
        HttpSession sesion = request.getSession();
        sesion.setAttribute("USUARIO", login);

        List<Menu> menu = new ArrayList<Menu>();
        menu = loginController.MenuUsuario(login.getUser_id());
        sesion.setAttribute("MENU", menu);

        out.print("<script>window.location.href = 'masterPage/complemento/index.jsp';</script>");

    } else {
        out.print("<p class='text-danger'>" + login.getMensage() + "</p> ");
    }
%>