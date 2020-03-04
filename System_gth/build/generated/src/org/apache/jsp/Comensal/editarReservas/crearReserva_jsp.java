package org.apache.jsp.Comensal.editarReservas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.C_TipoComensal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import Entidad.C_TipoComida;
import Entidad.Usuario;
import java.util.ArrayList;
import java.util.List;

public final class crearReserva_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      Controlador.UsuarioController _consultaUser = null;
      synchronized (_jspx_page_context) {
        _consultaUser = (Controlador.UsuarioController) _jspx_page_context.getAttribute("_consultaUser", PageContext.PAGE_SCOPE);
        if (_consultaUser == null){
          _consultaUser = new Controlador.UsuarioController();
          _jspx_page_context.setAttribute("_consultaUser", _consultaUser, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.C_TipoComidaController _tipoComida = null;
      synchronized (_jspx_page_context) {
        _tipoComida = (Controlador.C_TipoComidaController) _jspx_page_context.getAttribute("_tipoComida", PageContext.PAGE_SCOPE);
        if (_tipoComida == null){
          _tipoComida = new Controlador.C_TipoComidaController();
          _jspx_page_context.setAttribute("_tipoComida", _tipoComida, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.C_TipoComensalesController _tipoComensal = null;
      synchronized (_jspx_page_context) {
        _tipoComensal = (Controlador.C_TipoComensalesController) _jspx_page_context.getAttribute("_tipoComensal", PageContext.PAGE_SCOPE);
        if (_tipoComensal == null){
          _tipoComensal = new Controlador.C_TipoComensalesController();
          _jspx_page_context.setAttribute("_tipoComensal", _tipoComensal, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      Controlador.C_EmpleadoReservaController consultarComensal = null;
      synchronized (_jspx_page_context) {
        consultarComensal = (Controlador.C_EmpleadoReservaController) _jspx_page_context.getAttribute("consultarComensal", PageContext.PAGE_SCOPE);
        if (consultarComensal == null){
          consultarComensal = new Controlador.C_EmpleadoReservaController();
          _jspx_page_context.setAttribute("consultarComensal", consultarComensal, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');

    List<Usuario> Usuarios = new ArrayList<Usuario>();
    Usuarios = _consultaUser.GetAllUser();
    
    List<C_TipoComida> listaTipoComida = new ArrayList<C_TipoComida>();
    listaTipoComida = _tipoComida.getAllTipoComida();
    
    List<C_TipoComensal> listaComensal = new ArrayList<C_TipoComensal>();
    listaComensal = _tipoComensal.getAllTipoComensal();
    
    List<Usuario> listExternos = new ArrayList<Usuario>();
    listExternos = consultarComensal.getNombresComensalesExternos();
//    DateFormat dateFormat = new SimpleDateFormat("HH:mm");
//    String dataStart = request.getParameter("fechaInicio");
//    String dataNow = request.getParameter("fechaNow");
//    Date dateHora = new Date();
//    String horaNow[] = dateFormat.format(dateHora).split(":");

      out.write("\n");
      out.write("<input type=\"hidden\" value=\"");
      out.print(listaTipoComida.size());
      out.write("\" name=\"lengthComida\" id=\"lengthComida\">\n");
      out.write("<form id=\"form_guardar\" method=\"post\" class=\"form_guardar\">\n");
      out.write("             <div class=\"box-body\" style=\"padding-top: 0;\">\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label class=\"col-md-6 col-sm-12\">\n");
      out.write("                                <input type=\"radio\" name=\"funcionario\" class=\"minimal\" value=\"1\" checked >\n");
      out.write("                                Funcionario \n");
      out.write("                            </label>\n");
      out.write("                            <label class=\"col-md-6 col-sm-12\">\n");
      out.write("                                <input type=\"radio\" name=\"funcionario\" class=\"minimal\" value=\"0\">\n");
      out.write("                                No funcionario\n");
      out.write("                            </label>\n");
      out.write("                        </div>\n");
      out.write("                        <div id=\"calidad\" class=\"form-group\">\n");
      out.write("                            <label >En calidad:</label>\n");
      out.write("                                   <select id=\"idCalidad\" name=\"idCalidad\" class=\"form-control\" data-placeholder=\"Selelcione una opción\"style=\"width: 100%;\">\n");
      out.write("                                   <option value=\"0\">Nuevo</option>\n");
      out.write("                                   <option value=\"1\">Antiguo</option>\n");
      out.write("                            </select>                                \n");
      out.write("                        </div>\n");
      out.write("                        <div id=\"idComensalExterno\" class=\"form-group\">\n");
      out.write("                            <label class=\"control-label\" style=\"padding: 2% 0 0 0;\">Comensal externo</label>\n");
      out.write("                            <div class=\"input-group\" style=\"width: 100%;\">\n");
      out.write("                              <select id=\"idEmpleadoExterno\" name=\"idEmpleadoExterno\" class=\"form-control selectFuncionario\" style=\"width: 100%;\">\n");
      out.write("                                  <option value=\"0\" selected disabled>Selecione un comensal</option>\n");
      out.write("                              ");

                                        for(Usuario item : listExternos){
                                            if(item.getEstado() == 1){
                                                
      out.write("\n");
      out.write("                                       <option value=\"");
      out.print(item.getEmpleado_id());
      out.write('"');
      out.write('>');
      out.print(item.getNombre());
      out.write("</option>\n");
      out.write("                                        ");

                                            }
                                        }
                             
      out.write("\n");
      out.write("                            </select>  \n");
      out.write("                            </div>                        \n");
      out.write("                        </div>\n");
      out.write("                        <div id=\"nombreComensal\" class=\"form-group\">\n");
      out.write("                            <label for=\"nombreCompleto\">Nombre completo</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"nombreCompleto\" name=\"nombreCompleto\">\n");
      out.write("                        </div>\n");
      out.write("                        <div id=\"celularComensal\" class=\"form-group\">\n");
      out.write("                            <label for=\"celular\">Celular de referencia</label>\n");
      out.write("                            <input type=\"number\" class=\"form-control\" id=\"celular\" name=\"celular\">\n");
      out.write("                        </div>\n");
      out.write("                        <div id=\"idComensal\" class=\"form-group\">\n");
      out.write("                            <label class=\"control-label\" style=\"padding: 2% 0 0 0;\">Comensal</label>\n");
      out.write("                            <div class=\"input-group\" style=\"width: 100%;\">\n");
      out.write("                              <select id=\"idEmpleado\" name=\"idEmpleado\" class=\"form-control selectFuncionario\" style=\"width: 100%;\">\n");
      out.write("                                  <option value=\"0\" selected disabled>Selecione un funcionario</option>\n");
      out.write("                              ");

                                        for(Usuario item : Usuarios){
                                            if(item.getEstado() == 1){
                                                
      out.write("\n");
      out.write("                                       <option value=\"");
      out.print(item.getUser_id());
      out.write('"');
      out.write('>');
      out.print(item.getNombre());
      out.write("</option>\n");
      out.write("                                        ");

                                            }
                                        }
                             
      out.write("\n");
      out.write("                            </select>  \n");
      out.write("                            </div>                        \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Fecha</label>\n");
      out.write("                            <div class=\"input-group date\">\n");
      out.write("                              <div class=\"input-group-addon\">\n");
      out.write("                                <i class=\"fa fa-calendar\"></i>\n");
      out.write("                              </div>\n");
      out.write("                              <input type=\"text\" class=\"form-control pull-right\" name=\"fi\" id=\"datepicker1\" autocomplete=\"off\">                              \n");
      out.write("                            </div>\n");
      out.write("                            <label id=\"errorDate\" style=\"color: red\">Fecha incorrecto debe ser igual o mayor de hoy</label>\n");
      out.write("                        </div> \n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label class=\"col-md-4\" >\n");
      out.write("                                <strong>Tipo de comensal</strong>\n");
      out.write("                            </label>\n");
      out.write("                            <label class=\"col-md-4\">\n");
      out.write("                                <input type=\"radio\" name=\"ocacional\" class=\"minimal\" checked disabled>\n");
      out.write("                                Ocasional \n");
      out.write("                            </label>\n");
      out.write("                            <label class=\"col-md-4\">\n");
      out.write("                                <input type=\"radio\" name=\"mensual\" class=\"minimal\" disabled>\n");
      out.write("                                Mensual\n");
      out.write("                            </label>\n");
      out.write("                        </div>  \n");
      out.write("                       <input type=\"hidden\" value=\"0\" name=\"tipoComensal\" id=\"tipoComensal\">\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"control-label\" style=\"padding: 2% 0 0 0;\">Comida</label>\n");
      out.write("                            <div class=\"input-group\" style=\"width: 100%;\">\n");
      out.write("                              <select id=\"idTipoComida\" name=\"idTipoComida\" class=\"form-control\" style=\"width: 100%;\">\n");
      out.write("                                ");

                                    for(C_TipoComida item : listaTipoComida){
                                
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print(item.getIdTipoComida());
      out.write('"');
      out.write('>');
      out.print(item.getNombreComida());
      out.write("</option>\n");
      out.write("                                ");

                                    }
                                
      out.write("\n");
      out.write("                            </select>  \n");
      out.write("                            </div>                        \n");
      out.write("                        </div> \n");
      out.write("                        <div class=\"form-group\" >\n");
      out.write("                            <label>Cantidad</label>\n");
      out.write("                            <input type=\"number\" class=\"form-control\" id=\"cantidad\"  name=\"cantidad\" value=\"1\">                            \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Observaciones</label>\n");
      out.write("                            <textarea class=\"form-control\" rows=\"3\" id=\"observacion\"  name=\"observacion\"></textarea>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("             </div>\n");
      out.write("                    <div class=\"box-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default pull-left\" data-dismiss=\"modal\"><i class=\"fa fa-close\"></i> Cancelar</button>\n");
      out.write("                        <button type=\"submit\" class=\"btnGuardar btn-purple pull-right\"><i class=\"fa fa-save\"></i> Guardar</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("        <div id=\"mensaje\"></div>\n");
      out.write("<script>\n");
      out.write("    $(document).ready(function() {\n");
      out.write("        $('#errorDate').hide();\n");
      out.write("        $('#nombreComensal').hide(); \n");
      out.write("        $('#celularComensal').hide()\n");
      out.write("        $('#calidad').hide();\n");
      out.write("        $('#idComensalExterno').hide()\n");
      out.write("        for(var i = 0; i <= $('#lengthComida').val(); i++){\n");
      out.write("                    $('.posicion'+i).attr('disabled', true)\n");
      out.write("        } \n");
      out.write("        $('.selectFuncionario').select2();\n");
      out.write("        $('#datepicker1').datepicker({\n");
      out.write("            format: 'dd/mm/yyyy',\n");
      out.write("            autoclose: true,\n");
      out.write("            minDate: new Date()\n");
      out.write("        });\n");
      out.write("        \n");
      out.write("        var array = [];\n");
      out.write("        for(var i = 1; i <= $(\"#lengthComida\").val(); i++){\n");
      out.write("            array.push(i);\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        array.forEach(function (element){\n");
      out.write("        $('.posicion'+ element).change(function() {\n");
      out.write("            if(this.checked) {\n");
      out.write("              $('.cantidad'+element).prop(\"disabled\", false);\n");
      out.write("              $('.cantidad'+element).val(\"1\");\n");
      out.write("            } else {\n");
      out.write("              $('.cantidad'+element).prop(\"disabled\", true);\n");
      out.write("              $('.cantidad'+element).val(\"Cantidad\");\n");
      out.write("            }\n");
      out.write("            });  \n");
      out.write("        });\n");
      out.write("        \n");
      out.write("        $('input[name=funcionario]').on('change', function() {\n");
      out.write("            if(this.value == 1){\n");
      out.write("                celularComensal\n");
      out.write("                $('#nombreComensal').hide('fast'); \n");
      out.write("                $('#celularComensal').hide('fast'); \n");
      out.write("                $('#calidad').hide('fast');\n");
      out.write("                $('#idComensalExterno').hide('fast');\n");
      out.write("                $('#idComensal').show('slow');\n");
      out.write("            }else{\n");
      out.write("                $('#idComensal').hide();\n");
      out.write("                $('#nombreComensal').show('slow');\n");
      out.write("                $('#celularComensal').show('slow');\n");
      out.write("                $('#calidad').show('slow');\n");
      out.write("            }                \n");
      out.write("        })\n");
      out.write("        \n");
      out.write("        $('#idCalidad').on('change', function(){\n");
      out.write("            if(this.value == 0){\n");
      out.write("                $('#idComensalExterno').hide();\n");
      out.write("                $('#nombreComensal').show('slow');\n");
      out.write("                $('#celularComensal').show('slow');                \n");
      out.write("                \n");
      out.write("            }else{\n");
      out.write("                $('#nombreComensal').hide(); \n");
      out.write("                $('#celularComensal').hide(); \n");
      out.write("                $('#idComensalExterno').show('slow');\n");
      out.write("            }\n");
      out.write("         })\n");
      out.write("        \n");
      out.write("        $('#datepicker1').on('change', function() {\n");
      out.write("            var dateNow = new Date();\n");
      out.write("            var inputDate = (this.value).toString().split('/');\n");
      out.write("            var date = new Date(inputDate[2]+\"-\"+inputDate[1]+\"-\"+inputDate[0])\n");
      out.write("            date.setDate(date.getDate()+1)\n");
      out.write("            \n");
      out.write("            if(date >= dateNow){\n");
      out.write("                $('#errorDate').hide();\n");
      out.write("                for(var i = 0; i <= $('#lengthComida').val(); i++){\n");
      out.write("                    $('.posicion'+i).attr('disabled', false)\n");
      out.write("                }\n");
      out.write("                if(Math.round((date.getTime()-dateNow.getTime())/ (1000*60*60*24)) >= ");
      out.print(listaComensal.get(1).getDiasAnticipacion());
      out.write("){\n");
      out.write("                    $('#tipoComensal').val('1')\n");
      out.write("                    $('input[name=mensual]').attr('checked', true)\n");
      out.write("                    $('input[name=ocacional]').attr('checked', false)                      \n");
      out.write("                }else{\n");
      out.write("                    $('#tipoComensal').val('0')\n");
      out.write("                    $('input[name=ocacional]').attr('checked', true)\n");
      out.write("                    $('input[name=mensual]').attr('checked', false)\n");
      out.write("                }\n");
      out.write("            }else{\n");
      out.write("                for(var i = 0; i <= $('#lengthComida').val(); i++){\n");
      out.write("                    $('.posicion'+i).attr('disabled', true)\n");
      out.write("                } \n");
      out.write("                $('input[name=ocacional]').attr('checked', false)\n");
      out.write("                $('input[name=mensual]').attr('checked', false)\n");
      out.write("                $('#errorDate').show();\n");
      out.write("                  \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        })\n");
      out.write("        \n");
      out.write("        $('.form_guardar').bootstrapValidator({\n");
      out.write("            message: 'This value is not valid',\n");
      out.write("            feedbackIcons: {\n");
      out.write("                valid: 'glyphicon glyphicon-ok',\n");
      out.write("                invalid: 'glyphicon glyphicon-remove',\n");
      out.write("                validating: 'glyphicon glyphicon-refresh'\n");
      out.write("            },\n");
      out.write("            fields: {\n");
      out.write("                nombreCompleto: {\n");
      out.write("                    message: 'El nombre no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El nombre no puede ser vacio. '\n");
      out.write("                        },\n");
      out.write("                        stringLength: {\n");
      out.write("                            min: 3,\n");
      out.write("                            max: 30,\n");
      out.write("                            message: 'El nombre tiene que ser mas de 3 y menos de 30 caracteres'\n");
      out.write("                        },\n");
      out.write("                        regexp: {\n");
      out.write("                            regexp: /^([-a-z0-9_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛÝàáâãèéìíñòóùúûü-\\s])+$/i,\n");
      out.write("                            message: 'El nombre de usuario solo puede constar de letras, números y guiones bajos.'\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                calidad:{\n");
      out.write("                    message: 'El empleado no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Debe seleccionar una opción. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                idEmpleado:{\n");
      out.write("                    message: 'El empleado no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'Debe seleccionar un funcionario. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                fi: {\n");
      out.write("                    message: 'El campo no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El campo no puede ser vacio. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                idTipoComida: {\n");
      out.write("                    message: 'El campo no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El campo no puede ser vacio. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                cantidad: {\n");
      out.write("                    message: 'El campo no es valido.',\n");
      out.write("                    validators: {\n");
      out.write("                        notEmpty: {\n");
      out.write("                            message: 'El campo no puede ser vacio. '\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        }).on('success.form.bv', function (e) {\n");
      out.write("            // Prevent submit form\n");
      out.write("            e.preventDefault();\n");
      out.write("            $(\"#mensaje\").show();\n");
      out.write("            $(\"#mensaje\").addClass(\"loader\");\n");
      out.write("\n");
      out.write("\n");
      out.write("            var $form = $(e.target),\n");
      out.write("                    validator = $form.data('bootstrapValidator');\n");
      out.write("            $.ajax({\n");
      out.write("                type: \"POST\",\n");
      out.write("                url: \"guardarReserva.jsp\",\n");
      out.write("                data: $(\".form_guardar\").serialize(),\n");
      out.write("                success: function (data)\n");
      out.write("                {\n");
      out.write("                    $('.btnGuardar').prop(\"disabled\",true);\n");
      out.write("                    $(\"#mensaje\").removeClass(\"loader\");\n");
      out.write("                    $(\"#mensaje\").html(data);\n");
      out.write("                }, error: function (XMLHttpRequest, textStatus, errorThrown) {\n");
      out.write("                    $('.btnGuardar').prop(\"disabled\",true);\n");
      out.write("                    $(\"#mensaje\").removeClass(\"loader\");\n");
      out.write("                    var menn = \"<p class='text-red'>Se produjo un error \" + errorThrown + \"  \" + textStatus + \"</p>\";\n");
      out.write("                    $(\"#mensaje\").html(menn);\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        \n");
      out.write("    })\n");
      out.write("    \n");
      out.write("    \n");
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
