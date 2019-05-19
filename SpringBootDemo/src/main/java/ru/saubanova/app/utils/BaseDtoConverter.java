package ru.saubanova.app.utils;

import ru.saubanova.app.dto.BaseDto;
import ru.saubanova.app.models.IEntity;

public interface BaseDtoConverter <E extends IEntity, D extends BaseDto<E>> {

  E toEntity(D dto);

}

