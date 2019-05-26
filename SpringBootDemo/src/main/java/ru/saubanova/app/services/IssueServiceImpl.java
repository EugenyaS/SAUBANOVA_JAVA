package ru.saubanova.app.services;

import com.taskadapter.redmineapi.IssueManager;
import com.taskadapter.redmineapi.Params;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.bean.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.saubanova.app.models.Organization;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class IssueServiceImpl implements IssueService{
  @Autowired
  private IssueManager issueManager;
  @Override
  public List<Issue> getIssuesByOrganization(Organization organization) throws RedmineException {
/*    Params params = new Params()
            .add("set_filter", "1")
           .add("f[]", "project_id")
            .add("op[project_id]", "=")
            .add("v[project_id]", )
              .add("f[]", "cf_6")
            .add("op[cf_6]", "=")
            .add("v[cf_6]", organization.getName()) ;

  .add("f[]", "updated_on")
            .add("op[updated_on]", ">=")
            .add("v[updated_on]",  LocalDateTime.now().minusSeconds(600).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
*/
    Map<String, String> params = new HashMap<>();
    params.put("project_id", "ambulance-3");
    params.put("status_id", "open");
    if ( organization.getName() !="ICL") {
      params.put("cf_6", organization.getName());
    }
    List<Issue> issues = issueManager.getIssues(params).getResults();
    return issues;
  }
}
