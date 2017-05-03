package com.example.mkostiuk.android_vote_remote.upnp;

import org.fourthline.cling.binding.LocalServiceBindingException;
import org.fourthline.cling.binding.annotations.AnnotationLocalServiceBinder;
import org.fourthline.cling.model.DefaultServiceManager;
import org.fourthline.cling.model.ValidationException;
import org.fourthline.cling.model.meta.DeviceDetails;
import org.fourthline.cling.model.meta.DeviceIdentity;
import org.fourthline.cling.model.meta.LocalDevice;
import org.fourthline.cling.model.meta.LocalService;
import org.fourthline.cling.model.meta.ManufacturerDetails;
import org.fourthline.cling.model.meta.ModelDetails;
import org.fourthline.cling.model.types.DeviceType;
import org.fourthline.cling.model.types.UDADeviceType;
import org.fourthline.cling.model.types.UDN;

/**
 * Created by mkostiuk on 03/05/2017.
 */

public class VoteRemoteDevice {
    static LocalDevice createDevice(UDN udn)
            throws ValidationException, LocalServiceBindingException {

        DeviceType type =
                new UDADeviceType("VoteRemoteController", 1);

        DeviceDetails details =
                new DeviceDetails(
                        "Vote Remote",
                        new ManufacturerDetails("IRIT"),
                        new ModelDetails("AndroidController", "Soumet un vote", "v1")
                );

        LocalService service =
                new AnnotationLocalServiceBinder().read(VoteRemoteController.class);

        service.setManager(
                new DefaultServiceManager<>(service, VoteRemoteController.class)
        );

        return new LocalDevice(
                new DeviceIdentity(udn),
                type,
                details,

                service
        );
    }
}
