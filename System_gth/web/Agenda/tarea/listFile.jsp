<%@page import="Entidad.A_PathTarea"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="_path" class="Controlador.A_PathTareaController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    String idTarea = request.getParameter("id");
    List<A_PathTarea> listaP = new ArrayList<A_PathTarea>();
    listaP = _path.getAllPath(Integer.parseInt(idTarea));
%>
<div class="box-header" style="padding: 0 0 2% 0">
        <h3 class="box-title">Lista de archivos</h3>
        <a data-id="<%=idTarea%>" style="cursor:pointer;" class="formNewFile btn-purple pull-right" data-toggle="modal tooltip" data-target="#modal-default" data-placement="bottom" title="Añadir archivo">
                        <i class="fa fa-plus"></i>
         </a>
                        <div id="mensajeFile"></div>
    </div>
<div class="box-body table-responsive" style="padding: 0px 5px 30px 5px;">
                    <table id="example1" class="display table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th style="width: 2%">#</th>                                
                                <th style="width: 20%">Archivo</th>
                                <th style="width: 2%">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int contador = 0;
                                for (A_PathTarea p : listaP) {
                                    contador++;

                            %>
                            <tr id="<%=p.getIdPath()%>">
                                <td><%=contador%></td>    
                                <%
                                    String typeFile = "archivo";
                                    if(p.getTypeFilePath().equals("png") || p.getTypeFilePath().equals("jpeg") || p.getTypeFilePath().equals("jpg") || p.getTypeFilePath().equals("gif") || p.getTypeFilePath().equals("svg")){
                                      typeFile = "image";                                      
                                    }else if(p.getTypeFilePath().equals("docx")){
                                        typeFile = "docx";    
                                    }else if(p.getTypeFilePath().equals("xlsx")){
                                        typeFile = "excel";    
                                    }else if(p.getTypeFilePath().equals("pptx")){
                                        typeFile = "powerpoint";    
                                    }else if(p.getTypeFilePath().equals("mp3")){
                                        typeFile = "audio";    
                                    }else if(p.getTypeFilePath().equals("mp4")){
                                        typeFile = "video";    
                                    }else if(p.getTypeFilePath().equals("pdf")){
                                       typeFile = "pdf";     
                                    }
                                %>
                                <td><a href="downloadFile.jsp" target="_blank"><img style="width: 40px;" src="../../images/<%=typeFile%>.png" alt="message user image"> <%=p.getNombrePath()%></a></td>          
                                <td class="text-center">
                                    <div class="btn-group ">                          
                                        <button href="../../../../Files/" data-id="<%=p.getPath()%>" class="DownloadFile btn btn-success btn-xs" data-toggle="tooltip" data-placement="bottom" title="Descargar"> <i class="fa  fa-download"></i></button>                                
                                        <a data-id="<%=p.getIdPath()%>" class="DeletFile btn btn-danger btn-xs delete_button" data-toggle="tooltip" data-placement="bottom" title="Eliminar"> <i class="fa fa-trash-o"></i></a>           
                                    </div>
                                    
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                         
                </div>
<script>
    $(".formNewFile").click(function (e) {
        $(".modal-dialog-edit").width("25%");
        $(".modal-dialog-edit").css('margin-right', "37.5%");
        $(".modal-dialog-edit").css('margin-left', "37.5%");
        $("#titleModal").html("Adjuntar nuevo archivo");
        e.preventDefault();
        e.stopImmediatePropagation();
            $('#formulario_registro').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('crearFile.jsp',
            {id: $(this).attr('data-id')},
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
    $(".DeletFile").click(function (e) {
        var id = $(this).attr('data-id');
//       console.log('#'+id);
        $('#'+id).hide();
            $("#mensajeFile").show();
            $("#mensajeFile").addClass("loader");
            $.post('eliminarFile.jsp',
                    {id: id},
                    function (html) {
                        $("#mensajeFile").removeClass('loader');
                        $("#mensajeFile").html(html);
                    }
            );
    });
    
    function downloadLink(url) {
    	var ajaxOptions = {
    		url: url
        };
        
        var res = $.ajax(ajaxOptions);
        
        function onAjaxDone(data) {          
        		location.href = url
        }
        
        function onAjaxFail() {
        	alert('Error al descargar');
        }
        
        res.done(onAjaxDone).fail(onAjaxFail);
    }
    
    $(".DownloadFile").click(function (e) {
        var url = $(this).attr('data-id');
    	e.preventDefault();
        downloadLink(url);
    
    });
                            
</script>