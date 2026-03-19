# Currency Exchange Application

## Description
A simple Java Swing application that allows users to:  
- Input a base currency, a target currency, and an amount.  
- Convert the input amount from the base currency to the target currency.  
- Display the conversion result dynamically in the interface.  
- View a full list of supported currencies in a separate, non-blocking dialog.  

The GUI uses a **left panel** for input and a **right panel** for results and the logo.

## Features
- **Currency Conversion:** Enter base and target currencies and an amount to get the conversion.  
- **Dynamic Result Label:** Conversion results are displayed in a centered label that updates automatically.  
- **Non-Modal Currency List:** The "Show all Currencies" button opens a dialog listing all currencies; only one dialog can be open at a time.  
- **Custom GUI Layout:** Uses `null` layouts for precise component positioning.  
- **Image Display:** Logo displayed on the right panel, scaled smoothly.  

## Components
- **Main JFrame:** The main window containing all panels and components.  
- **Left Panel:** Contains `JLabel` and `JTextField` for currency input and the Convert button.  
- **Right Panel:** Contains a JLabel for the conversion result (`convertedShi`) and the logo image.  
- **JDialog:** Displays a scrollable list of all available currencies.  

## Usage
1. Run the `MainDisplay` class.  
2. Enter the base currency, target currency, and amount in the left panel.  
3. Click **Convert** to display the result in the right panel.  
4. Click **Show all Currencies** to view the full list in a separate dialog.  

## Notes
- Conversion depends on an external `Exchange` class for calculations and fetching currencies.  
- The GUI uses absolute positioning, so resizing the main window does not adjust component positions automatically.
