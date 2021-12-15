package com.example.demo;

import lombok.*;
import org.hibernate.envers.*;

@AllArgsConstructor
@Getter
public class RevisionData{
    // Для собственно данных таблицы можно сохранить тип Object для универсальности.
    private Object entity;
    // Объект с дополнительной информацией о редакции
    private Revision revision;
    // Тип редакции (RevisionType – штатное перечисление из состава Hibernate Envers)
    private RevisionType revisionType;
}
