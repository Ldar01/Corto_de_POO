/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import interfaces.metodos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Producto;

/**
 *
 * @author LN710Q
 */
public class ProductoDao  implements metodos <Producto>{
    private static final Conexion con = Conexion.conectar();
    private static final String SQL_INSERT = "INSERT INTO productos(codigo, nombre, tipo, precio, cantidad) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE productos SET cantidad = ?, precio =? WHERE codigo=?";
    private static final String SQL_DELETE = "DELETE FROM productos WHERE codigo = ?";
    private static final String SQL_READ = "SELECT * FROM productos WHERE codigo =?";
    private static final String SQL_READALL = "SELECT * FROM productos";
    @Override
    public boolean create(Producto g) {
        PreparedStatement ps;
        try{
            ps = con.getCnx().prepareStatement(SQL_INSERT);
            ps.setString(1, g.getCodigo());
            ps.setString(2, g.getNombre());
            ps.setString(3, g.getTipo());
            ps.setDouble(4, g.getPrecio());
            ps.setInt(5, g.getCantidad());
            
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        PreparedStatement ps;
        try{
            ps = con.getCnx().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(Producto c) {
        PreparedStatement ps;
        try{
            System.out.println(c.getCodigo());
            ps = con.getCnx().prepareStatement(SQL_UPDATE);
            
            //ps.setString(1, c.getNombre());
            
            ps.setInt(1, c.getCantidad());
            ps.setDouble(2, c.getPrecio());
            ps.setString(3, c.getCodigo());
            
            
            
            if(ps.executeUpdate() >0){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public Producto read(Object key) {
        Producto f = null;
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            ps = con.getCnx().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                //String Codigo, String Nombre,String Tipo,boolean Disponibilidad, float Precio, int Cantidad
                f = new Producto(rs.getString(3), rs.getString(2), rs.getString(4),rs.getBoolean(7), rs.getFloat(6),rs.getInt(5));
            }
            rs.close();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return f;
    }

    @Override
    public ArrayList<Producto> readAll() {
        ArrayList<Producto> all = new ArrayList();
        Statement s;
        ResultSet rs;
        
        try{
            s = con.getCnx().prepareStatement(SQL_READALL);
            rs = s.executeQuery(SQL_READALL);
            
            while(rs.next()){
                all.add(new Producto(rs.getString(3), rs.getString(2), rs.getString(4),rs.getBoolean(7), rs.getDouble(6),rs.getInt(5)));
            }
            rs.close();
        }
        catch (SQLException ex){
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all;
    }
}
