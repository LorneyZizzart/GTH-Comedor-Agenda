package org.apache.jsp.Funcionario.Ver.retro_005falimentacion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Feedback;

public final class Vista_005fimpresion_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      Controlador.FeedbackController _feedback_ver = null;
      synchronized (_jspx_page_context) {
        _feedback_ver = (Controlador.FeedbackController) _jspx_page_context.getAttribute("_feedback_ver", PageContext.PAGE_SCOPE);
        if (_feedback_ver == null){
          _feedback_ver = new Controlador.FeedbackController();
          _jspx_page_context.setAttribute("_feedback_ver", _feedback_ver, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.EncriptionController _encriptt = null;
      synchronized (_jspx_page_context) {
        _encriptt = (Controlador.EncriptionController) _jspx_page_context.getAttribute("_encriptt", PageContext.PAGE_SCOPE);
        if (_encriptt == null){
          _encriptt = new Controlador.EncriptionController();
          _jspx_page_context.setAttribute("_encriptt", _encriptt, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    String id_nota = request.getParameter("sdgsdfdgsdfgsdfg");
    id_nota = id_nota.replace(" ", "+");
    id_nota = _encriptt.ValorADesencriptar(id_nota);
    Feedback datos = new Feedback();
    datos = _feedback_ver.Get_feedback_by_id(Integer.parseInt(id_nota));

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        \n");
      out.write("        <!-- Tell the browser to be responsive to screen width -->\n");
      out.write("        <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\n");
      out.write("        <!-- Bootstrap 3.3.6 -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../../bootstrap/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../../plugins/fullcalendar/fullcalendar.print.css\" media=\"print\">\n");
      out.write("        <!-- Theme style -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../../dist/css/AdminLTE.min.css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body onload=\"window.print();\">\n");
      out.write("\n");
      out.write("        <div class=\"row\">\n");
      out.write("\n");
      out.write("            <!-- /.col -->\n");
      out.write("            <div class=\"col-md-12\">\n");
      out.write("                <div>\n");
      out.write("\n");
      out.write("                    <!-- /.box-header -->\n");
      out.write("                    <div class=\"box-body no-padding\">\n");
      out.write("                        <div class=\"mailbox-read-info\">\n");
      out.write("                            <h3>");
      out.print(datos.getFeedback_tipo_nombre());
      out.write("</h3>\n");
      out.write("                            <br>\n");
      out.write("                            <br>\n");
      out.write("                            <br>\n");
      out.write("                            <h4>Motivo: ");
      out.print(datos.getMotivo());
      out.write("\n");
      out.write("                                <!--<span class=\"mailbox-read-time pull-right\">11/02/2019</span>--></h4>\n");
      out.write("                            <h4>Fecha: ");
      out.print(datos.getFecha_advertencia());
      out.write("</h4>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!-- /.mailbox-controls -->\n");
      out.write("                        <div class=\"mailbox-read-message\">\n");
      out.write("                            <p>Estimado ");
      out.print(datos.getNombre_empleado());
      out.write(",</p>\n");
      out.write("\n");
      out.write("                            ");
      out.print(datos.getDescripcion());
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /.mailbox-read-message -->\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box-body -->\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <!-- /. box -->\n");
      out.write("            </div>\n");
      out.write("            <!-- /.col -->\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
