<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="Entidad.Login_Entidad"%>
<%@page import="Entidad.Log"%>
<%@page import="java.net.NetworkInterface"%>
<%@page import="java.net.InetAddress"%>
<%@page import="java.net.SocketException"%>
<jsp:useBean id="guardaLog" class="Controlador.LogController" />
<%

    HttpSession sesionLog = request.getSession();
    Login_Entidad DatoUsuarioLog = new Login_Entidad();
    DatoUsuarioLog = (Login_Entidad) sesionLog.getAttribute("USUARIO");

    Log log_save = new Log();

    String log_ip = "";
    String mac_log = "";
    String dato_nav_log = "";
    String navegador_log = "";
    String sis_op_log = "";

    InetAddress ips = InetAddress.getLocalHost();
    String ip = request.getRemoteAddr();
    //out.println("Direccion IP : " + ip.getHostAddress());
    log_ip = ip;//.getHostAddress();

    NetworkInterface network = NetworkInterface.getByInetAddress(ips);
    byte[] mac = network.getHardwareAddress();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < mac.length; i++) {
        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
    }
   // out.println("<br>Direcion Mac : " + sb.toString());
    mac_log = sb.toString();
    //String host = request.getRemoteHost();
    mac_log = mac_log;

    String browserDetails = request.getHeader("User-Agent");
    String userAgent = browserDetails;
    String user_ = userAgent.toLowerCase();

    String os = "";
    String browser = "";

    dato_nav_log = browserDetails;
   // out.print("<br>User Agent for the request is===>" + browserDetails);
    //=================OS=======================
    if (userAgent.toLowerCase().indexOf("windows") >= 0) {
        os = "Windows";
    } else if (userAgent.toLowerCase().indexOf("mac") >= 0) {
        os = "Mac";
    } else if (userAgent.toLowerCase().indexOf("x11") >= 0) {
        os = "Unix";
    } else if (userAgent.toLowerCase().indexOf("android") >= 0) {
        os = "Android";
    } else if (userAgent.toLowerCase().indexOf("iphone") >= 0) {
        os = "IPhone";
    } else {
        os = "UnKnown, More-Info: " + userAgent;
    }
    //===============Browser===========================
    if (user_.contains("msie")) {
        String substring = userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
        browser = substring.split(" ")[0].replace("MSIE", "IE") + "-" + substring.split(" ")[1];
    } else if (user_.contains("safari") && user_.contains("version")) {
        browser = (userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0] + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
    } else if (user_.contains("opr") || user_.contains("opera")) {
        if (user_.contains("opera")) {
            browser = (userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0] + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
        } else if (user_.contains("opr")) {
            browser = ((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-")).replace("OPR", "Opera");
        }
    } else if (user_.contains("chrome")) {
        browser = (userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
    } else if ((user_.indexOf("mozilla/7.0") > -1) || (user_.indexOf("netscape6") != -1) || (user_.indexOf("mozilla/4.7") != -1) || (user_.indexOf("mozilla/4.78") != -1) || (user_.indexOf("mozilla/4.08") != -1) || (user_.indexOf("mozilla/3") != -1)) {
        //browser=(userAgent.substring(userAgent.indexOf("MSIE")).split(" ")[0]).replace("/", "-");
        browser = "Netscape-?";

    } else if (user_.contains("firefox")) {
        browser = (userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
    } else if (user_.contains("rv")) {
        browser = "IE-" + user_.substring(user_.indexOf("rv") + 3, user_.indexOf(")"));
    } else {
        browser = "UnKnown, More-Info: " + userAgent;
    }
    navegador_log = browser;
    sis_op_log = os;
    System.out.println("<br>Operating System======>" + os);
    System.out.println("<br>Browser Name==========>" + browser);

    /*
    String firstInterface = "";
    String MACAddress = "";
    Map<String, String> addressByNetwork = new HashMap<>();
    Enumeration<NetworkInterface> networkInterfaces;

    try {
        networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface network = networkInterfaces.nextElement();
            byte[] bmac = network.getHardwareAddress();
            if (bmac != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < bmac.length; i++) {
                    sb.append(String.format("%02X%s", bmac[i], (i < bmac.length - 1) ? "-" : ""));
                }

                if (sb.toString().isEmpty() == false) {
                    addressByNetwork.put(network.getName(), sb.toString());
                }

                if (sb.toString().isEmpty() == false && firstInterface == null) {
                    firstInterface = network.getName();
                }
            }
        }

    } catch (SocketException e) {
        System.out.println("---- Error  -----" + e.getMessage());
    }

    if (firstInterface != null) {
        MACAddress = addressByNetwork.get(firstInterface);
        System.out.println(" --- " + MACAddress);
    }
*/
    log_save.setEmpleado_id(DatoUsuarioLog.getEmpleado_id());
    log_save.setIp(log_ip);
    log_save.setMac(mac_log);
    log_save.setDato_navegador(dato_nav_log);
    log_save.setNombre_navegador(navegador_log);
    log_save.setSistemaOperativo(os);
    log_save.setAccion(DatoUsuarioLog.getAccion());
    log_save.setUsuario(DatoUsuarioLog.getUsuario());
    guardaLog.saveLog(log_save);
%>

