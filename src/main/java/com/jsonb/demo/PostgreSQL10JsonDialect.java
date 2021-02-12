package com.jsonb.demo;

import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import org.hibernate.dialect.PostgreSQL10Dialect;

import java.sql.Types;
//reference https://vladmihalcea.com/hibernate-no-dialect-mapping-for-jdbc-type/  added for searching to work

public class PostgreSQL10JsonDialect extends PostgreSQL10Dialect {
    public PostgreSQL10JsonDialect() {
        super();
        this.registerHibernateType(
                Types.OTHER, JsonNodeBinaryType.class.getName()
        );
    }
}
