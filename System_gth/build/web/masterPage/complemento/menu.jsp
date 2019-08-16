<%@page import="Entidad.Opcion"%>
<%@page import="Entidad.Login_Entidad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Menu"%>

<%
    HttpSession sesionmenu = request.getSession();
    if (sesionmenu.getAttribute("USUARIO") == null) {
        out.print("<script>window.location.href = 'login.jsp';</script>");
    }
%>

<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="../../folder_picture/<%=DatoUsuario.getFoto_Empleado()%>" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p><%=DatoUsuario.getNombre()%></p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">MENÚ PRINCIPAL</li>

            <%

                List<Menu> menu = new ArrayList<Menu>();

                menu = (ArrayList<Menu>) sesionmenu.getAttribute("MENU");

                for (Menu item : menu) {
            %>
            <li class="treeview">
                <a href="#">
                    <i class="<%=item.getIcono()%>"></i> <span><%=item.getNombre()%></span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>

                <%
                    for (Opcion elem : item.getOpciones()) {
                %>
                <ul class="treeview-menu">
                    <li><a href="<%=elem.getUrl()%>"><i class="fa fa-circle-o"></i> <%=elem.getNombre()%></a></li>                    
                </ul>
                <%
                    }
                %>


            </li>
            <%
                }
            %>            

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">