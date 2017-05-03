package com.example.mkostiuk.android_vote_remote.upnp;

import org.fourthline.cling.binding.annotations.UpnpService;
import org.fourthline.cling.binding.annotations.UpnpServiceId;
import org.fourthline.cling.binding.annotations.UpnpServiceType;

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

    //TODO implémenter les méthodes du service
}
