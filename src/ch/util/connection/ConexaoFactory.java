package ch.util.connection;



public class ConexaoFactory {
	 public static Conexao getDatabase(String nome){
	        if(nome.equals("mysql")){
	            return new ConexaoMySQL();
	        }
	        return null;
	    }
}
