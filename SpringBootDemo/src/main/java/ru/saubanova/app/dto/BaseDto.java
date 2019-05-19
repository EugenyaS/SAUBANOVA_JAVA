package ru.saubanova.app.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.saubanova.app.models.IEntity;

@Data
@NoArgsConstructor
public class BaseDto<T extends IEntity> {
  private Long id;

  public BaseDto(Long id) {
    this.id = id;
  }

  public BaseDto(T entity) {
    if (entity == null) return;
    loadProperties(entity);
  }

  public void loadProperties(T pEntity) {
    this.id = pEntity.getId();
  }
}
