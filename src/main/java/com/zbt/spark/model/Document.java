package com.zbt.spark.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Frank Zhang on 16/3/3.
 */
@DatabaseTable(tableName = "document")
public class Document {

    @DatabaseField(generatedId = true)
    public Integer id;
    @DatabaseField
    public String title;
    @DatabaseField
    public String text;
}
