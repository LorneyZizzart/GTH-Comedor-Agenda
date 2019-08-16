<%@ include file= "../../masterPage/complemento/head.jsp" %> 

<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 

<%    }
%><!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        Administrar
        <small> Copia de Seguridad db</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
        <li class="active">Panel</li>
    </ol>
</section>

<div class="example-modal">
    <div class="">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">                                          
                    <h4 class="modal-title">Generar copia de seguridad</h4>
                </div>
                <div class="modal-body">
                    <p>Se generara una copia de seguridad en el servidor donde se encuentra alojado el sistema.</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left btn_cancelar">Cancelar</button>
                    <button type="button" class="btn-purple btn_generar">Generar Copia</button>
                </div>
                <div id = "mensaje"></div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->
</div>
<!-- /.example-modal -->
<%@ include file= "../../masterPage/complemento/footer.jsp" %> 

<script type="text/javascript" charset="utf-8">
    $(document).ready(function () {
        $(".btn_generar").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#mensaje").html("");
            $("#mensaje").addClass("loader");
            $.post('guardar_copia.jsp',
                    {},
                    function (html, textStatus, jqXHR) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }).fail(function (jqXHR, textStatus, errorThrown)
            {
                $("#mensaje").removeClass('loader');
                $("#mensaje").html(errorThrown);
            });
        });
        
        $(".btn_cancelar").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            window.top.location.href = "../../";
        });

    });

</script>