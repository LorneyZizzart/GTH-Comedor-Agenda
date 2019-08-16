package Controlador;

import Modelo.CEmpleado_reservaModel;

public class CEmpleado_reserva {

    public int CantidaReservas(int idEmpleado) {
        CEmpleado_reservaModel reserva = new CEmpleado_reservaModel();
        return reserva.CantidaReservas(idEmpleado) ;           
    }
}
