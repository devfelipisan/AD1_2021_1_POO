import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AD1_2021_1 {

	public static void main(String[] args) {
		Amigo fulano = new Amigo("Fulano");
		Amigo ciclano = new Amigo("Ciclano");
		Amigo beltrano = new Amigo("Beltrano");

		Rede paraiso = new Rede();
		paraiso.adicionarAmigo(fulano);
		paraiso.adicionarAmigo(ciclano);
		paraiso.adicionarAmigo(beltrano);

		Post bomdia = new Post("Bom dia!");
		Post boatarde = new Post("Boa tarde!");
		Post boanoite = new Post("Boa noite!");

		fulano.postar(bomdia);
		fulano.postar(boatarde);
		ciclano.postar(boanoite);

		beltrano.curtir(bomdia);
		beltrano.curtir(bomdia);
		beltrano.curtir(bomdia);
		beltrano.curtir(bomdia);
		beltrano.curtir(bomdia);
		beltrano.curtir(boatarde);
		beltrano.curtir(boanoite);
		fulano.curtir(boanoite);
		
		System.out.println("Timeline:");
		System.out.println(paraiso.timeline());
		System.out.println("Post mais curtido de um usuário:");
		Post maiscurtido = fulano.retornaPostMaisCurtido();
		System.out.println(maiscurtido);
		System.out.println("Quem curtiu: "+ maiscurtido.retornaNomesQueCurtiram());
	}
}

class Amigo {

	private String nome;
	private ArrayList<Post> posts;

	public Amigo(String string) {
		//Construtor que recebe como argumento uma string com o nome do novo amigo gerado.
		nome = string;
		posts = new ArrayList<>();
	}
 
	public String getNome() {
		//Este método getter foi gerado retornar o nome do amigo
		return nome;
	}

	public Post retornaPostMaisCurtido() {
		//Este metodo cria um loop para verificar o post mais curtido do ArrayList "posts" criado.
		Post saida = null;
		int count = 0;
		for (Post post : posts)
			if (count < post.getCurtidas()){
				saida = post;
				count = post.getCurtidas();
			}

		return saida;
	}

	public void postar(Post post) {
		//método responsável por criar um post e adicionar ao arraylist posts.
		
		posts.add(post);
		
	}

	public void curtir(Post post) {
		//Este metodo e responsavel por acessar o setter curtidas da classe post, com os argumentos a serem alterados.
		post.setCurtidas(1, this.getNome());
	}

	public String toString() {
		//Este metodo toString e responsavel por redefinir o toString da classe Object
		String saida = this.nome + ":\n"; 

		for (Post postagem : posts)			
			saida += postagem.toString()+ "\n";

		return saida;
	}
}

class Rede{

	private ArrayList<Amigo> rede = new ArrayList<>();//Este arraylist armazena objetos amigo do tipo Amigo

	public void adicionarAmigo(Amigo amigo) {
		//Este metodo e responsavel por adicionar o objeto amigo na lista rede.
		rede.add(amigo);
	}

	public String timeline() {
		//Este metodo e responsavel por exibira os objetos armazenados no arraylist rede
		String exibeAmigo = "";

		for (Amigo amigo : rede)
			exibeAmigo += amigo;

		return exibeAmigo;
	}
}

class Post {
	
	private String post;
	private int curtidas = 0;
	private Set<String> curtiram = new HashSet<>();//Este conjunto armazena os nomes do tipo String que curtiram
	
	public Post(String post) {
		//Contrustor responsavel para a criacao do post que recebe como argumento o tipo String e curtidas recebendo um inteiro 0
		this.post = post;
		this.curtidas = 0;
	}

	public void setCurtidas(int curtidas, String curtiu) {
		//Este metodo setter foi criado para acesso e modificacao de curtidas e adicionar ao conjunto o nome do amigo que curtiu o post
		this.curtidas += curtidas;
		this.curtiram.add(curtiu);
	}

	public int getCurtidas(){
		return this.curtidas;
	}

	public String retornaNomesQueCurtiram() {
		//Este metodo foi criado para retornar os nomes dos amigos que curtiram atraves do loop que varre o conjunto curtiram, retornando o tipo String
		String saida = "";
		
		for (String curtiu : curtiram)
			saida += curtiu + " ";
		
		return saida;
	}

	public String toString() {
		//Este metodo toString e responsavel por redefinir o toString da classe Object
		return this.post + ": " + this.curtidas + " curtidas";
	}
}