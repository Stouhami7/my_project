package my.vaadin.first_app;

import java.awt.peer.ChoicePeer;
import com.vaadin.flow.data.binder.Binder;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.datepicker.*;
import org.vaadin.gatanaso.MultiselectComboBox;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * The main view contains a button and a click listener.
 */
@Route
@PWA(name = "My Application", shortName = "My Application")
public class MainView extends VerticalLayout {
	
	  private List<OrderInformation> orderInformations = new LinkedList<>();
	  private Grid<OrderInformation> orderInformationGrid = new Grid<>(OrderInformation.class);
	
    public MainView() {
    	H1 header = new H1("APP INTERFACE");
    	
    	DatePicker datePicker = new DatePicker("Start Time");

    	TextField textField2 = new TextField("Duration");
    	
    	MultiselectComboBox<String> multiselectComboBox1 = new MultiselectComboBox();
    	multiselectComboBox1.setLabel("Type");
    	multiselectComboBox1.setItems("Raw", "Processed");
    	
    	MultiselectComboBox<String> multiselectComboBox2 = new MultiselectComboBox();
    	multiselectComboBox2.setLabel("Quality");
    	multiselectComboBox2.setItems("Low", "High");

        Button button1 = new Button("Send Request",
                event -> Notification.show("Request sent!"));
        
        Div errorsLayout = new Div();

        add(header, datePicker, textField2, multiselectComboBox1, multiselectComboBox2,  button1, orderInformationGrid );
      //  button1.addClickListener(click -> Notification.show("The Information are \r\n:" + "\r\n" + datePicker.getValue() + "\r\n" + textField2.getValue() + "\r\n" + multiselectComboBox1.getValue() + "\r\n" + multiselectComboBox2.getValue()));

     // Create bindings between UI fields and the data model
     //   OrderInformation instance;
        Binder<OrderInformation> binder = new Binder<>(OrderInformation.class);
        binder.forField(datePicker)
        	.asRequired("starttime is required")
        	.bind("startTime");
        binder.forField(textField2)
	        //.asRequired()
	        .withConverter(new StringToIntegerConverter("Quantity must be a number"))
	        .bind("duration");
        binder.forField(multiselectComboBox1)
	    	//.asRequired("Please choose the type")
	    	.bind("type");
        binder.forField(multiselectComboBox2)
	    	//.asRequired("Please choose the quality")
	    	.bind("quality");
        
        
//    	button1.addClickListener(click -> {
//    		OrderInformation saveOrder = new OrderInformation();
//    		binder.writeBean(saveOrder);
//    	});
    	
    	button1.addClickListener(click -> {
            try {
              errorsLayout.setText("");
      		  OrderInformation saveOrder = new OrderInformation();
      		  binder.writeBean(saveOrder);
             // addOrder(savedOrder);
      		  orderInformations.add(saveOrder);
      		  orderInformationGrid.setItems(orderInformations);
              //binder.readBean(new OrderInformation());
              //snackTypeSelect.setValue("");
            } catch (ValidationException e) {
              errorsLayout.add(new Html(e.getValidationErrors().stream()
                  .map(res -> "<p>" + res.getErrorMessage() + "</p>")
                  .collect(Collectors.joining("\n"))));
            }
          });
    }
}
