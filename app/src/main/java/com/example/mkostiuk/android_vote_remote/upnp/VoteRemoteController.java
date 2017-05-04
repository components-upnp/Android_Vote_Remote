package com.example.mkostiuk.android_vote_remote.upnp;

import org.fourthline.cling.binding.annotations.UpnpAction;
import org.fourthline.cling.binding.annotations.UpnpInputArgument;
import org.fourthline.cling.binding.annotations.UpnpService;
import org.fourthline.cling.binding.annotations.UpnpServiceId;
import org.fourthline.cling.binding.annotations.UpnpServiceType;
import org.fourthline.cling.binding.annotations.UpnpStateVariable;

import java.beans.PropertyChangeSupport;

/**
 * Created by mkostiuk on 03/05/2017.
 */

@UpnpService(
        serviceType = @UpnpServiceType(value = "VoteRemoteController"),
        serviceId = @UpnpServiceId("VoteRemoteController")
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

    @UpnpStateVariable(sendEvents = false)
    private String question = "";

    public void envoieCommande(String c) {
        commande = c;

        getPropertyChangeSupport().firePropertyChange("Commande", null, commande);
    }

    public void inscription(String udn) {
        this.udn = udn;
        getPropertyChangeSupport().firePropertyChange("Udn", null, udn);
    }

    @UpnpAction(name = "questionNotif")
    public void questionNotif(@UpnpInputArgument(name = "Question") String question) {
        this.question = question;
        getPropertyChangeSupport().firePropertyChange("question", null, this.question);
    }
}
