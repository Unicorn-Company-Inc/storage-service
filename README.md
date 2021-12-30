## Running the app from sources
```
mvn spring-boot:run
```

## API
Default port: 3002
```
# Get product stock details
GET /storage/stock/{id}

# Get product stock list
GET /storage/stock

# Trigger CSV import (from ./file/import.csv)
GET /storage/import
```