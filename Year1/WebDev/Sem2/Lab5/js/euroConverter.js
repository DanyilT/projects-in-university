// Assuming conversion rates as follows, however, in a real-world scenario you would retrieve these from an API
const conversionRates = {
    "USD": 1.09,
    "GBP": 0.84,
    "AUD": 1.48,
    "JPY": 129.53
};

function convertCurrency() {
    var euroAmount = document.getElementById("euroAmount").value;
    var currency = document.getElementById("currencySelect").value;
    var result = euroAmount * conversionRates[currency];
    document.getElementById("convertedAmount").textContent = result.toFixed(2);
}
