package com.wyj.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wyj.bean.VoteOption;
import com.wyj.dao.VoteOptionDAO;
import com.wyj.util.DBconnection;

public class VoteOptionDAOImpl implements VoteOptionDAO{
	public void addVoteOption(VoteOption voteOption) {
		Connection conn = DBconnection.getConnection();	
		String addSQL = "insert into " +
				"tb_voteoption(voteOptionName,voteID,ticketNum) values(?,?,?)";
		PreparedStatement pstmt = null;					
		try {
			pstmt = conn.prepareStatement(addSQL);		
			pstmt.setString(1, voteOption.getVoteOptionName());	
			pstmt.setInt(2, voteOption.getVoteID());		
			pstmt.setInt(3, voteOption.getTicketNum());		
			pstmt.executeUpdate();								
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBconnection.close(pstmt);							
			DBconnection.close(conn);							
		}
	}
	
	public List<VoteOption> findVoteOptionByVoteID(int voteID) {
		Connection conn = DBconnection.getConnection();		
		String findByIDSQL = "select * from tb_voteoption where voteID = ?";
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		List<VoteOption> voteOptions = new ArrayList<VoteOption>();
		try {
			pstmt = conn.prepareStatement(findByIDSQL);		
			pstmt.setInt(1, voteID);
			rs = pstmt.executeQuery();					
			while(rs.next()) {
				VoteOption voteOption = new VoteOption();
				voteOption.setVoteOptionID(rs.getInt(1));
				voteOption.setVoteID(rs.getInt(2));
				voteOption.setVoteOptionName(rs.getString(3));
				voteOption.setTicketNum(rs.getInt(4));
				voteOptions.add(voteOption);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBconnection.close(rs);								
			DBconnection.close(pstmt);							
			DBconnection.close(conn);							
		}
		return voteOptions;
	}
	
	public void deleteVoteOption(int voteOptionID) {
		Connection conn = DBconnection.getConnection();	
		String deleteSQL = "delete from tb_voteoption where voteOptionID=?";
		PreparedStatement pstmt = null;					
		try {
			pstmt = conn.prepareStatement(deleteSQL);		
			pstmt.setInt(1, voteOptionID);						
			pstmt.executeUpdate();								
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBconnection.close(pstmt);							
			DBconnection.close(conn);							
		}
	}
}

