package com.rubles_exchange_rate;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import feign.Response;
import feign.codec.Decoder;

import static feign.Util.UTF_8;
import static feign.Util.ensureClosed;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Collections;

public class GsonDecoder implements Decoder {

    private final Gson gson;

    public GsonDecoder(Iterable<TypeAdapter<?>> adapters) {
        this(GsonFactory.create(adapters));
    }

    public GsonDecoder() {
        this(Collections.emptyList());
    }

    public GsonDecoder(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Object decode(Response response, Type type) throws IOException {
        if (response.body() == null)
            return null;
        Reader reader = response.body().asReader(UTF_8);
        try {
            return gson.fromJson(reader, type);
        } catch (JsonIOException e) {
            if (e.getCause() != null && e.getCause() instanceof IOException) {
                throw (IOException) e.getCause();
            }
            throw e;
        } finally {
            ensureClosed(reader);
        }
    }
}
