package trawler.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class HttpRequestBody implements Serializable {
    private static final long serialVersionUID = 5659170945717023595L;
    private byte[] body;
    private String contentType;
    private String encoding;

//    public static HttpRequestBody json(String json, String encoding){
//
//    }

}
