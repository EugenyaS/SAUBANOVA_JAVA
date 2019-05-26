package ru.saubanova.app.controllers;

import com.taskadapter.redmineapi.IssueManager;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.bean.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.saubanova.app.models.User;
import ru.saubanova.app.security.details.UserDetailsImpl;
import ru.saubanova.app.services.IssueService;

import java.util.List;

@Controller
public class IssuesController {

  @Autowired
  IssueService issueService;

  @GetMapping("/issues")
  @PreAuthorize("isAuthenticated()")
  public String getIssues(Authentication authentication, ModelMap model) throws RedmineException {
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    User user = userDetails.getUser();
    List<Issue> issues = issueService.getIssuesByOrganization(user.getOrganization());
    model.addAttribute("issues", issues);
    return "issues";
  }

}
