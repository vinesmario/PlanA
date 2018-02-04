package com.common.model.po;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "jhi_user")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Account {
    private Integer id;
}
