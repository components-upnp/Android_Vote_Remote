package com.example.mkostiuk.android_vote_remote;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 *
 * Attention: -Le device Android doit être connecté à la machine en USB
 *            - Le device doit aussi être sur le même réseau local en WIFI
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.mkostiuk.android_vote_remote", appContext.getPackageName());
    }

    //TODO faire les tests des services ici, ajouter subscription et essayer de tester les services
}
