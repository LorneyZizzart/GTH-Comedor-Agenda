<%@page import="Entidad.Cliente"%>
<%@page import="Entidad.View_Empleado_Encuesta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="_guardar_evaluadores" class="Controlador.Cuestionario_evaluaController"/>
<%
    String id_personal = request.getParameter("id_empleado");
    String id_gestion = request.getParameter("id_ciclo_gestion");
    String id_cuestionario = request.getParameter("id_cuestionario");
    String auto_evaluacion = request.getParameter("autoevaluacion");
    
    List<View_Empleado_Encuesta> save_Jefes = new ArrayList<View_Empleado_Encuesta>();
    
    List<View_Empleado_Encuesta> save_Pares = new ArrayList<View_Empleado_Encuesta>();
    
    List<View_Empleado_Encuesta> save_Bajos = new ArrayList<View_Empleado_Encuesta>();
    
    List<Cliente> save_clientes = new ArrayList<Cliente>();

    //out.print("  codigo Personal = " + id_personal + "  gestion_id = " + id_gestion + "  cuestionario_id= " + id_cuestionario);
    //optenemos los Jefes
    try {
        String[] getJefes = request.getParameterValues("jefes[]");
        for (String j : getJefes) {
            View_Empleado_Encuesta jefe = new View_Empleado_Encuesta();
            jefe.setEmpleado_id(Integer.parseInt(j));
            save_Jefes.add(jefe);
        }
    } catch (Exception e) {
        System.out.println(" No tiene jefes");
    }

//optenemos los Pares
    try {
        String[] getPares = request.getParameterValues("pares[]");
        for (String p : getPares) {
            View_Empleado_Encuesta par = new View_Empleado_Encuesta();
            par.setEmpleado_id(Integer.parseInt(p));
            save_Pares.add(par);
        }
    } catch (Exception e) {
        System.out.println(" No tiene jefes");
    }

//optenemos los Bajos
    try {
        String[] getbajos = request.getParameterValues("bajos[]");
        for (String b : getbajos) {
            View_Empleado_Encuesta bajo = new View_Empleado_Encuesta();
            bajo.setEmpleado_id(Integer.parseInt(b));
            save_Bajos.add(bajo);
        }
    } catch (Exception e) {
        System.out.println(" No tiene Bajos");
    }
//optenemos los Clientes
   //optenemos los Clientes
    try {
        String[] getclientes = request.getParameterValues("clientes[]");
        for (String b : getclientes) {
            String[] parts = b.split("-");
            String a = parts[0];//codigo
            String bb = parts[1];//tipo E=Empleado, C=Ciente
            Cliente cliente = new Cliente();
            cliente.setCliente_id(Integer.parseInt(a));
            cliente.setTelefono(bb);
            save_clientes.add(cliente);
        }
    } catch (Exception e) {
        System.out.println(" No tiene Clientes");
    }
    
    View_Empleado_Encuesta guardar = new View_Empleado_Encuesta();
    
    guardar.setEmpleado_id(Integer.parseInt(id_personal));
    guardar.setCuestionario_id(Integer.parseInt(id_cuestionario));
    guardar.setCuestionario_gestion_id(Integer.parseInt(id_gestion));
    guardar.setAuto_evaluacion(auto_evaluacion);
    
    guardar.setJefes(save_Jefes);
    guardar.setPares(save_Pares);
    guardar.setBajos(save_Bajos);
    guardar.setClientes(save_clientes);
    
    String guarda_evaluador = _guardar_evaluadores.SaveUnCuestionario_evalua(guardar);
    
    out.print(guarda_evaluador);
    
%>