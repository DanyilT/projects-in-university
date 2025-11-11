function convertToUSD() {
    var euroAmount = document.getElementById('euroAmount').value;
    var usdAmount = euroAmount * 1.09;
    document.getElementById('usdAmount').value = usdAmount.toFixed(2);
}
