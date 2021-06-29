/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author jluis
 */
public class CTrabajos {
    
private int id_trabajo;
private String PN;
private String Job;
private String cliente;
private int cantidadlotes;
private int cantidadporlote;
private Date fechain;
private String observaciones;
private String notas;
private Date fechainicio;
private int estado;
private int no_lote;
private String inf_fecha;
private int id_lote;
private int diaspro;
private String fechafin;

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }



    public int getDiaspro() {
        return diaspro;
    }

    public void setDiaspro(int diaspro) {
        this.diaspro = diaspro;
    }


    public int getId_lote() {
        return id_lote;
    }

    public void setId_lote(int id_lote) {
        this.id_lote = id_lote;
    }



    public String getInf_fecha() {
        return inf_fecha;
    }

    public void setInf_fecha(String inf_fecha) {
        this.inf_fecha = inf_fecha;
    }

    public int getNo_lote() {
        return no_lote;
    }

    public void setNo_lote(int no_lote) {
        this.no_lote = no_lote;
    }
    
    public int getId_trabajo() {
        return id_trabajo;
    }

    public void setId_trabajo(int id_trabajo) {
        this.id_trabajo = id_trabajo;
    }

    public String getPN() {
        return PN;
    }

    public void setPN(String PN) {
        this.PN = PN;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String Job) {
        this.Job = Job;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getCantidadlotes() {
        return cantidadlotes;
    }

    public void setCantidadlotes(int cantidadlotes) {
        this.cantidadlotes = cantidadlotes;
    }

    public int getCantidadporlote() {
        return cantidadporlote;
    }

    public void setCantidadporlote(int cantidadporlote) {
        this.cantidadporlote = cantidadporlote;
    }

    public Date getFechain() {
        return fechain;
    }

    public void setFechain(Date fechain) {
        this.fechain = fechain;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
