package chang.alejandro.client.widgets.ticket;

import chang.alejandro.client.SampleAppResources;
import chang.alejandro.shared.domain.TicketData;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DateLabel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

/**
 * @version 1.0 (Jul 1, 2008)
 * @author Alejandro Chang (alejochang@gmail.com)
 */

public class TicketInfoRow extends Composite {

	private final HorizontalPanel rowLayer;
	private FlexTable rowBody;
	private final Button viewDetailBtn;
	private final ClickHandler clickHandler;
	private final boolean isOdd;
	private TicketData ticket;
	private DateLabel callDateLbl;
	private Label issueLbl;
	private Label urgencyLbl;

	public TicketInfoRow(TicketData theTicket, ClickHandler theClickhandler,
			boolean theIsOdd) {
		this.ticket = theTicket;
		this.rowLayer = new HorizontalPanel();
		this.rowBody = new FlexTable();
		this.viewDetailBtn = new Button(SampleAppResources.getMessages()
				.getCardStandardGoToCard());

		this.clickHandler = theClickhandler;
		this.rowLayer.addStyleName("tableRow");
		this.rowBody.addStyleName("tableRow");
		this.viewDetailBtn.setStyleName("goToBtn");
		this.viewDetailBtn.addClickHandler(this.clickHandler);
		this.isOdd = theIsOdd;

		this.callDateLbl = new DateLabel();
		this.issueLbl = new Label();
		this.urgencyLbl = new Label();

		String baseStyle = this.isOdd ? "detailedCellOdd" : "detailedCellEven";

		this.rowBody.getColumnFormatter().setWidth(0, "150px");
		this.rowBody.getColumnFormatter().setWidth(1, "150px");
		this.rowBody.getColumnFormatter().setWidth(2, "150px");
		this.rowBody.getColumnFormatter().setWidth(3, "20px");

		this.callDateLbl = new DateLabel();
		this.issueLbl = new Label();
		this.urgencyLbl = new Label();

		this.callDateLbl.setValue(this.ticket.getCallDate());
		
		this.issueLbl.setText(this.ticket.getIssue());
		
		this.urgencyLbl.setText(this.ticket.getUrgency());

		this.rowBody.setWidget(0, 0, this.callDateLbl);
		this.rowBody.getCellFormatter().setStyleName(0, 0, baseStyle);
		this.rowBody.setWidget(0, 1, this.issueLbl);
		this.rowBody.getCellFormatter().setStyleName(0, 1, baseStyle);
		this.rowBody.setWidget(0, 2, this.urgencyLbl);
		this.rowBody.setWidget(0, 3, this.viewDetailBtn);
		this.rowBody.getCellFormatter().setStyleName(0, 3, baseStyle);

		this.rowBody.setWidth("100%");
		this.rowLayer.add(this.rowBody);
		this.rowLayer.setWidth("100%");
		this.initWidget(this.rowLayer);
	}
}
