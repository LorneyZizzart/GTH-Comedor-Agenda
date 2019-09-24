<%
    String idTarea = request.getParameter("id");
%>
<form action="guardarFile.jsp" enctype="multipart/form-data" method="post">
    <input type="hidden" value="<%=idTarea%>" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group" >
                            <label>Nombre</label>
                            <input type="text" class="form-control" id="nombreFile"  name="nombreFile">                            
                        </div>
                        <div class="form-group">
                            <input type="file" name="file2" /><br>
                        </div>
                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer">
                        <button type="button" class="btn btn-default pull-left btn-rlistFile" data-dismiss="modal"><i class="fa fa-arrow-left"></i> Volver</button>
                        <button type="submit" class="btn-purple pull-right"><i class="fa fa-save"></i> Guardar</button>
                    </div>
</form>
<script type="text/javascript">   
    
    $(".btn-rlistFile").click(function (e) {
        
        $(".modal-dialog-edit").width("40%");
        $(".modal-dialog-edit").css('margin-right', "30%");
        $(".modal-dialog-edit").css('margin-left', "30%");
        $("#titleModal").html("Archivos relacionados");
        e.preventDefault();
        e.stopImmediatePropagation();
            $('#formulario_registro').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            
            $.post('listFile.jsp',
            {id: localStorage.getItem("idTarea")},
                    function (html) {
                    $(".cuerpo_registro").removeClass('loader');
                    $(".cuerpo_registro").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $(".cuerpo_registro").removeClass('loader');
                $(".cuerpo_registro").html(alerta);
            });
    });    

</script>
