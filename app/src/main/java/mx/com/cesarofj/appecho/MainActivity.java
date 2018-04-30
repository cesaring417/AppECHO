package mx.com.cesarofj.appecho;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
    }
        public void OnClick (View view)
    {
     ejecutarCliente();
    }

        private void ejecutarCliente()
        {
            mensaje=editText.getText().toString();
            String ip="31.13.89.35";
            int puerto=80;
            log( "socket"+ ip +" "+puerto);
        try
         {
            Socket sk=new Socket(ip,puerto);
            BufferedReader entrada= new BufferedReader(new InputStreamReader(sk.getInputStream()));
             PrintWriter salida=new PrintWriter(new OutputStreamWriter(sk.getOutputStream()),true);
             log("Enviando: "+ mensaje + "\n" );
             sk.close();

            }
        catch (Exception error)
            {
            log("error"+ error.toString() );
            }


        }

    private void log(String s) {

        textView.append(s + "\n");
    }


}

