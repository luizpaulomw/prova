public class locadora {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory().openSession();
        locadora locadora = new locadora();
		locadora.cadastraCategorias();
		locadora.cadastraFilmes();
		locadora.cadastraMidias();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Endereco endereco = new Endereco();
		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO();
		cliente.setCelular("(48) 9990303033");
		cliente.setEmail("siclano@javapro.com.br");
		cliente.setNome("siclano.silva");
		cliente.setTelefone("(48) 3333-4444");
		cliente.setEndereco(endereco);
		endereco.setBairro("Centro");
		endereco.setCep("89000-000");
		endereco.setCidade("florianopolis");
		endereco.setComplemento("Casa");
		endereco.setNumero(new Integer(1));
		endereco.setRua("Av. Principal");
		endereco.setUf("SC");
		endereco.setCliente(cliente);
		clienteDAO.salvar(cliente);
		enderecoDAO.salvar(endereco);

		LocacaoDAO locacaoDAO = new LocacaoDAO();
		Locacao locacao = new Locacao();
		locacao.setDataDevolucao(new Date(System.currentTimeMillis()));
		locacao.setDataEmprestimo(new Date(System.currentTimeMillis()));
		locacao.setObservacao("Devolução final de semana");
		locacao.setHoraEmprestimo(new Time(System.currentTimeMillis()));
		
		locacao.setCliente(cliente);
		
		MidiaDAO midiaDAO = new MidiaDAO();
		Midia midia = (Midia) midiaDAO.buscarCategoria(new Integer(1));
		locacao.setMidia(midia);
		locacaoDAO.salvar(locacao);
		System.out.println("Cadastros gerados com sucesso!");
		
	}
	
	public void cadastraCategorias(){
		
		String categorias[] = {"Aventura", "Ação", "Comédia"};
		Categoria categoria = null;
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		for(int i = 0 ; i < 3 ; i++){
			categoria = new Categoria();
			categoria.setDescricao(categorias[i]);
			categoriaDAO.salvar(categoria);
		}
	}
	
	public void cadastraFilmes(){
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		String filmesDescricao[] = {"Senhor dos Anéis", "Transformers", "Ghostbusters"};
		
		Date filmesAnoProducao[] = {new Date(2001-1900, 11, 19), new Date(2007-1900, 6, 20), new Date(1985-1900, 1, 1)};
		FilmeDAO filmeDAO = new FilmeDAO();
		Filme filme = null;
		for(int i = 0 ; i < 3 ; i++){
			filme = new Filme();
			filme.setDescricao(filmesDescricao[i]);
			filme.setAno(filmesAnoProducao[i]);
			filme.setCategoria(categoriaDAO.buscarCategoria(i+1));
			filmeDAO.salvar(filme);
		}
	}
	
	public void cadastraMidias(){
		Midia midia = null;
		Filme filme = null;
		MidiaDAO midiaDAO = new MidiaDAO();
		FilmeDAO filmeDAO = new FilmeDAO();
		List<Filme> resultado = filmeDAO.listar();
		for(int i = 0 ; i < 3 ; i++){
			midia = new Midia();
			filme = (Filme) resultado.get(i);
			midia.setFilme(filme);
			midia.setInutilizada("N");
			midiaDAO.salvar(midia);
		}
	}

}