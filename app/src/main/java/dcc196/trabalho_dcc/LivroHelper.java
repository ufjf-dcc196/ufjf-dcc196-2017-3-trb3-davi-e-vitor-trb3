package dcc196.trabalho_dcc;

import java.util.ArrayList;
import java.util.List;

import dcc196.trabalho_dcc.model.Livro;

/**
 * Created by Davi on 22/10/2017.
 */

public class LivroHelper {

    private static LivroHelper lhs = null;
    private List<Livro> livros = new ArrayList<>();

    private LivroHelper () {

    }

    public void criar(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> listarLivros() {
        return livros;
    }

    public static LivroHelper getInstance() {
        if (lhs == null)
            lhs = new LivroHelper();
        return lhs;
    }
}
