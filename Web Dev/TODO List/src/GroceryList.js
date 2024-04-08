import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faTrashAlt, faEdit, faCheck, faTimes } from '@fortawesome/free-solid-svg-icons'; // Include additional icons
import { useState, useEffect } from 'react';

function GroceryList({ item: { name: initialName, quantity: initialQuantity, checked }, onDeleteItem, onEditItem }) {
  const [isChecked, setIsChecked] = useState(checked);
  const [isEditing, setIsEditing] = useState(false);
  const [name, setName] = useState(initialName);
  const [quantity, setQuantity] = useState(initialQuantity);

  useEffect(() => {
    setIsChecked(checked);
  }, [checked]);

  const handleCheck = () => {
    setIsChecked(!isChecked);
  };

  const handleDelete = () => {
    onDeleteItem(name);
  };

  const handleEdit = () => {
    setIsEditing(true);
  };

  const handleSave = () => {
    setIsEditing(false);
    onEditItem(name, quantity);
  };

  const handleCancel = () => {
    setIsEditing(false);
    setName(initialName);
    setQuantity(initialQuantity);
  };

  return (
    <div className='d-flex justify-content-center row'>
      <div className='col'>
        <table className='table table-bordered grocery-table'>
          <thead>
            <tr>
              <th>Item</th>
              <th>Amount</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>
                {isEditing ? (
                  <input
                    type="text"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                  />
                ) : (
                  name
                )}
              </td>
              <td>
                {isEditing ? (
                  <input
                    type="number"
                    value={quantity}
                    onChange={(e) => setQuantity(e.target.value)}
                  />
                ) : (
                  quantity
                )}
              </td>
              <td>
                {isEditing ? (
                  <>
                    <FontAwesomeIcon
                      icon={faCheck}
                      className='mx-2'
                      style={{ color: "#28a745", cursor: "pointer" }}
                      onClick={handleSave}
                    />
                    <FontAwesomeIcon
                      icon={faTimes}
                      className='mx-2'
                      style={{ color: "#dc3545", cursor: "pointer" }}
                      onClick={handleCancel}
                    />
                  </>
                ) : (
                  <>
                    <FontAwesomeIcon
                      icon={faEdit}
                      className='mx-2'
                      style={{ color: "#007bff", cursor: "pointer" }}
                      onClick={handleEdit}
                    />
                    <FontAwesomeIcon
                      icon={faTrashAlt}
                      className='mx-2'
                      style={{ color: "#ff0000", cursor: "pointer" }}
                      onClick={handleDelete}
                    />
                  </>
                )}
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default GroceryList;
