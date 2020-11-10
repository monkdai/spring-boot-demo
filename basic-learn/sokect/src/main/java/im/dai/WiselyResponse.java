package im.dai;

/**
 * @author: roc
 * @date: 2020/9/16 上午 11:42
 * @description: TODO
 */
//服务器向浏览器发的此类的消息
public class WiselyResponse {
    private String responseMessage;
    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }
    public String getResponseMessage() {
        return responseMessage;
    }
}

