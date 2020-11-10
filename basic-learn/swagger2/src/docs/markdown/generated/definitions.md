
<a name="definitions"></a>
## Definitions

<a name="link"></a>
### Link

|Name|Schema|
|---|---|
|**href**  <br>*optional*|string|
|**templated**  <br>*optional*|boolean|


<a name="a1a99db20c14165edbb7e38ee2c86a80"></a>
### Map«string,Link»
*Type* : < string, [Link](#link) > map


<a name="modelandview"></a>
### ModelAndView

|Name|Schema|
|---|---|
|**empty**  <br>*optional*|boolean|
|**model**  <br>*optional*|object|
|**modelMap**  <br>*optional*|< string, object > map|
|**reference**  <br>*optional*|boolean|
|**status**  <br>*optional*|enum (100 CONTINUE, 101 SWITCHING_PROTOCOLS, 102 PROCESSING, 103 CHECKPOINT, 200 OK, 201 CREATED, 202 ACCEPTED, 203 NON_AUTHORITATIVE_INFORMATION, 204 NO_CONTENT, 205 RESET_CONTENT, 206 PARTIAL_CONTENT, 207 MULTI_STATUS, 208 ALREADY_REPORTED, 226 IM_USED, 300 MULTIPLE_CHOICES, 301 MOVED_PERMANENTLY, 302 FOUND, 302 MOVED_TEMPORARILY, 303 SEE_OTHER, 304 NOT_MODIFIED, 305 USE_PROXY, 307 TEMPORARY_REDIRECT, 308 PERMANENT_REDIRECT, 400 BAD_REQUEST, 401 UNAUTHORIZED, 402 PAYMENT_REQUIRED, 403 FORBIDDEN, 404 NOT_FOUND, 405 METHOD_NOT_ALLOWED, 406 NOT_ACCEPTABLE, 407 PROXY_AUTHENTICATION_REQUIRED, 408 REQUEST_TIMEOUT, 409 CONFLICT, 410 GONE, 411 LENGTH_REQUIRED, 412 PRECONDITION_FAILED, 413 PAYLOAD_TOO_LARGE, 413 REQUEST_ENTITY_TOO_LARGE, 414 URI_TOO_LONG, 414 REQUEST_URI_TOO_LONG, 415 UNSUPPORTED_MEDIA_TYPE, 416 REQUESTED_RANGE_NOT_SATISFIABLE, 417 EXPECTATION_FAILED, 418 I_AM_A_TEAPOT, 419 INSUFFICIENT_SPACE_ON_RESOURCE, 420 METHOD_FAILURE, 421 DESTINATION_LOCKED, 422 UNPROCESSABLE_ENTITY, 423 LOCKED, 424 FAILED_DEPENDENCY, 425 TOO_EARLY, 426 UPGRADE_REQUIRED, 428 PRECONDITION_REQUIRED, 429 TOO_MANY_REQUESTS, 431 REQUEST_HEADER_FIELDS_TOO_LARGE, 451 UNAVAILABLE_FOR_LEGAL_REASONS, 500 INTERNAL_SERVER_ERROR, 501 NOT_IMPLEMENTED, 502 BAD_GATEWAY, 503 SERVICE_UNAVAILABLE, 504 GATEWAY_TIMEOUT, 505 HTTP_VERSION_NOT_SUPPORTED, 506 VARIANT_ALSO_NEGOTIATES, 507 INSUFFICIENT_STORAGE, 508 LOOP_DETECTED, 509 BANDWIDTH_LIMIT_EXCEEDED, 510 NOT_EXTENDED, 511 NETWORK_AUTHENTICATION_REQUIRED)|
|**view**  <br>*optional*|[View](#view)|
|**viewName**  <br>*optional*|string|


<a name="view"></a>
### View

|Name|Schema|
|---|---|
|**contentType**  <br>*optional*|string|


<a name="630c418bb8e2f6124f174386dfdf750c"></a>
### 信息实体

|Name|Description|Schema|
|---|---|---|
|**id**  <br>*optional*|1|integer (int32)|
|**name**  <br>*optional*|2|string|
|**pwd**  <br>*optional*|3|string|
|**tel**  <br>*optional*|4|integer (int32)|


