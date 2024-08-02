<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Retailer - XXX Website</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="styles.css" rel="stylesheet">
</head>
<body>
    <div class="header">
        <span>xxx website</span>
        <div>
            <a href="login.html" class="text-white">Log out</a>
        </div>
    </div>
    <div class="main">
        <div class="container">
            <h2 class="text-center">Welcome Retailer</h2>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>itemID</th>
                        <th>itemName</th>
                        <th>quantity</th>
                        <th>Expiration date</th>
                        <th>Price type</th>
                        <th>price</th>
                        <th>Is Surplus</th>
                        <th>option</th>
                    </tr>
                </thead>
                <tbody id="retailer-items">
                    <!-- Items will be populated here from the backend -->
                </tbody>
            </table>
            <button class="btn btn-custom" onclick="window.location.href='add-item.html'">Add item</button>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        // JavaScript to fetch and display items from backend
        // Example:
        /*
        fetch('/api/retailer/items')
            .then(response => response.json())
            .then(data => {
                let items = '';
                data.forEach(item => {
                    items += `<tr>
                        <td>${item.itemID}</td>
                        <td>${item.itemName}</td>
                        <td>${item.quantity}</td>
                        <td>${item.expirationDate}</td>
                        <td>${item.priceType}</td>
                        <td>${item.price}</td>
                        <td>${item.isSurplus}</td>
                        <td>
                            <button onclick="editItem(${item.itemID})">Edit</button>
                            <button onclick="deleteItem(${item.itemID})">Delete</button>
                            <button onclick="markSurplus(${item.itemID})">Surplus</button>
                        </td>
                    </tr>`;
                });
                document.getElementById('retailer-items').innerHTML = items;
            });
        */
    </script>
</body>
</html>

