package my.vaadin.first_app;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.data.binder.Binder;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.QueryParameters;
import com.vaadin.flow.router.internal.RouteUtil;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.datepicker.*;
import lombok.NonNull;
import org.vaadin.gatanaso.MultiselectComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.component.grid.Grid;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The main view contains a button and a click listener.
 */
@Route
@PWA(name = "My Application", shortName = "My Application")
public class MainView extends VerticalLayout {

    private List<OrderInformation> orderInformations = new LinkedList<>();

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

        Button button1 = new Button("Send Request", event -> navigateToMachineView(datePicker, textField2, multiselectComboBox1, multiselectComboBox2));


        add(header, datePicker, textField2, multiselectComboBox1, multiselectComboBox2, button1);

    }

    private void navigateToMachineView(final DatePicker datePicker, final TextField textField2, final MultiselectComboBox<String> multiselectComboBox1, final MultiselectComboBox<String> multiselectComboBox2) {
        final QueryParameters orderInformation = QueryParameters
                .simple(Map.of("start_time", datePicker.getValue().toString(), "duration", textField2.getValue(), "type", multiselectComboBox1.getSelectedItems().toString(), "quality", multiselectComboBox2.getSelectedItems().toString()));
        navigate(Machine_view.class, orderInformation);
    }

    public static void navigate(@NonNull final Class<?> navigationTarget,
            @NonNull final QueryParameters queryParameter) {
        final var ui = UI.getCurrent();
        final var route = navigationTarget.getAnnotation(Route.class);
        if (null != route) {
            final var location = RouteUtil.getRoutePath(navigationTarget, route);
            ui.navigate(location, queryParameter);
        } else {
//            log.warn("The component {} does not have a route.", navigationTarget);
        }
    }
}
