<%@page import="Entidad.Empleado"%>
<%
   Empleado perfil = new Empleado();
//   perfil = empleado;
%>

<ul class="timeline timeline-inverse">
    <li>
        <i class="fa fa-user bg-aqua-active"></i>
        <div class="timeline-item">

            <h3 class="timeline-header"><a>Datos Personales</a></h3>

            <div class="timeline-body">
                <p class="timeline-header no-border">
                    <strong><i class="fa  fa-check-circle-o"></i> Nombre:</strong>
                    <%=perfil.getNombre()%>
                </p>
                <p class="timeline-header no-border">
                    <strong><i class="fa fa-check-circle-o"></i> Apellido Paterno: </strong>
                     <%=perfil.getApellido_paterno()%>
                </p>
                <p class="timeline-header no-border">
                    <strong><i class="fa fa-check-circle-o"></i> Apellido Materno</strong>
                    <%=perfil.getApellido_materno()%>
                </p>
                <p class="timeline-header no-border">
                    <strong><i class="fa fa-calendar"></i> Fecha Nacimiento: </strong>
                    <%=perfil.getFecha_nacimiento()%>
                </p>
                <p class="timeline-header no-border">
                    <strong><i class="fa fa-flag-checkered"></i> Pais de Origen:</strong>
                    <%=perfil.getPaisNombre()%>
                </p>
                <p class="timeline-header no-border">
                    <strong><i class="fa  fa-user-plus"></i> Estado Civil:</strong>
                    <%=perfil.getEstado_civil_Nombre()%> 
                </p>
                <p class="timeline-header no-border">
                    <strong><i class="fa fa-mobile"></i> Tel�fono:</strong>
                    <%=perfil.getTelefono()%> 
                </p>
                <p class="timeline-header no-border">
                    <strong><i class="fa fa-envelope-o"></i> Correo electr�nico :</strong>
                    <%=perfil.getEmail()%> 
                </p>
            </div>

        </div>
    </li>
</ul>
                
<ul class="timeline timeline-inverse">
    <li>
        <i class="fa  fa-sun-o bg-aqua-active"></i>
        <div class="timeline-item">

            <h3 class="timeline-header"><a>Datos AFP</a></h3>

            <div class="timeline-body">
                <p class="timeline-header no-border">
                    <strong><i class="fa  fa-check-circle-o"></i> Nombre AFP:</strong>
                    AFP FURUTO DE BOLIVIA
                </p>
                <p class="timeline-header no-border">
                    <strong><i class="fa fa-check-circle-o"></i> N.U.A./C.U.A: </strong>
                     40001290
                </p>
                
            </div>

        </div>
    </li>
</ul>                