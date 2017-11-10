package com.camilagiraldo.mybusant.Objetos;

/**
 * Created by USER on 07/11/2017.
 */

public class Viajes {
    String Origen_Destino;
    String Empresa;
    String Horarios;

    public Viajes() {
    }

    public Viajes(String origen_Destino, String empresa, String horarios) {
        this.Origen_Destino = origen_Destino;
        this.Empresa = empresa;
        this.Horarios = horarios;
    }

    public String getOrigen_Destino() {
        return Origen_Destino;
    }

    public void setOrigen_Destino(String origen_Destino) {
        Origen_Destino = origen_Destino;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String empresa) {
        Empresa = empresa;
    }

    public String getHorarios() {
        return Horarios;
    }

    public void setHorarios(String horarios) {
        Horarios = horarios;
    }
}
