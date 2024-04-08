import React, { useState } from 'react';
import './global.css';
import Header from './Header';
import GroceryForm from './GroceryForm'; // Renamed import
import GroceryList from './GroceryList'; // Renamed import

function App() {
  const [exercises, setExercises] = useState([]);

  const handleAddExercise = (newExercise) => {
    // Update state to add the new exercise
    setExercises([...exercises, newExercise]);
  };

  const handleDeleteExercise = (index) => {
    setExercises(exercises.filter((exercise, idx) => idx !== index));
  };

  const handleClearExercises = () => {
    setExercises([]);
  };

  const handleEditExercise = (index, updatedExercise) => {
    setExercises(
      exercises.map((exercise, idx) =>
        idx === index ? { ...exercise, ...updatedExercise } : exercise
      )
    );
  };

  return (
    <div>
      <div className="row">
        <div className='col'></div>
        <div className='col'>
          <Header></Header>
          <br/>
          <br/>
          <br/>
          {/* Pass handleAddExercise, handleClearExercises, and handleEditExercise as props to GroceryForm */}
          <GroceryForm
            onAddItem={handleAddExercise}
            onClear={handleClearExercises}
            onEditItem={handleEditExercise}
          ></GroceryForm>
          <br/>
          {/* Map each exercise to a GroceryList component */}
          {exercises.map((exercise, index) => (
            <GroceryList
              key={index}
              item={exercise}
              onDeleteItem={() => handleDeleteExercise(index)}
              onEditItem={(updatedExercise) => handleEditExercise(index, updatedExercise)}
            ></GroceryList>
          ))}
        </div>
        <div className='col'></div>
      </div>
    </div>
  );
}

export default App;
