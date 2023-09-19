/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package co.com.udea.controller;

import co.com.udea.modelo.Conductores;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Juane
 */
public class ConductoresBean {

    @EJB
    private co.com.udea.ejb.ConductoresFacadeLocal conductoresFacade;

    public UIComponent myButton;
    private int cedula;
    private String nombre;
    private Date fecha_nacimiento = new Date();
    private String licencia;
    private boolean disable = false;

    public String getsSubCadena() {
        return sSubCadena;
    }

    public void setsSubCadena(String sSubCadena) {
        this.sSubCadena = sSubCadena;
    }

    public String getMensajeconductor() {
        return mensajeconductor;
    }

    public void setMensajeconductor(String mensajeconductor) {
        this.mensajeconductor = mensajeconductor;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    String sSubCadena;
    String mensajeconductor;
    String m;

    private List<Conductores> conductores;

    public List<Conductores> getConductores() {
        if ((conductores == null) || (conductores.isEmpty())) {
            refresh();
        }
        return conductores;
    }

    public void refresh() {
        conductores = conductoresFacade.getAllConductores();
    }

    public UIComponent getMyButton() {
        return myButton;
    }

    public void setMyButton(UIComponent myButton) {
        this.myButton = myButton;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public ConductoresBean() {
    }

    public String guardar() {
        Conductores c = new Conductores();
        c.setCedula(cedula);
        c.setNombre(nombre);
        c.setFechaNacimiento(fecha_nacimiento);
        c.setLicencia(licencia);
        this.conductoresFacade.create(c);
        m = this.getMensajeconductor();
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
    
    public void validateNombre(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String nombre = (String) value;

        if (nombre != null && nombre.matches(".*\\d+.*")) {
            FacesMessage message = new FacesMessage("El nombre no puede contener números.");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
    
    public void validateCedula(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Integer cedula = (Integer) value;

        // Verificar si la cédula es un número dentro del rango deseado
        if (cedula == null || cedula < 1 || cedula > 999999999) {
            FacesMessage message = new FacesMessage("La cédula debe ser un número entre 1 y 9999999999.");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }else{
            this.disable=false;
        }
    }
    
    public void validateFechaNacimiento(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Date fechaNacimiento = (Date) value;

        if (fechaNacimiento != null) {
            Calendar calNacimiento = Calendar.getInstance();
            calNacimiento.setTime(fechaNacimiento);

            // Obtener la fecha actual
            Calendar calActual = Calendar.getInstance();

            // Restar 18 años a la fecha actual
            calActual.add(Calendar.YEAR, -18);

            if (calNacimiento.after(calActual)) {
                FacesMessage message = new FacesMessage("Debes tener al menos 18 años para registrarte.");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
        }
    }
    
    public void validateLicencia(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String licencia = (String) value;

        // Verificar si la licencia contiene solo dígitos
        if (licencia != null && !licencia.matches("\\d+")) {
            FacesMessage message = new FacesMessage("La licencia no debe contener letras.");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
    
    public void validatePlaca(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String placa = (String) value;

        // Verificar que la placa tenga 6 caracteres y contenga solo letras o números
        if (placa != null && placa.length() == 6 && placa.matches("[a-zA-Z0-9]+")) {
            // Placa válida
        } else {
            FacesMessage message = new FacesMessage("La placa debe tener exactamente 6 caracteres y contener solo letras o números.");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
}
