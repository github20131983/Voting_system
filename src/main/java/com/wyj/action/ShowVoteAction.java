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

public class ShowVoteAction extends ActionSupport {
		private int currentPage;

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
			int totalCount = voteDAO.findAllCount();
			Page page = PageUtil.createPage(10, totalCount, currentPage);
			List<Vote> votes = voteDAO.findAllVote(page);
			List<VoteResult> voteResultList = new ArrayList<VoteResult>();
			for (Vote vote : votes) {
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

