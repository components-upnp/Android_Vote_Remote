package com.example.mkostiuk.android_vote_remote;

import com.example.mkostiuk.android_vote_remote.main.GenerateurXml;

import junit.framework.TestCase;

import org.fourthline.cling.model.types.UDN;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * Created by mkostiuk on 17/05/2017.
 */

public class TestGenerateurXml extends TestCase {

    private String xml;
    private UDN udn;

    @Before
    public void setUp() throws TransformerException, ParserConfigurationException {
        udn = new UDN(UUID.randomUUID());
        String commande = "TEST";

        GenerateurXml gen;
        gen = new GenerateurXml();
        xml = gen.getDocXml(udn.toString(), commande);

    }

    @Test
    public void testXmlOk() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><TelecommandeEleve xmlns=\"/\"><UDN>"+udn.toString()+"</UDN><Commande>TEST</Commande></TelecommandeEleve>",
                xml);
    }
}
