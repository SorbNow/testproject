package com.sorb.testproject.model.metadata;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(TableMetadata.TableMetadataKey.class)
@Table(name = "table_metadata")
public class TableMetadata {
    @Column(name = "column_name")
    @Id
    String columnName;

    @Column(name = "table_name")
    @Id
    String tableName;

    public static class TableMetadataKey implements Serializable {
        String columnName;
        String tableName;
    }
}