package net.h0lg.autodns.xml.builder;

import net.h0lg.autodns.xml.request.model.Auth;
import net.h0lg.autodns.xml.request.model.Request;
import net.h0lg.autodns.xml.request.model.RequestCode;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

public class HandleListRequestBuilderTest {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "dummy";
    private static final String CONTEXT = "1";


    @Test
    public void should_returnValidRequest_given_authenticationInformation() {
        HandleListRequestBuilder builder = new HandleListRequestBuilder(
                new Auth(USERNAME, PASSWORD, CONTEXT)
        );

        Request actualValue = builder.build();

        assertThat(actualValue, is(notNullValue()));
        assertThat(actualValue.getAuth(), is(notNullValue()));
        assertThat(actualValue.getTask().getCode(), is(RequestCode.CONTACT_LIST));
        assertThat(actualValue.getTask().getView(), is(nullValue()));
    }

}
