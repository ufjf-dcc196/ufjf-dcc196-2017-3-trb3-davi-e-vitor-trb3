package dcc196.trabalho_dcc;

import java.util.ArrayList;
import java.util.List;

import dcc196.trabalho_dcc.model.Livro;

/**
 * Created by Davi on 22/10/2017.
 */

public class LivroHelper {

    private List<Livro> livros = new ArrayList<>();

    public void criar(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> listarLivros() {
        return livros;
    }
}
