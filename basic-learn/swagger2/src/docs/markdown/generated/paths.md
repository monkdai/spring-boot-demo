
<a name="paths"></a>
## Paths

<a name="linksusingget"></a>
### links
```
GET /actuator
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< string, < string, [Link](#link) > map > map|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `application/vnd.spring-boot.actuator.v3+json`
* `application/json`
* `application/vnd.spring-boot.actuator.v2+json`


#### Tags

* web-mvc-links-handler


<a name="handleusingget_1"></a>
### handle
```
GET /actuator/health
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*optional*|body|< string, string > map|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|object|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `application/vnd.spring-boot.actuator.v3+json`
* `application/json`
* `application/vnd.spring-boot.actuator.v2+json`


#### Tags

* operation-handler


<a name="handleusingget"></a>
### handle
```
GET /actuator/health/**
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*optional*|body|< string, string > map|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|object|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `application/vnd.spring-boot.actuator.v3+json`
* `application/json`
* `application/vnd.spring-boot.actuator.v2+json`


#### Tags

* operation-handler


<a name="handleusingget_2"></a>
### handle
```
GET /actuator/info
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*optional*|body|< string, string > map|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|object|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `application/vnd.spring-boot.actuator.v3+json`
* `application/json`
* `application/vnd.spring-boot.actuator.v2+json`


#### Tags

* operation-handler


<a name="errorhtmlusingpost"></a>
### errorHtml
```
POST /error
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[ModelAndView](#modelandview)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `text/html`


#### Tags

* basic-error-controller


<a name="errorhtmlusingget"></a>
### errorHtml
```
GET /error
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[ModelAndView](#modelandview)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `text/html`


#### Tags

* basic-error-controller


<a name="errorhtmlusingput"></a>
### errorHtml
```
PUT /error
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[ModelAndView](#modelandview)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `text/html`


#### Tags

* basic-error-controller


<a name="errorhtmlusingdelete"></a>
### errorHtml
```
DELETE /error
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[ModelAndView](#modelandview)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Produces

* `text/html`


#### Tags

* basic-error-controller


<a name="errorhtmlusingpatch"></a>
### errorHtml
```
PATCH /error
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[ModelAndView](#modelandview)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Consumes

* `application/json`


#### Produces

* `text/html`


#### Tags

* basic-error-controller


<a name="errorhtmlusinghead"></a>
### errorHtml
```
HEAD /error
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[ModelAndView](#modelandview)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Consumes

* `application/json`


#### Produces

* `text/html`


#### Tags

* basic-error-controller


<a name="errorhtmlusingoptions"></a>
### errorHtml
```
OPTIONS /error
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[ModelAndView](#modelandview)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Consumes

* `application/json`


#### Produces

* `text/html`


#### Tags

* basic-error-controller


<a name="insertusingpost"></a>
### 增加信息
```
POST /info/add
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**info**  <br>*required*|info|[信息实体](#630c418bb8e2f6124f174386dfdf750c)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|No Content|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* 信息管理


<a name="findpageusingget"></a>
### 分页查询
```
GET /info/all
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**page**  <br>*required*|page|integer (int32)|
|**Query**|**size**  <br>*required*|size|integer (int32)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< [信息实体](#630c418bb8e2f6124f174386dfdf750c) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* 信息管理


<a name="deletebyidusingdelete"></a>
### 删除信息
```
DELETE /info/delete/{id}
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|No Content|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Produces

* `\*/*`


#### Tags

* 信息管理


<a name="updatebyidusingput"></a>
### 修改信息
```
PUT /info/edit
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**info**  <br>*required*|info|[信息实体](#630c418bb8e2f6124f174386dfdf750c)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|No Content|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* 信息管理



