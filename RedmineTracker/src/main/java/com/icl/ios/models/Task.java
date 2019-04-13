package com.icl.ios.models;

import lombok.*;

import java.util.Date;

@Builder
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Task {
  private Long id;
  private Date createdOn;
  private Date updatedOn;
  private Integer numberOfTask;
  private String subject;
  private Category category;
  private Priority priority;
  private String description;
  private StatusTask status;
  private Version targetVersion;
  private Version sourceVersion;
  private Region region;
  private String fullNameOfApplicant;
}
