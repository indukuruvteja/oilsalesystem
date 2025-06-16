document.addEventListener("DOMContentLoaded", () => {
    const productSelect = document.getElementById("productSelect");
    const quantityInput = document.getElementById("quantityInput");
    const totalPriceSpan = document.getElementById("totalPrice");

    function calculatePrice() {
        const selected = productSelect.options[productSelect.selectedIndex];
        const pricePerLitre = parseFloat(selected.getAttribute("data-price")) || 0;
        const quantity = parseFloat(quantityInput.value) || 0;
        const total = (pricePerLitre * quantity).toFixed(2);
        totalPriceSpan.textContent = total;
    }

    productSelect.addEventListener("change", calculatePrice);
    quantityInput.addEventListener("input", calculatePrice);
});
