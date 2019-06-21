# Restaurant Backend

#### **Docs in progress**

### Get Menu
**GET** `/restaurant/v1/menu`

|   Parameter  |             Description             | Required |
|:------------:|:-----------------------------------:|:--------:|
| `restaurantId` | ID of the Restaurant for it's menu  |   `true`   |

**Example**
 ```java
 curl --location --request GET "http://localhost:8081/restaurant/v1/menu?restaurantId=301728"
 ```

### Add Menu Item
**POST** `/restaurant/v1/item`
- **Content-Type** : application/json
- **Body**
  ```json
  {
   "restaurantId": "<restaurant.id>",
   "item": {
    "itemId": "<item.id>",
    "name": "<item.name>",
    "imageUrl": "<item.imageUrl>",
    "quantity": "<item.quantity>",
    "price": "<item.price>",
    "attributes": "<item.attributes : string>"
   }
  }
  ```
- **Example**
  ```java
   curl --location --request POST "http://localhost:8081/restaurant/v1/item" \
     --header "Content-Type: application/json" \
     --data "{
    \"restaurantId\": \"301728\",
    \"item\": {
     \"itemId\":\"HFU3434\",
     \"name\": \"Name\",
     \"imageUrl\": \"\",
     \"quantity\": 1,
     \"price\": 10,
     \"attributes\": []
    }
   }"
  ```
**PUT** `/restaurant/v1/item`

**DELETE** `/restaurant/v1/item`

**GET** `/restaurant/v1/order/history`

**GET** `/restaurant/v1/order/active`

**PUT**`/restaurant/v1/order`

