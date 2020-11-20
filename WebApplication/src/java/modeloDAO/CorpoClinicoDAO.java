package modeloDAO;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import oracle.jdbc.OracleTypes;
import java.sql.Connection;
import entidade.CorpoClinico;

import java.util.ArrayList;
import java.util.List;

	public class CorpoClinicoDAO extends DAO{
   
		public Statement stm;  
		public ResultSet res = null;  
		public void insertCorpoClinico(CorpoClinico c) throws SQLException, ClassNotFoundException, IOException {
			Connection conexao=null;
			CallableStatement clst = null;
     
			try{
				conexao = getConexao();
	
				clst = conexao.prepareCall("{call hospital.populaCorpoClinicoB(?,?,?)}");
				clst.setInt(1, Integer.parseInt(c.getEspecialidade()));
				clst.setString(2, c.getDocCorpoClinico());
				clst.setString(3, c.getNome());
				clst.execute();
			}catch(SQLException e){
				throw new RuntimeException(e);
			}finally{ 
				if (clst != null) { try { clst.close(); } catch (SQLException ex) {} }
				if (conexao != null) { try { conexao.close(); } catch (SQLException ex) {} }
			}
       
		}
       
		public List<CorpoClinico> getDados() throws SQLException, ClassNotFoundException, IOException {
	    	Connection conexao = null;
			CallableStatement clst = null;
	    	ResultSet rset;
	       
	    	List<CorpoClinico> listaCorpoClinico = new ArrayList<>();
	    	
	    	try{
				conexao = getConexao();
	
				clst = conexao.prepareCall("{call hospital.getPacientes(?)}");
				clst.registerOutParameter(1, OracleTypes.CURSOR);
				clst.execute();
				rset = (ResultSet)clst.getObject(1);
				
			while(rset.next()) {
				
				System.out.println(rset.getString ("nome_paciente"));
			}
			}catch(SQLException e){
				throw new RuntimeException(e);
			}finally{ 
				if (clst != null) { try { clst.close(); } catch (SQLException ex) {} }
				if (conexao != null) { try { conexao.close(); } catch (SQLException ex) {} }
			}
	    	return listaCorpoClinico;
	    }
      
}
