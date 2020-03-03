<%@ include file= "../../masterPage/complemento/head.jsp" %> 

<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %>
<%    DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");
%>
<section class="content-header">
    <h1>
        Evaluaci�n
        <small> Importar Evaluaci�n del Sistema Acad�mico</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="../../"><i class="fa fa-dashboard"></i> Inicio</a></li>
        <li class="active">Impo Evaluaci�n UAB</li>
    </ol>
</section>

<section class="content">
    <div class="box box-purple">
        <div class="box-header">
            <h3 class="box-title">Lista de profesores UAB</h3>            
        </div>
        <!-- /.box-header -->
        <div class="form-inline text-center">
            <div class="form-group">
                <label>Gesti�n</label>
                <select class="form-control gestion">
                    <option value="0">Seleccione gesti�n</option>
                    <option value="2020-1">2020-1</option>
                    <option value="2019-2">2019-2</option>
                    <option value="2019-1">2019-1</option>
                </select>
            </div>

            <button type="button" class="btn btn-purple btn_buscar_prof">Buscar</button>
        </div>
        <section class="lista_profes">

        </section>.
    </div>
</section>

<%@ include file= "../../masterPage/complemento/footer.jsp" %> 

<script>


    $('.btn_buscar_prof').click(function () {
        var gestion = $(".gestion").val();
        var area = '1';
        if (gestion !== '0') {
            $(".lista_profes").html('');
            $(".lista_profes").addClass('loader');

            $.post('profesores_uab.jsp',
                    {gestion: gestion,
                        area: area},
                    function (html) {
                        $(".lista_profes").html(html);
                        $(".lista_profes").removeClass('loader');
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".lista_profes").removeClass('loader');
                $(".lista_profes").html(alerta);
            });
        } else {
            toastr.error("Seleccione Gestion.");
        }
    });
</script>

<%
} //cuando no encuentra inicio se seccion  o una session activa
else {
%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    Termino su sesi�n, ingrese nuevamente haga clic <a href="../../"> aqu�.</a>
</div>
<%
    }
%>