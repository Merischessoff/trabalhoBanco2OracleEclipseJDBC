package modeloDAO;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import oracle.jdbc.OracleTypes;
import java.sql.Connection;

import entidade.Consulta;
import entidade.CorpoClinico;
import entidade.Pessoa;

import java.util.ArrayList;
import java.util.List;

	public class PacienteDAO extends DAO{
   
		public Statement stm;  
		public ResultSet res = null;  
		
       
		public List<Consulta> getDadosPaciente() throws SQLException, ClassNotFoundException, IOException {
	    	Connection conexao = null;
			CallableStatement clst = null;
	    	ResultSet rset;
	       
	    	List<Consulta> listaConsulta = new ArrayList<>();
	    	
	    	try{
				conexao = getConexao();
	
				clst = conexao.prepareCall("{call hospital.getPacientes(?)}");
				clst.registerOutParameter(1, OracleTypes.CURSOR);
				clst.execute();
				rset = (ResultSet)clst.getObject(1);
				
			while(rset.next()) {
				Consulta consulta = new Consulta();
				consulta.setPaciente(rset.getString("nome_paciente"));
				consulta.setMedico(rset.getString("nome_medico"));
				consulta.setData(rset.getString("data_consulta"));
				listaConsulta.add(consulta);
			}
			}catch(SQLException e){
				throw new RuntimeException(e);
			}finally{ 
				if (clst != null) { try { clst.close(); } catch (SQLException ex) {} }
				if (conexao != null) { try { conexao.close(); } catch (SQLException ex) {} }
			}
	    	return listaConsulta;
	    }
      
}
