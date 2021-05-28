package com.sorb.testproject.repository.metadata;

import com.sorb.testproject.model.metadata.TableMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableMetadataRepository extends JpaRepository<TableMetadata, TableMetadata.TableMetadataKey>
{
    TableMetadata findByTableName(String tableName);
}
