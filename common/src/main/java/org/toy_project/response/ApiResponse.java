package org.toy_project.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import static org.toy_project.response.ApiResponse.ResultCode.CREATED;
import static org.toy_project.response.ApiResponse.ResultCode.FAIL;
import static org.toy_project.response.ApiResponse.ResultCode.SUCCESS;

@Getter
public class ApiResponse<T> {

    private static final ApiResponse<Void> OK = new ApiResponse<>(SUCCESS);

    public enum ResultCode {
        SUCCESS(200),
        CREATED(201),
        FAIL(500);

        private int code;

        ResultCode(int code) {
            this.code = code;
        }
    }

    @Getter
    public static class Error<R> {

        private HttpStatus status;
        private R cause;

        public Error(HttpStatus status, R cause) {
            this.status = status;
            this.cause = cause;
        }
    }

    private final ResultCode code;
    private T result;

    private ApiResponse(ResultCode code) {
        this.code = code;
    }

    private ApiResponse(ResultCode code, T result) {
        this.code = code;
        this.result = result;
    }

    public static ApiResponse<Error<String>> internalServerError(Exception e) {
        return ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR, String.format("[%s] %s", e.getClass().getSimpleName(), e.getMessage()));
    }

    public static <R> ApiResponse<Error<R>> badRequest(R cause) {
        return ApiResponse.error(HttpStatus.BAD_REQUEST, cause);
    }

    private static <R> ApiResponse<Error<R>> error(HttpStatus status, R cause) {
        return new ApiResponse<>(FAIL, new Error<>(status, cause));
    }

    public static ApiResponse<Void> ok() {
        return ApiResponse.OK;
    }

    public static <T> ApiResponse<T> created(T result) {
        return new ApiResponse<>(CREATED, result);
    }

    public static <T> ApiResponse<T> ok(T result) {
        return new ApiResponse<>(SUCCESS, result);
    }
}
