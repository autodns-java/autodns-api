package net.h0lg.autodns.xml.builder;

import net.h0lg.autodns.xml.request.model.contact.HandleType;
import org.junit.Test;

public class HandleBuilderTest {

    @Test
    public void should_returnHandle_given_minimalData() {
        HandleBuilder builder = new HandleBuilder();

        builder.createHandle()
                .setType(HandleType.PERSON);
    }


}
