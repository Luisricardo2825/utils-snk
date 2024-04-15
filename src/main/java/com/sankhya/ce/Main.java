package com.sankhya.ce;

import com.sankhya.ce.http.Http;
import okhttp3.Headers;
import org.apache.commons.lang3.tuple.Triple;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Triple<String, Headers, List<String>> response = Http.client.get("https://jsonplaceholder.typicode.com/todos/1");
        System.out.println(response.getLeft());
    }
}