/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.Butaca;
import MODELO.Conexion;
import MODELO.FuncionVerPelicula;
import MODELO.Pelicula;
import MODELO.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author LuisPc-Master
 */
public class FuncionVerPelicula_bd {

    private Connection conex;
    List butacas;
    public FuncionVerPelicula_bd() {

    }

    public FuncionVerPelicula_bd(Conexion conexion) {
        conex = conexion.getConex();
        try {
            conex = conexion.getConex();
        } catch (Exception ex) {
            System.out.println("Error al obtener conexion" + ex.getMessage());
        }

    }

    /*butacas Libres */
 /*SELECT * FROM butaca WHERE butaca.id_Butaca NOT IN (SELECT ticket.id_Butaca, verPelicula.idSala FROM ticket,verPelicula,sala,butaca WHERE 
    funcionverPelicula.id_sala = sala.id_Sala && ticked.id_Butaca = butaca.idButaca && verPelicula.id_verPelicula = ticket.id_feucnionVerPelicula 
    && funcionVerPelicula.hora_desde = 22:0000 );";*/
    public List<Butaca> verLugaresLibres() {
        List<Butaca> butacas = new ArrayList<Butaca>();
        //crear butacasList en Butaca_bd
        try {
            String sql = "SELECT * FROM butaca WHERE estado==false;";

            PreparedStatement ps = conex.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            Butaca butaca;

            while (rs.next()) {
                butaca = new Butaca();
                butaca.setId_butaca(rs.getInt("id_butaca"));
                butaca.setFila(rs.getInt("fila"));
                butaca.setColumna(rs.getInt("columna"));//butaca.setColumna(rs.getInt("columnas"))
                butaca.setEstado(rs.getBoolean("true"));
                butacas.add(butaca);
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener las butacas Libres: " + ex.getMessage());
        }

        return butacas;
    }
//------------------------------------------------------------------------------

    /* que  butacas son las ocupadas y salas*/
    //SELECT ticket.id_Butaca, verPelicula.idSala FROM ticket,verPelicula,sala,butaca WHERE 
    //funcionverPelicula.id_sala = sala.id_Sala && ticked.id_Butaca = butaca.idButaca && verPelicula.id_verPelicula = ticket.id_feucnionVerPelicula 
    //&& funcionVerPelicula.hora_desde = 22:0000 ;";
    public List<Butaca> verLugaresOcupados() {
        List<Butaca> butacas = new ArrayList<Butaca>();
        //crear butacasList en Butaca_bd
        try {
            String sql = "SELECT * FROM butaca WHERE estado==false;";

            PreparedStatement ps = conex.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            Butaca butaca;

            while (rs.next()) {
                butaca = new Butaca();
                butaca.setId_butaca(rs.getInt("id_butaca"));
                butaca.setFila(rs.getInt("fila"));
                butaca.setColumna(rs.getInt("columna"));//butaca.setColumna(rs.getInt("columnas"))
                //butaca.setEstado(rs.getBoolean("true"));
                butacas.add(butaca);
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener las butacas Libres: " + ex.getMessage());
        }

        return butacas;
    }

//------------------------------------------------------------------------------    
    public List<FuncionVerPelicula> obtenerVerPelicula(Sala sala, String hora_desde) {
        List<FuncionVerPelicula> verPelicula = new ArrayList<>();
        try {
            //String sql = "SELECT * FROM funcionVerPelicula;";
            String sql = "SELECT * FROM sala,butaca WHERE id_sala ;";
            PreparedStatement ps = conex.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            FuncionVerPelicula funcionVerPelicula;

            while (rs.next()) {

                funcionVerPelicula = new FuncionVerPelicula();
                funcionVerPelicula.setId_verPelicula(rs.getInt("id_verPelicula"));
                //  funcionVerPelicula.getPelicula(rs.getInt("id_pelicula"));
                // funcionVerPelicula.setId_sala(rs.getInt("id_sala"));
                funcionVerPelicula.setHorario_desde(rs.getTime("horario_desde"));
                funcionVerPelicula.setHorario_hasta(rs.getTime("horario_hasta"));

                verPelicula.add(funcionVerPelicula);
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.print("Error al obtener verPeliculas" + ex.getMessage());
        }

        return verPelicula;

    }

//------------------------------------------------------------------------------
    //listas las Peliculas proyectadas en una determinada sala en un horario determinado
    public List<FuncionVerPelicula> obtenerVerPeliculaProyectadas(int id_pelicula /*, String horario_desde*/) {
        List<FuncionVerPelicula> verPelicula = new ArrayList<FuncionVerPelicula>();
        try {
            String sql = "SELECT * FROM funcionVerPelicula WHERE id_pelicula =? AND hora_desde =? ;";

            PreparedStatement ps = conex.prepareStatement(sql);

            ps.setInt(1, id_pelicula);

            ResultSet rs = ps.executeQuery();

            FuncionVerPelicula funcionVerPelicula;

            while (rs.next()) {

                funcionVerPelicula = new FuncionVerPelicula();
                funcionVerPelicula.setId_verPelicula(rs.getInt("id_verPelicula"));

                Pelicula pelicula = buscarPeliculav2(rs.getInt("id_pelicula"));
                funcionVerPelicula.setPelicula(pelicula);

                // Sala sala = buscarSalav2(rs.getInt("id_sala"));
                //funcionVerPelicula.setSala(sala);
                funcionVerPelicula.setHorario_desde(rs.getTime("hora_desde"));
                funcionVerPelicula.setHorario_hasta(rs.getTime("hora_hasta"));

                verPelicula.add(funcionVerPelicula);
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.print("Error al obtener verPeliculas" + ex.getMessage());
        }

        return verPelicula;

    }
//------------------------------------------------------------------------------

   public List<FuncionVerPelicula> obtenerSalasProyectadas(int id_pelicula /*, String horario_desde*/) {
        List<FuncionVerPelicula> verPelicula = new ArrayList<FuncionVerPelicula>();
        try {
            String sql = "SELECT * FROM funcionVerPelicula WHERE id_pelicula =? , hora_desde =? ;";

            PreparedStatement ps = conex.prepareStatement(sql);

            ps.setInt(1, id_pelicula);

            ResultSet rs = ps.executeQuery();

            FuncionVerPelicula funcionVerPelicula;

            while (rs.next()) {

                funcionVerPelicula = new FuncionVerPelicula();
                funcionVerPelicula.setId_verPelicula(rs.getInt("id_verPelicula"));

                Pelicula pelicula = buscarPeliculav2(rs.getInt("id_pelicula"));
                funcionVerPelicula.setPelicula(pelicula);

               
                funcionVerPelicula.setHorario_desde(rs.getTime("hora_desde"));
                funcionVerPelicula.setHorario_hasta(rs.getTime("hora_hasta"));

                verPelicula.add(funcionVerPelicula);
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.print("Error al obtener verPeliculas" + ex.getMessage());
        }

        return verPelicula;

    }

//------------------------------------------------------------------------------    
    public Sala buscarSalav2(int id_sala) {
        Sala_bd salaData = new Sala_bd((Conexion) conex);
        return salaData.buscarSala(id_sala);
    }

    public Pelicula buscarPeliculav2(int id_Pelicula) {

        Pelicula_bd peliculaData = new Pelicula_bd((Conexion) conex);
        return peliculaData.buscarPelicula(id_Pelicula);

    }

//------------------------------------------------------------------------------    
    public void borrarVerPelicula(int id_verPelicula) {

        try {
            String sql = "DELETE FORM funcionverpelicula WHERE id_funcionverPelicula =?;";

            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_verPelicula);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al borrar Ver Pelicula" + ex.getMessage());
        }

    }

    public void actualizarVerPelicula(FuncionVerPelicula verPelicula) {

        try {
            String sql = "UPDATE funcionverpelicula SET id_pelicula ,id_sala,horario_desde,horario_hasta VALUES(?,?,?,?);";
            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, verPelicula.getPelicula().getId());
            ps.setInt(1, verPelicula.getSala().getId_sala());
            ps.setTime(3, verPelicula.getHorario_desde());
            ps.setTime(3, verPelicula.getHorario_hasta());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al actualizar proyeccion");
        }

    }

    public FuncionVerPelicula buscarVerPelicula(int id_verPelicula) {
        FuncionVerPelicula verPelicula = null;
        try {
            String sql = "SELECT * FROM cliente WHERE id_verPelicula=?;";
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, id_verPelicula);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                verPelicula = new FuncionVerPelicula();
                verPelicula.setId_verPelicula(rs.getInt("id_verPelicula"));
                          
                verPelicula.setHorario_desde(rs.getTime("hora_desde"));
                verPelicula.setHorario_hasta(rs.getTime("hora_hasta"));

                Sala_bd salaData = new Sala_bd((Conexion) conex);
                Sala sala = salaData.buscarSala(rs.getInt("id_sala"));
                
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al buscar funcion ver Pelicula" + ex.getMessage());
        }

        return verPelicula;

    }

    public void guardarFuncion(FuncionVerPelicula verPelicula) { //guardarProyeccion

        try {
            String sql = "INSERT INTO funcionverpelicula(id_pelicula, id_sala, horario_desde, horario_hasta)VALUES(?,?,?,?);";

            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, verPelicula.getPelicula().getId());
            ps.setInt(2, verPelicula.getSala().getId_sala());
            ps.setTime(3, verPelicula.getHorario_desde());
            ps.setTime(4, verPelicula.getHorario_hasta());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                verPelicula.setId_verPelicula(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id");
            }

            /*Butaca butaca;

            for (int i = 1; i < 10; i++) {

                for (int j = 1; j < 10; j++) {
                    butaca = new Butaca();
                    String sql2 = "INSERT INTO butaca (id_verPelicula,fila,columna,estado)VALUES(?,?,?,?);";
                    ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, j);
                    ps.setInt(1, j);
                    ps.setInt(i, 0);
                    ps.setInt(i, verPelicula.getId_verPelicula());
                }

            }
            
          butacas = new ArrayList();
            
          Butaca_bd  butacaData = new Butaca_bd();
          
          butacas = obtenerButacas(verPelicula.getId_verPelicula());
          verPelicula.setButacas((ArrayList<Butaca>) butacas);
          */
            ps.close();

        } catch (SQLException ex) {
            System.out.print("Error al guardar Funncion Ver Pelicula" + ex.getMessage());
        }

    }
    
    
   public List<Butaca> obtenerButacas(int id) throws SQLException{
       
     List<Butaca> butacas = new ArrayList<>();
     
     FuncionVerPelicula verPelicula = new FuncionVerPelicula();
     Butaca butaca;
     
     try{
         String sql = "SELECT * FROM sala,butaca WHERE id_verPelicula = "+id+" ;";
          PreparedStatement ps = conex.prepareStatement(sql);
         
         ResultSet rs = ps.executeQuery();
         while(rs.next()){
             butaca = new Butaca();
             butaca.setFila(rs.getInt("fila"));
             butaca.setColumna(rs.getInt("columna"));//Int porque columnas seria int;
             butaca.setEstado(rs.getBoolean("estado"));//Estado debe tener butaca
  
           /* FuncionVerPelicula_bd pd = new FuncionVerPelicula_bd((Conexion) conex);
             
             verPelicula = pd.buscarVerPelicula(id);
             
             butaca.setVerPelicula(verPelicula);*/
             butacas.add(butaca);
             
         }
         ps.close();
         
         
     }catch(SQLException ex){
         System.out.println("Error al buscar " + ex.getMessage());
     }
     
     return butacas;
       
   }
    
    
    

}



    /*public Pelicula buscarPelicula(int id_Pelicula) {
        Pelicula pelicula = null;

        try {
            String sql = "SELECT * FROM pelicula WHERE id_pelicula =?;";

            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, id_Pelicula);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pelicula = new Pelicula();
                pelicula.setId(rs.getInt("id_pelicula"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setGenero(rs.getString("genero"));
                pelicula.setDuracion(rs.getString("duracion"));
                pelicula.setAutor(rs.getString("autor"));
                pelicula.setIdioma(rs.getString("idioma"));
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.print("Error al Buscar Pelicula" + ex.getMessage());
        }
        return pelicula;
    }*/

   /* public Sala buscarSala(int id_Sala) {
        Sala sala = null;

        try {
            String sql = "SELECT * FROM sala WHERE id_pelicula =?;";

            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, id_Sala);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                sala = new Sala();
                sala.setId_sala(rs.getInt("id_sla"));
                sala.setUbicacion(rs.getString("ubicacion"));

            }
            ps.close();

        } catch (SQLException ex) {
            System.out.print("Error al Buscar Sala" + ex.getMessage());
        }
        return sala;
    }*/
