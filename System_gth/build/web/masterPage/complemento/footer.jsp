
</div>
<!-- /.content-wrapper -->

<footer class="main-footer">
    <div class="pull-right hidden-xs">
        <b>Version</b> 0.1
    </div>
    <strong>Copyright &copy; 2019 <a href="http://www.uab.edu.bo">UAB</a>.</strong> All rights
    reserved.
</footer>

<!-- Control Sidebar -->
<aside class="control-sidebar control-sidebar-dark">
    <!-- Create the tabs -->
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
        <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
        <!-- Home tab content -->
        <div class="tab-pane" id="control-sidebar-home-tab">
            <h3 class="control-sidebar-heading">Recent Activity</h3>
        </div>

    </div>
</aside>
<!-- /.control-sidebar -->
<!-- Add the sidebar's background. This div must be placed
     immediately after the control sidebar -->
<div class="control-sidebar-bg"></div>

<!-- ./wrapper -->
<script src="../../dist/js/CKEditor/ckeditor.js"></script>
<script src="../../dist/js/CKEditor/es.js"></script>
<!-- jQuery 2.2.3 -->
<!--<script src="../../plugins/jQuery/jquery-2.2.3.min.js"></script>-->
<script src="../../plugins/jQuery/jquery-3.4.1.min.js"></script>
<script src="../../plugins/jQueryUI/jquery-ui.min.js"></script>


<!-- Bootstrap 3.3.6 -->
<script src="../../bootstrap/js/bootstrap.min.js"></script>

<!-- Bootstrap validator -->
<script type="text/javascript" src="../../dist/js/bootstrapValidator.js"></script>
<!-- Slimscroll -->
<script src="../../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../../plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/app.min.js"></script>
<!-- bootstrap color picker -->
<script src="../../plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<!-- DataTables -->
<script src="../../plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../../plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- Select2 -->
<script src="../../plugins/select2/select2.full.min.js"></script>
<!--<script src='../../dist/fullcalendar-4.2.0/packages/moment/main.min.js'></script>--> 
<!-- Para Mostrar las alertas Toast-->        
<script src="../../bootstrap/toast_alert/toastr.js"></script>
<!-- bootstrap time picker -->
<script src="../../plugins/timepicker/bootstrap-timepicker.js"></script>
<!-- fullCalendar -->

<script src='../../dist/fullcalendar-4.2.0/packages/core/main.js'></script>
<script src='../../dist/fullcalendar-4.2.0/packages/interaction/main.js'></script>
<script src='../../dist/fullcalendar-4.2.0/packages/daygrid/main.js'></script>
<script src='../../dist/fullcalendar-4.2.0/packages/timegrid/main.js'></script> 
<!-- bootstrap datepicker -->
<script src="../../plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<!--<script src="https://cdn.ckeditor.com/4.5.7/standard/ckeditor.js"></script>-->
<script src="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>

<script src='../../dist/js/moment.js'></script>
<script type="text/javascript" charset="utf-8">
    $("#btn_salir").click(function () {
        $.post('../../masterPage/complemento/salir.jsp',
                {mensaje: 'Salir'},
                function (html) {
                    $(".salir_pagin_session").html(html);
                }
        ).fail(function (jqXHR, textStatus, errorThrown)
        {
            $(".salir_pagin_session").html("<p class='text-danger'>" + errorThrown + "</p>");
        });
    });
</script>

<div class="salir_pagin_session"></div>
</body>
</html>
