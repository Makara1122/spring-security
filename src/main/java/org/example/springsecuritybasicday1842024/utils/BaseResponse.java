package org.example.springsecuritybasicday1842024.utils;


import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

@Accessors(chain = true)
@Data
public class BaseResponse <T> {
    private T payload;
    private String message;
    private Object metadata; // relates to pagination
    private int status;

    public static <T> BaseResponse<T> createSuccess() {
        return new BaseResponse<T>()
                .setStatus(HttpStatus.CREATED.value())
                .setMessage("Created Successfully!!! ")
                ;
    }
    public static <T> BaseResponse<T> getAllUsers(){
        return new BaseResponse<T>()
                .setStatus(HttpStatus.OK.value())
                .setMessage("All Users")
                ;
    }

}
