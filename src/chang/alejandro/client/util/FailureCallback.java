
package chang.alejandro.client.util;

import chang.alejandro.client.SampleAppMessages;
import chang.alejandro.client.SampleAppResources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

/**
 * FailureCallback implements a customized alert dialog box for 
 * handling the asynchronous callback failure messages.
 * @version 1.0 (Jul 22, 2008)
 * @author Alejandro Chang (alejochang@gmail.com)
 */

public abstract class FailureCallback<T> implements AsyncCallback<T> {

	/**Instantiates an AlertDialogBox where the failure messages will be showed*/
	private static AlertDialogBox alert = new AlertDialogBox(SampleAppResources
			.getMessages().getMessageFunctionalityDisabled());

	public FailureCallback() {
		super();
	}

	/**
	 * @inheritDoc
	 */
	public void onFailure(Throwable theCaught) {
		this.showFailureMessage(theCaught);
	}

	/**
	 * @inheritDoc
	 */
	public abstract void onSuccess(T theResult);

	protected void showFailureMessage(Throwable theCaught) {

		theCaught.printStackTrace();
		GWT.log(theCaught.getMessage(), theCaught);

		alert.center();
		alert.getCloseButton().setFocus(true);
	}

	public static class AlertDialogBox extends DialogBox implements ClickHandler, KeyUpHandler {
		
		FlexTable body;
		SampleAppMessages msgs = SampleAppResources.getMessages();
		private Button closeButton;

		public AlertDialogBox(String message) {
			super(false, true);
			super.setText(SampleAppResources.getMessages()
					.getTitleAlertDialog());
			super.setTitle(SampleAppResources.getMessages()
					.getTitleAlertDialog());

			this.body = new FlexTable();
			this.body.getColumnFormatter().setWidth(0, "15%");
			this.body.getColumnFormatter().setWidth(1, "70%");
			this.body.getColumnFormatter().setWidth(2, "15%");

			this.body.setWidget(0, 0, new HTML("<div>&nbsp;</div>"));
			this.body.setWidget(0, 2, new HTML("<div>&nbsp;</div>"));

			this.body.getRowFormatter().setStyleName(0, "alert-row-msg");
			this.body.getRowFormatter().setStyleName(1, "alert-row-btn");

			this.body.setText(0, 1, message);

			this.closeButton = new Button(this.msgs.getTextOkButton(), this);
			this.body.setWidget(1, 1, this.closeButton);

			this.setWidget(this.body);

		}

		public void show(String message) {
			this.body.clearCell(0, 1);
			this.body.setText(0, 1, message);
			this.show();
		}

		public void center(String message) {
			this.body.clearCell(0, 1);
			this.body.setText(0, 1, message);
			this.center();
		}

		public void onClick(Widget sender) {
			this.hide();
		}

		public Button getCloseButton() {
			return this.closeButton;
		}

		public void setCloseButton(Button theCloseButton) {
			this.closeButton = theCloseButton;
			return;
		}
		
		
		/**
		 * Fired when the user clicks on the close button.
		 */
		public void onClick(ClickEvent event) {
			this.hide();
		}

		/**
		 * Fired when the user types in the alert dialog box.
		 */
		public void onKeyUp(KeyUpEvent event) {
			if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
				this.hide();
			}
		}
	}
}
