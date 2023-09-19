/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package co.com.udea.controller;

import co.com.udea.modelo.Vehiculos;
import java.util.Date;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 *
 * @author Juane
 */
public class VehiculosBean {

    @EJB
    private co.com.udea.ejb.VehiculosFacadeLocal vehiculosFacade;
    public UIComponent myButton;

    public UIComponent getMyButton() {
        return myButton;
    }

    public void setMyButton(UIComponent myButton) {
        this.myButton = myButton;
    }
    
    private String placa;
    private String modelo;
    private String marca;
    private Date anio_fabricacion = new Date();
    private String color;
    private String capacidad_pasajeros;
    public boolean disable;

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
    
    String sSubCadena;
    String mensajeVehiculo;
    String m;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getAnioFabricacion() {
        return anio_fabricacion;
    }

    public void setAnioFabricacion(Date anio_fabricacion) {
        this.anio_fabricacion = anio_fabricacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCapacidadPasajeros() {
        return capacidad_pasajeros;
    }

    public void setCapacidadPasajeros(String capacidad_pasajeros) {
        this.capacidad_pasajeros = capacidad_pasajeros;
    }

    public String getsSubCadena() {
        return sSubCadena;
    }

    public void setsSubCadena(String sSubCadena) {
        this.sSubCadena = sSubCadena;
    }

    public String getMensajeVehiculo() {
        return mensajeVehiculo;
    }

    public void setMensajeconductor(String mensajeVehiculo) {
        this.mensajeVehiculo = mensajeVehiculo;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }
    
    public VehiculosBean() {
        this.disable = false;
    }
    
    public String guardar() {
        Vehiculos v = new Vehiculos();
        v.setPlaca(placa);
        v.setModelo(modelo);
        v.setMarca(marca);
        v.setAnioFabricacion(anio_fabricacion);
        v.setColor(color);
        v.setCapacidadPasajeros(capacidad_pasajeros);
        this.vehiculosFacade.create(v);
        m = this.getMensajeVehiculo();
        return "submit";
    }

    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void changeLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
    }
}
