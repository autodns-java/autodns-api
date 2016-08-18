package net.h0lg.autodns.resources;

import net.h0lg.autodns.xml.request.model.Request;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public abstract class AbstractResource {

	protected String marshal(Request request) throws JAXBException {
		StringWriter result = new StringWriter();

		JAXBContext context = JAXBContext.newInstance(Request.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		marshaller.marshal(request, result);

		return result.toString();
	}

}
