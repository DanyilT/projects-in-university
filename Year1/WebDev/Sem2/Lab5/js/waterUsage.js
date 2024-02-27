function calculateWaterUsage() {
    var litres = document.getElementById('litres').value;
    var days = document.getElementById('days').value;
    var average = litres / days;
    document.getElementById('result').textContent = 'You used an average of ' + average.toFixed(2) + ' litres per day';
}
