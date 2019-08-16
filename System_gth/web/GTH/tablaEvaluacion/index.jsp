<%@ include file= "../../masterPage/complemento/head.jsp" %> 

<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%    }
%>
<section class="content-header">
    <h1>
        Registro 
        <small> de Evaluaciones</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
        <li class="active">Lista de Evaluaciones</li>
    </ol>
</section>

<section class="content">
    <div class="row">
        <div class="col-xs-12">            

            <div class="box box-purple">
                <div class="box-header">
                    <h3 class="box-title">Lista de Evaluaciones</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <table id="example1" class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Usuario</th>
                                <th>Nombre</th>
                                <th>Email</th>                                
                                <th>Perfil</th>
                                <th>Estado</th>
                                <th style="width: 10%">Opciones</th>
                            </tr>
                        </thead>
                        <tbody> 
                        </tbody>
                        <tfoot>
                            <tr>
                                <th>#</th>
                                <th>Usuario</th>
                                <th>Nombre</th>
                                <th>Email</th>                                
                                <th>Perfil</th>
                                <th>Estado</th>
                                <th>Opciones</th>
                            </tr>
                        </tfoot>
                    </table>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
</section>
<%@ include file= "../../masterPage/complemento/footer.jsp" %> 
<script>
    $('#formNuevo').tooltip({ boundary: 'window' })    
    $('.title').tooltip({ boundary: 'window' })

    $(function () {
        $("#example1").DataTable();
    });
</script>