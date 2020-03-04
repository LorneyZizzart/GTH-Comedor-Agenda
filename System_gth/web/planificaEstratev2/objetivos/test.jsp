<%@page import="Entidad.Plan_objetivo"%>
<jsp:useBean id="verPlanObjetivos" class="Controlador.Plan_objetivoController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%@ include file= "../../masterPage/complemento/head.jsp" %> 
<%    int empleado_id = 0;
    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%        DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");
        empleado_id = DatoUsuario.getEmpleado_id();
    }
%>
<style>
    .list-group.list-group-tree {
        list-style:none;margin:0;padding:0
    }

    .list-group.list-group-tree .list-group {
        margin-bottom: 0;
    }

    .list-group.list-group-tree > .list-group > .list-group-item {
        padding-left: 30px;
    }
    .list-group.list-group-tree > .list-group > .list-group > .list-group-item {
        padding-left: 45px;
    }
    .list-group.list-group-tree > .list-group > .list-group > .list-group-item > .list-group-item {
        padding-left: 60px;
    }
    .list-group.list-group-tree > .list-group > .list-group > .list-group-item > .list-group-item > .list-group-item {
        padding-left: 75px;
    }
    .list-group.list-group-tree > .list-group > .list-group > .list-group-item > .list-group-item > .list-group-item > .list-group-item {
        padding-left: 90px;
    }


    .list-group-item .fa {
        margin-right: 5px;
    }

    .fa-chevron:before {
        content: "\f054"; /*right*/
    }
    .in > .fa-chevron:before {
        content: "\f078"; /*down*/
    }
</style>
<section class="content-header">
    <h1>
        Planificación 
        <small>Estratégica</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Mailbox</li>
    </ol>
</section>

<section class="content">
    <div class="row">
        <div class="col-md-3">                      

            <div class="box box-solid">
                <div class="box-header with-border">
                    <h3 class="box-title">Planificar Objetivos</h3>

                    <div class="box-tools">
                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                        </button>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <section class="sidebar">
                        <ul class="sidebar-objetivo">
                            <li class="treeview">
                                <a href="#">
                                    <i class="fa fa-file-text-o"></i> <span>Objetivo 1</span>
                                    <span class="pull-right-container">
                                        <i class="fa fa-angle-left pull-right"></i>
                                    </span>
                                </a>
                                <ul class="treeview-menu">
                                    <li><a href="#"><i class="fa fa-circle-o"></i> Sub objetivo 1</a></li>
                                    <li>
                                        <a href="#"><i class="fa fa-circle-o"></i> Sub objetivo 2
                                            <span class="pull-right-container">
                                                <i class="fa fa-angle-left pull-right"></i>
                                            </span>
                                        </a>
                                        <ul class="treeview-menu">
                                            <li><a href="#"><i class="fa fa-circle-o"></i> Plan Estrategico 1</a></li>
                                            <li>
                                                <a href="#"><i class="fa fa-circle-o"></i> Plan Estrategico 2
                                                    <span class="pull-right-container">
                                                        <i class="fa fa-angle-left pull-right"></i>
                                                    </span>
                                                </a>
                                                <ul class="treeview-menu">
                                                    <li><a href="#"><i class="fa fa-circle-o"></i> Sub Plan Estrategico 1</a></li>
                                                    <li><a href="#"><i class="fa fa-circle-o"></i> Sub Plan Estrategico 2</a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a href="#"><i class="fa fa-circle-o"></i>Sub Objetivo3</a></li>
                                </ul>
                            </li>
                            <!-- /Para crear Un Objetivo -->
                            <li class="treeview">
                                <a href="#" class="link_create_objetivo">
                                    <i class="fa fa-plus"></i> <span>Crear Objetivo</span>                                    
                                </a>
                            </li>
                        </ul>
                    </section>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /. box -->
            <div class="box box-purple">
                <div class="box-header with-border">
                    <h3 class="box-title">Objetivos Concluidos</h3>

                    <div class="box-tools">
                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                        </button>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <ul class="nav nav-pills nav-stacked">
                        <li><a href="#"><i class="fa fa-circle-o text-red"></i> Important</a></li>
                        <li><a href="#"><i class="fa fa-circle-o text-yellow"></i> Promotions</a></li>
                        <li><a href="#"><i class="fa fa-circle-o text-light-blue"></i> Social</a></li>
                    </ul>
                </div>
                <!-- /.box-body -->
            </div>            
            <!-- /.box -->

            <div class="box box-purple">
                <div class="box-header with-border">
                    <h3 class="box-title">Test Menun</h3>
                </div>

                <div class="list-group list-group-tree">

                    <a href="javascript:void(0);" class="list-group-item" data-toggle="collapse">
                        <i class="fa fa-chevron"></i>
                        <span class="badge">12</span>
                        Item 1
                    </a>
                    <div class="list-group collapse">

                        <a href="javascript:void(0);" class="list-group-item" data-toggle="collapse">
                            <i class="fa fa-chevron"></i>
                            <span class="badge">3</span>
                            Item 1.1
                        </a>
                        <div class="list-group collapse" >
                            <a href="javascript:void(0);" class="list-group-item"><span class="badge">0</span>Item 1.1.1</a>
                            <a href="javascript:void(0);" class="list-group-item"><span class="badge">0</span>Item 1.1.2</a>
                            <a href="javascript:void(0);" class="list-group-item"><span class="badge">0</span>Item 1.1.3</a>
                        </div>

                        <a class="list-group-item" data-toggle="collapse">
                            <i class="fa fa fa-chevron"></i>
                            <span class="badge">3</span>
                            Item 1.2
                        </a>
                        <div class="list-group collapse" >
                            <a href="javascript:void(0);" class="list-group-item"><span class="badge">0</span>Item 1.2.1</a>
                            <a href="javascript:void(0);" class="list-group-item"><span class="badge">0</span>Item 1.2.2</a>
                            <a href="javascript:void(0);" class="list-group-item"><span class="badge">0</span>Item 1.2.3</a>
                        </div>

                        <a href="javascript:void(0);" class="list-group-item" data-toggle="collapse">
                            <i class="fa fa fa-chevron"></i>
                            <span class="badge">3</span>
                            Item 1.3
                        </a>
                        <div class="list-group collapse" >
                            <a href="javascript:void(0);" class="list-group-item"><span class="badge">0</span>Item 1.3.1</a>
                            <a href="javascript:void(0);" class="list-group-item"><span class="badge">0</span>Item 1.3.2</a>
                            <a href="javascript:void(0);" class="list-group-item"><span class="badge">0</span>Item 1.3.3</a>
                        </div>
                    </div>
                </div>



            </div>            
            <!-- /.col -->
        </div>

        <div class="col-md-9">
            <div class="box box-purple">               
                <!-- /.box-header -->
                <div class="box-body no-padding contenedor_planifica">                    

                </div>
                <!-- /.box-body -->
                <div class="box-footer no-padding">

                </div>
            </div>
            <!-- /. box -->
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
</section>
<%@ include file= "../../masterPage/complemento/footer.jsp" %> 

<script type="text/javascript" language="javascript">

    $(document).ready(function () {


        $(".link_create_objetivo").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            alert("crear");
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


        $(function () {
            $(".list-group-tree").on('click', "[data-toggle=collapse]", function () {
                $(this).toggleClass('in')
                $(this).next(".list-group.collapse").collapse('toggle');
                // next up, when you click, dynamically load contents with ajax - THEN toggle
                return false;
            });
        });

    });
</script>