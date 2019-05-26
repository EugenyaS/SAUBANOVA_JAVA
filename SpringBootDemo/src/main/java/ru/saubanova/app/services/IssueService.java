package ru.saubanova.app.services;

import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.bean.Issue;
import ru.saubanova.app.models.Organization;

import java.util.List;

public interface IssueService {
  List<Issue> getIssuesByOrganization(Organization organization) throws RedmineException;
}
