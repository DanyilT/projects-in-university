document.addEventListener('DOMContentLoaded', () => {
    const cart = document.getElementById('cart');
    const qtyInputs = cart.querySelectorAll('.qty');
    const grandTotal = document.getElementById('grandTotal');

    qtyInputs.forEach(input => {
        input.addEventListener('change', (e) => {
            const itemRow = e.target.closest('.item');
            const price = parseFloat(itemRow.dataset.price);
            let qty = parseInt(e.target.value, 10);
            if (isNaN(qty) || qty < 0) qty = 0;
            if (qty > 100) qty = 100;
            e.target.value = qty;
            const total = itemRow.querySelector('.total');
            total.textContent = `€ ${(price * qty).toFixed(2)}`;
            updateGrandTotal();
        });
    });

    function updateGrandTotal() {
        let total = 0;
        cart.querySelectorAll('.item').forEach(item => {
            const itemTotal = parseFloat(item.querySelector('.total').textContent.replace('€', ''));
            total += itemTotal;
        });
        grandTotal.textContent = `€ ${total.toFixed(2)}`;
    }

    cart.addEventListener('submit', (e) => {
        e.preventDefault();
        alert(`The amount due is ${grandTotal.textContent}`);
    });

    cart.addEventListener('reset', () => {
        cart.querySelectorAll('.total').forEach(total => {
            total.textContent = '€ 0';
        });
        grandTotal.textContent = '€ 0';
    });
});
