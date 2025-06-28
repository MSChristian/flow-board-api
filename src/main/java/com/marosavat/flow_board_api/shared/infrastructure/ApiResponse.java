package com.marosavat.flow_board_api.shared.infrastructure;

public record ApiResponse<T>(
        T data,
        String error) {
    public static <T> ApiResponse<T> of(T response) {
        return new ApiResponse<>(response, null);
    }
    public static <T> ApiResponse<T> of(T response, String error) {
        return new ApiResponse<>(response, error);
    }
}
