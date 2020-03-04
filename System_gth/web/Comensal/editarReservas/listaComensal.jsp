<%@page import="Entidad.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="consultaUser" class="Controlador.UsuarioController" />
<jsp:useBean id="consultarComensal" class="Controlador.C_EmpleadoReservaController" />
<%
    
    List<Usuario> Usuarios = new ArrayList<Usuario>();
    
    int idTipoComensal = 0;
    try{
        idTipoComensal = Integer.parseInt(request.getParameter("idTipoComensal"));
        if(idTipoComensal == 0){
            List<Usuario> listInternos = new ArrayList<Usuario>();
            List<Usuario> listExternos = new ArrayList<Usuario>();
            listInternos = consultaUser.GetAllUser();
            listExternos = consultarComensal.getNombresComensalesExternos();
            Usuarios.addAll(listInternos);
            Usuarios.addAll(listExternos);

        }else if(idTipoComensal == 1){
            List<Usuario> listInternos = new ArrayList<Usuario>();
            listInternos = consultaUser.GetAllUser();
            Usuarios.addAll(listInternos);      
        }else if(idTipoComensal == 2){
            
            List<Usuario> listExternos = new ArrayList<Usuario>();
            listExternos = consultarComensal.getNombresComensalesExternos();
            Usuarios.addAll(listExternos);
        }
    }catch(Exception e){
        
    }
    
    
%>

                          <select id="idEmpleado" name="idEmpleado" class="form-control selectFuncionario" style="width: 100%;">
                              <option value="0%2" selected>Todos</option>
                          <%
                                    for(Usuario item : Usuarios){
                                        if(item.getEstado() == 1){
                                            %>
                                   <option value="<%=item.getEmpleado_id()%>%<%=item.getFuncionario()%>"><%=item.getNombre()%></option>
                                    <%
                                        }
                                    }
                         %>
                        </select>
                        
                        <script>
                            $(document).ready(function() {
                                $('.selectFuncionario').select2();
                            })
                        </script>