package come.test;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("createEvent")
@ConversationScoped
public class CreateAction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Conversation conversation;

	public String startCreateEvent() {
		if (conversation.isTransient()) {
			conversation.begin();
		}
		return "/createEvent.xhtml";
	}

	/**
	 * 
	 * @return
	 */
	// @Transactional
	public String createEvent() {

		// do some stuff for event with DB, omitted
		if (!conversation.isTransient()) {
			conversation.end();
		}
		return "home.xhtml";
	}

	public String cancel() {
		conversation.end();
		return "cancel";
	}
}
