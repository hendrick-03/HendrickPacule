package ac.mz.hendrickpacule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText id, titulo, ano, autor, editora;
    private Button gravar, limpar, listar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        id = findViewById(R.id.id_ed);
        titulo = findViewById(R.id.titulo_ed);
        ano = findViewById(R.id.ano_ed);
        autor = findViewById(R.id.autor_ed);
        editora = findViewById(R.id.editora_ed);


        gravar = findViewById(R.id.gravar_btn);
        limpar = findViewById(R.id.limpar_btn);

        listar = findViewById(R.id.listar);



    }
    public void salvar(View view){


        int id_01 = Integer.valueOf(id.getText().toString());
        String titulo_ed = titulo.getText().toString();
        int ano_ed = Integer.valueOf(ano.getText().toString());
        String autor_ed = autor.getText().toString();
        String editora_ed = editora.getText().toString();

        if(ano_ed > 2005) {

            try {
                Livros livros = new Livros(id_01, ano_ed, titulo_ed, editora_ed, autor_ed);
                DataAcessObject.livros.add(livros);
                Toast.makeText(this, "Gravado com Sucesso", Toast.LENGTH_SHORT).show();

            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Preencha os campos correctamente", Toast.LENGTH_SHORT).show();

            } catch (NullPointerException e) {
                Toast.makeText(MainActivity.this, "Preecnha todos os campos", Toast.LENGTH_SHORT).show();

            }

        }else{
            Toast.makeText(this, "Nao salvo", Toast.LENGTH_SHORT).show();
        }
    }

    public void limparcampos(View view){
        id.setText("");
        titulo.setText("");
        ano.setText("");
        autor.setText("");
        editora.setText("");
    }

    public void listartudo(View view){



    }


}