package com.example.mkostiuk.android_vote_remote.upnp;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

import org.fourthline.cling.android.AndroidUpnpService;
import org.fourthline.cling.model.meta.LocalDevice;
import org.fourthline.cling.model.meta.LocalService;
import org.fourthline.cling.model.types.UDAServiceType;
import org.fourthline.cling.model.types.UDN;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by mkostiuk on 03/05/2017.
 */

public class Service {
    private AndroidUpnpService upnpService;
    private UDN udnVoteRemote;
    private ServiceConnection serviceConnection;


    public Service() {


        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                upnpService = (AndroidUpnpService) service;


                LocalService<VoteRemoteController> remoteControllerService = getVoteRemoteLocalService();
                LocalService<QuestionController> questionService = getQuestionService();

                // Register the device when this activity binds to the service for the first time
                if ((remoteControllerService == null) || (questionService == null)) {
                    try {
                        System.err.println("CREATION DEVICE!!!");
                        udnVoteRemote = new SaveUDN().getUdn();
                        LocalDevice remoteDevice = VoteRemoteDevice.createDevice(udnVoteRemote);

                        upnpService.getRegistry().addDevice(remoteDevice);

                    } catch (Exception ex) {
                        System.err.println("Creating Android remote controller device failed !!!");
                        ex.printStackTrace();
                        return;
                    }
                }

                System.out.println("Creation device reussie...");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                upnpService = null;
            }
        };
    }

    public LocalService<VoteRemoteController> getVoteRemoteLocalService() {
        if (upnpService == null)
            return null;

        LocalDevice remoteDevice;
        if ((remoteDevice = upnpService.getRegistry().getLocalDevice(udnVoteRemote, true)) == null)
            return null;

        return (LocalService<VoteRemoteController>)
                remoteDevice.findService(new UDAServiceType("VoteService", 1));
    }

    public LocalService<QuestionController> getQuestionService () {
        if (upnpService == null)
            return null;

        LocalDevice remoteDevice;

        if ((remoteDevice = upnpService.getRegistry().getLocalDevice(udnVoteRemote, true)) == null)
            return null;

        return (LocalService<QuestionController>)
                remoteDevice.findService(new UDAServiceType("QuestionService", 1));
    }

    public ServiceConnection getService() {
        return serviceConnection;
    }

    public void stop() {
        upnpService.get().shutdown();
    }

    public UDN getUdn() {
        return udnVoteRemote;
    }
}
