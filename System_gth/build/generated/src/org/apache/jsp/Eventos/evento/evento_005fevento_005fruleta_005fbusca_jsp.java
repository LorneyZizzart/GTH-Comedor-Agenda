package org.apache.jsp.Eventos.evento;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import Entidad.Empleado;
import Entidad.Evento_Actividad;
import Entidad.Evento;

public final class evento_005fevento_005fruleta_005fbusca_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      Controlador.EventoController consultaEvento = null;
      synchronized (_jspx_page_context) {
        consultaEvento = (Controlador.EventoController) _jspx_page_context.getAttribute("consultaEvento", PageContext.PAGE_SCOPE);
        if (consultaEvento == null){
          consultaEvento = new Controlador.EventoController();
          _jspx_page_context.setAttribute("consultaEvento", consultaEvento, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.Evento_ActividadController consultaActividad = null;
      synchronized (_jspx_page_context) {
        consultaActividad = (Controlador.Evento_ActividadController) _jspx_page_context.getAttribute("consultaActividad", PageContext.PAGE_SCOPE);
        if (consultaActividad == null){
          consultaActividad = new Controlador.Evento_ActividadController();
          _jspx_page_context.setAttribute("consultaActividad", consultaActividad, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.EncriptionController _encript = null;
      synchronized (_jspx_page_context) {
        _encript = (Controlador.EncriptionController) _jspx_page_context.getAttribute("_encript", PageContext.PAGE_SCOPE);
        if (_encript == null){
          _encript = new Controlador.EncriptionController();
          _jspx_page_context.setAttribute("_encript", _encript, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.CharacterController _character = null;
      synchronized (_jspx_page_context) {
        _character = (Controlador.CharacterController) _jspx_page_context.getAttribute("_character", PageContext.PAGE_SCOPE);
        if (_character == null){
          _character = new Controlador.CharacterController();
          _jspx_page_context.setAttribute("_character", _character, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String e_cod_id = request.getParameter("evento_id");

    String e_acti_id = request.getParameter("cantidad");

    int e_evento_id = Integer.parseInt((e_cod_id));
    Evento evento = new Evento();
    evento = consultaEvento.GetEventobyId(e_evento_id);

    //out.print("Actividad " + actividad.getEvento_Actividad_id() + "   Evento: " + e_evento_id);
    List<Empleado> Empleados = new ArrayList<Empleado>();
    Empleados = consultaEvento.Juego_cantidad_asistencia(Integer.parseInt(e_acti_id), e_evento_id); //consultaActividad.EmpleadosPresenteActividad(actividad.getEvento_Actividad_id(), e_evento_id);


      out.write("\n");
      out.write("<script src=\"../../dist/js/ruleta/TweenMax.min.js\"></script>\n");
      out.write("<script src=\"../../dist/js/ruleta/Winwheel.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- /.box-header -->\n");
      out.write("<div class=\"box-body table-responsive\">\n");
      out.write("    <center>\n");
      out.write("        <button type=\"button\" class=\"btn btn-primary btn-block\" onclick=\"miRuleta.startAnimation();\">Girar Ruleta</button>\n");
      out.write("        <br />\n");
      out.write("        <br />\n");
      out.write("        <canvas id='canvas' height=\"800\" width=\"800\"></canvas>\n");
      out.write("    </center>\n");
      out.write("</div>\n");
      out.write("<!-- /.box -->\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--Modal-->\n");
      out.write("\n");
      out.write("<div class=\"modal fade bs-example-modal-lg\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myLargeModalLabel\" id=\"muestra_ganador\">\n");
      out.write("    <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("        <div class=\"modal-content\">   \n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                    <span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                <h4 id=\"titleModal\" class=\"modal-title\">Personal seleccionado </h4>\n");
      out.write("            </div>            \n");
      out.write("\n");
      out.write("            <div class=\"modal-body cuerpo_registro\">\n");
      out.write("\n");
      out.write("            </div> \n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div> \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    var miRuleta = new Winwheel({\n");
      out.write("        'numSegments': ");
      out.print(Empleados.size());
      out.write(", // Número de segmentos\n");
      out.write("        'outerRadius': 350, // Radio externo\n");
      out.write("        'segments': [// Datos de los segmentos\n");
      out.write("\n");
      out.write("    ");
for (Empleado elem : Empleados) {
    
      out.write("\n");
      out.write("\n");
      out.write("            {'fillStyle': '");
      out.print(elem.getTelefono());
      out.write("', 'text': '");
      out.print(elem.getNombre());
      out.write(' ');
      out.print(elem.getApellido_paterno());
      out.write(' ');
      out.print(elem.getApellido_materno());
      out.write(" ', 'idempleado': '");
      out.print(elem.getEmpleado_id());
      out.write("'},\n");
      out.write("    ");

        }
    
      out.write("\n");
      out.write("        ],\n");
      out.write("        'animation': {\n");
      out.write("            'type': 'spinToStop', // Giro y alto\n");
      out.write("            'duration': 10, // Duración de giro\n");
      out.write("            'callbackFinished': 'Mensaje()', // Función para mostrar mensaje\n");
      out.write("            'callbackAfter': 'dibujarIndicador()' // Funciona de pintar indicador\n");
      out.write("        }\n");
      out.write("    });\n");
      out.write("    dibujarIndicador();\n");
      out.write("    function Mensaje() {\n");
      out.write("        var SegmentoSeleccionado = miRuleta.getIndicatedSegment();\n");
      out.write("        //alert(\"Elemento seleccionado:\" + SegmentoSeleccionado.idempleado + \"!\");\n");
      out.write("        guardaganador(SegmentoSeleccionado.idempleado);\n");
      out.write("        $('#muestra_ganador').modal('show');\n");
      out.write("        $(\".cuerpo_registro\").html('<h1 class=\"text-center\">' + SegmentoSeleccionado.text + '</h1>');\n");
      out.write("\n");
      out.write("        miRuleta.stopAnimation(false);\n");
      out.write("        miRuleta.rotationAngle = 0;\n");
      out.write("        miRuleta.draw();\n");
      out.write("        dibujarIndicador();\n");
      out.write("    }\n");
      out.write("    function dibujarIndicador() {\n");
      out.write("        var ctx = miRuleta.ctx;\n");
      out.write("        ctx.strokeStyle = 'navy';\n");
      out.write("        ctx.fillStyle = 'black';\n");
      out.write("        ctx.lineWidth = 2;\n");
      out.write("        ctx.beginPath();\n");
      out.write("        ctx.moveTo(370, 0);\n");
      out.write("        ctx.lineTo(430, 0);\n");
      out.write("        ctx.lineTo(400, 40);\n");
      out.write("        ctx.lineTo(371, 0);\n");
      out.write("        ctx.stroke();\n");
      out.write("        ctx.fill();\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function generarColor() {\n");
      out.write("        \"#000000\".replace(/0/g, function () {\n");
      out.write("            alert((~~(Math.random() * 16)).toString(16));\n");
      out.write("            return (~~(Math.random() * 16)).toString(16);\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function guardaganador(empleado) {\n");
      out.write("        //alert(\"empleado \" + empleado + \" evento: \" + ");
      out.print(e_evento_id);
      out.write(");\n");
      out.write("        var evento = ");
      out.print(e_evento_id);
      out.write(";\n");
      out.write("        $.post('evento_guarda_ganador.jsp',\n");
      out.write("                {empleado: empleado,\n");
      out.write("                    evento: evento},\n");
      out.write("                function (html) {\n");
      out.write("                }\n");
      out.write("        );\n");
      out.write("    }\n");
      out.write("</script>");
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
