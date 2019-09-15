package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      Controlador.EncriptionController _encript = null;
      synchronized (_jspx_page_context) {
        _encript = (Controlador.EncriptionController) _jspx_page_context.getAttribute("_encript", PageContext.PAGE_SCOPE);
        if (_encript == null){
          _encript = new Controlador.EncriptionController();
          _jspx_page_context.setAttribute("_encript", _encript, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');

    String valor = "Roberto Mñana sera un diía";
    String Encriptado = _encript.ValorAEncriptar(valor);
    out.print("Encriptado: " + Encriptado + "<br>");
    String Desencriptado = _encript.ValorADesencriptar(Encriptado);
    out.print("DesEncriptado: " + Desencriptado);

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <title>Documento sin título</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <center style=\"min-width:580px;width:100%\">\n");
      out.write("            <table style=\"background-color:#fff;background-image:none;background-position:top left;background-repeat:repeat;border-bottom:1px solid #bcbcbc;border-collapse:collapse;border-spacing:0;display:table;margin:10px 0 15px 0;padding:0;text-align:left;vertical-align:top;width:100%\">\n");
      out.write("                <tbody>\n");
      out.write("                    <tr style=\"padding:0;text-align:left;vertical-align:top\">\n");
      out.write("                        <th style=\"Margin:0 auto;color:#322f37;line-height:1.3;margin:0 auto;text-align:left;\">\n");
      out.write("                            <table style=\"text-align:left;vertical-align:top;width:100%\">\n");
      out.write("                                <tbody>\n");
      out.write("                                    <tr style=\"padding:0;text-align:left;vertical-align:top\">\n");
      out.write("                                        <th>\n");
      out.write("                                            <a href=\"#\" target=\"_blank\">\n");
      out.write("                                                <img src=\"http://localhost:8080/System_gth/images/Logo_gth.png\" alt=\"GTH\" style=\"Margin:0 auto;border:none;border-bottom:1px solid #6441a4;clear:both;display:block;float:none;margin:0 auto;max-width:100%;outline:0;padding:25px 0;text-align:center;text-decoration:none;width:102px!important\">\n");
      out.write("                                            </a>\n");
      out.write("                                        </th>                                        \n");
      out.write("                                    </tr>\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("\n");
      out.write("                        </th>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("            <table style=\"border-collapse:collapse;border-spacing:0;padding:0;text-align:left;vertical-align:top;width:100%\">\n");
      out.write("                <tbody>\n");
      out.write("                    <tr style=\"padding:0;text-align:left;vertical-align:top\">\n");
      out.write("                        <th>\n");
      out.write("                            ¡Hola, carlosrobertomarca! Us ted fue selecionado para evaluar a RACAROLOEROB ATRO A ONONO es tosos estas asdkfjkal jkasf ñlaksjdf asdf ahsjdfh asldkjfhal ksdjfhl kajsdfhl k\n");
      out.write("                        </th>                                                        \n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("        </center>\n");
      out.write("\n");
      out.write("    </body>\n");
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
