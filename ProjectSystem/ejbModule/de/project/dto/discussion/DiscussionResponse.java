package de.project.dto.discussion;

import java.util.List;

import de.project.dto.ReturncodeResponse;


public class DiscussionResponse extends ReturncodeResponse {

	private static final long serialVersionUID = 5490499269768302179L;
	
	private List<DiscussionTO> discussions;

	public List<DiscussionTO> getDiscussions() {
		return discussions;
	}

	public void setDiscussions(List<DiscussionTO> discussions) {
		this.discussions = discussions;
	} 

}
