package ru.saubanova.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

public enum Role {
  ADMIN, USER
}