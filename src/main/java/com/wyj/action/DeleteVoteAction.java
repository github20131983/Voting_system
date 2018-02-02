package com.wyj.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.wyj.bean.VoteOption;
import com.wyj.dao.VoteDAO;
import com.wyj.dao.VoteOptionDAO;
import com.wyj.daoFactory.VoteDAOFactory;
import com.wyj.daoFactory.VoteOptionDAOFactory;

public class DeleteVoteAction extends ActionSupport {
	private int voteID;

	public int getVoteID() {
		return voteID;
	}

	public void setVoteID(int voteID) {
		this.voteID = voteID;
	}
	public String execute() throws Exception {
		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
		VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory
				.getVoteOptionDAOInstance();

		List<VoteOption> voteOptions = voteOptionDAO.findVoteOptionByVoteID(voteID);

		for(VoteOption voteOption : voteOptions) {
			voteOptionDAO.deleteVoteOption(voteOption.getVoteOptionID());
		}
		voteDAO.deleteVote(voteID);
		return this.SUCCESS;
	}
}
