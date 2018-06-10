/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author redfi
 */
public class Manejador {
    public Connection getConexion() throws SQLException
    {
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/clinicadental", "root","");
        } catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return con;
    }
    
    public void agregar(int id,String nombre) throws SQLException{
        Statement stmt1=getConexion().createStatement();
        stmt1.executeUpdate("INSERT INTO prueba (id,nombre) values ("+id+",'"+nombre+"');");
        stmt1.close();
    }
    
    public void cambiarcontrasena(String email,String contrase) throws SQLException{
        Statement stmt1=getConexion().createStatement();
        stmt1.executeUpdate("update paciente set contrasena='"+contrase+"' where email='"+email+"';");
        stmt1.close();
    }
    
    
    public String listarTodo() throws SQLException
    {
        String cad="";
        Statement stmt=getConexion().createStatement();
        
        ResultSet rs = stmt.executeQuery("Select * from prueba");
        while (rs.next())
        {
            cad=cad+rs.getString(1)+"|"+rs.getString(2)+"\n";
        }
        
        rs.close();
        stmt.close();
        return cad;
    }
    
    public String buscarNombre(String nombre) throws SQLException
    {
        String cad="";
        Statement stmt=getConexion().createStatement();
        ResultSet rs=stmt.executeQuery("select * from prueba where nombre='"+nombre+"'");
        
        while (rs.next())
        {
            cad=cad+rs.getString(1)+"|"+rs.getString(2)+"\n";
        }
        rs.close();
        stmt.close();
        return cad;
    }
    
    public String buscarEmail(String email) throws SQLException
    {
        String cad="";
        Statement stmt=getConexion().createStatement();
        ResultSet rs=stmt.executeQuery("select id_paciente,nombre,apellido_Paterno,email,contrasena,apellido_Materno from paciente where email='"+email+"'");
        
        while (rs.next())
        {
            cad=cad+rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6)+"\n";
        }
        rs.close();
        stmt.close();
        return cad;
    }
    
    public void agregarCita(String fecha,String hora,String motivo,int id_paciente,int id_medico) throws SQLException{
        Statement stmt1=getConexion().createStatement();
        stmt1.executeUpdate("INSERT INTO cita (fecha_cita,hora_cita,motivo,id_paciente,id_medico) values "
                + "('"+fecha+"','"+hora+"','"+motivo+"',"+id_paciente+","+id_medico+");");
        stmt1.close();
    }
    
    public String buscarCita(String id_paciente) throws SQLException
    {
        String cad="";
        Statement stmt=getConexion().createStatement();
        ResultSet rs=stmt.executeQuery("select fecha_cita,hora_cita,nombre,apellido_paterno,apellido_materno from cita natural join medico_dentista where id_paciente="+id_paciente+" ORDER BY fecha_cita ASC");
        
        while (rs.next())
        {
            cad=cad+"Fecha: "+rs.getString(1)+"    Hora: "+rs.getString(2)+"    Doctor: "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+";";
        }
        rs.close();
        stmt.close();
        return cad;
    }
    
    public String buscarCitaPosponer(String id_paciente) throws SQLException
    {
        String cad="";
        Statement stmt=getConexion().createStatement();
        ResultSet rs=stmt.executeQuery("select fecha_cita,hora_cita,nombre,apellido_paterno,apellido_materno from cita natural join medico_dentista where id_paciente="+id_paciente+" ORDER BY fecha_cita ASC");
        int contador=1;
        while (rs.next())
        {
            cad=cad+"Cita N°: "+contador+" Fecha: "+rs.getString(1)+"    Hora: "+rs.getString(2)+"    Doctor: "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+";";
            contador++;
        }
        rs.close();
        stmt.close();
        return cad;
    }
   
    
    public void nuevoPaciente(String nombre,String apellido_Paterno,String apellido_materno,String genero,String calle_numero,String colonia,String codigo_postal,String estado,String telefono,String fecha_nacimiento,String email,String contrasena) throws SQLException
    {
        Statement stmt1=getConexion().createStatement();
        stmt1.executeUpdate("INSERT INTO paciente (nombre,apellido_Paterno,apellido_materno,genero,calle_numero,colonia,codigo_postal,estado,telefono,fecha_nacimiento,email,contrasena) values "
                + "('"+nombre+"','"+apellido_Paterno+"','"+apellido_materno+"','"+genero+"','"+calle_numero+"','"+colonia+"','"+codigo_postal+"','"+estado+"','"+telefono+"','"+fecha_nacimiento+"','"+email+"','"+contrasena+"');"     );
        stmt1.close();
    }
    
    public void eliminarCita(String id_paciente,String fecha_cita, String hora_cita) throws SQLException
    {
        Statement stmt1=getConexion().createStatement();
        stmt1.executeUpdate("delete from cita where id_paciente="+id_paciente+" and fecha_cita='"+fecha_cita+"' and hora_cita='"+hora_cita+"'");
        stmt1.close();
    }

    public String horaCita(String hora) throws SQLException {
        String cad="";
        Statement stmt=getConexion().createStatement();
        ResultSet rs=stmt.executeQuery("select hora_cita from cita where fecha_cita='"+hora+"';");
        
        while (rs.next())
        {
            cad=cad+rs.getString(1)+";";
        }
        rs.close();
        stmt.close();
        return cad;
    }
    
    public void cambiarDatos(String id_paciente,String calle_numero,String colonia,String codigo_postal,String estado,String telefono, String email) throws SQLException{
        Statement stmt1=getConexion().createStatement();
        
        if(!calle_numero.equals("*"))
        {
            stmt1.executeUpdate("update paciente set calle_numero='"+calle_numero+"' where id_paciente="+id_paciente+";");
        }
        else
        {
            
        }
        if(!colonia.equals("*"))
        {
            stmt1.executeUpdate("update paciente set colonia='"+colonia+"' where id_paciente="+id_paciente+";");
        }
        else
        {
            
        }
        if(!codigo_postal.equals("*"))
        {
            stmt1.executeUpdate("update paciente set codigo_postal='"+codigo_postal+"' where id_paciente="+id_paciente+";");
        }
        else
        {
            
        }
        if(!estado.equals("*"))
        {
            stmt1.executeUpdate("update paciente set estado='"+estado+"' where id_paciente="+id_paciente+";");
        }
        else
        {
            
        }
        if(!telefono.equals("*"))
        {
            stmt1.executeUpdate("update paciente set telefono='"+telefono+"' where id_paciente="+id_paciente+";");
        }
        else
        {
            
        }
        if(!email.equals("*"))
        {
            stmt1.executeUpdate("update paciente set email='"+email+"' where id_paciente="+id_paciente+";");
        }
        else
        {
            
        }
        stmt1.close();
    }
}
