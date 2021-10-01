package logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.ConexionBD;

public class Canciones {
    private int idCanciones;
    private String Titulo;
    private String Artista;
    private String Genero;
    private double Duracion;
    private String FechaSubida;
    private ConexionBD conexion;
    
    //inicializar variables
    
    public Canciones(int idCanciones, String Titulo, String Artista, String Genero, double Duracion, String FechaSubida, ConexionBD conexion){
        this.idCanciones=idCanciones;
        this.Titulo=Titulo;
        this.Artista=Artista;
        this.Genero=Genero;
        this.Duracion = Duracion;
        this.FechaSubida = FechaSubida;
        this.conexion = conexion;
    }
    
//****constructor por defecto
    public Canciones(){
        this.conexion=new ConexionBD();
    }
    
        //constructores set

    public void setIdCanciones(int idCanciones) {
        this.idCanciones = idCanciones;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public void setArtista(String Artista) {
        this.Artista = Artista;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public void setDuracion(double Duracion) {
        this.Duracion = Duracion;
    }

    public void setFechaSubida(String FechaSubida) {
        this.FechaSubida = FechaSubida;
    }

    public void setConexion(ConexionBD conexion) {
        this.conexion = conexion;
    }

    public int getIdCanciones() {
        return idCanciones;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getArtista() {
        return Artista;
    }

    public String getGenero() {
        return Genero;
    }

    public double getDuracion() {
        return Duracion;
    }

    public String getFechaSubida() {
        return FechaSubida;
    }

    public ConexionBD getConexion() {
        return conexion;
    }
    
    
    
     @Override
    public String toString() {
        return "Canciones{" + "idCanciones= "+idCanciones+
               " Titulo= "+Titulo+ " Artista= "+Artista+
                " Genero= "+Genero+" Duracion= "+Duracion+
                " Fecha de Subida= "+FechaSubida+ '}';
    }
    
    //Metodos que instrucciones en la bd
    public boolean guardarCanciones(){
    ConexionBD Connection = new ConexionBD();
    String sentencia ="INSERT INTO Canciones(Titulo, Artista, Genero, Duracion, FechaSubida,)"
            +"VALUES('"+this.Titulo+"',"+this.Artista+",'"
            +this.Genero+"',"+this.Duracion+this.FechaSubida+");";
//    System.out.println(sentencia);
//    conexion.insertarBD(sentencia);
//    conexion.closeConection();
//        return true;
    if (conexion.setAutoCommitBD(false)) {
        if (conexion.insertarBD(sentencia)) {
            conexion.commitBD();
            conexion.cerrarConexion();
            return true;
        } else {
            conexion.rollbackBD();
            conexion.cerrarConexion();
            return false;
            }
        } else {
            conexion.cerrarConexion();
            return false;
        }
    }

    
    //Actualizar
    
    public boolean actualizarCanciones(int id){
        ConexionBD conexion = new ConexionBD();
         String sentencia ="UPDATE Canciones(Titulo, Artista, Genero, Duracion, FechaSubida,)"
            +"VALUES('"+this.Titulo+"',"+this.Artista+",'"
            +this.Genero+"',"+this.Duracion+this.FechaSubida+");";
//        System.out.println(sentencia);
//        conexion.actualizarBD(sentencia);
//        conexion.closeConection();
//        return true;
        if (conexion.setAutoCommitBD(false)) {
        if (conexion.insertarBD(sentencia)) {
            conexion.commitBD();
            conexion.cerrarConexion();
            return true;
        } else {
            conexion.rollbackBD();
            conexion.cerrarConexion();
            return false;
            }
        } else {
            conexion.cerrarConexion();
            return false;
        }
    }
    
    //Borrar bd
    
    public boolean borrarCanciones(int id){
    ConexionBD conexion = new ConexionBD();
     String sentencia ="DELETE FROM Cancioness Where id='"+idCanciones+"';";
//    System.out.println(sentencia);
//    conexion.borrarBD(sentencia);
//    conexion.closeConection();
//    return true;
        if (conexion.setAutoCommitBD(false)) {
        if (conexion.insertarBD(sentencia)) {
            conexion.commitBD();
            conexion.cerrarConexion();
            return true;
        } else {
            conexion.rollbackBD();
            conexion.cerrarConexion();
            return false;
            }
        } else {
            conexion.cerrarConexion();
            return false;
        }
    }

    //Consultar
    public Canciones consultarCanciones(int id){
    ConexionBD conexion = new ConexionBD();//conexion
     String sentencia ="SELECT * FROM Cancioness WHERE id='"+idCanciones+"';";
      System.out.println(sentencia);
    ResultSet rs =conexion.consultarBD(sentencia);
    try{
        if(rs.next()){
            this.idCanciones=rs.getInt("id");
            this.Titulo=rs.getString("Titulo");
            this.Artista=rs.getString("Artista");
            this.Genero=rs.getString("Genero");
            this.Duracion=rs.getDouble("Duracion");
            this.FechaSubida=rs.getString("FechaSubida");
            conexion.closeConection();
            
        }else{
            return null;
        }
    }catch(SQLException error) {
         System.out.println("error: " + error.getMessage());
    }
    conexion.closeConection();
    return this;
    }
    
    //listar
    public List <Canciones> listaCancioness(){
    List<Canciones> listaCancioness =new ArrayList<>();
    String sentencia ="SELECT * FROM Canciones";
    ResultSet rs = conexion.consultarBD(sentencia);
    Canciones p;
        try{
            while(rs.next()){
                p=new Canciones();
                p.setIdCanciones(rs.getInt("idCanciones"));
                p.setTitulo(rs.getString("Titulo"));
                p.setArtista(rs.getString("Astista"));
                p.setGenero(rs.getString("Genero"));
                p.setDuracion(rs.getDouble("Duracion"));
                p.setFechaSubida(rs.getString("Fecha de Subida"));
                listaCancioness.add(p);
            }
        }catch(SQLException ex){
            System.out.println("Error en la consulta a la bd: "+ex.getMessage());
        }
        conexion.cerrarConexion();
        return listaCancioness;
    }
    
        public Canciones getCanciones() throws SQLException {
        ConexionBD conexion = new ConexionBD();
        String sql = "select * from contactos where idCanciones='" + this.idCanciones + "'";
        ResultSet rs = conexion.consultarBD(sql);
        if (rs.next()) {
            this.idCanciones = rs.getInt("idCanciones");
            this.Titulo = rs.getString("Titulo");
            this.Artista = rs.getString("Artista");
            this.Genero = rs.getString("Genero");
            this.Duracion = rs.getDouble("Duracion");
            this.FechaSubida = rs.getString("FechaSubida");
            conexion.cerrarConexion();
            return this;

        } else {
            conexion.cerrarConexion();
            return null;
        }
    
    }
}
