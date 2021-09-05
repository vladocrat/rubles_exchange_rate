package com.rubles_exchange_rate;




import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Map;
import static feign.Util.resolveLastTypeParameter;

final class GsonFactory {

    private GsonFactory() {}

    static Gson create(Iterable<TypeAdapter<?>> adapters) {
        GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
        builder.registerTypeAdapter(new TypeToken<Map<String, Object>>() {}.getType(),
                new DoubleToIntMapTypeAdapter());

        MyLocalDateDeserializer myLocalDateDeserializer = new MyLocalDateDeserializer();
        builder.registerTypeAdapter(LocalDate.class, myLocalDateDeserializer);

        for (TypeAdapter<?> adapter : adapters) {
            Type type = resolveLastTypeParameter(adapter.getClass(), TypeAdapter.class);
            builder.registerTypeAdapter(type, adapter);
        }
        return builder.create();
    }
}