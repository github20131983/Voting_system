package com.wyj.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wyj.bean.Vote;
import com.wyj.bean.VoteOption;
import com.wyj.dao.VoteDAO;
import com.wyj.dao.VoteOptionDAO;
import com.wyj.daoFactory.VoteDAOFactory;
import com.wyj.daoFactory.VoteOptionDAOFactory;

public class AddVoteAction extends ActionSupport {
	private int channel;		
	private String voteName;	
	private String[] voteOption;

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public String getVoteName() {
		return voteName;
	}

	public void setVoteName(String voteName) {
		this.voteName = voteName;
	}

	public String[] getVoteOption() {
		return voteOption;
	}

	public void setVoteOption(String[] voteOption) {
		this.voteOption = voteOption;
	}

	public String execute() throws Exception {
		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
		VoteOptionDAO voteOptionDAO = 
			VoteOptionDAOFactory.getVoteOptionDAOInstance();
		
		Vote vote = new Vote();
		vote.setChannelID(channel);
		vote.setVoteName(voteName);
		voteDAO.addVote(vote);
		
		int voteID = voteDAO.findVoteByName(voteName).getVoteID();
		
		for(String voteOptionName : voteOption) {
			VoteOption vp = new VoteOption();
			vp.setVoteID(voteID);
			vp.setVoteOptionName(voteOptionName);
			voteOptionDAO.addVoteOption(vp);
		}
		return this.SUCCESS;
	}

}
