package org.apache.jsp.Agenda.tarea;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import Entidad.A_EstadoTarea;
import Entidad.A_ProcedimientoTarea;
import Entidad.A_Tarea;

public final class guardarProceso_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      Controlador.A_ProcedimientoTareaController _procedimiento = null;
      synchronized (_jspx_page_context) {
        _procedimiento = (Controlador.A_ProcedimientoTareaController) _jspx_page_context.getAttribute("_procedimiento", PageContext.PAGE_SCOPE);
        if (_procedimiento == null){
          _procedimiento = new Controlador.A_ProcedimientoTareaController();
          _jspx_page_context.setAttribute("_procedimiento", _procedimiento, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.A_TareaController _tarea = null;
      synchronized (_jspx_page_context) {
        _tarea = (Controlador.A_TareaController) _jspx_page_context.getAttribute("_tarea", PageContext.PAGE_SCOPE);
        if (_tarea == null){
          _tarea = new Controlador.A_TareaController();
          _jspx_page_context.setAttribute("_tarea", _tarea, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    
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


      out.write("\n");
      out.write("<div class=\" text-center alert alert-success alert-dismissible\">\n");
      out.write("    <h4><i class=\"icon fa fa-check\"></i> Guardado</h4>\n");
      out.write("</div>\n");
      out.write(" <script type=\"text/javascript\">\n");
      out.write("     var jsonPath = {};\n");
      out.write("      var pathProceso = [];\n");
      out.write("      function saveImageProceso(imagen){\n");
      out.write("        var formData = new FormData();\n");
      out.write("        \n");
      out.write("        formData.append('file',imagen);\n");
      out.write("        $.ajax({\n");
      out.write("            url: 'guardarFileProceso.jsp',\n");
      out.write("            type: 'post',\n");
      out.write("            data: formData, \n");
      out.write("            contentType: false,\n");
      out.write("            processData: false,\n");
      out.write("            success: function(data) {\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("     function saveImageProcesoDB(json){        \n");
      out.write("        $.ajax({\n");
      out.write("            url: 'guardarFileProcesoDB.jsp',\n");
      out.write("            data:{'lista':json},\n");
      out.write("            type: 'post',\n");
      out.write("            success: function(response) {\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("     \n");
      out.write("    \n");
      out.write("    $(document).ready(function () {  \n");
      out.write("        ");
 for(A_Tarea idP : listaId){
            
      out.write("                    \n");
      out.write("                for (var i = 0; i < listaImage.length; i++) {\n");
      out.write("                pathProceso.push({idProceso:");
      out.print(idP.getIdProcedimiento());
      out.write(", titulo:listaImage[i].titulo, pathImage:listaImage[i].nameImage})    \n");
      out.write("                }                   \n");
      out.write("            ");
 }
      out.write("  \n");
      out.write("            \n");
      out.write("                for (var i = 0; i < listaImage.length; i++) {                    \n");
      out.write("                saveImageProceso(listaImage[i].path);\n");
      out.write("                }    \n");
      out.write("\n");
      out.write("//        enviamos un json para guadar a la DB\n");
      out.write("        jsonPath.listaPath = pathProceso;\n");
      out.write("        var jsonString = JSON.stringify(jsonPath);\n");
      out.write("        saveImageProcesoDB(jsonString);\n");
      out.write("        \n");
      out.write("        $(\"#mensaje\").hide(3000, function () {\n");
      out.write("            $('.form-group').removeClass('has-success');\n");
      out.write("            $('.glyphicon-ok').hide();\n");
      out.write("                \n");
      out.write("            \n");
      out.write("            $('#formulario_registro').modal('show');\n");
      out.write("            $(\"#titleModal\").html(\"Procesos\");\n");
      out.write("            $(\".cuerpo_registro\").html('');\n");
      out.write("            $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("            \n");
      out.write("            $.post('procesosTarea.jsp',\n");
      out.write("            {id: localStorage.getItem(\"idTarea\")},\n");
      out.write("                    function (html) {\n");
      out.write("                    $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                    $(\".cuerpo_registro\").html(html);\n");
      out.write("                    }\n");
      out.write("             ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("            {\n");
      out.write("                var alerta = \"<p class='bg-danger'>error: \"+errorThrown+\"</p>\";\n");
      out.write("                $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                $(\".cuerpo_registro\").html(alerta);\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        });\n");
      out.write("        $(\"#formGuardarProceso\")[0].reset();\n");
      out.write("\n");
      out.write("        \n");
      out.write("\n");
      out.write("        \n");
      out.write("    });\n");
      out.write("</script>\n");
 }else if(option.equalsIgnoreCase("update")){    

      out.write("\n");
      out.write("\n");
      out.write("<div class=\" text-center alert alert-success alert-dismissible\">\n");
      out.write("    <h4><i class=\"icon fa fa-check\"></i> Actualizado</h4>\n");
      out.write("</div>\n");
      out.write(" <script type=\"text/javascript\">\n");
      out.write("      var jsonPath = {};\n");
      out.write("      var pathProceso = [];  \n");
      out.write("      function saveImageProceso(imagen){\n");
      out.write("        var formData = new FormData();\n");
      out.write("        \n");
      out.write("        formData.append('file',imagen);\n");
      out.write("        $.ajax({\n");
      out.write("            url: 'guardarFileProceso.jsp',\n");
      out.write("            type: 'post',\n");
      out.write("            data: formData, \n");
      out.write("            contentType: false,\n");
      out.write("            processData: false,\n");
      out.write("            success: function(data) {\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("     function saveImageProcesoDB(json){        \n");
      out.write("        $.ajax({\n");
      out.write("            url: 'guardarFileProcesoDB.jsp',\n");
      out.write("            data:{'lista':json},\n");
      out.write("            type: 'post',\n");
      out.write("            success: function(response) {\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("      ");

        for (A_Tarea ip :listaProcesos){
        
      out.write("\n");
      out.write("           for (var i = 0; i < listaImage.length; i++) {\n");
      out.write("                pathProceso.push({idProceso:");
      out.print(ip.getIdProcedimiento());
      out.write(", titulo:listaImage[i].titulo, pathImage:listaImage[i].nameImage})    \n");
      out.write("                }  \n");
      out.write("        ");

        }
      
      out.write("            \n");
      out.write("                for (var i = 0; i < listaImage.length; i++) {                    \n");
      out.write("                saveImageProceso(listaImage[i].path);\n");
      out.write("                }    \n");
      out.write("  \n");
      out.write("        jsonPath.listaPath = pathProceso;\n");
      out.write("        var jsonString = JSON.stringify(jsonPath);\n");
      out.write("        saveImageProcesoDB(jsonString);\n");
      out.write("     \n");
      out.write("    $(document).ready(function () {        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        $(\"#mensaje\").hide(3000, function () {\n");
      out.write("            $('.form-group').removeClass('has-success');\n");
      out.write("            $('.glyphicon-ok').hide();\n");
      out.write("                \n");
      out.write("            \n");
      out.write("            $('#formulario_registro').modal('show');\n");
      out.write("            $(\"#titleModal\").html(\"Procesos\");\n");
      out.write("            $(\".cuerpo_registro\").html('');\n");
      out.write("            $(\".cuerpo_registro\").addClass('loader');\n");
      out.write("            \n");
      out.write("            $.post('procesosTarea.jsp',\n");
      out.write("            {id: localStorage.getItem(\"idTarea\")},\n");
      out.write("                    function (html) {\n");
      out.write("                    $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                    $(\".cuerpo_registro\").html(html);\n");
      out.write("                    }\n");
      out.write("             ).fail(function (jqXHR, textStatus, errorThrown)\n");
      out.write("            {\n");
      out.write("                var alerta = \"<p class='bg-danger'>error: \"+errorThrown+\"</p>\";\n");
      out.write("                $(\".cuerpo_registro\").removeClass('loader');\n");
      out.write("                $(\".cuerpo_registro\").html(alerta);\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        });\n");
      out.write("        $(\"#formGuardarProceso\")[0].reset();\n");
      out.write("\n");
      out.write("        \n");
      out.write("\n");
      out.write("        \n");
      out.write("    });\n");
      out.write("</script>\n");
}else{
      out.write("\n");
      out.write("<div class=\"alert alert-danger alert-dismissible\">\n");
      out.write("    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\n");
      out.write("    <h4><i class=\"icon fa fa-ban\"></i> Alerta!</h4>\n");
      out.write("    ");
      out.print(option);
      out.write("\n");
      out.write("</div>\n");
}
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
