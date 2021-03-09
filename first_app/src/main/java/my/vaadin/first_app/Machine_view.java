package my.vaadin.first_app;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Location;
import com.vaadin.flow.router.QueryParameters;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.datepicker.*;
import org.vaadin.gatanaso.MultiselectComboBox;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.HasText;


import com.vaadin.flow.data.converter.StringToIntegerConverter;

import my.vaadin.first_app.MainView;

import java.util.List;
import java.util.Map;

@Route("test")


//implements HasUrlParameter<String>
public class Machine_view extends VerticalLayout {
	// Informationen angezeigt werden müssen
	
	private String startTime = "Start Time: ";
	private String duration = "Duration: ";
	private String type = "Type: ";
	private String quality = "Quality: ";
	private String paymentStatus = "Payment Status: ";
	public Machine_view() {
	//TextField test = new TextField("test");
		
	H1 header = new H1("MACHINE INTERFACE");
	Button testButton = new Button("Download txt");
	Label label1 = new Label();
	Label label2 = new Label();
	Label label3 = new Label();
	Label label4 = new Label();
	Label label5 = new Label();
	//label.setBounds(20, 20, 40, 20);
	label1.setText(startTime);
	label2.setText(duration + "       days");
	label3.setText(type);
	label4.setText(quality);
	label5.setText(paymentStatus);
	add(header, label1, label2, label3, label4, label5, testButton);
}

//	@Override
//	public void setParameter(final BeforeEvent beforeEvent, final String s) {
//		setTestText(s);
//	}

	public void setTestText(final String value) {

	}

//	@Override
	public void setParameter(final BeforeEvent beforeEvent, final String s) {
		final Location location = beforeEvent.getLocation();
		final QueryParameters queryParameters = location.getQueryParameters();

		// parse the IDs
//		final Map<String, List<String>> parametersMap = queryParameters.getParameters();
//		final var spaceId = parametersMap.get(CommonConstants.Params.SPACE_ID).get(0);
//		final var dataEntryId = parametersMap.get(CommonConstants.Params.DATA_ID).get(0);
	}
}
