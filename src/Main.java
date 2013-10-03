import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class Main{
 
    //CONEXION A LA BASE DE DATOS
  public static void main(String[] argv) throws ClassNotFoundException, SQLException {

      
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banco","root","root");
    


///////////////////////////////////SELECT//////////////////////////////////////
//int idEntidadBancaria = 1001;  
String selectSQL = "SELECT idEntidad,nombre,tipoEntidadBancaria FROM entidadbancaria WHERE idEntidad = ?";
PreparedStatement preparedStatement = conn.prepareStatement(selectSQL); // Objeto que contine el SQL y los valores incognitas
preparedStatement.setInt(1, 1001); //el primer parametro que encuentra se le da el valor de idEntidadBancaria sustituyendose en el where
ResultSet rs = preparedStatement.executeQuery();
while (rs.next()) {
        String idEntidad = rs.getString("idEntidad");
        String nombre = rs.getString("nombre");
        String tipoEntidadBancaria = rs.getString("tipoEntidadBancaria");
        System.out.println(" "+idEntidad+" "+nombre+" "+tipoEntidadBancaria);
}



///////////////////////////////////////////INSERT//////////////////////////////
String insertTableSQL = "INSERT INTO entidadbancaria"
		+ "(idEntidad, codigoEntidad, nombre, cif, tipoEntidadBancaria) VALUES"
		+ "(?,?,?,?,?)";
PreparedStatement preparedStatement2 = conn.prepareStatement(insertTableSQL);
preparedStatement2.setString(1, "11");
preparedStatement2.setString(2, "3");
preparedStatement2.setString(3, "Caixa");
preparedStatement2.setString(4, "3333");
preparedStatement2.setString(5, "banco");
// execute insert SQL stetement
preparedStatement2 .executeUpdate();



////////////////////////////////// DELETE /////////////////////////////////////
String deleteSQL = "DELETE FROM entidadbancaria WHERE idEntidad = ?";
PreparedStatement preparedStatement3 = conn.prepareStatement(deleteSQL);
preparedStatement.setInt(1, 11);
// execute delete SQL stetement
preparedStatement3.executeUpdate();


conn.close(); 
System.out.println("Conexion creada con exito");

/* PREVENCION DE ERRORES
 * 
 * String codigo;
 * //solo obtiene UNA LINEA busca por clave primaria
if (resultSet.next()==true){
    codigo=resultSet.getString("codigo");
   
    if(resultSet.next==true){
    throw new RuntimeException("Existe mas de una entidad"+idEntidadBancaria);
    }
  }else{
        RuntimeRuntimeException runtimeException=new RuntimeException("No existe la entidad"+idEntidadBancaria);
    }
}
*/

}  
}