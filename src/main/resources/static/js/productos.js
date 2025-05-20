let priceChart, stockChart;

// Cargar productos al iniciar la página
document.addEventListener('DOMContentLoaded', () => {
    loadProducts();
    initializeCharts();
});

// Función para cargar productos
function loadProducts() {
    fetch('/productos')
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al obtener los productos');
            }
            return response.json();
        })
        .then(data => {
            updateTable(data);
            updateCharts(data);
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

// Actualizar la tabla de productos
function updateTable(products) {
    const tableBody = document.getElementById('productsTableBody');
    tableBody.innerHTML = ''; // Limpiar la tabla antes de agregar nuevos datos

    products.forEach(product => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.stock}</td>
        `;
        tableBody.appendChild(row);
    });
}

// Inicializar las gráficas
function initializeCharts() {
    const priceCtx = document.getElementById('priceChart').getContext('2d');
    const stockCtx = document.getElementById('stockChart').getContext('2d');

    priceChart = new Chart(priceCtx, {
        type: 'bar',
        data: {
            labels: [],
            datasets: [{
                label: 'Precios',
                data: [],
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            plugins: {
                legend: {
                    position: 'top',
                },
                title: {
                    display: true,
                    text: 'Precios de Productos'
                }
            }
        }
    });

    stockChart = new Chart(stockCtx, {
        type: 'pie',
        data: {
            labels: [],
            datasets: [{
                label: 'Stock',
                data: [],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)'
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            plugins: {
                legend: {
                    position: 'top',
                },
                title: {
                    display: true,
                    text: 'Stock de Productos'
                }
            }
        }
    });
}

// Actualizar las gráficas
function updateCharts(products) {
    const labels = products.map(product => product.name);
    const prices = products.map(product => product.price);
    const stocks = products.map(product => product.stock);

    // Actualizar datos de la gráfica de precios
    priceChart.data.labels = labels;
    priceChart.data.datasets[0].data = prices;
    priceChart.update();

    // Actualizar datos de la gráfica de stock
    stockChart.data.labels = labels;
    stockChart.data.datasets[0].data = stocks;
    stockChart.update();
}

// Función para agregar un producto
document.getElementById('addProductForm').addEventListener('submit', function (event) {
    event.preventDefault();

    const product = {
        id: document.getElementById('productId').value,
        name: document.getElementById('productName').value,
        price: document.getElementById('productPrice').value,
        stock: document.getElementById('productStock').value
    };

    fetch('/productos', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(product)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error al agregar el producto');
        }
        return response.json();
    })
    .then(() => {
        alert('Producto agregado exitosamente');
        document.getElementById('addProductForm').reset();
        loadProducts(); // Actualizar la tabla y las gráficas
    })
    .catch(error => {
        console.error('Error:', error);
    });
});

// Función para editar completamente un producto (PUT)
document.getElementById('editProductForm').addEventListener('submit', function (event) {
    event.preventDefault();

    const id = document.getElementById('editProductId').value;
    const name = document.getElementById('editProductName').value.trim();
    const price = document.getElementById('editProductPrice').value.trim();
    const stock = document.getElementById('editProductStock').value.trim();

    if (!id) {
        alert('El campo ID es obligatorio.');
        return;
    }

    // Crear el objeto con los campos no vacíos
    const product = { id };
    if (name) product.name = name;
    if (price) product.price = parseFloat(price);
    if (stock) product.stock = parseInt(stock, 10);

    console.log('Datos enviados en PUT:', JSON.stringify(product));

    fetch('/productos', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(product)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error al editar el producto');
        }
        return response.json();
    })
    .then(() => {
        alert('Producto editado exitosamente');
        document.getElementById('editProductForm').reset();
        loadProducts(); // Actualizar la tabla y las gráficas
    })
    .catch(error => {
        console.error('Error:', error);
    });
});

// Función para editar parcialmente un producto (PATCH)
document.getElementById('patchProductForm').addEventListener('submit', function (event) {
    event.preventDefault();

    const id = document.getElementById('patchProductId').value;
    const name = document.getElementById('patchProductName').value.trim();
    const price = document.getElementById('patchProductPrice').value.trim();
    const stock = document.getElementById('patchProductStock').value.trim();

    if (!id) {
        alert('El campo ID es obligatorio.');
        return;
    }

    if (!name && !price && !stock) {
        alert('Debe ingresar al menos un campo para actualizar.');
        return;
    }

    // Crear el objeto con los campos no vacíos
    const product = { id };
    if (name) product.name = name;
    if (price) product.price = parseFloat(price);
    if (stock) product.stock = parseInt(stock, 10);

    console.log('Datos enviados en PATCH:', JSON.stringify(product));

    fetch('/productos', {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(product)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error al editar parcialmente el producto');
        }
        return response.json();
    })
    .then(() => {
        alert('Producto editado parcialmente exitosamente');
        document.getElementById('patchProductForm').reset();
        loadProducts(); // Actualizar la tabla y las gráficas
    })
    .catch(error => {
        console.error('Error:', error);
    });
});

// Función para eliminar un producto (DELETE)
document.getElementById('deleteProductForm').addEventListener('submit', function (event) {
    event.preventDefault();

    const productId = document.getElementById('deleteProductId').value;

    fetch(`/productos/${productId}`, {
        method: 'DELETE'
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error al eliminar el producto');
        }
        return response.json();
    })
    .then(() => {
        alert('Producto eliminado exitosamente');
        document.getElementById('deleteProductForm').reset();
        loadProducts(); // Actualizar la tabla y las gráficas
    })
    .catch(error => {
        console.error('Error:', error);
    });
});