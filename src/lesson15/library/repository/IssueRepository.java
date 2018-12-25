package lesson15.library.repository;

import lesson15.library.entity.Book;
import lesson15.library.entity.Issue;
import lesson15.library.entity.Visitor;

import java.util.Date;

public class IssueRepository {
    private Issue[] issues;

    public IssueRepository(Issue[] issues) {
        this.issues = issues;
    }

    public Issue[] getIssues() {
        return issues;
    }

    public Date getMinIssueDateForVisitor(Visitor visitor) {
        Issue[] visitorIssues = getActiveIssuesForVisitor(visitor);
        if (visitorIssues.length == 0) {
            return null;
        }

        Date minDate = visitorIssues[0].getIssueDate();
        for (Issue issue : visitorIssues) {
            if (issue.getIssueDate().compareTo(minDate) < 0) {
                minDate = issue.getIssueDate();
            }
        }

        return minDate;
    }

    public Issue addIssue(Issue issue) {
        issue.setId(getNextIssueId());

        for (int i = 0; i < issues.length; i++) {
            if (issues[i] == null) {
                issues[i] = issue;

                return issue;
            }
        }

        return null;
    }

    public Issue[] getAllActiveIssues() {
        int length = 0;
        for (Issue issue : issues) {
            if (issue != null && issue.getReturnDate() == null) {
                length++;
            }
        }

        Issue[] activeIssues = new Issue[length];
        int index = 0;
        for (Issue issue : issues) {
            if (issue != null && issue.getReturnDate() == null) {
                activeIssues[index] = issue;
                index++;
            }
        }

        return activeIssues;
    }

    public Issue getIssueByBookAndVisitor(Book book, Visitor visitor) {
        for (Issue issue : issues) {
            if (issue != null && issue.getReturnDate() == null
                    && visitor.equals(issue.getVisitor()) && visitor.hashCode() == issue.getVisitor().hashCode()
                    && book.equals(issue.getBook()) && book.hashCode() == issue.getBook().hashCode()) {
                return issue;
            }
        }

        return null;
    }

    private Issue[] getActiveIssuesForVisitor(Visitor visitor) {
        int length = 0;
        for (Issue issue : issues) {
            if (issue != null && issue.getReturnDate() == null
                    && visitor.equals(issue.getVisitor()) && visitor.hashCode() == issue.getVisitor().hashCode()) {
                length++;
            }
        }

        Issue[] visitorIssues = new Issue[length];
        int index = 0;
        for (Issue issue : issues) {
            if (issue != null && issue.getReturnDate() == null
                    && visitor.equals(issue.getVisitor()) && visitor.hashCode() == issue.getVisitor().hashCode()) {
                visitorIssues[index] = issue;
                index++;
            }
        }

        return visitorIssues;
    }

    private long getNextIssueId() {
        long maxId = issues[0] != null ? issues[0].getId() : 0;
        for (Issue issue : issues) {
            if (issue != null && issue.getId() > maxId) {
                maxId = issue.getId();
            }
        }
        maxId++;

        return maxId;
    }
}