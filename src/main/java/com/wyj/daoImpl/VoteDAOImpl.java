package com.wyj.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wyj.bean.Vote;
import com.wyj.dao.VoteDAO;
import com.wyj.util.DBconnection;
import com.wyj.util.Page;

public class VoteDAOImpl implements VoteDAO{
public void addVote(Vote vote){
	Connection con=DBconnection.getConnection();
	String addSQL="insert into tb_vote(voteName,channelID) values(?,?)";
	PreparedStatement pst=null;
	
	try {
		pst=con.prepareStatement(addSQL);
		pst.setString(1, vote.getVoteName());
		pst.setInt(2, vote.getChannelID());
		pst.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally{
		DBconnection.close(pst);
		DBconnection.close(con);
	}
}

public void deleteVote(int voteID){
	Connection con = DBconnection.getConnection();	
	String deleteSQL = "delete from tb_vote where voteID=?";
	PreparedStatement pst = null;					
	try {
		pst = con.prepareStatement(deleteSQL);		
		pst.setInt(1, voteID);					
		pst.executeUpdate();								
	} catch (SQLException e) {
		e.printStackTrace();
	} finally{
		DBconnection.close(pst);							
		DBconnection.close(con);						
	}
}

public List<Vote> findAllVote(Page page) {
	Connection con = DBconnection.getConnection();		
	String findByIDSQL = "select * from tb_vote limit ?,?";		
	PreparedStatement pst = null;
	ResultSet rs = null;
	List<Vote> votes = new ArrayList<Vote>();
	try {
		pst = con.prepareStatement(findByIDSQL);		
		pst.setInt(1, page.getBeginIndex());
		pst.setInt(2, page.getEveryPage());
		rs = pst.executeQuery();						
		while(rs.next()) {
			Vote vote = new Vote();
			vote.setVoteID(rs.getInt(1));
			vote.setVoteName(rs.getString(2));
			vote.setChannelID(rs.getInt(3));
			votes.add(vote);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally{
		DBconnection.close(rs);								
		DBconnection.close(pst);							
		DBconnection.close(con);						
	}
	return votes;
}

public Vote findVoteById(int voteID) {
	Connection con = DBconnection.getConnection();	
	String querySQL  = "select * from tb_vote where voteID = ?";
	PreparedStatement pst = null;					
	ResultSet rs = null;
	Vote vote = null;
	try {
		pst = con.prepareStatement(querySQL);		
		pst.setInt(1, voteID);
		rs = pst.executeQuery();					
		if(rs.next()) {
			vote = new Vote();
			vote.setVoteID(rs.getInt(1));
			vote.setVoteName(rs.getString(2));
			vote.setChannelID(rs.getInt(3));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally{
		DBconnection.close(rs);								
		DBconnection.close(pst);							
		DBconnection.close(con);							
	}
	return vote;
}

public int findAllCount() {
	Connection con = DBconnection.getConnection();	
	String findSQL = "select count(*) from tb_vote";
	PreparedStatement pst = null;					
	ResultSet rs = null;
	int count = 0;
	try {
		pst = con.prepareStatement(findSQL);		
		rs = pst.executeQuery();					
		if(rs.next()) {
			count = rs.getInt(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally{
		DBconnection.close(rs);						//关闭结果集对象
		DBconnection.close(pst);					//关闭预处理对象
		DBconnection.close(con);					//关闭连接对象
	}
	return count;
}

public Vote findVoteByName(String voteName) {
	Connection conn = DBconnection.getConnection();	
	String querySQL  = "select * from tb_vote where voteName = ?";
	PreparedStatement pstmt = null;					
	ResultSet rs = null;
	Vote vote = null;
	try {
		pstmt = conn.prepareStatement(querySQL);		
		pstmt.setString(1, voteName);
		rs = pstmt.executeQuery();					
		if(rs.next()) {
			vote = new Vote();
			vote.setVoteID(rs.getInt(1));
			vote.setVoteName(rs.getString(2));
			vote.setChannelID(rs.getInt(3));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally{
		DBconnection.close(rs);								
		DBconnection.close(pstmt);							
		DBconnection.close(conn);							
	}
	return vote;
}
}
