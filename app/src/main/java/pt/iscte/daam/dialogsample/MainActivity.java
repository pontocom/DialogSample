package pt.iscte.daam.dialogsample;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDialog1(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Este é um exemplo de um diálogo... responda:").
                setCancelable(true).
                setPositiveButton("Sim", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Selecionou SIM!", Toast.LENGTH_SHORT).show();
                        dialogInterface.cancel();
                    }
                }).
                setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Selecionou NAO!", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void openDialog2(View v) {
        final CharSequence[] options = {"Option 1", "Option 2", "Option 3"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Escolher opção:");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Selecionou -> " + options[which], Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void openProgressDialog1(View v) {
        ProgressDialog progress = ProgressDialog.show(this, "Adding values...", "Please be patient...", true, true, new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                Toast.makeText(getApplicationContext(), "You have canceled the dialog", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void openProgressDialog2(View v) {
        ProgressDialog pdialog = new ProgressDialog(this);
        pdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pdialog.setTitle("Voting pool");
        pdialog.setMessage("Casting your vote...");
        pdialog.setCancelable(true);
        pdialog.show();

        pdialog.setProgress(50);

    }
}
