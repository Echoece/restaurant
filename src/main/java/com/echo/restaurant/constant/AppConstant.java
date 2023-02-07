package com.echo.restaurant.constant;

public class AppConstant {
    public static final Integer DEFAULT_PAGE_SIZE = 1000;
    public static final String[] WHITE_LIST_URL = {
            "/",
            "index",
            "/css/*",
            "/js/*",
            "/api/v1/auth/**",
            "/login",
            "/swagger-resources",
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/api/v1/**"
    };
}
