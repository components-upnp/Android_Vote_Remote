package com.example.mkostiuk.android_vote_remote.upnp;

import org.fourthline.cling.binding.annotations.UpnpAction;
import org.fourthline.cling.binding.annotations.UpnpInputArgument;
import org.fourthline.cling.binding.annotations.UpnpService;
import org.fourthline.cling.binding.annotations.UpnpServiceId;
import org.fourthline.cling.binding.annotations.UpnpServiceType;
import org.fourthline.cling.binding.annotations.UpnpStateVariable;

import java.beans.PropertyChangeSupport;

/**
 * Created by mkostiuk on 16/05/2017.
 */

@UpnpService(
        serviceId = @UpnpServiceId(value = "QuestionService"),
        serviceType = @UpnpServiceType("QuestionService")
)
public class QuestionController {

    private final PropertyChangeSupport propertyChangeSupport;

    public QuestionController() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

    @UpnpStateVariable(sendEvents = false)
    private String question = "";

    @UpnpAction(name = "questionNotif")
    public void questionNotif(@UpnpInputArgument(name = "Question") String question) {
        this.question = question;
        getPropertyChangeSupport().firePropertyChange("question", null, this.question);
    }
}
