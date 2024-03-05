let cart = [];

document.addEventListener('DOMContentLoaded', function() {
    // Opening the cart popup
    var btn = document.getElementById("cart-popup-button");
    var modal = document.getElementById("cart-popup");
    var span = document.getElementsByClassName("close-cart")[0];

    btn.onclick = function() {
        modal.style.display = "block";
        updateCartDisplay(); // Make sure to call this function to update cart items
    }

    span.onclick = function() {
        modal.style.display = "none";
    }

    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

    // Load cart from localStorage if it exists
    if (localStorage.getItem('cart')) {
        cart = JSON.parse(localStorage.getItem('cart'));
        updateCartDisplay(); // Update the cart display with loaded items
    }

    // Add to cart functionality
    document.querySelectorAll('.add-to-cart-btn').forEach(button => {
        button.addEventListener('click', function() {
            const productId = this.getAttribute('data-product-id');
            const productName = this.getAttribute('data-product-name');
            const productPrice = parseFloat(this.getAttribute('data-product-price'));
            const productImgSrc = this.getAttribute('data-product-img-src');
    
            // Hide the 'Add to Cart' button and show the 'View Cart' button
            this.style.display = 'none';
            this.nextElementSibling.style.display = 'inline-block';
    
            // Add the product to the cart (simplified logic)
            const cartItem = {
                id: productId,
                name: productName,
                price: productPrice,
                quantity: 1,
                imgSrc: productImgSrc
            };
            addToCart(cartItem); // Assuming you have a function to add items to your cart array/object
    
            // Update the display of the cart popup
            updateCartDisplay();
        });
    });
    document.getElementById('clear-cart-btn').addEventListener('click', function() {
        cart = []; // Empty the cart array
        localStorage.setItem('cart', JSON.stringify(cart)); // Update localStorage
        updateCartDisplay(); // Refresh the cart display
    });
    
});
function addToCart(item) {
    // Check if cart already has the item and update quantity if it does
    let itemIndex = cart.findIndex(cartItem => cartItem.id === item.id);
    if (itemIndex !== -1) {
        cart[itemIndex].quantity += 1;
    } else {
        cart.push(item);
    }

    // Save updated cart to localStorage
    localStorage.setItem('cart', JSON.stringify(cart));
    updateCartDisplay();
}

function updateCartDisplay() {
    const cartTableBody = document.querySelector('.cart-items tbody');
    cartTableBody.innerHTML = ''; // Clear existing cart items

    let total = 0;
    cart.forEach((item, index) => {
        const row = cartTableBody.insertRow();
        
        const cellImage = row.insertCell(0);
        cellImage.innerHTML = `<img src="${item.imgSrc}" alt="${item.name}" style="width:50px;"> ${item.name}`;

        const cellPrice = row.insertCell(1);
        cellPrice.textContent = `€${item.price}`;

        const cellQuantity = row.insertCell(2);
        cellQuantity.innerHTML = `<input type="number" value="${item.quantity}" min="0" class="cart-quantity" data-product-id="${item.id}">`;

        const cellTotal = row.insertCell(3);
        cellTotal.textContent = `€${(item.price * item.quantity).toFixed(2)}`;

        // Attach an event listener to the quantity input
        const quantityInput = cellQuantity.querySelector('input');
        quantityInput.addEventListener('change', (e) => {
            const newQty = parseInt(e.target.value);
            if (newQty > 0) {
                item.quantity = newQty;
            } else {
                // Remove item if quantity is less than or equal to 0
                cart.splice(index, 1);
            }
            // Save updated cart to localStorage and update display
            localStorage.setItem('cart', JSON.stringify(cart));
            updateCartDisplay();
        });

        total += (item.price * item.quantity);
    });

    // Calculate shipping
    let shipping = 10; // Default shipping cost
    if (total > 50) {
        shipping = 0; // Free shipping for orders over €50
    }
    // Update the overall total including shipping
    total += shipping;



    // Update the overall total
    const totalPrice = cart.reduce((acc, item) => acc + item.price * item.quantity, 0);
    // Calculate shipping
    const shippingCost = totalPrice > 50 ? 0 : 10;
    const grandTotal = totalPrice + shippingCost;
    // Display shipping cost with a tooltip
    const shippingDisplay = document.querySelector('.shipping-cost');
    shippingDisplay.innerHTML = `Shipping: €${shippingCost} <span class="tooltip-text">Free shipping above €50</span>`;

    // Update total price display to include shipping
    document.querySelector('.total-price').textContent = `Total: €${grandTotal.toFixed(2)}`;

    // Show shipping info tooltip on hover
    shippingDisplay.title = "Free shipping for orders over €50";
}

function viewCart() {
    // Logic to display the cart popup
    document.getElementById('cart-popup').style.display = 'block';
}
