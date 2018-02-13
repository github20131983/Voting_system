package com.wyj.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wyj.bean.Vote;
import com.wyj.bean.VoteOption;
import com.wyj.bean.VoteResult;
import com.wyj.dao.VoteDAO;
import com.wyj.dao.VoteOptionDAO;
import com.wyj.daoFactory.VoteDAOFactory;
import com.wyj.daoFactory.VoteOptionDAOFactory;
import com.wyj.util.Page;
import com.wyj.util.PageUtil;

public class ShowVoteByChannelAction extends ActionSupport {
	private int channelID;
	private int currentPage;

	public int getChannelID() {
		return channelID;
	}

	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String execute() throws Exception {
		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
		VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory
				.getVoteOptionDAOInstance();
		// 获得该频道下的记录数
		int totalCount = voteDAO.findCountByChannel(channelID);
		// 设置分页信息
		Page page = PageUtil.createPage(3, totalCount, currentPage);
		//取得该频道下的记录
		List<Vote> votes = voteDAO.findVoteByChannel(page, channelID);
		//存放所有投票和投票选项
		List<VoteResult> voteResultList = new ArrayList<VoteResult>();
		for (Vote vote : votes) {
			//查询该投票下的所有投票选项
			List<VoteOption> voteOptions = voteOptionDAO
					.findVoteOptionByVoteID(vote.getVoteID());
			VoteResult voteResult = new VoteResult();
			voteResult.setVote(vote);
			voteResult.setVoteOptions(voteOptions);
			voteResultList.add(voteResult);
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("voteResultList",voteResultList);
		request.setAttribute("page",page);
		return this.SUCCESS;
	}
}
