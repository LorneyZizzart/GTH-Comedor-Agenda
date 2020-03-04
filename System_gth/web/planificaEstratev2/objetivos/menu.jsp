<%@page import="Entidad.Plan_accion"%>
<%@page import="Entidad.Plan_subobjetivo"%>
<%@page import="Entidad.Plan_objetivo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Login_Entidad"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="verMenunObjetivos" class="Controlador.Plan_objetivoController" />
<%
    int empleado_id_menu = 0;
    Login_Entidad DatoUsuario = new Login_Entidad();
    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") == null) {
        out.print("Sesión terminada. Ingrese nuevamente ");
    } else {
        DatoUsuario = (Login_Entidad) sesionmenus.getAttribute("USUARIO");
        empleado_id_menu = DatoUsuario.getEmpleado_id();

        List<Plan_objetivo> menu_objetivos = new ArrayList<Plan_objetivo>();
        menu_objetivos = verMenunObjetivos.getMenuGetAllPlanObjetivobyUser(Integer.toString(empleado_id_menu));
%>

<style>
    .tree {
        margin-bottom:20px;
        background-color:#fbfbfb;
        color: #000;
    }
    .tree li {
        list-style-type:none;
        margin:0;
        padding:10px 0 0 5px;
        position:relative;
        color: #000;
    }

    .tree li::before, .tree li::after {
        content:'';
        left:-20px;
        position:absolute;
        right:auto
    }
    .tree li::before {
        border-left:1px solid #999;
        bottom:50px;
        height:100%;
        top:0;
        width:1px;
        color: #000;
    }
    .tree li::after {
        border-top:1px solid #999;
        height:20px;
        top:25px;
        width:25px;
        color: #000;
    }
    .tree li span {
        text-decoration:none;
    }
    .tree li.parent_li>span {
        cursor:pointer;
        color: #000;
    }
    .tree>ul>li::before, .tree>ul>li::after {
        border:0;
        color: #000;
    }
    .tree li:last-child::before {
        height:30px;
        color: #000;
    }
    .tree li.parent_li>span:hover, .tree li.parent_li>span:hover+ul li span {
        background:#eee;
        border:1px solid #94a0b4;
        color:#000
    }
    .tree li.parent_li>a{        
        color:#000;
        font-weight: 600;
    }
    .tree li.pl_es>a{
        color: #777;
    }
    .tree li.pl_es>a:hover{
        color: #000;
    }
</style>


<div class="box box-purple">
    <div class="box-header with-border">
        <h3 class="box-title">OBJETIVOS</h3>
    </div>

    <%
        if (menu_objetivos.size() > 0) {
    %>
    <div class="tree">
        <ul class="list-unstyled">
            <%
                for (Plan_objetivo m_objetivos : menu_objetivos) {
            %>
            <li>
                <span style="font-weight: 600;">Objetivo:</span> <a href="#" class="a_ver_objetivo" data-id="<%=m_objetivos.getPlan_objetivo_id()%>"><%=m_objetivos.getTitulo()%></a> 
                <ul>                    

                    <% for (Plan_subobjetivo sub : m_objetivos.getPlan_subobjetivos()) {
                    %>
                    <li>
                        <span style="font-weight: 600;">Subobjetivo:</span> <a href="" class="a_ver_subobjetivo" data-id="<%=sub.getPlan_subobjetivo_id()%>"><%=sub.getTitulo()%></a>
                        <ul>
                            <% for (Plan_accion p : sub.getPlan_accion()) {
                            %>
                            <li class="pl_es"><a href="" class="a_ver_planaccion" data-id="<%=_encript.ValorAEncriptar(Integer.toString(p.getPlan_accion_id()))%>" data-suob="<%=sub.getPlan_subobjetivo_id()%>">Plan de Acción: <%=p.getNombre()%></a></li>
                                <%
                                    }
                                %>

                            <li class="pl_es"><a href="" class="link_create_planaccion" data-id="<%=sub.getPlan_subobjetivo_id()%>">Crear Plan Accion</a></li>
                        </ul>
                    </li>
                    <%
                        }
                    %>
                    <li>
                        <span class="label label-default"><i class="fa fa-plus"></i></span> <a href="" class="link_create_subobjetivo" data-id="<%=m_objetivos.getPlan_objetivo_id()%>">Crear subobjetivo</a>                        
                    </li>
                </ul>
            </li>
            <%
                }
            %>
        </ul>
    </div>
    <%
        }
    %>
    <!--<div class="tree">
        <ul class="list-unstyled">
            <li>
                <span><i class="fa fa-folder-open"></i></span> <a href="">Objetivo 1</a> 
                <ul>
                    <li>
                        <span class="label label-default"><i class="fa fa-file-text-o"></i></span> <a href="">Sub Objetivo 1</a>
                        <ul>
                            <li class="pl_es"><a href="">Plan Estrategico 1</a></li>
                            <li class="pl_es"><a href="">Plan Estrategico 2</a></li>
                        </ul>
                    </li>
                    <li>
                        <span class="label label-default"><i class="fa fa-file-text-o"></i></span> <a href="">Sub Obgetivo 2</a>
                        <ul>
                            <li class="pl_es"><a href="">Plan Estrategico 1</a></li>
                            <li class="pl_es"><a href="">Plan Estrategico 2</a></li>                                        
                            <li class="pl_es"><a href="">Plan Estrategico 3</a></li>
                        </ul>
                    </li>
                </ul>
            </li>            
        </ul>
    </div>-->

    <div class="tree">
        <ul class="list-unstyled">
            <li>
                <span><i class="fa fa-plus"></i></span> <a href="#" style="color: #000;" class="link_create_objetivo">Crear Objetivo</a> 
            </li>
        </ul>
    </div>
    <br>

</div>

<script type="text/javascript" language="javascript">

    $(document).ready(function () {
        $(".link_create_objetivo").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $(".contenedor_planifica").html('');
            $(".contenedor_planifica").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('objetivo_crear.jsp',
                    {id: '0', titulo: 'Crear Objetivo'},
                    function (html) {
                        $(".contenedor_planifica").html(html);
                        $(".contenedor_planifica").removeClass('loader');
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".contenedor_planifica").html(alerta);
                $(".contenedor_planifica").removeClass('loader');

            });
        });

        $(".link_create_subobjetivo").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $(".contenedor_planifica").html('');
            $(".contenedor_planifica").addClass('loader');

            var subobjetivo = $(this).attr('data-id');

            $.post('subobjetivo_crear.jsp',
                    {objetivo_id: subobjetivo, titulo: 'Crear Subobjetivo'},
                    function (html) {
                        $(".contenedor_planifica").html(html);
                        $(".contenedor_planifica").removeClass('loader');
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".contenedor_planifica").html(alerta);
                $(".contenedor_planifica").removeClass('loader');

            });
        });
        
        $(".link_create_planaccion").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $(".contenedor_planifica").html('');
            $(".contenedor_planifica").addClass('loader');

            var subobjetivo = $(this).attr('data-id');

            $.post('../plan_accion/plan_accion_crear.jsp',
                    {id: subobjetivo, titulo: 'Crear Plan de Acción'},
                    function (html) {
                        $(".contenedor_planifica").html(html);
                        $(".contenedor_planifica").removeClass('loader');
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".contenedor_planifica").html(alerta);
                $(".contenedor_planifica").removeClass('loader');

            });
        });
        

        $(".a_ver_objetivo").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            var id_objetivo = $(this).attr('data-id');
            $(".contenedor_planifica").html('');
            $(".contenedor_planifica").addClass('loader');

            $.post('objetivo_ver.jsp',
                    {objetivo_id: id_objetivo},
                    function (html) {
                        $(".contenedor_planifica").html(html);
                        $(".contenedor_planifica").removeClass('loader');
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".contenedor_planifica").html(alerta);
                $(".contenedor_planifica").removeClass('loader');

            });
        });

        $(".a_ver_subobjetivo").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            var subobjetivo_id = $(this).attr('data-id');
            $(".contenedor_planifica").html('');
            $(".contenedor_planifica").addClass('loader');

            $.post('subobjetivo_ver.jsp',
                    {subobjetivo_id: subobjetivo_id},
                    function (html) {
                        $(".contenedor_planifica").html(html);
                        $(".contenedor_planifica").removeClass('loader');
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".contenedor_planifica").html(alerta);
                $(".contenedor_planifica").removeClass('loader');

            });
        });

        $(".a_ver_planaccion").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            var plan_id = $(this).attr('data-id');
            var subo_id = $(this).attr('data-suob');
            //alert(plan_id+" - "+subo_id);
            $(".contenedor_planifica").html('');
            $(".contenedor_planifica").addClass('loader');

            $.post('../plan_accion/plan_accion_ver.jsp',
                    {id_pla_ac: plan_id,
                        id: subo_id},
                    function (html) {
                        $(".contenedor_planifica").html(html);
                        $(".contenedor_planifica").removeClass('loader');
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".contenedor_planifica").html(alerta);
                $(".contenedor_planifica").removeClass('loader');

            });
          
        });

        $(function () {
            $('.tree li:has(ul)').addClass('parent_li').find(' > span').attr('title', 'Collapse this branch');
            $('.tree li.parent_li > span').on('click', function (e) {
                var children = $(this).parent('li.parent_li').find(' > ul > li');
                if (children.is(":visible")) {
                    children.hide('fast');
                    $(this).attr('title', 'Expand this branch').find(' > i').addClass('fa-folder').removeClass('fa-folder-open');
                } else {
                    children.show('fast');
                    $(this).attr('title', 'Collapse this branch').find(' > i').addClass('fa-folder-open').removeClass('fa-folder');
                }
                e.stopPropagation();
            });
            //http://jsfiddle.net/riteshpahwa/6xm9ngr2/ origen del codigo
        });
    });
</script>

<%
    }
%>