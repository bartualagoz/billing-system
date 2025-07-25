---
title: Customer Billing System API v1.0
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
highlight_theme: darkula
headingLevel: 2

---

<!-- Generator: Widdershins v4.0.1 -->

<h1 id="customer-billing-system-api">Customer Billing System API v1.0</h1>

> Scroll down for code samples, example requests and responses. Select a language for code samples from the tabs above or the mobile navigation menu.

API documentation for the Customer Billing System

Base URLs:

* <a href="http://localhost:8082">http://localhost:8082</a>

<h1 id="customer-billing-system-api-invoice-controller">invoice-controller</h1>

## getInvoiceById

<a id="opIdgetInvoiceById"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8082/api/invoice/{id} \
  -H 'Accept: */*'

```

```http
GET http://localhost:8082/api/invoice/{id} HTTP/1.1
Host: localhost:8082
Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'
};

fetch('http://localhost:8082/api/invoice/{id}',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.get 'http://localhost:8082/api/invoice/{id}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.get('http://localhost:8082/api/invoice/{id}', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8082/api/invoice/{id}', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/invoice/{id}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8082/api/invoice/{id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /api/invoice/{id}`

<h3 id="getinvoicebyid-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|id|path|integer(int32)|true|none|

> Example responses

> 200 Response

<h3 id="getinvoicebyid-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[Invoice](#schemainvoice)|

<aside class="success">
This operation does not require authentication
</aside>

## updateInvoice

<a id="opIdupdateInvoice"></a>

> Code samples

```shell
# You can also use wget
curl -X PUT http://localhost:8082/api/invoice/{id} \
  -H 'Content-Type: application/json' \
  -H 'Accept: */*'

```

```http
PUT http://localhost:8082/api/invoice/{id} HTTP/1.1
Host: localhost:8082
Content-Type: application/json
Accept: */*

```

```javascript
const inputBody = '{
  "invoiceId": 0,
  "totalCost": 0.1,
  "date": "2019-08-24",
  "account": {
    "customer": {
      "firstName": "string",
      "lastName": "string",
      "nationalId": "string",
      "phoneNo": "string",
      "email": "string",
      "user": {
        "id": 0,
        "username": "string",
        "password": "string",
        "enabled": true,
        "accountNonExpired": true,
        "credentialsNonExpired": true,
        "authorities": [
          {
            "authority": "string"
          }
        ],
        "accountNonLocked": true
      },
      "id": 0
    },
    "address": {
      "id": 0,
      "street": "string",
      "avenue": "string",
      "postalCode": 0,
      "buildingNo": 0,
      "doorNo": 0,
      "city": "string",
      "country": "string"
    },
    "invoices": [
      {
        "invoiceId": 0,
        "totalCost": 0.1,
        "date": "2019-08-24",
        "account": {}
      }
    ],
    "id": 0
  }
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'*/*'
};

fetch('http://localhost:8082/api/invoice/{id}',
{
  method: 'PUT',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'application/json',
  'Accept' => '*/*'
}

result = RestClient.put 'http://localhost:8082/api/invoice/{id}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': '*/*'
}

r = requests.put('http://localhost:8082/api/invoice/{id}', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('PUT','http://localhost:8082/api/invoice/{id}', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/invoice/{id}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PUT");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"application/json"},
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("PUT", "http://localhost:8082/api/invoice/{id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`PUT /api/invoice/{id}`

> Body parameter

```json
{
  "invoiceId": 0,
  "totalCost": 0.1,
  "date": "2019-08-24",
  "account": {
    "customer": {
      "firstName": "string",
      "lastName": "string",
      "nationalId": "string",
      "phoneNo": "string",
      "email": "string",
      "user": {
        "id": 0,
        "username": "string",
        "password": "string",
        "enabled": true,
        "accountNonExpired": true,
        "credentialsNonExpired": true,
        "authorities": [
          {
            "authority": "string"
          }
        ],
        "accountNonLocked": true
      },
      "id": 0
    },
    "address": {
      "id": 0,
      "street": "string",
      "avenue": "string",
      "postalCode": 0,
      "buildingNo": 0,
      "doorNo": 0,
      "city": "string",
      "country": "string"
    },
    "invoices": [
      {
        "invoiceId": 0,
        "totalCost": 0.1,
        "date": "2019-08-24",
        "account": {}
      }
    ],
    "id": 0
  }
}
```

<h3 id="updateinvoice-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|id|path|integer(int32)|true|none|
|body|body|[Invoice](#schemainvoice)|true|none|

> Example responses

> 200 Response

<h3 id="updateinvoice-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[Invoice](#schemainvoice)|

<aside class="success">
This operation does not require authentication
</aside>

## deleteInvoiceById

<a id="opIddeleteInvoiceById"></a>

> Code samples

```shell
# You can also use wget
curl -X DELETE http://localhost:8082/api/invoice/{id}

```

```http
DELETE http://localhost:8082/api/invoice/{id} HTTP/1.1
Host: localhost:8082

```

```javascript

fetch('http://localhost:8082/api/invoice/{id}',
{
  method: 'DELETE'

})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

result = RestClient.delete 'http://localhost:8082/api/invoice/{id}',
  params: {
  }

p JSON.parse(result)

```

```python
import requests

r = requests.delete('http://localhost:8082/api/invoice/{id}')

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('DELETE','http://localhost:8082/api/invoice/{id}', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/invoice/{id}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("DELETE");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("DELETE", "http://localhost:8082/api/invoice/{id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`DELETE /api/invoice/{id}`

<h3 id="deleteinvoicebyid-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|id|path|integer(int32)|true|none|

<h3 id="deleteinvoicebyid-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|None|

<aside class="success">
This operation does not require authentication
</aside>

## getAllInvoices

<a id="opIdgetAllInvoices"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8082/api/invoice \
  -H 'Accept: */*'

```

```http
GET http://localhost:8082/api/invoice HTTP/1.1
Host: localhost:8082
Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'
};

fetch('http://localhost:8082/api/invoice',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.get 'http://localhost:8082/api/invoice',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.get('http://localhost:8082/api/invoice', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8082/api/invoice', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/invoice");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8082/api/invoice", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /api/invoice`

> Example responses

> 200 Response

<h3 id="getallinvoices-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="getallinvoices-responseschema">Response Schema</h3>

Status Code **200**

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|[[Invoice](#schemainvoice)]|false|none|none|
|» invoiceId|integer(int32)|false|none|none|
|» totalCost|number(double)|false|none|none|
|» date|string(date)|false|none|none|
|» account|[BillingAccount](#schemabillingaccount)|false|none|none|
|»» customer|[Customer](#schemacustomer)|false|none|none|
|»»» firstName|string|false|none|none|
|»»» lastName|string|false|none|none|
|»»» nationalId|string|false|none|none|
|»»» phoneNo|string|false|none|none|
|»»» email|string|false|none|none|
|»»» user|[User](#schemauser)|false|none|none|
|»»»» id|integer(int32)|false|none|none|
|»»»» username|string|false|none|none|
|»»»» password|string|false|none|none|
|»»»» enabled|boolean|false|none|none|
|»»»» accountNonExpired|boolean|false|none|none|
|»»»» credentialsNonExpired|boolean|false|none|none|
|»»»» authorities|[[GrantedAuthority](#schemagrantedauthority)]|false|none|none|
|»»»»» authority|string|false|none|none|
|»»»» accountNonLocked|boolean|false|none|none|
|»»» id|integer(int32)|false|none|none|
|»» address|[BillingAddress](#schemabillingaddress)|false|none|none|
|»»» id|integer(int32)|false|none|none|
|»»» street|string|false|none|none|
|»»» avenue|string|false|none|none|
|»»» postalCode|integer(int32)|false|none|none|
|»»» buildingNo|integer(int32)|false|none|none|
|»»» doorNo|integer(int32)|false|none|none|
|»»» city|string|false|none|none|
|»»» country|string|false|none|none|
|»» invoices|[[Invoice](#schemainvoice)]|false|none|none|
|»» id|integer(int32)|false|none|none|

<aside class="success">
This operation does not require authentication
</aside>

## createInvoice

<a id="opIdcreateInvoice"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8082/api/invoice \
  -H 'Content-Type: application/json' \
  -H 'Accept: */*'

```

```http
POST http://localhost:8082/api/invoice HTTP/1.1
Host: localhost:8082
Content-Type: application/json
Accept: */*

```

```javascript
const inputBody = '{
  "invoiceId": 0,
  "totalCost": 0.1,
  "date": "2019-08-24",
  "account": {
    "customer": {
      "firstName": "string",
      "lastName": "string",
      "nationalId": "string",
      "phoneNo": "string",
      "email": "string",
      "user": {
        "id": 0,
        "username": "string",
        "password": "string",
        "enabled": true,
        "accountNonExpired": true,
        "credentialsNonExpired": true,
        "authorities": [
          {
            "authority": "string"
          }
        ],
        "accountNonLocked": true
      },
      "id": 0
    },
    "address": {
      "id": 0,
      "street": "string",
      "avenue": "string",
      "postalCode": 0,
      "buildingNo": 0,
      "doorNo": 0,
      "city": "string",
      "country": "string"
    },
    "invoices": [
      {
        "invoiceId": 0,
        "totalCost": 0.1,
        "date": "2019-08-24",
        "account": {}
      }
    ],
    "id": 0
  }
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'*/*'
};

fetch('http://localhost:8082/api/invoice',
{
  method: 'POST',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'application/json',
  'Accept' => '*/*'
}

result = RestClient.post 'http://localhost:8082/api/invoice',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': '*/*'
}

r = requests.post('http://localhost:8082/api/invoice', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('POST','http://localhost:8082/api/invoice', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/invoice");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"application/json"},
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("POST", "http://localhost:8082/api/invoice", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`POST /api/invoice`

> Body parameter

```json
{
  "invoiceId": 0,
  "totalCost": 0.1,
  "date": "2019-08-24",
  "account": {
    "customer": {
      "firstName": "string",
      "lastName": "string",
      "nationalId": "string",
      "phoneNo": "string",
      "email": "string",
      "user": {
        "id": 0,
        "username": "string",
        "password": "string",
        "enabled": true,
        "accountNonExpired": true,
        "credentialsNonExpired": true,
        "authorities": [
          {
            "authority": "string"
          }
        ],
        "accountNonLocked": true
      },
      "id": 0
    },
    "address": {
      "id": 0,
      "street": "string",
      "avenue": "string",
      "postalCode": 0,
      "buildingNo": 0,
      "doorNo": 0,
      "city": "string",
      "country": "string"
    },
    "invoices": [
      {
        "invoiceId": 0,
        "totalCost": 0.1,
        "date": "2019-08-24",
        "account": {}
      }
    ],
    "id": 0
  }
}
```

<h3 id="createinvoice-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[Invoice](#schemainvoice)|true|none|

> Example responses

> 200 Response

<h3 id="createinvoice-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[Invoice](#schemainvoice)|

<aside class="success">
This operation does not require authentication
</aside>

## test

<a id="opIdtest"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8082/api/invoice/test \
  -H 'Accept: */*'

```

```http
GET http://localhost:8082/api/invoice/test HTTP/1.1
Host: localhost:8082
Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'
};

fetch('http://localhost:8082/api/invoice/test',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.get 'http://localhost:8082/api/invoice/test',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.get('http://localhost:8082/api/invoice/test', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8082/api/invoice/test', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/invoice/test");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8082/api/invoice/test", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /api/invoice/test`

> Example responses

> 200 Response

<h3 id="test-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|string|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="customer-billing-system-api-customer-controller">customer-controller</h1>

## getCustomerById

<a id="opIdgetCustomerById"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8082/api/customers/{id} \
  -H 'Accept: */*'

```

```http
GET http://localhost:8082/api/customers/{id} HTTP/1.1
Host: localhost:8082
Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'
};

fetch('http://localhost:8082/api/customers/{id}',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.get 'http://localhost:8082/api/customers/{id}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.get('http://localhost:8082/api/customers/{id}', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8082/api/customers/{id}', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/customers/{id}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8082/api/customers/{id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /api/customers/{id}`

<h3 id="getcustomerbyid-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|id|path|integer(int32)|true|none|

> Example responses

> 200 Response

<h3 id="getcustomerbyid-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomerDTO](#schemacustomerdto)|

<aside class="success">
This operation does not require authentication
</aside>

## updateCustomer

<a id="opIdupdateCustomer"></a>

> Code samples

```shell
# You can also use wget
curl -X PUT http://localhost:8082/api/customers/{id} \
  -H 'Content-Type: application/json' \
  -H 'Accept: */*'

```

```http
PUT http://localhost:8082/api/customers/{id} HTTP/1.1
Host: localhost:8082
Content-Type: application/json
Accept: */*

```

```javascript
const inputBody = '{
  "firstName": "string",
  "lastName": "string",
  "nationalId": "string",
  "phoneNo": "string",
  "email": "string",
  "user": {
    "id": 0,
    "username": "string",
    "password": "string",
    "enabled": true,
    "accountNonExpired": true,
    "credentialsNonExpired": true,
    "authorities": [
      {
        "authority": "string"
      }
    ],
    "accountNonLocked": true
  },
  "id": 0
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'*/*'
};

fetch('http://localhost:8082/api/customers/{id}',
{
  method: 'PUT',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'application/json',
  'Accept' => '*/*'
}

result = RestClient.put 'http://localhost:8082/api/customers/{id}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': '*/*'
}

r = requests.put('http://localhost:8082/api/customers/{id}', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('PUT','http://localhost:8082/api/customers/{id}', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/customers/{id}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PUT");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"application/json"},
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("PUT", "http://localhost:8082/api/customers/{id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`PUT /api/customers/{id}`

> Body parameter

```json
{
  "firstName": "string",
  "lastName": "string",
  "nationalId": "string",
  "phoneNo": "string",
  "email": "string",
  "user": {
    "id": 0,
    "username": "string",
    "password": "string",
    "enabled": true,
    "accountNonExpired": true,
    "credentialsNonExpired": true,
    "authorities": [
      {
        "authority": "string"
      }
    ],
    "accountNonLocked": true
  },
  "id": 0
}
```

<h3 id="updatecustomer-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|id|path|integer(int32)|true|none|
|body|body|[Customer](#schemacustomer)|true|none|

> Example responses

> 200 Response

<h3 id="updatecustomer-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomerDTO](#schemacustomerdto)|

<aside class="success">
This operation does not require authentication
</aside>

## deleteCustomerById

<a id="opIddeleteCustomerById"></a>

> Code samples

```shell
# You can also use wget
curl -X DELETE http://localhost:8082/api/customers/{id}

```

```http
DELETE http://localhost:8082/api/customers/{id} HTTP/1.1
Host: localhost:8082

```

```javascript

fetch('http://localhost:8082/api/customers/{id}',
{
  method: 'DELETE'

})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

result = RestClient.delete 'http://localhost:8082/api/customers/{id}',
  params: {
  }

p JSON.parse(result)

```

```python
import requests

r = requests.delete('http://localhost:8082/api/customers/{id}')

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('DELETE','http://localhost:8082/api/customers/{id}', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/customers/{id}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("DELETE");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("DELETE", "http://localhost:8082/api/customers/{id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`DELETE /api/customers/{id}`

<h3 id="deletecustomerbyid-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|id|path|integer(int32)|true|none|

<h3 id="deletecustomerbyid-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|None|

<aside class="success">
This operation does not require authentication
</aside>

## getAllCustomers

<a id="opIdgetAllCustomers"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8082/api/customers \
  -H 'Accept: */*' \
  -H 'Authorization: string'

```

```http
GET http://localhost:8082/api/customers HTTP/1.1
Host: localhost:8082
Accept: */*
Authorization: string

```

```javascript

const headers = {
  'Accept':'*/*',
  'Authorization':'string'
};

fetch('http://localhost:8082/api/customers',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*',
  'Authorization' => 'string'
}

result = RestClient.get 'http://localhost:8082/api/customers',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*',
  'Authorization': 'string'
}

r = requests.get('http://localhost:8082/api/customers', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
    'Authorization' => 'string',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8082/api/customers', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/customers");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
        "Authorization": []string{"string"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8082/api/customers", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /api/customers`

<h3 id="getallcustomers-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|Authorization|header|string|true|none|

> Example responses

> 200 Response

<h3 id="getallcustomers-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="getallcustomers-responseschema">Response Schema</h3>

Status Code **200**

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|[[CustomerDTO](#schemacustomerdto)]|false|none|none|
|» id|integer(int32)|false|none|none|
|» firstName|string|false|none|none|
|» lastName|string|false|none|none|
|» nationalId|string|false|none|none|
|» phoneNo|string|false|none|none|
|» email|string|false|none|none|

<aside class="success">
This operation does not require authentication
</aside>

## createCustomer

<a id="opIdcreateCustomer"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8082/api/customers \
  -H 'Content-Type: application/json' \
  -H 'Accept: */*' \
  -H 'Authorization: string'

```

```http
POST http://localhost:8082/api/customers HTTP/1.1
Host: localhost:8082
Content-Type: application/json
Accept: */*
Authorization: string

```

```javascript
const inputBody = '{
  "firstName": "string",
  "lastName": "string",
  "nationalId": "string",
  "phoneNo": "string",
  "email": "string",
  "user": {
    "id": 0,
    "username": "string",
    "password": "string",
    "enabled": true,
    "accountNonExpired": true,
    "credentialsNonExpired": true,
    "authorities": [
      {
        "authority": "string"
      }
    ],
    "accountNonLocked": true
  },
  "id": 0
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'*/*',
  'Authorization':'string'
};

fetch('http://localhost:8082/api/customers',
{
  method: 'POST',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'application/json',
  'Accept' => '*/*',
  'Authorization' => 'string'
}

result = RestClient.post 'http://localhost:8082/api/customers',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': '*/*',
  'Authorization': 'string'
}

r = requests.post('http://localhost:8082/api/customers', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => '*/*',
    'Authorization' => 'string',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('POST','http://localhost:8082/api/customers', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/customers");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"application/json"},
        "Accept": []string{"*/*"},
        "Authorization": []string{"string"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("POST", "http://localhost:8082/api/customers", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`POST /api/customers`

> Body parameter

```json
{
  "firstName": "string",
  "lastName": "string",
  "nationalId": "string",
  "phoneNo": "string",
  "email": "string",
  "user": {
    "id": 0,
    "username": "string",
    "password": "string",
    "enabled": true,
    "accountNonExpired": true,
    "credentialsNonExpired": true,
    "authorities": [
      {
        "authority": "string"
      }
    ],
    "accountNonLocked": true
  },
  "id": 0
}
```

<h3 id="createcustomer-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|Authorization|header|string|true|none|
|body|body|[Customer](#schemacustomer)|true|none|

> Example responses

> 200 Response

<h3 id="createcustomer-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomerDTO](#schemacustomerdto)|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="customer-billing-system-api-billing-address-controller">billing-address-controller</h1>

## getAddressById

<a id="opIdgetAddressById"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8082/api/address/{id} \
  -H 'Accept: */*'

```

```http
GET http://localhost:8082/api/address/{id} HTTP/1.1
Host: localhost:8082
Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'
};

fetch('http://localhost:8082/api/address/{id}',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.get 'http://localhost:8082/api/address/{id}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.get('http://localhost:8082/api/address/{id}', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8082/api/address/{id}', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/address/{id}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8082/api/address/{id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /api/address/{id}`

<h3 id="getaddressbyid-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|id|path|integer(int32)|true|none|

> Example responses

> 200 Response

<h3 id="getaddressbyid-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[BillingAddress](#schemabillingaddress)|

<aside class="success">
This operation does not require authentication
</aside>

## updateAddress

<a id="opIdupdateAddress"></a>

> Code samples

```shell
# You can also use wget
curl -X PUT http://localhost:8082/api/address/{id} \
  -H 'Content-Type: application/json' \
  -H 'Accept: */*'

```

```http
PUT http://localhost:8082/api/address/{id} HTTP/1.1
Host: localhost:8082
Content-Type: application/json
Accept: */*

```

```javascript
const inputBody = '{
  "id": 0,
  "street": "string",
  "avenue": "string",
  "postalCode": 0,
  "buildingNo": 0,
  "doorNo": 0,
  "city": "string",
  "country": "string"
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'*/*'
};

fetch('http://localhost:8082/api/address/{id}',
{
  method: 'PUT',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'application/json',
  'Accept' => '*/*'
}

result = RestClient.put 'http://localhost:8082/api/address/{id}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': '*/*'
}

r = requests.put('http://localhost:8082/api/address/{id}', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('PUT','http://localhost:8082/api/address/{id}', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/address/{id}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PUT");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"application/json"},
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("PUT", "http://localhost:8082/api/address/{id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`PUT /api/address/{id}`

> Body parameter

```json
{
  "id": 0,
  "street": "string",
  "avenue": "string",
  "postalCode": 0,
  "buildingNo": 0,
  "doorNo": 0,
  "city": "string",
  "country": "string"
}
```

<h3 id="updateaddress-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|id|path|integer(int32)|true|none|
|body|body|[BillingAddress](#schemabillingaddress)|true|none|

> Example responses

> 200 Response

<h3 id="updateaddress-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[BillingAddress](#schemabillingaddress)|

<aside class="success">
This operation does not require authentication
</aside>

## deleteAddressById

<a id="opIddeleteAddressById"></a>

> Code samples

```shell
# You can also use wget
curl -X DELETE http://localhost:8082/api/address/{id}

```

```http
DELETE http://localhost:8082/api/address/{id} HTTP/1.1
Host: localhost:8082

```

```javascript

fetch('http://localhost:8082/api/address/{id}',
{
  method: 'DELETE'

})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

result = RestClient.delete 'http://localhost:8082/api/address/{id}',
  params: {
  }

p JSON.parse(result)

```

```python
import requests

r = requests.delete('http://localhost:8082/api/address/{id}')

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('DELETE','http://localhost:8082/api/address/{id}', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/address/{id}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("DELETE");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("DELETE", "http://localhost:8082/api/address/{id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`DELETE /api/address/{id}`

<h3 id="deleteaddressbyid-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|id|path|integer(int32)|true|none|

<h3 id="deleteaddressbyid-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|None|

<aside class="success">
This operation does not require authentication
</aside>

## getAllAddresses

<a id="opIdgetAllAddresses"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8082/api/address \
  -H 'Accept: */*'

```

```http
GET http://localhost:8082/api/address HTTP/1.1
Host: localhost:8082
Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'
};

fetch('http://localhost:8082/api/address',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.get 'http://localhost:8082/api/address',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.get('http://localhost:8082/api/address', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8082/api/address', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/address");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8082/api/address", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /api/address`

> Example responses

> 200 Response

<h3 id="getalladdresses-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="getalladdresses-responseschema">Response Schema</h3>

Status Code **200**

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|[[BillingAddress](#schemabillingaddress)]|false|none|none|
|» id|integer(int32)|false|none|none|
|» street|string|false|none|none|
|» avenue|string|false|none|none|
|» postalCode|integer(int32)|false|none|none|
|» buildingNo|integer(int32)|false|none|none|
|» doorNo|integer(int32)|false|none|none|
|» city|string|false|none|none|
|» country|string|false|none|none|

<aside class="success">
This operation does not require authentication
</aside>

## createAddress

<a id="opIdcreateAddress"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8082/api/address \
  -H 'Content-Type: application/json' \
  -H 'Accept: */*'

```

```http
POST http://localhost:8082/api/address HTTP/1.1
Host: localhost:8082
Content-Type: application/json
Accept: */*

```

```javascript
const inputBody = '{
  "id": 0,
  "street": "string",
  "avenue": "string",
  "postalCode": 0,
  "buildingNo": 0,
  "doorNo": 0,
  "city": "string",
  "country": "string"
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'*/*'
};

fetch('http://localhost:8082/api/address',
{
  method: 'POST',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'application/json',
  'Accept' => '*/*'
}

result = RestClient.post 'http://localhost:8082/api/address',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': '*/*'
}

r = requests.post('http://localhost:8082/api/address', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('POST','http://localhost:8082/api/address', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/address");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"application/json"},
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("POST", "http://localhost:8082/api/address", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`POST /api/address`

> Body parameter

```json
{
  "id": 0,
  "street": "string",
  "avenue": "string",
  "postalCode": 0,
  "buildingNo": 0,
  "doorNo": 0,
  "city": "string",
  "country": "string"
}
```

<h3 id="createaddress-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[BillingAddress](#schemabillingaddress)|true|none|

> Example responses

> 200 Response

<h3 id="createaddress-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[BillingAddress](#schemabillingaddress)|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="customer-billing-system-api-billing-account-controller">billing-account-controller</h1>

## getAccountById

<a id="opIdgetAccountById"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8082/api/accounts/{id} \
  -H 'Accept: */*'

```

```http
GET http://localhost:8082/api/accounts/{id} HTTP/1.1
Host: localhost:8082
Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'
};

fetch('http://localhost:8082/api/accounts/{id}',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.get 'http://localhost:8082/api/accounts/{id}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.get('http://localhost:8082/api/accounts/{id}', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8082/api/accounts/{id}', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/accounts/{id}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8082/api/accounts/{id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /api/accounts/{id}`

<h3 id="getaccountbyid-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|id|path|integer(int32)|true|none|

> Example responses

> 200 Response

<h3 id="getaccountbyid-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[BillingAccount](#schemabillingaccount)|

<aside class="success">
This operation does not require authentication
</aside>

## updateAccount

<a id="opIdupdateAccount"></a>

> Code samples

```shell
# You can also use wget
curl -X PUT http://localhost:8082/api/accounts/{id} \
  -H 'Content-Type: application/json' \
  -H 'Accept: */*'

```

```http
PUT http://localhost:8082/api/accounts/{id} HTTP/1.1
Host: localhost:8082
Content-Type: application/json
Accept: */*

```

```javascript
const inputBody = '{
  "id": 0,
  "customerId": 0,
  "addressId": 0
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'*/*'
};

fetch('http://localhost:8082/api/accounts/{id}',
{
  method: 'PUT',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'application/json',
  'Accept' => '*/*'
}

result = RestClient.put 'http://localhost:8082/api/accounts/{id}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': '*/*'
}

r = requests.put('http://localhost:8082/api/accounts/{id}', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('PUT','http://localhost:8082/api/accounts/{id}', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/accounts/{id}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PUT");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"application/json"},
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("PUT", "http://localhost:8082/api/accounts/{id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`PUT /api/accounts/{id}`

> Body parameter

```json
{
  "id": 0,
  "customerId": 0,
  "addressId": 0
}
```

<h3 id="updateaccount-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|id|path|integer(int32)|true|none|
|body|body|[AccountUpdateDTO](#schemaaccountupdatedto)|true|none|

> Example responses

> 200 Response

<h3 id="updateaccount-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[BillingAccount](#schemabillingaccount)|

<aside class="success">
This operation does not require authentication
</aside>

## deleteAccountById

<a id="opIddeleteAccountById"></a>

> Code samples

```shell
# You can also use wget
curl -X DELETE http://localhost:8082/api/accounts/{id}

```

```http
DELETE http://localhost:8082/api/accounts/{id} HTTP/1.1
Host: localhost:8082

```

```javascript

fetch('http://localhost:8082/api/accounts/{id}',
{
  method: 'DELETE'

})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

result = RestClient.delete 'http://localhost:8082/api/accounts/{id}',
  params: {
  }

p JSON.parse(result)

```

```python
import requests

r = requests.delete('http://localhost:8082/api/accounts/{id}')

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('DELETE','http://localhost:8082/api/accounts/{id}', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/accounts/{id}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("DELETE");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("DELETE", "http://localhost:8082/api/accounts/{id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`DELETE /api/accounts/{id}`

<h3 id="deleteaccountbyid-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|id|path|integer(int32)|true|none|

<h3 id="deleteaccountbyid-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|None|

<aside class="success">
This operation does not require authentication
</aside>

## getAllAccounts

<a id="opIdgetAllAccounts"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8082/api/accounts \
  -H 'Accept: */*'

```

```http
GET http://localhost:8082/api/accounts HTTP/1.1
Host: localhost:8082
Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'
};

fetch('http://localhost:8082/api/accounts',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.get 'http://localhost:8082/api/accounts',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.get('http://localhost:8082/api/accounts', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8082/api/accounts', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/accounts");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8082/api/accounts", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /api/accounts`

> Example responses

> 200 Response

<h3 id="getallaccounts-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="getallaccounts-responseschema">Response Schema</h3>

Status Code **200**

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|[[BillingAccount](#schemabillingaccount)]|false|none|none|
|» customer|[Customer](#schemacustomer)|false|none|none|
|»» firstName|string|false|none|none|
|»» lastName|string|false|none|none|
|»» nationalId|string|false|none|none|
|»» phoneNo|string|false|none|none|
|»» email|string|false|none|none|
|»» user|[User](#schemauser)|false|none|none|
|»»» id|integer(int32)|false|none|none|
|»»» username|string|false|none|none|
|»»» password|string|false|none|none|
|»»» enabled|boolean|false|none|none|
|»»» accountNonExpired|boolean|false|none|none|
|»»» credentialsNonExpired|boolean|false|none|none|
|»»» authorities|[[GrantedAuthority](#schemagrantedauthority)]|false|none|none|
|»»»» authority|string|false|none|none|
|»»» accountNonLocked|boolean|false|none|none|
|»» id|integer(int32)|false|none|none|
|» address|[BillingAddress](#schemabillingaddress)|false|none|none|
|»» id|integer(int32)|false|none|none|
|»» street|string|false|none|none|
|»» avenue|string|false|none|none|
|»» postalCode|integer(int32)|false|none|none|
|»» buildingNo|integer(int32)|false|none|none|
|»» doorNo|integer(int32)|false|none|none|
|»» city|string|false|none|none|
|»» country|string|false|none|none|
|» invoices|[[Invoice](#schemainvoice)]|false|none|none|
|»» invoiceId|integer(int32)|false|none|none|
|»» totalCost|number(double)|false|none|none|
|»» date|string(date)|false|none|none|
|»» account|[BillingAccount](#schemabillingaccount)|false|none|none|
|» id|integer(int32)|false|none|none|

<aside class="success">
This operation does not require authentication
</aside>

## createAccount

<a id="opIdcreateAccount"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8082/api/accounts \
  -H 'Content-Type: application/json' \
  -H 'Accept: */*'

```

```http
POST http://localhost:8082/api/accounts HTTP/1.1
Host: localhost:8082
Content-Type: application/json
Accept: */*

```

```javascript
const inputBody = '{
  "customerId": 0,
  "addressId": 0
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'*/*'
};

fetch('http://localhost:8082/api/accounts',
{
  method: 'POST',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'application/json',
  'Accept' => '*/*'
}

result = RestClient.post 'http://localhost:8082/api/accounts',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': '*/*'
}

r = requests.post('http://localhost:8082/api/accounts', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('POST','http://localhost:8082/api/accounts', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/accounts");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"application/json"},
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("POST", "http://localhost:8082/api/accounts", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`POST /api/accounts`

> Body parameter

```json
{
  "customerId": 0,
  "addressId": 0
}
```

<h3 id="createaccount-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[AccountRequestDTO](#schemaaccountrequestdto)|true|none|

> Example responses

> 200 Response

<h3 id="createaccount-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[BillingAccount](#schemabillingaccount)|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="customer-billing-system-api-authentication-controller">authentication-controller</h1>

## register

<a id="opIdregister"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8082/api/auth/register \
  -H 'Content-Type: application/json' \
  -H 'Accept: */*'

```

```http
POST http://localhost:8082/api/auth/register HTTP/1.1
Host: localhost:8082
Content-Type: application/json
Accept: */*

```

```javascript
const inputBody = '{
  "id": 0,
  "username": "string",
  "password": "string",
  "enabled": true,
  "accountNonExpired": true,
  "credentialsNonExpired": true,
  "authorities": [
    {
      "authority": "string"
    }
  ],
  "accountNonLocked": true
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'*/*'
};

fetch('http://localhost:8082/api/auth/register',
{
  method: 'POST',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'application/json',
  'Accept' => '*/*'
}

result = RestClient.post 'http://localhost:8082/api/auth/register',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': '*/*'
}

r = requests.post('http://localhost:8082/api/auth/register', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('POST','http://localhost:8082/api/auth/register', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/auth/register");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"application/json"},
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("POST", "http://localhost:8082/api/auth/register", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`POST /api/auth/register`

> Body parameter

```json
{
  "id": 0,
  "username": "string",
  "password": "string",
  "enabled": true,
  "accountNonExpired": true,
  "credentialsNonExpired": true,
  "authorities": [
    {
      "authority": "string"
    }
  ],
  "accountNonLocked": true
}
```

<h3 id="register-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[User](#schemauser)|true|none|

> Example responses

> 200 Response

<h3 id="register-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="register-responseschema">Response Schema</h3>

<aside class="success">
This operation does not require authentication
</aside>

## login

<a id="opIdlogin"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8082/api/auth/login \
  -H 'Content-Type: application/json' \
  -H 'Accept: */*'

```

```http
POST http://localhost:8082/api/auth/login HTTP/1.1
Host: localhost:8082
Content-Type: application/json
Accept: */*

```

```javascript
const inputBody = '{
  "username": "string",
  "password": "string"
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'*/*'
};

fetch('http://localhost:8082/api/auth/login',
{
  method: 'POST',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'application/json',
  'Accept' => '*/*'
}

result = RestClient.post 'http://localhost:8082/api/auth/login',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': '*/*'
}

r = requests.post('http://localhost:8082/api/auth/login', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('POST','http://localhost:8082/api/auth/login', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/auth/login");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"application/json"},
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("POST", "http://localhost:8082/api/auth/login", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`POST /api/auth/login`

> Body parameter

```json
{
  "username": "string",
  "password": "string"
}
```

<h3 id="login-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[AuthRequest](#schemaauthrequest)|true|none|

> Example responses

> 200 Response

<h3 id="login-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="login-responseschema">Response Schema</h3>

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="customer-billing-system-api-user-controller">user-controller</h1>

## getUser

<a id="opIdgetUser"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8082/api/users/{username} \
  -H 'Accept: */*'

```

```http
GET http://localhost:8082/api/users/{username} HTTP/1.1
Host: localhost:8082
Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'
};

fetch('http://localhost:8082/api/users/{username}',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.get 'http://localhost:8082/api/users/{username}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.get('http://localhost:8082/api/users/{username}', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8082/api/users/{username}', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8082/api/users/{username}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8082/api/users/{username}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /api/users/{username}`

<h3 id="getuser-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|username|path|string|true|none|

> Example responses

> 200 Response

<h3 id="getuser-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="getuser-responseschema">Response Schema</h3>

<aside class="success">
This operation does not require authentication
</aside>

# Schemas

<h2 id="tocS_BillingAccount">BillingAccount</h2>
<!-- backwards compatibility -->
<a id="schemabillingaccount"></a>
<a id="schema_BillingAccount"></a>
<a id="tocSbillingaccount"></a>
<a id="tocsbillingaccount"></a>

```json
{
  "customer": {
    "firstName": "string",
    "lastName": "string",
    "nationalId": "string",
    "phoneNo": "string",
    "email": "string",
    "user": {
      "id": 0,
      "username": "string",
      "password": "string",
      "enabled": true,
      "accountNonExpired": true,
      "credentialsNonExpired": true,
      "authorities": [
        {
          "authority": "string"
        }
      ],
      "accountNonLocked": true
    },
    "id": 0
  },
  "address": {
    "id": 0,
    "street": "string",
    "avenue": "string",
    "postalCode": 0,
    "buildingNo": 0,
    "doorNo": 0,
    "city": "string",
    "country": "string"
  },
  "invoices": [
    {
      "invoiceId": 0,
      "totalCost": 0.1,
      "date": "2019-08-24",
      "account": {
        "customer": {
          "firstName": "string",
          "lastName": "string",
          "nationalId": "string",
          "phoneNo": "string",
          "email": "string",
          "user": {
            "id": 0,
            "username": "string",
            "password": "string",
            "enabled": true,
            "accountNonExpired": true,
            "credentialsNonExpired": true,
            "authorities": [
              {
                "authority": "string"
              }
            ],
            "accountNonLocked": true
          },
          "id": 0
        },
        "address": {
          "id": 0,
          "street": "string",
          "avenue": "string",
          "postalCode": 0,
          "buildingNo": 0,
          "doorNo": 0,
          "city": "string",
          "country": "string"
        },
        "invoices": [],
        "id": 0
      }
    }
  ],
  "id": 0
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|customer|[Customer](#schemacustomer)|false|none|none|
|address|[BillingAddress](#schemabillingaddress)|false|none|none|
|invoices|[[Invoice](#schemainvoice)]|false|none|none|
|id|integer(int32)|false|none|none|

<h2 id="tocS_BillingAddress">BillingAddress</h2>
<!-- backwards compatibility -->
<a id="schemabillingaddress"></a>
<a id="schema_BillingAddress"></a>
<a id="tocSbillingaddress"></a>
<a id="tocsbillingaddress"></a>

```json
{
  "id": 0,
  "street": "string",
  "avenue": "string",
  "postalCode": 0,
  "buildingNo": 0,
  "doorNo": 0,
  "city": "string",
  "country": "string"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|integer(int32)|false|none|none|
|street|string|false|none|none|
|avenue|string|false|none|none|
|postalCode|integer(int32)|false|none|none|
|buildingNo|integer(int32)|false|none|none|
|doorNo|integer(int32)|false|none|none|
|city|string|false|none|none|
|country|string|false|none|none|

<h2 id="tocS_Customer">Customer</h2>
<!-- backwards compatibility -->
<a id="schemacustomer"></a>
<a id="schema_Customer"></a>
<a id="tocScustomer"></a>
<a id="tocscustomer"></a>

```json
{
  "firstName": "string",
  "lastName": "string",
  "nationalId": "string",
  "phoneNo": "string",
  "email": "string",
  "user": {
    "id": 0,
    "username": "string",
    "password": "string",
    "enabled": true,
    "accountNonExpired": true,
    "credentialsNonExpired": true,
    "authorities": [
      {
        "authority": "string"
      }
    ],
    "accountNonLocked": true
  },
  "id": 0
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|firstName|string|false|none|none|
|lastName|string|false|none|none|
|nationalId|string|false|none|none|
|phoneNo|string|false|none|none|
|email|string|false|none|none|
|user|[User](#schemauser)|false|none|none|
|id|integer(int32)|false|none|none|

<h2 id="tocS_GrantedAuthority">GrantedAuthority</h2>
<!-- backwards compatibility -->
<a id="schemagrantedauthority"></a>
<a id="schema_GrantedAuthority"></a>
<a id="tocSgrantedauthority"></a>
<a id="tocsgrantedauthority"></a>

```json
{
  "authority": "string"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|authority|string|false|none|none|

<h2 id="tocS_Invoice">Invoice</h2>
<!-- backwards compatibility -->
<a id="schemainvoice"></a>
<a id="schema_Invoice"></a>
<a id="tocSinvoice"></a>
<a id="tocsinvoice"></a>

```json
{
  "invoiceId": 0,
  "totalCost": 0.1,
  "date": "2019-08-24",
  "account": {
    "customer": {
      "firstName": "string",
      "lastName": "string",
      "nationalId": "string",
      "phoneNo": "string",
      "email": "string",
      "user": {
        "id": 0,
        "username": "string",
        "password": "string",
        "enabled": true,
        "accountNonExpired": true,
        "credentialsNonExpired": true,
        "authorities": [
          {
            "authority": "string"
          }
        ],
        "accountNonLocked": true
      },
      "id": 0
    },
    "address": {
      "id": 0,
      "street": "string",
      "avenue": "string",
      "postalCode": 0,
      "buildingNo": 0,
      "doorNo": 0,
      "city": "string",
      "country": "string"
    },
    "invoices": [
      {
        "invoiceId": 0,
        "totalCost": 0.1,
        "date": "2019-08-24",
        "account": {}
      }
    ],
    "id": 0
  }
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|invoiceId|integer(int32)|false|none|none|
|totalCost|number(double)|false|none|none|
|date|string(date)|false|none|none|
|account|[BillingAccount](#schemabillingaccount)|false|none|none|

<h2 id="tocS_User">User</h2>
<!-- backwards compatibility -->
<a id="schemauser"></a>
<a id="schema_User"></a>
<a id="tocSuser"></a>
<a id="tocsuser"></a>

```json
{
  "id": 0,
  "username": "string",
  "password": "string",
  "enabled": true,
  "accountNonExpired": true,
  "credentialsNonExpired": true,
  "authorities": [
    {
      "authority": "string"
    }
  ],
  "accountNonLocked": true
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|integer(int32)|false|none|none|
|username|string|false|none|none|
|password|string|false|none|none|
|enabled|boolean|false|none|none|
|accountNonExpired|boolean|false|none|none|
|credentialsNonExpired|boolean|false|none|none|
|authorities|[[GrantedAuthority](#schemagrantedauthority)]|false|none|none|
|accountNonLocked|boolean|false|none|none|

<h2 id="tocS_CustomerDTO">CustomerDTO</h2>
<!-- backwards compatibility -->
<a id="schemacustomerdto"></a>
<a id="schema_CustomerDTO"></a>
<a id="tocScustomerdto"></a>
<a id="tocscustomerdto"></a>

```json
{
  "id": 0,
  "firstName": "string",
  "lastName": "string",
  "nationalId": "string",
  "phoneNo": "string",
  "email": "string"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|integer(int32)|false|none|none|
|firstName|string|false|none|none|
|lastName|string|false|none|none|
|nationalId|string|false|none|none|
|phoneNo|string|false|none|none|
|email|string|false|none|none|

<h2 id="tocS_AccountUpdateDTO">AccountUpdateDTO</h2>
<!-- backwards compatibility -->
<a id="schemaaccountupdatedto"></a>
<a id="schema_AccountUpdateDTO"></a>
<a id="tocSaccountupdatedto"></a>
<a id="tocsaccountupdatedto"></a>

```json
{
  "id": 0,
  "customerId": 0,
  "addressId": 0
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|integer(int32)|false|none|none|
|customerId|integer(int32)|false|none|none|
|addressId|integer(int32)|false|none|none|

<h2 id="tocS_AuthRequest">AuthRequest</h2>
<!-- backwards compatibility -->
<a id="schemaauthrequest"></a>
<a id="schema_AuthRequest"></a>
<a id="tocSauthrequest"></a>
<a id="tocsauthrequest"></a>

```json
{
  "username": "string",
  "password": "string"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|username|string|false|none|none|
|password|string|false|none|none|

<h2 id="tocS_AccountRequestDTO">AccountRequestDTO</h2>
<!-- backwards compatibility -->
<a id="schemaaccountrequestdto"></a>
<a id="schema_AccountRequestDTO"></a>
<a id="tocSaccountrequestdto"></a>
<a id="tocsaccountrequestdto"></a>

```json
{
  "customerId": 0,
  "addressId": 0
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|customerId|integer(int32)|false|none|none|
|addressId|integer(int32)|false|none|none|

