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
public class Filtro {
    
    private String nombre;
    private String codigo;
    private String tipo;
    
    private int cantidad;
    private float precio;
    private boolean disponibilidad;
    
    public Filtro() {
    }

    public Filtro(String nombre, String codigo, String tipo, int cantidad, float precio, boolean disponibilidad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }

    public Filtro(String nombre, String tipo, int cantidad, float precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Filtro(String nombre, String codigo, String tipo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public Filtro(String Codigo, String Nombre,String Tipo,boolean Disponibilidad, float Precio, int Cantidad){
        this.codigo = Codigo;
        this.nombre = Nombre;
        this.tipo = Tipo;
        this.disponibilidad = Disponibilidad;
        this.precio = Precio;
        this.cantidad = Cantidad;
    }
    
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
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

    
    
}
