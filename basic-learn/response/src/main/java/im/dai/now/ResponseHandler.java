package im.dai.now;

import im.dai.old.ResResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @ClassName ResponseHandler
 * @description: TODO
 * @author: roc
 * @date: 2020/8/9 下午 11:26
 * @version: 1.0
 */
@ControllerAdvice(basePackages = "im.dai.response.now")
class ResponseHandler implements ResponseBodyAdvice<Object> {

    /**
     * 是否支持advice功能
     * true=支持，false=不支持
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    /**
     *
     * 处理response的具体业务方法
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //if (o instanceof String) {
        //    return JsonUtil.object2Json(ResResult.suc(o));
        //}
        return ResResult.suc(o);
    }
}
