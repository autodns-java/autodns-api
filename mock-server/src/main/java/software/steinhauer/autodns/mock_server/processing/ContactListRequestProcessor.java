package software.steinhauer.autodns.mock_server.processing;

import lombok.Getter;
import org.springframework.context.ApplicationContext;
import software.steinhauer.autodns.mock_server.helper.HandleTransformer;
import software.steinhauer.autodns.mock_server.persistence.HandleService;
import software.steinhauer.autodns.mock_server.persistence.model.Handle;
import software.steinhauer.autodns.xml.request.model.Task;
import software.steinhauer.autodns.xml.response.model.*;
import software.steinhauer.util.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ContactListRequestProcessor implements RequestProcessor {

	@Getter
	private final Task task;

	private HandleService handleService;

	ContactListRequestProcessor(Task task, ApplicationContext context) {
		this.task = task;
		this.handleService = (HandleService) context.getBean("handleService");
	}

	@Override
	public Response process() {
		Assert.notNull(task, "Can not process null task.");
		return Response.builder()
				.clientTransactionId(task.getClientTransactionId())
				.serverTransactionId(UUID.randomUUID().toString())
				.result(getResult())
				.build();
	}

	private List<Result> getResult() {
		return Collections.singletonList(Result.builder()
				.dataList(getPayload())
				.status(getSuccessStatus())
				.build());
	}

	private Status getSuccessStatus() {
		return Status.builder()
				.code(StatusType.SUCCESS.getCodePrefix() + "0304")
				.text("Domainkontakt-Daten wurden erfolgreich ermittelt.")
				.type(StatusType.SUCCESS)
				.build();
	}

	private List<Data> getPayload() {
		List<Handle> handlesInMock = handleService.getAll();
		List<software.steinhauer.autodns.xml.request.model.contact.Handle> autoDnsHandles = new ArrayList<>();

		handlesInMock.forEach(handle ->
				autoDnsHandles.add(HandleTransformer.toAutoDnsHandle(handle)));

		return Collections.singletonList(Data.builder()
				.count(handlesInMock.size())
				.handles(autoDnsHandles)
				.build());
	}
}
