/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import bd.Manejador;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author redfi
 */
@WebService(serviceName = "ClinicaWS")
public class ClinicaWS {

    Manejador man = new Manejador();

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregar")
    @Oneway
    public void agregar(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre) {
        try {
            man.agregar(id, nombre);
        } catch (SQLException ex) {
            Logger.getLogger(ClinicaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listarTodos")
    public String listarTodos() {
        try {
            return man.listarTodo();
        } catch (SQLException ex) {
            Logger.getLogger(ClinicaWS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "buscarNombre")
    public String buscarNombre(@WebParam(name = "nombre") String nombre) {
        try {
            return man.buscarNombre(nombre);
        } catch (SQLException ex) {
            Logger.getLogger(ClinicaWS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "buscarEmail")
    public String buscarEmail(@WebParam(name = "email") String email) {
        try {
            return man.buscarEmail(email);
        } catch (SQLException ex) {
            Logger.getLogger(ClinicaWS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregarCita")
    @Oneway
    public void agregarCita(@WebParam(name = "fecha") String fecha, @WebParam(name = "hora") String hora, @WebParam(name = "motivo") String motivo, @WebParam(name = "idpaciente") int idpaciente, @WebParam(name = "idmedico") int idmedico) {
        try {
            man.agregarCita(fecha, hora, motivo, idpaciente, idmedico);
        } catch (SQLException ex) {
            Logger.getLogger(ClinicaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "buscarCita")
    public String buscarCita(@WebParam(name = "id_paciente") String id_paciente) {
        try {
            return man.buscarCita(id_paciente);
        } catch (SQLException ex) {
            Logger.getLogger(ClinicaWS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "buscarCitaPosponer")
    public String buscarCitaPosponer(@WebParam(name = "id_paciente") String id_paciente) {
        try {
            return man.buscarCitaPosponer(id_paciente);
        } catch (SQLException ex) {
            Logger.getLogger(ClinicaWS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "nuevoPaciente")
    @Oneway
    public void nuevoPaciente(@WebParam(name = "nombre") String nombre, @WebParam(name = "apellido_Paterno") String apellido_Paterno, @WebParam(name = "apellido_materno") String apellido_materno, @WebParam(name = "genero") String genero, @WebParam(name = "calle_numero") String calle_numero, @WebParam(name = "colonia") String colonia, @WebParam(name = "codigo_postal") String codigo_postal, @WebParam(name = "estado") String estado, @WebParam(name = "telefono") String telefono, @WebParam(name = "fecha_nacimiento") String fecha_nacimiento, @WebParam(name = "email") String email, @WebParam(name = "contrasena") String contrasena) {
        try {
            man.nuevoPaciente(nombre, apellido_Paterno, apellido_materno, genero, calle_numero, colonia, codigo_postal, estado, telefono, fecha_nacimiento, email, contrasena);
        } catch (SQLException ex) {
            Logger.getLogger(ClinicaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cambiarContra")
    @Oneway
    public void cambiarContra(@WebParam(name = "emailcontra") String emailcontra, @WebParam(name = "contrase") String contrase) {
        try {
            man.cambiarcontrasena(emailcontra, contrase);
        } catch (SQLException ex) {
            Logger.getLogger(ClinicaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "horaCita")
    public String horaCita(@WebParam(name = "hora") String hora) {
        try {
            return man.horaCita(hora);
        } catch (SQLException ex) {
            Logger.getLogger(ClinicaWS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cambiarDatos")
    @Oneway
    public void cambiarDatos(@WebParam(name = "id_paciente") String id_paciente, @WebParam(name = "calle_numero") String calle_numero, @WebParam(name = "colonia") String colonia, @WebParam(name = "codigo_postal") String codigo_postal, @WebParam(name = "estado") String estado, @WebParam(name = "telefono") String telefono, @WebParam(name = "email") String email) {
        try {
            man.cambiarDatos(id_paciente, calle_numero, colonia, codigo_postal, estado, telefono, email);
        } catch (SQLException ex) {
            Logger.getLogger(ClinicaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminarCita")
    @Oneway
    public void eliminarCita(@WebParam(name = "id_paciente") String id_paciente, @WebParam(name = "fecha_cita") String fecha_cita, @WebParam(name = "hora_cita") String hora_cita) {
        try {
            man.eliminarCita(id_paciente, fecha_cita, hora_cita);
        } catch (SQLException ex) {
            Logger.getLogger(ClinicaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
