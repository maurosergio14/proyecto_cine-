/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import java.sql.*;
import MODELO.*;
import java.util.*;

/**
 *
 * @author Dani Barros
 */
public class ClienteBD {

    private Connection conex;

    public ClienteBD(Conexion conexion) {
        try {
            conex = conexion.getConex();
        } catch (Exception e) {
            System.out.println("Error al obtener la conexion en ClienteBD");
        }
    }

    public void guardarCliente(Cliente cliente) {
        try {

            String instrucciones = "INSERT INTO cliente (nombre, apellido, dni) VALUES (?, ?, ?);";

            PreparedStatement ps = conex.prepareStatement(instrucciones, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getDni());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys(); //ID
            
            if(rs.next()){
                cliente.setId_cliente(rs.getInt(1));
            }else{
                System.out.println("No se pudo obtener el id de Cliente luego de insertar un cliente");
            }
            ps.close();
            
        } catch (Exception e) {
            System.out.println("Error al querer guardar cliente");
        }
    }
    
    public List<Cliente> obtenerClientes(){
        List<Cliente> clientes = new ArrayList<Cliente>();
        
        try {
            String instrucciones = "SELECT * FROM cliente;";
            PreparedStatement ps = conex.prepareStatement(instrucciones);
            ResultSet resultSet = ps.executeQuery();
            
            Cliente cliente;
            
            while(resultSet.next()){
                cliente = new Cliente();
                cliente.setId_cliente(resultSet.getInt("id_cliente"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setApellido(resultSet.getString("apellido"));
                cliente.setDni(resultSet.getInt("dni"));
                
                clientes.add(cliente);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al obtener Clientes");
        }
        return clientes;
    }
    
    public void borrarCliente(int id){
        try {
            
            String instrucciones = "DELETE FROM cliente WHERE id_cliente = ?;";
            PreparedStatement ps = conex.prepareStatement(instrucciones, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al querer borrar un Cliente");
        }
    }
    
    public void actualizarCliente(Cliente cliente){
        try {
            
            String instrucciones = "UPDATE cliente SET nombre = ?, apellido = ?, dni = ?;";
            
            PreparedStatement ps = conex.prepareStatement(instrucciones);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getDni());
            ps.executeUpdate();
            
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al querer actualizar el cliente "+cliente.getNombre()+" "+cliente.getApellido());
        }
    }
    
    public Cliente buscarCliente(int id){
        Cliente cliente=null;
        
        try {
            
            String instrucciones = "SELECT * FROM cliente WHERE id_cliente = ?;";
            
            PreparedStatement ps = conex.prepareStatement(instrucciones, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            
            ResultSet resultSet = ps.executeQuery();
            
            while(resultSet.next()){
                cliente = new Cliente();
                cliente.setId_cliente(resultSet.getInt("id_cliente"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setApellido(resultSet.getString("apellido"));
                cliente.setDni(resultSet.getInt("dni"));
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al querer buscar un cliente"+e.getMessage());
        }
        return cliente;
    }
    
    public List<Cliente> obtenerClientesXfecha(int idCliente, String fecha){
        List<Cliente> clientes = new ArrayList<Cliente>();
        
        try {
            String instrucciones = "SELECT * FROM cliente, ticket WHERE fecha_ticket='"+fecha+"' AND "
                    + "ticket.id_cliente = "+idCliente+";";
            PreparedStatement ps = conex.prepareStatement(instrucciones);
            ResultSet resultSet = ps.executeQuery();
            
            Cliente cliente;
            
            while(resultSet.next()){
                cliente = new Cliente();
                cliente.setId_cliente(resultSet.getInt("id_cliente"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setApellido(resultSet.getString("apellido"));
                cliente.setDni(resultSet.getInt("dni"));
                
                clientes.add(cliente);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al obtener Clientes"+e);
        }
        return clientes;
    }

}
