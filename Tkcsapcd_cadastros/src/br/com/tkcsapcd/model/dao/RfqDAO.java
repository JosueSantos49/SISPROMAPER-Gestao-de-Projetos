/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tkcsapcd.conexao.InterfacePool;
import br.com.tkcsapcd.model.bean.Rfq;
import br.com.tkcsapcd.model.util.Conexao;

public class RfqDAO implements InterfaceRfqDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public RfqDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM rfq WHERE codigo = ?;";

			ps = con.prepareStatement(sqlExcluir);
			ps.setInt(1, codigo);//setando
			ps.executeUpdate();
			ps.close();
		} finally 
		{
			 // fecha todos os recursos e devolve a conexao ao pool	        
	        if (ps != null && !ps.isClosed() ) {
	            try { ps.close(); } catch (SQLException e) { ; }
	            ps = null;
	        }
	        if (con != null && !con.isClosed() ) {
	            try { con.close(); } catch (SQLException e) { ; }
	            con = null;
	        }
		}			
	}
	private void setPreparedStatement(Rfq rfq, PreparedStatement ps) throws SQLException 
	{
			ps.setDate(1, new java.sql.Date(rfq.getData().getTime() )); //transforma o java util date em java sql date				
			ps.setInt(2, rfq.getNumerorfq());
			ps.setString(3, rfq.getPrazoentrega());
			ps.setString(4, rfq.getContatocomercial());
			ps.setString(5, rfq.getContatotecnico());
			ps.setDate(6, new java.sql.Date(rfq.getDatalimite().getTime() )); //transforma o java util date em java sql date
			ps.setString(7, rfq.getTermopagamento());
			ps.setString(8, rfq.getTempogarantia());
			ps.setString(9, rfq.getOutracondicao());
			ps.setObject(10, rfq.getEmpresa());
			ps.setString(11, rfq.getEndereco());
			ps.setString(12, rfq.getCidade());		
			ps.setString(13, rfq.getEstado());
			ps.setString(14, rfq.getTelefone());
			
			ps.setInt(15, rfq.getCodigoitem1());	
			ps.setInt(16, rfq.getCodigoitem2());
			ps.setInt(17, rfq.getCodigoitem3());
			ps.setInt(18, rfq.getCodigoitem4());
			ps.setInt(19, rfq.getCodigoitem5());
			ps.setInt(20, rfq.getCodigoitem6());
			ps.setInt(21, rfq.getCodigoitem7());
			ps.setInt(22, rfq.getCodigoitem8());
			ps.setInt(23, rfq.getCodigoitem9());
			ps.setInt(24, rfq.getCodigoitem10());
			ps.setInt(25, rfq.getCodigoitem11());
			ps.setInt(26, rfq.getCodigoitem12());
			ps.setInt(27, rfq.getCodigoitem13());
			ps.setInt(28, rfq.getCodigoitem14());
			ps.setInt(29, rfq.getCodigoitem15());
			ps.setInt(30, rfq.getCodigoitem16());
			ps.setInt(31, rfq.getCodigoitem17());
			ps.setInt(32, rfq.getCodigoitem18());
			ps.setInt(33, rfq.getCodigoitem19());
			ps.setInt(34, rfq.getCodigoitem20());	
			
			ps.setString(35, rfq.getDescricao1());
			ps.setString(36, rfq.getDescricao2());
			ps.setString(37, rfq.getDescricao3());
			ps.setString(38, rfq.getDescricao4());
			ps.setString(39, rfq.getDescricao5());
			ps.setString(40, rfq.getDescricao6());
			ps.setString(41, rfq.getDescricao7());
			ps.setString(42, rfq.getDescricao8());
			ps.setString(43, rfq.getDescricao9());
			ps.setString(44, rfq.getDescricao10());
			ps.setString(45, rfq.getDescricao11());
			ps.setString(46, rfq.getDescricao12());
			ps.setString(47, rfq.getDescricao13());
			ps.setString(48, rfq.getDescricao14());
			ps.setString(49, rfq.getDescricao15());
			ps.setString(50, rfq.getDescricao16());
			ps.setString(51, rfq.getDescricao17());
			ps.setString(52, rfq.getDescricao18());
			ps.setString(53, rfq.getDescricao19());
			ps.setString(54, rfq.getDescricao20());
			
			ps.setInt(55, rfq.getQtd1());
			ps.setInt(56, rfq.getQtd2());
			ps.setInt(57, rfq.getQtd3());
			ps.setInt(58, rfq.getQtd4());
			ps.setInt(59, rfq.getQtd5());
			ps.setInt(60, rfq.getQtd6());
			ps.setInt(61, rfq.getQtd7());
			ps.setInt(62, rfq.getQtd8());
			ps.setInt(63, rfq.getQtd9());
			ps.setInt(64, rfq.getQtd10());
			ps.setInt(65, rfq.getQtd11());
			ps.setInt(66, rfq.getQtd12());
			ps.setInt(67, rfq.getQtd13());
			ps.setInt(68, rfq.getQtd14());
			ps.setInt(69, rfq.getQtd15());
			ps.setInt(70, rfq.getQtd16());
			ps.setInt(71, rfq.getQtd17());
			ps.setInt(72, rfq.getQtd18());
			ps.setInt(73, rfq.getQtd19());
			ps.setInt(74, rfq.getQtd20());
			
			ps.setDouble(75, rfq.getPuitem1());
			ps.setDouble(76, rfq.getPuitem2());
			ps.setDouble(77, rfq.getPuitem3());
			ps.setDouble(78, rfq.getPuitem4());
			ps.setDouble(79, rfq.getPuitem5());
			ps.setDouble(80, rfq.getPuitem6());
			ps.setDouble(81, rfq.getPuitem7());
			ps.setDouble(82, rfq.getPuitem8());
			ps.setDouble(83, rfq.getPuitem9());
			ps.setDouble(84, rfq.getPuitem10());
			ps.setDouble(85, rfq.getPuitem11());
			ps.setDouble(86, rfq.getPuitem12());
			ps.setDouble(87, rfq.getPuitem13());
			ps.setDouble(88, rfq.getPuitem14());
			ps.setDouble(89, rfq.getPuitem15());
			ps.setDouble(90, rfq.getPuitem16());
			ps.setDouble(91, rfq.getPuitem17());
			ps.setDouble(92, rfq.getPuitem18());
			ps.setDouble(93, rfq.getPuitem19());
			ps.setDouble(94, rfq.getPuitem20());			
			
			ps.setDouble(95, rfq.getTotal()); 
			ps.setDouble(96, rfq.getFrete());
			
			ps.setLong(97, rfq.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public Rfq getRfq(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM rfq WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<Rfq> resultado = getListarfq(rs);
			
			if (resultado.size() > 0)			
				return resultado.get(0);//pegando elemento por chave (unico projeto!).			
			
			ps.close();			
		} finally 
		{
			 // fecha todos os recursos e devolve a conexao ao pool	        
			if (rs != null && !rs.isClosed() ) {
	            try { rs.close(); } catch (SQLException e) { ; }
	            rs = null;
	        }
			if (ps != null && !ps.isClosed() ) {
	            try { ps.close(); } catch (SQLException e) { ; }
	            ps = null;
	        }
	        if (con != null && !con.isClosed() ) {
	            try { con.close(); } catch (SQLException e) { ; }
	            con = null;
	        }
		}
		return null;
	}
	/*---------------------------------------------------------------------------------------------------------------------------------------*/

		//Metodo p confirma objetivo. Resulmir linhas de códigos, que pode ser usados em outros métodos. (ex: resultado = getListaCliente(rs); ou List<Cliente> resultado = getListaCliente(rs);)
		private List<Rfq> getListarfq(ResultSet rs) throws SQLException	{
				List<Rfq> resultado = new ArrayList<Rfq>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				Rfq rfq = new Rfq();
				
				rfq.setData(rs.getDate("data"));
				rfq.setNumerorfq(rs.getInt("numerorfq"));
				rfq.setPrazoentrega(rs.getString("prazoentrega"));
				rfq.setContatocomercial(rs.getString("contatocomercial"));
				rfq.setContatotecnico(rs.getString("contatotecnico"));
				rfq.setDatalimite(rs.getDate("datalimite"));
				rfq.setTermopagamento(rs.getString("termopagamento"));
				rfq.setTempogarantia(rs.getString("tempogarantia"));
				rfq.setOutracondicao(rs.getString("outracondicao"));
				rfq.setEmpresa(rs.getString("empresa"));				
				rfq.setEndereco(rs.getString("endereco"));					
				rfq.setCidade(rs.getString("cidade"));
				rfq.setEstado(rs.getString("estado"));
				rfq.setTelefone(rs.getString("telefone"));
				
				rfq.setCodigoitem1(rs.getInt("codigoitem1"));
				rfq.setCodigoitem2(rs.getInt("codigoitem2"));
				rfq.setCodigoitem3(rs.getInt("codigoitem3"));
				rfq.setCodigoitem4(rs.getInt("codigoitem4"));
				rfq.setCodigoitem5(rs.getInt("codigoitem5"));
				rfq.setCodigoitem6(rs.getInt("codigoitem6"));
				rfq.setCodigoitem7(rs.getInt("codigoitem7"));
				rfq.setCodigoitem8(rs.getInt("codigoitem8"));
				rfq.setCodigoitem9(rs.getInt("codigoitem9"));
				rfq.setCodigoitem10(rs.getInt("codigoitem10"));
				rfq.setCodigoitem11(rs.getInt("codigoitem11"));
				rfq.setCodigoitem12(rs.getInt("codigoitem12"));
				rfq.setCodigoitem13(rs.getInt("codigoitem13"));
				rfq.setCodigoitem14(rs.getInt("codigoitem14"));
				rfq.setCodigoitem15(rs.getInt("codigoitem15"));
				rfq.setCodigoitem16(rs.getInt("codigoitem16"));
				rfq.setCodigoitem17(rs.getInt("codigoitem17"));
				rfq.setCodigoitem18(rs.getInt("codigoitem18"));
				rfq.setCodigoitem19(rs.getInt("codigoitem19"));
				rfq.setCodigoitem20(rs.getInt("codigoitem20"));	
				
				rfq.setDescricao1(rs.getString("descricao1"));
				rfq.setDescricao2(rs.getString("descricao2"));
				rfq.setDescricao3(rs.getString("descricao3"));
				rfq.setDescricao4(rs.getString("descricao4"));
				rfq.setDescricao5(rs.getString("descricao5"));
				rfq.setDescricao6(rs.getString("descricao6"));
				rfq.setDescricao7(rs.getString("descricao7"));
				rfq.setDescricao8(rs.getString("descricao8"));
				rfq.setDescricao9(rs.getString("descricao9"));
				rfq.setDescricao10(rs.getString("descricao10"));
				rfq.setDescricao11(rs.getString("descricao11"));
				rfq.setDescricao12(rs.getString("descricao12"));
				rfq.setDescricao13(rs.getString("descricao13"));
				rfq.setDescricao14(rs.getString("descricao14"));
				rfq.setDescricao15(rs.getString("descricao15"));
				rfq.setDescricao16(rs.getString("descricao16"));
				rfq.setDescricao17(rs.getString("descricao17"));
				rfq.setDescricao18(rs.getString("descricao18"));
				rfq.setDescricao19(rs.getString("descricao19"));
				rfq.setDescricao20(rs.getString("descricao20"));
				
				rfq.setQtd1(rs.getInt("qtd1"));
				rfq.setQtd2(rs.getInt("qtd2"));
				rfq.setQtd3(rs.getInt("qtd3"));
				rfq.setQtd4(rs.getInt("qtd4"));
				rfq.setQtd5(rs.getInt("qtd5"));
				rfq.setQtd6(rs.getInt("qtd6"));
				rfq.setQtd7(rs.getInt("qtd7"));
				rfq.setQtd8(rs.getInt("qtd8"));
				rfq.setQtd9(rs.getInt("qtd9"));
				rfq.setQtd10(rs.getInt("qtd10"));
				rfq.setQtd11(rs.getInt("qtd11"));
				rfq.setQtd12(rs.getInt("qtd12"));
				rfq.setQtd13(rs.getInt("qtd13"));
				rfq.setQtd14(rs.getInt("qtd14"));
				rfq.setQtd15(rs.getInt("qtd15"));
				rfq.setQtd16(rs.getInt("qtd16"));
				rfq.setQtd17(rs.getInt("qtd17"));
				rfq.setQtd18(rs.getInt("qtd18"));
				rfq.setQtd19(rs.getInt("qtd19"));
				rfq.setQtd20(rs.getInt("qtd20"));
				
				rfq.setPuitem1(rs.getDouble("puitem1"));
				rfq.setPuitem2(rs.getDouble("puitem2"));
				rfq.setPuitem3(rs.getDouble("puitem3"));
				rfq.setPuitem4(rs.getDouble("puitem4"));
				rfq.setPuitem5(rs.getDouble("puitem5"));
				rfq.setPuitem6(rs.getDouble("puitem6"));
				rfq.setPuitem7(rs.getDouble("puitem7"));
				rfq.setPuitem8(rs.getDouble("puitem8"));
				rfq.setPuitem9(rs.getDouble("puitem9"));
				rfq.setPuitem10(rs.getDouble("puitem10"));
				rfq.setPuitem11(rs.getDouble("puitem11"));
				rfq.setPuitem12(rs.getDouble("puitem12"));
				rfq.setPuitem13(rs.getDouble("puitem13"));
				rfq.setPuitem14(rs.getDouble("puitem14"));
				rfq.setPuitem15(rs.getDouble("puitem15"));
				rfq.setPuitem16(rs.getDouble("puitem16"));
				rfq.setPuitem17(rs.getDouble("puitem17"));
				rfq.setPuitem18(rs.getDouble("puitem18"));
				rfq.setPuitem19(rs.getDouble("puitem19"));
				rfq.setPuitem20(rs.getDouble("puitem20"));				
				
				rfq.setTotal(rs.getDouble("total"));
				rfq.setFrete(rs.getDouble("frete"));
				rfq.setCodigo(rs.getLong("codigo"));
												
				resultado.add(rfq);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(Rfq rfq) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE rfq SET " +
									"data = ?,				" +
									"numerorfq = ?, 		" +
									"prazoentrega = ?, 		" +
									"contatocomercial = ?, 	" +
									"contatotecnico = ?, 	" +
									"datalimite = ?, 		" +
									"termopagamento = ?, 	" +
									"tempogarantia = ?,		" +
									"outracondicao = ?, 	" +
									"empresa = ?, 			" +
									"endereco = ?, 			" +
									"cidade = ?, 			" +
									"estado = ?, 			" +
									"telefone = ?, 			" +
									"codigoitem1 = ?,	 " +
									"codigoitem2 = ?, 	 " +
									"codigoitem3 = ?, 	 " +
									"codigoitem4 = ?,	 " +
									"codigoitem5 = ?, 	 " +
									"codigoitem6 = ?,	 " +
									"codigoitem7 = ?, 	 " +
									"codigoitem8 = ?,	 " +
									"codigoitem9 = ?,	 " +
									"codigoitem10 = ?,	 " +
									"codigoitem11 = ?,	 " +
									"codigoitem12 = ?,	 " +
									"codigoitem13 = ?,	 " +
									"codigoitem14 = ?,	 " +
									"codigoitem15 = ?,	 " +
									"codigoitem16 = ?,	 " +
									"codigoitem17 = ?,	 " +
									"codigoitem18 = ?,	 " +
									"codigoitem19 = ?,	 " +
									"codigoitem20 = ?,	 " +
									"descricao1 = ?,	 " +
									"descricao2 = ?,	 " +
									"descricao3 = ?,	 " +
									"descricao4 = ?,	 " +
									"descricao5 = ?,	 " +
									"descricao6 = ?,	 " +
									"descricao7 = ?,	 " +
									"descricao8 = ?,	 " +
									"descricao9 = ?,	 " +
									"descricao10 = ?,	 " +
									"descricao11 = ?,	 " +
									"descricao12 = ?,	 " +
									"descricao13 = ?,	 " +
									"descricao14 = ?,	 " +
									"descricao15 = ?,	 " +
									"descricao16 = ?,	 " +
									"descricao17 = ?,	 " +
									"descricao18 = ?,	 " +
									"descricao19 = ?,	 " +
									"descricao20 = ?,    " +
									"qtd1 = ?,   " +
									"qtd2 = ?,	 " +
									"qtd3 = ?,	 " +
									"qtd4 = ?,	 " +
									"qtd5 = ?,	 " +
									"qtd6 = ?,	 " +
									"qtd7 = ?,	 " +
									"qtd8 = ?,	 " +
									"qtd9 = ?,	 " +
									"qtd10 = ?,	 " +
									"qtd11 = ?,	 " +
									"qtd12 = ?,	 " +
									"qtd13 = ?,	 " +
									"qtd14 = ?,	 " +
									"qtd15 = ?,	 " +
									"qtd16 = ?,	 " +
									"qtd17 = ?,	 " +
									"qtd18 = ?,	 " +
									"qtd19 = ?,  " +
									"qtd20 = ?,	 " +
									"puitem1 = ?,	 " +
									"puitem2 = ?,	 " +
									"puitem3 = ?,	 " +
									"puitem4 = ?,	 " +
									"puitem5 = ?,	 " +
									"puitem6 = ?,	 " +
									"puitem7 = ?,	 " +
									"puitem8 = ?,	 " +
									"puitem9 = ?,	 " +
									"puitem10 = ?,	 " +
									"puitem11 = ?,	 " +
									"puitem12 = ?,   " +
									"puitem13 = ?,	 " +
									"puitem14 = ?,	 " +
									"puitem15 = ?,	 " +
									"puitem16 = ?,	 " +
									"puitem17 = ?,	 " +
									"puitem18 = ?,	 " +
									"puitem19 = ?,	 " +
									"puitem20 = ?, " +
									"total = ?," +
									"frete = ? WHERE codigo = ?;";
			
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(rfq, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
			ps.executeUpdate();//Linha muito importante, sem ela não é executado a atualização do cliente
			ps.close();	
			
		}finally{
			 // fecha todos os recursos e devolve a conexao ao pool	        
	        if (ps != null && !ps.isClosed() ) {
	            try { ps.close(); } catch (SQLException e) { ; }
	            ps = null;
	        }
	        if (con != null && !con.isClosed() ) {
	            try { con.close(); } catch (SQLException e) { ; }
	            con = null;
	        }
		}
		
	}

	@Override
	public void salvar(Rfq rfq) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		
	try {
	String sqlInsert = "INSERT INTO rfq (" +
	"data, numerorfq, prazoentrega, contatocomercial, contatotecnico, datalimite, termopagamento, tempogarantia," +
	"outracondicao, empresa, endereco, cidade, estado, telefone, " +
	"codigoitem1,	codigoitem2, 	 codigoitem3, 	 codigoitem4,	 codigoitem5, 	 codigoitem6,	 codigoitem7, 	 codigoitem8,	 codigoitem9,	 " +
	"codigoitem10,	codigoitem11,	 codigoitem12,	 codigoitem13,	 codigoitem14,	 codigoitem15,	 codigoitem16,	 codigoitem17,	 codigoitem18,	 " +
	"codigoitem19,	codigoitem20,	 " +
	"descricao1,	descricao2,	     descricao3,	 descricao4,	 descricao5,	 descricao6,	 descricao7,	 descricao8,	 descricao9,	 " +
	"descricao10,	descricao11,	 descricao12,	 descricao13,	 descricao14,	 descricao15,	 descricao16,	 descricao17,	 descricao18,	 " +
	"descricao19,	descricao20, " +
	"qtd1, qtd2,	 qtd3,	 qtd4,	 qtd5,	 qtd6,	 qtd7,	 qtd8,	 qtd9,	 qtd10,	 qtd11,	 qtd12,	 qtd13,	 qtd14,	 qtd15,	 qtd16,	 qtd17,	 qtd18,	 qtd19," +
	"qtd20,	 puitem1,	 puitem2,	 puitem3,	 puitem4,	 puitem5,	 puitem6,	 puitem7,	 puitem8,	 puitem9,	 puitem10,	 puitem11,	 puitem12," +
	"puitem13,	 puitem14,	 puitem15,	 puitem16,	 puitem17,	 puitem18,	 puitem19,	 puitem20, total, frete " +
	") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
						
			ps.setDate(1, new java.sql.Date(rfq.getData().getTime() )); //transforma o java util date em java sql date				
			ps.setInt(2, rfq.getNumerorfq());
			ps.setString(3, rfq.getPrazoentrega());
			ps.setString(4, rfq.getContatocomercial());
			ps.setString(5, rfq.getContatotecnico());
			ps.setDate(6, new java.sql.Date(rfq.getDatalimite().getTime() )); //transforma o java util date em java sql date
			ps.setString(7, rfq.getTermopagamento());
			ps.setString(8, rfq.getTempogarantia());
			ps.setString(9, rfq.getOutracondicao());
			ps.setObject(10, rfq.getEmpresa());
			ps.setString(11, rfq.getEndereco());
			ps.setString(12, rfq.getCidade());		
			ps.setString(13, rfq.getEstado());
			ps.setString(14, rfq.getTelefone());
			
			ps.setInt(15, rfq.getCodigoitem1());	
			ps.setInt(16, rfq.getCodigoitem2());
			ps.setInt(17, rfq.getCodigoitem3());
			ps.setInt(18, rfq.getCodigoitem4());
			ps.setInt(19, rfq.getCodigoitem5());
			ps.setInt(20, rfq.getCodigoitem6());
			ps.setInt(21, rfq.getCodigoitem7());
			ps.setInt(22, rfq.getCodigoitem8());
			ps.setInt(23, rfq.getCodigoitem9());
			ps.setInt(24, rfq.getCodigoitem10());
			ps.setInt(25, rfq.getCodigoitem11());
			ps.setInt(26, rfq.getCodigoitem12());
			ps.setInt(27, rfq.getCodigoitem13());
			ps.setInt(28, rfq.getCodigoitem14());
			ps.setInt(29, rfq.getCodigoitem15());
			ps.setInt(30, rfq.getCodigoitem16());
			ps.setInt(31, rfq.getCodigoitem17());
			ps.setInt(32, rfq.getCodigoitem18());
			ps.setInt(33, rfq.getCodigoitem19());
			ps.setInt(34, rfq.getCodigoitem20());	
			
			ps.setString(35, rfq.getDescricao1());
			ps.setString(36, rfq.getDescricao2());
			ps.setString(37, rfq.getDescricao3());
			ps.setString(38, rfq.getDescricao4());
			ps.setString(39, rfq.getDescricao5());
			ps.setString(40, rfq.getDescricao6());
			ps.setString(41, rfq.getDescricao7());
			ps.setString(42, rfq.getDescricao8());
			ps.setString(43, rfq.getDescricao9());
			ps.setString(44, rfq.getDescricao10());
			ps.setString(45, rfq.getDescricao11());
			ps.setString(46, rfq.getDescricao12());
			ps.setString(47, rfq.getDescricao13());
			ps.setString(48, rfq.getDescricao14());
			ps.setString(49, rfq.getDescricao15());
			ps.setString(50, rfq.getDescricao16());
			ps.setString(51, rfq.getDescricao17());
			ps.setString(52, rfq.getDescricao18());
			ps.setString(53, rfq.getDescricao19());
			ps.setString(54, rfq.getDescricao20());
			
			ps.setInt(55, rfq.getQtd1());
			ps.setInt(56, rfq.getQtd2());
			ps.setInt(57, rfq.getQtd3());
			ps.setInt(58, rfq.getQtd4());
			ps.setInt(59, rfq.getQtd5());
			ps.setInt(60, rfq.getQtd6());
			ps.setInt(61, rfq.getQtd7());
			ps.setInt(62, rfq.getQtd8());
			ps.setInt(63, rfq.getQtd9());
			ps.setInt(64, rfq.getQtd10());
			ps.setInt(65, rfq.getQtd11());
			ps.setInt(66, rfq.getQtd12());
			ps.setInt(67, rfq.getQtd13());
			ps.setInt(68, rfq.getQtd14());
			ps.setInt(69, rfq.getQtd15());
			ps.setInt(70, rfq.getQtd16());
			ps.setInt(71, rfq.getQtd17());
			ps.setInt(72, rfq.getQtd18());
			ps.setInt(73, rfq.getQtd19());
			ps.setInt(74, rfq.getQtd20());
			
			ps.setDouble(75, rfq.getPuitem1());
			ps.setDouble(76, rfq.getPuitem2());
			ps.setDouble(77, rfq.getPuitem3());
			ps.setDouble(78, rfq.getPuitem4());
			ps.setDouble(79, rfq.getPuitem5());
			ps.setDouble(80, rfq.getPuitem6());
			ps.setDouble(81, rfq.getPuitem7());
			ps.setDouble(82, rfq.getPuitem8());
			ps.setDouble(83, rfq.getPuitem9());
			ps.setDouble(84, rfq.getPuitem10());
			ps.setDouble(85, rfq.getPuitem11());
			ps.setDouble(86, rfq.getPuitem12());
			ps.setDouble(87, rfq.getPuitem13());
			ps.setDouble(88, rfq.getPuitem14());
			ps.setDouble(89, rfq.getPuitem15());
			ps.setDouble(90, rfq.getPuitem16());
			ps.setDouble(91, rfq.getPuitem17());
			ps.setDouble(92, rfq.getPuitem18());
			ps.setDouble(93, rfq.getPuitem19());
			ps.setDouble(94, rfq.getPuitem20());			
			
			ps.setDouble(95, rfq.getTotal()); 
			ps.setDouble(96, rfq.getFrete());
			
			ps.executeUpdate();
			ps.close();

			// Pode acontecer o q/ for, que a conexao sera executada.
		} finally {
			
			 // fecha todos os recursos e devolve a conexao ao pool	        
	        if (ps != null && !ps.isClosed() ) {
	            try { ps.close(); } catch (SQLException e) { ; }
	            ps = null;
	        }
	        if (con != null && !con.isClosed() ) {
	            try { con.close(); } catch (SQLException e) { ; }
	            con = null;
	        }
		}		
	}

	@Override
	public List<Rfq> getRfqs() throws Exception {
		
		   List<Rfq> resultado = new ArrayList<Rfq>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM rfq";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					Rfq rfq = new Rfq();
									
					rfq.setData(rs.getDate("data"));
					rfq.setNumerorfq(rs.getInt("numerorfq"));
					rfq.setPrazoentrega(rs.getString("prazoentrega"));
					rfq.setContatocomercial(rs.getString("contatocomercial"));
					rfq.setContatotecnico(rs.getString("contatotecnico"));
					rfq.setDatalimite(rs.getDate("datalimite"));
					rfq.setTermopagamento(rs.getString("termopagamento"));
					rfq.setTempogarantia(rs.getString("tempogarantia"));
					rfq.setOutracondicao(rs.getString("outracondicao"));
					rfq.setEmpresa(rs.getString("empresa"));				
					rfq.setEndereco(rs.getString("endereco"));					
					rfq.setCidade(rs.getString("cidade"));
					rfq.setEstado(rs.getString("estado"));
					rfq.setTelefone(rs.getString("telefone"));
					
					rfq.setCodigoitem1(rs.getInt("codigoitem1"));
					rfq.setCodigoitem2(rs.getInt("codigoitem2"));
					rfq.setCodigoitem3(rs.getInt("codigoitem3"));
					rfq.setCodigoitem4(rs.getInt("codigoitem4"));
					rfq.setCodigoitem5(rs.getInt("codigoitem5"));
					rfq.setCodigoitem6(rs.getInt("codigoitem6"));
					rfq.setCodigoitem7(rs.getInt("codigoitem7"));
					rfq.setCodigoitem8(rs.getInt("codigoitem8"));
					rfq.setCodigoitem9(rs.getInt("codigoitem9"));
					rfq.setCodigoitem10(rs.getInt("codigoitem10"));
					rfq.setCodigoitem11(rs.getInt("codigoitem11"));
					rfq.setCodigoitem12(rs.getInt("codigoitem12"));
					rfq.setCodigoitem13(rs.getInt("codigoitem13"));
					rfq.setCodigoitem14(rs.getInt("codigoitem14"));
					rfq.setCodigoitem15(rs.getInt("codigoitem15"));
					rfq.setCodigoitem16(rs.getInt("codigoitem16"));
					rfq.setCodigoitem17(rs.getInt("codigoitem17"));
					rfq.setCodigoitem18(rs.getInt("codigoitem18"));
					rfq.setCodigoitem19(rs.getInt("codigoitem19"));
					rfq.setCodigoitem20(rs.getInt("codigoitem20"));	
					
					rfq.setDescricao1(rs.getString("descricao1"));
					rfq.setDescricao2(rs.getString("descricao2"));
					rfq.setDescricao3(rs.getString("descricao3"));
					rfq.setDescricao4(rs.getString("descricao4"));
					rfq.setDescricao5(rs.getString("descricao5"));
					rfq.setDescricao6(rs.getString("descricao6"));
					rfq.setDescricao7(rs.getString("descricao7"));
					rfq.setDescricao8(rs.getString("descricao8"));
					rfq.setDescricao9(rs.getString("descricao9"));
					rfq.setDescricao10(rs.getString("descricao10"));
					rfq.setDescricao11(rs.getString("descricao11"));
					rfq.setDescricao12(rs.getString("descricao12"));
					rfq.setDescricao13(rs.getString("descricao13"));
					rfq.setDescricao14(rs.getString("descricao14"));
					rfq.setDescricao15(rs.getString("descricao15"));
					rfq.setDescricao16(rs.getString("descricao16"));
					rfq.setDescricao17(rs.getString("descricao17"));
					rfq.setDescricao18(rs.getString("descricao18"));
					rfq.setDescricao19(rs.getString("descricao19"));
					rfq.setDescricao20(rs.getString("descricao20"));
					
					rfq.setQtd1(rs.getInt("qtd1"));
					rfq.setQtd2(rs.getInt("qtd2"));
					rfq.setQtd3(rs.getInt("qtd3"));
					rfq.setQtd4(rs.getInt("qtd4"));
					rfq.setQtd5(rs.getInt("qtd5"));
					rfq.setQtd6(rs.getInt("qtd6"));
					rfq.setQtd7(rs.getInt("qtd7"));
					rfq.setQtd8(rs.getInt("qtd8"));
					rfq.setQtd9(rs.getInt("qtd9"));
					rfq.setQtd10(rs.getInt("qtd10"));
					rfq.setQtd11(rs.getInt("qtd11"));
					rfq.setQtd12(rs.getInt("qtd12"));
					rfq.setQtd13(rs.getInt("qtd13"));
					rfq.setQtd14(rs.getInt("qtd14"));
					rfq.setQtd15(rs.getInt("qtd15"));
					rfq.setQtd16(rs.getInt("qtd16"));
					rfq.setQtd17(rs.getInt("qtd17"));
					rfq.setQtd18(rs.getInt("qtd18"));
					rfq.setQtd19(rs.getInt("qtd19"));
					rfq.setQtd20(rs.getInt("qtd20"));
					
					rfq.setPuitem1(rs.getDouble("puitem1"));
					rfq.setPuitem2(rs.getDouble("puitem2"));
					rfq.setPuitem3(rs.getDouble("puitem3"));
					rfq.setPuitem4(rs.getDouble("puitem4"));
					rfq.setPuitem5(rs.getDouble("puitem5"));
					rfq.setPuitem6(rs.getDouble("puitem6"));
					rfq.setPuitem7(rs.getDouble("puitem7"));
					rfq.setPuitem8(rs.getDouble("puitem8"));
					rfq.setPuitem9(rs.getDouble("puitem9"));
					rfq.setPuitem10(rs.getDouble("puitem10"));
					rfq.setPuitem11(rs.getDouble("puitem11"));
					rfq.setPuitem12(rs.getDouble("puitem12"));
					rfq.setPuitem13(rs.getDouble("puitem13"));
					rfq.setPuitem14(rs.getDouble("puitem14"));
					rfq.setPuitem15(rs.getDouble("puitem15"));
					rfq.setPuitem16(rs.getDouble("puitem16"));
					rfq.setPuitem17(rs.getDouble("puitem17"));
					rfq.setPuitem18(rs.getDouble("puitem18"));
					rfq.setPuitem19(rs.getDouble("puitem19"));
					rfq.setPuitem20(rs.getDouble("puitem20"));
					
					rfq.setTotal(rs.getDouble("total"));	
					rfq.setFrete(rs.getDouble("frete"));
					rfq.setCodigo(rs.getLong("codigo"));
									
					resultado.add(rfq);// Add o projeto ao resultado.
				}			
				rs.close();
				ps.close();
		} finally{
			 // fecha todos os recursos e devolve a conexao ao pool	        
			if (rs != null && !rs.isClosed() ) {
	            try { rs.close(); } catch (SQLException e) { ; }
	            rs = null;
	        }
			if (ps != null && !ps.isClosed() ) {
	            try { ps.close(); } catch (SQLException e) { ; }
	            ps = null;
	        }
	        if (con != null && !con.isClosed() ) {
	            try { con.close(); } catch (SQLException e) { ; }
	            con = null;
	        }
		}			
		return resultado;
	}
	
}
