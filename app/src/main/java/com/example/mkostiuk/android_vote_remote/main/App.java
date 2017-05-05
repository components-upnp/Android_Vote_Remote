package com.example.mkostiuk.android_vote_remote.main;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

    private Button one, two, three, four, five, six, seven, eight, nine, zero, inscription, retour, affiheQuestion;
    private Service service;
    private ServiceConnection serviceConnection;
    private LocalService<VoteRemoteController> voteRemoteService;
    private GenerateurXml gen;
    private EditText textQuestion;
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


        activate(inscription, affiheQuestion);
        deactivate(one, two, three, four, five, six, seven, eight, nine, zero);

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
        voteRemoteService = service.getVoteRemoteLocalService();

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
        service.getVoteRemoteLocalService().getManager().getImplementation().getPropertyChangeSupport()
                .addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if (evt.getPropertyName() == "question") {
                            activate(one, two, three, four, five, six, seven, eight, nine, zero);
                            Toaster.toast("Nouvelle question");
                            question = (String)evt.getNewValue();
                        }
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        init();
    }

    public void onClickOne(View view) throws TransformerException, ParserConfigurationException {
        service.getVoteRemoteLocalService().getManager().getImplementation().envoieCommande(
                gen.getDocXml(service.getUdn().toString(),"1")
        );
        deactivate(one, two, three, four, five, six, seven, eight, nine, zero);
    }

    public void onClickTwo(View view) throws TransformerException, ParserConfigurationException {
        service.getVoteRemoteLocalService().getManager().getImplementation().envoieCommande(
                gen.getDocXml(service.getUdn().toString(),"2")
        );
        deactivate(one, two, three, four, five, six, seven, eight, nine, zero);
    }

    public void onClickThree(View view) throws TransformerException, ParserConfigurationException {
        service.getVoteRemoteLocalService().getManager().getImplementation().envoieCommande(
                gen.getDocXml(service.getUdn().toString(),"3")
        );
        deactivate(one, two, three, four, five, six, seven, eight, nine, zero);
    }

    public void onClickFour(View view) throws TransformerException, ParserConfigurationException {
        service.getVoteRemoteLocalService().getManager().getImplementation().envoieCommande(
                gen.getDocXml(service.getUdn().toString(),"4")
        );
        deactivate(one, two, three, four, five, six, seven, eight, nine, zero);
    }

    public void onClickFive(View view) throws TransformerException, ParserConfigurationException {
        service.getVoteRemoteLocalService().getManager().getImplementation().envoieCommande(
                gen.getDocXml(service.getUdn().toString(),"5")
        );
        deactivate(one, two, three, four, five, six, seven, eight, nine, zero);
    }

    public void onClickSix(View view) throws TransformerException, ParserConfigurationException {
        service.getVoteRemoteLocalService().getManager().getImplementation().envoieCommande(
                gen.getDocXml(service.getUdn().toString(),"6")
        );
        deactivate(one, two, three, four, five, six, seven, eight, nine, zero);
    }

    public void onClickSeven(View view) throws TransformerException, ParserConfigurationException {
        service.getVoteRemoteLocalService().getManager().getImplementation().envoieCommande(
                gen.getDocXml(service.getUdn().toString(),"7")
        );
        deactivate(one, two, three, four, five, six, seven, eight, nine, zero);
    }

    public void onClickEight(View view) throws TransformerException, ParserConfigurationException {
        service.getVoteRemoteLocalService().getManager().getImplementation().envoieCommande(
                gen.getDocXml(service.getUdn().toString(),"8")
        );
        deactivate(one, two, three, four, five, six, seven, eight, nine, zero);
    }

    public void onClickNine(View view) throws TransformerException, ParserConfigurationException {
        service.getVoteRemoteLocalService().getManager().getImplementation().envoieCommande(
                gen.getDocXml(service.getUdn().toString(),"9")
        );
        deactivate(one, two, three, four, five, six, seven, eight, nine, zero);
    }

    public void onClickZero(View view) throws TransformerException, ParserConfigurationException {
        service.getVoteRemoteLocalService().getManager().getImplementation().envoieCommande(
                gen.getDocXml(service.getUdn().toString(),"0")
        );
        deactivate(one, two, three, four, five, six, seven, eight, nine, zero);
    }

    public void onClickInscription(View view) {
        service.getVoteRemoteLocalService().getManager().getImplementation()
                .inscription(service.getUdn().getIdentifierString()
        );
        deactivate(inscription);
    }

    public void onClickAfficherQuestion(View view) {
        setContentView(R.layout.affiche_question);
        textQuestion = (EditText) findViewById(R.id.textQuestion);
        textQuestion.setText(question);
    }

    public void onClickRetour(View view) {
        setContentView(R.layout.activity_app);
    }
}
