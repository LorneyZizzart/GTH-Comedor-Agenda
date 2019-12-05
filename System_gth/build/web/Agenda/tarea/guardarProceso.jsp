<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="Entidad.A_EstadoTarea"%>
<%@page import="Entidad.A_ProcedimientoTarea"%>
<%@page import="Entidad.A_Tarea"%>
<jsp:useBean id="_procedimiento" class="Controlador.A_ProcedimientoTareaController"/>
<jsp:useBean id="_tarea" class="Controlador.A_TareaController"/>
<%
    
    String[] id = request.getParameter("id").split("%"); 
    List<A_Tarea> listaId = new ArrayList<A_Tarea>();
    String option = null;
    A_Tarea tarea = new A_Tarea();
    A_Tarea aux = new A_Tarea();
    A_ProcedimientoTarea p = new A_ProcedimientoTarea();
    List<A_Tarea> listaProcesos = new ArrayList<A_Tarea>();
    try{        
        if(request.getParameter("proceso").equalsIgnoreCase("update")){    
            listaProcesos = _procedimiento.getAllIdProcedimiento(id[1],Integer.parseInt(id[2]), id[3]);
            String resultadoUpdate = null;
            
            p.setNombreProcedimiento(request.getParameter("nombre"));
            p.setDescripcionProcedimiento(request.getParameter("descripcion"));
            System.out.print("entro aqui3: "+listaProcesos.size());
            for (A_Tarea ip :listaProcesos){
                p.setIdProcedimiento(ip.getIdProcedimiento()); 
                resultadoUpdate = _procedimiento.UpdateProcedimientoTarea(p);
                
            }
            if(resultadoUpdate.equalsIgnoreCase("Ok")){
                option = "update";
            }
        }else{
            
            tarea.setTitulo(id[0]);
            tarea.setIdUserCrea(Integer.parseInt(id[1]));
            tarea.setNombreProcedimiento(request.getParameter("nombre"));
            tarea.setDescripcionProcedimiento(request.getParameter("descripcion"));
            listaId = _procedimiento.SaveProcedimiento(tarea);
            aux = _tarea.getMaxIdTarea();
//            for(A_Tarea idP : listaId){
//                File directorio = new File("E:/Proyectos/GTH/System_gth/web/folder_picture/"+request.getParameter("id")+"/"+idP.getIdProcedimiento()+"");
//                directorio.mkdirs();
//            }
            option = "insert";
        }
        
        
    }catch(Exception e){
        option =  "No se resivieron todos los parametros. Error: " + e;
    }
    if(option.equalsIgnoreCase("insert")){
        System.out.print("tamaño de la lista: "+listaId.size());

%>
<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
 <script type="text/javascript">
     var jsonPath = {};
      var pathProceso = [];
      function saveImageProceso(imagen){
        var formData = new FormData();
        
        formData.append('file',imagen);
        $.ajax({
            url: 'guardarFileProceso.jsp',
            type: 'post',
            data: formData, 
            contentType: false,
            processData: false,
            success: function(data) {
            }
        });
    }
     function saveImageProcesoDB(json){        
        $.ajax({
            url: 'guardarFileProcesoDB.jsp',
            data:{'lista':json},
            type: 'post',
            success: function(response) {
            }
        });
    }
     
    
    $(document).ready(function () {  
        <% for(A_Tarea idP : listaId){
            %>                    
                for (var i = 0; i < listaImage.length; i++) {
                pathProceso.push({idProceso:<%=idP.getIdProcedimiento()%>, titulo:listaImage[i].titulo, pathImage:listaImage[i].nameImage})    
                }                   
            <% }%>  
            
                for (var i = 0; i < listaImage.length; i++) {                    
                saveImageProceso(listaImage[i].path);
                }    

//        enviamos un json para guadar a la DB
        jsonPath.listaPath = pathProceso;
        var jsonString = JSON.stringify(jsonPath);
        saveImageProcesoDB(jsonString);
        
        $("#mensaje").hide(3000, function () {
            $('.form-group').removeClass('has-success');
            $('.glyphicon-ok').hide();
                
            
            $('#formulario_registro').modal('show');
            $("#titleModal").html("Procesos");
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            
            $.post('procesosTarea.jsp',
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
        $("#formGuardarProceso")[0].reset();

        

        
    });
</script>
<% }else if(option.equalsIgnoreCase("update")){    
%>

<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Actualizado</h4>
</div>
 <script type="text/javascript">
      var jsonPath = {};
      var pathProceso = [];  
      function saveImageProceso(imagen){
        var formData = new FormData();
        
        formData.append('file',imagen);
        $.ajax({
            url: 'guardarFileProceso.jsp',
            type: 'post',
            data: formData, 
            contentType: false,
            processData: false,
            success: function(data) {
            }
        });
    }
     function saveImageProcesoDB(json){        
        $.ajax({
            url: 'guardarFileProcesoDB.jsp',
            data:{'lista':json},
            type: 'post',
            success: function(response) {
            }
        });
    }
      <%
        for (A_Tarea ip :listaProcesos){
        %>
           for (var i = 0; i < listaImage.length; i++) {
                pathProceso.push({idProceso:<%=ip.getIdProcedimiento()%>, titulo:listaImage[i].titulo, pathImage:listaImage[i].nameImage})    
                }  
        <%
        }
      %>            
                for (var i = 0; i < listaImage.length; i++) {                    
                saveImageProceso(listaImage[i].path);
                }    
  
        jsonPath.listaPath = pathProceso;
        var jsonString = JSON.stringify(jsonPath);
        saveImageProcesoDB(jsonString);
     
    $(document).ready(function () {        
        
        
        $("#mensaje").hide(3000, function () {
            $('.form-group').removeClass('has-success');
            $('.glyphicon-ok').hide();
                
            
            $('#formulario_registro').modal('show');
            $("#titleModal").html("Procesos");
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            
            $.post('procesosTarea.jsp',
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
        $("#formGuardarProceso")[0].reset();

        

        
    });
</script>
<%}else{%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=option%>
</div>
<%}%>
