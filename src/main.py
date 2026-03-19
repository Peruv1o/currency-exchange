import sys
from forex_python.converter import CurrencyRates

sys.stdout.reconfigure(encoding='utf-8')
c = CurrencyRates()

currency_names = {
    'AUD': 'Australian Dollar',
    'BRL': 'Brazilian Real',
    'CAD': 'Canadian Dollar',
    'CHF': 'Swiss Franc',
    'CNY': 'Chinese Yuan',
    'CZK': 'Czech Koruna',
    'DKK': 'Danish Krone',
    'EUR': 'Euro',
    'GBP': 'British Pound',
    'HKD': 'Hong Kong Dollar',
    'HUF': 'Hungarian Forint',
    'IDR': 'Indonesian Rupiah',
    'ILS': 'Israeli Shekel',
    'INR': 'Indian Rupee',
    'ISK': 'Icelandic Króna',
    'JPY': 'Japanese Yen',
    'KRW': 'South Korean Won',
    'MXN': 'Mexican Peso',
    'MYR': 'Malaysian Ringgit',
    'NOK': 'Norwegian Krone',
    'NZD': 'New Zealand Dollar',
    'PHP': 'Philippine Peso',
    'PLN': 'Polish Złoty',
    'RON': 'Romanian Leu',
    'SEK': 'Swedish Krona',
    'SGD': 'Singapore Dollar',
    'THB': 'Thai Baht',
    'TRY': 'Turkish Lira',
    'USD': 'US Dollar',
    'ZAR': 'South African Rand',
}

# If "--list" is passed, just print currencies
if len(sys.argv) > 1 and sys.argv[1] == "--list":
    for code, name in currency_names.items():
        print(f"{code} - {name}")
    sys.exit()

# Make sure there are enough arguments for conversion
if len(sys.argv) < 5:
    print("Usage: main.py <dummy> <baseCurrency> <targetCurrency> <amount>")
    sys.exit(1)

# Normal conversion
baseCurrency = sys.argv[2]
targetCurrency = sys.argv[3]
amount = float(sys.argv[4])
result = c.convert(baseCurrency, targetCurrency, amount)
print(f"{amount} {baseCurrency} = {result:.2f} {targetCurrency}")