# Emerald

Backend side of demonstration ad campaign management app built with Java Spring Boot.

## Features

**CRUD operations** - creating, editing, viewing and deleting advertisement campaigns.

## Tech Stack

- **Language**: Java
- **Framework**: Spring Boot
- **Database**: H2

## API methods

- `GET /api/campaigns` - Fetch all campaigns

_Response example:_

```
[
    {
        "id": 1,
        "campaignName": "Example Campaign 1",
        "keywords": [
            "used",
            "sell",
            "delivery"
        ],
        "bidAmount": 1.5,
        "campaignFund": 100.0,
        "status": true,
        "town": "Kraków",
        "radius": 10.0
    },
    {
        "id": 2,
        "campaignName": "Example Campaign 2",
        "keywords": [
            "local",
            "available"
        ],
        "bidAmount": 2.0,
        "campaignFund": 200.0,
        "status": false,
        "town": "Wrocław",
        "radius": 20.0
    }
]
```

- `GET /api/campaigns/:id` - Fetch campaign by ID

_Response example:_

```
{
        "id": 2,
        "campaignName": "Example Campaign 2",
        "keywords": [
            "local",
            "available"
        ],
        "bidAmount": 2.0,
        "campaignFund": 200.0,
        "status": false,
        "town": "Wrocław",
        "radius": 20.0
    }
```

- `POST /api/campaigns` - Create new campaign

_Response example:_

```
{
    "id": 3,
    "campaignName": "campaign 8",
    "keywords": [
        "used"
    ],
    "bidAmount": 1.5,
    "campaignFund": 150.0,
    "status": true,
    "town": "Warsaw",
    "radius": 10.0
}
```

- `PUT /api/campaigns/:id` - Update campaign

_Response example:_

```
{
    "id": 3,
    "campaignName": "campaign 9",
    "keywords": [
        "new"
    ],
    "bidAmount": 1.5,
    "campaignFund": 150.0,
    "status": true,
    "town": "Katowice",
    "radius": 10.0
}
```

- `DELETE /api/campaigns/:id` - Delete campaign

_Response_ - void

- `GET /api/balance` - Get demo account balance

_Response example:_

```
850.0
```

- `PUT /api/balance?value=<amount>` - Update demo account balance

_Response_ - void
