package net.h0lg.autodns.xml.request.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.h0lg.autodns.xml.adapter.RequestCodeAdapter;
import net.h0lg.autodns.xml.request.model.contact.Handle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Task {

	private Handle handle;
	@XmlJavaTypeAdapter(RequestCodeAdapter.class)
	private RequestCode code;
	private View view;
	@XmlElement(name = "key")
	private List<String> keys;

}
