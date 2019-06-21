# QEats-Restaurant

#### **Docs in progress**

:globe_with_meridians: **GET** `/restaurant/v1/menu`

|   Parameter  |             Description             | Required |
|:------------:|:-----------------------------------:|:--------:|
| `restaurantId` | ID of the Restaurant for it's menu  |   `true`   |

**Example**
 ```java
 curl --location --request GET "http://localhost:8081/restaurant/v1/menu?restaurantId=301728"
 ```
---
 
**POST** `/restaurant/v1/item`

**PUT** `/restaurant/v1/item`

**DELETE** `/restaurant/v1/item`

**GET** `/restaurant/v1/order/history`

**GET** `/restaurant/v1/order/active`

**PUT**`/restaurant/v1/order`

