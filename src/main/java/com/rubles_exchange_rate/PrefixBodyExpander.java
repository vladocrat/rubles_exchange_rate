package com.rubles_exchange_rate;

import feign.Param;

public class PrefixBodyExpander implements Param.Expander {
    @Override
    public String expand(Object value) {
        return "body:" + value;
    }
}