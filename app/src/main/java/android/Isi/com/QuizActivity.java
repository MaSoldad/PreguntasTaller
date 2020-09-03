package android.Isi.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button btnSiguiente;
    private Button atras;
    private TextView pregunta;
    private Button trampa;
    
    private Pregunta[] preguntas = {
            new Pregunta(R.string.question_text1,true),
            new Pregunta(R.string.question_text2,true),
            new Pregunta(R.string.question_text3,true),
            new Pregunta(R.string.question_text4,true),
            new Pregunta(R.string.question_text5,false),
    };

    int actual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton=(Button)findViewById(R.id.true_button);
        mFalseButton=(Button)findViewById(R.id.false_button);

        btnSiguiente=(Button)findViewById(R.id.btnSiguiente);
        atras=(Button)findViewById(R.id.btnAtras);

        pregunta=(TextView) findViewById(R.id.txtpregunta);

        pregunta.setText(preguntas[actual].getTextId());

        trampa=findViewById(R.id.btnTrampa);


        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override  public void onClick(View v) {
                Toast.makeText(QuizActivity.this,"Correcto!!",Toast.LENGTH_SHORT).
                        show();
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override  public void onClick(View v) {
                Toast.makeText(QuizActivity.this,"Incorrecto!!",Toast.LENGTH_SHORT).
                        show();
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actual = (actual + 1) % preguntas.length;
                pregunta.setText(preguntas[actual].getTextId());
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(actual == 0){
                    actual = (actual + 4) % preguntas.length;
                    pregunta.setText(preguntas[actual].getTextId());
                }else{
                    actual = (actual - 1);
                    pregunta.setText(preguntas[actual].getTextId());
                }
            }
        });

        trampa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = preguntas[actual].isRespuesta();

                Intent i = Trampa.newIntent(QuizActivity.this, result);
                startActivity(i);
                /*
                Intent i = new Intent(QuizActivity.this, Trampa.class);
                i.putExtra("respuesta", result);
                startActivity(i);

                 */
            }
        });

        if(savedInstanceState != null){
            pregunta.setText(savedInstanceState.getString("valor"));
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("valor",(String) pregunta.getText());
        super.onSaveInstanceState(outState);
    }
}