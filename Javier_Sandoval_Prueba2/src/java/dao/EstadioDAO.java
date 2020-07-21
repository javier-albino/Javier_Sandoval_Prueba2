package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Estadio;
import modelos.Ciudad;

/**
 *
 * @author javie
 */
public class EstadioDAO extends Conexion {
    
    public int registrar(Estadio  es ) throws SQLException{
        String sentencia = "Insert into estadio  values (?,?,?,?)";
        
        try{
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setString(1, es.getNombre());
            ps.setInt(2, es.getCapacidad());
            ps.setInt(3, es.getCiudad());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    public int modificar(Estadio estadio) throws SQLException{
        String sentencia = "update estadio set nombre = ? where id_estadio = ?";
        try{
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setString(1, estadio.getNombre());
            ps.setInt(2, estadio.getCapacidad());
            
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    public int eliminar(Estadio estadio) throws SQLException{
        String sentencia = "delete from estadio where id = ?";
        try{
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, estadio.getId());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    public Estadio obtenerEstadio(int id) throws SQLException{
        String sentencia = "select * from estadio where id=?";
        try{
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                   Ciudad c = new Ciudad(rs.getInt("id"),rs.getString("nombre"));
                 return (new Estadio(rs.getInt("id"),rs.getString("nombre"),rs.getInt("capacidad"),c));
            }else{
                return null;
            }
        }catch(Exception e ){
            return null;
        }finally{
            desconectar();
        }
    }
    public Ciudad obtenerCiudad(String nombre) throws SQLException{
        String sentencia = "select * from ciudad where nombre=?";
        try{
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return (new Ciudad(rs.getInt("id"),rs.getString("nombre")));
            }else{
                return null;
            }
        }catch(Exception e ){
            return null;
        }finally{
            desconectar();
        }
    }
    public ArrayList<Ciudad> obtenerCiudades() throws SQLException{
        String sentencia = "select * from ciudad";
        try{
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ResultSet rs = ps.executeQuery();
            ArrayList<Ciudad> Ciudades = new ArrayList();
            while(rs.next()){
                Ciudades.add(new Ciudad(rs.getInt("id"),rs.getString("nombre")));
            }
            return Ciudades;
        }catch(Exception e ){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
    
}