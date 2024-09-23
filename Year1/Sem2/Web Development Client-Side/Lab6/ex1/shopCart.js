document.addEventListener('DOMContentLoaded', () => {
    const cart = document.getElementById('cart');
    const qtyInputs = cart.querySelectorAll('.qty');
    const grandTotal = document.getElementById('grandTotal');

    qtyInputs.forEach(input => {
        input.addEventListener('change', (e) => {
            const itemRow = e.target.closest('.item');
            const price = parseFloat(itemRow.dataset.price);
            const qty = parseInt(e.target.value, 10);
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

    cart.addEventListener('reset', () => {
        cart.querySelectorAll('.total').forEach(total => {
            total.textContent = '€ 0';
        });
        grandTotal.textContent = '€ 0';
    });
});
