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
        <small> de tareas</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
        <li class="active">Nueva tareas</li>
    </ol>
</section>
<section class="content">  
    <div class="col-xs-12">            
            <div class="box box-purple">
                <div class="box-header">
                    <h3 class="box-title">Nueva tarea</h3>
                    
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                   <div class="form-group">
                            <label>Descripción</label>
                            <textarea class="textarea" placeholder="Place some text here" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
                        </div>
                         
                </div>
                <div class="box-body pad">
                    <div class="adjoined-bottom">
		<div class="grid-container">
			<div class="grid-width-100">
				<textarea name="content" id="editor">This is some sample content.</textarea>
			</div>
		</div>
            </div>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
    </div>
</section>
<%@ include file= "../../masterPage/complemento/footer.jsp" %> 
<script type="text/javascript">
    ClassicEditor
                                .create( document.querySelector( '#editor' ) )
                                .then( editor => {
                                        console.log( editor );
                                } )
                                .catch( error => {
                                        console.error( error );
                                } );
    $(document).ready(function () {
    //bootstrap WYSIHTML5 - text editor
    $(".textarea").wysihtml5();
});
</script>