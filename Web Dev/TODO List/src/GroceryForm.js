import { useState } from "react";
import './index.css'; // Import the CSS file

function GroceryForm({ onAddItem }) {
  const [item, setItem] = useState('');
  const [quantity, setQuantity] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    // Check if any of the fields are empty
    if (!item || !quantity) {
      alert('Please fill out all fields');
      return;
    }
   
    const newItem = {
      name: item,
      quantity: parseInt(quantity),
    };
   
    onAddItem(newItem);
    // Reset form fields
    setItem('');
    setQuantity('');
  };

  const handleItemChange = (e) => {
    setItem(e.target.value);
  };

  const handleQuantityChange = (e) => {
    setQuantity(e.target.value);
  };

  return (
    <div className="d-flex justify-content-center">
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <div>
            <label htmlFor="itemInput" className="item-label"><b>Enter item</b></label>
          </div>
          <input
            type="text"
            className="form-control"
            id="itemInput"
            placeholder="Apples"
            value={item}
            onChange={handleItemChange}
          />
        </div>
        <br/>
        <div className="form-group">
          <div>
            <label htmlFor="quantityInput" className="item-label"><b>Enter quantity</b></label>
          </div>
          <input
            type="number"
            className="form-control"
            id="quantityInput"
            placeholder="Enter quantity"
            value={quantity}
            onChange={handleQuantityChange}
          />
        </div>
        <br/>
        <button type="submit" className="btn btn-primary">Add Item</button>
      </form>
    </div>
  );
}

export default GroceryForm;
