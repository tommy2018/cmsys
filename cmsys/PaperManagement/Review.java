package cmsys.PaperManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import cmsys.Common.CmsysException;
import cmsys.Common.Settings;

public class Review {
	private String strengths, weaknesses, cs, oc;
	private String isBP, isSP, oe, rc, relevance, originality;
	private String significance, presentation, tq, evaluation;
	private int pid, uid;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getStrengths() {
		return strengths;
	}
	public void setStrengths(String strengths) {
		this.strengths = strengths;
	}
	public String getWeaknesses() {
		return weaknesses;
	}
	public void setWeaknesses(String weaknesses) {
		this.weaknesses = weaknesses;
	}
	public String getCs() {
		return cs;
	}
	public void setCs(String cs) {
		this.cs = cs;
	}
	public String getOc() {
		return oc;
	}
	public void setOc(String oc) {
		this.oc = oc;
	}
	public String getIsBP() {
		return isBP;
	}
	public void setIsBP(String isBP) {
		this.isBP = isBP;
	}
	public String getIsSP() {
		return isSP;
	}
	public void setIsSP(String isSP) {
		this.isSP = isSP;
	}
	public String getOe() {
		return oe;
	}
	public void setOe(String oe) {
		this.oe = oe;
	}
	public String getRc() {
		return rc;
	}
	public void setRc(String rc) {
		this.rc = rc;
	}
	public String getRelevance() {
		return relevance;
	}
	public void setRelevance(String relevance) {
		this.relevance = relevance;
	}
	public String getOriginality() {
		return originality;
	}
	public void setOriginality(String originality) {
		this.originality = originality;
	}
	public String getSignificance() {
		return significance;
	}
	public void setSignificance(String significance) {
		this.significance = significance;
	}
	public String getPresentation() {
		return presentation;
	}
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
	public String getTq() {
		return tq;
	}
	public void setTq(String tq) {
		this.tq = tq;
	}
	public String getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	
	static public void submitReview(Review review) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("INSERT INTO review(uid, pid, significance, presentation, tq, evaluation, isBP, isSP, oe, rc, relevance, originality, strengths, weaknesses, cs, oc) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		) {
			String strengths, weaknesses, cs, oc;
			String isBP, isSP, oe, rc, relevance, originality;
			String significance, presentation, tq, evaluation;
			int uid, pid;
			
			strengths = review.getStrengths();
			weaknesses = review.getWeaknesses();
			cs = review.getCs();
			oc = review.getOc();
			isBP = review.getIsBP();
			isSP = review.getIsSP();
			oe = review.getOe();
			rc = review.getRc();
			relevance = review.getRelevance();
			originality = review.getOriginality();
			significance = review.getSignificance();
			presentation = review.getPresentation();
			tq = review.getTq();
			evaluation = review.getEvaluation();
			uid = review.getUid();
			pid = review.getPid();
			
			statement.setInt(1, uid);
			statement.setInt(2, pid);
			statement.setString(3, significance);
			statement.setString(4, presentation);
			statement.setString(5, tq);
			statement.setString(6, evaluation);
			statement.setString(7, isBP);
			statement.setString(8, isSP);
			statement.setString(9, oe);
			statement.setString(10, rc);
			statement.setString(11, relevance);
			statement.setString(12, originality);
			statement.setString(13, strengths);
			statement.setString(14, weaknesses);
			statement.setString(15, cs);
			statement.setString(16, oc);
			
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
		
		try (
			PreparedStatement statement = conn.prepareStatement("UPDATE distribution SET status = 1 WHERE pid = ? AND uid = ?");
		) {
			int uid, pid;
			
			uid = review.getUid();
			pid = review.getPid();
			System.out.println(uid + " "  + pid);
			statement.setInt(1, pid);
			statement.setInt(2, uid);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
		
	}
	
	static public ArrayList<Review> getReviewListByPid(int pid) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM review WHERE pid = ?");
		) {
			ArrayList<Review> reviewList = new ArrayList<Review>();
			ResultSet result = null;
			
			statement.setInt(1, pid);
			result = statement.executeQuery();
				
			while (result.next()) {
				Review review = new Review();
				
				String strengths, weaknesses, cs, oc;
				String isBP, isSP, oe, rc, relevance, originality;
				String significance, presentation, tq, evaluation;
				int uid;
					
				uid = result.getInt("uid");
				significance = result.getString("significance");
				presentation = result.getString("presentation");
				tq = result.getString("tq");
				evaluation = result.getString("evaluation");
				strengths = result.getString("strengths");
				weaknesses = result.getString("weaknesses");
				cs = result.getString("cs");
				oc = result.getString("oc");
				isBP = result.getString("isBP");
				isSP = result.getString("isSP");
				oe = result.getString("oe");
				rc = result.getString("rc");
				relevance = result.getString("relevance");
				originality = result.getString("originality");
					
				review.setCs(cs);
				review.setEvaluation(evaluation);
				review.setIsBP(isBP);
				review.setIsSP(isSP);
				review.setOc(oc);
				review.setOe(oe);
				review.setOriginality(originality);
				review.setPid(pid);
				review.setPresentation(presentation);
				review.setRc(rc);
				review.setRelevance(relevance);
				review.setSignificance(significance);
				review.setStrengths(strengths);
				review.setTq(tq);
				review.setUid(uid);
				review.setWeaknesses(weaknesses);
				
				reviewList.add(review);
			}

			result.close();
			return reviewList;
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
}
