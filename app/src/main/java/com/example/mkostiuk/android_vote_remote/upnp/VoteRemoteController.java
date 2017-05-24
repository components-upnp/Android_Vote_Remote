package com.example.mkostiuk.android_vote_remote.upnp;


import org.fourthline.cling.binding.annotations.UpnpService;
import org.fourthline.cling.binding.annotations.UpnpServiceId;
import org.fourthline.cling.binding.annotations.UpnpServiceType;
import org.fourthline.cling.binding.annotations.UpnpStateVariable;

import java.beans.PropertyChangeSupport;

/**
 * Created by mkostiuk on 03/05/2017.
 */

@UpnpService(
        serviceType = @UpnpServiceType(value = "VoteService"),
        serviceId = @UpnpServiceId("VoteService")
)
public class VoteRemoteController {

    private final PropertyChangeSupport propertyChangeSupport;

    public VoteRemoteController() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return  propertyChangeSupport;
    }

    @UpnpStateVariable
    private String commande;

    @UpnpStateVariable
    private String udn = "";

    public void envoieCommande(String c) {
        commande = c;

        getPropertyChangeSupport().firePropertyChange("Commande", null, commande);
    }

}
