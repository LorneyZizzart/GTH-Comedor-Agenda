package Controlador;


public class test {

    public static void main(String[] args) {
        /* EventoController ev = new EventoController();
        Evento e = new Evento();
        e.setEvento_id(1);
        e.setNombre_evento("Roberto Test");
        e.setFecha_creacion("");
        e.setEmpleado_id(2);
        e.setFecha_inicio("28/08/2019");
        e.setFecha_fin("30/08/2019");
        e.setEstado(1);
        System.out.println(" respuesta = " + ev.InsertOrUpdate(e));
         */
        Reporte_gthController c = new Reporte_gthController();
        c.getReporte("00");
    }

}
