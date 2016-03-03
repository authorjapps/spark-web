package com.zbt.spark;
import com.alibaba.fastjson.JSON;
import com.zbt.spark.model.Document;

import static com.zbt.spark.ConnectionManager.*;
import static spark.Spark.*;

/**
 * Created by Frank Zhang on 16/3/3.
 */
public class SparkServer {

    public static void main(String[] args) {
        port(8080);
        get("/hello", (request, response) -> "Hello World!");
        documents();
    }

    public static void documents() {
        get("/documents/:id", (request, response) -> JSON.toJSONString(getDocumentDao().queryForId(Integer.valueOf(request.params(":id")))));
        post("/documents", (request, response) -> {
            System.out.println(request.body());
            Document document = JSON.parseObject(request.body(), Document.class);
            return getDocumentDao().create(document);
        });
        put("/documents/:id", (request, response) -> {
            Document document = JSON.parseObject(request.body(), Document.class);
            document.id = Integer.valueOf(request.params("id"));
            return getDocumentDao().update(document);
        });
        delete("/documents/:id", (request, response) -> getDocumentDao().deleteById(Integer.valueOf(request.params("id"))));
    }

}
