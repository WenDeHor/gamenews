package com.silkpath.gamenews.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class IdEntity implements Persistable<Integer> {
    public static final int START_SEQENCE = 1000;
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQENCE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    protected Integer id;

    public IdEntity() {
    }

    public IdEntity(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return this.id == null;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ":" + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdEntity idEntity = (IdEntity) o;
        return id.equals(idEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
