package cmsys.PaperManagement;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cmsys.Common.CmsysException;
import cmsys.UserManagement.User;

public class Check {
	static public boolean isCOI(Paper p, User u) throws CmsysException {        
        User UserSubmiter = User.getUserByUid(p.getUid());
        String SubmiterEmail = UserSubmiter.getEmail();
        String ReviewerEmail = u.getEmail();
        try {
        Pattern pattern = Pattern.compile("@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?");
        Matcher mSubmitEmail = pattern.matcher(SubmiterEmail);
        Matcher mReviewerEmail = pattern.matcher(ReviewerEmail);
        mSubmitEmail.find();
        mReviewerEmail.find();
        SubmiterEmail = mSubmitEmail.group();
        ReviewerEmail = mReviewerEmail.group();
        System.out.println(SubmiterEmail + ", " + ReviewerEmail);
        if (SubmiterEmail.equalsIgnoreCase(ReviewerEmail)) {
            return true;
        }
        
        ArrayList<Author> authors = p.getAuthors();
        for (Author a : authors) {
            if (a.getFirstName().equalsIgnoreCase(u.getFirstName())) {
            	if (a.getLastName().equalsIgnoreCase(u.getLastName())) {
                    return true;
                }
            }
            
        }
        return false;
        } catch (Exception e) {
        	return false;
        }
    }

}
