package de.project.dto.discussion;

import java.io.Serializable;
import java.util.List;


public class DiscussionResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5490499269768302179L;
	
	private List<DiscussionTO> discussions;

	public List<DiscussionTO> getDiscussions() {
		return discussions;
	}

	public void setDiscussions(List<DiscussionTO> discussions) {
		this.discussions = discussions;
	} 
	
	
	

}
