/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LN710Q
 */
public class Producto {
    
    private String nombre;
    private String codigo;
    private String tipo;
    
    private int cantidad;
    private double precio;
    private boolean disponibilidad;
    
    public Producto() {
    }

    public Producto(String nombre, String codigo, String tipo, int cantidad, double precio, boolean disponibilidad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }

    public Producto(String nombre, String tipo, int cantidad, double precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Producto(String nombre, String codigo, String tipo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public Producto(String Codigo, String Nombre,String Tipo,boolean Disponibilidad, double Precio, int Cantidad){
        this.codigo = Codigo;
        this.nombre = Nombre;
        this.tipo = Tipo;
        this.disponibilidad = Disponibilidad;
        this.precio = Precio;
        this.cantidad = Cantidad;
    }
    //cantidad = ?, precio =?

    public Producto(String Codigo,int cantidad, double precio) {
        this.codigo = Codigo;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Producto(String codigo) {
        this.codigo = codigo;
    }
    
    
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", codigo=" + codigo + ", tipo=" + tipo + ", cantidad=" + cantidad + ", precio=" + precio + ", disponibilidad=" + disponibilidad + '}';
    }

    
    
}
