package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class qr_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible; Content-Type\" content=\"text/html; charset=utf-8\">\n");
      out.write("        <title>GTH | Dashboard</title>\n");
      out.write("        <!-- Tell the browser to be responsive to screen width -->\n");
      out.write("        <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\n");
      out.write("        <!-- Bootstrap 3.3.6 -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.min.css\">        \n");
      out.write("        <link rel=\"stylesheet\" href=\"dist/css/AdminLTE.min.css\">       \n");
      out.write("        <style>\n");
      out.write("            .bg {\n");
      out.write("                /* The image used */\n");
      out.write("                background-image: url(\"images/crede_cole.png\");\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                /* Center and scale the image nicely */\n");
      out.write("                background-position: center;\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-size: cover;\n");
      out.write("            }\n");
      out.write("            .table_ {\n");
      out.write("                border:2px solid black;\n");
      out.write("            }\n");
      out.write("            canvas{\n");
      out.write("                width: 80px;\n");
      out.write("                height: 80px\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       \n");
      out.write("           \n");
      out.write("                <div class=\"row invoice-info\">\n");
      out.write("                    ");


                        int contador = 0;
                        //for (Empleado em : Empleados) {
                        for (int i = 1; i <= 50; i = i + 1) {
                            
                            if (contador == 3) {
                                out.print("</div><br><div class='row invoice-info'>");
                                contador = 0;
                                
                            }
                            System.out.println(contador);
                            
                    
      out.write("\n");
      out.write("                    <div class=\"col-sm-4 invoice-col ");
      out.print(contador);
      out.write("\">\n");
      out.write("                        <table class=\"table_\">\n");
      out.write("                            <tr style=\"width: 270px; height: 130px\">\n");
      out.write("                                <td style=\"width: 120px;\"><img src=\"images/crede_cole_i.png\"> </td>\n");
      out.write("                                <td><div id=\"output_");
      out.print(i);
      out.write("\"></div>\n");
      out.write("                                    <div class=\"text-center\"><label>");
      out.print(i);
      out.write("</label></div></td>\n");
      out.write("                                <td style=\"width: 20px;\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                    ");

                        contador++;
                        }
                    
      out.write("\n");
      out.write("              \n");
      out.write("           \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("    <!-- jQuery 2.2.3 -->\n");
      out.write("    <!--<script src=\"../../plugins/jQuery/jquery-2.2.3.min.js\"></script>-->\n");
      out.write("    <script src=\"plugins/jQuery/jquery-3.4.1.min.js\"></script>\n");
      out.write("    <script src=\"plugins/jQueryUI/jquery-ui.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!--Genera QR-->\n");
      out.write("    <script src=\"dist/js/qr/jquery.qrcode.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        $(document).ready(function () {\n");
      out.write("\n");
      out.write("\n");
      out.write("            jQuery(function () {\n");
      out.write("        ");
 for (int i = 1; i <= 50; i = i + 1) {
        
      out.write("\n");
      out.write("                jQuery('#output_");
      out.print(i);
      out.write("').qrcode(\"");
      out.print(i);
      out.write("\");\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("\n");
      out.write("            });\n");
      out.write("\n");
      out.write("        });\n");
      out.write("    </script>\n");
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
