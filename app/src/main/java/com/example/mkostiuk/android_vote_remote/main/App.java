package com.example.mkostiuk.android_vote_remote.main;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mkostiuk.android_vote_remote.R;
import com.example.mkostiuk.android_vote_remote.upnp.Service;
import com.example.mkostiuk.android_vote_remote.upnp.VoteRemoteController;

import org.fourthline.cling.android.AndroidUpnpServiceImpl;
import org.fourthline.cling.model.meta.LocalService;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import xdroid.toaster.Toaster;

import static org.fourthline.cling.binding.xml.Descriptor.Device.ELEMENT.service;

public class App extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_STORAGE = 1;

    private Button one, two, three, four, five, six, seven, eight, nine, zero, inscription, retour, affiheQuestion;
    private Service service;
    private ServiceConnection serviceConnection;
    private GenerateurXml gen;
    private TextView textQuestion;
    private String question;

    public void activate(Button ... buttons) {
        for (Button b : buttons)
            b.setClickable(true);
    }

    public void deactivate(Button ... buttons) {
        for (Button b : buttons)
            b.setClickable(false);
    }


    public void init() {

        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        inscription = (Button) findViewById(R.id.inscription);
        retour = (Button) findViewById(R.id.retour);
        affiheQuestion = (Button) findViewById(R.id.afficheQuestion);

        question = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        File dir;
        System.err.println(Build.BRAND);
        if (Build.BRAND.toString().equals("htc_europe"))
            dir = new File("/mnt/emmc/VoteRemote/");
        else
            dir = new File(Environment.getExternalStorageDirectory().getPath() + "/VoteRemote/");

        while (!dir.exists()) {
            dir.mkdir();
            dir.setReadable(true);
            dir.setExecutable(true);
            dir.setWritable(true);
        }



        service = new Service();
        serviceConnection = service.getService();

        gen = new GenerateurXml();
        
        getApplicationContext().bindService(new Intent(this, AndroidUpnpServiceImpl.class),
                serviceConnection,
                Context.BIND_AUTO_CREATE);

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                setListeners();
            }
        }, 5000);

    }

    public void setListeners() {
        service.getQuestionService().getManager().getImplementation().getPropertyChangeSupport()
                .addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if (evt.getPropertyName() == "question") {
                            if (!(((String) evt.getNewValue()).equals(""))) {
                                Toaster.toast("Nouvelle question");
                                question = (String)evt.getNewValue();
                            }
                        }
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        //Vérification que l'autorisation d'accès au système de stockage est accrodée
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                //Cela signifie que la permission à déjà était
                //demandé et l'utilisateur l'a refusé
                //Vous pouvez aussi expliquer à l'utilisateur pourquoi
                //cette permission est nécessaire et la redemander
                Toaster.toast("Vous avez refusé l'accés au Stockage, fermeture");
                finish();
            } else {
                //Sinon demander la permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_STORAGE);
            }
        }
        else {
            //Permission déjà accrodée
            init();
        }



    }

    public void onClickOne(View view) throws TransformerException, ParserConfigurationException {
        service.getVoteRemoteLocalService().getManager().getImplementation().envoieCommande(
                gen.getDocXml(service.getUdn().toString(),"1")
        );
        sendVide();
    }

    public void onClickTwo(View view) throws TransformerException, ParserConfigurationException {
        service.getVoteRemoteLocalService().getManager().getImplementation().envoieCommande(
                gen.getDocXml(service.getUdn().toString(),"2")
        );
        sendVide();
    }

    public void onClickThree(View view) throws TransformerException, ParserConfigurationException {
        service.getVoteRemoteLocalService().getManager().getImplementation().envoieCommande(
                gen.getDocXml(service.getUdn().toString(),"3")
        );
        sendVide();
    }

    public void onClickFour(View view) throws TransformerException, ParserConfigurationException {
        service.getVoteRemoteLocalService().getManager().getImplementation().envoieCommande(
                gen.getDocXml(service.getUdn().toString(),"4")
        );
        sendVide();
    }

    public void onClickFive(View view) throws TransformerException, ParserConfigurationException {
        service.getVoteRemoteLocalService().getManager().getImplementation().envoieCommande(
                gen.getDocXml(service.getUdn().toString(),"5")
        );
        sendVide();
    }

    public void onClickSix(View view) throws TransformerException, ParserConfigurationException {
        service.getVoteRemoteLocalService().getManager().getImplementation().envoieCommande(
                gen.getDocXml(service.getUdn().toString(),"6")
        );
        sendVide();
    }

    public void onClickSeven(View view) throws TransformerException, ParserConfigurationException {
        service.getVoteRemoteLocalService().getManager().getImplementation().envoieCommande(
                gen.getDocXml(service.getUdn().toString(),"7")
        );
        sendVide();
    }

    public void onClickEight(View view) throws TransformerException, ParserConfigurationException {
        service.getVoteRemoteLocalService().getManager().getImplementation().envoieCommande(
                gen.getDocXml(service.getUdn().toString(),"8")
        );
        sendVide();
    }

    public void onClickNine(View view) throws TransformerException, ParserConfigurationException {
        service.getVoteRemoteLocalService().getManager().getImplementation().envoieCommande(
                gen.getDocXml(service.getUdn().toString(),"9")
        );
        sendVide();
    }

    public void onClickZero(View view) throws TransformerException, ParserConfigurationException {
        service.getVoteRemoteLocalService().getManager().getImplementation().envoieCommande(
                gen.getDocXml(service.getUdn().toString(),"0")
        );
        sendVide();
    }

    public void onClickInscription(View view) throws TransformerException, ParserConfigurationException {
        service.getVoteRemoteLocalService().getManager().getImplementation()
                .envoieCommande(gen.getDocXml(service.getUdn().toString(), "")
        );

    }

    public void onClickAfficherQuestion(View view) {
        setContentView(R.layout.affiche_question);
        textQuestion = (TextView) findViewById(R.id.textQuestion);
        textQuestion.setText(question);

    }

    public void onClickRetour(View view) {
        setContentView(R.layout.activity_app);
    }

    public void sendVide() {
        service.getVoteRemoteLocalService().getManager().getImplementation()
                .envoieCommande("");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[],
                                           int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_STORAGE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // La permission est garantie on initialise les services et boutons
                    init();
                } else {
                    Toaster.toast("Permission refusée, fermeture");
                    finish();
                }
                return;
            }
        }
    }
}
