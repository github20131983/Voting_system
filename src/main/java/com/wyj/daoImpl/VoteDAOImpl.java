package com.wyj.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wyj.bean.Vote;
import com.wyj.dao.VoteDAO;
import com.wyj.util.DBconnection;

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

public void deleteVote(){
	
}

public Vote findVoteByName(String voteName) {
	Connection conn = DBconnection.getConnection();	//获得连接对象
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
